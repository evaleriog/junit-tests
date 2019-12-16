import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static java.util.Arrays.asList;

import static org.junit.Assert.*;

public class CohortTest {
    Cohort emptyCohort;
    Cohort oneStudentCohort;
    Cohort manyStudentsCohort;
    Student mia;
    Student joe;
    Student george;
    Student danielle;
    @Before
    public void setUp(){
        emptyCohort = new Cohort();

        oneStudentCohort = new Cohort();
        mia = new Student(2345, "Mia");
        mia.addGrade(90);
        mia.addGrade(95);
        mia.addGrade(80);
        oneStudentCohort.addStudent(mia);


        manyStudentsCohort = new Cohort();
        manyStudentsCohort.addStudent(mia);
        joe = new Student(1234, "Joe");
        joe.addGrade(60);
        joe.addGrade(65);
        joe.addGrade(70);
        manyStudentsCohort.addStudent(joe);
        george = new Student(78965, "George");
        george.addGrade(100);
        george.addGrade(95);
        george.addGrade(80);
        manyStudentsCohort.addStudent(george);
        danielle = new Student(9999, "Danielle");
        danielle.addGrade(45);
        danielle.addGrade(80);
        danielle.addGrade(90);
        manyStudentsCohort.addStudent(danielle);
    }

    @Test
    public void checkIfSetUpWorks(){
        assertNotNull(emptyCohort.getStudents());
        assertNotNull(oneStudentCohort.getStudents());
        assertNotNull(manyStudentsCohort.getStudents());
    }

    @Test
    public void checkIfCanAddStudent(){
        assertEquals(88.33333333333333, oneStudentCohort.getCohortAverage(), 0);
    }

    @Test
    public void checkIfAverageWorks(){
        assertEquals(79.16666666666667, manyStudentsCohort.getCohortAverage(),0);
    }

    @Test
    public void checkListOfStudents(){
        List<Student> test1 = asList(mia);
        assertEquals(test1, oneStudentCohort.getStudents());

        List<Student> test2 = asList(mia, joe, george, danielle);
        assertEquals(test2, manyStudentsCohort.getStudents());
    }
}
