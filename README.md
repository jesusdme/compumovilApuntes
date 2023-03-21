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
  
- Colocar margenes 
  padding 
  
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

## Resumen David

### Arquitectura:
Linux Kernel
- HAL <br>
Interface to expose hardware capabilities
- Android Runtime <br>
Each App runs on an instance of ART (Like the JVM)
- Native C/C++ Libraries <br>
Support for native libraries in C and C++.
Used for 2D and 3D graphics.
- Java API Framework <br>
API available from Java code for UI,
resources, notifications, activities....
- System Apps <br>
Main apps included with the OS

### STRINGS:
- Android maneja un conjunto de recursos dentro de los que se encuentran las
cadenas.
- La idea es definir las cadenas que se van a usar en la aplicación en un archivo
separado, lo que facilita la modificación de las mismas, así como soportar por
ejemplo, diferentes idiomas.


### ACTIVIDADES:
Toda aplicación tiene una actividad principal definida en el
manifest.xml <br>
Una aplicación se compone de varias actividades <br>
• Cada actividad se conforma de dos partes, el layout de presentación
(XML) y la lógica (Kotlin)

### RECURSOS:

Al igual que desde los archivos XML, android automáticamente mantiene una clase R
en donde se crean referencias a todos los recursos <br>
• Para identificar un elemento gráfico desde la vista XML, se agrega un atributo de
identificación:

```bash
<EditText
android:id= "@+id/loginText"
android:layout_width="match_parent"
android:layout_height="wrap_content"/>
```

### DIFERENCIA ENTRE VAL Y VAR:

Kotlin utiliza dos palabras clave diferentes para declarar variables: val y var .  <br>
- Val: para una variable cuyo valor no cambia nunca, similar a constantes
- Var: para una variable cuyo valor puede cambiar, similar a variables <br>
• Tanto a val como a var se le puede definir el tipo de objeto que almacenará desde
su declaración directamente, o se puede dejar que lo infiera a partir de la
asignación en su inicialización. <br>
• Particularmente para var el tipo de dato deberá mantenerse a lo largo del
programa

### CICLO DE VIDA:
Una actividad pasa por diferentes etapas durante su ejecución: <br> 
- Android define una serie de callbacks que se ejecutan en cada momento del ciclo de vida.
- Cuando se lanza una aplicación se utilizan, onCreate() y onStart()
- Cuando el usuario empieza a dejar la actividad, el sistema llama a los callbacks que desarman la
actividad. En algunos casos esta acción es sólo parcial (onPause()), por ejemplo cuando el usuario
cambia a otra aplicación, y aún puede volver a utilizar la actividad donde la dejó
- En este último caso la actividad se reactiva con el callback onResume()
- El sistema puede terminar los procesos de una aplicación y sus actividades (onStop() y
onDestroy()) dependiendo de los recursos disponibles y otras variables como el tiempo que ha
estado inactiva. También lo puede hacer el usuario directamente al cerrar la aplicación
- Dependiendo de la complejidad de la actividad, no se necesitan manejar todos los estados del ciclo de vida

### CICLO DE VIDA AL CAMBIAR ENTRE ACTIVIDADES:
Cuando las dos actividades están en el mismo proceso (app) y una está iniciando a la
otra. Este es el orden de las acciones que ocurren cuando la actividad A inicia la
actividad B: <br>
- El método onPause() de la Actividad A se ejecuta.
- Los métodos onCreate(), onStart(), y onResume() de la Actividad B se ejecutan en
secuencia. (La Actividad B tiene ahora el foco del usuario).
- Entonces, si la Actividad A ya no es visible en la pantalla, su método onStop() se
ejecuta.




### TIPOS DE INTENTS:
Una aplicació n típicamente esta compuesta por varias actividades o llamadas a
servicios del telefono. Hay dos tipos de intents: implícito y explícito. <br>
- Un intent explícito es muy específico y se usa cuando se conoces la actividad precisa
que se iniciará (a menudo, se trata de una pantalla en la misma app y es el más
frecuente)
- Un intent implícito es un poco más abstracto y se usa para indicar al sistema el tipo
de acción, como abrir un vínculo, redactar un correo electrónico o realizar una
llamada telefónica, y el sistema es responsable de determinar la forma en que
completará la solicitud.


