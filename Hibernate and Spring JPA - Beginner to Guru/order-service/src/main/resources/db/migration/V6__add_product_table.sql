CREATE TABLe product (
    id                 SERIAL8 NOT NULL PRIMARY KEY,
    description        VARCHAR(100),
    product_status     VARCHAR(20),
    created_date       TIMESTAMP,
    last_modified_date TIMESTAMP
);