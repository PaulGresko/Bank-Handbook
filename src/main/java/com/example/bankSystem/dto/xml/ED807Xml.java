package com.example.bankSystem.dto.xml;

import com.example.bankSystem.enums.CreationReason;
import com.example.bankSystem.enums.InfoTypeCode;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ED807", namespace = "urn:cbr-ru:ed:v2.0")
public class ED807Xml {

    private String title;

    private String fileName;

    @XmlAttribute(name = "DirectoryVersion")
    @Digits(integer = 2, fraction = 0)
    private int directoryVersion;

    @XmlAttribute(name = "BusinessDay")
    @Temporal(TemporalType.DATE)
    private Date businessDay;

    @XmlAttribute(name = "InfoTypeCode")
    @Enumerated(EnumType.STRING)
    private InfoTypeCode infoTypeCode;

    @XmlAttribute(name = "CreationDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    @XmlAttribute(name = "CreationReason")
    @Enumerated(EnumType.STRING)
    private CreationReason creationReason;

    @XmlAttribute(name = "EDReceiver")
    @Size(min = 10, max = 10)
    private String eDReceiver;

    @XmlAttribute(name = "EDAuthor")
    @Size(min = 10, max = 10)
    private String edAuthor;

    @XmlAttribute(name = "EDDate")
    @Temporal(TemporalType.DATE)
    private Date edDate;

    @XmlAttribute(name = "EDNo")
    @Size(max = 9)
    private String edNo;

    @XmlElement(name = "BICDirectoryEntry", namespace = "urn:cbr-ru:ed:v2.0")
    private List<BICDirectoryEntryXml> bicDirectoryEntries = new ArrayList<>();
}
