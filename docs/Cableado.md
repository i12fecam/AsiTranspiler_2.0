# Funcionamiento de cableado


Para programar en cableado solamente es necesario definir cada uno de los steps de las instrucciones.

>Un step es un paso que puede contener varias microinstrucciones que se ejecutan en el mismo ciclo



Cada step también tiene asociado un control de flujo asociado, estos pudiendo ser `SR+1->SR`, `SC-1->SC`, `LOAD_SR` y `LOAD_SC` estos dos ultimos necesitan también un valor asociado poniendo `(NUM)`detras suya.

Un step simple se vería así:
```
[SR+1->SR] GPR+ACC->GPR, 0->F ;
```

También se permite hacer steps complejos que consiste en que un step ejecuta unas microinstrucciones diferentes dependiendo de las flags activadas por el sistema en ese momento.

Para escribir un step complejo se abre unas `{}` que representaran el step, a continuacion se pondra la flagEnum correspondiente que podra ser negada con `!`,  el simbolo `:` y después como si fuera una instrucción simple.

```
[SR+1->SR] GPR+ACC->GPR, 0->F ;
{
	!Z:[SR+1->SR] !ACC->ACC;
	Z:[LOAD_SR (0)] ;
}
```


Un ejemplo de este bloque de instrucciones completo sería el siguiente

```
ejemplo
```