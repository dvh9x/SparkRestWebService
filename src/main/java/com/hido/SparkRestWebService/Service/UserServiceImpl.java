package com.hido.SparkRestWebService.Service;

import com.hido.SparkRestWebService.Exception.UserException;
import com.hido.SparkRestWebService.Model.User;

import java.util.Collection;
import java.util.HashMap;

public class UserServiceImpl implements IUserService{

    private HashMap<String, User> userMap;

    public UserServiceImpl() {
        userMap = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getId(),user);
    }

    @Override
    public Collection<User> getUsers() {
        return userMap.values();
    }

    @Override
    public User getUser(String id) {
        return userMap.get(id);
    }

    @Override
    public User editUser(User oldUser) throws UserException {
        try {
            if (oldUser.getId() == null)
                throw new UserException("User can not be blank");
            User newUser = userMap.get(oldUser.getId());
            if (newUser == null)
                throw new UserException("User not found");
            if (oldUser.getEmail() != null) {
                newUser.setEmail(oldUser.getEmail());
            }
            if (oldUser.getFirstName() != null) {
                newUser.setFirstName(oldUser.getFirstName());
            }
            if (oldUser.getLastName() != null) {
                newUser.setLastName(oldUser.getLastName());
            }
            if (oldUser.getId() != null) {
                newUser.setId(oldUser.getId());
            }
            return newUser;
        }
        catch (Exception ex){
            throw new UserException(ex.getMessage());
        }
    }

    @Override
    public void deleteUser(String id) {
        userMap.remove(id);

    }

    @Override
    public boolean userExist(String id) {
        return userMap.containsKey(id);
    }
}
