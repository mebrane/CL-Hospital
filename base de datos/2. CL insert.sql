INSERT INTO CL_TIPODOCUMENTO
  (TDOC_ID, TDOC_NOMB
  ) VALUES
  (1, 'DNI'
  );
  
  INSERT INTO CL_TIPODOCUMENTO
  (TDOC_ID, TDOC_NOMB
  ) VALUES
  (2, 'CARNET'
  );
  
  
  INSERT
INTO CL_EMPLEADO
  (
    EMPL_ID,
    EMPL_ESTA,
    EMPL_NOMB,
    EMPL_DOCU,
    EMPL_ESPE,
    EMPL_DIRE,
    EMPL_TIPO,
    TDOC_ID,
    EMPL_APEL,
    EMPL_fnac,
    EMPL_TELF
  )
  VALUES
  (
    1,--id
    'A',--esta
    'Nombre 1',
    '11111111',--doc
    'Cardiología',--esp
    'Dire 1',
    'M',--tipo
    1,--tdoc
    'Apell. 1',
    null,
    '1234567'
  );
  
    
  INSERT
INTO CL_EMPLEADO
  (
    EMPL_ID,
    EMPL_ESTA,
    EMPL_NOMB,
    EMPL_DOCU,
    EMPL_ESPE,
    EMPL_DIRE,
    EMPL_TIPO,
    TDOC_ID,
    EMPL_APEL,
    EMPL_fnac,
    EMPL_TELF
  )
  VALUES
  (
    2,--id
    'A',--esta
    'Nombre 2',
    '22222222',--doc
    'Otorrinolaringología',--esp
    'Dire 2',
    'M',      --tipo
    1,    --tdoc
    'Apell. 2',
    null,
    '7654321'
  );
  
  INSERT
INTO CL_USUARIO
  (
    USER_ID,
    USER_USER,
    EMPL_ID,
    USER_ESTA,
    USER_PASS
  )
  VALUES
  (
    1,
    'admin', --user
    2, --empl
    'A',
    'admin' --pass
  );
  
  
  commit;