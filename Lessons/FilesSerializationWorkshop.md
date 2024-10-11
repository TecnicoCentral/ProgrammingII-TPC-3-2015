# Taller: Creación de una Página Web desde Java

---

- [Taller: Creación de una Página Web desde Java](#taller-creación-de-una-página-web-desde-java)
  - [Objetivo](#objetivo)
  - [Introducción](#introducción)
  - [Paso 1: Modelado de las clases para los componentes HTML](#paso-1-modelado-de-las-clases-para-los-componentes-html)
    - [Clase Principal: `PaginaWeb`](#clase-principal-paginaweb)
    - [Clase `ComponenteWeb` (abstracta)](#clase-componenteweb-abstracta)
  - [Paso 2: Implementación de Clases Específicas para Componentes](#paso-2-implementación-de-clases-específicas-para-componentes)
    - [Clase `Titulo` (hereda de `ComponenteWeb`)](#clase-titulo-hereda-de-componenteweb)
    - [Clase `Parrafo` (hereda de `ComponenteWeb`)](#clase-parrafo-hereda-de-componenteweb)
    - [Clase `Imagen` (hereda de `ComponenteWeb`)](#clase-imagen-hereda-de-componenteweb)
    - [Clase `Tabla` (hereda de `ComponenteWeb`)](#clase-tabla-hereda-de-componenteweb)
    - [Clase: `Enlace` (hereda de `ComponenteWeb`)](#clase-enlace-hereda-de-componenteweb)
  - [Paso 3: Implementación de Estilos en CSS](#paso-3-implementación-de-estilos-en-css)
    - [Clase `Estilo`](#clase-estilo)
  - [Paso 4: Integración de Serialización](#paso-4-integración-de-serialización)
    - [Clase `SerializadorPagina`](#clase-serializadorpagina)
  - [Paso 5: Creación de la página web y manipulación de archivos](#paso-5-creación-de-la-página-web-y-manipulación-de-archivos)
  - [Criterios de Evaluación](#criterios-de-evaluación)
  - [Referencias](#referencias)
    - [Recursos en línea](#recursos-en-línea)
    - [Libros](#libros)

---


## Objetivo 
Desarrollar una aplicación en Java que permita generar una página web estática (HTML y CSS) mediante la creación y manipulación de archivos. Se implementarán clases y métodos en Java para generar componentes como títulos, subtítulos, párrafos, imágenes, tablas, entre otros. Adicionalmente, se abordará la serialización de clases para guardar y recuperar el estado de los elementos generados.

## Introducción

En este taller, se simulará la construcción de una página web utilizando clases en Java. Cada clase será responsable de un componente de HTML (por ejemplo, títulos, párrafos, imágenes). El programa creará un archivo HTML y CSS para representar visualmente la estructura de la página, y se generará un código HTML que se puede abrir en cualquier navegador.

>[!NOTE]
>Este programa debe ser immplementado como un projecto de java. Para enviarlo deben subir toda la carpeta del proyecto comprimida en un archivo zip, rar, o tar.

## Paso 1: Modelado de las clases para los componentes HTML

### Clase Principal: `PaginaWeb`
Esta clase contendrá todos los elementos que conforman la página web, y gestionará la creación del archivo HTML y CSS.

- **Atributos**:
  - `titulo`: Título de la página.
  - `html_nombre` y `css_nombre`: Nombre de los archivos html y css, definan los valores con los nombre más utilizados: `index.html` y `styles.css`.
  - `componentes`: Lista de componentes de la página (títulos, subtítulos, párrafos, tablas, imágenes, etc.).
  - `estilos`: Estilos (colores, fuentes, tamaño de texto) para aplicar en el CSS.
  - `plantilla`: Plantilla del documento:
  
    ```html
    <!DOCTYPE html>
    <html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Título de la página</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
    ```
    Desde aca le empiezan a sumar cosas a esta string, eso lo hará el método `generarHTM()`.
  - `plantilla_final`: Plantilla final del documento:
  
    ```html
    </body>
    </html>
    ```

  Es altamente sugerido que en vez de sumar cadenas utilicen mejores estrategias y métodos para insertar texto, como por ejemplo el método `formatted()` o `String.format()`. Para estos casos, donde tenemos una string de muchas líneas, una buena opción es utilizar la triple comilla:

  ```java
  String css_str = """
  /* Estilos globales */
  body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f0f0f5;
      color: #333;
      line-height: 1.6;
  }
  """;
  ```

  Sin embargo, las funciones de formatted o format no funcionan, pero se puede solucionar con el siguiente truco:

  ```java
  String margin = "0";
  String padding = "0";
  String css_str = """
  /* Estilos globales */
  body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      margin: """+margin+"""
      ;
      padding: """+padding+"""
      ;
      background-color: #f0f0f5;
      color: #333;
      line-height: 1.6;
  }
  """;
  ```
  Donde se definieron los atributos `margin` y `padding` en variables externas y despues solo se concatenan, **cuidado porque el ; debe ir en otra línea para no generar error**. <br> <br>
  
- **Métodos**:
  - **Constructor**: Recibe el `titulo` y nombre de los archivos html y css como parámetros obligatorios.
  - `agregarComponente(ComponenteWeb componente)`: Método para añadir un componente a la lista de la página.
  - `generarHTML()`: Método para generar el archivo HTML, iterando sobre los componentes. Es un método que no pide nada y escribe un archivo.
  - `generarCSS()`: Método para generar el archivo CSS, basándose en los estilos definidos. Es un método que no pide nada y escribe un archivo.

### Clase `ComponenteWeb` (abstracta)  
Esta clase abstracta será la base para todos los componentes HTML.

- **Atributos**:
  - `tipo`: Tipo de componente (título, párrafo, imagen, tabla).
  
- **Métodos**:
  - `generarCodigoHTML()`: Método abstracto para que cada subclase defina cómo generar su código HTML específico.
  - `serializarComponente()`: Método para serializar el componente, permitiendo guardar su estado.


## Paso 2: Implementación de Clases Específicas para Componentes

### Clase `Titulo` (hereda de `ComponenteWeb`)
Esta clase representará un título HTML (`<h1>`).

- **Atributos**:
  - `text`: Texto del título.
  - `nivel`: Nivel del título (h1, h2, h3, etc.).

- **Métodos**:
  -  **Constructor**: Recibe `texto` y `nivel` como parámetros obligatorios.
  - `generarCodigoHTML()`: Genera el código HTML para un título de acuerdo al nivel especificado.

- **Ejemplo**:
  ```html
   <h1>This is heading 1</h1>
   ```

### Clase `Parrafo` (hereda de `ComponenteWeb`)
Esta clase representará un párrafo (`<p>`).

- **Atributos**:
  - `texto`: Texto del párrafo.

- **Métodos**:
  - **Constructor**: Recibe `texto` como parámetro obligatorio.
  - `generarCodigoHTML()`: Genera el código HTML para un párrafo.

- **Ejemplo**:
  ```html
   <p>Párrafo con texto</p>
   ```

### Clase `Imagen` (hereda de `ComponenteWeb`)
Esta clase representará una imagen (`<img>`).

- **Atributos**:
  - `ruta`: Ruta de la imagen (`src`).
  - `texto`: Texto alternativo (`alt`).

- **Métodos**:
  - **Constructor**: Recibe `ruta` y `texto` como parámetros obligatorios.
  - `generarCodigoHTML()`: Genera el código HTML para una imagen.

- **Ejemplo**:
  ```html
     <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkHkwOfU9ISltfS7mk7ooj3SS80Ac_mCnkAw&s" alt="Italian Trulli">
   ```

### Clase `Tabla` (hereda de `ComponenteWeb`) 
Esta clase representará una tabla (`<table>`).

- **Atributos**:
  - `datos`: Datos de la tabla (matriz de filas y columnas o varios vectores).

- **Métodos**:
  - **Constructor**: Recibe `datos` como parámetro obligatorio.
  - `generarCodigoHTML()`: Genera el código HTML para una tabla completa.

- **Ejemplo**:
  
```html
  <table>
  <tr>
    <th>Company</th>
    <th>Contact</th>
    <th>Country</th>
  </tr>
  <tr>
    <td>Alfreds Futterkiste</td>
    <td>Maria Anders</td>
    <td>Germany</td>
  </tr>
  <tr>
    <td>Centro comercial Moctezuma</td>
    <td>Francisco Chang</td>
    <td>Mexico</td>
  </tr>
</table> 
```

>[!NOTE]
>La etiqueta ```<th>``` se refiere a los encabezado, aunque no obligatoria tenerla. La tabla también funciona si tiene solo etiquetas ```<td>```.

### Clase: `Enlace` (hereda de `ComponenteWeb`)

Esta clase representa un enlace HTML. Contiene los atributos necesarios para definir el texto visible y la URL a la que apunta el enlace.

- **Atributos**
  - `texto`: El texto visible que aparecerá en la página como el enlace clicable.
  - `url`: La dirección URL a la que redirige el enlace.
  - `target`: Define cómo se abrirá el enlace. Por ejemplo:
     - `"_blank"`: Abre el enlace en una nueva pestaña.
     - `"_self"`: Abre el enlace en la misma pestaña (por defecto).
     Este atributo es opcional y puede tener un valor por defecto.

- **Métodos**
  - **Constructor**: Recibe `texto`, `url`, y `target` como parámetros obligatorios.

  - `generarCodigoHTML()`:  Este método devuelve el código HTML correspondiente para crear el enlace.  
     Ejemplo de un enlace generado:  
     ```html
     <a href="https://www.ejemplo.com" target="_blank">Visita Ejemplo</a>
     ```

## Paso 3: Implementación de Estilos en CSS

### Clase `Estilo`
Esta clase será utilizada para gestionar los estilos que se aplicarán a la página y sus componentes.

- **Atributos**:
  - `color`: Color de fondo.
  - `fuente`: Fuente.
  - `tamaño`: Tamaño de texto.
  - `color_titulos`: Color de los títulos.

- **Métodos**:
  - `generarCSS()`: Genera el código CSS en función de los atributos definidos, para aplicar los estilos correspondientes a la página.

## Paso 4: Integración de Serialización

### Clase `SerializadorPagina`
Esta clase se encargará de la serialización de los objetos que representan la página web, permitiendo guardar el estado de la página y restaurarla en el futuro.

- **Atributos**:
  - `pagina`: Objeto `PaginaWeb` a serializar.

- **Métodos**:
  - `serializarPagina()`: Método para serializar la página web completa (guardar).
  - `deserializarPagina()`: Método para deserializar la página web completa (cargar).


## Paso 5: Creación de la página web y manipulación de archivos

1. **Instanciación de componentes**: El estudiante debe instanciar varios objetos de las clases `Titulo`, `Parrafo`, `Imagen` y `Tabla`, añadirlos a un objeto de la clase `PaginaWeb`, y luego generar los archivos HTML y CSS correspondientes.

2. **Generación de los archivos**: Utilizando la clase `PaginaWeb`, se deben generar dos archivos:
   - **`index.html`**: Contendrá la estructura y el contenido de la página.
   - **`styles.css`**: Contendrá los estilos definidos para la página.

3. **Serialización de la página**: Utilizar la clase `SerializadorPagina` para guardar el estado de la página en un archivo binario y luego cargarla para comprobar que la estructura se mantiene correctamente.

## Criterios de Evaluación

- Correcta implementación de clases y métodos para generar los diferentes elementos HTML.
- Generación correcta de los archivos `index.html` y `styles.css`.
- Implementación de la serialización y deserialización de los objetos de la página.
- Calidad de la estructura y estilo de la página generada (aplicación de CSS).

## Referencias

### Recursos en línea

1. [MDN Web Docs (Mozilla Developer Network)](https://developer.mozilla.org/es/)
   MDN es una de las mejores fuentes para aprender HTML y CSS. Ofrece documentación clara y ejemplos prácticos tanto para principiantes como para usuarios avanzados.
     - [HTML: Introducción](https://developer.mozilla.org/es/docs/Web/HTML)
     - [CSS: Introducción](https://developer.mozilla.org/es/docs/Web/CSS)

2. [W3Schools](https://www.w3schools.com/)
  Un sitio muy popular para aprender HTML y CSS con tutoriales sencillos, ejemplos, y un editor en línea para probar código. Está dirigido a principiantes.
     - [HTML Tutorial](https://www.w3schools.com/html/)
     - [CSS Tutorial](https://www.w3schools.com/css/)

1. [HTML Dog](https://www.htmldog.com/)
   Ofrece tutoriales estructurados en niveles (principiante, intermedio y avanzado) para HTML y CSS.
     - [HTML Tutorials](https://www.htmldog.com/guides/html/)
     - [CSS Tutorials](https://www.htmldog.com/guides/css/)

2. [CSS-Tricks](https://css-tricks.com/)
   Un blog y sitio especializado en CSS, con artículos, trucos y ejemplos sobre cómo resolver problemas comunes de diseño web. Ideal para profundizar en CSS.
   - [CSS Guide](https://css-tricks.com/guides/)

### Libros

1. **"HTML & CSS: Design and Build Websites"** – *Jon Duckett*  
   
2. **"Learning Web Design"** – *Jennifer Niederst Robbins*  
   
3. **"CSS: The Definitive Guide"** – *Eric A. Meyer*  