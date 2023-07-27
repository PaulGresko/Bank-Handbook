package com.example.bankSystem.dto;

import com.example.bankSystem.enums.CreationReason;
import com.example.bankSystem.enums.InfoTypeCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ED807Dto {
    private Long id;
    private String title;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy HH:mm:ss")
    private Date createdDate;
    private String fileName;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy")
    private Date edDate;
    private String edAuthor;
    private String edReceiver;
    private CreationReason creationReason;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy HH:mm:ss")
    private Date creationDateTime;
    private InfoTypeCode infoTypeCode;
    private Date businessDay;
    private int directoryVersion;
    private String createdBy;
}
