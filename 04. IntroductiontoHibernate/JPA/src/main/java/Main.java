import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student student1 = new Student("Kris", new Date());
        Student student2 = new Student("Gosho", new Date());
        Student student3 = new Student("Pesho", new Date());
        Student student4 = new Student("Nik", new Date());

        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);

        em.getTransaction().commit();
        em.close();
    }
}
