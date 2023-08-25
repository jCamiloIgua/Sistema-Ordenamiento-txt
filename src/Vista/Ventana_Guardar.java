package Vista;

import javax.swing.*;
import java.awt.event.*;
import Modelo.Control_Archivos;

public class Ventana_Guardar extends JFrame implements ActionListener {
    private JButton guardar;
    private JTextField Path;
    private JLabel guardarDoc;
    public String Url;
    public String Order;
    public String Algorithm;

    public String path = "";
    public String direccion;
    public Ventana_Guardar(String ubicacion,String algoritmo, String orden) {
        setTitle("Guardar");
        setLayout(null);
        this.setResizable(false);//no se pueda agrandar ventana
        this.setBounds(0, 0, 300, 135);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        guardarDoc = new JLabel("Guardar archivo como:");
        guardarDoc.setBounds(10, 10, 150, 20);
        add(guardarDoc);
        guardar = new JButton("guardar");
        guardar.setBounds(163, 33, 80, 20);
        guardar.addActionListener(this);
        add(guardar);
        Path = new JTextField("");
        Path.setBounds(10, 33, 150, 20);
        add(Path);
        Url = ubicacion;
        Order = orden;
        Algorithm = algoritmo;
    }
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == guardar) {
            System.out.println(Algorithm + "alg");
            datos(Url, Algorithm, Order, Order + "-" + Path.getText() + ".txt");
            this.dispose();
        }
    }
    public void datos(String ubicacion, String metodo, String orden, String nombre) {
        Control_Archivos cargar = new Control_Archivos();
        cargar.CargarArreglo(ubicacion, metodo, orden, nombre);
    }

}
