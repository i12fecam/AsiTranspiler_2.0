# Funcionamiento de Microprogramado

Para programar en microprogramado es necesario definir una serie de control de estados que se definen al principio del archivo

El bloque tendría una forma así:

```c
estados{


}
```

El estado simple consiste del nombre del control de estado seguido de una flecha, `BIF`, `INCR`, `BIF` y opcionalmente `DISABLE`.

```
estados{
 nop -> INCR DISABLE //0
 inc ->  INCR //1
 bif ->  BIF  //2
 ret -> RET //3
}
```

Si es un estado complejo se habre una llave y se describe que hacer dependiendo de las flags

```
bif_disable_if_F ->{ //5
  !F: BIF
   F: BIF DISABLE
}
```

Para la definición de instrucciones  se sigue una forma parecida a como se hace en cableado, entre corchetes se pone el estado que se quiere asociar a ese step además de instrucciones de las instrucciones `LOAD_SC` o `SC-1->SC`, después de los corchetes se pondran todas las instrucciones que se quieran hacer en ese step.

> Si un estado hace uso de BIF se le pedirá un numero al llamarlo

> No puede haber dos microinstrucciones del mismo grupo en un step 
```
pop(value){
    [inc] SP->MAR;
    [inc] M->QR SP+1->SP;
    [inc] GPR{AD}->MAR;
    [bif(0)] QR->M;
}
```