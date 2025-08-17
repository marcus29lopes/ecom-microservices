CREATE TABLE cart (
                      cart_id SERIAL PRIMARY KEY,
                      user_id INT NOT NULL,
                      cart_total NUMERIC(10,2) DEFAULT 0
);

CREATE TABLE cart_item (
                           cart_item_id SERIAL PRIMARY KEY,
                           cart_id INT NOT NULL,
                           product_id INT NOT NULL,
                           cart_item_quantity INT NOT NULL,
                           cart_item_price NUMERIC(10,2) NOT NULL
);
