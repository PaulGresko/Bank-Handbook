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
@XmlRootElement(name="RstrList")
@XmlAccessorType(XmlAccessType.FIELD)
public class RstrListDto {

    @XmlAttribute(name = "RstrDate")
    private Date rstrDate;

    @XmlAttribute(name = "Rstr")
    private String rstr;
}
