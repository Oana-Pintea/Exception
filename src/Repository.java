import java.util.ArrayList;
import java.util.List;

public class Repository {

    public List<Student> students;

    public Repository()
    {
        students = new ArrayList<>();
    }

    public void add(Student s) throws Exception
    {
        if(s.getBirthDate().getYear()<1900)
            throw new MyException(ExceptionType.AGE_LIMIT, "Too old");
        if(s.age() .getYears() < 18)
            throw new MyException(ExceptionType.AGE_LIMIT, "Too young");
        if(s.getFirstName().isEmpty())
            throw new MyException(ExceptionType.NAME_EMPTY, "First name empty");
        if(s.getLastName().isEmpty())
            throw new MyException(ExceptionType.NAME_EMPTY, "Last name is empty");
        if(s.getGender() != Gender.MALE && s.getGender() != Gender.FEMALE)
            throw new MyException(ExceptionType.HETERO_ONLY,"Only M or F gender accepted in repository");

        students.add(s);
    }

    public void delete(String ID) throws Exception {
        if(ID.isEmpty()){
            throw new MyException(ExceptionType.ID_EMPTY, "ID cannot be empty");
        }

        boolean found = false;
        for(Student s: students) {
            if (s.getID() == ID) {
                students.remove(s);
                found = true;
                break;
            }
        }
        if(!found)
            throw new MyException(ExceptionType.STUDENT_ID_NOT_FOUND, "Student to be deleted does not exist in Repository");
    }

    public List<Student> select(String age) throws Exception
    {
        int ageNumber = Integer.parseInt(age);
        return select(ageNumber);
    }

    public List<Student> select(int age) throws Exception {
        if(age<0)
            throw new MyException(ExceptionType.AGE_NEGATIVE, "Age is negative");
        List<Student> selectati = new ArrayList<>();
        for(Student s: students)
            if(s.age().getYears() == age)
                selectati.add(s);
        return selectati;
    }

}
