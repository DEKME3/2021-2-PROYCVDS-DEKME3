# 2021-2-PROYCVDS-DEKME3

## Nombre del proyecto
### _**2021-2-PROYCVDS-DEKME3**_




## Período académico
### _2021-2_
## Nombre del curso
### _CVDS-2_
## Nombre de los integrantes
* ### DEIVID SEBASTIAN MEDINA RATIVA
* ### EDUARDO OSPINA MEJIA
* ### KRISTHIAN DAVID SEGURA GUATIBONZA
* ### MARÍA JOSÉ TORRES NIEVES
## Nombre del profesor
### OSCAR DAVID OSPINA RODRIGUEZ
## Roles asignados
* ### DEIVID SEBASTIAN MEDINA RATIVA: ***UX***
* ### EDUARDO OSPINA MEJIA: ***Back***
* ### KRISTHIAN DAVID SEGURA GUATIBONZA: ***Back***
* ### MARÍA JOSÉ TORRES NIEVES: ***Front***
* ### OSCAR DAVID OSPINA RODRIGUEZ: ***Dueño del producto***

## Descripción del producto.
**1. Descripción general:**

La Plataforma Solidaridad Escuela, es una herramienta para generar un entorno de comunicación y ayuda dentro de la comunidad de la Escuela Colombiana de Ingeniería Julio Garavito. El sistema permite que los estudiantes puedan expresar las necesidades que puedan tener de algún elemento para poder desarrollar sus actividades de forma correcta, y que los demás miembros de la comunidad puedan facilitar estos elementos a quienes lo necesitan. De igual manera los miembros de la comunidad pueden ofrecer diferentes elementos que sean de interés para los estudiantes sin que exista alguna solicitud específica. Adicionalmente el sistema cuenta con diferentes funcionalidades de reportería y administración que permite llevar un control del funcionamiento de la plataforma y del alcance que se está logrando.

**2. Manual de usuario.**

El presenta manual se encuentra organizado de acuerdo al orden de pantallas de la pagina, como se muestra a continuacion: 

