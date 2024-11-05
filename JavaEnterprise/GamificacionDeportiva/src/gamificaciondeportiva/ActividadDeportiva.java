package gamificaciondeportiva;

import java.time.LocalDateTime;

//Clase para gestionar actividades deportivas
class ActividadDeportiva {
	private String id;
	private TipoDeporte tipo;
	private LocalDateTime fecha;
	private int duracionMinutos;
	private double distanciaKm;
	private int caloriasQuemadas;
	private Usuario usuario;

	public enum TipoDeporte {
		CORRER, NATACION, CICLISMO, FUTBOL, BALONCESTO, VOLLEYBALL, GIMNASIO
	}

	public ActividadDeportiva(String id, TipoDeporte tipo, int duracionMinutos, double distanciaKm, Usuario usuario) {
		this.id = id;
		this.tipo = tipo;
		this.fecha = LocalDateTime.now();
		this.duracionMinutos = duracionMinutos;
		this.distanciaKm = distanciaKm;
		this.usuario = usuario;
		calcularCalorias();
	}

	private void calcularCalorias() {
		// Cálculo simplificado de calorías basado en el tipo de deporte y duración
		switch (this.tipo) {
		case CORRER:
			this.caloriasQuemadas = (int) (duracionMinutos * 10);
			break;
		case NATACION:
			this.caloriasQuemadas = (int) (duracionMinutos * 12);
			break;
		case CICLISMO:
			this.caloriasQuemadas = (int) (duracionMinutos * 8);
			break;
		default:
			this.caloriasQuemadas = (int) (duracionMinutos * 6);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TipoDeporte getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeporte tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}

	public double getDistanciaKm() {
		return distanciaKm;
	}

	public void setDistanciaKm(double distanciaKm) {
		this.distanciaKm = distanciaKm;
	}

	public int getCaloriasQuemadas() {
		return caloriasQuemadas;
	}

	public void setCaloriasQuemadas(int caloriasQuemadas) {
		this.caloriasQuemadas = caloriasQuemadas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}