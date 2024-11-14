# Práctica 1 - Noventa grados

## Autores
**Víctor Acevedo Lorenzo**

**Sergiy Khudoley**

## Comentarios sobre el código
	1- Hemos realizado una modificación en el método de validarFormato de la clase NoventaGrados del paquete "textui" para
	   prevenir un error en el caso de dar un string de menor tamaño al esperado. En este caso podía podía ocurrir un 
	   StringIndexOutOfBoundsException.
	   
	2- El método empujar de la clase Árbitro se ha implementado de dos formas diferentes, una iterativa y otra recursiva. 
       Mantenemos comentada una versión de la iterativa que utiliza un LinkedList a modo de pila FIFO para ordenar las 
       piezas necesarias a empujar.
       
	3- El método configuraciónInicial de Árbitro se podría abreviar utilizando índices y bucles. Nos hemos ahorrado
	   este para mayor claridad y simplicidad.
	   
	   
## Extras
	1- Hemos utilizado git como gestor de versiones donde se puede ver el proceso que hemos seguido para tener
	   una traza del proyecto y familiarizarnos a trabajar con esta herramienta.
	   
	2- Hemos agregado un script de bash `inicio.sh` para compilar, documentar y lanzar el juego en un único fichero.
	
	
## Posibles mejoras
	1- Hemos tenido bastante problemas con los consultar y obtener por no tener claro cual era el que clonaba y cual
	   traia una referencia. Quizás fuese más sencillo para otra ocasión modificar el nombre a consultarClon, por ejemplo.
	   
	2- Estaría bien tener una forma de cancelar una jugada en modo gráfico en vez de estar obligado a realizar una incorrecta
	   en caso de haber seleccionado una pieza y querer rectificar.