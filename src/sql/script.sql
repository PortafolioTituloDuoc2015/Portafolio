-- Generado por Oracle SQL Developer Data Modeler 3.1.0.700
--   en:        2015-10-02 10:42:36 CLT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g

create table uf (idUf int,fecha date, valor int)

CREATE SEQUENCE  UF_SEQ
MINVALUE 1 MAXVALUE 999999999999999999999999999 
INCREMENT BY 1 START WITH 5 NOCACHE  ORDER  NOCYCLE ;



CREATE OR REPLACE TRIGGER UF_SEQ_TRG
BEFORE INSERT ON uf 
FOR EACH ROW 

BEGIN 
    SELECT Trabajador_IdTrabajador_SEQ.NEXTVAL INTO :NEW.IdTrabajador FROM DUAL; 
END;

BEGIN 
    SELECT UF_SEQ.NEXTVAL INTO :NEW.idUf FROM DUAL; 
END;
/

CREATE TABLE BoletaEstacionamiento 
    ( 
     IdBoletaEstacionamiento INTEGER  NOT NULL , 
     Fecha DATE  NOT NULL , 
     Total INTEGER  NOT NULL , 
     IdPagoEstacionamiento INTEGER  NOT NULL 
    ) 
;


CREATE UNIQUE INDEX BoletaEstacionamiento__IDX ON BoletaEstacionamiento 
    ( 
     IdPagoEstacionamiento ASC 
    ) 
;

ALTER TABLE BoletaEstacionamiento 
    ADD CONSTRAINT "BoletaEstacionamiento PK" PRIMARY KEY ( IdBoletaEstacionamiento ) ;



CREATE TABLE BoletaServicios 
    ( 
     codigoBoletaS INTEGER, 
     NumBoletaG INTEGER  NOT NULL , 
     Fecha DATE  NOT NULL , 
     Total INTEGER  NOT NULL , 
     IdPagoServicios INTEGER  NOT NULL 
    ) 
;


CREATE UNIQUE INDEX BoletaServicios__IDX ON BoletaServicios 
    ( 
     IdPagoServicios ASC 
    ) 
;

ALTER TABLE BoletaServicios 
    ADD CONSTRAINT "BoletaServicios PK" PRIMARY KEY ( NumBoletaG ) ;



CREATE TABLE Cargo 
    ( 
     IdCargo INTEGER  NOT NULL , 
     NombreCargo VARCHAR2 (50) 
    ) 
;



ALTER TABLE Cargo 
    ADD CONSTRAINT "Cargo PK" PRIMARY KEY ( IdCargo ) ;



CREATE TABLE Comuna 
    ( 
     IdComuna INTEGER  NOT NULL , 
     NombreComuna VARCHAR2 (100) , 
     CodigoProvincia INTEGER  NOT NULL 
    ) 
;



ALTER TABLE Comuna 
    ADD CONSTRAINT "Comuna PK" PRIMARY KEY ( IdComuna ) ;



CREATE TABLE LavaAuto 
    ( 
     IdLavaAuto INTEGER  NOT NULL , 
	 nombre VARCHAR2 (100), NOT NULL,
     Encargado VARCHAR2 (20)  NOT NULL , 
     Correo VARCHAR2 (50)  NOT NULL , 
     IdSucursal INTEGER  NOT NULL 
    ) 
;


CREATE UNIQUE INDEX LavaAuto__IDX ON LavaAuto 
    ( 
     IdSucursal ASC 
    ) 
;

ALTER TABLE LavaAuto 
    ADD CONSTRAINT "LavaAuto PK" PRIMARY KEY ( IdLavaAuto ) ;


ALTER TABLE LavaAuto 
    ADD CONSTRAINT LavaAuto__UN UNIQUE ( Correo ) ;



CREATE TABLE OrdenServicio 
    ( 
     IdOrdenServicio INTEGER  NOT NULL , 
     Patente VARCHAR2 (6)  NOT NULL , 
     observacion VARCHAR2 (500) 
    ) 
;



ALTER TABLE OrdenServicio 
    ADD CONSTRAINT "OrdenServicio PK" PRIMARY KEY ( IdOrdenServicio ) ;



