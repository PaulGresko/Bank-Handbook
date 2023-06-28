package com.example.bankSystem.dto;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "Accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountDto {

    @XmlAttribute(name = "DateIn")
    private Date dateIn;

    @XmlAttribute(name = "AccountStatus")
    private String accountStatus;

    @XmlAttribute(name = "AccountCBRBIC")
    private String accountCBRBIC;

    @XmlAttribute(name = "CK")
    private String ck;

    @XmlAttribute(name = "RegulationAccountType")
    private String regulationAccountType;

    @XmlAttribute(name = "Account")
    private String account;

    @XmlElement(name = "AccRstrList", namespace = "urn:cbr-ru:ed:v2.0")
    private List<AccRstrListDto> accRstrLists = new ArrayList<>();
}
