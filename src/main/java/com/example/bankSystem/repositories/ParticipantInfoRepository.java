package com.example.bankSystem.repositories;

import com.example.bankSystem.models.bankModels.ParticipantInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantInfoRepository extends JpaRepository<ParticipantInfo, Long> {

    @Query(value = "select participant_info.id, ed807_id, bic, name_p, engl_name, reg_n, cntr_cd," +
            " rgn, ind, tnp, nnp, adr, prnt_bic, date_in, date_out, pt_type, srvcs, xch_type, uid, participant_status " +
            "from bic_directory_entry left join participant_info " +
            "ON participant_info.bic_directory_entry_id = bic_directory_entry.id " +
            "where ed807_id = :ed807 " +
            "AND (:bic IS NULL or bic = :bic) " +
            "AND (name_p like %:name% ) " +
            "AND (:ptType IS NULL or pt_type = :ptType)",
            nativeQuery = true)
    Page<Object[]> getByCategories(Pageable pageable,Long ed807, String bic, String name, String ptType);


    @Query(value = "select COUNT(*) from bic_directory_entry left join participant_info " +
            "ON participant_info.bic_directory_entry_id = bic_directory_entry.id " +
            "where ed807_id = :ed807 " +
            "AND (:bic IS NULL or bic = :bic) " +
            "AND (name_p like %:name% ) " +
            "AND (:ptType IS NULL or pt_type = :ptType)",
            nativeQuery = true)
    Long getCountByCategories(Long ed807, String bic, String name, String ptType);

}
