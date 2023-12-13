package org.acme.Roles;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/roles")
@Transactional
public class RolesResource {

    @Inject
    private RolesRepository repo;


    @GET
    public List<Roles> index(){
        return repo.listAll();
    }

    @GET
    @Path("/searchAdmin")
    public List<Roles> searchAdmin() {
        return repo.searchAdmin();
    }



    @GET
    @Path("/searchEmployee")
    public List<Roles> searchEmployee() {
        return repo.searchGestion();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveRol(Roles rol) {
        repo.saveRol(rol);
        return Response.ok("El rol fue añadido").build();
    }
}


