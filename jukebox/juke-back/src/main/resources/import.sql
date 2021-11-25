-- Insert Users
INSERT INTO User (name, email, role, username, password)
VALUES ('Gustavo Gianini', 'ggianini@jukefy.com.br', 'admin', 'ggianini', '$2a$10$7Td9sEF1wqUjOK1gr1l.ROHRoU9Vg0OUWBdOlg9y.DUYq1xQYXzfO');

INSERT INTO User (name, email, role, username, password)
VALUES ('Hugo Pfeffer', 'hpfeffer@jukefy.com.br', 'user', 'hpfeffer', '$2a$10$7Td9sEF1wqUjOK1gr1l.ROHRoU9Vg0OUWBdOlg9y.DUYq1xQYXzfO');


INSERT INTO Song (author, duration, name, votes)
VALUES ('Elis Regina','123','Águas de Março','352');

INSERT INTO Song (author, duration, name, votes)
VALUES ('Cartola','97','O Mundo é um Moinho','194');

INSERT INTO Song (author, duration, name, votes)
VALUES ('Legião Urbana','141','Há Tempos','631');

INSERT INTO Song (author, duration, name, votes)
VALUES ('Queen','141','Don''t stop me now','358');

INSERT INTO Playlist (name, user_id)
VALUES ('rock', '1');

INSERT INTO Playlist (name, user_id)
VALUES ('mpb', '2');