package com.example.survey.domain.service;

import com.example.survey.api.question.PatchQuestionRequest;
import com.example.survey.domain.entity.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private UpdateQuestionService updateQuestionService;

    @Test
    void updateUpdatesTheQuestionsActiveProperty() {
        Question question = new Question();
        question.setActive(true);
        when(questionRepository.findById(any(UUID.class))).thenReturn(Optional.of(question));

        updateQuestionService.updateQuestion(UUID.randomUUID(), new PatchQuestionRequest(false));

        Assertions.assertThat(question.getActive()).isFalse();
    }

    @Test
    void updateThrowsNotFoundExceptionIfQuestionDoesNotExist() {
        when(questionRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> updateQuestionService.updateQuestion(UUID.randomUUID(), new PatchQuestionRequest(true)))
                .isInstanceOf(EntityNotFoundException.class);
    }
}