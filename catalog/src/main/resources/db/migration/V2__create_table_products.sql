CREATE TABLE products (
                          product_id SERIAL PRIMARY KEY,
                          product_name VARCHAR(255) NOT NULL,
                          product_description TEXT,
                          product_price NUMERIC(10, 2) NOT NULL,
                          product_quantity INT NOT NULL DEFAULT 0,
                          category_id INT NOT NULL,
                          CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES categories(category_id)
);
