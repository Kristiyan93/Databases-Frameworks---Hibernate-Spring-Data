import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Student example = new Student("Pesho", new Date());
        Student example1 = new Student("Petra", new Date());
        Student example2 = new Student("Mima", new Date());
        Student example3 = new Student("Gesha", new Date());
        Student example4 = new Student("Rija", new Date());
        Student example5 = new Student("Raika", new Date());
        session.save(example);
        session.save(example1);
        session.save(example2);
        session.save(example3);
        session.save(example4);
        session.save(example5);

        List<Student> studentList = session
                .createQuery("FROM Student ").list();

        for (Student student : studentList) {
            System.out.println(student.getId());
        }

        System.out.println();

        List<Student> studentList2 = 	session.createCriteria(Student.class)
                .add(Restrictions.like("name", 	"R%")).list();
        for (Student student : studentList2) {
            System.out.println(student.getId() + " " + student.getName());
        }


        session.getTransaction().commit();
        session.close();
    }
}
