# Preguntas miércoles 28 Nov

1. strings.xml
- Como se organizan los strings? 
- res/values-es/string.xml
- definir un string por activity
- tengo que definir por ejemplo  <string name="minigame_title">Minijuego</string> tanto en res/values/strings.xml como en res/values-es/strings.xml



2. Cómo se organizan los layouts?
- [layout folders](https://stackoverflow.com/questions/4930398/can-the-android-layout-folder-contain-subfolders)
- res/layouts/activities/"nombreActivity"
- res/layouts/content/"nombreContent"
- res/layouts/fragments/"nombreFragment"


# Preguntas miércoles 5 Dic

1. Para el minijuego 
- Razas y pelajes
- interacción B (palabra a imágenes)
- con nivel de dificultad 2 (4 imágenes)


## ACTIVITY
1. Hay la misma cantidad de razas que de imágenes?
2. Si hay n Razas y m Pelajes, puedo ir variando R2, P4, R1, R4, P5...
3. cómo es la aleatoriedad de la imágenes con las que asocio la palabra?
4. cuántos tipos de juegos existen? 18 combinaciones

## ALMACENAMIENTO
1. uso *preferences* para guardar los datos de las jugadas? 

## COMBINACIÓN DE JUGAS Y ACTIVITIES

Jugada: ITEM PPAL + ITEMS ASOCIADOS (2 a 4)

- I   3 minijuegos: RyP, RyPJ, C
- II  2 niveles: 1, 2
- III 3 interacciones: A,B,C

juego 1:  RyP 1 A

juego 2:  RyP 1 B

juego 3:  RyP 1 C

juego 4:  RyP 2 A

juego 5:  RyP 2 B *este elijo implementar*

juego 6:  RyP 2 C

juego 7:  RyPJ 1 A

juego 8:  RyPJ 1 B

juego 9:  RyPJ 1 C

juego 10: RyPJ 2 A

juego 11: RyPJ 2 B

juego 12: RyPJ 2 C

juego 13: C    1 A

juego 14: C    1 B

juego 15: C    1 C

juego 16: C    2 A

juego 17: C    2 B

juego 18: C    2 C

agrupo por I (minijuego), II (niveles) o III (interacciones)?

### Para el juego 5
1.  Genero una `Activity` 
2.  contenido fijo: item ppal (texto) + items asociados (4 imgs)
3.  cantidad jugadas: n.m  (n razas, m pelajes)


### Suposicion:
1. hay n razas
2. hay m pelajes
3. hay n imágenes de razas
4. hay m  imágenes de pelajes
5. el juego tiene n.m *jugadas*
6. inicio del juego:
..1. nuevo juego: 
..2. configuración guardada
7. Jugadas:
..1. cantidad: n.m
..2. entre cada una: volver a jugar | siguiente
..3. nueva jugada: actualiza json


```json
{
    settings: {...},
    minigames: {
        razasYPelajes: {
            ultimaJugadaGanada: 0, (*1)
            secuenciaDeJugadas: 1,2,3,4,5 (*2)
        },
        razasYPelajesJuntas: {},
        cruzas: {}
    }
}

```

 `(*1)` indica un se actualiza por jugada. Indica alguna de "secuenciaDeJugadas"
 `(*2)` la secuencia de niveles es aleatoria y se genera al configurar el juego

