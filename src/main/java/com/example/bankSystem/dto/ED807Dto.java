package com.example.bankSystem.dto;

import com.example.bankSystem.utils.Enums.CreationReason;
import com.example.bankSystem.utils.Enums.InfoTypeCode;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
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
public class ED807Dto {

    @XmlAttribute(name = "DirectoryVersion")
    @Digits(integer = 2, fraction = 0)
    private Integer directoryVersion;

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

    @XmlAttribute(name = "EDAuthor")
    @Size(min = 10, max = 10)
    private String edAuthor;

    @XmlAttribute(name = "EDReceiver")
    @Size(min = 10, max = 10)
    private String eDReceiver;

    @XmlAttribute(name = "EDDate")
    @Temporal(TemporalType.DATE)
    private Date edDate;

    @XmlAttribute(name = "EDNo")
    @Size(max = 9)
    //@Pattern(regexp = "\t[\\-]?[1-9]\\d{0,}|[0]\t\n") // todo Необходимо затестить
    private String edNo;

    @XmlElement(name = "BICDirectoryEntry", namespace = "urn:cbr-ru:ed:v2.0")
    private List<BICDirectoryEntryDto> bicDirectoryEntries = new ArrayList<>();
}
