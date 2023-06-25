package com.example.bankSystem.repositories;

import com.example.bankSystem.models.bankModels.RstrList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RstrListRepository extends JpaRepository<RstrList,Long> {
}
