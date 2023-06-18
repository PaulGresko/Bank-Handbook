package com.example.bankSystem.models;

import jakarta.persistence.*;
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
@Table(name = "participant_info")
@XmlRootElement(name="ParticipantInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "participant_status")
    @XmlAttribute(name = "ParticipantStatus")
    private String participantStatus;

    @Column(name = "uid")
    @XmlAttribute(name = "UID")
    private String uid;

    @Column(name = "xch_type")
    @XmlAttribute(name = "XchType")
    private Boolean xchType;

    @Column(name = "srvcs")
    @XmlAttribute(name = "Srvcs")
    private String srvcs;

    @Column(name = "pt_type")
    @XmlAttribute(name = "PtType")
    private String ptType;

    @Column(name = "date_in")
    @XmlAttribute(name = "DateIn")
    private Date dateIn;

    @Column(name = "adr")
    @XmlAttribute(name = "Adr")
    private String adr;

    @Column(name = "nnp")
    @XmlAttribute(name = "Nnp")
    private String nnp;

    @Column(name = "tnp")
    @XmlAttribute(name = "Tnp")
    private String tnp;

    @Column(name = "ind")
    @XmlAttribute(name = "Ind")
    private String ind;

    @Column(name = "rgn")
    @XmlAttribute(name = "Rgn")
    private String rgn;

    @Column(name = "cntr_cd")
    @XmlAttribute(name = "CntrCd")
    private String cntrCd;

    @Column(name = "name_p")
    @XmlAttribute(name = "NameP")
    private String nameP;

    @Column(name="reg_N")
    @XmlAttribute(name = "RegN")
    private String regN;

    @OneToOne
    @JoinColumn(name = "bic_directory_entry_id")
    private BICDirectoryEntry bicDirectoryEntry;

    @OneToMany(mappedBy = "participantInfo",cascade = CascadeType.ALL)
    @XmlElement(name = "RstrList", namespace = "urn:cbr-ru:ed:v2.0")
    private List<RstrList> rstrLists = new ArrayList<>();
}

