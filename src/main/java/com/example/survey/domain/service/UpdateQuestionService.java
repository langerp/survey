package com.example.survey.domain.service;

import com.example.survey.api.question.PatchQuestionRequest;
import com.example.survey.domain.entity.Question;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class UpdateQuestionService {

    private final QuestionRepository questionRepository;

    public UpdateQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional
    public void updateQuestion(UUID questionId, PatchQuestionRequest patchQuestionRequest) {
        Question question = questionRepository.findById(questionId).orElseThrow(EntityNotFoundException::new);
        question.setActive(patchQuestionRequest.isActive());
    }
}
