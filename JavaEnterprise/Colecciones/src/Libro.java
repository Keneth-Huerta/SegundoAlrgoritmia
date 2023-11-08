import java.util.Objects;

public class Libro {
	private String titulo;
	private String autor;
	private int ISBN;

	public Libro(String titulo, String autor, int ISBN) {

		this.autor = autor;
		this.titulo = titulo;
		this.ISBN = ISBN;
	}

//	public int hashCode() {
//		return Objects.hash(ISBN);
//	}

//	public boolean equals(Object obj) {
//
//		if (obj instanceof Libro) {
//
//			Libro otro = (Libro) obj;
//			if (this.ISBN == otro.ISBN) {
//
//				return true;
//			} else {
//				return false;
//			}
//		} else {
//			return false;
//		}
//	}

	public String getDatos() {

		return "El título es: " + titulo + ". El autor es:" + autor + ". Y el ISBN es: " + ISBN;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return ISBN == other.ISBN;
	}
}
