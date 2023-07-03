package com.example.bankSystem.models.bankModels;

import com.example.bankSystem.enums.AccountStatus;
import com.example.bankSystem.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
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
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_in")
    @Temporal(TemporalType.DATE)
    private Date dateIn;

    @Column(name = "date_out")
    @Temporal(TemporalType.DATE)
    private Date dateOut;

    @Column(name = "account_status")
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @Column(name = "account_cbr_bic")
    private String accountCBRBIC;

    @Column(name = "ck")
    private String ck;

    @Column(name = "regulation_account_type")
    private AccountType regulationAccountType;

    @Column(name = "account")
    private String account;

    @ManyToOne
    @JoinColumn(name = "bic_directory_entry_id")
    @JsonIgnore
    private BICDirectoryEntry bicDirectoryEntry;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<AccRstrList> accRstrLists = new ArrayList<>();
}
