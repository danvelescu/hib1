package entiti.dao;

import entiti.EntityManager;
import entiti.model.Discipline;
import entiti.model.User;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class DisciplineDao {

    private EntityManager entityManager = new EntityManager();
    private EntityManagerFactory entityManagerFactory = entityManager.getEntityManagerFactory();

    public void addDisciplines(List<Discipline> disciplines) {
            javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            for(Discipline discipline : disciplines){
                entityManager.persist(discipline);
            }
            entityManager.getTransaction().commit();
            entityManager.close();
    }


    public void updateDisciplines(List<Discipline> disciplines) {
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for(Discipline discipline : disciplines){
            entityManager.merge(discipline);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void updateHeadOfDiscipline(User user , Discipline discipline){
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        discipline.setUser(user);
        entityManager.merge(discipline);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public List<Discipline> getDisciplineHaveMoreThan(int numbersOfUsers){
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
       List<User> list = entityManager.
               createQuery("select user from User user join user.discipline discipline where discipline.users.size <= :numOfusers").
                setParameter("numOfusers",numbersOfUsers).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        list.stream().forEach(discipline -> System.out.println(discipline.getDiscipline().getDisciplineType()));

        List<Discipline> disciplineList = new ArrayList<>();
        list.stream().forEach(user -> disciplineList.add(user.getDiscipline()));
       return disciplineList;
    }

}