CREATE TABLE PagoEstacionamiento 
    ( 
     IdPagoEstacionamiento INTEGER  NOT NULL , 
     Descuento INTEGER , 
     Liberado CHAR (1) , 
     IdTicket INTEGER  NOT NULL , 
     IdBoletaEstacionamiento INTEGER , 
     observacion VARCHAR2 (500) , 
     tiempo INTEGER  NOT NULL 
    ) 
;


CREATE UNIQUE INDEX PagoEstacionamiento__IDX ON PagoEstacionamiento 
    ( 
     IdTicket ASC 
    ) 
;
CREATE UNIQUE INDEX PagoEstacionamiento__IDXv1 ON PagoEstacionamiento 
    ( 
     IdBoletaEstacionamiento ASC 
    ) 
;

ALTER TABLE PagoEstacionamiento 
    ADD CONSTRAINT "PagoEstacionamiento PK" PRIMARY KEY ( IdPagoEstacionamiento ) ;



CREATE TABLE PagoServicios 
    ( 
     IdPagoServicios INTEGER  NOT NULL , 
     IdOrdenServicio INTEGER  NOT NULL , 
     IdBoletaServicios INTEGER 
    ) 
;


CREATE UNIQUE INDEX PagoServicios__IDX ON PagoServicios 
    ( 
     IdOrdenServicio ASC 
    ) 
;
CREATE UNIQUE INDEX PagoServicios__IDXv1 ON PagoServicios 
    ( 
     IdBoletaServicios ASC 
    ) 
;

ALTER TABLE PagoServicios 
    ADD CONSTRAINT "PagoServicios PK" PRIMARY KEY ( IdPagoServicios ) ;



CREATE TABLE Plaza 
    ( 
     IdSucursal INTEGER  NOT NULL , 
     IdPLaza INTEGER  NOT NULL , 
     pasillo CHAR (2)  NOT NULL , 
     Estado CHAR (1)  NOT NULL , 
     Vigente CHAR (1)  NOT NULL 
    ) 
;



ALTER TABLE Plaza 
    ADD CONSTRAINT "Plaza PK" PRIMARY KEY ( IdPLaza, IdSucursal, pasillo ) ;



CREATE TABLE Provincia 
    ( 
     CodigoProvincia INTEGER  NOT NULL , 
     NombreProvincia VARCHAR2 (100)  NOT NULL , 
     Region VARCHAR2 (4)  NOT NULL 
    ) 
;



ALTER TABLE Provincia 
    ADD CONSTRAINT "Provincia PK" PRIMARY KEY ( CodigoProvincia ) ;



CREATE TABLE Region 
    ( 
     Region VARCHAR2 (4)  NOT NULL 
    ) 
;



ALTER TABLE Region 
    ADD CONSTRAINT "Region PK" PRIMARY KEY ( Region ) ;



CREATE TABLE Servicio 
    ( 
     IdServicio INTEGER  NOT NULL , 
     nombre VARCHAR2 (50)  NOT NULL , 
     Descripcion VARCHAR2 (200) , 
     Precio INTEGER  NOT NULL , 
     IdLavaAuto INTEGER  NOT NULL 
    ) 
;



ALTER TABLE Servicio 
    ADD CONSTRAINT "Servicio PK" PRIMARY KEY ( IdServicio ) ;



CREATE TABLE Sucursal 
    ( 
     IdSucursal INTEGER  NOT NULL , 
     NombreSucursal VARCHAR2 (400)  NOT NULL , 
     Fono VARCHAR2 (12) , 
     IdComuna INTEGER  NOT NULL , 
     direccion VARCHAR2 (100)  NOT NULL 
    ) 
;



ALTER TABLE Sucursal 
    ADD CONSTRAINT "Sucursal PK" PRIMARY KEY ( IdSucursal ) ;


ALTER TABLE Sucursal 
    ADD CONSTRAINT Sucursal__UNv1 UNIQUE ( IdSucursal , NombreSucursal , direccion ) ;



CREATE TABLE Ticket 
    ( 
     IdTicket INTEGER  NOT NULL , 
     Ingreso TIMESTAMP  NOT NULL , 
     Salida TIMESTAMP , 
     IdPLaza INTEGER  NOT NULL , 
     Patente VARCHAR2 (6)  NOT NULL , 
     pagado CHAR (1)  NOT NULL , 
     Plaza_IdSucursal INTEGER  NOT NULL , 
     Plaza_pasillo CHAR (2)  NOT NULL 
    ) 
