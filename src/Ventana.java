import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener{

    private JLabel CargarArchivo;
    private JLabel Algoritmo;
    private JLabel MetodoOrdenamiento;
    private JButton Iniciar;
    private JComboBox ASCDESC;
    private JComboBox Metodo;

    public Ventana(){ //se crea una clase llamada ventana
        setTitle("Bienvenido");//se le coloca el titulo a la ventana
        setLayout(null);

        CargarArchivo = new JLabel("Cargar archivo TXT");//Se crea el objeto del JLabel con su nombre
        CargarArchivo.setBounds(5, 10, 150, 20);//Se le da la posicion y altura con ancho de inicio
        add(CargarArchivo);
        MetodoOrdenamiento = new JLabel("Metodo De Ordenamiento");
        MetodoOrdenamiento.setBounds(5, 45, 150, 20);
        add(MetodoOrdenamiento);
        ASCDESC = new JComboBox<>();
        ASCDESC.setBounds(160, 45, 150, 20);
        add(ASCDESC);
        Algoritmo = new JLabel("Algoritmo"); 
        Algoritmo.setBounds(5, 80, 80, 20); 
        add(Algoritmo);
        Metodo = new JComboBox<>();
        Metodo.setBounds(160, 80, 150, 20);
        add(Metodo);
        Iniciar = new JButton("Iniciar");
        Iniciar.setBounds(5, 115, 70, 20);
        add(Iniciar);
        Iniciar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Iniciar){
            VentanaDos ventanaDos = new VentanaDos();
            ventanaDos.setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setBounds(0, 0, 350, 250);
        ventana.setVisible(true);//Hacer visible la ventana
        ventana.setLocationRelativeTo(null);//Posicionar la ventana en el medio de la panatalla
    }
    
}
