CREATE TABLE enrollment_management_hibernate.course(
    id INT NOT NULL AUTO_INCREMENT,
    course_title VARCHAR(100),
    course_code VARCHAR(7),
    PRIMARY KEY(id)
);

CREATE TABLE enrollment_management_hibernate.user(
    id INT NOT NULL AUTO_INCREMENT,
    name varchar(100),
    PRIMARY KEY(id)
);

CREATE TABLE enrollment_management_hibernate.enrollment(
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    PRIMARY KEY(id)
);
