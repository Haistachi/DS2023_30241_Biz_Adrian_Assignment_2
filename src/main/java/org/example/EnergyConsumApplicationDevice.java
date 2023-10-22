package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.*;

@SpringBootApplication
public class EnergyConsumApplication {

	public static String EXCHANGE_NAME ="Senzor";
	public static String QUEUE_GENERIC_NAME ="SenzorQueue";
	public final static String QUEUE_SPECIFIC_NAME ="SenzorQueue1";
	public static String ROUTING_KEY ="ROUTING_KEY";
	@Bean
	public TopicExchange appExchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	public Queue appQueueGeneric() {
		return new Queue(QUEUE_GENERIC_NAME);
	}

	@Bean
	public Queue appQueueSpecific() {
		return new Queue(QUEUE_SPECIFIC_NAME);
	}

	@Bean
	public Binding declareBindingGeneric() {
		return BindingBuilder.bind(appQueueGeneric()).to(appExchange()).with(ROUTING_KEY);
	}

	@Bean
	public Binding declareBindingSpecific() {
		return BindingBuilder.bind(appQueueSpecific()).to(appExchange()).with(ROUTING_KEY);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final var rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(EnergyConsumApplication.class);
		Connection connection = null;
		Statement statement = null;
		try {
			logger.debug("Creating database if not exist...");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "A.Hunu2000");
			statement = connection.createStatement();
			statement.executeQuery("SELECT count(*) FROM pg_database WHERE datname = 'Assignment1'");
			ResultSet resultSet = statement.getResultSet();
			resultSet.next();
			int count = resultSet.getInt(1);

			if (count <= 0) {
				statement.executeUpdate("CREATE DATABASE Assignment1");
				logger.debug("Database created.");
			} else {
				logger.debug("Database already exist.");
			}
		} catch (SQLException e) {
			logger.error(e.toString());
		} finally {
			try {
				if (statement != null) {
					statement.close();
					logger.debug("Closed Statement.");
				}
				if (connection != null) {
					logger.debug("Closed Connection.");
					connection.close();
				}
			} catch (SQLException e) {
				logger.error(e.toString());
			}
		}
		SpringApplication.run(EnergyConsumApplication.class, args);
	}
}
