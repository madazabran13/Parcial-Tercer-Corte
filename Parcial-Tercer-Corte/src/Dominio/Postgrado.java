
package Dominio;


public class Postgrado extends Estudiante{
    private String  programaPostgrado;
    private int promedio;

    public Postgrado() {
    }

    public Postgrado(int noDocumento,String nombre, String apellido,String programaPostgrado, int semestre,int promedio) {
        super(noDocumento, nombre, apellido, semestre);
        this.programaPostgrado = programaPostgrado;
    }

    public String getProgramaPostgrado() {
        return programaPostgrado;
    }

    public void setProgramaPostgrado(String programaPostgrado) {
        this.programaPostgrado = programaPostgrado;
    }
    
    public String ProgramaPostgrado(){
        return null;    
    }
    
    public double PromedioSemestre(){
        return 0;     
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }
    
    
    @Override
    public String toString() {
        return  this.programaPostgrado+";"
                +this.promedio+";";    
    }
}
