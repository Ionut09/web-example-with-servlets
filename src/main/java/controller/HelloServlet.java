package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = {"/hello"}, loadOnStartup = 1,
        initParams = {@WebInitParam(
                name = "name",
                value = "Johnny"
        )})
public class HelloServlet extends HttpServlet {

    //private HelloService helloService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getInitParameter("name");
        response.getWriter().print("Hello " + name + "!!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");

        String lastName = request.getParameter("lastName");

        String fullName = firstName + " " + lastName;

        request.setAttribute("fullName", fullName);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
