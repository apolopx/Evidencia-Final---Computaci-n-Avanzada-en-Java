package com.mycompany.imcapp.resources;

import com.imc.dao.IMCDAO;
import com.imc.model.RegistroIMC;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.util.List;

@Path("imc")
public class IMCResource {

    @GET
    @Path("historial/{id}")
    @Produces("application/json")
    public List<RegistroIMC> obtenerHistorial(@PathParam("id") int idUsuario) {

        IMCDAO dao = new IMCDAO();

        return dao.obtenerHistorial(idUsuario);
    }
}
