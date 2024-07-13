CREATE DATABASE IF NOT EXISTS seatExample;
USE seatExample;

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS seatingchart;

CREATE TABLE seatingchart (
  floor_seat_seq INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  floor_no INT NOT NULL,
  seat_no INT NOT NULL
);

INSERT INTO seatingchart (floor_no, seat_no) VALUES (1, 1);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (1, 2);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (1, 3);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (1, 4);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (2, 1);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (2, 2);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (2, 3);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (2, 4);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (3, 1);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (3, 2);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (3, 3);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (3, 4);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (4, 1);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (4, 2);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (4, 3);
INSERT INTO seatingchart (floor_no, seat_no) VALUES (4, 4);

CREATE TABLE employee (
  emp_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL,
  email VARCHAR(40) NOT NULL,
  floor_seat_seq INT,
  CONSTRAINT employee_floor_seat_seq_fk FOREIGN KEY (floor_seat_seq) REFERENCES seatingchart(floor_seat_seq)
);

-- Set AUTO_INCREMENT start value
ALTER TABLE employee AUTO_INCREMENT = 10001;

INSERT INTO employee (name, email, floor_seat_seq) VALUES ('蔡小姐', 'tsai@gmail.com', 1);
INSERT INTO employee (name, email, floor_seat_seq) VALUES ('邱小姐', 'chiu@gmail.com', 4);
INSERT INTO employee (name, email, floor_seat_seq) VALUES ('李先生', 'li@gmail.com', null);
INSERT INTO employee (name, email, floor_seat_seq) VALUES ('王先生', 'wang@gmail.com', 6);
INSERT INTO employee (name, email, floor_seat_seq) VALUES ('葉先生', 'ye@gmail.com', null);
INSERT INTO employee (name, email, floor_seat_seq) VALUES ('林小姐', 'lin@gmail.com', null);
