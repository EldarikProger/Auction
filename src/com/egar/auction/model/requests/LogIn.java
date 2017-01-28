package com.egar.auction.model.requests;

import java.io.Serializable;

/**
 * Team log-in
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class LogIn implements Request, Serializable {

    private String name;
    private String password;
    private boolean checkAdmin;

    /**
     * @see LogIn#LogIn(String, String, boolean)
     */
    public LogIn() {
    }

    /**
     * Create request
     *
     * @param name     client name
     * @param password client password
     */
    public LogIn(String name, String password, boolean a) {
        this.name = name;
        this.password = password;
        this.checkAdmin = a;
    }

    /**
     * Return user name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * put user name
     *
     * @param name user name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return user password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * put user password
     *
     * @param password user password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * checkAdmin
     * @return
     */
    public boolean isCheckAdmin() {
        return checkAdmin;
    }

    /**
     * checkAdmin
     * @param checkAdmin
     */
    public void setCheckAdmin(boolean checkAdmin) {
        this.checkAdmin = checkAdmin;
    }
}
