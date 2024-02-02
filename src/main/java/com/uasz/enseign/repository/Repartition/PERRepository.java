package com.uasz.enseign.repository.Repartition;
import com.uasz.enseign.dto.Repartition.PERDTO;
import com.uasz.enseign.model.Repartition.PER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PERRepository extends JpaRepository<PER, Long> {
}
