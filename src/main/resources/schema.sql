/*
--
-- TOC entry 209 (class 1259 OID 16482)
-- Name: active; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.active (
                               id int NOT NULL,
                               consumption DOUBLE PRECISION NOT NULL,
                               device int,
                               "timestamp" character varying(255)
);

ALTER TABLE IF EXISTS public.active OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16489)
-- Name: device; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.device (
                               id int NOT NULL,
                               address character varying(255),
                               consumption DOUBLE PRECISION NOT NULL,
                               description character varying(255),
                               person int
);

ALTER TABLE IF EXISTS public.device OWNER TO postgres;

--
-- TOC entry 3176 (class 2606 OID 16488)
-- Name: active active_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.active
    DROP CONSTRAINT IF EXISTS active_pkey;
ALTER TABLE ONLY public.active
    ADD CONSTRAINT active_pkey PRIMARY KEY (id);


--
-- TOC entry 3178 (class 2606 OID 16495)
-- Name: device device_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.device
    DROP CONSTRAINT IF EXISTS device_pkey;
ALTER TABLE ONLY public.device
    ADD CONSTRAINT device_pkey PRIMARY KEY (id);

-- Completed on 2022-12-17 20:49:15

--
-- PostgreSQL database dump complete
--
*/