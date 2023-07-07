package com.sanndag.login.logic;

import com.sanndag.login.persistence.PersistenceController;

import java.util.List;

public class Controller {

    PersistenceController perstController = new PersistenceController();
    
    public Controller(){
        perstController = new PersistenceController();
    }

    public User userValidate(String user, String password) {
        //String message = "";
        User usr = null;
        
        List<User> userList = perstController.getUsers();

        for (User us : userList) {
            if (us.getUsername().equals(user)) {               
                if (us.getPassword().equals(password)) {
                    //return message = "Correct username and password . Welcome!";
                    usr = us;
                    return usr;
                } else {
                    //return message = "The password is incorrect";
                    usr = null;
                    return usr;
                }
            } else {
                //message = "The entered username doesn't exist.";
                usr = null;
                  
            }
        }
        return usr;
    }

    public List<User> getUsers() {
        return perstController.getUsers();   
    }

    public List<Role> getRoles() {
        return perstController.getRoles();
    }

    public void createUser(String user, String passw, String receivedRole) {
        User us = new User();
        us.setUsername(user);
        us.setPassword(passw);
        
        Role foundRole = new Role();
        foundRole = this.getRole(receivedRole);        
        if(foundRole!=null){
            us.setUserRole(foundRole);
        }
        
        int id = this.findLastUserId();
        us.setId(id+1);
        perstController.createUser(us);
    }

    private Role getRole(String receivedRole) {
        List<Role> roleList = perstController.getRoles();
        
        for(Role role : roleList){
            if(role.getRoleName().equals(receivedRole)){
                return role;
            }
        }
        
        return null;
    }

    private int findLastUserId() {
        List<User> userList = this.getUsers();
        
        User us = userList.get(userList.size()-1);
        return us.getId();
    }

    public void deleteUser(int userId) {
        perstController.deleteUser(userId);
    }

    public User getUser(int userId) {
        return perstController.getUsers(userId);
    }

    public void updateUser(User us, String user, String passw, String receivedRole) {
        us.setUsername(user);
        us.setPassword(passw);
        
        Role foundRole = new Role();
        foundRole = this.getRole(receivedRole);        
        if(foundRole!=null){
            us.setUserRole(foundRole);
        }
        
        perstController.updateUser(us);
        
    }

    

}
