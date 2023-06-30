package com.example.bankSystem.dto;


import com.example.bankSystem.utils.Enums.AccRstr;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class AccRstrListDto {

    @XmlAttribute(name = "AccRstrDate")
    @Temporal(TemporalType.DATE)
    private Date accRstrDate;

    @XmlAttribute(name = "AccRstr")
    @Enumerated(EnumType.STRING)
    private AccRstr accRstr;

}
