package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.ClasseDTO;
import com.uasz.enseign.mappers.Maquette.ClasseMapper;
import com.uasz.enseign.model.Maquette.Classe;
import com.uasz.enseign.model.Maquette.Enseignement;
import com.uasz.enseign.model.Maquette.Formation;
import com.uasz.enseign.model.Maquette.Semestre;
import com.uasz.enseign.repository.Maquette.ClasseRepository;
import com.uasz.enseign.services.Maquette.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClasseServiceImpl implements ClasseService {

    private final ClasseRepository classeRepository;
    private final ClasseMapper classeMapper;

    @Autowired
    public ClasseServiceImpl(ClasseRepository classeRepository, ClasseMapper classeMapper) {
        this.classeRepository = classeRepository;
        this.classeMapper = classeMapper;
    }

    @Override
    public List<ClasseDTO> getAllClasses() {
        return classeRepository.findAll().stream()
                .map(ClasseMapper.INSTANCE::classeToClasseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClasseDTO getClasseById(Long id) {
        return classeRepository.findById(id)
                .map(ClasseMapper.INSTANCE::classeToClasseDTO)
                .orElse(null);
    }
    @Override
    public ClasseDTO createClasse(ClasseDTO classeDTO) {
        Classe classe = ClasseMapper.INSTANCE.classeDTOToClasse(classeDTO);
        classe = classeRepository.save(classe);
        return ClasseMapper.INSTANCE.classeToClasseDTO(classe);
    }

    @Override
    public ClasseDTO updateClasse(Long id, ClasseDTO classeDTO) {
        Classe existingClasse = classeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classe not found with id: " + id));

        // Update existingClasse properties with values from classeDTO
        existingClasse.setLibelle(classeDTO.getLibelle());
        existingClasse.setEffectif(classeDTO.getEffectif());
        existingClasse.setDescription(classeDTO.getDescription());

        existingClasse = classeRepository.save(existingClasse);

        return ClasseMapper.INSTANCE.classeToClasseDTO(existingClasse);
    }

    @Override
    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }

    @Override
    public List<ClasseDTO> getClassesBySemestreId(Long semestreId) {
        Semestre semestre = new Semestre(); // Créez une instance de Semestre avec l'ID fourni
        List<Classe> classes = classeRepository.findBySemestre(semestre);
        return classes.stream()
                .map(classeMapper::classeToClasseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClasseDTO> getClassesByFormationId(Long formationId) {
        Formation formation = new Formation(); // Créez une instance de Formation avec l'ID fourni
        List<Classe> classes = classeRepository.findByFormation(formation);
        return classes.stream()
                .map(classeMapper::classeToClasseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClasseDTO> getClassesByEnseignementId(Long enseignementId) {
        Enseignement enseignement = new Enseignement(); // Créez une instance de Enseignement avec l'ID fourni
        List<Classe> classes = classeRepository.findByEnseignement(enseignement);
        return classes.stream()
                .map(classeMapper::classeToClasseDTO)
                .collect(Collectors.toList());
    }
}