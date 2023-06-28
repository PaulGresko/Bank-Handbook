package com.example.bankSystem.models.bankModels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "bic_directory_entry")
@XmlRootElement(name = "BICDirectoryEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class BICDirectoryEntry{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "bic")
    @XmlAttribute(name = "BIC")
    private String bic;

    @ManyToOne
    @JoinColumn(name = "ed807_id")
    private ED807 ed807;

    @OneToOne(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    @XmlElement(name = "ParticipantInfo",namespace = "urn:cbr-ru:ed:v2.0")
    private ParticipantInfo participantInfo;

    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    @XmlElement(name = "Accounts",namespace = "urn:cbr-ru:ed:v2.0")
    private List<Account> accounts = new ArrayList<>();

    @OneToOne(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    @XmlElement(name = "SWBICS",namespace = "urn:cbr-ru:ed:v2.0")
    private Swbics swbics;
}
