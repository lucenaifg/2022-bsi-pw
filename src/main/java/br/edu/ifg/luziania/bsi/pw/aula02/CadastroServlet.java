package br.edu.ifg.luziania.bsi.pw.aula02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Cadastro de Pessoa", value = "/aula02/cadastro")
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/aula02/cadastro.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Pessoa> pessoas = (List<Pessoa>) request.getSession().getAttribute("pessoas");

        if (pessoas == null)
            pessoas = new ArrayList<>();

        Pessoa pessoa = new Pessoa(
                request.getParameter("nome"),
                request.getParameter("telefone")
        );
        pessoas.add(pessoa);

        request.getSession().setAttribute("pessoas",pessoas);
        request.getSession().setAttribute("nome", pessoa.getNome());

        getServletContext()
                .getRequestDispatcher("/aula02/cadastro.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
