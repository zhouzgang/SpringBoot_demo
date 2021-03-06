DROP TABLE user if EXISTS;
CREATE TABLE user (
   id bigint generated BY DEFAULT AS IDENTITY,
   username VARCHAR(40),
   name VARCHAR(20),
   age INT(3),
   balance DECIMAL(10,2),
   PRIMARY KEY (id)
);

DROP TABLE course if EXISTS;
CREATE TABLE course (
  id bigint generated BY DEFAULT AS IDENTITY ,
  name VARCHAR (100),
  PRIMARY KEY (id)
);

DROP TABLE user_course if EXISTS ;
CREATE TABLE user_course (
  id bigint generated BY DEFAULT AS IDENTITY ,
  user_id bigint,
  course_id bigint,
  grade INT
);