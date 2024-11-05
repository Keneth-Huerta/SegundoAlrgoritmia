package gamificaciondeportiva;

//Clase para gestionar logros
class Logro {
	private String id;
	private String nombre;
	private String descripcion;
	private int puntosRecompensa;
	private boolean completado;
	private TipoLogro tipo;

	public enum TipoLogro {
		DISTANCIA, TIEMPO, FRECUENCIA, SOCIAL, ESPECIAL
	}

	public Logro(String id, String nombre, String descripcion, int puntosRecompensa, TipoLogro tipo) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.puntosRecompensa = puntosRecompensa;
		this.completado = false;
		this.tipo = tipo;
	}

	public void completarLogro() {
		if (!completado) {
			this.completado = true;
			System.out.println("¡Logro desbloqueado: " + this.nombre + "!");
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPuntosRecompensa() {
		return puntosRecompensa;
	}

	public void setPuntosRecompensa(int puntosRecompensa) {
		this.puntosRecompensa = puntosRecompensa;
	}

	public boolean isCompletado() {
		return completado;
	}

	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	public TipoLogro getTipo() {
		return tipo;
	}

	public void setTipo(TipoLogro tipo) {
		this.tipo = tipo;
	}
}
