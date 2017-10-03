package login;

import javax.ejb.Local;

@Local
public interface UserManagerLocal {
    User getUser(long id);
    void saveUser(User u);
}
