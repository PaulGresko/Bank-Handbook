package com.example.bankSystem.dto.xml;


import com.example.bankSystem.enums.ParticipantStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="ParticipantInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantInfoXml {

    @XmlAttribute(name = "ParticipantStatus")
    @Enumerated(EnumType.STRING)
    private ParticipantStatus participantStatus;

    @XmlAttribute(name = "UID")
    @Size(min = 10, max = 10)
    private String uid;

    @XmlAttribute(name = "XchType")
    @Size(min = 1, max = 1)
    private Boolean xchType;

    @XmlAttribute(name = "Srvcs")
    @Size(min = 1, max = 1)
    private String srvcs;

    @XmlAttribute(name = "PtType")
    @Size(min = 1, max = 2)
    private String ptType;

    @XmlAttribute(name = "DateIn")
    @Temporal(TemporalType.DATE)
    private Date dateIn;

    @XmlAttribute(name = "DateOut")
    @Temporal(TemporalType.DATE)
    private Date dateOut;

    @XmlAttribute(name="PrntBIC")
    @Size(min = 9, max = 9)
    private String prntBIC;

    @XmlAttribute(name = "Adr")
    @Size(min = 1, max = 160)
    private String adr;

    @XmlAttribute(name = "Nnp")
    @Size(min = 1, max = 25)
    private String nnp;

    @XmlAttribute(name = "Tnp")
    @Size(min = 1, max = 5)
    private String tnp;

    @XmlAttribute(name = "Ind")
    @Size(min = 1, max = 16)
    private String ind;

    @XmlAttribute(name = "Rgn")
    @Size(min = 1, max = 2)
    private String rgn;

    @XmlAttribute(name = "CntrCd")
    @Size(min = 2, max = 2)
    private String cntrCd;

    @XmlAttribute(name = "NameP")
    @Size(min = 1, max = 160)
    private String nameP;

    @XmlAttribute(name = "EnglName")
    @Size(min = 1, max = 140)
    private String englName;

    @XmlAttribute(name = "RegN")
    @Size(min = 1,max = 9)
    private String regN;

    @XmlElement(name = "RstrList", namespace = "urn:cbr-ru:ed:v2.0")
    private List<RstrListXml> rstrLists = new ArrayList<>();
}
