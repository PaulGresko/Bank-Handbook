-- Создание таблицы ED807
CREATE TABLE ED807(
                      id  INT PRIMARY KEY AUTO_INCREMENT,

);

-- Создание таблицы BICDirectoryEntry
CREATE TABLE BICDirectoryEntry
(
    id  INT PRIMARY KEY AUTO_INCREMENT,
    BIC VARCHAR(20) NOT NULL
);

-- Создание таблицы ParticipantInfo
CREATE TABLE ParticipantInfo
(
    id                   INT PRIMARY KEY AUTO_INCREMENT,
    BICDirectoryEntry_id INT          NOT NULL,
    ParticipantStatus    VARCHAR(10)  NOT NULL,
    UID                  VARCHAR(20)  NOT NULL,
    XchType              INT          NOT NULL,
    Srvcs                INT          NOT NULL,
    PtType               INT          NOT NULL,
    DateIn               DATE         NOT NULL,
    Adr                  VARCHAR(255) NOT NULL,
    Nnp                  VARCHAR(255) NOT NULL,
    Tnp                  VARCHAR(10)  NOT NULL,
    Ind                  VARCHAR(10)  NOT NULL,
    Rgn                  VARCHAR(10)  NOT NULL,
    CntrCd               VARCHAR(10)  NOT NULL,
    NameP                VARCHAR(255) NOT NULL,
    RegN                 VARCHAR(10),
    FOREIGN KEY (BICDirectoryEntry_id) REFERENCES BICDirectoryEntry (id)
);

-- Создание таблицы Accounts
CREATE TABLE Accounts
(
    id                    INT PRIMARY KEY AUTO_INCREMENT,
    BICDirectoryEntry_id  INT         NOT NULL,
    DateIn                DATE        NOT NULL,
    AccountStatus         VARCHAR(10) NOT NULL,
    AccountCBRBIC         VARCHAR(20) NOT NULL,
    CK                    VARCHAR(10) NOT NULL,
    RegulationAccountType VARCHAR(10) NOT NULL,
    Account               VARCHAR(20) NOT NULL,
    FOREIGN KEY (BICDirectoryEntry_id) REFERENCES BICDirectoryEntry (id)
);

-- Создание таблицы RstrList
CREATE TABLE RstrList
(
    id                 INT PRIMARY KEY AUTO_INCREMENT,
    ParticipantInfo_id INT         NOT NULL,
    RstrDate           DATE        NOT NULL,
    Rstr               VARCHAR(10) NOT NULL,
    FOREIGN KEY (ParticipantInfo_id) REFERENCES ParticipantInfo (id)
);
