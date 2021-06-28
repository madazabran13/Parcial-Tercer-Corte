
package Negocio;

import Datos.ArchivoObjeto;
import Datos.IAccesoDatos;
import Dominio.Estudiante;
import java.io.IOException;
import java.util.List;


public class GestionEstudiantes {
    
     private IAccesoDatos datos;

    public GestionEstudiantes() {
        
        this.datos = new ArchivoObjeto();
        
    }
    
    public void registrarEstudiante(Estudiante e) throws IOException{
        if(e==null)
            throw new NullPointerException("Debe registrar un Jugador");
        
        if(e.getNoDocumento()<=0)
            throw new NullPointerException("Debe registrar documento del Estudiante");
        
        if(e.getNombre()==null || e.getNombre().isEmpty())
            throw new NullPointerException("Debe registrar nombre del Estudiante");
        
        if(e.getApellido()==null || e.getApellido().isEmpty())
            throw new NullPointerException("Debe registrar apellido del Estudiante");
        
        if(e.getSemestre()<=0)
            throw new NullPointerException("Debe registrar semestre del Estudiante");
        
        if(e.getPregrado().getProgramaPregrado()==null || e.getPregrado().getProgramaPregrado().isEmpty())
            throw new NullPointerException("Debe registrar programaPregrado del Estudiante");
        
         if(e.getPostgrado().getProgramaPostgrado()==null || e.getPostgrado().getProgramaPostgrado().isEmpty())
            throw new NullPointerException("Debe registrar programaPregrado del Estudiante");
        
        if(this.datos.buscarEstudiante(e.getNombre())!=null)
            throw new NullPointerException("El Estudiante ya se encuentra registrado");
        
        this.datos.registrarEstudiante(e);
    }
    
    public List<Estudiante> leerEstudiante()throws IOException{
        return this.datos.leerEstudiante();
    }
    
    public Estudiante buscarEstudiante(int noDocumento) throws IOException{
        return this.datos.buscarEstudiante(noDocumento);
    }
    
    public List<Estudiante> buscarEstudiante(String nombre)throws IOException{
        return this.datos.buscarEstudiante(nombre);
    }
    
    public List<Estudiante> filtrarRegistroEstudiante(String filtro)throws IOException{
        return this.datos.consultarEstudiante(filtro);
    }
}
