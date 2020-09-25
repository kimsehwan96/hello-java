package fourthweek;
import fourthweek.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student studentLee  = new Student(100, "Kim");

        studentLee.setKoreaSubject("korea", 50);
        studentLee.setMathSubject("math", 80);

        studentLee.showStudentScore();
    }
    
}
