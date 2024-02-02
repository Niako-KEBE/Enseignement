package com.uasz.enseign.services.Repartition;

import com.uasz.enseign.dto.Repartition.RepartitionDTO;

import java.util.List;

public interface RepartitionService {

    List<RepartitionDTO> getAllRepartitions();

    RepartitionDTO getRepartitionById(Long id);

    RepartitionDTO createRepartition(RepartitionDTO repartitionDTO);

    RepartitionDTO updateRepartition(Long id, RepartitionDTO repartitionDTO);

    void deleteRepartition(Long id);


}
