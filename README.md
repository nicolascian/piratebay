# TP Grupal - Segunda Entrega

![Build Status](https://travis-ci.org/lfrinaldi/template-tp-grupal.svg?branch=master) 


## Enunciado ##

Dada la repercusión que tuvo el motor de juegos de aventura gráfica, muchas personas están interesadas en crear y cargar nuevos juegos al server, pero surge la necesidad de poder crear juegos en runtime a través de configuraciones, sin necesidad de programar y extender clases del motor, es decir que dichos comandos o configuraciones instancien nuestro modelo y lo usen.  Incluso en un futuro fuera del nuestro scope se desearía que desde alguna interfaz o desde algún modo creativo o edición, se puedan crear cualquier tipo de juego dinámicamente.

Lo que se ha detectado luego de implementar los primeros juegos es que cada juego tiene cosas similares, como objetos que se relacionan con otros objetos, tienen ciertas características generales, tienen estados, tienen acciones que se pueden ejecutar (si corresponde quizás dado su estado u otras restricciones) que al ejecutarse hacen cosas sobre si mismo u otros objetos.

Se nos pide que nos abstraigamos y pensemos en un modelo capaz de representar a este tipo de juegos, es decir poder crear escenarios, con personajes, poder definirles estados, y agregarles acciones, que realicen cosas al ejecutarlas. Y que al juego se le defina una misión, que de cumplirla ganará el juego, o combinación de cosas que si se cumple perdiera el juego.

En resumen nos piden: Que el motor debe ser capaz de crear juegos de tipo aventuras, con distintos objetos, escenarios, y personajes, misiones, con solo configurar a los mismos, sin necesidad de programar o crear nuevas clases que extiendan el motor.

Para esta segunda entrega, se nos pide modificar nuestro motor, para soportar los mismos juegos implementados, pero haciendo uso de un modelo genérico de clases, que se pueda configurar pero sin necesidad de extender o de crear clases concretas de un juego en particular. Es decir no queremos tener que escribir clases como Door, Box, Stick, Wolf, etc. Sino usar una genérica a la que le podamos configurar para que represente al cada una de ellas según el juego a implementar.

Se nos pide:
- Soportar cualquier tipo de juego como los ya realizados.
- Restricción de no poder heredar para implementar nuevos juegos, solo usar nuestro modelo.
- La próxima entrega se deberá implementar durante el horario de la clase un juego dado y definido en la clase. El mismo deberá sólo deberá requerir implementar un Builder que configure el juego y sus reglas, para ser cargado en el server para poder jugar.
Dicha implementación deberá estar en un proyecto separado el cual utilice o referencie el motor desarrollado.

>**Los requerimientos pueden (y van a) cambiar en cualquier momento.**

## Condiciones ##
 - Para las consultas generales se va a utilizar el channel `#tp-grupal-channel`.
 - Cada grupo va a tener su channel para consultas particulares y comunicación con su ayudante.
 - Se debe usar el mismos toolset que para el TP0 (java 8, IntelliJ, gradle, pmd, cpd, checkstyle, findbugs).
 - Se supone que todos están al tanto de las notificaciones en Slack. Esto incluye cambios de alcance, cambios en los requerimientos, restricciones adicionales, etc.
 - Se podrán modificar la configuración del toolset sólo bajo aprobación de los ayudantes (`#quejas-tooling`).
 - Cada grupo debe crear un repositorio en GitHub y agregar a los ayudantes de la materia al mismo.
 - Se debe integrar el repositorio con Travis-CI.
 - La documentación se realizará en la misma Wiki del repositorio en GitHub.
 - En la fecha de entrega se realizará una demo del TP a uno o dos ayudantes. Esto implica que el TP se debe poder utilizar dentro de las restricciones de la entrega.
Durante la demo y posterior corrección se cargarán issues en GitHub que deben estar solucionados para la siguiente entrega.
 - **No se aceptarán TPs:**
   - **con warnings.**
   - **que no compilen en Travis-CI.**
   - **con issues abiertos.**
   - **Que no se puedan utilizar**
   - **Que no tengan documentación de uso del sistema**
   - **Que no tengan documentación del diseño del sistema**

 - **No hay re-entrega.** Es responsabilidad del grupo realizar las consultas durante las 2-3 semanas disponibles para realizar el TP.
 - Si un alumno no puede concurrir a la demo, se aceptará la entrega pero dicho alumno figurará como ausente. Esto puede repercutir en la nota final.


## Calendario tentativo ##

| Fecha       |                  |
|-----------  | -----------------|
| 5 de Mayo   | Publicación 2da Entrega |
| 12 de Mayo  | Entrega de notas 1ra Entrega |
| 19 de Mayo  | **Segunda Entrega** - Publicación 3ra Entrega |
| 26 de Mayo  | Entrega de notas 2da Entrega |
| 2 de junio  | **Tercera Entrega** |
| 9 de Junio  | Revisión |
| 16 de Junio | Cierre de notas |

