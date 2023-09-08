package com.hido.SparkRestWebService.Service;

import com.hido.SparkRestWebService.Exception.UserException;
import com.hido.SparkRestWebService.Model.*;

import java.util.Collection;

public interface IUserService {
    public void addUser(User user);

    public Collection<User> getUsers();

    public User getUser(String id);

    public User editUser(User user) throws UserException;

    public void deleteUser(String id);

    public boolean userExist(String id);
}
