package me.mosesapp.moses.model;

import java.math.BigDecimal;

/**
 * Created by thiago on 1/14/16.
 */
public class GroupUser {
    private User user;
    private Group group;
    private Boolean isAdmin;
    private BigDecimal spentOnBill;


    public GroupUser() {
        this.isAdmin = false;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public BigDecimal getSpentOnBill() {
        return spentOnBill;
    }

    public void setSpentOnBill(BigDecimal spentOnBill) {
        this.spentOnBill = spentOnBill;
    }
}
