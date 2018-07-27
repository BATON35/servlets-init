package pl.sda.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("INIT");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<div>");
        req.getParameterMap().entrySet()
                .forEach(x -> writer.println("<p>" + x.getKey() + " - " + Arrays.toString(x.getValue()) + "</p>"));
        writer.println("</div>");
        writer.println("</html>");
    }

    @Override
    public void destroy() {
        System.out.println("DESTROY");
    }
}

