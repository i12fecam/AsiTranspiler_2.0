# Estructura de archivo de programa

El archivo se divide en tres partes, obligatorias y ordenadas de la siguiente manera

## Bloque de instrucciones

El bloque se define escribiendo

```
@Cableado
Instrucciones {
    ...
}
```


Dentro de este bloque se puede inscribir instrucciones que tomaran los argumentos `dir` para cuando reciba como argumento una posición de instrucción, `var` en caso que reciba la dirección de memoria de de variables , `num` si recibe un numero literal como argumento o nada si no lo requiere.

El nombre de las instrucciones deberán empezar por letra minúscula.

```
escribir(num){
	...
}
saltarA(dir){
	...
}
restar(var){
	...
}
resetear(){
	...
}
```

Dentro de cada instrucción se escriben los steps, estos son conjuntos de microinstrucciones que se ejecutan en el mismo espacio de tiempo

Cada step también tiene asociado un control de flujo asociado, estos pudiendo ser `SR+1->SR`, `SC-1->SC`, `LOAD_SR` y `LOAD_SC` estos dos ultimos necesitan también un valor asociado poniendo `(NUM)`detras suya.

Un step simple se vería asi
```
[SR+1->SR] GPR+ACC->GPR, 0->F ;
```

También se permite hacer steps complejos que consiste en que un step ejecuta unas microinstrucciones diferentes dependiendo de las flags activadas por el sistema en ese momento

Para escribir un step complejo se abre unas `{}` que representaran el step, a continuacion se pondra la flag correspondiente que podra ser negada con `!`,  el simbolo `:` y después como si fuera una instrucción simple.

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

## Bloque de variables

El bloque se define escribiendo

```
variables{

}
```

Las variables se reservan al principio de la memoria, deben empezar en minuscula y pueden ser de varios tipos

El primer tipo es la variable simple que reserva un solo espacio y puede ser inicializada con un valor hexadecimal como `0x14E` o con un número decimal de manera normal.

```
valor1 = 14;
valor2 = 0x2E3;
```

El segundo tipo de variable es el vector que reserva un espacio mayor que 1, y puede ser inicializada con todos los espacios al mismo valor o asignandose manualmente

```
data [3] = {1,2,3};
cumulative [3] = {0}
```


## Bloque de programa

El bloque se define escribiendo
```
programa{
	...
}
```

Dentro del programa se podrá inscribir usar las instrucciones que hayamos definidos antes juntos a las variables

Este bloque también ofrece la capacidad de marcar pasos del programa para que puedan ser referenciados posteriormente mediante usos del mark

```
MARK inicio
sumar data[0];
guardar cumulative[0];
sumar data[1];
guardar cumulative[1];
sumar data[2];
guardar cumulative[2];
saltarSiNoZ inicio;
```

La posición a la que se refiere mark será la de la instrucción siguiente

## Comentarios

Se puede hacer comentarios en cualquier parte del fichero

Los comentarios en linea tendran la sintaxis

```
//Comentarios en linea
```

Y los comentarios multilinea tendrán las sintaxis

```
/*Hola
Soy
Un
Comentario
multilinea
*/
```

