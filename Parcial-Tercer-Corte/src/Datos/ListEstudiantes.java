
package Datos;

import Dominio.Estudiante;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ListEstudiantes implements IAccesoDatos{
    
    private List<Estudiante> lista;

    public ListEstudiantes() {
        this.lista = new ArrayList();
    }

    @Override
    public void registrarEstudiante(Estudiante e) throws IOException {
        this.lista.add(e);
    }

    @Override
    public List<Estudiante> leerEstudiante() throws IOException {
        return this.lista; 
    }

    @Override
    public Estudiante buscarEstudiante(int noDocumento) throws IOException {
        for (Estudiante e : this.lista) {
            if ( e.getNoDocumento() == (noDocumento) ) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Estudiante> buscarEstudiante(String nombre) throws IOException {
        List<Estudiante> encontrados = new ArrayList();
        for (Estudiante e : this.lista) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                encontrados.add(e);
            }
        }
        return encontrados;
    }

    @Override
    public List<Estudiante> consultarEstudiante(String filtroTexto) throws IOException {
        List<Estudiante> encontrados = new ArrayList();
        for (Estudiante e : this.lista) {
            if (e.getNombre().contains(filtroTexto) ||
                        e.getApellido().contains(filtroTexto)) {
                encontrados.add(e);
            }
        }
        return encontrados;
    }
    
    
}
