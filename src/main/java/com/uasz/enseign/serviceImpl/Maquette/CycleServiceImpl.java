package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.CycleDTO;
import com.uasz.enseign.mappers.Maquette.CycleMapper;
import com.uasz.enseign.model.Maquette.Cycle;
import com.uasz.enseign.repository.Maquette.CycleRepository;
import com.uasz.enseign.services.Maquette.CycleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CycleServiceImpl implements CycleService {

    private final CycleRepository cycleRepository;
    private final CycleMapper cycleMapper;

    public CycleServiceImpl(CycleRepository cycleRepository, CycleMapper cycleMapper) {
        this.cycleRepository = cycleRepository;
        this.cycleMapper = cycleMapper;
    }

    @Override
    public List<CycleDTO> getAllCycles() {
        List<Cycle> cycles = cycleRepository.findAll();
        return cycles.stream()
                .map(cycleMapper::cycleToCycleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CycleDTO getCycleById(Long id) {
        Optional<Cycle> cycle = cycleRepository.findById(id);
        return cycle.map(cycleMapper::cycleToCycleDTO).orElse(null);
    }

    @Override
    public CycleDTO createCycle(CycleDTO cycleDTO) {
        Cycle cycle = cycleMapper.cycleDTOToCycle(cycleDTO);
        cycle = cycleRepository.save(cycle);
        return cycleMapper.cycleToCycleDTO(cycle);
    }

    @Override
    public CycleDTO updateCycle(Long id, CycleDTO cycleDTO) {
        Optional<Cycle> existingCycle = cycleRepository.findById(id);
        if (existingCycle.isPresent()) {
            Cycle updatedCycle = cycleMapper.cycleDTOToCycle(cycleDTO);
            updatedCycle.setId(existingCycle.get().getId());
            updatedCycle = cycleRepository.save(updatedCycle);
            return cycleMapper.cycleToCycleDTO(updatedCycle);
        } else {
            // Handle non-existing cycle
            return null;
        }
    }

    @Override
    public void deleteCycle(Long id) {
        cycleRepository.deleteById(id);
    }
}
