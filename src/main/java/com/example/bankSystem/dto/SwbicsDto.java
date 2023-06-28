package com.example.bankSystem.dto;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="SWBICS")
@XmlAccessorType(XmlAccessType.FIELD)
public class SwbicsDto {

    @XmlAttribute(name = "DefaultSWBIC")
    private Boolean defaultSWBIC;

    @XmlAttribute(name = "SWBIC")
    private String swbic;
}
