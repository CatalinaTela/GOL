public class Vecindarios {
    /// Metodo seleccionar vecindario
    public static int[][] elegirPatron(int numeroVecindario){
        int[][] patron;
        switch (numeroVecindario){
            case 1 -> patron = patronJalaUniversity();
            case 2 -> patron = patronProgramming1();
            case 3 -> patron = patronMoore();
            case 4 -> patron = patronReverseJalaUniversity();
            case 5 -> patron = patronCustom();
            default -> patron = patronMoore();
        }
        return patron;
    }


    /// Metodo contador de vecinos
    public static int contadorVecinos(boolean [][] tablero, int fila, int columna, int[][] vecindario) {
        int contadorVecinosVivos = 0;
        int cantFilas = tablero.length;
        int cantColumnas = tablero[0].length;

        for(int[] pareja: vecindario){
            int filaVecina = fila + pareja[0];
            int columnaVecina = columna + pareja[1];

            /// Verificar no salirse del tablero
            if (filaVecina >= 0 && filaVecina < cantFilas && columnaVecina >= 0 && columnaVecina < cantColumnas){
                if(tablero[filaVecina][columnaVecina]){
                    contadorVecinosVivos++;
                }
            }
        }
        return contadorVecinosVivos;
    }



    /// Metodos para crear cada patron de cada vecindario

    public static int[][] patronJalaUniversity(){
        return new int[][]{
                        {-1,0},
                {0,-1},         {0,1},
                        {1,0}
        };
    }

    public static int[][] patronProgramming1(){
        return new int[][]{
                {-1,-1},{-1,0},
                {0,-1},         {0,1},
                        {1,0},  {1,1}
        };
    }

    public static int[][] patronMoore(){
        return new int[][]{
                {-1,-1},{-1,0},{-1,1},
                {0,-1},        {0,1},
                {1,-1},  {1,0}, {1,1}
        };
    }

    public static int[][] patronReverseJalaUniversity(){
        return new int[][]{
                {-1,-1},        {-1,1},

                {1,-1},          {1,1}
        };
    }

    public static int[][] patronCustom(){
        return new int[][]{
                {-1,-1},{-1,0},{-1,1},

                {1,-1},  {1,0}, {1,1}
        };
    }

}
