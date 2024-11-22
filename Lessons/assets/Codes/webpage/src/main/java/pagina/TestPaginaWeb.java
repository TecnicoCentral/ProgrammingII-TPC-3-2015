package pagina;

import java.io.Serializable;

public class TestPaginaWeb implements Serializable {

  public static void main(String[] args) {
    PaginaWeb pagina = new PaginaWeb("Mi página web", "index.html", "styles.css");
    System.out.println(pagina.plantilla);
    // Agregue las componentes
    pagina.agregarComponente(new Titulo("Bienvenido a Mi Página Profesional", "h1"));
    pagina.agregarComponente(new Titulo("Acerca de Nosotros", "h2"));
    pagina.agregarComponente(new Parrafo("""
        Somos una empresa con una sólida trayectoria en el desarrollo de software y la implementación de soluciones tecnológicas, comprometida con brindar a nuestros clientes servicios de alta calidad que se adapten a sus necesidades específicas. Nos especializamos en diseñar y crear productos tecnológicos innovadores, siempre a la vanguardia de las últimas tendencias del mercado."""));
        pagina.agregarComponente(new Parrafo("""
        Nuestro equipo de expertos trabaja estrechamente con cada cliente, entendiendo sus desafíos y objetivos, para ofrecer soluciones personalizadas que mejoren su eficiencia operativa y les permitan destacarse en un entorno competitivo. Creemos firmemente en la importancia de la innovación continua, por lo que nos esforzamos en utilizar las tecnologías más avanzadas y en proporcionar resultados que superen las expectativas, manteniendo altos estándares de calidad en cada etapa del proceso."""));
    pagina.agregarComponente(new Parrafo("""
        A lo largo de los años, hemos consolidado una reputación basada en la confianza, el profesionalismo y el cumplimiento de los plazos establecidos, lo que nos ha permitido establecer relaciones duraderas con nuestros clientes. Nuestro compromiso es seguir ofreciendo soluciones tecnológicas que impulsen el crecimiento y el éxito de las organizaciones que depositan su confianza en nosotros.
        """));
    pagina.agregarComponente(new Imagen("https://media.istockphoto.com/id/1316134499/photo/a-concept-image-of-a-magnifying-glass-on-blue-background-with-a-word-example-zoom-inside-the.jpg?s=612x612&w=0&k=20&c=sZM5HlZvHFYnzjrhaStRpex43URlxg6wwJXff3BE9VA=", "Imagen de ejemplo"));

    Enlace link_example = new Enlace("sitio oficial", "https://www.ejemplo.com", "_blank");
    pagina.agregarComponente(new Parrafo("Visita nuestro "+link_example.generarCodigoHTML()+" para más información."));
    
    String[][] tabla1 = {
      {"Servicio", "Descripción", "Precio"},
      {"Desarrollo Web", "Creación de sitios web modernos y personalizados.", "$1500"},
      {"Consultoría IT", "Asesoría en la implementación de tecnología en su empresa.", "$800"},
      {"Soporte Técnico", "Resolución de problemas y mantenimiento de sistemas.", "$500"},
    };
    pagina.agregarComponente(new Tabla(tabla1));
    pagina.agregarComponente(new Titulo("Acerca de Nosotros", "h2"));
    pagina.agregarComponente(new Parrafo("<b>Lorem Ipsum</b> is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"));
    pagina.agregarComponente(new Imagen("https://t3.ftcdn.net/jpg/00/92/53/56/360_F_92535664_IvFsQeHjBzfE6sD4VHdO8u5OHUSc6yHF.jpg", "Imagen de ejemplo"));
    
    Enlace link_google = new Enlace("Google", "https://www.google.com", "_blank");
    pagina.agregarComponente(new Titulo(link_google.generarCodigoHTML(), "h2"));
    pagina.agregarComponente(new Titulo("Final", "h5"));

    // Crear los archivos de html y css
    pagina.generarHTML();  // escribe archivo html
    pagina.generarCSS();   // escribe archivo de estilos, css

    // serialización
    SerializadorPagina serializador = new SerializadorPagina(pagina);
    serializador.serializarPagina("pagina1");

    // Des-serialización
    PaginaWeb pagina_ser = serializador.deserializarPagina("pagina1");
    System.out.println("Componente con indice 7:\n"+pagina_ser.componentes.get(7).generarCodigoHTML());
  }
  
}
