package com.example.bankSystem.dto;

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
    private String directoryVersion;

    @XmlAttribute(name = "BusinessDay")
    private Date businessDay;

    @XmlAttribute(name = "InfoTypeCode")
    private String infoTypeCode;

    @XmlAttribute(name = "CreationDateTime")
    private Date creationDateTime;

    @XmlAttribute(name = "CreationReason")
    private String creationReason;

    @XmlAttribute(name = "EDAuthor")
    private String edAuthor;

    @XmlAttribute(name = "EDDate")
    private Date edDate;

    @XmlAttribute(name = "EDNo")
    private String edNo;

    @XmlElement(name = "BICDirectoryEntry", namespace = "urn:cbr-ru:ed:v2.0")
    private List<BICDirectoryEntryDto> bicDirectoryEntries = new ArrayList<>();
}
