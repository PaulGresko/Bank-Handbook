package com.example.bankSystem.dto.xml;


import com.example.bankSystem.enums.RstrType;
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
@XmlRootElement(name="RstrList")
@XmlAccessorType(XmlAccessType.FIELD)
public class RstrListXml {

    @XmlAttribute(name = "RstrDate")
    @Temporal(TemporalType.DATE)
    private Date rstrDate;

    @XmlAttribute(name = "Rstr")
    @Enumerated(EnumType.STRING)
    private RstrType rstr;
}
