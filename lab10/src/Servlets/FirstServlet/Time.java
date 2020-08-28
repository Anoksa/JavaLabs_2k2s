package Servlets.FirstServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Enumeration;

@WebServlet(name = "Time", urlPatterns = {"/Time"})
public class Time extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>FirstServlet</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1 style=\"text-align: center;\">Текущее время " + LocalTime.now() + "</h1>");
            writer.println("<p style=\"background: plum\">Версия и номер протокола " + "<b>" + request.getProtocol() + "</b>" + "</p>");
            writer.println("<p style=\"background: pink\">IP-адреса клиента, от имени которого пришел запрос и его имя " + "<b>" + request.getRemoteAddr() + "  " + request.getRemoteUser() + "</b>" + "</p>");
            writer.println("<p style=\"background: pink\">Имя метода доступа к ресурсам, на основе которого построен запрос " + "<b>" + request.getMethod() + "</b>" + "</p>");
            writer.println("<p style=\"background: black\"><font color=\"white\">URL-адрес, который клиент использовал для выполнения запроса " + "<b>" + request.getRequestURL() + "</b>" + "</font></p>");
            writer.println("<p style=\"background: plum\">часть URL-адреса этого запроса, которая вызывает сервлет " + "<b>" + request.getServletPath() + "</b>" + "</p>");
            writer.println("<p style=\"background: plum\">Возвращает любую дополнительную информацию о пути, связанную с URL-адрес, который клиент отправил при выполнении этого запроса " + "<b>" + request.getPathInfo() + "</b>" + "</p>");
            writer.println("<p style=\"background: pink\">Информация о заголовках");
            Enumeration<String> headerNames = request.getHeaderNames();
            while(headerNames.hasMoreElements()){
                String name = headerNames.nextElement();
                String headerValues = request.getHeader(name);
                writer.println(name + ":  " + headerValues);
            }
            writer.println("</p>");
            writer.println("<img src=\"https://i.pinimg.com/564x/12/b3/69/12b369ca10c732ef798fd464f8695e01.jpg\"></img>");
            writer.println("</body>");
            writer.println("</html>");
        } finally {
            writer.close();
        }
    }
}
