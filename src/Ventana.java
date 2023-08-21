import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Ventana extends JFrame implements ActionListener {

    private JLabel CargarArchivo;
    private JLabel Algoritmo;
    private JLabel MetodoOrdenamiento;
    private JButton Iniciar;
    private JButton SubirArchivo;
    private JComboBox ASCDESC;
    private JComboBox Metodo;
    private JTextField Url;

    public Ventana() { // se crea una clase llamada ventana
        setTitle("Bienvenido");// se le coloca el titulo a la ventana
        setLayout(null);
        CargarArchivo = new JLabel("Cargar archivo TXT");// Se crea el objeto del JLabel con su nombre
        CargarArchivo.setBounds(5, 10, 150, 20);// Se le da la posicion y altura con ancho de inicio
        add(CargarArchivo);
        MetodoOrdenamiento = new JLabel("Método De Ordenamiento");
        MetodoOrdenamiento.setBounds(5, 45, 150, 20);
        add(MetodoOrdenamiento);
        ASCDESC = new JComboBox<>();
        ASCDESC.setBounds(160, 45, 150, 20);
        add(ASCDESC);
        Algoritmo = new JLabel("Orden");
        Algoritmo.setBounds(5, 80, 80, 20);
        add(Algoritmo);
        Metodo = new JComboBox<>();
        Metodo.setBounds(160, 80, 150, 20);
        add(Metodo);
        Iniciar = new JButton("Iniciar");
        Iniciar.setBounds(5, 115, 70, 20);
        add(Iniciar);
        Iniciar.addActionListener(this);
        Url = new JTextField("");
        Url.setBounds(160, 10, 150, 20);
        add(Url);
        SubirArchivo = new JButton("Abrir");
        SubirArchivo.setBounds(320, 10, 70, 20);
        add(SubirArchivo);
        SubirArchivo.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == Iniciar) {
            CargarArreglo();
            VentanaDos ventanaDos = new VentanaDos();
            ventanaDos.setVisible(true);
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
        Ventana ventana = new Ventana();
        ventana.setBounds(0, 0, 420, 250);
        ventana.setVisible(true);// Hacer visible la ventana
        ventana.setLocationRelativeTo(null);// Posicionar la ventana en el medio de la panatalla
    }

    public void CargarArreglo(){
        String nombreUrl = Url.getText();;
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreUrl))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int numero = Integer.parseInt(linea); // Convertir la línea a número
                numeros.add(numero); // Almacenar el número en la lista
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        // Convertir la lista a un arreglo
        Integer[] arreglo = numeros.toArray(new Integer[0]);
        // Imprimir el arreglo
        System.out.println("arreglo");

        System.out.println(arreglo.length);

        Algoritmos asd = new Algoritmos();
        asd.sort(arreglo, 0, arreglo.length-1);
        System.out.println("\nSorted array is");
        asd.printArray(arreglo);
    }
}
