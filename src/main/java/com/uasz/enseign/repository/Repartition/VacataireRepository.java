package com.uasz.enseign.repository.Repartition;

import com.uasz.enseign.dto.Repartition.VacataireDTO;
import com.uasz.enseign.model.Repartition.Vacataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VacataireRepository extends JpaRepository<Vacataire, Long> {

}
