package entiti.dao;

import entiti.EntityManager;
import entiti.model.Discipline;
import entiti.model.Role;
import entiti.model.Task;
import entiti.model.User;
import entiti.model.enums.DisciplineType;
import entiti.model.enums.Status;
import entiti.model.enums.UserRoles;



import javax.persistence.EntityManagerFactory;

import java.util.List;

public class UserDao {
    private EntityManager entityManager = new EntityManager();
    private EntityManagerFactory entityManagerFactory = entityManager.getEntityManagerFactory();

    public void addUsers(List<User> users) {
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for(User user : users){
            entityManager.persist(user);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<User> getAllUsers() {
        List<User> list;
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        list = entityManager.createQuery("from User", User.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return list;
    }


    public List<User> getUserById(int id) {
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery(
                "SELECT user from User user where user.id = :thisid")
                .setParameter("thisid", id)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }

    public List<User> getUsersByRole(UserRoles userRoles) {
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Integer rol = (int) entityManager.createQuery("select role.id from Role role where role.roles like :usrRol")
                .setParameter("usrRol", userRoles)
                .getSingleResult();
        entityManager.getTransaction().commit();
        List<User> users =
                entityManager.createQuery("select user from User user join user.roles roles where roles.id = :roleid")
                        .setParameter("roleid", rol).getResultList();
        entityManager.close();
        return users;
    }


    public void updateUser(User user , List<Task>tasks,List<Role>roles,Discipline discipline){
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
            user.setRoles(roles);
            user.setTasks(tasks);
            user.setDiscipline(discipline);
            entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<User> getUsersByTaskstatus(Status status) {
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> users =
                entityManager.createQuery("select user from User user join user.tasks task where task.status = :taskId")
                        .setParameter("taskId", status).getResultList();
        entityManager.close();
        return users;
    }


    public void softDeletebyId(int id){
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
