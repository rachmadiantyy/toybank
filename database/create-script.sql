-- Table: public.account_transaction

-- DROP TABLE public.account_transaction;

CREATE TABLE IF NOT EXISTS public.account_transaction
(
    id integer NOT NULL,
    account_id integer,
    amount numeric(19,2),
    date date,
    description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT account_transaction_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.account_transaction
    OWNER to postgres;
