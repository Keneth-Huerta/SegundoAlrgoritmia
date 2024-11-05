package gamificaciondeportiva;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Clase para gestionar desafíos
class Desafio {
	private String id;
	private String nombre;
	private String descripcion;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private int puntosRecompensa;
	private List<Usuario> participantes;
	private EstadoDesafio estado;

	public enum EstadoDesafio {
		PENDIENTE, ACTIVO, COMPLETADO, EXPIRADO
	}

	public Desafio(String id, String nombre, String descripcion, int puntosRecompensa, LocalDateTime fechaInicio,
			LocalDateTime fechaFin) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.puntosRecompensa = puntosRecompensa;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.participantes = new ArrayList<>();
		this.estado = EstadoDesafio.PENDIENTE;
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

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getPuntosRecompensa() {
		return puntosRecompensa;
	}

	public void setPuntosRecompensa(int puntosRecompensa) {
		this.puntosRecompensa = puntosRecompensa;
	}

	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}

	public EstadoDesafio getEstado() {
		return estado;
	}

	public void setEstado(EstadoDesafio estado) {
		this.estado = estado;
	}

	public void unirseAlDesafio(Usuario usuario) {
		if (!participantes.contains(usuario)) {
			participantes.add(usuario);
			System.out.println(usuario.getNombre() + " se ha unido al desafío: " + this.nombre);
		}
	}
}
