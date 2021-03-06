CREATE TABLE course(
    id INT NOT NULL AUTO_INCREMENT,
    course_title VARCHAR(100)
    course_code VARCHAR(7),
    PRIMARY KEY("id")
);

CREATE TABLE user(
    id INT NOT NULL AUTO_INCREMENT,
    name varchar(100),
    PRIMARY KEY("id")
);

CREATE TABLE enrollment(
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    PRIMARY KEY("id")
);
