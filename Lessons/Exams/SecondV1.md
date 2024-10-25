# Segundo Parcial - V1

---

- [Segundo Parcial - V1](#segundo-parcial---v1)
  - [Instrucciones Generales](#instrucciones-generales)
  - [Tareas](#tareas)
    - [1. Consulta a la API de Xeno Canto](#1-consulta-a-la-api-de-xeno-canto)
    - [2. Almacenamiento en Base de Datos](#2-almacenamiento-en-base-de-datos)
    - [3. Inserción de Datos en la Tabla](#3-inserción-de-datos-en-la-tabla)
    - [4. Consulta a la Base de Datos](#4-consulta-a-la-base-de-datos)
    - [Consideraciones Técnicas](#consideraciones-técnicas)
  - [Criterios de Evaluación](#criterios-de-evaluación)
  - [Entregables](#entregables)

---

## Instrucciones Generales

El objetivo de este parcial es que implementes un programa en **Java** que consulte datos de la API de **Xeno Canto**, los almacene en una base de datos llamada `XenoCanto`, y realice una consulta para mostrar los datos guardados. Para este punto utilicen la documentación oficial: 

- [Xeno-canto API 2.0](https://xeno-canto.org/article/153)
- [Application Programming Interface (API v2)](https://xeno-canto.org/explore/api)
- [Search Tips - XenoCanto](https://xeno-canto.org/help/search)

Los dos primeros links tienen la documentación del endpoint, el último unos tipos para realizar busquedas. Deben hacer la busqueda por la ciudad Bogotá, ¿que filtro deben usar: id, gen, sp, loc, lat, lon, o cuál?

>[!NOTE]
>Deben implementar un proyecto de java y enviar el proyecto en un archivo zip. Recuerden que en los url para realizar los query, consultas, tienes que reemplazar los espacios por "%20".

A continuación se describen los pasos detallados que debes seguir:

## Tareas

### 1. Consulta a la API de Xeno Canto

   - Utiliza el API de Xeno Canto, que provee datos de grabaciones de sonidos de aves a nivel global.
   - Deberás realizar una consulta a la API basándote en la **locación bogotá**, ciudad. Dada una línea del json, **línea 766**, debes retornar varios datos de la grabación a la que pertenece la línea brindada, estos datos pueden ser el país, la especie de ave, la localización, quién grabó el audio, o cualquier otro disponible en la API, con lo que se realiza la consulta en el endpoint.
   - La URL base de la API y algunos parámetros de ejemplo están descritos en el siguiente enlace: [Xeno Canto API](https://xeno-canto.org/article/153).
   - Estos datos deben guardarse en un clase llamada `Grabacion` que tenga todos los atributos públicos. La idea es que la cantidad de atributos debe ser mínimo 4 (nombre, id, locacion, longitud, etc).
   - Después, implementa un código que guarde y lea la clase `Grabacion` como un archivo `.ser`, es decir, serializar y deserealizar el objeto. (Dejar de último, priorizar lo demás puntos)

### 2. Almacenamiento en Base de Datos

   - Crea una base de datos en **MySQL** llamada `XenoCanto`.
   - Dentro de la base de datos, define una tabla que almacene los datos obtenidos de la API. Debes incluir las columnas que seleccionaste en el punto anterior, mínimo 4, como:
     - **ID** (auto incrementable)
     - **Especie** (nombre científico o común del ave)
     - **País**
     - **Localización** (opcional)
     - **Grabador** (persona que grabó el audio)
     - **URL del audio**
     - **Fecha de la grabación** (opcional)
     - Otros datos que consideres relevantes.
    
      <br>La estructura de la tabla a crear es la siguiente:
    
      ```sql
      CREATE TABLE nombre_tabla(
         ID INT PRIMARY KEY,      -- es una línea obligatoria que puede ser el ID del ave o un número nuevo
         atributo1 VARCHAR(100),  -- si es string
         atributo2 INT,           -- si es entero
         atributo3 DOUBLE(10,4),
         atributo1 VARCHAR(100)  -- si es una fecha
      );
      ```

      Cambia los nombres de los atributos por los apropiados y guarda el tipo de dato correcto.
   
### 3. Inserción de Datos en la Tabla

   - Luego de obtener los datos de la API, deberás almacenarlos en la tabla correspondiente de la base de datos `XenoCanto`. Utiliza la clase creada en el punto 1.
   - Asegúrate de insertar varios registros (mínimo 5) para mostrar la utilidad del programa. Puedes ingresarlos todos al mismo tiempo o uno por uno como prefieras.

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