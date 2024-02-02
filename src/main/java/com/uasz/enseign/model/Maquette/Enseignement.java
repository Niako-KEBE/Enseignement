package com.uasz.enseign.model.Maquette;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name = "enseignement")

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String description;

    @ManyToOne
    private Classe classe;

    @ManyToOne
    private Groupe groupe;
    //
//    private List<Module> modules;

    @ManyToOne
    @JoinColumn(name = "module_id") // Assurez-vous que le nom ici correspond à la colonne de clé étrangère dans la table Enseignement
    private Module module;
}
