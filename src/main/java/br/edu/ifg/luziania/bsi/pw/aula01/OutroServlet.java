package br.edu.ifg.luziania.bsi.pw.aula01;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OutroServlet", value = "/aula01/outroservlet")
public class OutroServlet  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Aula 01 - Meu primeiro Servlet</h1>");
        out.println("<h2>Este é outro Servlet</h2>");
        out.println("<a href=\"/\">Voltar</a>");
        out.println("</body></html>");
    }
}