;



ALTER TABLE Ticket 
    ADD CONSTRAINT "Ticket PK" PRIMARY KEY ( IdTicket ) ;



CREATE TABLE Trabajador 
    ( 
     IdTrabajador INTEGER  NOT NULL , 
     Rut VARCHAR2 (10)  NOT NULL , 
     Nombre VARCHAR2 (150) , 
     ApellidoP VARCHAR2 (50) , 
     ApellidoM VARCHAR2 (50) , 
     Usuario VARCHAR2 (15) , 
     Clave VARCHAR2 (15) , 
     Vigente CHAR (1) , 
     IdSucursal INTEGER  NOT NULL , 
     IdCargo INTEGER  NOT NULL 
    ) 
;



ALTER TABLE Trabajador 
    ADD CONSTRAINT "Trabajador PK" PRIMARY KEY ( IdTrabajador ) ;


ALTER TABLE Trabajador 
    ADD CONSTRAINT Trabajador__UN UNIQUE ( IdTrabajador , Rut , Usuario ) ;



CREATE TABLE Vehiculo 
    ( 
     Patente VARCHAR2 (6)  NOT NULL , 
     Marca VARCHAR2 (150) , 
     Modelo VARCHAR2 (150) 
    ) 
;



ALTER TABLE Vehiculo 
    ADD CONSTRAINT "Vehiculo PK" PRIMARY KEY ( Patente ) ;



CREATE TABLE relacionOrdenServicio 
    ( 
     Servicio_IdServicio INTEGER  NOT NULL , 
     OrdenServicio_IdOrdenServicio INTEGER  NOT NULL,
	 idrelacionordenservicio INTEGER NOT NULL
    ) 
;



ALTER TABLE relacionOrdenServicio 
    ADD CONSTRAINT relacionOrdenServicio__IDX PRIMARY KEY ( Servicio_IdServicio, OrdenServicio_IdOrdenServicio ) ;




