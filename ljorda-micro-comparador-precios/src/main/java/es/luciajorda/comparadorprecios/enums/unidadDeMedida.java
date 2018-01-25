package es.luciajorda.comparadorprecios.enums;

public enum unidadDeMedida {
	GRAMOS("gr"), 
	KILOS("kg"), 
	LITROS("l"), 
	MILILITROS("ml"), 
	UNIDAD("Unidad");
	
	private final String unidad;
  
    unidadDeMedida(String unidad) {
        this.unidad = unidad;
    }

    public String getUnidad() {
        return unidad;
    }
}
