package com.uasz.enseign.dto.Repartition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class VacataireDTO extends EnseignantDTO {
    private String specialite;
    private String contrat;
    private int heuresEnseignement;
}
