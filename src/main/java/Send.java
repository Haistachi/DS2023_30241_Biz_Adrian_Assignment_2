import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Send {

    private final static String QUEUE_NAME = "csvqueue1";

    private static Integer index = 0;


    public static List<Double> readCSV() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("E:\\Facultate\\UTCN\\An4\\DS\\CSV_Reader\\src\\main\\resources\\sensor.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Double> readValues = new ArrayList<>();
        while (sc.hasNext()) {
            readValues.add(sc.nextDouble());
        }
        sc.close();
        return readValues;
    }

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqps://bxjxjwnv:OO07BLJPPe2L3Y7O17WoZXgl1KgmEAgv@goose.rmq2.cloudamqp.com/bxjxjwnv");

        List<Double> readValues = readCSV();
        Boolean ok=true;

        while(ok){

            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {

                for (Integer i=0;i<readValues.size();i++ ) {

                    Message msg = new Message();
                    msg.setReadingDate(new Date());
                    msg.setIdDevice(Integer.valueOf(argv[0]));
                    msg.setValue(readValues.get(i));
                    i++;

                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String json = ow.writeValueAsString(msg);

                    channel.queueDeclare(QUEUE_NAME, true, false, false, null);
                    channel.basicPublish("", QUEUE_NAME, null, json.getBytes(StandardCharsets.UTF_8));
                    System.out.println(msg);
                    Thread.sleep(60000);
                }
                ok=false;
            }
        }
    }

}