package org.acme;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.NoSuchElementException;

@Path("/users")
@Transactional
public class ClientResource {


    @Inject
    private ClientRepository repo;


    @GET
    public List<Client> index(){
        return repo.listAll();
    }

    @GET
    @Path("/searchEmployee")
    public List<Client> searchByEmployee() {
        return repo.searchEmployee();
    }

    @GET
    @Path("/searchBoss")
    public List<Client> searchBoss() {
        return repo.searchBoss();
    }

    @GET
    @Path("{id}")
    public Client getById(@PathParam("id") Long id){
        var client = repo.findById(id);
        if (client != null){
            return client;
        }
      throw new NoSuchElementException("No existe el id "+id);
    }
    @GET
    @Path("/name")
    public List<Client> searchByName(@QueryParam("name")  String name, @QueryParam("surname")  String surname){
        if (name == null) {
            return repo.listAll();
        } else {
            return repo.list("name LIKE ?1 and surname LIKE ?2", name, surname);
        }
    }




    @GET
    @Path("/address")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Client> getAddress(@QueryParam("a") String query){
        if(query == null){
            throw new QueryParameterMissingException("Es necesario introducir una dirección");
        }else{
            String filter = "%" + query + "%";
            return repo.list("address ILIKE ?1", filter);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveClient(Client client) {
        repo.saveClient(client);
        return Response.ok("El empleado ha sido añadido").build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id) {
        if (repo.deleteById(id)) {
            return Response.ok("El empleado con id " + id + " se ha borrado correctamente").build();
        } else {
            throw new NotFoundException("No existe el id " + id);
        }
    }
}
