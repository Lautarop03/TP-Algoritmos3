# TP Algoritmos 3

Este es un juego basado en Pokemon rojo.

---

## Información General

Para poder ejecutar el programa se debe contar con Java-17.0.8 
```bash
sudo apt-get install openjdk-17-jdk
```
y Maven

```bash
sudo apt install maven
```

---


## Como correr el juego

Una vez clonado el repositorio y parado en la carpeta TP-Algoritmos3

Instalamos las dependencias y compilamos el proyecto:

```bash
mvn install
```

Una vez compilado lo ejecutamos:

```bash
java -jar target/TP-Algoritmos-1-jar-with-dependencies.jar
```

---

## Como jugar

- Todo el juego se va a realizar por consola
- Se van a pedir los nombres de los jugadores y luego podran jugar seleccionando las opciones deseadas
- El juego termina cuando un jugador se rinde o se le mueren todos los pokemons

```python
Ingrese nombre de jugador: xxx
Ingrese nombre de jugador: vvv

Turno de: xxx
1. Rendirse
2. Ver el campo de batalla
3. Intercambiar Pokemon
4. Aplicar item
5. Ataque
Ingrese numero de la opcion deseada: 

```
