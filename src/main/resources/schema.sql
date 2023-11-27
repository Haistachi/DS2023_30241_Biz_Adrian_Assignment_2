--
-- TOC entry 209 (class 1259 OID 16482)
-- Name: active; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.measurement (
                                id SERIAL PRIMARY KEY,
                                id_device integer NOT NULL,
                                timest timestamp without time zone NOT NULL,
                                val double precision NOT NULL
);
SELECT setval(PG_GET_SERIAL_SEQUENCE('"measurement"', 'id_measurement'), 24);
ALTER TABLE IF EXISTS public.measurement OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16489)
-- Name: device; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.treshhold (
                                id SERIAL PRIMARY KEY,
                                current double precision NOT NULL,
                                id_device integer NOT NULL,
                                treshhold double precision NOT NULL
);
SELECT setval(PG_GET_SERIAL_SEQUENCE('"treshhold"', 'id_treshhold'), 1);
ALTER TABLE IF EXISTS public.treshhold OWNER TO postgres;