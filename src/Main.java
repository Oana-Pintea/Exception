import java.time.LocalDate;
import java.util.Locale;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {

        try {
            Student s1 = Student.parseStudent("Andrei", "Popescu", "1995", "12", "25", "Male", "1951225776655");

            Student s2 = Student.parseStudent("Cristina", "Popescu", "1997", "6", "22", "Female", "2940406308233");

            Student s3 = Student.parseStudent("Maria", "Ionescu", "1997", "11", "12", "Female", "2940416309233");


            Repository rep = new Repository();
            rep.add(s1);
            rep.add(s2);
            rep.add(s3);

            for(Student s : rep.select(24))
                System.out.println(s.getFirstName() + " " + s.age());

        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }



    }
}