1. Inicio de sesión a la pagina:

   Para poder hacer uso de la pagina web de solidaridad de la escuela el primer paso y la primera funcionalidad es la de poder iniciar sesión, y dependiendo de el usuario que ingrese, se habilitan diferentes funcionalidades dentro de la pagina.

   ![](https://i.postimg.cc/qqBfsCmX/iniciosesion.png)

2. Cerrar Sesión:

   Al hacer inicio de sesión, una de las primeras funcionalidades disponibles es la de cerrar la sesión en la que se encuentra actualmente. 

   ![](https://i.postimg.cc/g0bTyZjX/cerrarsesion.png)

3. Operaciones Categoría:

   Solo un usuario administrador tiene acceso a las funcionalidades que se encuentran dentro de la sección de Categoría.

   ![](https://i.postimg.cc/g2sghBC5/categoria.png)

   Al momento de ingresar se habilitan las siguientes funcionalidades:

   1.  Cerrar sesión: permite al usuario cerrar su sesión:

      ![](https://i.postimg.cc/Rh7nJhsB/Microsoft-Teams-image-5.png)

   2. Ingresar nueva categoría: Permite al administrador del sistema agregar una nueva categoría:

      ![](https://i.postimg.cc/Dz40bm0M/Microsoft-Teams-image-6.png)

   3. Actualizar categoría existente: permite al administrador actualizar información de las categorías, siendo esta información el nombre, la descripción y el estado.

      ![](https://i.postimg.cc/kg09zsMT/Microsoft-Teams-image-7.png)

   4. visualizar categorías existentes: La pagina le muestra al administrador todas las categorías presentes en la base de datos.

      ![](https://i.postimg.cc/4dJCRFDQ/Microsoft-Teams-image-9.png)

   5. Generar Reporte categoría en PDF: si el administrador lo desea, la pagina le permite generar un PDF con las categorías mas solicitadas u ofrecidas.

      ![](https://i.postimg.cc/bYC74g31/Microsoft-Teams-image-10.png)

   6. Generar reporte categoría Excel: si el administrador lo desea, la pagina le permite generar un Excel con las categorías mas solicitadas u ofrecidas.

      ![](https://i.postimg.cc/bYC74g31/Microsoft-Teams-image-10.png)

   7. Generar grafico de reporte de categoría: la pagina genera un grafico de las categorías mas solicitadas u ofrecidas.

      ![](https://i.postimg.cc/tC8L4T0T/Microsoft-Teams-image-11.png)

   8. eliminar categoría: la pagina le permite al administrador eliminar una categoria a partir del nombre.

      ![](https://i.postimg.cc/ZRfQtYFJ/Microsoft-Teams-image-12.png)

      

4. Operaciones Necesidades:

5. Operaciones Oferta:

	![](https://i.postimg.cc/kgQqr8V9/oferta.png)

    1. Cerrar sesión: le permite al usuario cerrar la sesión actual.

   	![](https://i.postimg.cc/DZMKQPNQ/Capture.png)

    2. Registrar oferta: permite al usuario del sistema crear una oferta nueva.

   	![](https://i.postimg.cc/0ysrJ9Dk/capture1.png)

    3. Actualizar oferta: permite actualizar el estado de una oferta ya existente a través de su id.

   	![](https://i.postimg.cc/44YYDLXg/Capture2.png)

    4. Visualizar todas las ofertas: Permite visualizar todas las ofertas que se encuentran en la base de datos.

   	![](https://i.postimg.cc/nLVz0T3N/Capture3.png)

    5. Generar Reporte oferta en PDF: si el administrador lo desea, la pagina le permite generar un PDF del reporte de ofertas

   	![](https://i.postimg.cc/CKvKtDt5/Capture4.png)

    6. Generar reporte oferta Excel: si el administrador lo desea, la pagina le permite generar un Excel del reporte de ofertas

   	![](https://i.postimg.cc/CKvKtDt5/Capture4.png)

    7. Generar grafico de reporte de oferta: la pagina genera un grafico del reporte de ofertas.

   	![](https://i.postimg.cc/TwpPX1M9/Capture5.png)

    8. Registrar respuesta para una oferta: la pagina permite al usuario registrar respuesta para una oferta.

   	![](https://i.postimg.cc/Pfvq3CMf/Capture6.png)

6. Operaciones Respuesta:

**3. Imágenes y descripción de las funcionalidades más importantes.**

## Arquitectura y Diseño detallado:
1. Modelo E-R.
#### Diagrama version 001.

![Diagrama-Version-001.png](https://i.postimg.cc/66ncdHZ5/Diagrama-Version-001.png)

2. Diagrama de clases (hacerlo mediante ingeniería inversa)
3. Descripción de la arquitectura (capas) y del Stack de tecnologías utilizado (PrimeFaces, Guice, QuickTheories, PostgreSQL).
4. Enlace a la aplicación en Heroku.

[![Heroku](https://i.postimg.cc/3JBqPghh/Heroku.png)](https://dashboard.heroku.com/apps/proyecto-dekm)

5. Enlace al sistema de integración continua.


## Descripción del proceso:
1. Integrantes.
2. Breve descripción de la Metodología.
3. Enlace a Taiga (hacer público el Backlog).

[![Taiga.jpg](https://i.postimg.cc/3r6jWNZG/Taiga.jpg)](https://tree.taiga.io/project/kristhiansegura-solidaridad-escuela/backlog)

4. Generar el 'release-burndown chart' del proyecto, e indicar los puntos de historia realizados y los faltantes.
5. Para cada Sprint:
    - Imagen del 'sprint-backlog'

    - Imagen del 'sprint-burndown chart' (sacado del sprint-backlog anterior), y una descripción breve de los problemas encontrados y mejoras realizadas al proceso.

6. Reporte de pruebas y de cubrimiento de las mismas (sólo la foto del reporte principal). Para la cobertura, pueden usar los plugins disponibles (EclEmma, Jacoco, etc.)

7. Reporte de análisis estático de código. Se pueden usar las mismas herramientas trabajadas en los laboratorios.
