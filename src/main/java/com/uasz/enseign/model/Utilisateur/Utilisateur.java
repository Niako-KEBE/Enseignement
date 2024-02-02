//package com.uasz.enseign.model.Utilisateur;
//
//import java.util.List;
//
//import com.uasz.enseign.model.Maquette.UE;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.management.relation.Relation;
//@Table( name = "utilisateur")
//@Entity
//@Data @NoArgsConstructor @AllArgsConstructor
//public class Utilisateur {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String nom;
//    private String prenom;
//    private String role;
//    @OneToMany(mappedBy = "utilisateur")
//   private List<UE> ues;
//}




package com.uasz.enseign.model.Utilisateur;

import com.uasz.enseign.model.Maquette.Role;
import jakarta.persistence.*;
import com.uasz.enseign.model.Maquette.UE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;

    // Dans la classe Utilisateur
    @OneToMany(mappedBy = "utilisateur")  // Assurez-vous que "utilisateur" est la propriété correcte
    private List<Role> roles;

    @OneToMany(mappedBy = "utilisateur")
    private List<UE> ues;

    public void setRole(String role) {
    }
}







