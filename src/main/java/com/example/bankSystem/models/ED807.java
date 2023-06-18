package com.example.bankSystem.models;

import jakarta.persistence.*;
import jakarta.xml.bind.Unmarshaller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ED807")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ED807", namespace = "urn:cbr-ru:ed:v2.0")
public class ED807 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "directory_version")
    @XmlAttribute(name = "DirectoryVersion")
    private String directoryVersion;

    @Column(name = "business_day")
    @XmlAttribute(name = "BusinessDay")
    private Date businessDay;

    @Column(name = "info_type_code")
    @XmlAttribute(name = "InfoTypeCode")
    private String infoTypeCode;

    @Column(name = "creation_date_time")
    @XmlAttribute(name = "CreationDateTime")
    private Date creationDateTime;

    @Column(name = "creation_reason")
    @XmlAttribute(name = "CreationReason")
    private String creationReason;

    @Column(name = "ed_author")
    @XmlAttribute(name = "EDAuthor")
    private String edAuthor;

    @Column(name = "ed_date")
    @XmlAttribute(name = "EDDate")
    private Date edDate;

    @Column(name = "ed_no")
    @XmlAttribute(name = "EDNo")
    private String edNo;

    @OneToMany(mappedBy = "ed807", cascade = CascadeType.ALL)
    @XmlElement(name = "BICDirectoryEntry", namespace = "urn:cbr-ru:ed:v2.0")
    private List<BICDirectoryEntry> bicDirectoryEntries = new ArrayList<>();
}
