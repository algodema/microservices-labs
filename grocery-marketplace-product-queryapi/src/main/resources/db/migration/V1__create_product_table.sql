-- Create tables for all related entities
CREATE TABLE category (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE price (
    id INT PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL
);

CREATE TABLE supplier (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE rating (
    id INT PRIMARY KEY,
    score INT NOT NULL CHECK (score BETWEEN 1 AND 5)
);

CREATE TABLE manufacturer (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE warranty (
    id INT PRIMARY KEY,
    duration_months INT NOT NULL
);

CREATE TABLE tag (
    id INT PRIMARY KEY,
    tag_name VARCHAR(100) NOT NULL
);

CREATE TABLE promotion (
    id INT PRIMARY KEY,
    promo_code VARCHAR(50) NOT NULL,
    discount DECIMAL(5, 2) NOT NULL
);

-- Create the product table with foreign keys
CREATE TABLE product (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id INT,
    price_id INT,
    supplier_id INT,
    rating_id INT,
    manufacturer_id INT,
    warranty_id INT,
    tag_id INT,
    promotion_id INT,
    description TEXT,
    FOREIGN KEY (category_id) REFERENCES category(id),
    FOREIGN KEY (price_id) REFERENCES price(id),
    FOREIGN KEY (supplier_id) REFERENCES supplier(id),
    FOREIGN KEY (rating_id) REFERENCES rating(id),
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(id),
    FOREIGN KEY (warranty_id) REFERENCES warranty(id),
    FOREIGN KEY (tag_id) REFERENCES tag(id),
    FOREIGN KEY (promotion_id) REFERENCES promotion(id)
);

-- Sample Data Insertion for related tables

-- Insert categories
INSERT INTO category (id, name) VALUES (1, 'Electronics');
INSERT INTO category (id, name) VALUES (2, 'Furniture');
INSERT INTO category (id, name) VALUES (3, 'Clothing');

-- Insert prices
INSERT INTO price (id, amount) VALUES (1, 199.99);
INSERT INTO price (id, amount) VALUES (2, 79.99);
INSERT INTO price (id, amount) VALUES (3, 49.99);

-- Insert suppliers
INSERT INTO supplier (id, name) VALUES (1, 'Best Electronics Co.');
INSERT INTO supplier (id, name) VALUES (2, 'Home Furnishings Inc.');
INSERT INTO supplier (id, name) VALUES (3, 'Apparel Mart');

-- Insert ratings
INSERT INTO rating (id, score) VALUES (1, 5);
INSERT INTO rating (id, score) VALUES (2, 4);
INSERT INTO rating (id, score) VALUES (3, 3);

-- Insert manufacturers
INSERT INTO manufacturer (id, name) VALUES (1, 'Samsung');
INSERT INTO manufacturer (id, name) VALUES (2, 'Ikea');
INSERT INTO manufacturer (id, name) VALUES (3, 'Nike');

-- Insert warranties
INSERT INTO warranty (id, duration_months) VALUES (1, 24);
INSERT INTO warranty (id, duration_months) VALUES (2, 12);
INSERT INTO warranty (id, duration_months) VALUES (3, 36);

-- Insert tags
INSERT INTO tag (id, tag_name) VALUES (1, 'Best Seller');
INSERT INTO tag (id, tag_name) VALUES (2, 'Discounted');
INSERT INTO tag (id, tag_name) VALUES (3, 'New Arrival');

-- Insert promotions
INSERT INTO promotion (id, promo_code, discount) VALUES (1, 'SALE20', 20.00);
INSERT INTO promotion (id, promo_code, discount) VALUES (2, 'SUMMER15', 15.00);
INSERT INTO promotion (id, promo_code, discount) VALUES (3, 'NEWYEAR10', 10.00);

-- Insert sample products with foreign key relationships
INSERT INTO product (id, name, category_id, price_id, supplier_id, rating_id, manufacturer_id, warranty_id, tag_id, promotion_id, description)
VALUES (1, 'Samsung Smart TV', 1, 1, 1, 1, 1, 1, 1, 1, 'A high-definition smart TV with 4K resolution and smart features.');
INSERT INTO product (id, name, category_id, price_id, supplier_id, rating_id, manufacturer_id, warranty_id, tag_id, promotion_id, description)
VALUES (2, 'Ikea Sofa', 2, 2, 2, 2, 2, 2, 2, 2, 'Comfortable 3-seater sofa perfect for living rooms.');
INSERT INTO product (id, name, category_id, price_id, supplier_id, rating_id, manufacturer_id, warranty_id, tag_id, promotion_id, description)
VALUES (3, 'Nike Running Shoes', 3, 3, 3, 3, 3, 3, 3, 3, 'Durable and comfortable running shoes for athletes.');
