package com.example.bankSystem.repositories;

import com.example.bankSystem.models.AccRstrList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccRstrListRepository extends JpaRepository<AccRstrList, Long> {
}
