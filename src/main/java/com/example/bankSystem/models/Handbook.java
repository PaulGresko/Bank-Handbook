package com.example.bankSystem.models;


import com.example.bankSystem.enums.handbook.HandbookType;
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
@Table
public class Handbook extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private HandbookType type;

    @Column
    private String code;

    @Column
    private String title;

    @Column
    @Temporal(TemporalType.DATE)
    private Date validFrom;

    @Column
    @Temporal(TemporalType.DATE)
    private Date validUntil;
}
