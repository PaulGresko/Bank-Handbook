package com.example.bankSystem.repositories;

import com.example.bankSystem.models.bankModels.AccRstrList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccRstrListRepository extends JpaRepository<AccRstrList, Long> {
    List<AccRstrList> findAllByAccountId(Long id);
}
