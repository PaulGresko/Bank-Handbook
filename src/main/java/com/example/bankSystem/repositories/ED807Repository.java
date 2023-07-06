package com.example.bankSystem.repositories;

import com.example.bankSystem.models.bankModels.ED807;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;


@Repository
public interface ED807Repository extends JpaRepository<ED807, Long> {

    @Query(value = "select * from ED807\n" +
            "where (title LIKE %:title%) \n" +
            "AND deleted = :deleted "+
            "AND(:date1 IS NULL OR created_date >= :date1)\n" +
            "AND (:date2 IS NULL OR created_date <= :date2)",
        nativeQuery = true)
    Page<ED807> findByCategory(Pageable page, String title, Boolean deleted, LocalDate date1, LocalDate date2);

    @Query(value = "select COUNT(*) from ED807\n" +
            "where (title LIKE %:title%) \n " +
            "AND deleted = :deleted "+
            "AND(:date1 IS NULL OR created_date >= :date1)\n" +
            "AND (:date2 IS NULL OR created_date <= :date2)",
            nativeQuery = true)
    Long getCountByCategory(String title, Boolean deleted, LocalDate date1, LocalDate date2);
}
