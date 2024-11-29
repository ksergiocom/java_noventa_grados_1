if [ -z "$1" ]
then
	java -cp "bin:lib/noventagrados-gui-lib-2.0.2.jar" noventagrados.gui.NoventaGrados
else
	java -cp "bin:lib/noventagrados-gui-lib-2.0.2.jar" noventagrados.gui.NoventaGrados "$1"
fi