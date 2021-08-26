package net.therap.hibernet.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author rumi.dipto
 * @since 8/26/21
 */
public interface EntityManagerConfiguration {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-1");

    EntityManager entityManager = entityManagerFactory.createEntityManager();
}
