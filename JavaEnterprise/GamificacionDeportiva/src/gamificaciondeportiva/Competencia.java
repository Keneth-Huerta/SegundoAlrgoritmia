package gamificaciondeportiva;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gamificaciondeportiva.ActividadDeportiva.TipoDeporte;

//Sistema de gestión de competencias
public class Competencia {
	private String id;
	private String nombre;
	private TipoDeporte tipoDeporte;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private Map<Usuario, Integer> participantesYPuntos;
	private EstadoCompetencia estado;

	public enum EstadoCompetencia {
		REGISTRO, EN_PROGRESO, FINALIZADA
	}

	public Competencia(String id, String nombre, TipoDeporte tipoDeporte, LocalDateTime fechaInicio,
			LocalDateTime fechaFin) {
		this.id = id;
		this.nombre = nombre;
		this.tipoDeporte = tipoDeporte;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.participantesYPuntos = new HashMap<>();
		this.estado = EstadoCompetencia.REGISTRO;
	}

	public void registrarParticipante(Usuario usuario) {
		if (estado == EstadoCompetencia.REGISTRO) {
			participantesYPuntos.put(usuario, 0);
			System.out.println(usuario.getNombre() + " registrado en la competencia: " + this.nombre);
		}
	}

	public void actualizarPuntuacion(Usuario usuario, int puntos) {
		if (estado == EstadoCompetencia.EN_PROGRESO) {
			participantesYPuntos.put(usuario, participantesYPuntos.getOrDefault(usuario, 0) + puntos);
		}
	}

	public void finalizarCompetencia() {
		if (estado == EstadoCompetencia.EN_PROGRESO) {
			estado = EstadoCompetencia.FINALIZADA;
			anunciarGanadores();
		}
	}

	private void anunciarGanadores() {
		// Ordenar participantes por puntos
		List<Map.Entry<Usuario, Integer>> ranking = new ArrayList<>(participantesYPuntos.entrySet());
		ranking.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

		System.out.println("¡Resultados de la competencia " + this.nombre + "!");
		for (int i = 0; i < Math.min(3, ranking.size()); i++) {
			Map.Entry<Usuario, Integer> entrada = ranking.get(i);
			System.out.println(
					(i + 1) + "° lugar: " + entrada.getKey().getNombre() + " con " + entrada.getValue() + " puntos");
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

	public TipoDeporte getTipoDeporte() {
		return tipoDeporte;
	}

	public void setTipoDeporte(TipoDeporte tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
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

	public Map<Usuario, Integer> getParticipantesYPuntos() {
		return participantesYPuntos;
	}

	public void setParticipantesYPuntos(Map<Usuario, Integer> participantesYPuntos) {
		this.participantesYPuntos = participantesYPuntos;
	}

	public EstadoCompetencia getEstado() {
		return estado;
	}

	public void setEstado(EstadoCompetencia estado) {
		this.estado = estado;
	}

}