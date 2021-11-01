package user;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.saveUser(user);
    }

    public void modifyUser(User user) {
        userRepository.saveUser(user);
    }

    public void deleteUser(User user) {
        userRepository.removeUser(user);
    }
    public List<User> getUsers(){
       return userRepository.findAllUsers();
    }

    private boolean verifyCredetials(String username, String password, User user) {
        return user.getEmail().equals(username) && user.getPassword().equals(password);
    }
    public User getUserById(int id){
        return userRepository.findUserById(id);
    }
    public User validateUser(String username, String password) throws Exception  {
        Optional<User> userByUsername = userRepository.findUserByUsername(username);
        if (userByUsername.isPresent())
            return verifyCredetials(username, password, userByUsername.get()) ? userByUsername.get() : null;
        return null;

    }


}
