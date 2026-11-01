package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {

    public final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("exam/get/{amount}")
    public Collection<Question> getQuestion(@PathVariable int amount) {
        return examinerService.getQuestion(amount);
    }

}
