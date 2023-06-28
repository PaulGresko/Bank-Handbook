package com.example.bankSystem.dto;


import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "BICDirectoryEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class BICDirectoryEntryDto {


    @XmlAttribute(name = "BIC")
    private String bic;

    @XmlElement(name = "ParticipantInfo",namespace = "urn:cbr-ru:ed:v2.0")
    private ParticipantInfoDto participantInfo;

    @XmlElement(name = "Accounts",namespace = "urn:cbr-ru:ed:v2.0")
    private List<AccountDto> accounts = new ArrayList<>();

    @XmlElement(name = "SWBICS",namespace = "urn:cbr-ru:ed:v2.0")
    private SwbicsDto swbics;
}
