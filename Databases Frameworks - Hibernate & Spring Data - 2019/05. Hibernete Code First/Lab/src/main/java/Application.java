import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("shampoo_company");
        EntityManager manager = factory.createEntityManager();

        Runnable runnable = new Engine(manager);

        runnable.run();
    }
}
