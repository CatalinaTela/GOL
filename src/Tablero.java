import java.util.Random;

public class Tablero {
    public static boolean[][] crearTablero(int width, int height, String population) {
        boolean[][] tablero = new boolean[height][width];
        tablero = population.equals("rnd") ? tableroRandom(width, height) : tableroConValores(width, height, population);
        return tablero;
    }

    /// Generar tablero con parametros
    public static boolean[][] tableroConValores(int width, int height, String population) {
        boolean[][] tablero = new boolean[height][width];

        String[] rows = population.split("#");
        for (int fila = 0; fila < rows.length; fila++) {
            for (int columna = 0; columna < rows[fila].length(); columna++) {
                tablero[fila][columna] = rows[fila].charAt(columna) == '1';
            }
        }
        return tablero;
    }

    /// Generar tablero random
    public static boolean[][] tableroRandom(int width, int height) {
        boolean [][] tableroRND = new boolean[height][width];
        Random generator = new Random();

        for (int fila = 0; fila < height; fila++) {
            for (int columna = 0; columna < width; columna++) {
                tableroRND[fila][columna] = generator.nextInt(2) == 1;
            }
        }
        return tableroRND;
    }

    /// Dibujar tablero
    public static void dibujarTablero(boolean[][] tablero) {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                if (tablero[fila][columna]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
