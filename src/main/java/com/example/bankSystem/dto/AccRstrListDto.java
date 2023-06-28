package com.example.bankSystem.dto;


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
    private Date accRstrDate;

    @XmlAttribute(name = "AccRstr")
    private String accRstr;

}
