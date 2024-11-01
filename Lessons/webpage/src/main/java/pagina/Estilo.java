package pagina;

public class Estilo {
  String color = "'#333'";
  String fuente = "'Segoe UI', Tahoma, Geneva, Verdana, sans-serif";
  String tamaño = "'20px'";
  String color_titulos = "'#1d3557'";

  public String generarCSS(){
    return 
    """
/* Estilos globales */
body {
    font-family: """+fuente+"""
    ;
    margin: 0;
    padding: 0 20px;
    background-color: #f0f0f5;
    color: """+color+"""
    ;
    font-size: """+tamaño+"""
    ;
    line-height: 1.6;
}

/* Estilo para el contenedor principal */
.container {
    width: 85%;
    margin: 20px auto;
    padding: 30px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

/* Estilos para los títulos */
h1, h2, h3, h4, h5, h6 {
    margin-bottom: 20px;
    font-weight: bold;
    color: """+fuente+"""
;
}

h1 {
    font-size: 2.8em;
    color: #e63946; /* Rojo brillante */
    border-bottom: 3px solid #457b9d;
    padding-bottom: 10px;
    text-align: center;
}

h2 {
    font-size: 2.2em;
    color: #457b9d; /* Azul claro */
    border-left: 5px solid #a8dadc;
    padding-left: 10px;
}

h3 {
    font-size: 1.8em;
    color: #1d3557;
}

/* Estilos para los párrafos */
p {
    margin-bottom: 20px;
    font-size: 1.1em;
    color: #444;
    line-height: 1.8;
    text-align: justify;
}

/* Estilos para los enlaces */
a {
    color: #e63946; /* Rojo brillante */
    text-decoration: none;
    font-weight: bold;
}

a:hover {
    color: #457b9d;
    text-decoration: underline;
    transition: color 0.3s;
}

/* Estilos mejorados para la imagen */
img {
    display: block;
    margin: 20px auto; /* Centrar la imagen horizontalmente */
    max-width: 80%; /* Ajustar la imagen al 80% del contenedor */
    height: auto; /* Mantener la proporción de la imagen */
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Sombra para efecto visual */
}

/* Estilos para tablas */
table {
    width: 80%;
    margin: 20px auto; /* Centrar la imagen horizontalmente */
    border-collapse: collapse;
    margin-bottom: 30px;
}

table th, table td {
    padding: 15px;
    border: 1px solid #ddd;
    text-align: left;
    font-size: 1em;
}

table th {
    background-color: #1d3557;
    color: white;
    text-transform: uppercase;
    text-align: center;
}

table tr:nth-child(even) {
    background-color: #f1faee;
}

table tr:hover {
    background-color: #a8dadc;
    color: white;
}

/* Estilos para las listas (ordenadas y no ordenadas) */
ul, ol {
    margin: 20px 0;
    padding-left: 40px;
}

ul li, ol li {
    margin-bottom: 10px;
    font-size: 1.1em;
}
/* Estilos mejorados para el pie de página */
footer {
    background-color: #1d3557; /* Fondo oscuro */
    color: #ffffff; /* Texto en blanco para mejor contraste */
    text-align: center; /* Centrar el texto */
    padding: 10px 0; /* Aumentar el espaciado superior e inferior */
    margin-top: 40px; /* Separar el pie de página del contenido anterior */
    font-size: 1em; /* Aumentar ligeramente el tamaño de la fuente */
    border-top: 5px solid #457b9d; /* Borde superior decorativo */
}

footer p {
    color: #f0f0f5;
    text-align: center; /* Centrar el texto */
    
}
""";
  }
}
