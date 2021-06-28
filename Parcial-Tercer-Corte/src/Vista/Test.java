
package Vista;

import Dominio.Estudiante;
import Dominio.Postgrado;
import Dominio.Pregrado;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        VentanaPregrado ventanapre = new VentanaPregrado(null, true);
        VentanaPostgrado ventanapost = new VentanaPostgrado(null, true);
        
        Pregrado pre1 = new Pregrado(1003243573,"LUIS MANUEL","DIAZ SEQUEA","SISTEMAS",4,3,4,5);
        Postgrado post1 = new Postgrado(1065853781, "MICHEEL TATIANA", "ROJAS HOYOS","DESARROLLO SOFTWARE",2,4);
    
        
    
    }
    
    public static void imprimirListado(List<Estudiante> lista){
        for(Estudiante e : lista){
               System.out.println(e);
        }
        System.out.println(lista.size() + " Jugadores registrados");
    }
}
