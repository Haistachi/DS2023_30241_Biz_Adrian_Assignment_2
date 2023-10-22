
--
-- TOC entry 212 (class 1259 OID 16503)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
                               id int NOT NULL,
                               role character varying(255),
                               user_password character varying(255),
                               username character varying(255)
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 3182 (class 2606 OID 16509)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);

-- Completed on 2022-12-17 20:49:15

--
-- PostgreSQL database dump complete
--
