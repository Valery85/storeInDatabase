package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

        private AccountService accountService;

        public SignInServlet(AccountService accountService){
            this.accountService = accountService;
        }

    public void doPost (HttpServletRequest request,
                        HttpServletResponse response) throws IOException {

       String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserProfile profile = accountService.getUserByLogin(login);

        if ((profile == null) || (!password.equals(profile.getPass())) ){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Unauthorized");
            return;

        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("Authorized: " + login);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}


//        if (accountService.getUserByLogin(login).getLogin().equals(login)  &&
//                (accountService.getUserByLogin(login).getPass().equals(password)) ){
//            response.getWriter().println("Authorized:" + login);
//        }
//        else {
//            response.getWriter().println("Unauthorized:");
//        }

//}
