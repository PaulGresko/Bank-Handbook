package com.example.bankSystem.dto;

import com.example.bankSystem.enums.CreationReason;
import com.example.bankSystem.enums.InfoTypeCode;
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
    private Date createdDate;
    private String fileName;
    private Date edDate;
    private String edAuthor;
    private String edReceiver;
    private CreationReason creationReason;
    private Date creationDateTime;
    private InfoTypeCode infoTypeCode;
    private Date businessDay;
    private int directoryVersion;
    private String createdBy;
}
