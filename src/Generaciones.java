public class Generaciones {
    public static boolean[][] nuevaGeneracion(boolean[][] tablero, int[][] vecindario) {
        int cantFilas = tablero.length;
        int cantColumnas = tablero[0].length;
        boolean [][] nuevoTablero = new boolean[cantColumnas][cantFilas];

        for (int fila = 0; fila < cantFilas; fila++) {
            for (int columna = 0; columna < cantColumnas; columna++) {
                int vecinosVivos = Vecindarios.contadorVecinos(tablero, fila, columna, vecindario);
                boolean estaVivo = tablero[fila][columna];

                /// Comprobar si vive, revive, o muere
                nuevoTablero[fila][columna] = reglas(vecinosVivos, estaVivo);
            }
        }
        return nuevoTablero;
    }

    /// Metodo Reglas GOL
    public static boolean reglas (int vecinosVivos, boolean estado) {
        if (estado) {
            /// Si esta viva, sigue viva solo si tiene 2 o 3 vecinos, sino muere
            return (vecinosVivos == 2) || (vecinosVivos == 3);
        } else {
            /// Si esta muerta, revive con 3 vecinos, sino sigue muerta
            return vecinosVivos == 3;
        }
    }


    /// Metodo ejecutar la cantidad de generaciones
    public static void ejecutarGeneracion(boolean[][] tablero, int[][] vecindario, int generaciones, int velocidad) {
        for(int numeroGeneracion = 0; numeroGeneracion < generaciones || generaciones == 0; numeroGeneracion++) {
            /// Dibujar generacion actual
            System.out.println("Generacion " + (numeroGeneracion) + ":");
            Tablero.dibujarTablero(tablero);

            /// Calcular siguiente generacion
            tablero = nuevaGeneracion(tablero, vecindario);

            /// Esperar a la siguiente generacion
            try{
                Thread.sleep(velocidad);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
