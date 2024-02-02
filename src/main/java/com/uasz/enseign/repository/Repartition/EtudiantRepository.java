//package com.uasz.enseign.repository.Repartition;
//
//import com.uasz.enseign.entities.Repartition.Etudiant;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {
//
//    @Query("SELECT e FROM Etudiant e WHERE e.id = :etudiantId")
//    Optional<Etudiant> findById(Long etudiantId);
//
//    @Query("SELECT e FROM Etudiant e WHERE e.nom = :nom")
//    List<Etudiant> findByNom(String nom);
//
//    @Query("SELECT e FROM Etudiant e WHERE e.prenom = :prenom")
//    List<Etudiant> findByPrenom(String prenom);
//
//
//}
