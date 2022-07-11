package br.edu.ifg.luziania.bsi.pw.aula05.model;

import javax.enterprise.context.Dependent;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Dependent
public class Util {

    @Context
    ServletContext servletContextInjetado;

    public FileInputStream getFile(String filename, ServletContext servletContext) {
        try {
            String base = servletContext.getRealPath("/WEB-INF/classes/view");
            File f = new File(String.format("%s/%s", base, filename));
            return new FileInputStream(f);
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
