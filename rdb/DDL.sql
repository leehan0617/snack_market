-- DOCKER IMAGE MYSQL LTS
CREATE DATABASE snack_market;
CREATE user 'heron'@'%' IDENTIFIED BY '46463522';
GRANT ALL PRIVILEGES ON snack_market.* TO 'heron'@'%';
FLUSH PRIVILEGES;

CREATE TABLE snack_order (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(50),
    snack VARCHAR(500),
    status VARCHAR(10),
    etc VARCHAR(1000),
    reg_dt DATETIME DEFAULT NOW()
);
