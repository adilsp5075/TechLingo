package com.techlingo.modules.submission.evaluator;

import com.techlingo.modules.learning.entity.Question;

public interface AnswerEvaluator {
    boolean evaluate(
            Question question,
            String submittedAnswer
    );
}
