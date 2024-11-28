package io.codeforall.fanstatics;

public class User {
    private String name;
    private String email;
    private int contact;

    public User() {
        this.name = "Rui Ferrão";
        this.email = "rui.ferrao@academiadocodigo.org";
        this.contact = 916668877;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

}
