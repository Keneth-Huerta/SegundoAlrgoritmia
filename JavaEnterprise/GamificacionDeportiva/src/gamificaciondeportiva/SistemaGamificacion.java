package gamificaciondeportiva;

import java.util.ArrayList;
import java.util.List;

//Gestor principal del sistema de gamificación
class SistemaGamificacion {
	private List<Usuario> usuarios;
	private List<Logro> logrosDisponibles;
	private List<Desafio> desafiosActivos;
	private List<Competencia> competencias;

	public SistemaGamificacion() {
		this.usuarios = new ArrayList<>();
		this.logrosDisponibles = new ArrayList<>();
		this.desafiosActivos = new ArrayList<>();
		this.competencias = new ArrayList<>();
		inicializarLogros();
	}

	private void inicializarLogros() {
		// Agregar logros predefinidos
		logrosDisponibles.add(new Logro("L001", "Primer Kilómetro", "Completa tu primera actividad de 1 km", 100,
				Logro.TipoLogro.DISTANCIA));
		logrosDisponibles.add(new Logro("L002", "Madrugador", "Completa 5 actividades antes de las 8 AM", 200,
				Logro.TipoLogro.FRECUENCIA));
		logrosDisponibles.add(new Logro("L003", "Deportista Social", "Participa en 3 competencias diferentes", 300,
				Logro.TipoLogro.SOCIAL));
	}

	public void registrarActividad(ActividadDeportiva actividad) {
		// Procesar la actividad y actualizar logros, desafíos y competencias
		Usuario usuario = actividad.getUsuario();
		verificarLogros(usuario, actividad);
		actualizarDesafios(usuario, actividad);
		actualizarCompetencias(usuario, actividad);
	}

	private void verificarLogros(Usuario usuario, ActividadDeportiva actividad) {
		for (Logro logro : logrosDisponibles) {
			// Implementar lógica de verificación de logros según el tipo
			// y las condiciones específicas de cada logro
		}
	}

	private void actualizarDesafios(Usuario usuario, ActividadDeportiva actividad) {
		for (Desafio desafio : desafiosActivos) {
			// Actualizar progreso en desafíos activos
		}
	}

	private void actualizarCompetencias(Usuario usuario, ActividadDeportiva actividad) {
		for (Competencia competencia : competencias) {
			// Actualizar puntuación en competencias activas
		}
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Logro> getLogrosDisponibles() {
		return logrosDisponibles;
	}

	public void setLogrosDisponibles(List<Logro> logrosDisponibles) {
		this.logrosDisponibles = logrosDisponibles;
	}

	public List<Desafio> getDesafiosActivos() {
		return desafiosActivos;
	}

	public void setDesafiosActivos(List<Desafio> desafiosActivos) {
		this.desafiosActivos = desafiosActivos;
	}

	public List<Competencia> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<Competencia> competencias) {
		this.competencias = competencias;
	}


}