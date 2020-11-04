package entiti.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "t_user")
@SQLDelete(sql = "UPDATE t_user SET active = false where user_id = ?")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @OneToOne(mappedBy="user")
    private Discipline head;

    @Column(name = "fname")
    private String firstName;

    @Column(name = "lname")
    private String lname;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "createdAt")
    private String createdAt;

    @Column(name = "active")
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "User_Roles",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    List<Role> roles = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="discipline_id")
    private Discipline discipline;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",orphanRemoval=true)
    private List<Task> tasks = new ArrayList<>();



    public User(String firstName, String lname, String email, String createdAt, boolean enabled, Discipline discipline,List<Task>tasks,List<Role>roles) {
        this.firstName = firstName;
        this.lname = lname;
        this.email = email;
        this.createdAt = createdAt;
        this.enabled = enabled;
        this.discipline = discipline;
        this.tasks = tasks;
        this.tasks = tasks;
        this.roles = roles;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Discipline getHead() {
        return head;
    }

    public void setHead(Discipline head) {
        this.head = head;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        tasks.stream().forEach((task -> { task.setUser(this); }));
        this.tasks = tasks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }


}
