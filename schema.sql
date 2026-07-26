-- ADPS Restaurant Application MySQL Database Schema
CREATE DATABASE IF NOT EXISTS restaurant_db;
USE restaurant_db;

-- 1. User Table
CREATE TABLE IF NOT EXISTS user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone BIGINT,
    password VARCHAR(255) NOT NULL
);

-- 2. Chef Table
CREATE TABLE IF NOT EXISTS chef (
    chef_id INT AUTO_INCREMENT PRIMARY KEY,
    chef_name VARCHAR(100) NOT NULL,
    ch_email VARCHAR(100) UNIQUE NOT NULL,
    phone_no BIGINT,
    ch_pswd VARCHAR(255) NOT NULL
);

-- 3. Menu Item Table
CREATE TABLE IF NOT EXISTS menu_item (
    menu_id INT AUTO_INCREMENT PRIMARY KEY,
    food_name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    description TEXT,
    price DOUBLE NOT NULL,
    image VARCHAR(255),
    is_available BOOLEAN DEFAULT TRUE
);

-- 4. Restaurant Table
CREATE TABLE IF NOT EXISTS restaurant_table (
    t_id INT AUTO_INCREMENT PRIMARY KEY,
    table_number INT UNIQUE NOT NULL,
    capacity INT NOT NULL,
    status VARCHAR(20) DEFAULT 'AVAILABLE'
);

-- 5. Table Reserve Table
CREATE TABLE IF NOT EXISTS reserve (
    reserve_id INT AUTO_INCREMENT PRIMARY KEY,
    c_id INT,
    t_id INT,
    reserved_date DATE NOT NULL,
    reserved_time TIME NOT NULL,
    guests INT DEFAULT 1,
    status VARCHAR(20) DEFAULT 'PENDING',
    FOREIGN KEY (c_id) REFERENCES user(user_id) ON DELETE CASCADE,
    FOREIGN KEY (t_id) REFERENCES restaurant_table(t_id) ON DELETE CASCADE
);

-- 6. Orders Table
CREATE TABLE IF NOT EXISTS orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    reserve_id INT,
    chief_id INT,
    subtotal DOUBLE DEFAULT 0.0,
    gst DOUBLE DEFAULT 0.0,
    total_amt DOUBLE DEFAULT 0.0,
    order_date DATE,
    order_status VARCHAR(20) DEFAULT 'PENDING',
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
);

-- 7. Order Item Table
CREATE TABLE IF NOT EXISTS order_item (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    menu_id INT,
    price DOUBLE NOT NULL,
    quantity INT DEFAULT 1,
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
    FOREIGN KEY (menu_id) REFERENCES menu_item(menu_id) ON DELETE CASCADE
);

-- 8. Cart Table
CREATE TABLE IF NOT EXISTS cart (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    menu_id INT,
    quantity INT DEFAULT 1,
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    FOREIGN KEY (menu_id) REFERENCES menu_item(menu_id) ON DELETE CASCADE
);

-- Sample Data Ingestion
INSERT INTO chef (chef_name, ch_email, phone_no, ch_pswd) 
VALUES ('Head Chef Gordon', 'chef@restaurant.com', 9876543210, 'chef123')
ON DUPLICATE KEY UPDATE chef_name=chef_name;

