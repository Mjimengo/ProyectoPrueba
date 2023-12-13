package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.NoSuchElementException;

@ApplicationScoped
public class ClientRepository implements  PanacheRepository<Client> {

    public List<Client> searchEmployee() {
        List<Client> resultList = find("id_rol", 2).list();
        if (resultList.isEmpty()) {
            throw new NoSuchElementException("No se encontraron empleados.");
        }
        return resultList;
    }

    public List<Client> searchBoss() {
        List<Client> resultList = find("id_rol", 1).list();
        if (resultList.isEmpty()) {
            throw new NoSuchElementException("No se encontraron Jefes.");
        }
        return resultList;
    }


    public Client saveClient(Client client){
        Client newClient = new Client();
        newClient.setName(client.getName());
        newClient.setSurname(client.getSurname());
        newClient.setId_rol(client.getId_rol());

        persist(newClient);

        return newClient;
    }

}
