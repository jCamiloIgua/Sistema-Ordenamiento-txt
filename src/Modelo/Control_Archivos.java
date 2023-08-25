package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class Control_Archivos {
    public String dirr;

    public void CargarArreglo(String nombreUrl, String metodo, String orden, String nombre) {
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreUrl))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int numero = Integer.parseInt(linea); // Convertir la línea a número
                numeros.add(numero); // Almacenar el número en la lista
            }
            // Convertir la lista a un arreglo
            int[] arreglo = new int[numeros.size()];
            for (int i = 0; i < numeros.size(); i++) {
                arreglo[i] = numeros.get(i);
            }
            Algoritmos algoritmo = new Algoritmos();
            System.out.println("metodo " + metodo);
            System.out.println("orden " + orden);
            System.out.println("nombreUrl " + nombreUrl);
            switch (orden) {
                case "Merge Sort":
                    algoritmo.sortS(arreglo, 0, arreglo.length - 1);
                    if (metodo.equals("Mayor a menor")) {
                        algoritmo.alreves(arreglo);
                        guardarArreglo(arreglo, nombre);
                    } else {
                        guardarArreglo(arreglo, nombre);
                    }
                    break;
                case "Shell Sort":
                    algoritmo.ShellSort(arreglo);
                    if (metodo.equals("Mayor a menor")) {
                        algoritmo.alreves(arreglo);
                        guardarArreglo(arreglo,nombre);
                    } else {
                        guardarArreglo(arreglo,nombre);
                    }
                    break;
                case "Quick Sort": // default será el mas optimo
                    algoritmo.quickSort(arreglo, 0, arreglo.length - 1);
                    if (orden.equals("Mayor a menor")) {
                        algoritmo.alreves(arreglo);
                        guardarArreglo(arreglo,nombre);
                    } else {
                        guardarArreglo(arreglo,nombre);
                    }
                    break;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public static void guardarArreglo(int[] arreglo, String nombreArchivo) {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            File archivo = new File(selectedDirectory, nombreArchivo);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
                for (int numero : arreglo) {
                    writer.write(Integer.toString(numero));
                    writer.newLine();
                }
                writer.close();
                JOptionPane.showMessageDialog(null, "Arreglo guardado! \n" + archivo.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }
    }
}