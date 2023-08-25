package Modelo;

import java.io.FileWriter;
import java.io.IOException;

public class Algoritmos {
  int i, j, temporal, saltos;

  public Algoritmos() {
    this.i = 0;
    this.j = 0;
    this.temporal = 0;
    this.saltos = 0;
  }

  
  /** 
   * @param arr[]
   * Merge sort in Java
   * Funcion para mezclar ambos arreglos, donde:
   * El arreglo izquierdo va desde inicio del arreglo, hasta indice medio del
   * arreglo.
   * El arreglo derecho va desde medio + 1 del arreglo, hasta final del arrelo.
   */
  // Merge two subarrays L and M into arr
  void merge(int arr[], int p, int q, int r) {

    // Create L ← A[p..q] and M ← A[q+1..r]
    int n1 = q - p + 1;
    int n2 = r - q;

    int L[] = new int[n1];
    int M[] = new int[n2];

    for (int i = 0; i < n1; i++)
      L[i] = arr[p + i];
    for (int j = 0; j < n2; j++)
      M[j] = arr[q + 1 + j];

    // Maintain current index of sub-arrays and main array
    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    // Until we reach either end of either L or M, pick larger among
    // elements L and M and place them in the correct position at A[p..r]
    while (i < n1 && j < n2) {
      if (L[i] <= M[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = M[j];
        j++;
      }
      k++;
    }

    // When we run out of elements in either L or M,
    // pick up the remaining elements and put in A[p..r]
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = M[j];
      j++;
      k++;
    }
  }

  
  /** 
   * @param arr[]
   * Divide the array into two subarrays, sort them and merge them
   */
  public void mergeSort(int arr[], int l, int r) {
    if (l < r) {

      // m is the point where the array is divided into two subarrays
      int m = (l + r) / 2;

      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);

      // Merge the sorted subarrays
      merge(arr, l, m, r);
    }
  }

  
  /** 
   * @param arr[]
   */
  // Print the array
  public static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  public void mergeS(Integer[] arreglo, int inicioArreglo, int indiceMedio, int finalArreglo) {
    // Find sizes of two subarrays to be merged

    // Encontramos el tamaño de los dos subarreglos que se mezclaran para los
    // arreglos temporales
    int tamañoArregloIzquierda = indiceMedio - inicioArreglo + 1;
    int tamañoArregloDerecha = finalArreglo - indiceMedio;

    // Creamos los arreglos temporales con el tamaña anteriormente obtenido
    int arregloTemporalIzquierdo[] = new int[tamañoArregloIzquierda];
    int arregloTemporalDerecho[] = new int[tamañoArregloDerecha];

    // Copiamos los datos de los arreglos principales a los temporales
    for (int i = 0; i < tamañoArregloIzquierda; ++i) {
      arregloTemporalIzquierdo[i] = arreglo[inicioArreglo + i];
    }
    for (int j = 0; j < tamañoArregloDerecha; ++j) {
      arregloTemporalDerecho[j] = arreglo[indiceMedio + 1 + j];
    }
    // Mezclado de los arreglos temporales en otro arreglo

    // Indices iniciales del primer y segundo subarreglo
    int indiceIzquierda = 0, indiceDerecha = 0;
    // Indice inicial del arreglo con los subarreglos mezclados
    int indiceArreglo = inicioArreglo;
    while (indiceIzquierda < tamañoArregloIzquierda && indiceDerecha < tamañoArregloDerecha) {
      if (arregloTemporalIzquierdo[indiceIzquierda] <= arregloTemporalDerecho[indiceDerecha]) {
        arreglo[indiceArreglo] = arregloTemporalIzquierdo[indiceIzquierda];
        indiceIzquierda++;
      } else {
        arreglo[indiceArreglo] = arregloTemporalDerecho[indiceDerecha];
        indiceDerecha++;
      }
      indiceArreglo++;
    }
    // Si el arregloTemporalDerecho copió todos los elementos, se pasaran los que
    // quedan restantes en el arregloTemporal izquierdo
    while (indiceIzquierda < tamañoArregloIzquierda) {
      arreglo[indiceArreglo] = arregloTemporalIzquierdo[indiceIzquierda];
      indiceIzquierda++;
      indiceArreglo++;
    }
    // Si el arregloTemporalIzquierdo copió todos los elementos, se pasaran los que
    // quedan restantes en el arregloTemporalDerecho
    while (indiceDerecha < tamañoArregloDerecha) {
      arreglo[indiceArreglo] = arregloTemporalDerecho[indiceDerecha];
      indiceDerecha++;
      inicioArreglo++;
    }
    System.out.println("ordenado");
  }

  /*
   * Funcion encargada de Ordenar el arreglo usando Merge(), recibe tres
   * parámetros:
   * 1. Arreglo a ordenar
   * 2. Inicio de la sublista
   * 3. Final de la sublista
   */

  public void sortS(Integer arreglo[], int inicioArreglo, int finalArreglo) {
    // Condicion if para verificar que el inicio sea menor que el final del arreglo
    // de forma que cuando esta no se cumpla es porque ya ordenó el mismo.
    if (inicioArreglo < finalArreglo) {
      // Encontramos el punto medio del arreglo
      int indiceMedio = inicioArreglo + (finalArreglo - inicioArreglo) / 2;
      // Ordenamos por recursividad la primera mitad del arreglo
      sortS(arreglo, inicioArreglo, indiceMedio);
      // Ordenamos por recursividad la segunda mitad del arreglo
      sortS(arreglo, indiceMedio + 1, finalArreglo);
      // Mezclamos ambas partes
      mergeS(arreglo, inicioArreglo, indiceMedio, finalArreglo);
    }
  }

  /*
   * Funcion para imprimir arreglo ordenado.
   */
  public void imprimirArreglo(int[] arreglo) {
    int longitudArreglo = arreglo.length;
    int contador = 0;
    // Ciclo for para imprimir el arreglo en su totalidad, usando la condicion
    // i < longitudArreglo
    for (int i = 0; i < longitudArreglo; ++i) {
      System.out.println(arreglo[i]);
      contador++;
    }
    System.out.println("saltos " + contador);
  }

  // QuickSort

  public void quickSort(int A[], int izq, int der) {

    int pivote = A[izq]; // tomamos primer elemento como pivote
    int i = izq; // i realiza la búsqueda de izquierda a derecha
    int j = der; // j realiza la búsqueda de derecha a izquierda
    int aux;

    while (i < j) { // mientras no se crucen las búsquedas
      while (A[i] <= pivote && i < j)
        i++; // busca elemento mayor que pivote
      while (A[j] > pivote)
        j--; // busca elemento menor que pivote
      if (i < j) { // si no se han cruzado
        aux = A[i]; // los intercambia
        A[i] = A[j];
        A[j] = aux;
      }
    }

    A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
    A[j] = pivote; // los menores a su izquierda y los mayores a su derecha

    if (izq < j - 1)
      quickSort(A, izq, j - 1); // ordenamos subarray izquierdo
    if (j + 1 < der)
      quickSort(A, j + 1, der); // ordenamos subarray derecho

  }

  public static void quickSortDesc(int A[], int izq, int der) {
    int pivote = A[izq];
    int i = izq;
    int j = der;
    int aux;

    while (i < j) {
      while (A[i] >= pivote && i < j) // Cambiamos el operador <= por >=
        i++;
      while (A[j] < pivote) // Cambiamos el operador > por <
        j--;
      if (i < j) {
        aux = A[i];
        A[i] = A[j];
        A[j] = aux;
      }
    }

    A[izq] = A[j];
    A[j] = pivote;

    if (izq < j - 1)
      quickSortDesc(A, izq, j - 1);
    if (j + 1 < der)
      quickSortDesc(A, j + 1, der);
  }

  // ShellSort
  public void ShellSort(){
    int [] A = {15,33,27,10,35,19,42,44};
        int salto;//valor del intervalo a separar el arragel en n subarreglos
        int aux;//guardar posicion arreglo
        int i;
        boolean cambios;//bandera por si se puede hacer un cambio en el arreglo
        //salto es el total del arrelgo el cual se divide en la mitad
        //Salto debe ser diferente de cero porque la minima es 1
        //luego de la primera iteracion dividir el salto en 2 y ese en 2 y asi hasta llegar a un solo arreglo

        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento                                         
                cambios = false;//si se intercambia paselo a falso
                // se da una pasada en el arreglo 
                for (i = salto; i < A.length; i++)  
                {//estaba por defecto >
                    if (A[i - salto] > A[i]) { // (mayor  o menor estaba <  y si están desordenados
                        aux = A[i];           // se reordenan
                        A[i] = A[i - salto];
                        A[i - salto] = aux;
                        cambios = true; // se realizo un cambio                                  
                    }
                }
            }
      }
  }


  // Descendentemente

}
