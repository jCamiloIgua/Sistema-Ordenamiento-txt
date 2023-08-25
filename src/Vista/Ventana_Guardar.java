package Vista;

import javax.swing.*;
import java.awt.event.*;
import Modelo.*;


public class Ventana_Guardar extends JFrame implements ActionListener {
    private JButton guardar;
    public String ubicacion;
    public String Url;
    public Ventana_Guardar(String ubicacion) {

        setTitle("Guardar");
        setLayout(null);
        System.out.println("ubi en cons "+ ubicacion);

        this.setBounds(0, 0, 300, 200);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        guardar = new JButton("guardar");
        guardar.setBounds(5, 115, 70, 20);
        add(guardar);
        guardar.addActionListener(this);

        Url=ubicacion;
        datos(ubicacion, "a","a");
    }

    
    /** 
     * @param evt
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == guardar) {
            System.out.println(Url+ " Url ubicaicon");
        } /*
           * else if (evt.getSource() == guardar) {
           * JFileChooser jf = new JFileChooser();
           * jf.showOpenDialog(this);
           * File archivo = jf.getSelectedFile();
           * if (archivo != null) {
           * Url.setText(archivo.getAbsolutePath());
           * }
           * }
           */
    }

    
    /** 
     * @param ubicacion
     * @param metodo
     * @param orden
     */
    public void datos(String ubicacion, String metodo, String orden) {

        Control_Archivos cargar = new Control_Archivos();
        cargar.CargarArreglo(ubicacion, metodo);
        Algoritmos algoritmo = new Algoritmos();

        if(algoritmo.equals("merge")){

        } else if (algoritmo.equals("quick")){

        } else{

        }

        
    }
}
