--
-- TOC entry 209 (class 1259 OID 16482)
-- Name: active; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.active (
                                id SERIAL PRIMARY KEY,
                               consumption DOUBLE PRECISION NOT NULL,
                               device int,
                               "timestamp" character varying(255)
);
SELECT setval('active_id_seq', 24);
ALTER TABLE IF EXISTS public.active OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16489)
-- Name: device; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.device (
                                id SERIAL PRIMARY KEY,
                               address character varying(255),
                               consumption DOUBLE PRECISION NOT NULL,
                               description character varying(255),
                               person int
);
SELECT setval('device_id_seq', 2);
ALTER TABLE IF EXISTS public.device OWNER TO postgres;