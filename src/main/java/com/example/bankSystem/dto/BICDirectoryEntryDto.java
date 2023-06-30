package com.example.bankSystem.dto;


import com.example.bankSystem.utils.Enums.ChangeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.validation.constraints.Size;
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
    @Size(min = 9, max = 9)
    private String bic;

    @XmlAttribute(name="ChangeType")
    @Enumerated(EnumType.STRING)
    private ChangeType changeType;

    @XmlElement(name = "ParticipantInfo",namespace = "urn:cbr-ru:ed:v2.0")
    private ParticipantInfoDto participantInfo;

    @XmlElement(name = "Accounts",namespace = "urn:cbr-ru:ed:v2.0")
    private List<AccountDto> accounts = new ArrayList<>();

    @XmlElement(name = "SWBICS",namespace = "urn:cbr-ru:ed:v2.0")
    private SwbicsDto swbics;
}
