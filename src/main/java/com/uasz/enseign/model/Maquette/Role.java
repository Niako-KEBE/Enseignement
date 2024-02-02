package com.uasz.enseign.model.Maquette;

import com.uasz.enseign.model.Utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", unique = true, nullable = false)
    private String nom;

    @Column(name = "description")
    private String description;

    // Dans la classe Role
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")  // Assurez-vous que "utilisateur_id" est la colonne correcte
    private Utilisateur utilisateur;
}
