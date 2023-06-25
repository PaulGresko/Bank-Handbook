package com.example.bankSystem.repositories;

import com.example.bankSystem.models.bankModels.SWBICS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SWBICSRepository extends JpaRepository<SWBICS,Long> {
}
