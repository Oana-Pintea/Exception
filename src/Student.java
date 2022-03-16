import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private String ID;  //CNP, stocat ca String

    public String getID()
    {
        return ID;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public Student(String firstName, String lastName, LocalDate birthDate, Gender gender, String ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.ID = ID;
    }

    public static Student parseStudent(String firstName, String lastName, String yearString, String monthString, String dayString, String genderString, String cnpString) throws Exception {

        int year = Integer.parseInt(yearString);
        int month = Integer.parseInt(monthString);
        int day = Integer.parseInt(dayString);
        LocalDate birthDate = LocalDate.of(year, month, day);

        String genderLower = genderString.toLowerCase(Locale.ROOT);
        Gender gender;
        if(genderLower.compareTo("m")==0 || genderLower.compareTo("male")==0)
            gender = Gender.MALE;
        else if (genderLower.compareTo("f")==0 || genderLower.compareTo("female")==0)
            gender = Gender.FEMALE;
        else if (genderLower.compareTo("other") == 0)
            gender = Gender.OTHER;
        else
            throw new MyException(ExceptionType.GENDER_TEXT, "gender text must be m, f, male or female or other (case insensitive)");

        for(char c : cnpString.toCharArray())
        {
            if(c<'0' || c>'9')
                throw new MyException(ExceptionType.CNP_TEXT, "cnp contains non-numerical characters");
        }

        Student s = new Student(firstName, lastName, birthDate, gender, cnpString );
        return  s;
    }

    public Period age() {
        return Period.between(birthDate, LocalDate.now());

    }
}
