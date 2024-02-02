package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.GroupeDTO;
import com.uasz.enseign.mappers.Maquette.GroupeMapper;
import com.uasz.enseign.model.Maquette.Groupe;
import com.uasz.enseign.model.Maquette.Classe;
import com.uasz.enseign.repository.Maquette.GroupeRepository;
import com.uasz.enseign.services.Maquette.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupeServiceImpl implements GroupeService {

    private final GroupeRepository groupeRepository;
    private final GroupeMapper groupeMapper;

    @Autowired
    public GroupeServiceImpl(GroupeRepository groupeRepository, GroupeMapper groupeMapper) {
        this.groupeRepository = groupeRepository;
        this.groupeMapper = groupeMapper;
    }

    @Override
    public List<GroupeDTO> getAllGroupes() {
        List<Groupe> groupeList = groupeRepository.findAll();
        return groupeMapper.groupeListToGroupeDTOList(groupeList);
    }

    @Override
    public GroupeDTO getGroupeById(Long id) {
        Optional<Groupe> groupeOptional = groupeRepository.findById(id);
        return groupeOptional.map(groupeMapper::groupeToGroupeDTO).orElse(null);
    }

    @Override
    public GroupeDTO createGroupe(GroupeDTO groupeDTO) {
        Groupe groupe = groupeMapper.groupeDTOToGroupe(groupeDTO);
        Groupe savedGroupe = groupeRepository.save(groupe);
        return groupeMapper.groupeToGroupeDTO(savedGroupe);
    }

    @Override
    public GroupeDTO updateGroupe(Long id, GroupeDTO groupeDTO) {
        Optional<Groupe> groupeOptional = groupeRepository.findById(id);

        if (groupeOptional.isPresent()) {
            Groupe groupe = groupeMapper.groupeDTOToGroupe(groupeDTO);
            groupe.setId(id); // Set the ID to update the existing entity
            Groupe updatedGroupe = groupeRepository.save(groupe);
            return groupeMapper.groupeToGroupeDTO(updatedGroupe);
        } else {
            return null; // Groupe with the given ID not found
        }
    }

    @Override
    public void deleteGroupe(Long id) {
        groupeRepository.deleteById(id);
    }

    @Override
    public List<GroupeDTO> getGroupesByClasseId(Long classeId) {
        Classe classe = new Classe();
        classe.setId(classeId);
        List<Groupe> groupeList = groupeRepository.findByClasse(classe);
        return groupeMapper.groupeListToGroupeDTOList(groupeList);
    }
}
