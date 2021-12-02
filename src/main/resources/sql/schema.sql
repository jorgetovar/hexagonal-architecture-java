CREATE TABLE IF NOT EXISTS steps
(
    step_id       INT PRIMARY KEY,
    resource_link VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS roadmaps
(
    id      VARCHAR(60) PRIMARY KEY,
    mentor  VARCHAR NOT NULL,
    step_id INT     NOT NULL,

    CONSTRAINT fk_steps FOREIGN KEY (step_id) REFERENCES steps (step_id)

);

INSERT INTO steps
values (0, 'https://www.youtube.com/watch?v=SxdOUGdseq4');
INSERT INTO steps
values (1, 'https://www.youtube.com/watch?v=YR5WdGrpoug');
INSERT INTO steps
values (2, 'https://www.youtube.com/watch?v=2V1FtfBDsLU');
INSERT INTO roadmaps
values ('0', 'Rich Hickey', 0);
INSERT INTO roadmaps
values ('1', 'Rich Hickey', 1);