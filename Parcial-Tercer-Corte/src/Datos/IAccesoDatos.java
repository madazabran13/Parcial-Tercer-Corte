
package Datos;

import Dominio.Estudiante;
import java.io.IOException;
import java.util.List;

public interface IAccesoDatos {
    
    void registrarEstudiante(Estudiante e) throws IOException;
    List<Estudiante> leerEstudiante() throws IOException;
    Estudiante  buscarEstudiante(int noDocumento)throws IOException;
    List<Estudiante> buscarEstudiante(String nombre) throws IOException;
    List<Estudiante> consultarEstudiante(String filtroTexto) throws IOException;
}
