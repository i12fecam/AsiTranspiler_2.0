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
El bloque de instrucciones empezará inmediatamente después del bloque de variables en memoria

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

## Programas ejemplo

```
@cableado
instrucciones{

	//Carga del registro ACC con el contenido de la dirección de memoria indicada.
	lda(var){ 
		[SR+1->SR] M->GPR,0->ACC;
		[LOAD_SR (start)]  GPR+ACC->ACC;
	}


	//Carga del registro QR con el contenido de la dirección de memoria indicada.
	ldq(var){
		[LOAD_SR (start)] M->QR;
	}
	
	//Almacena el contenido del registro ACC en la dirección de memoria indicada.
	sta(var){
		[SR+1->SR] ACC->GPR;
		[LOAD_SR (start)] GPR->M;
	}

		//Almacena el contenido del registro QR en la dirección de memoria indicada.
	stq(var){
		[LOAD_SR (start)] QR->M;
	}
	
}

variables{
	variable1 = 5;
	variable2 = 6;
	resultado1 = 0;
}

programa{
	lda variable1;
	sta resultado1;
	ldq variable2;
}
```

```
@cableado
instrucciones{

	//Carga del registro ACC con el contenido de la dirección de memoria indicada.
	lda(var){ 
		[SR+1->SR] M->GPR,0->ACC;
		[LOAD_SR (start)]  GPR+ACC->ACC;
	}
	
	paraq(var){
		/*Salva ACC en la pila, QR en dir y GPR en QR (temporal)*/
		
		[SR+1->SR] QR->M , SP-1->SP; //0
		[SR+1->SR] GPR->QR , SP->MAR; //1
		[SR+1->SR] ACC->GPR; //2
		[SR+1->SR] GPR->M, QR->GPR; //3
		[SR+1->SR] GPR(AD)->MAR, 0->QR; //4

		/*ONES*/
		[SR+1->SR,LOAD SC(16)] QR->GPR; //5
		[SR+1->SR, SC-1->SC] ROL_FAQ ; //6
		{ //7
			F Zsc :[SR+1->SR] GPR+1->GPR;
			!F Zsc : [SR+1->SR];
			F !Zsc : [LOAD_SR (6)] GPR+1->GPR;
			!F !Zsc :[LOAD_SR (6)] ;
		}

		/*Guarda bit de paridad (menos significativo) en dir*/

		[SR+1->SR] GPR->QR ,0->ACC; //8
		{ //9
			Qn : [SR+1->SR] ACC+1->ACC;
			!Qn : [SR+1->SR];
		}

		/*Restaura ACC y QR*/

		[SR+1->SR] ACC->GPR M->QR;
		[SR+1->SR] SP->MAR;
		[SR+1->SR] 0->ACC;
		[SR+1->SR] M->GPR;
		[SR+1->SR] GPR+ACC->ACC;
		[LOAD_SR (start)] SP+1->SP;
		
	}
	
}

variables{
	input = 2;
	output = 0;
}

programa{
	lda input;
	paraq output;
}
```