## Preguntas de repaso

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
```

## Preguntas de repaso David

- Ordene los diferentes LocationRequest que son usados para solicitar la posición del dispositivo del mas al menos exacto <br>
       -1. PRIORITY_HIGH_ACCURACY <br>
       -2. PRIORITY_BALANCED_POWER_ACCURACY <br>
       -3. PRIORITY_LOW_POWER <br>
       -4. PRIORITY_NO_POWER <br>
- Para utilizar recursos con permisos de riesgo en Android se deben seguir los siguientes pasos: <br>
      -1. Desde el manifest.xml definir los permisos a utilizar <br>
      -2. Si el permiso no ha sido otorgado se puede solicitar el usuario el permiso utilizando la       función: ActivityCompat.requestPermissions(context, new String[]{permission},id); <br>
      -3. Cuando se inicia una actividad se debe verificar si los permisos ya han sido otorgados previamente usando:  ContextCompat.checkSelfPermission(context, permission) ==PackageManager.PERMISSION_DENIED. <br>

- Ordene los siguientes métodos del ciclo de vida de una actividad en Android: <br>
   -1. onCreate() 
   -2. onStart()
   -3. onResume()
   -4. onPause()
   -5. onStop()
   -6. onDestroy()
- Un Framelayout tiene como función mostrar un solo elemento pero se pueden tener varios elementos, y estos se muestran uno sobre otro. <br>
  Verdadero
- ¿Si quiero posicionar los elementos de una interfaz relativos a otros elementos, que layout debo usar? <br>
 constraint layout
- Los DPs son utilizados para definir posiciones y espacios de los elementos en el layout de una actividad? <br>
 Verdadero
- ¿Para que se usa un LinearLayout? <br>
  El LinearLayout organiza los elementos hijos en dirección vertical o horizontal.
- Los Intent me permiten realizar las siguientes operaciones:
1. Lanzar la cámara, galería del dispositivo <br>
2. Hacer transición entre actividades <br>
3. Lanzar actividades de otras aplicaciones instaladas en el dispositivo <br>

- Un intent que sea definido como: Intent intent = new Intent(Intent.ACTION_PICK); Intent.setType(“image/*”); Me permite: <br>
Abrir la app galería o gestor de archivos.
- En un <TextView>, Cuáles son sus atributos obligatorios? <br>
-android:layout_height_”wrap_content” <br>
-android:textSize <br>
-android:id=”@+id/text_view_id”  <br>
-android:layout_width=”wrap_content” <br>

- Los bundles son utilizados para el envío de información entre las actividades al momento de llamar el método onCreate() <br>
Falso

- Cuales de los siguientes permisos requieren autorización del usuario en tiempo de ejecución (es decir que son con riesgo)? <br>
Almacenamiento <br>
Internet <br>
NFC <br>
Localización <br>
Bluetooth <br>
Cámara <br>

- De los siguientes elementos, cuál NO debe ubicarse en la carpeta de recursos de una aplicación? <br>
Valores de arreglos de cadenas.

- Cuando se hace una solicitud de localización y se usa el parámetro: PRIORITY_BALANCED_POWER_ACCURACY, Se está obligando al dispositivo a encender el GPS <br>
Falso

- La actividad principal de una aplicación se define en: <br>
 manifest




 

