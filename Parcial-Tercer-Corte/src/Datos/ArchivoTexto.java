
package Datos;

import Dominio.Estudiante;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoTexto implements IAccesoDatos{
    
    private File archivo;
    private FileWriter modoEscritura; // abre el archivo para escritura
    private Scanner modoLectura; // abre el archivo en modo lectura

    public ArchivoTexto() {
        this.archivo = new File("Registro-Academico.dat");
    }

    public ArchivoTexto(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
    }

    @Override
    public void registrarEstudiante(Estudiante e) throws IOException {
    
        PrintWriter pw = null;
        try {
            this.modoEscritura = new FileWriter(this.archivo, true); // modo edicion
            pw = new PrintWriter(this.modoEscritura);
            pw.println(e.getDataText());
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (pw != null) {
                pw.close();
            }
            this.modoEscritura.close();
        }
    }
    
     private Estudiante crearEstudiante(String linea) {

        String datos[] = linea.split(";");
        Estudiante e = new Estudiante();
        e.setNoDocumento(Integer.parseInt(datos[0]));
        e.setNombre(datos[1]);
        e.setApellido(datos[2]);
        e.setSemestre(Integer.parseInt(datos[3]));
        e.getPregrado().setProgramaPregrado(datos[4]);
        e.getPostgrado().setProgramaPostgrado(datos[5]);
        return e;
    }

    @Override
    public List<Estudiante> leerEstudiante() throws IOException {
         List<Estudiante> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Estudiante e = this.crearEstudiante(linea);
                listado.add(e);
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    @Override
    public Estudiante buscarEstudiante(int noDocumento) throws IOException {
        Estudiante encontrado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Estudiante e = this.crearEstudiante(linea);
                if (e.getNoDocumento() == (noDocumento)) {
                    encontrado = e;
                    break;
                }
            }
            return encontrado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    @Override
    public List<Estudiante> buscarEstudiante(String nombre) throws IOException {
        List<Estudiante> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Estudiante e = this.crearEstudiante(linea);
                if (e.getNombre().equalsIgnoreCase(nombre)) {
                    listado.add(e);
                }
                
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    
    @Override
    public List<Estudiante> consultarEstudiante(String filtroTexto) throws IOException {
        List<Estudiante> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Estudiante e = this.crearEstudiante(linea);
                if ( e.getNombre().contains(filtroTexto) ||
                        e.getApellido().contains(filtroTexto)) {
                    listado.add(e);
                }
                
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }
    
    
}
