1.	¿Qué diferencia hay entre DPs, SPs y PX?

•PX: usan los píxeles de la pantalla.

•DPs (density-independent pixels): tienen el mismo tamaño sin tener en cuenta que tantos pixeles hay en la pantalla

•SPs (scalable pixels): es para el tamaño del texto

2.	¿Qué es un text view? ¿Cuáles son los 2 atributos (fuera del texto) que son obligatorios y que aplican también para cualquier objeto dentro de cualquier layout?

Alto y ancho

3.	¿Cuál es la diferencia entre LinearLayout y ConstrainLayout?

LinearLayout organiza los elementos en una dirección lineal (horizontal o vertical).
ConstraintLayout utiliza restricciones para posicionar y ajustar los elementos en una vista.

4.	¿En dónde se deben guardar las cadenas de texto que se quieren mostrar en una aplicación Android?

En el archivo strings 

5.	¿Cómo se llama el componente que permite enviar mensajes temporales en pantalla?

Toast

6.	¿Qué clase agrupa los identificadores de los recursos en Android?

La clase: R

7.	¿Cuándo se llama a onDestroy()?
	
Cuando la actividad termina o está siendo destruida y a punto de ser eliminada de la 	memoria.

8.	¿Cómo se llama el objeto que permite lanzar una nueva actividad desde Kotlin?
	
Intent

9.	¿Para que se usa el FrameLayout?

Para tener objetos transparentes que se pueden poner uno encima de otro, ej una imagen encima de otro objeto

10.	¿Para qué sirve un adapter?
	
Para interpretar los datos que se necesite mostrar una pantalla

11.	¿Qué clase contiene los identificadores de las vistas definidas en los layouts?

La clase: R 

12.	¿Qué atributo se debe definir para cargar los valores de un spinner?

Un array

PERMISOS
Manifest archivo de permisos

A partir del 6 api 23 piden permisos CADA VEZ QUE SE EJECUTA	 

antes en la 5.1 api 22 se necesitaba borrar para quitar permisos

Con riesgo: gps, microfono fotos, calendario, contactos

normales: Internet, bluetooth, zona horaria 

ContextCompact.ChechSelfPermision(): es para pedir permiso en un momento especifico 

shouldShowRequestestPermisionRationale(): texto de porque dar permiso 

requestPermision: pedir permiso 

Companion object: variable GLOBAL entre clases estática 

onRequiestPermisionResult: muchos if de qué hacer con los permisos que tenemos o no


Adapter personalizado: Para mostrar los datos del cursor en un ListView, es necesario crear un adapter personalizado. Primero se crea un layout para cada posición de la lista en un xml separado (New -> XML -> Layout XML File)

startActivityForResult() (en lugar de startActivity(): Para actividades que se salen de la app ej: seleccionar foto

