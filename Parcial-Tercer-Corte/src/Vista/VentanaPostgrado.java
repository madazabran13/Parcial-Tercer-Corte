
package Vista;

import Dominio.Estudiante;
import Negocio.GestionEstudiantes;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class VentanaPostgrado extends JDialog {
    private Container contenedor;
    private JPanel panelFiltro, panelBase;
    private JScrollPane panelResultado;
    private JLabel lFiltro;
    private JTextField tFiltro;
    private JTable tabla;
    private DefaultTableModel modelo;
    
    private String titulos1[]={"No Documento", "Nombre", "Apellido", "Programa Postgrado",
                              "Semestre","Promedio"};
    private GestionEstudiantes gestor;
    
    public VentanaPostgrado(JFrame frame, boolean bln) {
        super(frame, bln);
        this.setTitle("ESTUDIANTES DE POSTGRADO");
        this.gestor = new GestionEstudiantes();
        this.iniciarComponentes();
        //this.pack(); 
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    
    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.panelBase = new JPanel();
        this.panelBase.setLayout(new BorderLayout());
        this.panelBase.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.iniciarPanelFiltro();
        this.iniciarPanelResultado();
        this.mostraTotalRegistros();
        this.contenedor.add(this.panelBase);
    }
    
    public void iniciarPanelFiltro(){
        this.panelFiltro = new JPanel();
        this.panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        this.lFiltro= new JLabel("Filtro busqueda: ");
        this.tFiltro= new JTextField(10);
        this.tFiltro.addKeyListener(new EventoTecladoFiltro());
        
        this.panelFiltro.add(this.lFiltro);
        this.panelFiltro.add(this.tFiltro);
        
        this.panelBase.add(this.panelFiltro, BorderLayout.NORTH);
        
       
    }
    
    public void iniciarPanelResultado(){
        this.panelResultado = new JScrollPane();
        
        this.tabla = new JTable();
        this.modelo = new DefaultTableModel(null, this.titulos1);
        this.tabla.setModel(modelo);
        this.panelResultado.setViewportView(this.tabla);
        this.panelBase.add(this.panelResultado, BorderLayout.CENTER);
    
    }
    
    public void mostraTotalRegistros(){
        try{
            List<Estudiante> lista = this.gestor.leerEstudiante();
            this.actualizarTabla(lista);
            
        }catch(IOException ioe){
            this.ventanaMsg("Error", ioe.getMessage(), JOptionPane.ERROR_MESSAGE);
        }    
        
    }
    
    public void actualizarTabla(List<Estudiante> lista){
            this.modelo.setNumRows(0);
            for(Estudiante e : lista){
                String linea[] ={""+e.getNoDocumento(), e.getNombre(), e.getApellido(),
                                 ""+e.getSemestre(), e.getPregrado().getProgramaPregrado(), 
                                 e.getPostgrado().getProgramaPostgrado(),
                                };
                this.modelo.addRow(linea);
            }
    }
    
    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }
    
    public void filtrarTabla(){
        String texto = this.tFiltro.getText();
        try{
            List<Estudiante> listaFiltrada = this.gestor.filtrarRegistroEstudiante(texto);
            this.actualizarTabla(listaFiltrada);
            
        }catch(IOException ioe){
            this.ventanaMsg("Error", ioe.getMessage(), JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    class EventoTecladoFiltro extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent ke) {
            filtrarTabla();
        }
    }
}
