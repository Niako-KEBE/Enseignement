package com.uasz.enseign.serviceImpl.Repartition;

import com.uasz.enseign.dto.Repartition.RepartitionDTO;
import com.uasz.enseign.mappers.Repartition.RepartitionMapper;
import com.uasz.enseign.model.Repartition.Repartition;
import com.uasz.enseign.repository.Repartition.RepartitionRepository;
import com.uasz.enseign.services.Repartition.RepartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RepartitionServiceImpl implements RepartitionService {

    private final RepartitionRepository repartitionRepository;
    private final RepartitionMapper repartitionMapper;

    @Autowired
    public RepartitionServiceImpl(RepartitionRepository repartitionRepository, RepartitionMapper repartitionMapper) {
        this.repartitionRepository = repartitionRepository;
        this.repartitionMapper = repartitionMapper;
    }

    @Override
    public List<RepartitionDTO> getAllRepartitions() {
        List<Repartition> repartitions = repartitionRepository.findAll();
        return repartitions.stream()
                .map(repartitionMapper::repartitionToRepartitionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RepartitionDTO getRepartitionById(Long id) {
        Optional<Repartition> repartition = repartitionRepository.findById(id);
        return repartition.map(repartitionMapper::repartitionToRepartitionDTO).orElse(null);
    }

    @Override
    public RepartitionDTO createRepartition(RepartitionDTO repartitionDTO) {
        Repartition repartition = repartitionMapper.repartitionDTOToRepartition(repartitionDTO);
        Repartition savedRepartition = repartitionRepository.save(repartition);
        return repartitionMapper.repartitionToRepartitionDTO(savedRepartition);
    }

    @Override
    public RepartitionDTO updateRepartition(Long id, RepartitionDTO repartitionDTO) {
        Optional<Repartition> existingRepartition = repartitionRepository.findById(id);

        if (existingRepartition.isPresent()) {
            Repartition repartition = existingRepartition.get();
            repartitionMapper.updateRepartitionFromDTO(repartitionDTO, repartition);
            Repartition updatedRepartition = repartitionRepository.save(repartition);
            return repartitionMapper.repartitionToRepartitionDTO(updatedRepartition);
        }

        return null; // Handle the case where the Repartition with the given id is not found
    }

    @Override
    public void deleteRepartition(Long id) {
        repartitionRepository.deleteById(id);
    }
}
