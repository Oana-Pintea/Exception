import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @org.junit.jupiter.api.Test
    void parseStudent() throws Exception{


        //Test 1: Year is not a number throws exception
        boolean exceptie = false;
        try {
            Student s = Student.parseStudent("Gigi", "Florea", "1991a", "4", "7", "MALE", "194041023345");
        }
        catch (NumberFormatException ex) {
            exceptie = true;
            //ok
        }

        assertEquals(true, exceptie);


        //Test 2: gender must be m  / f  / male /  female / other (big or small letters)
        exceptie = false;
        try {
            Student s = Student.parseStudent("Gigi", "Florea", "1991", "4", "7", "QUEER", "194041023345");
        }
        catch (MyException ex)
        {
            exceptie = true;
            assertEquals(ExceptionType.GENDER_TEXT, ex.id);
        }
        assertEquals(true, exceptie);


        // Test 3

        exceptie = false;
        try{
            Student s = Student.parseStudent("Gigi", "Florea", "1991", "4", "7", "MALE", "ABC94041023345");
        }
        catch (MyException ex){
            exceptie = true;
            assertEquals(ExceptionType.CNP_TEXT, ex.id);
        }
        assertEquals(true, exceptie);
    }

    @org.junit.jupiter.api.Test
    void age() {

        Student s = new Student("Yuri", "Gagarin", LocalDate.now(), Gender.MALE, "1923456789123");
        Period period = s.age();

        assertEquals(0, period.getYears());
    }
}