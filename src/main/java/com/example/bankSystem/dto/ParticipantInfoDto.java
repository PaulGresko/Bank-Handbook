package com.example.bankSystem.dto;


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
public class ParticipantInfoDto {

    @XmlAttribute(name = "ParticipantStatus")
    private String participantStatus;

    @XmlAttribute(name = "UID")
    private String uid;

    @XmlAttribute(name = "XchType")
    private Boolean xchType;

    @XmlAttribute(name = "Srvcs")
    private String srvcs;

    @XmlAttribute(name = "PtType")
    private String ptType;

    @XmlAttribute(name = "DateIn")
    private Date dateIn;

    @XmlAttribute(name = "Adr")
    private String adr;

    @XmlAttribute(name = "Nnp")
    private String nnp;

    @XmlAttribute(name = "Tnp")
    private String tnp;

    @XmlAttribute(name = "Ind")
    private String ind;

    @XmlAttribute(name = "Rgn")
    private String rgn;

    @XmlAttribute(name = "CntrCd")
    private String cntrCd;

    @XmlAttribute(name = "NameP")
    private String nameP;

    @XmlAttribute(name = "RegN")
    private String regN;

    @XmlElement(name = "RstrList", namespace = "urn:cbr-ru:ed:v2.0")
    private List<RstrListDto> rstrLists = new ArrayList<>();
}
