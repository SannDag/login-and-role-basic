package com.sanndag.login.persistence;

import com.sanndag.login.logic.Role;
import com.sanndag.login.logic.User;
import com.sanndag.login.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceController {
    UserJpaController userJpa = new UserJpaController();
    RoleJpaController rolJpa = new RoleJpaController();
    
    public List<User> getUsers(){
        return userJpa.findUserEntities();
    }

    public List<Role> getRoles() {
        return rolJpa.findRolEntities();
    }

    public void createUser(User us) {
        userJpa.create(us);
    }

    public void deleteUser(int userId) {
        try {
            userJpa.destroy(userId);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUsers(int userId) {
        return userJpa.findUser(userId);
    }

    public void updateUser(User us) {
        try {
            userJpa.edit(us);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
