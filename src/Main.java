public class Main {
    public static void main(String[] args) {
        Object[] resultado = Argumentos.recibirArgumentos(args);
        /// Extraer parametros y validacion
        Parametros parametros = (Parametros) resultado[0];
        boolean parametrosValidos = (boolean) resultado[1];

        if(parametrosValidos) {
            /// Crear tablero inicial
            boolean[][] tableroInicial = Tablero.crearTablero(parametros.getAncho(), parametros.getAlto(), parametros.getPoblacion());
            Tablero.dibujarTablero(tableroInicial);

            /// Seleccionar patron del vecindario
            int[][] vecindario = Vecindarios.elegirPatron(parametros.getVecindario());

            /// Ejecutar las generaciones
            Generaciones.ejecutarGeneracion(tableroInicial, vecindario, parametros.getGeneraciones(), parametros.getVelocidad());
        }

    }


}