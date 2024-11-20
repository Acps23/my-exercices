package io.codeforall.fanstatics;

import javax.persistence.*;
import java.util.List;


@Entity
public class SecurityGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToMany(
            // mappedBy required for bidirectional association
            mappedBy = "sgroups",


            fetch = FetchType.LAZY
    )
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }
}
