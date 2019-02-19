import labels.BasicLabel;
import shampoos.BasicShampoo;
import shampoos.FreshNuke;

import javax.persistence.EntityManager;

public class Engine implements Runnable {
    private final EntityManager manager;

    public Engine(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        this.manager.getTransaction().begin();

        BasicLabel label = new BasicLabel("Fresh Nuke Shampoo", "min and lent");

        BasicShampoo fn = new FreshNuke(label);

        this.manager.persist(fn);

        this.manager.getTransaction().commit();
    }
}
