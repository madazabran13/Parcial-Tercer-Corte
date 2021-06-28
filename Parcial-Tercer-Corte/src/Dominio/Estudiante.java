
package Dominio;

import java.io.Serializable;

public class Estudiante implements Serializable{
    private int noDocumento;
    private String nombre, apellido;
    private int semestre;

    private Pregrado pregrado;
    private Postgrado postgrado;
    
    public Estudiante() {
    }

    public Estudiante(int noDocumento, String nombre, String apellido, int semestre) {
        this.noDocumento = noDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
    }

    public Estudiante(int noDocumento, String nombre, String apellido, int semestre, Pregrado pregrado, Postgrado postgrado) {
        this.noDocumento = noDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
        this.pregrado = pregrado;
        this.postgrado = postgrado;
    }
    
    
    public int getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(int noDocumento) {
        this.noDocumento = noDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Pregrado getPregrado() {
        return pregrado;
    }

    public void setPregrado(Pregrado pregrado) {
        this.pregrado = pregrado;
    }

    public Postgrado getPostgrado() {
        return postgrado;
    }

    public void setPostgrado(Postgrado postgrado) {
        this.postgrado = postgrado;
    }
    
    
    
    public String getDataText(){
        return  this.noDocumento+";"
                +this.nombre+";"
                +this.apellido+";"
                +this.semestre+";"
                +this.pregrado+";"
                +this.postgrado+";";              
                
    }
}
