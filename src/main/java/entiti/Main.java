package entiti;

import entiti.Repository.DisciplineRep;
import entiti.Repository.RolesRep;
import entiti.Repository.TaskRep;
import entiti.Repository.UserRep;
import entiti.dao.DisciplineDao;
import entiti.dao.RoleDao;
import entiti.dao.TaskDao;
import entiti.dao.UserDao;
import entiti.model.Discipline;
import entiti.model.Role;
import entiti.model.Task;
import entiti.model.User;
import entiti.model.enums.DisciplineType;
import entiti.model.enums.Status;
import entiti.model.enums.UserRoles;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Discipline> disciplines = new DisciplineRep().getDisciplines();
        List<Role> roles = new RolesRep().getRoles();
        List<User> users = new UserRep().getUsers();
        List<Task>tasks = new TaskRep().getTasks();
        UserDao userDao = new UserDao();
        RoleDao roleDao = new RoleDao();
        TaskDao taskDao = new TaskDao();
        DisciplineDao disciplineDao = new DisciplineDao();



        try {


            userDao.addUsers(users);
            roleDao.addRoles(roles);
            taskDao.addTasks(tasks);
            disciplineDao.addDisciplines(disciplines);

            List<Role> roles1 = new ArrayList<>();
            roles1.add(roles.get(0));

            List<Task> tasks1 = new ArrayList<>();
            tasks1.add(tasks.get(0));

            List<Task> tasks2 = new ArrayList<>();
            tasks2.add(tasks.get(1));

            Discipline discipline1 = disciplines.get(0);
            Discipline discipline2 = disciplines.get(1);

            userDao.updateUser(users.get(0),tasks1,roles1,discipline1);
            userDao.updateUser(users.get(1),tasks2,roles1,discipline2);


            disciplines.get(0).setUser(users.get(0));
            disciplines.get(1).setUser(users.get(1));
            disciplines.get(2).setUser(users.get(2));
            disciplineDao.updateDisciplines(disciplines);

            disciplineDao.updateHeadOfDiscipline(users.get(1),disciplines.get(0));

            userDao.getUsersByRole(UserRoles.USER_ROLE).stream().forEach(user -> System.out.
                    println(user.getFirstName()+"  "+user.getLname()+" "+user.getDiscipline().getDisciplineType()));


            userDao.getUsersByTaskstatus(Status.TODO).stream().
                    forEach(user -> System.out.
                            println(user.getFirstName()+" "+user.getLname()));

            disciplineDao.getDisciplineHaveMoreThan(1);

            userDao.softDeletebyId(users.get(0).getId());


           // userDao.getAllUsers().stream().forEach(user -> System.out.printf(" "+user.getFirstName()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
