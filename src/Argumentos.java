public class Argumentos {
    public static Object[] recibirArgumentos(String[] args) {
        Integer width = null, height = null, generations = null, speed = null, neighborhood = 3;
        String population = "";

        ///  Booleano para saber si el parametro fue ingresado
        boolean wExist = false, hExist = false, gExist = false, sExist = false, pExist = false, nExist = false;


        for (String arg : args) {
            String[] partesDelArg = arg.split("=");

            // Asignar el valor a la variable correspondiente
            switch (partesDelArg[0]) {
                case "w":
                    wExist = true;
                    width = convertirEnteros(partesDelArg[1]);
                    break;
                case "h":
                    hExist = true;
                    height = convertirEnteros(partesDelArg[1]);
                    break;
                case "g":
                    gExist = true;
                    generations = convertirEnteros(partesDelArg[1]);
                    break;
                case "s":
                    sExist = true;
                    speed = convertirEnteros(partesDelArg[1]);
                    break;
                case "p":
                    pExist = true;
                    population = partesDelArg[1];
                    break;
                case "n":
                    nExist = true;
                    neighborhood = convertirEnteros(partesDelArg[1]);
                    break;
                default:
                    System.out.println("Parámetro desconocido: " + partesDelArg[0]);
                    break;
            }

        }

        /// Validar los parametros con la Clase CondicionesGOL
        ///  Verificar si existe, si no existe es "No presente",
        String messageWidth = !wExist ? "No presente" :
                /// sino validar si la variable no es nula y validar los parametros con la clase CondicionalGOL, si son validos devolver el valor de la variable, sino devolver "Invalido"
                (width != null && Condiciones.validarAncho(width) ? String.valueOf(width) : "Invalido");

        String messageHeight = !hExist ? "No presente" :
                (height != null && Condiciones.validarAlto(height) ? String.valueOf(height) : "Invalido");

        String messageGenerations = !gExist ? "No presente" :
                (generations != null && Condiciones.validarGeneraciones(generations) ? String.valueOf(generations) : "Invalido");

        String messageSpeed = !sExist ? "No presente" :
                (speed != null && Condiciones.validarVelocidad(speed) ? String.valueOf(speed) : "Invalido");

        String messageNeighborhood = !nExist ? "3" :
                (neighborhood != null && Condiciones.validarVecindario(neighborhood) ? String.valueOf(neighborhood) : "Invalido");

        String messagePopulation = !pExist ? "No presente" : (width != null ? Condiciones.validarPoblacion(population,width) : "Invalido");

        System.out.println("width = [" + messageWidth + "]");
        System.out.println("height = [" + messageHeight + "]");
        System.out.println("generations = [" + messageGenerations + "]");
        System.out.println("speed = [" + messageSpeed + "]");
        System.out.println("population = ['" + messagePopulation + "']");
        System.out.println("vecindario = [" + messageNeighborhood + "]");

        /// Si el tablero y la poblacion son validos dibujar tablero
        boolean tableroValido = Parametros.sonValidos(population, width, height, messagePopulation, messageWidth, messageHeight);
        if (tableroValido) {
            Tablero.crearTablero(width, height, population);
        }

        boolean parametrosValidos = Parametros.todoEsValido(generations, speed, neighborhood, messageGenerations, messageSpeed, messageNeighborhood, tableroValido);

        return new Object[] { new Parametros(width, height, generations, speed, neighborhood, population), parametrosValidos};
    }

    /// Metodo convertir a enteros si se puede
    private static Integer convertirEnteros(String valor) {
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            return null;
        }
    }


}
