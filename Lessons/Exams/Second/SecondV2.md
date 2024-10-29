# Segundo Parcial - V2

---

- [Segundo Parcial - V2](#segundo-parcial---v2)
  - [Instrucciones Generales](#instrucciones-generales)
  - [Tareas](#tareas)
    - [1. Consulta a la API de TVMaze](#1-consulta-a-la-api-de-tvmaze)
    - [2. Almacenamiento en Base de Datos](#2-almacenamiento-en-base-de-datos)
    - [3. Inserción de Datos en la Tabla](#3-inserción-de-datos-en-la-tabla)
    - [4. Consulta a la Base de Datos](#4-consulta-a-la-base-de-datos)
    - [Consideraciones Técnicas](#consideraciones-técnicas)
  - [Criterios de Evaluación](#criterios-de-evaluación)
  - [Entregables](#entregables)

---

## Instrucciones Generales

El objetivo de este parcial es que implementes un programa en **Java** que consulte datos de la API de **TVMaze**, los almacene en una base de datos llamada `TVShowsDB`, y realice una consulta para mostrar los datos guardados. Para este punto utilicen la documentación oficial:

- [tvmaze](https://www.tvmaze.com/api)

Deben hacer la búsqueda por show y encontrar la serie de Breaking Bad.

>[!NOTE]
>Deben implementar un proyecto de java y enviar el proyecto en un archivo zip. Recuerden que en los url para realizar los query, consultas, tienes que reemplazar los espacios por "%20".

A continuación, se describen los pasos detallados que debes seguir:

## Tareas

### 1. Consulta a la API de TVMaze
   - Utiliza el API de TVMaze, que provee información sobre shows de TV de todo el mundo.
   - Deberás realizar una consulta a la API basándote en **show Breaking Bad**, show. Debes consultar y guardar mínimo 4 datos:
     - **Nombre del show**.
     - **Género** (comedia, drama, ciencia ficción, etc.).
     - **Idioma** del show.
     - **Canal** o plataforma de transmisión.
     - U otro dato que consideres pertinente.
      Dada una línea del json, **línea 209**, debes retornar varios datos del show a la que pertenece la línea brindada, estos datos pueden ser el lenguaje, estado, resumen, o cualquier otro disponible en la API, con lo que se realiza la consulta en el endpoint.
   - La URL base de la API y algunos ejemplos de consultas están disponibles en el siguiente enlace: [TVMaze API](https://www.tvmaze.com/api).
   - Estos datos deben guardarse en un clase llamada `Show` que tenga todos los atributos públicos. La idea es que la cantidad de atributos debe ser mínimo 4 (nombre, autor, director, cantidad de episodios, etc).
   - Después, implementa un código que guarde y lea la clase `Show` como un archivo `.ser`, es decir, serializar y deserealizar el objeto. (Dejar de último, priorizar lo demás puntos).

### 2. Almacenamiento en Base de Datos
   - Crea una base de datos en **MySQL** llamada `TVShowsDB`.
   - Dentro de la base de datos, define una tabla que almacene los datos obtenidos de la API. Debes incluir columnas relevantes como:
     - **ID** (auto incrementable)
     - **Nombre del Show**
     - **Género**
     - **Idioma**
     - **Canal/Plataforma**
     - **Fecha de estreno** (opcional)
     - **URL del Show** (opcional)
     - Otros datos que consideres relevantes. <br><br>

      La estructura de la tabla a crear es la siguiente:
    
      ```sql
      CREATE TABLE nombre_tabla(
         ID INT PRIMARY KEY,      -- es una línea obligatoria que puede ser el ID del ave o un número nuevo
         atributo1 VARCHAR(100),  -- si es string
         atributo2 INT,           -- si es entero
         atributo3 DOUBLE(10,4),
         atributo1 VARCHAR(100),  -- si es una fecha
      );
      ```

      Cambia los nombres de los atributos por los apropiados y guarda el tipo de dato correcto.

### 3. Inserción de Datos en la Tabla
   - Luego de obtener los datos de la API, deberás almacenarlos en la tabla correspondiente de la base de datos `TVShowsDB`.
   - Asegúrate de insertar varios registros (mínimo 5) para mostrar la utilidad del programa.

### 4. Consulta a la Base de Datos
   - Implementa una consulta SQL que recupere todos los registros de la tabla.
   - Usa el comando `SELECT * FROM nombre_tabla;` para mostrar los datos almacenados en la consola.
   - Implementa una actualización o eliminación de un dato dado un id, el que tu eligas. 


### Consideraciones Técnicas

- Utiliza bibliotecas como **HttpClient** o **Json** para realizar las peticiones a la API. Cargalas en el arhivo pom.
- Para la conexión a la base de datos, emplea **JDBC**.
- Asegúrate de manejar excepciones adecuadamente.
- Usa clases en Java para almacenar temporalmente los datos antes de insertarlos en la base de datos.

>[!NOTE]
>Utiliza los códigos ya existentes del repositorio del curso https://github.com/uETITC/ProgrammingII-2024-2/tree/main.


## Criterios de Evaluación

- Consulta a la API correctamente implementada.
- Creación de la base de datos.
- Creación y poblamiento de la tabla.
- Inserción correcta de los datos en la tabla.
- Consulta correcta de los datos almacenados en la base de datos.

## Entregables

- Código fuente en Java que realice la consulta a la API, almacene los datos y realice la consulta final. Formato .zip.
- Script SQL de la creación de la base de datos y la tabla. 
- Capturas de pantalla o logs de la consola mostrando los datos obtenidos de la consulta.