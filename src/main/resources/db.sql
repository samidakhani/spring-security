=========  MySQL for JDBC ===========
CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

CREATE TABLE authorities (
  user_authority_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  authority varchar(45) NOT NULL,
  PRIMARY KEY (user_authority_id),
  UNIQUE KEY uni_username_authority (authority,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
  
==== for remember-me ====
CREATE TABLE persistent_logins (
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
);
  
  
INSERT INTO users(username,password,enabled)
VALUES ('sami','sami', true);
INSERT INTO users(username,password,enabled)
VALUES ('suraj','suraj', true);

INSERT INTO authorities (username, authority)
VALUES ('sami', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('sami', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority)
VALUES ('suraj', 'ROLE_USER');

commit;

===== Oralce for JPA ======
CREATE SEQUENCE  USER_SEQ  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE; 
CREATE SEQUENCE  AUTHORITY_SEQ  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE; 

CREATE TABLE SUSER
(
 USER_ID NUMBER,
 USERNAME VARCHAR2(50),
 SPASSWORD VARCHAR(50),
 CONSTRAINT USER_PK PRIMARY KEY (USER_ID)
 USING INDEX  ENABLE
);

CREATE TABLE AUTHORITY
(
 AUTHORITY_ID NUMBER,
 AUTHORITY_NAME VARCHAR2(50),
 USER_ID NUMBER,
 CONSTRAINT AUTHORITY_PK PRIMARY KEY (AUTHORITY_ID)
 USING INDEX  ENABLE,
 CONSTRAINT AUTHORITY_FK FOREIGN KEY (USER_ID)
 REFERENCES  SUSER (USER_ID) ON DELETE CASCADE ENABLE
);

INSERT INTO SUSER VALUES(1,'sami','sami');
INSERT INTO SUSER VALUES(2,'suraj','suraj');

INSERT INTO AUTHORITY VALUES (1,'ROLE_USER',1);
INSERT INTO AUTHORITY VALUES (2,'ROLE_ADMIN',1);
INSERT INTO AUTHORITY VALUES (3,'ROLE_USER',2);

COMMIT;

==== for remember-me ====
CREATE TABLE persistent_logins (
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
);
