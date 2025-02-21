public class Condiciones {
    public static boolean validarAncho(int width) {
        /// Validar ancho (Unicos valores 10, 20, 40, 80)
        return width == 10 || width == 20 || width == 40 || width == 80;
    }

    public static boolean validarAlto(int height) {
        /// Validar alto (Unicos valores 10, 20, 40)
        return height == 10 || height == 20 || height == 40;
    }

    public static boolean validarGeneraciones(int generations) {
        /// Validar numero de generaciones (>= 0 si el valor es 0, se ejecutara hasta que el usuario presione una tecla)
        return generations >= 0;
    }

    public static boolean validarVelocidad(int speed) {
        /// Validar velocidad (Unicos valores 250,1000)
        return speed >= 250 && speed <= 1000;
    }

    public static boolean validarVecindario(int neighborhood) {
        /// Validar vecindario (Opciones [1,2,3,4,5] si  es 0 o null asignar n=3)
        return neighborhood >= 0 && neighborhood <= 5;
    }

    public static String validarPoblacion(String population, int width) {

        /// Validar poblacion ( las filas se separan por #, tiene que ser mas chico que la cuadricula, si faltan numeros se considera 0, "rnd" significa que sea random el patron, 0->dead, 1->alive)
        if (!population.equals("rnd")){
            String[] rows = population.split("#");
            for (String row : rows) {
                if (row.length() > width) {
                    return "Invalido";
                }
            }

        }
        return population;
    }
}
