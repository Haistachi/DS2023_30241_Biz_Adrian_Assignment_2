
--
-- TOC entry 209 (class 1259 OID 16482)
-- Name: active; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.active (
                               id bytea NOT NULL,
                               consumption DOUBLE PRECISION NOT NULL,
                               device uuid,
                               "timestamp" character varying(255)
);


ALTER TABLE public.active OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16489)
-- Name: device; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.device (
                               id bytea NOT NULL,
                               address character varying(255),
                               consumption DOUBLE PRECISION NOT NULL,
                               description character varying(255),
                               person uuid
);


ALTER TABLE public.device OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16503)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
                               id bytea NOT NULL,
                               role character varying(255),
                               user_password character varying(255),
                               username character varying(255)
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 3176 (class 2606 OID 16488)
-- Name: active active_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.active
    ADD CONSTRAINT active_pkey PRIMARY KEY (id);


--
-- TOC entry 3178 (class 2606 OID 16495)
-- Name: device device_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.device
    ADD CONSTRAINT device_pkey PRIMARY KEY (id);

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
