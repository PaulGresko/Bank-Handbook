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
@Table(name = "rstr_list")
@XmlRootElement(name="RstrList")
@XmlAccessorType(XmlAccessType.FIELD)
public class RstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rstr_date")
    @XmlAttribute(name = "RstrDate")
    private Date rstrDate;

    @Column(name = "rstr")
    @XmlAttribute(name = "Rstr")
    private String rstr;

    @ManyToOne
    @JoinColumn(name = "participant_info_id")
    private ParticipantInfo participantInfo;
}
