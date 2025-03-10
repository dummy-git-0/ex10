package org.example.ex10;

import java.io.*;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String nickname;
//    private String message;

    //    public void init() {
//        message = "Hello World!";
//    }
    public void init() {
        Dotenv dotenv = Dotenv.load();
        nickname = dotenv.get("NICKNAME");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + nickname + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
// 이름(name)과 경로(value, path)를 지정
