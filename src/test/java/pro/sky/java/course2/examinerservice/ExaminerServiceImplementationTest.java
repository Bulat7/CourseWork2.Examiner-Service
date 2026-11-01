package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.ExaminerServiceImplementation;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplementationTest {

    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImplementation examinerServiceImplementation;


    @Test
    public void shouldReturnCorrectExamTicket() {
        Question question1 = new Question("1","1");
        Question question2 = new Question("2","2");
        Collection<Question> questions = List.of(question1,question2);

        Mockito.when(questionService.getAll()).thenReturn(questions);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(question1,question2);

        Collection<Question> result = examinerServiceImplementation.getQuestion(2);

        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains(question1));
        Assertions.assertTrue(result.contains(question2));
    }

    @Test
    public void shouldThrowExceptionWhenAmountIsInvalid(){

        Question question1 = new Question("1","1");
        Question question2 = new Question("2","2");
        Collection<Question> questions = List.of(question1,question2);

        Mockito.when(questionService.getAll()).thenReturn(questions);
        Assertions.assertThrows(
                IllegalArgumentException.class,
        ()-> {
            examinerServiceImplementation.getQuestion(questions.size()+1);
        }
        );


    }


}
