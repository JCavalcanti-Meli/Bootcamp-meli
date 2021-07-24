INSERT INTO DENTISTS(id, name, last_name, address, dni, birth_date, phone, email, code_mp) VALUES(1, 'Jonathan', 'Cavalcanti', 'Address','347387', '1993-07-04', 992919394, 'jow@meli.com', 03563);
INSERT INTO DENTISTS(id, name, last_name, address, dni, birth_date, phone, email, code_mp) VALUES(2, 'Cristiano', 'Ronaldo', 'Address','987654', '1996-07-04', 992919394, 'jow@meli.com', 2036);
INSERT INTO DENTISTS(id, name, last_name, address, dni, birth_date, phone, email, code_mp) VALUES(3, 'Lionel', 'Messi', 'Address','987654', '1996-07-04', 992919394, 'jow@meli.com', 2036);
INSERT INTO DENTISTS(id, name, last_name, address, dni, birth_date, phone, email, code_mp) VALUES(4, 'Denilson', 'Kanti', 'Address','347387', '1993-07-04', 992919394, 'jow@meli.com', 03563);
INSERT INTO DENTISTS(id, name, last_name, address, dni, birth_date, phone, email, code_mp) VALUES(5, 'Dodo', 'Naldo', 'Address','987654', '1996-07-04', 992919394, 'jow@meli.com', 2036);
INSERT INTO DENTISTS(id, name, last_name, address, dni, birth_date, phone, email, code_mp) VALUES(6, 'Dechamps', 'Essi', 'Address','987654', '1996-07-04', 992919394, 'jow@meli.com', 2036);

INSERT INTO PATIENTS(id, name, last_name, address, dni, birth_date, phone, email) VALUES(1, 'Patrick', 'Evra', 'Address','347387', '1993-07-04', 992919394, 'jow@meli.com');
INSERT INTO PATIENTS(id, name, last_name, address, dni, birth_date, phone, email) VALUES(2, 'Platini', 'Michael', 'Address','347387', '1993-07-04', 992919394, 'jow@meli.com');
INSERT INTO PATIENTS(id, name, last_name, address, dni, birth_date, phone, email) VALUES(3, 'Pauleta', 'Postigua', 'Address','987654', '1996-07-04', 992919394, 'jow@meli.com');
INSERT INTO PATIENTS(id, name, last_name, address, dni, birth_date, phone, email) VALUES(4, 'Portsmal', 'Evra', 'Address','347387', '1993-07-04', 992919394, 'jow@meli.com');
INSERT INTO PATIENTS(id, name, last_name, address, dni, birth_date, phone, email) VALUES(5, 'Polaco', 'Michael', 'Address','347387', '1993-07-04', 992919394, 'jow@meli.com');
INSERT INTO PATIENTS(id, name, last_name, address, dni, birth_date, phone, email) VALUES(6, 'Podolski', 'Postigua', 'Address','987654', '1996-07-04', 992919394, 'jow@meli.com');

INSERT INTO TURN_STATUS(id, name, description) VALUES(1, 'CONCLUIDO', 'CONCLUIDO');
INSERT INTO TURN_STATUS(id, name, description) VALUES(2, 'CANCELADO', 'CANCELADO');
INSERT INTO TURN_STATUS(id, name, description) VALUES(3, 'PENDENTE', 'PENDENTE');


INSERT INTO DIARYS(ID, START_TIME, ENDING_TIME, DENTIST_ID) VALUES (1, '2021-01-01T10:00:00', '2021-01-01T10:30:00', 1);
INSERT INTO DIARYS(ID, START_TIME, ENDING_TIME, DENTIST_ID) VALUES (2, '2021-01-01T11:00:00', '2021-01-01T11:30:00', 1);
INSERT INTO DIARYS(ID, START_TIME, ENDING_TIME, DENTIST_ID) VALUES (3, '2021-01-01T12:00:00', '2021-01-01T12:30:00', 3);
INSERT INTO DIARYS(ID, START_TIME, ENDING_TIME, DENTIST_ID) VALUES (4, '2021-01-01T13:00:00', '2021-01-01T13:30:00', 4);
INSERT INTO DIARYS(ID, START_TIME, ENDING_TIME, DENTIST_ID) VALUES (5, '2021-01-01T14:00:00', '2021-01-01T14:30:00', 5);
INSERT INTO DIARYS(ID, START_TIME, ENDING_TIME, DENTIST_ID) VALUES (6, '2021-01-02T15:00:00', '2021-01-02T15:30:00', 6);

INSERT INTO TURNS(id, day, diary_id, patient_id, turn_status_id) VALUES(1, '2021-01-01', 1, 1, 1);
INSERT INTO TURNS(id, day, diary_id, patient_id, turn_status_id) VALUES(2, '2021-01-01', 2, 2, 2);
INSERT INTO TURNS(id, day, diary_id, patient_id, turn_status_id) VALUES(3, '2021-01-01', 3, 3, 3);
INSERT INTO TURNS(id, day, diary_id, patient_id, turn_status_id) VALUES(4, '2021-01-01', 4, 4, 1);
INSERT INTO TURNS(id, day, diary_id, patient_id, turn_status_id) VALUES(5, '2021-01-01', 5, 5, 2);
INSERT INTO TURNS(id, day, diary_id, patient_id, turn_status_id) VALUES(6, '2021-01-02', 6, 6, 3);

INSERT INTO DENTISTS_DIARYS VALUES(1, 1);
INSERT INTO DENTISTS_DIARYS VALUES(2, 2);
INSERT INTO DENTISTS_DIARYS VALUES(3, 3);
INSERT INTO DENTISTS_DIARYS VALUES(4, 4);
INSERT INTO DENTISTS_DIARYS VALUES(5, 5);
INSERT INTO DENTISTS_DIARYS VALUES(6, 6);

INSERT INTO DIARYS_TURN VALUES(1, 1);
INSERT INTO DIARYS_TURN VALUES(2, 2);
INSERT INTO DIARYS_TURN VALUES(3, 3);
INSERT INTO DIARYS_TURN VALUES(4, 4);
INSERT INTO DIARYS_TURN VALUES(5, 5);
INSERT INTO DIARYS_TURN VALUES(6, 6);

INSERT INTO TURN_STATUS_TURNS_LIST VALUES(1, 1);
INSERT INTO TURN_STATUS_TURNS_LIST VALUES(2, 2);
INSERT INTO TURN_STATUS_TURNS_LIST VALUES(3, 3);
INSERT INTO TURN_STATUS_TURNS_LIST VALUES(1, 4);
INSERT INTO TURN_STATUS_TURNS_LIST VALUES(2, 5);
INSERT INTO TURN_STATUS_TURNS_LIST VALUES(3, 6);