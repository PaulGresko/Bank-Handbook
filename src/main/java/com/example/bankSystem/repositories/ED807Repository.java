package com.example.bankSystem.repositories;

import com.example.bankSystem.models.bankModels.ED807;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ED807Repository extends JpaRepository<ED807, Long> {

    }
