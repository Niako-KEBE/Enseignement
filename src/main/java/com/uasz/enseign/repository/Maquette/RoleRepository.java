package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.model.Maquette.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    //@Query(value = "SELECT r FROM RoleDto r WHERE r.name = ?1")
    @Query(value = "SELECT * FROM roles r WHERE r.nom = ?1",nativeQuery = true)
    Role findByNom(String roles);

    @Query(value = "SELECT * FROM roles r WHERE r.nom = ?1",nativeQuery = true)
    Role findByNames(String roles);

    Role findByid(Long roleId);
}
