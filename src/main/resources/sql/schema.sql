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
values (0, 'link0');
INSERT INTO steps
values (1, 'link1');
INSERT INTO steps
values (2, 'link2');
INSERT INTO roadmaps
values ('0', 'Rich Hickey', 0);
INSERT INTO roadmaps
values ('1', 'Rich Hickey', 1);