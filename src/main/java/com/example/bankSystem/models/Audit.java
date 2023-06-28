package com.example.bankSystem.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @CreatedBy
    private String createdBy;


    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedBy;


    @Column(name="deleted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @Column(name="deleted_by")
    private String deletedBy;

    @Column(name="deleted")
    private Boolean deleted = false;


    @PreUpdate
    private void beforeDelete() {
        if (deleted) {
            deletedDate = lastModifiedDate;
            deletedBy = lastModifiedBy;
        }
    }
}
