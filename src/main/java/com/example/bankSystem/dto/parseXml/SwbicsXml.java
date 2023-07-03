package com.example.bankSystem.dto.parseXml;


import jakarta.validation.constraints.Size;
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
public class SwbicsXml {

    @XmlAttribute(name = "DefaultSWBIC")
    private Boolean defaultSWBIC;

    @XmlAttribute(name = "SWBIC")
    @Size(min=8, max = 11)
    private String swbic;
}
