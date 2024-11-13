#Buscamos todos los archivos a compilar
find src -name "*.java" > sourcepath.txt
#Compilamos con la opcion de sourcepath
javac -d bin -sourcepath src @sourcepath.txt
#Borro el archivo sourcepath.txt para no dejar basura :)
rm sourcepath.txt

