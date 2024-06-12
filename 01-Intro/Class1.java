class Class1 {
    public static void main(String[] args) {
        int n[] = {32, 27, 64, 18, 95, 14, 90, 70, 60, 37};
        
        // Imprimir encabezado
        System.out.printf("%-10s%-10s%n", "Elemento", "Valor");
        
        int suma = 0;  // Variable para almacenar la suma de los elementos
        
        // Imprimir cada elemento del arreglo y calcular la suma
        for (int i = 0; i < n.length; i++) {
            System.out.printf("%-10d%-10d%n", i, n[i]);
            suma += n[i];  // Sumar el valor actual al total
        }
        
        // Calcular el promedio
        double promedio = (double) suma / n.length;
        
        // Imprimir el promedio
        System.out.printf("%nPromedio: %.2f%n", promedio);
    }
}
