package Vista;

import Modelo.*;

import javax.swing.*;
import java.awt.event.*;

import java.io.File;

public class Ventana_Principal extends JFrame implements ActionListener {

    private JLabel CargarArchivo;
    private JLabel Algoritmo;
    private JLabel MetodoOrdenamiento;
    private JButton Continuar;
    private JButton SubirArchivo;
    private JComboBox ASCDESC;
    private JComboBox Metodo;
    private JTextField Url;

    public Ventana_Principal() { // se crea una clase llamada ventana
        String[] modoDeOrdenar = { "Mayor a menor", "Menor a mayor" };
        String[] metodosOrdenamiento = { "Merge Sort", "Shell Sort", "Quick Sort" };

        setTitle("Bienvenido");// se le coloca el titulo a la ventana
        setLayout(null);
        CargarArchivo = new JLabel("Cargar archivo TXT");// Se crea el objeto del JLabel con su nombre
        CargarArchivo.setBounds(5, 10, 150, 20);// Se le da la posicion y altura con ancho de inicio
        add(CargarArchivo);
        MetodoOrdenamiento = new JLabel("Algoritmo de ordenamiento");
        MetodoOrdenamiento.setBounds(5, 45, 150, 20);
        add(MetodoOrdenamiento);
        ASCDESC = new JComboBox<>(metodosOrdenamiento);
        ASCDESC.setBounds(160, 45, 150, 20);
        add(ASCDESC);
        Algoritmo = new JLabel("Orden");
        Algoritmo.setBounds(5, 80, 80, 20);
        add(Algoritmo);
        Metodo = new JComboBox<>(modoDeOrdenar);
        Metodo.setBounds(160, 80, 150, 20);
        add(Metodo);
        Continuar = new JButton("Iniciar");
        Continuar.setBounds(5, 115, 70, 20);
        add(Continuar);
        Continuar.addActionListener(this);
        Url = new JTextField("");
        Url.setBounds(160, 10, 150, 20);
        add(Url);
        SubirArchivo = new JButton("Abrir");
        SubirArchivo.setBounds(320, 10, 70, 20);
        add(SubirArchivo);
        SubirArchivo.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == Continuar) {
            String seleccion = Metodo.getSelectedItem().toString();
            String seleccion2 = ASCDESC.getSelectedItem().toString();
            String ubicacion = Url.getText();
            Ventana_Guardar ventana_Guardar = new Ventana_Guardar(ubicacion, seleccion, seleccion2);
            ventana_Guardar.setVisible(true);
        } else if (evt.getSource() == SubirArchivo) {
            JFileChooser jf = new JFileChooser();
            jf.showOpenDialog(this);
            File archivo = jf.getSelectedFile();
            if (archivo != null) {
                Url.setText(archivo.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        Ventana_Principal ventana = new Ventana_Principal();
        ventana.setBounds(0, 0, 420, 250);
        ventana.setVisible(true);// Hacer visible la ventana
        ventana.setLocationRelativeTo(null);// Posicionar la ventana en el medio de la panatalla
    }
    
}



