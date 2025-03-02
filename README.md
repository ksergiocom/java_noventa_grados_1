# Práctica 2 - Noventa grados

*Los archivos de script están escritos en bash para ser lanzados en GNU/Linux*

## Autores
**Víctor Acevedo Lorenzo** *GRUPO 202*

**Sergiy Khudoley** *GRUPO 102*

## Coautores
Hemos recibido ayuda por parte de nuestros compañeros **María Guzmán Valdezate** y **Juan Francisco Benavente Carzolio** para la realización del paquete *control.undo* .

Hemos recibido ayuda por parte de **Guillermo López de Arechavaleta Zapatero** para hacer el paquete *textui*.

## Actualización 2024-11-29 (NoventaGrados 2.0)
En esta nueva práctica hemos reutilizado la anterior para agregarle un mecanismo de registros ó historico de jugadas.
Este mecanismo está implementado con dos versiones diferentes, uno guardando los estados de la partida en cada jugada y otro guardando el registro de jugadas aplicadas. 

Para desarollarlo hemos utilizado una jerarquía de herencias en el nuevo paquete **noventagrados.control.undo** que tiene una interfaz con los métodos a implementar, una clase abstracta con la lógica compartida de los dos mecanismos de historico y por ultimo las dos clases concretas con la implementación especifica de cada uno de los mecanismos.

Además se ha mejorado el control de errores creando una excepción personalizada y considerando posibles nuevos errores en nuestro main.

*Se ha actualizado el script **ejecutar_textui.sh** y **ejecutar_gui.sh** para recibir un parametro adicional.

### Listado correciones

1. Codificación UTF-8
2. Celda *clonacion más sencilla*
3. Pieza *corrección atributos privados*
4. Tablero *Agregando constantes*
5. Arbitro *cambiar turno usando método de Color*
6. Caja *Definida constnte para tamaño máximo*
7. TableroConsultor *Borrado el hashCode y equals*
8. Agregando mensajes de error


***

## Introducción

El objetivo fundamental es implementar el juego de Noventa Grados, un juego de tablero abstracto de
origen alemán. A continuación se describen las reglas a implementar1.

Se utiliza un tablero de 7x7 celdas, para dos contrincantes: con siete piezas de color blanco y negro
respectivamente. Una de esas siete piezas juega el papel de reina, considerando al resto peones.

Para la colocación inicial de las piezas se tomará siempre como referencia la siguiente figura en la Ilustra-
ción 1. Donde las piezas blancas ocupan la esquina superior izquierda, y las negras la esquina inferior de-
recha, con las correspondientes reinas en sus esquinas:

![Jugada inicial](images/inicio.jpg)

Los objetivos para ganar la partida son iguales para ambos contrincantes: expulsar del tablero a la reina
del contrincante o bien colocar su reina en el centro del tablero. Cumpliendo cualquiera de estas dos con -
diciones, se gana la partida.

En cada turno los jugadores podrán desplazar solo una de sus piezas dentro del tablero. Los
movimientos solo pueden ser en horizontal y vertical. La única distancia válida a la que se puede
desplazar está determinada por el número de piezas que se encuentren en su perpendicular con
independencia del color y contándose a sí misma, de ahí el nombre del juego, puesto que siempre hay
que contar en 90 grados cuantas piezas hay.

Al desplazarse la pieza, el efecto que se produce en las piezas con las que se choca, es que se
desplazan en ese mismo sentido (literalmente, se empuja a las piezas). Al empujar, puede
darse la situación que se expulsa o echa a una pieza del tablero, pasando a su correspondiente caja.

En relación a las reglas, se toma como referencia siempre lo indicado en este enunciado y lo solicitado por los tests automáticos
proporcionados.

![Victoria reina centro](images/victoria_blanca.jpg)

Se permite que un contrincante provoque su propia derrota expulsando a su reina del tablero. Si al
empujar se expulsan ambas reinas se considerará una situación de empate.

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