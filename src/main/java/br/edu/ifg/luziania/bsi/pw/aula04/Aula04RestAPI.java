package br.edu.ifg.luziania.bsi.pw.aula04;

import br.edu.ifg.luziania.bsi.pw.aula02.Pessoa;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Random;

import static java.util.Objects.isNull;

@Path("aula04")
public class Aula04RestAPI {

    @Context
    ServletContext servletContext;

    private FileInputStream getFile(String filename) {
        try {
            String base = servletContext.getRealPath("/WEB-INF/classes/frontend");
            File f = new File(String.format("%s/%s", base, filename));
            return new FileInputStream(f);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    @GET
    @Path("")
    @Produces("text/html")
    public InputStream getHTML() throws URISyntaxException, IOException {
        return getFile("aula04.html");
    }

    @POST
    @Path("save")
    @Produces("application/json")
    @Consumes("application/json")
    public Response save(Pessoa pessoa, @Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        pessoa.setId((new Random()).nextInt());
        if (isNull(session.getAttribute("pessoa")))
            session.setAttribute("pessoa", pessoa);
        return Response.ok(pessoa).build();
    }

}
