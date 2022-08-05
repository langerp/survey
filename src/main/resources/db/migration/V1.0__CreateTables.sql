CREATE TABLE survey (
    id UUID NOT NULL,
    description VARCHAR(255) NOT NULL,
    version INT,
    PRIMARY KEY (id)
);

CREATE TABLE question (
    id UUID NOT NULL,
    text VARCHAR(255) NOT NULL,
    survey_id UUID NOT NULL,
    version INT,
    FOREIGN KEY (survey_id) REFERENCES survey (id),
    PRIMARY KEY (id)
);

CREATE TABLE answer (
    id UUID NOT NULL,
    text VARCHAR(255) NOT NULL,
    question_id UUID NOT NULL,
    version INT,
    FOREIGN KEY (question_id) REFERENCES question (id),
    PRIMARY KEY (id)
);