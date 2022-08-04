package com.example.survey.api.question;

import com.example.survey.api.Paths;
import com.example.survey.domain.service.UpdateQuestionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = QuestionController.class)
class QuestionControllerTest {

    private static final UUID SURVEY_ID = UUID.randomUUID();
    private static final UUID QUESTION_ID = UUID.randomUUID();

    @MockBean
    private UpdateQuestionService updateQuestionService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void patchReturnsOkWhenRequestBodyIsValid() throws Exception {
        mockMvc.perform(patch(Paths.SURVEYS + SURVEY_ID + "/questions/" + QUESTION_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"active\": \"false\"}"))
                .andExpect(status().isOk());

        Mockito.verify(updateQuestionService).updateQuestion(QUESTION_ID, new PatchQuestionRequest(false));
    }

    @Test
    void patchReturnsBadRequestWhenRequestBodyIsInvalid() throws Exception {
        mockMvc.perform(patch(Paths.SURVEYS + SURVEY_ID + "/questions/" + QUESTION_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"something\": \"something\"}"))
                .andExpect(status().isBadRequest());
    }
}