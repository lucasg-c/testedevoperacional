import java.util.List;
import java.util.Optional;

public class Authentication {
    List<User> userList;

    public Authentication(List<User> userList) {
        this.userList = userList;
    }

    public Optional<User> authenticate(String username, String password) {
        Optional<User> optionalUser = userList.stream().filter(u -> u.getUsername().equals(username))
                .findAny();

        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
            return optionalUser;
        } else {
            return Optional.empty();
        }
    }
}
