drop table cl_estudio;
drop table cl_cita;
drop table cl_usuario;
drop table cl_historial;
drop table cl_empleado;
drop table cl_antecedente;
drop table cl_paciente;
drop table cl_tipodocumento;
commit;

CREATE TABLE CL_ANTECEDENTE
  (
    ante_id  NUMBER NOT NULL ,
    ante_quir VARCHAR2 (150) ,
    ante_pato VARCHAR2 (150) ,
    ante_aler VARCHAR2 (150) ,
    ante_fami VARCHAR2 (150) ,
    ante_otro VARCHAR2 (150) ,
    paci_id   NUMBER NOT NULL
  )
  ;
ALTER TABLE CL_ANTECEDENTE ADD CONSTRAINT CL_ANTECEDENTE_PK PRIMARY KEY ( ante_id ) ;
CREATE TABLE CL_CITA
  (
    cita_id   NUMBER NOT NULL ,
    cita_fech DATE NOT NULL ,
    paci_id   NUMBER NOT NULL ,
    empl_id   NUMBER NOT NULL ,
    hist_id   NUMBER NOT NULL
  )
  ;
ALTER TABLE CL_CITA ADD CONSTRAINT CL_CITA_PK PRIMARY KEY ( cita_id ) ;
CREATE TABLE CL_EMPLEADO
  (
    empl_id   NUMBER NOT NULL ,
    tdoc_id   NUMBER NOT NULL ,
    empl_docu VARCHAR2 (50) NOT NULL ,
    empl_nomb VARCHAR2 (50) NOT NULL ,
    empl_apel VARCHAR2 (50) NOT NULL ,
    empl_tipo CHAR (1) NOT NULL ,
    empl_espe VARCHAR2 (50) ,
    empl_fnac date,
    empl_telf VARCHAR2 (20) ,
    empl_dire VARCHAR2 (50) ,
    empl_esta CHAR (1) NOT NULL
  )
  ;
ALTER TABLE CL_EMPLEADO ADD CONSTRAINT CL_EMPLEADO_PK PRIMARY KEY ( empl_id ) ;
CREATE TABLE CL_ESTUDIO
  (
    estu_id   NUMBER NOT NULL ,
    estu_tipo CHAR (1) NOT NULL ,
    estu_desc VARCHAR2 (20) NOT NULL ,
    paci_id   NUMBER NOT NULL
  )
  ;
ALTER TABLE CL_ESTUDIO ADD CONSTRAINT CL_ESTUDIO_PK PRIMARY KEY ( estu_id ) ;
CREATE TABLE CL_HISTORIAL
  (
    hist_id   NUMBER NOT NULL ,
    hist_tens NUMBER ,
    hist_pres NUMBER ,
    hist_ritm NUMBER ,
    hist_temp NUMBER ,
    hist_freg DATE NOT NULL ,
    hist_moti VARCHAR2 (50) ,
    hist_esta CHAR (1) NOT NULL
  )
  ;
ALTER TABLE CL_HISTORIAL ADD CONSTRAINT CL_HISTORIAL_PK PRIMARY KEY ( hist_id ) ;
CREATE TABLE CL_PACIENTE
  (
    paci_id   NUMBER NOT NULL ,
    tdoc_id   NUMBER NOT NULL ,
    paci_docu VARCHAR2 (50) NOT NULL ,
    paci_nomb VARCHAR2 (50) NOT NULL ,
    paci_apel VARCHAR2 (50) NOT NULL ,
    paci_fnac date,
    paci_telf VARCHAR2 (20) ,
    paci_dire VARCHAR2 (50) ,
    paci_esta CHAR (1) NOT NULL
  )
  ;
ALTER TABLE CL_PACIENTE ADD CONSTRAINT CL_PACIENTE_PK PRIMARY KEY ( paci_id ) ;
CREATE TABLE CL_TIPODOCUMENTO
  (
    tdoc_id   NUMBER NOT NULL ,
    tdoc_nomb VARCHAR2(30)
    --  ERROR: VARCHAR2 size not specified
    NOT NULL
  )
  ;
ALTER TABLE CL_TIPODOCUMENTO ADD CONSTRAINT CL_TIPODOCUMENTO_PK PRIMARY KEY ( tdoc_id ) ;
CREATE TABLE CL_USUARIO
  (
    user_id   NUMBER NOT NULL ,
    user_user VARCHAR2 (30) NOT NULL ,
    user_pass VARCHAR2 (30) NOT NULL ,
    user_esta CHAR (1) NOT NULL ,
    empl_id   NUMBER NOT NULL
  )
  ;
ALTER TABLE CL_USUARIO ADD CONSTRAINT CL_USUARIO_PK PRIMARY KEY ( user_id ) ;
ALTER TABLE CL_ANTECEDENTE ADD CONSTRAINT CL_ANTECEDENTE_CL_PACIENTE_FK FOREIGN KEY ( paci_id ) REFERENCES CL_PACIENTE ( paci_id ) NOT DEFERRABLE ;
ALTER TABLE CL_CITA ADD CONSTRAINT CL_CITA_CL_EMPLEADO_FK FOREIGN KEY ( empl_id ) REFERENCES CL_EMPLEADO ( empl_id ) NOT DEFERRABLE ;
ALTER TABLE CL_CITA ADD CONSTRAINT CL_CITA_CL_HISTORIAL_FK FOREIGN KEY ( hist_id ) REFERENCES CL_HISTORIAL ( hist_id ) NOT DEFERRABLE ;
ALTER TABLE CL_CITA ADD CONSTRAINT CL_CITA_CL_PACIENTE_FK FOREIGN KEY ( paci_id ) REFERENCES CL_PACIENTE ( paci_id ) NOT DEFERRABLE ;
--  ERROR: FK name length exceeds maximum allowed length(30)
ALTER TABLE CL_EMPLEADO ADD CONSTRAINT CL_EMPL_CL_TDOC_FK FOREIGN KEY ( tdoc_id ) REFERENCES CL_TIPODOCUMENTO ( tdoc_id ) NOT DEFERRABLE ;
ALTER TABLE CL_ESTUDIO ADD CONSTRAINT CL_ESTUDIO_CL_PACIENTE_FK FOREIGN KEY ( paci_id ) REFERENCES CL_PACIENTE ( paci_id ) NOT DEFERRABLE ;
--  ERROR: FK name length exceeds maximum allowed length(30)
ALTER TABLE CL_PACIENTE ADD CONSTRAINT CL_PACI_CL_TDOC_FK FOREIGN KEY ( tdoc_id ) REFERENCES CL_TIPODOCUMENTO ( tdoc_id ) NOT DEFERRABLE ;
ALTER TABLE CL_USUARIO ADD CONSTRAINT CL_USUARIO_CL_EMPLEADO_FK FOREIGN KEY ( empl_id ) REFERENCES CL_EMPLEADO ( empl_id ) NOT DEFERRABLE ;

commit;
