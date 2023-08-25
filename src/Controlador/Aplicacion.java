package Controlador;

import Vista.*;

public class Aplicacion {
    public static void main(String[] args) throws Exception {
        // frame
        Ventana_Principal ventana = new Ventana_Principal();
        ventana.setBounds(0, 0, 420, 195);
        ventana.setVisible(true);// Hacer visible la ventana
        ventana.setLocationRelativeTo(null);// Posicionar la ventana en el medio de la panatalla
        ventana.setResizable(false);//no se pueda agrandar ventana
    }
}
