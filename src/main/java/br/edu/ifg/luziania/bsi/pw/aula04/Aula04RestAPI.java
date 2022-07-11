package br.edu.ifg.luziania.bsi.pw.aula04;

import br.edu.ifg.luziania.bsi.pw.aula02.Pessoa;
import br.edu.ifg.luziania.bsi.pw.aula05.model.Util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("aula04")
public class Aula04RestAPI {

    @Context
    ServletContext servletContext;

    @GET
    @Path("")
    @Produces("text/html")
    public InputStream getHTML() throws URISyntaxException, IOException {
        Util util = new Util();
        return util.getFile("aula04.html", servletContext);
    }

    @POST
    @Path("save")
    @Produces("application/json")
    @Consumes("application/json")
    public Response save(Pessoa pessoa, @Context HttpServletRequest request) {

        List<Pessoa> pessoas = (List<Pessoa>) request.getSession().getAttribute("pessoas");
        if (pessoas == null)
            pessoas = new ArrayList<>();

        //simulando persistencia criando ID randômico.
        pessoa.setId((new Random()).nextInt());
        pessoas.add(pessoa);
        request.getSession().setAttribute("pessoas",pessoas);
        return Response.ok(pessoa).build();
    }

    @GET
    @Path("list")
    @Produces("application/json")
    @Consumes("application/json")
    public Response list(@Context HttpServletRequest request) {
        return Response.ok((List<Pessoa>) request.getSession().getAttribute("pessoas")).build();
    }

}
