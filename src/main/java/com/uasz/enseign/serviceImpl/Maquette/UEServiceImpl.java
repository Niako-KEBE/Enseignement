package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.UEDTO;
import com.uasz.enseign.mappers.Maquette.UEMapper;
import com.uasz.enseign.model.Maquette.UE;
import com.uasz.enseign.repository.Maquette.UERepository;
import com.uasz.enseign.services.Maquette.UEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UEServiceImpl implements UEService {

    private final UERepository ueRepository;
    private final UEMapper ueMapper;

    @Autowired
    public UEServiceImpl(UERepository ueRepository, UEMapper ueMapper) {
        this.ueRepository = ueRepository;
        this.ueMapper = ueMapper;
    }

    @Override
    public List<UEDTO> getAllUEs() {
        List<UE> ues = ueRepository.findAll();
        return ues.stream().map(ueMapper::ueToUEDTO).collect(Collectors.toList());
    }

    @Override
    public UEDTO getUEById(Long id) {
        UE ue = ueRepository.findById(id).orElse(null);
        return ue != null ? ueMapper.ueToUEDTO(ue) : null;
    }

    @Override
    public UEDTO createUE(UEDTO ueDTO) {
        UE ue = ueMapper.ueDTOToUE(ueDTO);
        ue = ueRepository.save(ue);
        return ueMapper.ueToUEDTO(ue);
    }

    @Override
    public UEDTO updateUE(Long id, UEDTO ueDTO) {
        if (ueRepository.existsById(id)) {
            UE ue = ueMapper.ueDTOToUE(ueDTO);
            ue.setId(id);
            ue = ueRepository.save(ue);
            return ueMapper.ueToUEDTO(ue);
        }
        return null;
    }

    @Override
    public void deleteUE(Long id) {
        ueRepository.deleteById(id);
    }

    @Override
    public List<UEDTO> getUEsByUtilisateurId(Long utilisateurId) {
        List<UE> ues = ueRepository.findByUtilisateur_Id(utilisateurId);
        return ues.stream().map(ueMapper::ueToUEDTO).collect(Collectors.toList());
    }
}
