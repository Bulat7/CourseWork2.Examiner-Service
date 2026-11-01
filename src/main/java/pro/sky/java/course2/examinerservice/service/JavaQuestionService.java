package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questionsSet = new HashSet<>();


    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question,answer);
        questionsSet.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questionsSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionsSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionsSet;
    }

    @Override
    public Question getRandomQuestion() {
        Object[] objects = questionsSet.toArray();
        Random randomQuestion = new Random();
        int index = randomQuestion.nextInt(objects.length);
        return (Question) objects[index];
    }

}
