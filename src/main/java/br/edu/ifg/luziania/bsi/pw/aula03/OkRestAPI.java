package br.edu.ifg.luziania.bsi.pw.aula03;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("ok")
public class OkRestAPI {

    @GET
    @Path("")
    @Produces("text/plain")
    public Response getOk() {
        return Response.ok("OK").build();
    }

    @GET
    @Path("{nome}")
    @Produces("text/plain")
    public Response getOk(@PathParam("nome") String nome) {
        return Response.ok(nome).build();
    }

    @GET
    @Path("{nome}/{sobrenome}")
    @Produces("text/plain")
    public Response getOk(@PathParam("nome") String nome, @PathParam("sobrenome") String qualquer) {
        return Response.ok(nome + " "+qualquer).build();
    }
}
