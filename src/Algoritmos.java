public class Algoritmos {
    int i, j, temporal, saltos;

    public Algoritmos() {
        this.i = 0;
        this.j = 0;
        this.temporal = 0;
        this.saltos = 0;
    }

    public void MetodoBurbujaAscendente(Integer[] arreglo) {

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    temporal = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temporal;
                }
                saltos++;
            }
        }
        System.out.println(saltos + " saltos");
        MostrarArreglo(arreglo);
    }

    public void MostrarArreglo(Integer[] arreglo) {
        for (int k = 0; k < arreglo.length; k++) {
            System.out.print("[" + arreglo[k] + "] ");
        }
        System.out.println();
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public void merge(Integer[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(Integer arr[], int l, int r) {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public void printArray(Integer[] arreglo) {
        int n = arreglo.length;
        int contador = 0;
        for (int i = 0; i < n; ++i) {
            System.out.println(arreglo[i]);
            contador++;
        }
        System.out.println("saltos " + contador);
    }

}
