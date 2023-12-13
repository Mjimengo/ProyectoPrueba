package org.acme.Roles;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.NoSuchElementException;

@ApplicationScoped
public class RolesRepository implements PanacheRepository<Roles>{

        public List<Roles> searchAdmin() {
        List<Roles> resultList = find("id_rol",1).list();
        if (resultList.isEmpty()) {
            throw new NoSuchElementException("No se encontraron roles.");
        }
        return resultList;
    }

    public List<Roles> searchGestion() {
        List<Roles> resultList = find("id_rol",2).list();
        if (resultList.isEmpty()) {
            throw new NoSuchElementException("No se encontraron roles.");
        }
        return resultList;
    }


    public Roles saveRol(Roles roles){
        Roles newRoles = new Roles();
        newRoles.setId_rol(roles.getId_rol());
        newRoles.setDepartment(roles.getDepartment());
        newRoles.setHollidays(roles.getHollidays());
        newRoles.setName_rol(roles.getName_rol());
        newRoles.setSalary(roles.getSalary());

        persist(newRoles);

        return newRoles;
    }

}
