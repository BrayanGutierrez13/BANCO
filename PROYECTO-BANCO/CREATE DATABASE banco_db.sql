-- Database: banco_db

-- DROP DATABASE IF EXISTS banco_db;

CREATE DATABASE banco_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'es_CO.UTF-8'
    LC_CTYPE = 'es_CO.UTF-8'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;