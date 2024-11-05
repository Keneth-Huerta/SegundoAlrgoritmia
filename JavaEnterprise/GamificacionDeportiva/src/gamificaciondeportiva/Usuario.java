package gamificaciondeportiva;

import java.util.ArrayList;
import java.util.List;

//Clase principal para gestionar usuarios
class Usuario {
	private String id;
	private String nombre;
	private int nivel;
	private int puntosTotales;
	private int experiencia;

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

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getPuntosTotales() {
		return puntosTotales;
	}

	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public List<Logro> getLogrosObtenidos() {
		return logrosObtenidos;
	}

	public void setLogrosObtenidos(List<Logro> logrosObtenidos) {
		this.logrosObtenidos = logrosObtenidos;
	}

	public List<Desafio> getDesafiosActivos() {
		return desafiosActivos;
	}

	public void setDesafiosActivos(List<Desafio> desafiosActivos) {
		this.desafiosActivos = desafiosActivos;
	}

	private List<Logro> logrosObtenidos;
	private List<Desafio> desafiosActivos;

	public Usuario(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.nivel = 1;
		this.puntosTotales = 0;
		this.experiencia = 0;
		this.logrosObtenidos = new ArrayList<>();
		this.desafiosActivos = new ArrayList<>();
	}

	public void ganarPuntos(int puntos) {
		this.puntosTotales += puntos;
		ganarExperiencia(puntos);
	}

	public void ganarExperiencia(int exp) {
		this.experiencia += exp;
		verificarNivel();
	}

	private void verificarNivel() {
		// Cada 1000 puntos de experiencia sube un nivel
		int nuevoNivel = (this.experiencia / 1000) + 1;
		if (nuevoNivel > this.nivel) {
			this.nivel = nuevoNivel;
			System.out.println("¡Felicidades! Has alcanzado el nivel " + this.nivel);
		}
	}
}
