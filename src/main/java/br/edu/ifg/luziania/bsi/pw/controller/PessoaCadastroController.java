package br.edu.ifg.luziania.bsi.pw.controller;

import br.edu.ifg.luziania.bsi.pw.model.dto.PessoaDTO;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pessoa")
public class PessoaCadastroController {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance cadastro();
    }

    @GET
    @Path("cadastro")
    public TemplateInstance getHTMLFile(){
        return Templates.cadastro();
    }


    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(PessoaDTO dto){
        return Response.ok().build();
    }

}
