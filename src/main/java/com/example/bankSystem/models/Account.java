package com.example.bankSystem.models;

import jakarta.persistence.Entity;
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
@Table(name = "accounts")
@XmlRootElement(name = "Accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_in")
    @XmlAttribute(name = "DateIn")
    private Date dateIn;

    @Column(name = "account_status")
    @XmlAttribute(name = "AccountStatus")
    private String accountStatus;

    @Column(name = "account_cbr_bic")
    @XmlAttribute(name = "AccountCBRBIC")
    private String accountCBRBIC;

    @Column(name = "ck")
    @XmlAttribute(name = "CK")
    private String ck;

    @Column(name = "regulation_account_type")
    @XmlAttribute(name = "RegulationAccountType")
    private String regulationAccountType;

    @Column(name = "account")
    @XmlAttribute(name = "Account")
    private String account;

    @ManyToOne
    @JoinColumn(name = "bic_directory_entry_id")
    private BICDirectoryEntry bicDirectoryEntry;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    @XmlElement(name = "AccRstrList", namespace = "urn:cbr-ru:ed:v2.0")
    private List<AccRstrList> accRstrLists = new ArrayList<>();
}
