package login;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {
    @EJB
    UserManagerLocal manager;
    User user1 = new User("Peter123", "jesuslever");

    public void makeMongo(){
        manager.saveUser(user1);
    }

    private void authenticate() throws IOException {
        User heisann = manager.getUser(1);
        if(heisann.getPassword().contains(user1.getPassword())){
            System.out.println("Hei peter din mongopikk");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        makeMongo();
        authenticate();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        makeMongo();
        authenticate();
    }
}
