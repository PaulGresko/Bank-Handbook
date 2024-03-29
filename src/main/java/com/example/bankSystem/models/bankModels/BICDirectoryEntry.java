package com.example.bankSystem.models.bankModels;

import com.example.bankSystem.enums.ChangeType;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class BICDirectoryEntry{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bic")
    @XmlAttribute(name = "BIC")
    private String bic;

    @Column(name = "change_type")
    @Enumerated(EnumType.STRING)
    private ChangeType changeType;


    @ManyToOne
    @JoinColumn(name = "ed807_id")
    @JsonIgnore
    private ED807 ed807;

    @OneToOne(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    private ParticipantInfo participantInfo;

    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    @OneToOne(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    private Swbics swbics;
}