### BOTONES:
Se lanza la actividad desde el método onClick(View)
 
### LOGS:
Android provee un API para crear mensajes y controlar lo que pasa en la
aplicación


### LAYOUTS
Un layout describe la estructura de los elementos que aparecen en
pantalla <br>
Se pueden declarar layouts de dos formas: <br>
- Declarar elementos UI en XML. Utilizar los elementos provistos por android
para crear los elementos que se visualizan en la pantalla.
- Instanciar los elementos en ejecución: La aplicación crea objetos de vistas y
grupos y manipula sus propiedades programaticamente.
Todos los archivos xml se compilan en una vista (View) <br>
• La geometría de una vista es un rectángulo <br>
• Un layout puede tener un padding, que puede ser usado <br>
para ubicar mejor algunos elementos en la pantalla
(Márgen). Ejemplo, 10 dps de márgen a la izquierda
derecha arriba y abajo. Equivalente a usar sólo padding.

### WEIGHT
Un valor que se utiliza en un LinearLayout para indicar la importancia
de un elemento en términos del espacio que ocupa en el padre. <br>
• Cada elemento dentro de la vista puede especificar un peso, y de
acuerdo al valor, se llenará el espacio disponible en el padre. <br>
• El valor por defecto es 0 y lo que se busca es la comparación con el
peso de los demás elementos en un LinearLayout. <br>

### SPINNER

Permite seleccionar un valor de una lista de valores predeterminados. <br>
• Los valores pueden estar definidos en la aplicación, o pueden ser obtenidos de
un servicio remoto y utilizados dinámicamente.

### FRAMELAYOUT
Se usa como un marco o espacio en la pantalla y su función es mostrar
un elemento. <br>
• Se pueden tener varios elementos, pero estos se muestran uno sobre
otro (superpuestos).

### CONSTRAINLAYOUT
Se usa para crear layouts cuya posición es relativa a otro elemento del
layout. Se manejan ejes horizontal y vertical <br>
• Eje horizontal: Left, Right, Start, and End <br>
• Eje vertical: Top, bottom, and text baseline

### LISTVIEW
Se usa para mostrar una lista de (Scrollable Items). Es especialmente útil cuando
estos elementos se cargan dinámicamente. <br>
• Se puede usar un AdapterView para llenar la lista con las vistas en ejecución.

### ASSETS
Los Assets son archivos extra que se procesan por la aplicación. (Json,
fonts, etc.) <br>
• Deben estar almacenados en una carpeta de assets:<br>
```
app/src/main/assets
```

### PERMISOS
En Android, cada aplicación corre de forma separada de las demás,
dentro de un SandBox. <br>
• Cada aplicación debe pedir explícitamente permisos para acceder a
los recursos que necesita fuera de su sandbox a través de
“permissions” <br>
• Dependiendo de lo sensible del recurso, Android puede dar el
permiso de forma automática o solicitar el permiso al usuario final.
• Una aplicación no tiene permisos por defecto. <br>
Hasta Android 5.1 API 22 <br>
- Se solicitan los permisos al momento de instalar la aplicación, o en las actualizaciones.
Una vez la aplicación está instalada, la única forma de quitar el permiso es
desinstalándola. <br>
- Permisos en grupo, o se autoriza todo o no se instala.
• Desde de Android 6 Api 23 <br>
- La aplicación pide permiso al usuario en ejecución. El usuario puede quitar los
permisos en cualquier momento. De esta forma, la aplicación debe verificar que aún
tenga permiso para acceder al recurso que necesita cada vez que se ejecuta! <br>
- La instalación se hace más simple, pero cada permiso se debe manejar de forma
individual y en ejecución. Una aplicación puede tener algunos permisos rechazados y
otros aceptados. <br>

### PERMISOS NORMALES
Se necesitan datos o recursos por fuera del sandbox pero hay muy poco
riesgo para la privacidad del usuario o para el buen funcionamiento de
Android <br>
‣ Internet, bluetooth, NFC, alarmas, zona horaria, vibración, wallpaper, audio, etc. <br>
- Android lo autoriza automáticamente <br>

