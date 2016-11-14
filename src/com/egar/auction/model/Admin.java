package com.egar.auction.model;

/**
 * Admin is the user. Class Admin have admin data
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Admin implements User {

    private String name;
    private String password;
    private long id;

    /**
     * Create Admin
     *
     * @param name string with admin name
     * @param password string with admin password
     * @param id admin id
     */
    public Admin(String name, String password, long id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    /**
     * Return name user
     *
     * @return string name admin
     */
    public String getName() {
        return name;
    }

    /**
     * Set name to user
     *
     * @param name string with admin name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return password admin
     *
     * @return string admin password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password to user
     *
     * @param password string with admin password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get id admin
     *
     * @return id admin
     */
    public long getId() {
        return id;
    }

    /**
     * Return true if all admin fields coincide with Object fields
     *
     * @param o object with which compare
     * @return boolean value: true if object and admin equally
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (id != admin.id) return false;
        if (name != null ? !name.equals(admin.name) : admin.name != null) return false;
        return password != null ? password.equals(admin.password) : admin.password == null;

    }

    /**
     * Return hash admin
     *
     * @return hash admin
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    /**
     * Represent Admin in string form
     *
     * @return string data of admin
     */
    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
