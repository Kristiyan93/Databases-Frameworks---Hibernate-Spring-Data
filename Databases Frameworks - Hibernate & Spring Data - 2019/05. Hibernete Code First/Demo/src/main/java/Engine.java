import ingredient.Student;
import ingredient.Teacher;

import javax.persistence.EntityManager;

public class Engine implements Runnable {
    private final EntityManager manager;

    public Engine(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        this.manager.getTransaction().begin();

        Student student = new Student("Pesho", 3);
        Teacher teacher = new Teacher("Petra", "Java");

        this.manager.persist(student);
        this.manager.persist(teacher);

        this.manager.getTransaction().commit();
    }
}
