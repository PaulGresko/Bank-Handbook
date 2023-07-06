package com.example.bankSystem.repositories;

import com.example.bankSystem.models.Handbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface HandbookRepository extends JpaRepository<Handbook, Long> {

    @Query(value = "select * from handbook where type = :type " +
            "and deleted = :deleted " +
            "and (code like %:code% ) " +
            "and (title like %:title% ) " +
            "and (:date IS NULL or (( valid_from IS NULL OR valid_from <= :date) \n" +
            " AND (valid_until IS NULL OR valid_until >= :date)))",
            nativeQuery = true)
   // List<Handbook> findByCategory(String type, Boolean deleted, String code, String title, LocalDate date);
    Page<Handbook> findByCategory(Pageable pageable, String type, Boolean deleted, String code, String title, LocalDate date);

    @Query(value = "select COUNT(*) from handbook where type = :type " +
            "and deleted = :deleted " +
            "and (code like %:code% ) " +
            "and (title like %:title% ) " +
            "and (:date IS NULL or (( valid_from IS NULL OR valid_from <= :date) \n" +
            " AND (valid_until IS NULL OR valid_until >= :date)))",
            nativeQuery = true)
    Long getCountByCategory(String type, Boolean deleted, String code, String title, LocalDate date);
}
