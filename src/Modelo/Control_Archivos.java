package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Control_Archivos {

    
    /** 
     * @param nombreUrl
     * @param metodo
     */
    public void CargarArreglo(String nombreUrl, String metodo) {
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreUrl))) {
            System.out.println("hola si");
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

            Algoritmos asd = new Algoritmos();
            metodo = "quick";

            switch (metodo) {
                case "merge":
                    asd.mergeSort(arreglo, 0, arreglo.length - 1);
                    System.out.println("\nSorted array is");
                    break;
                case "quick":
                System.out.println("quick");
                asd.quickSort(arreglo, 0, arreglo.length - 1);
                asd.imprimirArreglo(arreglo);
                    break;
                
                default: //default será el mas optimo

                
                    break;
            }
            
            /*
            asd.printArray(arreglo);
            Control_Archivos cn = new Control_Archivos();
            cn.guardarNumerosEnArchivo(nombreUrl, arreglo);
            System.out.println();
            System.out.println("termino"); */
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        // Convertir la lista a un arreglo

        // Imprimir el arreglo

    }

    
    /** 
     * @param arreglo
     */
    public void guardar(Integer[] arreglo) {
        try {
            FileWriter writer = new FileWriter("asdasd.txt");
            for (int elemento : arreglo) {
                writer.write(Integer.toString(arreglo[elemento]));
                writer.write(System.lineSeparator());
            }
            writer.close();
            System.out.println("Arreglo ordenado por inserción escrito en el archivo exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void guardarNumerosEnArchivo(String nombreArchivo, int[] arreglo) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("asd.txt")))) {
            for (Integer numero : arreglo) {
                pw.println(numero);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public class ArregloToFileWriter {
        public void guardarArregloEnArchivo(int[] arreglo, String rutaArchivo) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
                for (int numero : arreglo) {
                    bw.write(Integer.toString(numero)); // Convertir número a String y escribirlo
                    bw.newLine(); // Agregar una nueva línea después de cada número
                }
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }
    }
}