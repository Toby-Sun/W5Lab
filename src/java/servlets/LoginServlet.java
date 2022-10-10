package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;
import models.User;

/**
 *
 * @author tobys
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if (session.getAttribute("logout") != null && session.getAttribute("user") != null) {
            request.setAttribute("logoutMessage", true);
            session.invalidate();
            session = request.getSession();
        }
        else if (session.getAttribute("user") != null) {
            response.sendRedirect("home");
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        User my_user = new AccountService().login(username, password);
        request.setAttribute("username", username);
        

        if (my_user == null) {
            request.setAttribute("invalidInput", true);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        session.setAttribute("user", my_user);
        response.sendRedirect("home");
        return;

    }

}
