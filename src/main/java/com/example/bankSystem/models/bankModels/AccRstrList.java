package com.example.bankSystem.models.bankModels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.*;

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
    private String accRstr;

    @ManyToOne
    @JoinColumn(name = "accounts_id")
    private Account account;
}
