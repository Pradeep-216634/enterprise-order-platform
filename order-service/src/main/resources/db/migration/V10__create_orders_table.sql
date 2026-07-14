CREATE TABLE orders (

    id BIGSERIAL PRIMARY KEY,

    customer_name VARCHAR(255) NOT NULL,

    product_name VARCHAR(255) NOT NULL,

    quantity INTEGER NOT NULL,

    amount NUMERIC(19,2) NOT NULL,

    status VARCHAR(50) NOT NULL,

    created_at TIMESTAMP NOT NULL,

    created_by VARCHAR(255),

    updated_at TIMESTAMP,

    updated_by VARCHAR(255),

    version BIGINT NOT NULL DEFAULT 0
);