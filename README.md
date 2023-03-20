## Preguntas de QUICES

- ¿Qué diferencia hay entre DPs, SPs y PX?

  •PX: usan los píxeles de la pantalla.

  •DPs (density-independent pixels): tienen el mismo tamaño sin tener en cuenta que tantos pixeles hay en la pantalla

  •SPs (scalable pixels): es para el tamaño del texto

- ¿Qué es un text view? ¿Cuáles son los 2 atributos (fuera del texto) que son obligatorios y que aplican también para cualquier objeto dentro de cualquier layout? <br>
Alto y ancho

- ¿Cuál es la diferencia entre LinearLayout y ConstrainLayout? <br>
LinearLayout organiza los elementos en una dirección lineal (horizontal o vertical). ConstraintLayout utiliza restricciones para posicionar y ajustar los   elementos en una vista.

- ¿En dónde se deben guardar las cadenas de texto que se quieren mostrar en una aplicación Android? <br>
  En el archivo strings

- ¿Cómo se llama el componente que permite enviar mensajes temporales en pantalla? <br>
  Toast

- ¿Qué clase agrupa los identificadores de los recursos en Android? <br>
  La clase: R

- ¿Cuándo se llama a onDestroy()? <br>
  Cuando la actividad termina o está siendo destruida y a punto de ser eliminada de la memoria.

- ¿Cómo se llama el objeto que permite lanzar una nueva actividad desde Kotlin? <br>
  Intent

- ¿Para que se usa el FrameLayout? <br>
  Para tener objetos transparentes que se pueden poner uno encima de otro, ej una imagen encima de otro objeto

- ¿Para qué sirve un adapter? <br>
  el adapter sisrve para adaptar el contenido a diferentes tipos de patanllas/actividades

- ¿Qué clase contiene los identificadores de las vistas definidas en los layouts? <br>
  La clase: R

- ¿Qué atributo se debe definir para cargar los valores de un spinner? <br>
  Un array

## Apuntes Manifest (permisos)

- A partir del 6 api 23 piden permisos CADA VEZ QUE SE EJECUTA

- antes en la 5.1 api 22 se necesitaba borrar para quitar permisos

- **Con riesgo:** gps, microfono fotos, calendario, contactos

- **normales:** Internet, bluetooth, zona horaria

- Es para pedir permiso en un momento especifico
```bash
ContextCompact.ChechSelfPermision()
```
- Texto de porque dar permiso
```bash
shouldShowRequestestPermisionRationale()
```
- Pedir permiso
```bash
requestPermision
```
- variable GLOBAL entre clases estática
```bash
Companion object
```
- muchos if de qué hacer con los permisos que tenemos o no
```
onRequiestPermisionResult
```
- **Adapter personalizado:** Para mostrar los datos del cursor en un ListView, es necesario crear un adapter personalizado. Primero se crea un layout para cada posición de la lista en un xml separado (New -> XML -> Layout XML File)

- en lugar de startActivity(): Para actividades que se salen de la app ej: seleccionar foto
```
startActivityForResult()