### PERMISOS CON RIESGO
Se necesitan datos o recursos por fuera del sandbox que involucran
información privada del usuario, modifican la información almacenada, o la
operación de otras aplicaciones: <br>
‣ Calendario, cámara, contactos, localización fina y gruesa, grabar audio, registro de
llamadas, SMS, leer y escribir en el almacenamiento externo: <br>
- El usuario tiene que dar el permiso de forma explícita

### COMO SE SOLICITA UN PERMISO?
Si es un permiso con riesgo, y el API es 23 o posterior, además de definir el permiso en el Manifest
de la aplicación, es necesario verificar en ejecución el permiso y eventualmente solicitarlo usando
el método ContextCompat.checkSelfPermission().
Este método retorna: <br>
‣ Si hay permiso: PackageManager.PERMISSION_GRANTED <br>
‣ Si no hay permiso: PackageManager.PERMISSION_DENIED <br>
Android proporciona un método de utilidad: <br>
- shouldShowRequestPermissionRationale() retorna true si la app ha
solicitado el permiso anteriormente y el usuario ha rechazado la solicitud. <br>
El sistema muestra el diálogo estándar (no se puede modificar) y cuando el usuario responde, el
sistema llama al callback onRequestPermissionResult()

### GRUPOS DE PERMISOS
Todos los permisos pertenecen a grupos. <br>
• Cuando se solicita un permiso a través del diálogo, el sistema describe el grupo completo de
permisos. <br>
• Si un permiso con riesgo ya se aceptó y existe otro del mismo grupo en el manifest, el sistema
otorga el segundo permiso sin interacción con el usuario. <br>
• Por ejemplo, si a una app ya se le otorgó el permiso READ_CONTACTS y luego esta solicita el
permiso WRITE_CONTACTS, el sistema lo otorga de inmediato. <br>

### ADAPTER
Para mostrar los datos del cursor en un ListView, es necesario crear un adapter
personalizado. Primero se crea un layout para cada posición de la lista en un xml
separado (New -> XML -> Layout XML File)



### AGREGAR DATOS AL EMULADOR
En Android Studio ir a Device File Explorer <br>
• “Drag and Drop” del archivo seleccionado
en storage -> emulated -> 0 <br>
• Para el archivo vcf, importar los contactos
desde la aplicación de contactos desde el
almacenamiento interno 

### ACTIVIDADES CON RESULTADO
En algunos casos es necesario recibir un resultado de una actividad que se lanza. <br>
- En estos casos se debe usar startActivityForResult() (en lugar de startActivity()). <br>
- Por ejemplo se puede lanzar una aplicación que tome una fotografía, y recibir esta
fotografía como resultado. <br>
- Por supuesto, la actividad lanzada debe estar programada para retornar un
resultado y lo hace a través de otro objeto Intent

### RESULTADO DE LA ACTIVIDAD
El resultado se procesa en el callback onActivityResult

### ACTIVITY RESULT API
• startActivityForResult() es obsoleto actualmente <br>
- Sigue disponible pero se recomienda utilizar la nueva API <br>
• Existe una nueva alternativa para trabajar con resultados de actividades y con solicitudes de
permisos <br>
• Basada en default contracts (ActivityResultContract) que definen el tipo de entrada
necesario para producir un resultado junto con el tipo de salida del resultado. <br>
• Las API proporcionan métodos predeterminados para intents básicas como hacer una foto,
solicitar permisos, etc

### VIEW BINDING
Interactuar más simple con layouts XML <br>
• Hasta ahora (Old Style): <br>
- Definir ids en el XML
- Definir atributos en la actividad
- Inflar los atributos: findViewById... <br>
• Nueva alternativa
- ViewBinding para crear un objeto que contiene todas las referencias de la
vista, no se necesitan objetos adicionales.

### PERMISOS PARA LOCALIZACIÓN
La localización es una de las características propias de los dispositivos móviles. <br> 
• Hacer una aplicación sensible a la ubicación permite dar servicios únicos a
dispositivos en movimiento. <br>
• La localización es un recurso con riesgo pues involucra información privada
del usuario. <br>
• Es necesario solicitar permiso y validar si el permiso ha sido aceptado, de la
misma forma que se hizo con los contactos, la cámara o el acceso a la
memoria interna. <br>

