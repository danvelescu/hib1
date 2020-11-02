package entiti.model;
import entiti.model.enums.DisciplineType;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "t_discipline")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discipline_id")
    private int id;

    @OneToOne
    @JoinColumn(name="HeadOfDiscipline",referencedColumnName = "user_id")
    private User user;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private DisciplineType disciplineType;

    @OneToMany(mappedBy = "discipline",cascade = CascadeType.ALL)
    private List<User>users;

    public Discipline(DisciplineType disciplineType, List<User> users) {
        this.disciplineType = disciplineType;
        this.users = users;
    }

    public Discipline() {

    }



    public Discipline(DisciplineType am) {
        this.disciplineType = am;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DisciplineType getDisciplineType() {
        return disciplineType;
    }

    public void setDisciplineType(DisciplineType disciplineType) {
        this.disciplineType = disciplineType;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
