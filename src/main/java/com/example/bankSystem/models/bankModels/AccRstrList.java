package com.example.bankSystem.models.bankModels;

import com.example.bankSystem.enums.AccRstrType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "acc_rstr_list")
public class AccRstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "acc_rstr_date")
    @Temporal(TemporalType.DATE)
    private Date accRstrDate;

    @Column(name = "acc_rstr")
    private AccRstrType accRstr;

    @Column(name = "successor_bic")
    private String successorBic;

    @ManyToOne
    @JoinColumn(name = "accounts_id")
    @JsonIgnore
    private Account account;


}
