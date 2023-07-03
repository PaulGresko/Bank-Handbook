package com.example.bankSystem.models.bankModels;

import com.example.bankSystem.models.Audit;
import com.example.bankSystem.enums.CreationReason;
import com.example.bankSystem.enums.InfoTypeCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ED807")
@DynamicUpdate
public class ED807 extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "directory_version")
    private int directoryVersion;

    @Column(name = "business_day")
    @Temporal(TemporalType.DATE)
    private Date businessDay;

    @Column(name = "info_type_code")
    @Enumerated(EnumType.STRING)
    private InfoTypeCode infoTypeCode;

    @Column(name = "creation_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    @Column(name = "creation_reason")
    @Enumerated(EnumType.STRING)
    private CreationReason creationReason;

    @Column(name = "ed_author")
    private String edAuthor;

    @Column(name = "ed_receiver")
    private String edReceiver;

    @Column(name = "ed_date")
    @Temporal(TemporalType.DATE)
    private Date edDate;

    @Column(name = "ed_no")
    private String edNo;

    @OneToMany(mappedBy = "ed807", cascade = CascadeType.ALL)
    private List<BICDirectoryEntry> bicDirectoryEntries = new ArrayList<>();

}