ALTER TABLE relacionOrdenServicio 
    ADD CONSTRAINT FK_ASS_18 FOREIGN KEY 
    ( 
     Servicio_IdServicio
    ) 
    REFERENCES Servicio 
    ( 
     IdServicio
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE relacionOrdenServicio 
    ADD CONSTRAINT FK_ASS_19 FOREIGN KEY 
    ( 
     OrdenServicio_IdOrdenServicio
    ) 
    REFERENCES OrdenServicio 
    ( 
     IdOrdenServicio
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE OrdenServicio 
    ADD CONSTRAINT Relation_14 FOREIGN KEY 
    ( 
     Patente
    ) 
    REFERENCES Vehiculo 
    ( 
     Patente
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE LavaAuto 
    ADD CONSTRAINT Relation_15 FOREIGN KEY 
    ( 
     IdSucursal
    ) 
    REFERENCES Sucursal 
    ( 
     IdSucursal
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE Servicio 
    ADD CONSTRAINT Relation_18 FOREIGN KEY 
    ( 
     IdLavaAuto
    ) 
    REFERENCES LavaAuto 
    ( 
     IdLavaAuto
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE Provincia 
    ADD CONSTRAINT Relation_2 FOREIGN KEY 
    ( 
     Region
    ) 
    REFERENCES Region 
    ( 
     Region
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE Ticket 
    ADD CONSTRAINT Relation_20 FOREIGN KEY 
    ( 
     IdPLaza,
     Plaza_IdSucursal,
     Plaza_pasillo
    ) 
    REFERENCES Plaza 
    ( 
     IdPLaza,
     IdSucursal,
     pasillo
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE Trabajador 
    ADD CONSTRAINT Relation_21 FOREIGN KEY 
    ( 
     IdCargo
    ) 
    REFERENCES Cargo 
    ( 
     IdCargo
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE PagoEstacionamiento 
    ADD CONSTRAINT Relation_23 FOREIGN KEY 
    ( 
     IdTicket
    ) 
    REFERENCES Ticket 
    ( 
     IdTicket
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE PagoEstacionamiento 
    ADD CONSTRAINT Relation_24 FOREIGN KEY 
    ( 
     IdBoletaEstacionamiento
    ) 
    REFERENCES BoletaEstacionamiento 
    ( 
     IdBoletaEstacionamiento
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE BoletaEstacionamiento 
    ADD CONSTRAINT Relation_24 FOREIGN KEY 
    ( 
     IdPagoEstacionamiento
    ) 
    REFERENCES PagoEstacionamiento 
    ( 
     IdPagoEstacionamiento
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE Comuna 
    ADD CONSTRAINT Relation_3 FOREIGN KEY 
    ( 
     CodigoProvincia
    ) 
    REFERENCES Provincia 
    ( 
     CodigoProvincia
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE Ticket 
    ADD CONSTRAINT Relation_31 FOREIGN KEY 
    ( 
     Patente
    ) 
    REFERENCES Vehiculo 
    ( 
     Patente
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE PagoServicios 
    ADD CONSTRAINT Relation_32 FOREIGN KEY 
    ( 
     IdOrdenServicio
    ) 
    REFERENCES OrdenServicio 
    ( 
     IdOrdenServicio
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE BoletaServicios 
    ADD CONSTRAINT Relation_33 FOREIGN KEY 
    ( 
     IdPagoServicios
    ) 
    REFERENCES PagoServicios 
    ( 
     IdPagoServicios
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE PagoServicios 
    ADD CONSTRAINT Relation_33 FOREIGN KEY 
    ( 
     IdBoletaServicios
    ) 
    REFERENCES BoletaServicios 
    ( 
     NumBoletaG
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE Sucursal 
    ADD CONSTRAINT Relation_4 FOREIGN KEY 
    ( 
     IdComuna
    ) 
    REFERENCES Comuna 
    ( 
     IdComuna
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE Plaza 
    ADD CONSTRAINT Relation_5 FOREIGN KEY 
    ( 
     IdSucursal
    ) 
    REFERENCES Sucursal 
    ( 
     IdSucursal
    ) 
    ON DELETE CASCADE 
;


ALTER TABLE Trabajador 
    ADD CONSTRAINT Relation_6 FOREIGN KEY 
    ( 
     IdSucursal
    ) 
    REFERENCES Sucursal 
    ( 
     IdSucursal
    ) 
    ON DELETE CASCADE 
;

CREATE SEQUENCE BoletaServicios_NumBoletaG_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER BoletaServicios_NumBoletaG_TRG 
BEFORE INSERT ON BoletaServicios 
FOR EACH ROW 

BEGIN 
    SELECT BoletaServicios_NumBoletaG_SEQ.NEXTVAL INTO :NEW.NumBoletaG FROM DUAL; 
END;
/

CREATE SEQUENCE Cargo_IdCargo_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Cargo_IdCargo_TRG 
BEFORE INSERT ON Cargo 
FOR EACH ROW 

BEGIN 
    SELECT Cargo_IdCargo_SEQ.NEXTVAL INTO :NEW.IdCargo FROM DUAL; 
END;
/

CREATE SEQUENCE Comuna_IdComuna_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Comuna_IdComuna_TRG 
BEFORE INSERT ON Comuna 
FOR EACH ROW 

BEGIN 
    SELECT Comuna_IdComuna_SEQ.NEXTVAL INTO :NEW.IdComuna FROM DUAL; 
END;
/

CREATE SEQUENCE LavaAuto_IdLavaAuto_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER LavaAuto_IdLavaAuto_TRG 
BEFORE INSERT ON LavaAuto 
FOR EACH ROW 

BEGIN 
    SELECT LavaAuto_IdLavaAuto_SEQ.NEXTVAL INTO :NEW.IdLavaAuto FROM DUAL; 
END;
/

CREATE SEQUENCE OrdenServicio_IdOrdenServicio 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER OrdenServicio_IdOrdenServicio 
BEFORE INSERT ON OrdenServicio 
FOR EACH ROW 

BEGIN 
    SELECT OrdenServicio_IdOrdenServicio.NEXTVAL INTO :NEW.IdOrdenServicio FROM DUAL; 
END;
/

CREATE SEQUENCE PagoServicios_IdPagoServicios 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER PagoServicios_IdPagoServicios 
BEFORE INSERT ON PagoServicios 
FOR EACH ROW 

BEGIN 
    SELECT PagoServicios_IdPagoServicios.NEXTVAL INTO :NEW.IdPagoServicios FROM DUAL; 
END;
/

CREATE SEQUENCE Provincia_CodigoProvincia_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Provincia_CodigoProvincia_TRG 
BEFORE INSERT ON Provincia 
FOR EACH ROW 

BEGIN 
    SELECT Provincia_CodigoProvincia_SEQ.NEXTVAL INTO :NEW.CodigoProvincia FROM DUAL; 
END;
/

CREATE SEQUENCE Servicio_IdServicio_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Servicio_IdServicio_TRG 
BEFORE INSERT ON Servicio 
FOR EACH ROW 

BEGIN 
    SELECT Servicio_IdServicio_SEQ.NEXTVAL INTO :NEW.IdServicio FROM DUAL; 
END;
/

CREATE SEQUENCE Sucursal_IdSucursal_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Sucursal_IdSucursal_TRG 
BEFORE INSERT ON Sucursal 
FOR EACH ROW 

BEGIN 
    SELECT Sucursal_IdSucursal_SEQ.NEXTVAL INTO :NEW.IdSucursal FROM DUAL; 
END;
/

CREATE SEQUENCE Ticket_IdTicket_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Ticket_IdTicket_TRG 
BEFORE INSERT ON Ticket 
FOR EACH ROW 

BEGIN 
    SELECT Ticket_IdTicket_SEQ.NEXTVAL INTO :NEW.IdTicket FROM DUAL; 
END;
/

CREATE SEQUENCE Trabajador_IdTrabajador_SEQ 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Trabajador_IdTrabajador_TRG 
BEFORE INSERT ON Trabajador 
FOR EACH ROW 

BEGIN 
    SELECT Trabajador_IdTrabajador_SEQ.NEXTVAL INTO :NEW.IdTrabajador FROM DUAL; 
END;
/

CREATE SEQUENCE Plaza_IdPlaza_SEQ 
    NOCACHE 
    ORDER ;


create or replace 
TRIGGER Plaza_IdPlaza
BEFORE INSERT ON Plaza 
FOR EACH ROW 

BEGIN 
    SELECT Plaza_IdPlaza_SEQ.NEXTVAL INTO :NEW.IdPlaza FROM DUAL; 
END;
/


CREATE SEQUENCE pagoestacionamiento_seq
    NOCACHE 
    ORDER 

CREATE OR REPLACE TRIGGER pagoestacionamiento_seq_trg
BEFORE INSERT ON pagoestacionamiento 
FOR EACH ROW 
BEGIN 
    SELECT pagoestacionamiento_seq.NEXTVAL INTO :NEW.idpagoestacionamiento FROM DUAL; 
END;
/

CREATE SEQUENCE boletaestacionamiento_seq
    NOCACHE 
    ORDER 

CREATE OR REPLACE TRIGGER boletaestacionamiento_seq_trg
BEFORE INSERT ON boletaestacionamiento 
FOR EACH ROW 
BEGIN 
    SELECT boletaestacionamiento_seq.NEXTVAL INTO :NEW.idboletaestacionamiento FROM DUAL; 
END;
/

CREATE SEQUENCE relacionordenservicio_seq
    NOCACHE 
    ORDER 

CREATE OR REPLACE TRIGGER relacionordenservicio_seq_trg
BEFORE INSERT ON relacionordenservicio 
FOR EACH ROW 
BEGIN 
    SELECT relacionordenservicio_seq.NEXTVAL INTO :NEW.idrelacionordenservicio FROM DUAL; 
END;
/


CREATE TABLE COMISIONES
(
IDCOMISIONES INTEGER PRIMARY KEY,
IDORDENSERVICIO INTEGER,
FECHA DATE,
TOTAL INTEGER,
DIEZPORCIENTO INTEGER,
CINCOPORCIENTO INTEGER
);


CREATE SEQUENCE COMISIONES_SEQ
    NOCACHE 
    ORDER 

CREATE OR REPLACE TRIGGER COMISIONES_SEQ_TRG
BEFORE INSERT ON COMISIONES 
FOR EACH ROW 
BEGIN 
    SELECT COMISIONES_SEQ.NEXTVAL INTO :NEW.IDCOMISIONES FROM DUAL; 
END;
/


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            17
-- CREATE INDEX                             7
-- ALTER TABLE                             39
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                          11
-- ALTER TRIGGER                            0
-- CREATE STRUCTURED TYPE                   0
-- CREATE COLLECTION TYPE                   0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                         11
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
