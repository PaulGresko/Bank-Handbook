package com.example.bankSystem.models;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy HH:mm:ss")
    private Date createdDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
    private Date lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @Column(name="deleted")
    private Boolean deleted = false;

    @Column(name = "deleted_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
    private Date deletedDate;

    @Column(name = "deleted_by")
    private String deletedBy;
    @PreUpdate
    public void beforeDelete(){
        if(getDeleted() && deletedDate == null){
            deletedDate = lastModifiedDate;
            deletedBy = lastModifiedBy;
        }
        if(!getDeleted() && deletedDate != null){
            deletedDate = null;
            deletedBy = null;
        }
    }
}
