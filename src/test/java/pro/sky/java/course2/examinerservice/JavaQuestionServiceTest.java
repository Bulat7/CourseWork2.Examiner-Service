package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.JavaQuestionService;

import java.util.Collection;

public class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    public void setJavaQuestionService() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    public void shouldAddQuestion() {
        Question expectedQuestion = new Question("1", "1");
        javaQuestionService.add(expectedQuestion);
        Assertions.assertTrue(javaQuestionService.getAll().contains(expectedQuestion));
    }

    @Test
    public void shouldDoNotPushSecondSameQuestion() {
        Question question = new Question("1","1");
        javaQuestionService.add(question);
        javaQuestionService.add(question);
        Assertions.assertEquals(1, javaQuestionService.getAll().size());
    }

    @Test
    public void shouldRemoveQuestion() {
        Question question = new Question("1","1");
        javaQuestionService.add(question);

        javaQuestionService.remove(question);
        Assertions.assertFalse(javaQuestionService.getAll().contains(question));
    }

    @Test
    public void shouldReturnRandomQuestion() {
        Question question = new Question("1","1");
        javaQuestionService.add(question);

        Question result = javaQuestionService.getRandomQuestion();
        Assertions.assertNotNull(result);
    }

    @Test
    public void shouldReturnGetAllQuestion() {
        Question question1 = new Question("1", "1");
        Question question2 = new Question("2","2");
        Question question3 = new Question("3", "3");

        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        javaQuestionService.add(question3);

        Collection <Question> result = javaQuestionService.getAll();
        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void shouldThrowExceptionWhenCollectionIsEmpty() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                ()-> {
                    javaQuestionService.getRandomQuestion();
                }
        );

    }




}
