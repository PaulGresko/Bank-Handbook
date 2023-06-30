package com.example.bankSystem.dto;

import com.example.bankSystem.utils.Enums.AccountStatus;
import com.example.bankSystem.utils.Enums.RegulationAccountType;
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


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "Accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountDto {

    @XmlAttribute(name = "DateIn")
    @Temporal(TemporalType.DATE)
    private Date dateIn;

    @XmlAttribute(name = "AccountStatus")
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @XmlAttribute(name = "AccountCBRBIC")
    @Size(min = 9,max = 9)
    private String accountCBRBIC;

    @XmlAttribute(name = "CK")
    @Size(min = 2, max = 2)
    private String ck;

    @XmlAttribute(name = "RegulationAccountType")
    @Enumerated(EnumType.STRING)
    private RegulationAccountType regulationAccountType;

    @XmlAttribute(name = "Account")
    @Size(min = 20, max = 20)
    private String account;

    @XmlElement(name = "AccRstrList", namespace = "urn:cbr-ru:ed:v2.0")
    private List<AccRstrListDto> accRstrLists = new ArrayList<>();
}
