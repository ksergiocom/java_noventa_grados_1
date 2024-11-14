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
echo "Víctor Acevedo Lorenzo"
echo "Sergiy Khudley"
echo "--------------------------------------"

echo "Compilando archivos fuente en ./bin"
./compilar.sh
echo "Compilando con exito"

echo "Generando documentacion del proyecto en el directorio ./doc"
./documentar.sh
echo "Documentacion generada con exito"

echo "A jugar!"
./ejecutar_gui.sh
echo "Hasta luego :)"
