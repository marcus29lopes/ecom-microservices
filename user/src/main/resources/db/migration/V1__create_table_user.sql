CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       user_name VARCHAR(100) NOT NULL,
                       user_email VARCHAR(100) NOT NULL UNIQUE,
                       user_password VARCHAR(255) NOT NULL,
                       user_role VARCHAR(20) NOT NULL,
                       user_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE addresses (
                           address_id SERIAL PRIMARY KEY,
                           user_id BIGINT NOT NULL,
                           street VARCHAR(255) NOT NULL,
                           city VARCHAR(100) NOT NULL,
                           state VARCHAR(50) NOT NULL,
                           zip_code VARCHAR(20) NOT NULL,
                           country VARCHAR(50) NOT NULL,
                           FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);
