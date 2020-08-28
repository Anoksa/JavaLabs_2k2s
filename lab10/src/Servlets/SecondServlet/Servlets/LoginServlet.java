package Servlets.SecondServlet.Servlets;

import Servlets.SecondServlet.Model.User;
import Servlets.SecondServlet.Model.UsersJson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String login = request.getParameter("login");
        String password = String.valueOf(request.getParameter("password").hashCode());
        PrintWriter writer = response.getWriter();
        try {
            UsersJson usersJson = new UsersJson();

            if(usersJson.checkUser(new User(login, password))) {
                writer.println("<img src=\"https://i.pinimg.com/originals/3b/d8/a8/3bd8a84fadadac395aaedad1fe6a5f50.gif\"></img>");
            }
            else {
                writer.println("Такого пользователя не существует или данные с ошибкой :(");
            }
        } finally {
            writer.println();
            writer.close();
        }
    }
}
