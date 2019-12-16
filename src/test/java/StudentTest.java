import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Before
    public void setUp(){
        new Student(2345, "Eduardo");
    }

    @Test
    public void checkIfSetUpCorrect(){
        assertEquals(2345, Student.id);
        assertEquals("Eduardo", Student.name);
        assertNotNull(Student.grades);
    }

    @Test
    public void checkConstructorWorks(){
        new Student(12343, "John Smith");
        assertEquals(12343, Student.id);
        assertEquals("John Smith", Student.name);
        assertNotNull(Student.grades);
    }

    @Test
    public void checkIdIsReturn(){
        assertEquals(2345, Student.getId());
        Student.id = 998877;
        assertEquals(998877, Student.getId());
        Student.id = 111111;
        assertEquals(111111, Student.getId());
    }

    @Test
    public void checkNameIsReturn(){
        assertEquals("Eduardo", Student.getName());
        Student.name = "Jonny Smith";
        assertEquals("Jonny Smith", Student.getName());
        Student.name = "$%12344Hello";
        assertNotEquals("Jonny Smith", Student.getName());
        assertEquals("$%12344Hello", Student.getName());
    }

    @Test
    public void checkIfGradeCanBeAdded(){
        assertEquals(0, Student.grades.size());
        Student.addGrade(90);
        assertEquals(1,Student.grades.size());
        Student.addGrade(60);
        assertEquals(2, Student.grades.size());
        assertEquals(90, (long)Student.grades.get(0));
        assertEquals(60, (long)Student.grades.get(1));
    }

    @Test
    public void checkIfGradeAverageCorrect(){
        Student.addGrade(90);
        Student.addGrade(80);
        Student.addGrade(50);
        Student.addGrade(100);
        Student.addGrade(95);
        assertEquals(83, Student.getGradeAverage(),0);

        Student.grades.clear();
        Student.addGrade(60);
        Student.addGrade(75);
        Student.addGrade(67);
        assertEquals(67.33333333333333, Student.getGradeAverage(),0);
    }

}
