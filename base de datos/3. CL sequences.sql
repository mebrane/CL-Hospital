 drop sequence cl_tipodocumento_seq;
  CREATE SEQUENCE cl_tipodocumento_seq
  MINVALUE 3
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20;
  
  
   drop sequence cl_empleado_seq;
  CREATE SEQUENCE cl_empleado_seq
  MINVALUE 3
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20;
  
     drop sequence cl_usuario_seq;
  CREATE SEQUENCE cl_usuario_seq
  MINVALUE 2
  MAXVALUE 999999999999999999999999999
  START WITH 2
  INCREMENT BY 1
  CACHE 20;

  commit;
  
  select * from cl_tipodocumento;
  
  select * from cl_empleado;