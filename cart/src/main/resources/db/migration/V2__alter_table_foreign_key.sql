ALTER TABLE cart_item
    ADD CONSTRAINT fk_cart
        FOREIGN KEY (cart_id) REFERENCES cart(cart_id)
            ON DELETE CASCADE;