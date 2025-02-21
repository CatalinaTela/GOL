public class Parametros {
    private Integer ancho;
    private Integer alto;
    private Integer generaciones;
    private Integer velocidad;
    private Integer vecindario;
    private String poblacion;

    /// Constructor
    public Parametros(Integer ancho, Integer alto, Integer generaciones, Integer velocidad, Integer vecindario, String poblacion) {
        this.ancho = ancho;
        this.alto = alto;
        this.generaciones = generaciones;
        this.velocidad = velocidad;
        this.vecindario = vecindario;
        this.poblacion = poblacion;
    }

    /// Validar ancho alto y poblacion para crear tablero
    public static boolean sonValidos(String population, Integer width, Integer height, String mensajaPoblacion, String mensajaAncho, String mensajeAlto) {
        return mensajeAlto.equals(String.valueOf(width)) && mensajeAlto.equals(String.valueOf(height)) && mensajaPoblacion.equals(population);
    }

    /// Validar generaciones, vecindario y velocidad para crear tablero
    public static boolean todoEsValido(Integer generaciones, Integer velocidad, Integer vecindario, String mensajaGeneraciones, String mensajeVelocidad, String mensajeVecindario, boolean esValidoTablero) {
        return mensajeVecindario.equals(String.valueOf(vecindario)) && mensajeVelocidad.equals(String.valueOf(velocidad)) && mensajaGeneraciones.equals(String.valueOf(generaciones)) && esValidoTablero;
    }

    /// Metodos Get y Set No las estoy usando pero pueden servir
    public Integer getAncho() {
        return ancho;
    }
    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public Integer getAlto() {
        return alto;
    }
    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public Integer getGeneraciones() {
        return generaciones;
    }
    public void setGeneraciones(Integer generaciones) {
        this.generaciones = generaciones;
    }

    public Integer getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getVecindario() {
        return vecindario;
    }
    public void setVecindario(Integer vecindario) {
        this.vecindario = vecindario;
    }

    public String getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }




}



