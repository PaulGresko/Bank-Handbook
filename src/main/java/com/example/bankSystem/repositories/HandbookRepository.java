package com.example.bankSystem.repositories;

import com.example.bankSystem.enums.HandbookType;
import com.example.bankSystem.models.Handbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface HandbookRepository extends JpaRepository<Handbook,Long> {
    Page<Handbook> findAllByTypeAndDeleted(HandbookType type, Pageable pageable, Boolean deleted);
    Long countByType(HandbookType type);

}
