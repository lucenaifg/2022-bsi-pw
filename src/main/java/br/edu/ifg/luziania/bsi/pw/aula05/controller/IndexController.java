package br.edu.ifg.luziania.bsi.pw.aula05.controller;

import br.edu.ifg.luziania.bsi.pw.aula05.model.Util;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import java.io.InputStream;

@Path("aula05")
public class IndexController {

    @Context
    ServletContext servletContext;

    @GET
    @Path("")
    public InputStream getIndexHTML(){
        Util util = new Util();
        return util.getFile("index.html", servletContext);
    }
}
