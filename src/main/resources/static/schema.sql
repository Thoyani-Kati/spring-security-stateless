Create Table IF NOT EXISTS 'spring'.'users'(
    'id' INT PRIMARY KEY AUTO_INCREMENT,
    'username' CHAR(45) NOT NULL,
    'password' CHAR(45) NOT NULL,
    'enabled' INT NOT NULL
);

CREATE TABLE IF NOT EXISTS 'spring'.'authorities'(
    `id` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(45) FOREIGN KEY REFERENCES users('username'),
`authority` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`)
)