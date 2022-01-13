CREATE TABLE order_line (
    id SERIAL8 NOT NULL PRIMARY KEY,
    quantity_ordered INTEGER,
    order_header_id BIGINT,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    constraint fk_order_header_id FOREIGN KEY (order_header_id) REFERENCES order_header(id)
);