package net.therap.hibernet.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author rumi.dipto
 * @since 8/29/21
 */
public class EntityManagerConfiguration {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-1");

    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    private static EntityManagerConfiguration entityManagerConfiguration = null;

    public static EntityManagerConfiguration getInstance() {
        if (entityManagerConfiguration == null) {
            entityManagerConfiguration = new EntityManagerConfiguration();
        }
        return entityManagerConfiguration;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
