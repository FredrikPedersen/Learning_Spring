ALTER TABLE order_line ADD COLUMN product_id BIGINT;
ALTER TABLE order_line ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES product(id);