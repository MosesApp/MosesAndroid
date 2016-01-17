package me.mosesapp.moses.model;

/**
 * Created by thiago on 1/10/16.
 */
public class User {
    private String name;
    private String email;

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

    /**
     * This is used in the filtering of the autocomplete text field
     */
    @Override
    public String toString() {
        return this.name;
    }
}
