INSERT INTO user(id, first_name, last_name,  email, password)
VALUES
  ('1', 'some', 'some', 'some@email.com', 'password123'),
  ('2', 'Ivan', 'Ivanov', 'ivan@email.com', 'pass'),
  ('3', 'some', 'some', 'some@email.com', 'password123');


INSERT INTO note_book(id, name, create_date, id_user)
    VALUES
      ('1', 'default', '2017-12-01 20:37:25', '1'),
      ('2', 'MyFirstNoteBook', '2017-12-01 21:37:25', '1'),
      ('3', 'forDeletion', '2017-11-01 21:37:25', '2'),
      ('4', 'forNotesAdding', '2017-11-01 21:37:25', '2');

INSERT INTO note(id, title, description, create_date, id_note_book)
    VALUES
      ('1', 'Buying list', 'milk, salt, knife', '2017-12-02 21:37:25', '1'),
      ('2', 'LastDayPartyCleaning', 'bury corpses of whores', '2017-12-02 21:37:25', '1'),
      ('3', 'AfterDivorce', 'Burn things of my last wife', '2017-12-03 21:37:25', '2'),
      ('4', 'GTA', 'Take a six stars', '2017-12-03 21:37:25', '2'),
      ('5', 'forDeletion', 'Take a six stars', '2017-12-03 21:37:25', '4');

INSERT INTO mark(id, name)
    VALUES
      ('1', 'important'),
      ('2', 'f*cking important'),
      ('3', 'forDeletion');


INSERT INTO note_mark(id_note, id_mark)
    VALUES
      ('1', '1'),
      ('2', '2'),
      ('3', '2'),
      ('4', '1'),
      ('4', '2');
