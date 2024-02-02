package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.SemestreDTO;
import com.uasz.enseign.mappers.Maquette.SemestreMapper;
import com.uasz.enseign.model.Maquette.Semestre;
import com.uasz.enseign.repository.Maquette.SemestreRepository;
import com.uasz.enseign.repository.Maquette.ClasseRepository;
import com.uasz.enseign.repository.Maquette.ModuleRepository;
import com.uasz.enseign.services.Maquette.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SemestreServiceImpl implements SemestreService {

    private final SemestreRepository semestreRepository;
    private final SemestreMapper semestreMapper;
    private final ClasseRepository classeRepository;
    private final ModuleRepository moduleRepository;

    @Autowired
    public SemestreServiceImpl(
            SemestreRepository semestreRepository,
            SemestreMapper semestreMapper,
            ClasseRepository classeRepository,
            ModuleRepository moduleRepository) {
        this.semestreRepository = semestreRepository;
        this.semestreMapper = semestreMapper;
        this.classeRepository = classeRepository;
        this.moduleRepository = moduleRepository;
    }
        @Override
        public List<SemestreDTO> getAllSemestres () {
            List<Semestre> semestres = semestreRepository.findAll();
            return semestres.stream()
                    .map(semestreMapper::semestreToSemestreDTO)
                    .collect(Collectors.toList());
        }

        @Override
        public SemestreDTO getSemestreById (Long id){
            Semestre semestre = semestreRepository.findById(id).orElse(null);
            return (semestre != null) ? semestreMapper.semestreToSemestreDTO(semestre) : null;
        }

        @Override
        public SemestreDTO createSemestre (SemestreDTO semestreDTO){
            Semestre semestre = semestreMapper.semestreDTOToSemestre(semestreDTO);
            Semestre savedSemestre = semestreRepository.save(semestre);
            return semestreMapper.semestreToSemestreDTO(savedSemestre);
        }

        @Override
        public SemestreDTO updateSemestre (Long id, SemestreDTO semestreDTO){
            if (semestreRepository.existsById(id)) {
                semestreDTO.setId(id);
                Semestre semestre = semestreMapper.semestreDTOToSemestre(semestreDTO);
                Semestre updatedSemestre = semestreRepository.save(semestre);
                return semestreMapper.semestreToSemestreDTO(updatedSemestre);
            }
            return null;
        }

        @Override
        public void deleteSemestre (Long id){
            semestreRepository.deleteById(id);
        }

        @Override
        public List<SemestreDTO> getSemestresByClasseId(Long classeId) {
            List<Semestre> semestres = semestreRepository.findByClasse(classeRepository.findById(classeId).orElse(null));
            return semestres.stream()
                    .map(semestreMapper::semestreToSemestreDTO)
                    .collect(Collectors.toList());
        }

        @Override
        public List<SemestreDTO> getSemestresByModuleId(Long moduleId) {
            List<Semestre> semestres = semestreRepository.findByModule(moduleRepository.findById(moduleId).orElse(null));
            return semestres.stream()
                    .map(semestreMapper::semestreToSemestreDTO)
                    .collect(Collectors.toList());
        }
    }
