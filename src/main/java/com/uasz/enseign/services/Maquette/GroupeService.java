package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.GroupeDTO;

import java.util.List;

public interface GroupeService {

    List<GroupeDTO> getAllGroupes();

    GroupeDTO getGroupeById(Long id);

    GroupeDTO createGroupe(GroupeDTO groupeDTO);

    GroupeDTO updateGroupe(Long id, GroupeDTO groupeDTO);

    void deleteGroupe(Long id);

    List<GroupeDTO> getGroupesByClasseId(Long classeId);

}