-- Delicious Menu Items & Recipes
INSERT INTO menu_item (food_name, category, description, price, image, is_available) VALUES 
('Crispy Paneer 65', 'Starters', 'Crispy cottage cheese cubes tossed in spicy South Indian curry leaf & chili temperate.', 240.0, 'https://images.unsplash.com/photo-1567188040759-fb8a883dc6d8?auto=format&fit=crop&w=600&q=80', TRUE),
('Chicken Tandoori Tikka', 'Starters', 'Tender chicken chunks marinated in yogurt, Kashmiri red chili & smoked in clay oven.', 320.0, 'https://images.unsplash.com/photo-1599487488170-d11ec9c172f0?auto=format&fit=crop&w=600&q=80', TRUE),
('Crispy Veg Spring Rolls', 'Starters', 'Golden rolled pastry stuffed with crunchy wok-tossed vegetables & sweet chili dip.', 210.0, 'https://images.unsplash.com/photo-1544025162-d76694265947?auto=format&fit=crop&w=600&q=80', TRUE),
('Paneer Butter Masala', 'Main Course', 'Soft cottage cheese cubes simmering in rich velvet tomato, cashew & butter gravy.', 280.0, 'https://images.unsplash.com/photo-1631452180519-c014fe946bc7?auto=format&fit=crop&w=600&q=80', TRUE),
('Hyderabadi Dum Chicken Biryani', 'Main Course', 'Fragrant long-grain basmati rice layered with slow-cooked spiced chicken & saffron.', 360.0, 'https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?auto=format&fit=crop&w=600&q=80', TRUE),
('Dal Makhani Supreme', 'Main Course', 'Slow-cooked black lentils simmered overnight with cream, butter & aromatic spices.', 230.0, 'https://images.unsplash.com/photo-1546833999-b9f581a1996d?auto=format&fit=crop&w=600&q=80', TRUE),
('Butter Chicken Delicacy', 'Main Course', 'Charcoal-grilled tandoori chicken simmered in rich silky tomato cream gravy.', 370.0, 'https://images.unsplash.com/photo-1588166524941-3bf61a9c41db?auto=format&fit=crop&w=600&q=80', TRUE),
('Mutton Rogan Josh', 'Main Course', 'Tender lamb morsels cooked in traditional Kashmiri red chili & aromatic fennel sauce.', 420.0, 'https://images.unsplash.com/photo-1545247181-516773cae754?auto=format&fit=crop&w=600&q=80', TRUE),
('Butter Garlic Naan', 'Breads', 'Freshly baked tandoori naan brushed with roasted garlic & melted butter.', 60.0, 'https://images.unsplash.com/photo-1601050690597-df0568f70950?auto=format&fit=crop&w=600&q=80', TRUE),
('Cheese Stuffed Kulcha', 'Breads', 'Fluffy Indian bread stuffed with spiced melted cheese & coriander.', 80.0, 'https://images.unsplash.com/photo-1626074353765-517a681e40be?auto=format&fit=crop&w=600&q=80', TRUE),
('Sizzling Chocolate Brownie', 'Desserts', 'Hot fudgy chocolate brownie topped with vanilla ice cream & hot fudge sauce.', 180.0, 'https://images.unsplash.com/photo-1606313564200-e75d5e30476c?auto=format&fit=crop&w=600&q=80', TRUE),
('Gulab Jamun with Rabri', 'Desserts', 'Warm golden milk dumplings soaked in cardamom syrup paired with thick rabri.', 140.0, 'https://images.unsplash.com/photo-1589301760014-d929f3979dbc?auto=format&fit=crop&w=600&q=80', TRUE),
('Mango Lassi Delight', 'Beverages', 'Creamy chilled yogurt smoothie blended with Alphonso mango pulp & cardamom.', 110.0, 'https://images.unsplash.com/photo-1553530666-ba11a7da3888?auto=format&fit=crop&w=600&q=80', TRUE),
('Fresh Mint Mojito', 'Beverages', 'Refreshing virgin cocktail crushed with fresh mint leaves, lime juice & sparkling soda.', 130.0, 'https://images.unsplash.com/photo-1513558161293-cdaf765ed2fd?auto=format&fit=crop&w=600&q=80', TRUE)
ON DUPLICATE KEY UPDATE food_name=food_name;

INSERT INTO restaurant_table (table_number, capacity, status) VALUES 
(1, 2, 'AVAILABLE'),
(2, 4, 'AVAILABLE'),
(3, 6, 'AVAILABLE'),
(4, 8, 'AVAILABLE')
ON DUPLICATE KEY UPDATE table_number=table_number;
