package com.example.bankSystem.models.bankModels;

import com.example.bankSystem.enums.ParticipantStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "participant_info")
public class ParticipantInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "participant_status")
    @Enumerated(EnumType.STRING)
    private ParticipantStatus participantStatus;

    @Column(name = "uid")
    private String uid;

    @Column(name = "xch_type")
    private Boolean xchType;

    @Column(name = "srvcs")
    private String srvcs;

    @Column(name = "pt_type")
    private String ptType;

    @Column(name = "date_in")
    @Temporal(TemporalType.DATE)
    private Date dateIn;

    @Column(name = "date_out")
    @Temporal(TemporalType.DATE)
    private Date dateOut;

    @Column(name = "adr")
    private String adr;

    @Column(name = "nnp")
    private String nnp;

    @Column(name = "tnp")
    private String tnp;

    @Column(name = "ind")
    private String ind;

    @Column(name = "rgn")
    private String rgn;

    @Column(name = "cntr_cd")
    private String cntrCd;

    @Column(name = "name_p")
    private String nameP;

    @Column(name="prnt_bic")
    private String prntBIC;

    @Column(name = "engl_name")
    private String englName;

    @Column(name="reg_N")
    private String regN;

    @OneToOne
    @JoinColumn(name = "bic_id")
    @JsonIgnore
    private BICDirectoryEntry bicDirectoryEntry;

    @OneToMany(mappedBy = "participantInfo",cascade = CascadeType.ALL)
    private List<RstrList> rstrLists = new ArrayList<>();
}

