package entiti.dao;

import entiti.EntityManager;
import entiti.model.Role;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class RoleDao {
    private EntityManager entityManager = new EntityManager();
    private EntityManagerFactory entityManagerFactory = entityManager.getEntityManagerFactory();

    public void addRoles(List<Role> roles) {
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for(Role role : roles){
            entityManager.persist(role);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
