package entiti.Repository;

import entiti.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRep {
    List<User> users = new ArrayList<>();
    User user1 = new User("Dan",
            "velescu",
            "danvl@edava",
            "10/28/2020",
            true,
            null,
            null,
            null
    );
    User user2 = new User("Dan1",
            "velescu",
            "danvl@edava",
            "10/28/2020",
            true,
            null,
            null,
            null
    );
    User user3 = new User("Dan2",
            "velescu",
            "danvl@edava",
            "10/28/2020",
            true,
            null,
            null,
            null
    );
    User user4 = new User("Dan3",
            "velescu",
            "danvl@edava",
            "10/28/2020",
            true,
            null,
            null,
            null
    );

    public List<User> getUsers() {
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        return users;
    }
}
