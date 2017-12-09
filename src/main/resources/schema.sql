CREATE TABLE "user"
(
  id         BIGINT NOT NULL PRIMARY KEY,
  first_name TEXT   NOT NULL,
  last_name  TEXT   NOT NULL,
  email      TEXT   NOT NULL,
  password   TEXT   NOT NULL
);

CREATE TABLE note_book
(
  id          BIGINT    NOT NULL PRIMARY KEY,
  name        TEXT      NOT NULL,
  create_date TIMESTAMP NOT NULL,
  id_user     BIGINT    NOT NULL,
  CONSTRAINT note_book_user_id_fk FOREIGN KEY (id_user) REFERENCES "user" (id)
);

CREATE TABLE note
(
  id           BIGINT    NOT NULL PRIMARY KEY,
  title        TEXT      NOT NULL,
  description  TEXT,
  create_date  TIMESTAMP NOT NULL,
  id_note_book BIGINT    NOT NULL,
  CONSTRAINT note_note_book_id_fk FOREIGN KEY (id_note_book) REFERENCES note_book (id)
);

CREATE TABLE mark
(
  id   BIGINT NOT NULL PRIMARY KEY,
  name TEXT   NOT NULL
);

CREATE TABLE note_mark
(
  id_note BIGINT NOT NULL,
  id_mark BIGINT NOT NULL,
  CONSTRAINT note_mark_mark_id_fk FOREIGN KEY (id_mark) REFERENCES mark (id),
  CONSTRAINT note_mark_note_id_fk FOREIGN KEY (id_note) REFERENCES note (id)
);