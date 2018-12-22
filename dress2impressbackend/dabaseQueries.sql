CREATE TABLE `drees2impress`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `image_url` VARCHAR(255) NULL,
  `is_active` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));
  

 CREATE TABLE `drees2impress`.`clothes` (
  `id` INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(255),
	name VARCHAR(255),
	brand VARCHAR(255),
	size VARCHAR(20),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
    price_per_day DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	rented INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_clothes_id PRIMARY KEY (id),
 	CONSTRAINT fk_clothes_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_clothes_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id)	
  );
  
  CREATE TABLE cart_line (
	id NOT NULL AUTO_INCREMENT,
	cart_id int,
	clothes_id int,
	clothes_count int,
	price_per_day DECIMAL(10,2),
        issue_date date,
	no_of_days int,
        return_date date,
        deposite DECIMAL (10,2),
	is_available boolean,
        total_price DECIMAL (10,2),
        CONSTRAINT fk_cartline_cart_id FOREIGN KEY (cart_id ) REFERENCES cart (id),
	CONSTRAINT fk_cartline_clothes_id FOREIGN KEY (clothes_id ) REFERENCES clothes (id),
	CONSTRAINT pk_cartline_id PRIMARY KEY (id)
);