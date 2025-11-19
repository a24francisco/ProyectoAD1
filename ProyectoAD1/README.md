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
### Busquedas
### Consultar la información del personaje
### Otras opciones (crear personaje nuevo)
### Registro
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
