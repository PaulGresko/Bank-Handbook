package com.example.bankSystem.models.bankModels;

import com.example.bankSystem.enums.RstrType;
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
@Table(name = "rstr_list")
public class RstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rstr_date")
    @Temporal(TemporalType.DATE)
    private Date rstrDate;

    @Column(name = "rstr")
    @Enumerated(EnumType.STRING)
    private RstrType rstr;

    @ManyToOne
    @JoinColumn(name = "participant_info_id")
    @JsonIgnore
    private ParticipantInfo participantInfo;
}
