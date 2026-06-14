package com.techlingo.modules.submission.evaluator;

import org.springframework.stereotype.Component;
import com.techlingo.modules.learning.entity.Question;

@Component
public class McqEvaluator implements AnswerEvaluator {

    @Override
    public boolean evaluate(Question question, String submittedAnswer) {
        return question.getCorrectAnswer()
                .equalsIgnoreCase(submittedAnswer);
    }

    
}
