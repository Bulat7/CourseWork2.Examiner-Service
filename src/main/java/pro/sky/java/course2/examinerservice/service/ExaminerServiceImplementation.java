package pro.sky.java.course2.examinerservice.service;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImplementation implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImplementation(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size())
            throw new IllegalArgumentException("BAD REQUEST");
        Set<Question> examTicket = new HashSet<>();
        while ( examTicket.size() < amount) {
            examTicket.add(questionService.getRandomQuestion());
        }
        return examTicket;
    }
}
