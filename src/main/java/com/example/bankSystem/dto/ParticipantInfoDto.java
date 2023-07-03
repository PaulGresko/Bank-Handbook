package com.example.bankSystem.dto;



import com.example.bankSystem.enums.ParticipantStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantInfoDto {
    private Long id;
    private Long ed807Id;
    private String bic;
    private String nameP;
    private String englName;
    private String regN;
    private String cntrCd;
    private String rgn;
    private String ind;
    private String tnp;
    private String nnp;
    private String adr;
    private String prntBIC;
    private Date dateIn;
    private Date dateOut;
    private String ptType;
    private String srvcs;
    private Boolean xchType;
    private String uid;
    private ParticipantStatus participantStatus;
}
