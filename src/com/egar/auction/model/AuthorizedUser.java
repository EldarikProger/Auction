package com.egar.auction.model;

/**
 * AuthorizedUser is the user. Class AuthorizedUser have user data
 */
public class AuthorizedUser implements User {

    private String name;
    private String password;
    private long id;

    /**
     * Create user
     *
     * @param name
     * @param password
     * @param id
     */
    public AuthorizedUser(String name, String password, long id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    /**
     * Return id user
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Return password user
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password to user
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Return name user
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name to user
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return true if all user fields coincide with Object fields
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorizedUser user = (AuthorizedUser) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    /**
     * Return hash user
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    /**
     * Represent AuthorizedUser in string form
     *
     * @return
     */
    @Override
    public String toString() {
        return "AuthorizedUser{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
