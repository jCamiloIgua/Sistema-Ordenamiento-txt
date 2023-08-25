package Modelo;

public class Algoritmos {
  int i, j, temporal, saltos;

  public Algoritmos() {
    this.i = 0;
    this.j = 0;
    this.temporal = 0;
    this.saltos = 0;
  }

  /*
   * Funcion para mezclar ambos arreglos, donde:
   * El arreglo izquierdo va desde inicio del arreglo, hasta indice medio del
   * arreglo.
   * El arreglo derecho va desde medio + 1 del arreglo, hasta final del arrelo.
   */
  void mergeS(int arreglo[], int inicioArreglo, int indiceMedio, int finalArreglo) {
    // Encontramos el tamaño de los dos subarreglos que se mezclaran para los
    // arreglos temporales
    int tamañoArregloIzquierda = indiceMedio - inicioArreglo + 1;
    int tamañoArregloDerecha = finalArreglo - indiceMedio;
    // Creamos los arreglos temporales con el tamaña anteriormente obtenido
    int arregloTemporalIzquierdo[] = new int[tamañoArregloIzquierda];
    int arregloTemporalDerecho[] = new int[tamañoArregloDerecha];
    // Copiamos los datos de los arreglos principales a los temporales
    for (int i = 0; i < tamañoArregloIzquierda; i++)
      arregloTemporalIzquierdo[i] = arreglo[inicioArreglo + i];
    for (int j = 0; j < tamañoArregloDerecha; j++)
      arregloTemporalDerecho[j] = arreglo[indiceMedio + 1 + j];
    // Mezclado de los arreglos temporales en otro arreglo
    // Indices iniciales del primer y segundo subarreglo
    int i, j, k;
    i = 0;
    j = 0;
    k = inicioArreglo;
    while (i < tamañoArregloIzquierda && j < tamañoArregloDerecha) {
      if (arregloTemporalIzquierdo[i] <= arregloTemporalDerecho[j]) {
        arreglo[k] = arregloTemporalIzquierdo[i];
        i++;
      } else {
        arreglo[k] = arregloTemporalDerecho[j];
        j++;
      }
      k++;
    }
    // Si el arregloTemporalDerecho copió todos los elementos, se pasaran los que
    // quedan restantes en el arregloTemporal izquierdo
    while (i < tamañoArregloIzquierda) {
      arreglo[k] = arregloTemporalIzquierdo[i];
      i++;
      k++;
    }
    // Si el arregloTemporalIzquierdo copió todos los elementos, se pasaran los que
    // quedan restantes en el arregloTemporalDerecho
    while (j < tamañoArregloDerecha) {
      arreglo[k] = arregloTemporalDerecho[j];
      j++;
      k++;
    }
  }

  /*
   * Funcion encargada de Ordenar el arreglo usando Merge(), recibe tres
   * parámetros:
   * 1. Arreglo a ordenar
   * 2. Inicio de la sublista
   * 3. Final de la sublista
   */
  public void sortS(int arreglo[], int inicioArreglo, int finalArreglo) {
    // Condicion if para verificar que el inicio sea menor que el final del arreglo
    // de forma que cuando esta no se cumpla es porque ya ordenó el mismo.
    if (inicioArreglo < finalArreglo) {
      // Encontramos el punto medio del arreglo
      int indiceMedio = (inicioArreglo + finalArreglo) / 2;
      // Ordenamos por recursividad la primera mitad del arreglo
      sortS(arreglo, inicioArreglo, indiceMedio);
      // Ordenamos por recursividad la segunda mitad del arreglo
      sortS(arreglo, indiceMedio + 1, finalArreglo);
      // Mezclamos ambas partes
      mergeS(arreglo, inicioArreglo, indiceMedio, finalArreglo);
    }
  }

  // metodo para ordenar descendentemente
  public void alreves(int[] arreglo) {
    int[] arregloInv = new int[arreglo.length];
    for (int i = 0; i < arreglo.length; i++) {
      arregloInv[i] = arreglo[arreglo.length - 1 - i];
    }
    for (int j = 0; j < arreglo.length; j++) {
      arreglo[j] = arregloInv[j];
    }
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

  // ShellSort
  public void ShellSort(int[] arreglo) {
    int salto;// valor del intervalo a separar el arragel en n subarreglos
    int aux;// guardar posicion arreglo
    int i;
    boolean cambios;// bandera por si se puede hacer un cambio en el arreglo
    // salto es el total del arrelgo el cual se divide en la mitad
    // Salto debe ser diferente de cero porque la minima es 1
    // luego de la primera iteracion dividir el salto en 2 y ese en 2 y
    // asi hasta llegar a un solo arreglo

    for (salto = arreglo.length / 2; salto != 0; salto /= 2) {
      cambios = true;
      while (cambios) { // Mientras se intercambie algún elemento
        cambios = false;// si se intercambia paselo a falso
        // se da una pasada en el arreglo
        for (i = salto; i < arreglo.length; i++) {// estaba por defecto >
          if (arreglo[i - salto] > arreglo[i]) { // (mayor o menor estaba < y si están desordenados
            aux = arreglo[i]; // se reordenan
            arreglo[i] = arreglo[i - salto];
            arreglo[i - salto] = aux;
            cambios = true; // se realizo un cambio
          }
        }
      }
    }
  }

}
