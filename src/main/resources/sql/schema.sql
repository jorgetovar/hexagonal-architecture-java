CREATE TABLE IF NOT EXISTS steps
(
    id            INT DEFAULT RANDOM() PRIMARY KEY,
    resource_link VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS roadmaps
(
    id      VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    mentor  VARCHAR NOT NULL,
    step_id INT,

    CONSTRAINT fk_steps FOREIGN KEY (step_id) REFERENCES steps (id)

);