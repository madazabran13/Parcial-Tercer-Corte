
package Dominio;

public class Pregrado extends Estudiante{
    
    private String  programaPregrado;
    private int corte1, corte2, corte3;
    

    public Pregrado() {
    }

    public Pregrado( int noDocumento, String nombre, String apellido, String programaPregrado,int semestre, int corte1, int corte2, int corte3) {
        super(noDocumento, nombre, apellido, semestre);
        this.programaPregrado = programaPregrado;
        this.corte1 = corte1;
        this.corte2 = corte2;
        this.corte3 = corte3;
    }

    

    public String getProgramaPregrado() {
        return programaPregrado;
    }

    public void setProgramaPregrado(String programaPregrado) {
        this.programaPregrado = programaPregrado;
    }

    
    public double PromedioCorte1(){
        return 0;
    }
    
    public double PromedioCorte2(){
        return 0;
    }
    
    public double PromedioCorte3(){
        return 0;
    }

    public int getCorte1() {
        return corte1;
    }

    public void setCorte1(int corte1) {
        this.corte1 = corte1;
    }

    public int getCorte2() {
        return corte2;
    }

    public void setCorte2(int corte2) {
        this.corte2 = corte2;
    }

    public int getCorte3() {
        return corte3;
    }

    public void setCorte3(int corte3) {
        this.corte3 = corte3;
    }
    

    @Override
    public String toString() {
        return  this.programaPregrado+";"
                +this.corte1+";"
                +this.corte2+";"
                +this.corte3+";";    
    }
    
    
}
