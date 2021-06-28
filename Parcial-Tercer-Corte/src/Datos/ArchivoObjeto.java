
package Datos;

import Dominio.Estudiante;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


public class ArchivoObjeto implements IAccesoDatos{
    
    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;

    public ArchivoObjeto(String name) {
        this.archivo = new File(name);
    }

    public ArchivoObjeto() {
        this("Registro-Academico.obj");
    }
    
    private void guardar(ListEstudiantes lista) throws IOException {
        ObjectOutputStream oos = null;
        try {
            this.aEscritura = new FileOutputStream(this.archivo, false);
            oos = new ObjectOutputStream(this.aEscritura);
            oos.writeObject(lista);
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (oos != null) {
                oos.close();
            }

            if (this.aEscritura != null) {
                this.aEscritura.close();
            }
        }
    }
    
    private ListEstudiantes leer() throws IOException {
        ListEstudiantes lista = null;
        ObjectInputStream ois = null;

        if (this.archivo.exists()) {
            try {
                this.aLectura = new FileInputStream(this.archivo);
                ois = new ObjectInputStream(this.aLectura);
                lista = (ListEstudiantes) ois.readObject();
                return lista;
            } catch (IOException ioe) {
                throw ioe;
            } catch (ClassNotFoundException ex) {
                throw new IOException("La clase ListEstudiantes No existe");
            } finally {
                if (ois != null) {
                    ois.close();
                }
                if (this.aLectura != null) {
                    this.aLectura.close();
                }
            }
        }
        else{
            lista = new ListEstudiantes();
            return lista;
        }

    }

    @Override
    public void registrarEstudiante(Estudiante e) throws IOException {
        ListEstudiantes lista = this.leer();
        lista.registrarEstudiante(e);
        this.guardar(lista);
    }

    @Override
    public List<Estudiante> leerEstudiante() throws IOException {
        ListEstudiantes lista = this.leer();
        return lista.leerEstudiante();
    }

    @Override
    public Estudiante buscarEstudiante(int noDocumento) throws IOException {
        ListEstudiantes lista = this.leer();
        return lista.buscarEstudiante(noDocumento);
    }

    @Override
    public List<Estudiante> buscarEstudiante(String nombre) throws IOException {
        ListEstudiantes lista = this.leer();
        return lista.buscarEstudiante(nombre);
    }

    @Override
    public List<Estudiante> consultarEstudiante(String filtroTexto) throws IOException {
        ListEstudiantes lista = this.leer();
        return  lista.consultarEstudiante(filtroTexto);
    }
}
