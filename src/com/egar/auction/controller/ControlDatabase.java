package com.egar.auction.controller;

import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.Admin;
import com.egar.auction.model.AuctionDatabase;
import com.egar.auction.model.AuthorizedUser;

import java.util.List;


public class ControlDatabase implements Controller{
    private AuctionDatabase database;

    public ControlDatabase(AuctionDatabase database) {
        this.database = database;
    }

    public void createAuthorizedUser(String name,String password) throws UserException {
        for(AuthorizedUser user : database.getAuthorizedUsers()){
            if(name.equals(user.getName()))
                throw new UserException("Такой пользователь уже существует! Введите другое имя!");
        }
        database.addAuthorizedUser(new AuthorizedUser(name,password));
    }

    public void createAdmin(String name, String password) throws UserException {
        for(Admin admin : database.getAdmins()){
            if(name.equals(admin.getName()))
                throw new UserException("Такой пользователь уже существует! Введите другое имя!");
        }
        database.addAdmin(new Admin(name,password));
    }

    public void deleteAdmin(String name,String password){
        List<Admin> list = database.getAdmins();
        for (int i=0; i<list.size();i++){
            if(name.equals(list.get(i).getName()) && password.equals(list.get(i).getPassword()))
                list.remove(i);
        }
    }

    public void deleteAuthorizedUser(String name,String password){
        List<AuthorizedUser> list = database.getAuthorizedUsers();
        for (int i=0; i<list.size();i++){
            if(name.equals(list.get(i).getName()) && password.equals(list.get(i).getPassword()))
                list.remove(i);
        }
    }

}
