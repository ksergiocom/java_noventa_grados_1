if [ -z "$1" ]
then
  java -cp "bin" noventagrados.textui.NoventaGrados 
else
	java -cp "bin" noventagrados.textui.NoventaGrados "$1"
fi
