package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.ECDTO;
import com.uasz.enseign.mappers.Maquette.ECMapper;
import com.uasz.enseign.model.Maquette.EC;
import com.uasz.enseign.repository.Maquette.ECRepository;
import com.uasz.enseign.services.Maquette.ECService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ECServiceImpl implements ECService {

    private final ECRepository ecRepository;
    private final ECMapper ecMapper;

    @Autowired
    public ECServiceImpl(ECRepository ecRepository, ECMapper ecMapper) {
        this.ecRepository = ecRepository;
        this.ecMapper = ecMapper;
    }

    @Override
    public List<ECDTO> getAllECs() {
        List<EC> ecList = ecRepository.findAll();
        return ecMapper.ecListToECDTOList(ecList);
    }

    @Override
    public ECDTO getECById(Long id) {
        Optional<EC> ecOptional = ecRepository.findById(id);
        return ecOptional.map(ecMapper::ecToEcDTO).orElse(null);
    }

    @Override
    public ECDTO createEC(ECDTO ecDTO) {
        EC ec = ecMapper.ecDTOToEC(ecDTO);
        EC savedEC = ecRepository.save(ec);
        return ecMapper.ecToEcDTO(savedEC);
    }

    @Override
    public ECDTO updateEC(Long id, ECDTO ecDTO) {
        Optional<EC> ecOptional = ecRepository.findById(id);

        if (ecOptional.isPresent()) {
            EC ec = ecMapper.ecDTOToEC(ecDTO);
            ec.setId(id);
            EC updatedEC = ecRepository.save(ec);
            return ecMapper.ecToEcDTO(updatedEC);
        } else {
            return null; // EC with the given ID not found
        }
    }

    @Override
    public void deleteEC(Long id) {
        ecRepository.deleteById(id);
    }
    @Override
    public List<ECDTO> getECsByUeId(Long ueId) {
        List<EC> ecList = ecRepository.findByUeId(ueId);
        return ecMapper.ecListToECDTOList(ecList);
    }

    @Override
    public List<ECDTO> getECsByModuleId(Long moduleId) {
        List<EC> ecList = ecRepository.findByModuleId(moduleId);
        return ecMapper.ecListToECDTOList(ecList);
    }

    @Override
    public List<ECDTO> getECsBySemestreId(Long semestreId) {
        List<EC> ecList = ecRepository.findBySemestre_Id(semestreId);
        return ecMapper.ecListToECDTOList(ecList);
    }
}
