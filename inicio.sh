#!/bin/bash

echo "${c1}"
echo ".................@@. @@..............."
echo "...............#.      @.............."
echo "...............@   @.  :@............."
echo "..........@@@:         :@............."
echo "..............@        ::@............"
echo "..............:        ::@............"
echo "..............@        ::@............"
echo "..............+        .::@..........."
echo ".............@          ::@..........."
echo ".............@         .:::@.........."
echo "............:.          :::@.........."
echo "............@           ::::@........."
echo "...........@            .:::@........."
echo "............@%@          :@..........."
echo "................@ .@.@..@=............"
echo "..................@..@................"
echo "..................@...@..............."
echo "..................@...@..............."
echo "...............@@@@..@@..............."
echo "...................@*@................"

echo "--------------------------------------"
echo "Metodología de la Programacion"
echo "PRÁCTICA OBLIGATORIA 1 – PRIMERA CONVOCATORIA"
echo "Noventa grados"
echo
echo "Autores:"
echo "Víctor Acevedo Lorenzo (Grupo 202)"
echo "Sergiy Khudley (Grupo 102)"
echo "--------------------------------------"

echo "Compilando archivos fuente en ./bin"
./compilar.sh
echo "Compilando con exito"

echo "Generando documentacion del proyecto en el directorio ./doc"
./documentar.sh
echo "Documentacion generada con exito"

echo "A jugar!"
if [ -z "$1" ]
then
	./ejecutar_gui.sh
else
	./ejecutar_gui.sh "$1"
fi


echo "Hasta luego :)"
