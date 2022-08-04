CREATE TABLE survey (
    id UUID NOT NULL,
    description VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE question (
    id UUID NOT NULL,
    text VARCHAR(255) NOT NULL,
    survey_id UUID NOT NULL,
    FOREIGN KEY (survey_id) REFERENCES survey (id),
    PRIMARY KEY (id)
);

CREATE TABLE answer (
    id UUID NOT NULL,
    text VARCHAR(255) NOT NULL,
    question_id UUID NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question (id),
    PRIMARY KEY (id)
);