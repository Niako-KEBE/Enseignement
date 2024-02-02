package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.ClasseDTO;
import java.util.List;

public interface ClasseService {

    List<ClasseDTO> getAllClasses();

    ClasseDTO getClasseById(Long id);

    ClasseDTO createClasse(ClasseDTO classeDTO);

    ClasseDTO updateClasse(Long id, ClasseDTO classeDTO);

    void deleteClasse(Long id);

    List<ClasseDTO> getClassesBySemestreId(Long semestreId);

    List<ClasseDTO> getClassesByFormationId(Long formationId);

    List<ClasseDTO> getClassesByEnseignementId(Long enseignementId);

}
