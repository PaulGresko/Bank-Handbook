package com.example.bankSystem.repositories;

import com.example.bankSystem.models.bankModels.Swbics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwbicsRepository extends JpaRepository<Swbics,Long> {
}
