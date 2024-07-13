CREATE DATABASE IF NOT EXISTS seatExample;
USE seatExample;

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS seatingchart;

CREATE TABLE SeatingChart (
  floor_seat_seq INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  floor_no VARCHAR(10) NOT NULL,
  seat_no VARCHAR(10) NOT NULL
);

INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('1樓', '座位1');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('1樓', '座位2');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('1樓', '座位3');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('1樓', '座位4');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('2樓', '座位1');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('2樓', '座位2');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('2樓', '座位3');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('2樓', '座位4');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('3樓', '座位1');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('3樓', '座位2');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('3樓', '座位3');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('3樓', '座位4');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('4樓', '座位1');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('4樓', '座位2');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('4樓', '座位3');
INSERT INTO SeatingChart (floor_no, seat_no) VALUES ('4樓', '座位4');

CREATE TABLE Employee (
  emp_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL,
  email VARCHAR(40) NOT NULL,
  floor_seat_seq INT,
  CONSTRAINT employee_floor_seat_seq_fk FOREIGN KEY (floor_seat_seq) REFERENCES SeatingChart(floor_seat_seq)
);

INSERT INTO Employee (name, email, floor_seat_seq) VALUES ('蔡小姐', 'tsai@gmail.com', 1);
INSERT INTO Employee (name, email, floor_seat_seq) VALUES ('邱小姐', 'chiu@gmail.com', 4);
INSERT INTO Employee (name, email, floor_seat_seq) VALUES ('李先生', 'li@gmail.com', null);
INSERT INTO Employee (name, email, floor_seat_seq) VALUES ('王先生', 'wang@gmail.com', 6);
INSERT INTO Employee (name, email, floor_seat_seq) VALUES ('葉先生', 'ye@gmail.com', null);
INSERT INTO Employee (name, email, floor_seat_seq) VALUES ('林小姐', 'lin@gmail.com', null);
