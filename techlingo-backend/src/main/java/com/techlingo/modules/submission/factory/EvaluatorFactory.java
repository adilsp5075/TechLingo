package com.techlingo.modules.submission.factory;

import org.springframework.stereotype.Component;

import com.techlingo.modules.learning.enums.QuestionType;
import com.techlingo.modules.submission.evaluator.AnswerEvaluator;
import com.techlingo.modules.submission.evaluator.DebugEvaluator;
import com.techlingo.modules.submission.evaluator.FillBlankEvaluator;
import com.techlingo.modules.submission.evaluator.McqEvaluator;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EvaluatorFactory {

    private final McqEvaluator mcqEvaluator;
    private final FillBlankEvaluator fillBlankEvaluator;
    private final DebugEvaluator debugEvaluator;

    public AnswerEvaluator getEvaluator( QuestionType type) {
        return switch (type) {
            case MCQ -> mcqEvaluator;
            case FILL_BLANK -> fillBlankEvaluator;
            case DEBUG -> debugEvaluator;
            default -> throw new IllegalArgumentException("Unsupported question type: " + type);
        };
    }
    
}
