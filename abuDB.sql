
CREATE TABLE IF NOT EXISTS product (
  `product_id` int auto_increment primary key,
  `product_name` varchar(20) DEFAULT NULL,
  `price_per_product` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `date_of_entry` varchar(20) DEFAULT NULL,
  `date_of_entry_notime` varchar(20) DEFAULT NULL
) ;

CREATE TABLE IF NOT EXISTS daily_sales (
  `product_id` int auto_increment primary key,
  `product_name` varchar(20) DEFAULT NULL,
  `entry_date` varchar(20) DEFAULT NULL,
  `sold_quantity` int DEFAULT NULL,
  `sold_price` int DEFAULT NULL,
  `sold_date` varchar(20) DEFAULT NULL,
  `sold_datenotime` varchar(20) DEFAULT NULL,
  `price_per_product` int DEFAULT NULL,
  `entry_quantity` int DEFAULT NULL,
  `remaining_quantity` int DEFAULT NULL
) ;

CREATE TABLE IF NOT EXISTS product_details (
  `product_id` int auto_increment primary key,
  `product_name` varchar(20) DEFAULT NULL,
  `entry_date` varchar(20) DEFAULT NULL,
  `entry_quantity` int DEFAULT NULL,
  `remaining_quantity` int DEFAULT NULL,
  `price_per_product` int DEFAULT NULL

) ;

CREATE TABLE IF NOT EXISTS userlogin (
  `user_id` int auto_increment primary key,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL

) ;

INSERT INTO userlogin (username,password) VALUES("abustore","bigman");

