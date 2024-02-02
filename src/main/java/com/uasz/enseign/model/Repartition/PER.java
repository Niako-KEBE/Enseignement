package com.uasz.enseign.model.Repartition;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PER")
public class PER extends Enseignant {
    private String matricule;
    private String specialite;

    public void setStatut(String statut) {
    }

    public void setAnciennete(int anciennete) {
    }
}
