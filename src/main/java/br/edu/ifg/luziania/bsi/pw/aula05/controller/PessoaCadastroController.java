package br.edu.ifg.luziania.bsi.pw.aula05.controller;

import br.edu.ifg.luziania.bsi.pw.aula05.model.Util;
import br.edu.ifg.luziania.bsi.pw.aula05.model.dto.PessoaDTO;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@Path("pessoa")
public class PessoaCadastroController {

    @Context
    ServletContext servletContext;

    @GET
    @Path("cadastro")
    public InputStream getHTMLFile(){
        return (new Util()).getFile("pessoa/cadastro.html", servletContext);
    }

    @GET
    @Path("cadastro/js/{file}")
    public InputStream getJSFile(@PathParam("file") String file){
        return (new Util()).getFile("pessoa/js/"+file, servletContext);
    }

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(PessoaDTO dto){
        return Response.ok().build();
    }

}
