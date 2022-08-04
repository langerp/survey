package com.example.survey.api;

public interface Paths {

    String PREFIX = "api/v1/";

    String SURVEYS = PREFIX + "surveys/";

    String SURVEY_ID = "surveyId";

    String QUESTIONS = SURVEYS + "{" + SURVEY_ID + "}" + "/questions/";

}
