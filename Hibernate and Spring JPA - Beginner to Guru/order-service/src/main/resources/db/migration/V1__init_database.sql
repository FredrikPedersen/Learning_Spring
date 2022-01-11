DROP TABLE IF EXISTS order_header CASCADE;

CREATE TABLE order_header (
    id       SERIAL8 NOT NULL PRIMARY KEY,
    customer VARCHAR(255)
);
