# Proyecto de los Simpson
## Índice
- [Introducción](#introducción)
    - [Postman](#postman)
- [Manual técnico para desarrolladores](#manual-técnico-para-desarrolladores)
    - [Requisitos previos](#requisitos-previos)
    - [Estructura](#estructura)
    - [Metodología](#metodología)
    - [Configuración de Maven](#configuración-de-maven)
    - [Ejecución del proyecto](#ejecución-del-proyecto)
    - [Manejo de la caché](#manejo-de-la-caché)
    - [Manejo de errores](#manejo-de-errores)
    - [Exportación de datos](#exportación-de-datos)
- [Manual de usuario](#manual-de-usuario)
    - [Busquedas](#busquedas)
    - [Consultar la información del personaje](#consultar-la-información-del-personaje)
    - [Otras opciones (crear personaje nuevo)](#otras-opciones-crear-personaje-nuevo)
    - [Registro](#registro)
    - [Exportaciones](#exportaciones)
- [Reparto de tareas](#reparto-de-tareas)
- [Extras](#extras)
- [Mejoras](#mejoras)
- [Conclusiones](#conclusiones)
- [Autores](#autores)

## Introducción
Esto es una aplicación que nos permite realizar busquedas en la api de los Simpson.
El programa de base nos dejara buscar por nombre y tendremos a nuestra disposición el ID del personaje, edad, trabajo, género, cumpleaños y alguna frase tipica.

Tendremos la opción de crearnos un usuario e iniciar sesion para tener un registro de los nombres que buscamos en la aplicación ademas de poder crear, editar y eliminar personajes.

---
### Postman
[Volver al índice](#índice)
## Manual técnico para desarrolladores
### Requisitos previos
- **Java SE 17 o superior:** El proyecto se ha desarrollado usando la version 17 de Java, lo cual se requiere usar la misma version o superior
- **Maven:** La gestión de las dependencias se hace con Maven, lo cual se deberá tener Maven instalado.
- **IDE Recomendado:** Para este proyecto se ha usado Apache NetBeans como IDE pero se puede usar cualquiera que soporte el lenguaje de Java.
### Estructura
El proyecto está planteado segun la estructura Modelo, Vista, Controlador.

---
#### Modelo
El modelo tiene toda la información del programa y dicta como esos datos deben ser modificados. Gracias al modelo tenemos la opcion de poder añadir, editar y eliminar cada informacion que tengamos acceso en la aplicación con la API.
La aplicación cuenta con estas clases:

---
#### Vista
Es la que se encarga de visualizar los datos que nos da el modelo para que lo vea el usuario. La vista manda todo lo relacionado con las cajas de texto, botones de buscar, añadir, editar o eliminar y tambien para poder crear usuario e iniciar sesion a los controladores correspondientes.

*SimpsonFrame*: Es la clase principal que contiene practicamente todo, el buscador para los personajes, todas las opciones que puede tener cada personaje buscado, un boton para acceder a otra ventana para crear un personaje de 0 y los apartados de crear usuario e iniciar sesion con el.

*crearPersonajeJDialog*: clase que sirve para la creación de los personajes de los Simpson, con todas las opciones posibles, solo puede usarse si tienes iniciada la sesion para que se pueda guardar ese personaje y que puedas buscarlo en otro momento.

---
#### Controlador
El controlador recibe las entradas del usuario desde la vista y las traduce en acciones que el modelo debe ejecutar. Se encarga de interpretar las acciones del usuario, manejar los eventos, y de actualizar tanto el modelo como la vista.

*SimpsonController*: controlador principal de la aplicación, hace de puente con la vista principal y el modelo para manejar la logica de la aplicación.

*crearPersonajeController*: clase encargada de mandar los datos introducidos de la vista al modelo y guardar esa información para cuando se quiera buscar mas tarde.

---
### Metodología
#### Uso de Git
El proyecto usa la metodología de desarrollo incremental basado en ramas, lo cual facilita la gestión de versiones y el trabajo en equipo de los desarrolladores. Las ramas base para el proyecto son `main` y `developer`, pero para el desarrollo se usaron 3 ramas en paralelo donde cada uno de los integrastes trabajaba en cada 1, `Fran`, `Nico`, `Roi`.

Flujo de trabajo:

1. **Añadir funcionalidad:** cuando se quiere crear una nueva funcionalidad, se avisa al equipo y se trabaja en la propia rama para implementarla sabiendo de antemano que no va a pisar nada de lo que otro desarrollador este trabajando en otra rama.
2. **Testear:** Cuando se completa la nueva funcionalidad se realizan las pruebas pertinentes para asegurar que funciona correctamente y no rompe nada del resto del proyecto.
3. **Merge a Developer:** Al haber testeado las nuevas funcionalidades y ser exitosas, se realiza un mergeo de la rama a developer. Es importante este paso dado que todo lo que vaya a esta rama debera de ir  con los menos problemas posibles a la hora de mergear con el resto de desarrolladores.
4. **Merge a Main:** Para finalizar cuando la rama `developer` fue probada y es una version estable y sin errores, se realiza el merge a la rama `main`. Al tener todo el proyecto actualizado en el main dariamos paso a una nueva version del proyecto final.

Gracias a este flujo de trabajo nos permite trabajar varios desarrolladores simultaneamente cada 1 con funciones diferentes y poder integrar todos los cambios a la vez, testeandolo todo al mismo tiempo y corregir errores que puedan salir al mergear.

---
### Configuración de Maven
El archivo `pom.xml` incluye estas dependencias:
```
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.13.1</version>
        <type>jar</type>
    </dependency>
    <dependency>
        <groupId>org.netbeans.external</groupId>
        <artifactId>AbsoluteLayout</artifactId>
        <version>RELEASE230</version>
    </dependency>
</dependencies>
```
### Ejecución del proyecto
### Manejo de la caché
### Manejo de errores
### Exportación de datos
[Volver al índice](#índice)
## Manual de usuario
### Registro
Al abrir la aplicación, el usuario en cuestión verá la siguiente pantalla :


<img width="1166" height="1016" alt="image" src="https://github.com/user-attachments/assets/ea5016ac-ccda-44b2-a613-786238c0a876" />


En cuanto al usuario de registro,el que aparecerá siempre por defecto será el de *INVITADO*: 


<img width="1098" height="1018" alt="image" src="https://github.com/user-attachments/assets/aa1b836d-7eb2-4c83-a1f5-2af5b9b2e0d6" />


Para acceder a todas las funcionalidades de la aplicación,tendremos que registrarnos en la aplicación,desde el botón *Crear cuenta*(derecha de la imagen):


<img width="958" height="1016" alt="image" src="https://github.com/user-attachments/assets/f29131ac-5271-48bf-acc5-2205acbe25cb" />


El siguiente paso será introducir tanto el nombre de usuario como la contraseña:


<img width="960" height="1017" alt="image" src="https://github.com/user-attachments/assets/f5afcb19-9c8f-4530-8064-c1ccfc11f76b" />


Al pulsar el boton de *Registarse* aparecerá automáticamente un mensaje en pantalla que el usuario se registro de manera satisfactoria:


<img width="960" height="1020" alt="image" src="https://github.com/user-attachments/assets/4108e210-492d-4cad-b5da-10083d69b069" />


Si el usuario queda bien registrado después de enviar el mensaje en pantalla,se borrarán automáticamente los campos de *Usuario* y *Contraseña*:


<img width="960" height="1016" alt="image" src="https://github.com/user-attachments/assets/49da19c0-bc04-43c4-9ceb-4438bb71d343" />


Una vez hecho esto tendremos que abrir la pantalla de *Iniciar sesión* la cual abrirá un panel con *Usuario* y *Contraseña* otra vez, ocultando así el panel asociado a *Crear cuenta*:


<img width="1086" height="1020" alt="image" src="https://github.com/user-attachments/assets/7af1b92f-45a2-413c-b793-f32fdc690e95" />


Con esto introducimos el *Usuario* y la *Contraseña* que registramos:


<img width="962" height="1012" alt="image" src="https://github.com/user-attachments/assets/c438e638-e2f7-47a5-93b7-c85d6a8ee37a" />


Una vez metidos estos datos le daremos a *Acceder* y automáticamente se sustituirá el nombre de *INVITADO*(esquina superior derecha) en este caso por el de Nico(Usuario metido para el inicio de sesión),dejando los campos de *Usuario* y *Contraseña* vacíos :


<img width="1093" height="1011" alt="image" src="https://github.com/user-attachments/assets/69096279-2804-4241-87f9-762e6672b169" />


En caso de que cerremos la aplicación y volvamos a estar con el usuario *INVITADO* por defecto, si volvemos a registrarnos con el mismo *Usuario* nos aparecerá un mensaje de error ya que el *Usuario* ya está registrado: 


<img width="960" height="1018" alt="image" src="https://github.com/user-attachments/assets/9300f89b-35a8-48e9-94d1-0e8db09a43e7" />

Como también nos dará el mismo error si intentamos crear una clase *INVITADO*(sin distinción de mayúsculas y minúsculas):


<img width="1097" height="1018" alt="image" src="https://github.com/user-attachments/assets/44503dd9-e881-4878-af1e-0f5209586e16" />


En caso de *Iniciar sesión* con el *Usuario* y *Contraseña* creados anteriormente, volverá dejar *Acceder* al mismo usuario: 


<img width="962" height="1012" alt="image" src="https://github.com/user-attachments/assets/56ae2a78-08cf-4dca-84f6-7b704334cd61" />

<img width="1093" height="1011" alt="image" src="https://github.com/user-attachments/assets/2a8cfa6a-4833-44df-9d0d-857a758b2078" />


En caso de que la *Contraseña* no sea correcta o el *Usuario* no este registrado, aparecerá el siguiente mensaje:

<img width="957" height="1020" alt="image" src="https://github.com/user-attachments/assets/1714958c-a3a0-45c5-9644-06e0d0d36547" />

<img width="957" height="1012" alt="image" src="https://github.com/user-attachments/assets/59c23ba8-26ce-4c94-8c3d-bd52d87471c6" />

Por último con el botón ocultar, ocultaríamos lo que son los paneles de *Iniciar sesión* y *Crear cuenta*:


<img width="1062" height="1017" alt="image" src="https://github.com/user-attachments/assets/8cf63836-f960-44a3-81d3-2278e16751d4" />


### Busquedas

**USUARIO INVITADO**

Si volvemos a iniciar la interfaz,nos aparecerá el usuario *INVITADO* el cual posee de una única funcionalidad, *Buscar*:

Por lo que si buscamos un *Personaje* en el campo vacío al lado de *Nombre*,por ejemplo, Homer Simpson, aparecerán todos sus datos:


<img width="1060" height="1016" alt="image" src="https://github.com/user-attachments/assets/0094a519-b20a-4193-b20b-791617aa86d6" />


En caso de darle al botón *BORRAR* aparecerá esto:


<img width="1062" height="1017" alt="image" src="https://github.com/user-attachments/assets/09c913bd-92f6-4d6d-b59f-47186ac3b147" />


Si le das a *Editar*:


<img width="1062" height="1017" alt="image" src="https://github.com/user-attachments/assets/47792dbc-3e64-4eb8-8f66-b7bebf05a9c5" />


Y por último en *CREAR PERSONAJE* :


<img width="1062" height="1017" alt="image" src="https://github.com/user-attachments/assets/81f412dd-ba44-479d-a996-e0b7d1d10e9d" />



**USUARIO REGISTRADO**

 Accedemos ya al *Usuario* Nico ya antes registrado, y probamos todas las funcionalidades:

Primero le damos a *BUSCAR* que funciona igual que con el *Usuario INVITADO*.

ACLARACIÓN❗❗: No hay distinción de mayúsculas y minúsculas, por lo que el *Usuario* en cuestión no tendrá que tener tanto cuidado a la hora de escribir el nombre del *Personaje*:  

<img width="1081" height="1020" alt="image" src="https://github.com/user-attachments/assets/a68ad85b-e8d6-4fbe-8a7b-108919c9d5b7" />


En caso de volver a darle a *BUSCAR* teniendo el mismo *PERSONAJE* buscado, podremos ver también que cada vez, se genera una frase diferente:

<img width="1085" height="1017" alt="image" src="https://github.com/user-attachments/assets/f625c308-e764-4779-8c56-59823e48ed4f" />

<img width="1087" height="1015" alt="image" src="https://github.com/user-attachments/assets/db4fdc65-775f-4e36-9b1e-5fe3bcaaac0c" />

 
Después con la funcionalidad de *BORRAR* donde deja vacío todos los campos y elimina el *Personaje* de la lista :


<img width="1041" height="1018" alt="image" src="https://github.com/user-attachments/assets/00fd9721-4b84-4820-abd1-8f883231e1f0" />

De hecho si ahora volvemos a buscar el *Personaje*, Homer Simpson en este caso, no aparecería, y saltaría la excepción:


<img width="1040" height="1018" alt="image" src="https://github.com/user-attachments/assets/670fe453-4c4d-475c-a9fd-73515d88d440" />



Ahora seguiremos con la funcionalidad de Editar, la cual si escribes dentro de alguno de los 5 campos existentes,(ya que *ID* está bloqueado) ya con el personaje buscado, y pulsas a continuación *EDITAR* se guardarían los cambios:

Por lo que una vez editado algunos de los campos,si vuelves a buscar el mismo *Personaje*, los datos que hemos escrito nuevos quedarían ya guardados:

<img width="1041" height="1017" alt="image" src="https://github.com/user-attachments/assets/81998160-d448-4d45-bb2c-e7bdc5ac8d33" />

<img width="1040" height="1022" alt="image" src="https://github.com/user-attachments/assets/1709c9b7-5299-42c9-86bd-0b9a1be2fdd8" />

En caso de querer editar específicamente el atributo edad, si introducimos algún caracter que no sea un número, nos saltará la excepción:


<img width="1038" height="1017" alt="image" src="https://github.com/user-attachments/assets/b47f1c56-fd52-432d-b2ed-c9f10392564a" />


Y también en caso de que queramos *EDITAR* sin antes *BUSCAR* un usuario que existe salta la siguiente excepción:

<img width="1040" height="1016" alt="image" src="https://github.com/user-attachments/assets/ad04c997-5c2b-478e-bff6-60b285683da0" />



### Consultar la información del personaje
### Otras opciones (crear personaje nuevo)

En cuanto a esta funcionalidad, abarca la integración de nuevos *PERSONAJES* , dentro de la aplicación, pulsando en el botón *CREAR PERSONAJE*.

Este, nos mostrará una pantalla nueva donde nos muestra todos los datos posibles para poder crear un nuevo *PERSONAJE*:


<img width="1091" height="1021" alt="image" src="https://github.com/user-attachments/assets/364ab79a-fa28-4f3f-ad94-391e099ca939" />

En caso de meterle un *ID* mayor que 20, o el de un *PERSONAJE* borrado, se creará el *PERSONAJE* correctamente dandole al botón *GUARDAR*:


<img width="1028" height="1017" alt="image" src="https://github.com/user-attachments/assets/d56ed11c-00ca-4b10-8b31-68f478ddc15f" />


En caso contrario, se mostrará un mensaje un mensaje en pantalla:

<img width="1102" height="1017" alt="image" src="https://github.com/user-attachments/assets/b2481b4d-7fda-42c6-8dcf-2428be5e78d0" />


También hay una excepción con el *ID*, por lo que si introduces una edad con otro caracter q no sea número, te saltará este mensaje:


<img width="1087" height="1016" alt="image" src="https://github.com/user-attachments/assets/ebb8d6a1-80a3-4091-84ef-d6cbc1c5cb19" />


Como también en *EDAD*:


<img width="1080" height="1017" alt="image" src="https://github.com/user-attachments/assets/50b02d40-1ab2-4a96-ab36-a2c18a4cc131" />

Y el último error que podría ocurrir sería no ponerle el nombre al *PERSONAJE* por lo que si no se le introduce el nombre , salta este mensaje:


<img width="1085" height="1020" alt="image" src="https://github.com/user-attachments/assets/a0031e3d-2422-456b-88a5-de9b8a809288" />

Una vez creado el *PERSONAJE*,probaremos las tres funciones de la clase principal en él:


<img width="1087" height="1017" alt="image" src="https://github.com/user-attachments/assets/3388a439-2622-4f61-acd7-fb1258d3af43" />

Le editamos algun campo,por ejemplo el *Trabajo*:


<img width="1088" height="1025" alt="image" src="https://github.com/user-attachments/assets/04f44595-7c47-4b45-b09e-d3b4e212987e" />

Lo borramos, y lo volvemos a *BUSCAR* :


<img width="1095" height="1021" alt="image" src="https://github.com/user-attachments/assets/2a3c26e3-86fe-481a-8fb1-44f2c83ee07d" />


Haciendo esto,comprobamos que  *BUSCAR, BORRAR * y *EDITAR* funcionan correctamente con el nuevo *PERSONAJE* creado.

### Exportaciones
[Volver al índice](#índice)
## Reparto de tareas
[Volver al índice](#índice)
## Extras
[Volver al índice](#índice)
## Mejoras
[Volver al índice](#índice)
## Conclusiones
[Volver al índice](#índice)

## Autores
Francisco Alende Antelo [@fran](https://github.com/a24francisco)  
Nicolás Sanjuás Casal [@nico](https://github.com/Nicosanju)  
Roi Conles Ferro [@roi](https://github.com/a24roicf)
