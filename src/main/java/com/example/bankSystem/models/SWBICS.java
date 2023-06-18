package com.example.bankSystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "swbics")
@XmlRootElement(name="SWBICS")
@XmlAccessorType(XmlAccessType.FIELD)
public class SWBICS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "default_swbic")
    @XmlAttribute(name = "DefaultSWBIC") // todo Сделать фото
    private Boolean defaultSWBIC;

    @Column(name = "swbic")
    @XmlAttribute(name = "SWBIC")
    private String swbic;

    @OneToOne
    @JoinColumn(name = "bic_directory_entry_id")
    @XmlElementRef
    private BICDirectoryEntry bicDirectoryEntry;
}
