/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom_sax_jaxb;

import java.io.File;
import java.util.List;
import javalibros.Libros;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javalibros.Libros.Libro;

public class JAXB {

    Libros misLibros;

    public int abrir_XML_JAXB(File fichero) {

        try {
            //Crea una instancia JAXB
            JAXBContext contexto = JAXBContext.newInstance(Libros.class);
            //Crea un oobjeto Unmarshaller
            Unmarshaller u = contexto.createUnmarshaller();
            //Deserializa (unmarshal) el fichero
            misLibros = (Libros) u.unmarshal(fichero);
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    public String recorrerJAXB() {

        String cadena_resultado = "";

        List<Libros.Libro> lLibros = misLibros.getLibro();

        for (int i = 0; i < lLibros.size(); i++) {
            Libro libro_temp = lLibros.get(i);
            cadena_resultado = cadena_resultado + "\nPublicado en: " + libro_temp.getPublicadoEn();

            cadena_resultado = cadena_resultado + "\nTitulo: " + libro_temp.getTitulo();

            cadena_resultado = cadena_resultado + "\nAutor: " + libro_temp.getAutor();

            cadena_resultado = cadena_resultado + "\nEditorial: " + libro_temp.getEditorial();

            cadena_resultado = cadena_resultado + "\n------------------------";
        }

        return cadena_resultado;
    }

}