### LOCATION
La aplicación puede consultar la ubicación una sóla vez <br>
• Sin embargo, para aplicaciones que ayudan al usuario a encontrar una ruta mientras
se desplazan, la ubicación debe actualizarse en intervalos regulares. <br>
• Además de la ubicación geográfica (latitud y longitud), también se puede obtener
mas información como altitud y velocidad de desplazamiento. <br>
• Esta información está disponible en la clase Location que se obtiene del fused
location provider. <br>
• Esta funcionalidad es parte de los servicios de Google Play.

### CONSULTAR LA LOCALIZACIÓN
Se utiliza el servicio de localización de Google <br>
- Atributo de la clase
- En onCreate se inicializa
```
private lateinit var mFusedLocationClient: FusedLocationProviderClient
mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
```

### NOTIFICACIÓN DE CAMBIOS DE POSICIÓN
Para especificar mejor las condiciones que se requieren de localización y suscribirse a
actualizaciones periódicas primero es necesario crear un objeto de tipo RequestLocation.

### NOTIFICACIÓN DE CAMBIOS DE POSICIÓN- PRIORIDAD SOLICITUD
- PRIORITY_BALANCED_POWER_ACCURACY - Utilice este ajuste para solicitar una precisión de localización dentro de una
manzana de la ciudad, lo que supone una precisión de aproximadamente 100 metros. Esto se considera un nivel grueso
de precisión y es probable que consuma menos energía. Con esta configuración, es probable que los servicios de
localización utilicen el posicionamiento por WiFi y torres de telefonía móvil. Ten en cuenta, sin embargo, que la
elección del proveedor de localización depende de muchos otros factores, como las fuentes disponibles. <br>
• PRIORITY_HIGH_ACCURACY - Utilice este ajuste para solicitar la ubicación más precisa posible. Con este ajuste, es más
probable que los servicios de localización utilicen el GPS para determinar la ubicación. <br>
• PRIORITY_LOW_POWER - Utilice este ajuste para solicitar precisión a nivel de ciudad, lo que supone una exactitud de
aproximadamente 10 kilómetros. Esto se considera un nivel grueso de precisión y es probable que consuma menos
energía. <br>
• PRIORITY_NO_POWER - Utilice esta configuración si necesita un impacto insignificante en el consumo de energía, pero
desea recibir actualizaciones de ubicación cuando estén disponibles. Con esta configuración, su aplicación no activa
ninguna actualización de ubicación, pero recibe las ubicaciones activadas por otras aplicaciones. <br>


### NOTIFICACIÓN DE CAMBIOS DE POSICIÓN- SUSCRIPCIÓN A LA LOCALIZACIÓN
Para suscribirse a la localización, se debe definir un objeto callback() cuyos
métodos son invocados de acuerdo a la tasa de refresco antes establecida. <br>
• Este atributo se asigna al fusedLocationClient para recibir las actualizaciones.

### NOTIFICACIÓN DE CAMBIOS DE POSICIÓN- OBJETO CALLBACK
Finalmente se programa el objeto callback para reaccionar a la
actualización de la ubicación

### ENCENDER DE FORMA PROGRAMATICA
Si el usuario no tiene encendida la localización, la aplicación puede
encenderla mostrando un diálogo al usuario. Para eso se debe: <br>
1. Acceder a la configuración del usuario <br>
2. Si la tarea es exitosa, la localización está encendida y se
puede seguir adelante. <br>
3. Sino, pero si existe el hardware en el dispositivo se debe
enviar un diálogo para encender la localización de forma
programática. <br>
4. Finalmente si no se cuenta con el hardware se debe
deshabilitar la funcionalidad asociada a la localización.

### ENCENDER Y APAGAR LA SUSCRIPCIÓN
Suscribirse a la actualización de cambios en la posición es costoso en
términos de procesamiento y consumo de energía. <br>
• Sólo se debe hacer cuando la aplicación necesite mostrar actualizaciones
de forma constante como parte de su funcionamiento. <br>
• En una aplicación con navegación (Waze, google maps, etc.) sólo se debe
escuchar la ubicación si el usuario está viendo algo como un mapa y es
consciente de su desplazamiento. <br>





 

