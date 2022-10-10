
package services;

import java.util.*;
import models.User;


/**
 *
 * @author tobys
 */
public class AccountService {
    public User login(String username, String password){
        List<User> users = new ArrayList<>();
        users.add(new User("abe", "password"));
        users.add(new User("barb", "password"));
        
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return new User(user.getUsername(), null);
            }
        }
        return null;
    }
}
