package com.example.bankSystem.repositories;

import com.example.bankSystem.models.bankModels.BICDirectoryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BICDirectoryEntryRepository extends JpaRepository<BICDirectoryEntry,Long> {
}
