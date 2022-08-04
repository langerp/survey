package com.example.survey.api.question;

import com.example.survey.api.Paths;
import com.example.survey.domain.service.UpdateQuestionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(Paths.QUESTIONS)
public class QuestionController {

    private static final String QUESTION_ID = "questionId";
    private final UpdateQuestionService updateQuestionService;

    public QuestionController(UpdateQuestionService updateQuestionService) {
        this.updateQuestionService = updateQuestionService;
    }

    @PatchMapping(value = "{" + QUESTION_ID + "}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void patchQuestion(
            @PathVariable(QUESTION_ID) UUID questionId,
            @Valid @RequestBody PatchQuestionRequest request
    ) {
        updateQuestionService.updateQuestion(questionId, request);
    }

}
