package io.codeforall.fanstatics;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;
    @ManyToMany(
            cascade = CascadeType.PERSIST,
            // fetch all security groups when fetching a user
            fetch = FetchType.LAZY
    )
    private List<SecurityGroup> sgroups;

    // utility methods to update both sides of the relationship

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SecurityGroup> getSgroups() {
        return sgroups;
    }

    public void setSgroups(List<SecurityGroup> sgroups) {
        this.sgroups = sgroups;
    }

    public void addSecurityGroup(SecurityGroup sg) {
        if (!sgroups.contains(sg)) {
            sgroups.add(sg);
            sg.addUser(this);
        }
    }
}
