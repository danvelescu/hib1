package entiti.model;


import entiti.model.enums.UserRoles;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_role")
@SQLDelete(sql = "UPDATE user_roles SET role_id = null where user_id = ?")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    @Enumerated(value = EnumType.STRING)
    UserRoles roles;

    public Role(){}

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    public Role(UserRoles roles) {
        this.roles = roles;
    }

    public UserRoles getRoles() {
        return roles;
    }

    public void setRoles(UserRoles roles) {
        this.roles = roles;
    }
}
