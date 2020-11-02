package entiti.dao;

import entiti.EntityManager;
import entiti.model.Role;
import entiti.model.Task;
import entiti.model.User;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class TaskDao {
    private EntityManager entityManager = new EntityManager();
    private EntityManagerFactory entityManagerFactory = entityManager.getEntityManagerFactory();

    public void addTasks(List<Task>tasks){
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for(Task task : tasks){
            entityManager.persist(task);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateTasks(List<Task>tasks) {
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for(Task task : tasks){
            entityManager.merge(task);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
