package entiti.Repository;

import entiti.model.Role;
import entiti.model.User;
import entiti.model.enums.UserRoles;

import java.util.ArrayList;
import java.util.List;

public class RolesRep {
    List<Role> roles = new ArrayList<>();

     Role rol1 = new Role(UserRoles.USER_ROLE);
     Role rol2 = new Role(UserRoles.ADMIN_ROLE);

    public List<Role> getRoles() {
        roles.add(rol1);
        roles.add(rol2);
        return roles;
    }
}
