package entiti;
import entiti.model.Discipline;
import entiti.model.Role;
import entiti.model.Task;
import entiti.model.User;
import entiti.model.enums.DisciplineType;
import entiti.model.enums.Status;
import entiti.model.enums.UserRoles;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntityManager {
    private EntityManagerFactory entityManagerFactory;


  public EntityManager(){
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence.Event");
    }

   public void tearDown() throws Exception {
        entityManagerFactory.close();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
