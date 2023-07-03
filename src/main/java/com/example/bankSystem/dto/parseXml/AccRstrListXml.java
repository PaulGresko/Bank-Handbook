package com.example.bankSystem.dto.parseXml;


import com.example.bankSystem.enums.AccRstrType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "AccRstrList")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccRstrListXml {

    @XmlAttribute(name = "AccRstrDate")
    @Temporal(TemporalType.DATE)
    private Date accRstrDate;

    @XmlAttribute(name = "AccRstr")
    @Enumerated(EnumType.STRING)
    private AccRstrType accRstrType;

    @XmlAttribute(name = "SuccessorBIC")
    @Size(min = 9,max = 9)
    private String SuccessorBic;

}
