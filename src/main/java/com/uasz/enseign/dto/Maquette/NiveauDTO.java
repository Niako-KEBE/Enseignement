package com.uasz.enseign.dto.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NiveauDTO {
    private Long id;
    private String nom;
    private CycleDTO cycle;
    private List<FormationDTO> formations;
}
