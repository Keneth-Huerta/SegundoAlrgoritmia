import java.util.Comparator;
import java.util.TreeSet;

public class PruebaTreeSet {

	public static void main(String[] args) {

//		TreeSet<String> ordenaPersonas = new TreeSet<String>();
//		ordenaPersonas.add("Sandra");
//		ordenaPersonas.add("Amanda");
//		ordenaPersonas.add("Diana");
//		for (String string : ordenaPersonas) {
//
//			System.out.println(string);
//		}
		Articulo primero = new Articulo(1, "Primer Articulo");
		Articulo segundo = new Articulo(2, "Segundo Articulo");
		Articulo tercero = new Articulo(3, "Este es el tercer articulo");
		TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
		ordenaArticulos.add(tercero);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(segundo);
		for (Articulo articulo : ordenaArticulos) {

			System.out.println(articulo.getDescripcion());
		}
		System.out.println();
//		Articulo comparadorArticulo = new Articulo();
//		TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorArticulo);
//		ComparadorArticulos comparaArt = new ComparadorArticulos();
		TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(new Comparator<Articulo>() {

			@Override
			public int compare(Articulo o1, Articulo o2) {

				String desc1 = o1.getDescripcion();
				String desc2 = o2.getDescripcion();
				return desc1.compareTo(desc2);
			}
		});
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(tercero);
		for (Articulo articulo : ordenaArticulos2) {

			System.out.println(articulo.getDescripcion());
		}
	}
}

class Articulo implements Comparable<Articulo> {
	private int numeroArticulo;
	private String descripcion;

	public Articulo(int num, String desc) {

		numeroArticulo = num;
		descripcion = desc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int compareTo(Articulo o) {
		return numeroArticulo - o.numeroArticulo;
	}

	public int compare(Articulo o1, Articulo o2) {
		String descripcionA = o1.getDescripcion();
		String descripcionB = o2.getDescripcion();
		return descripcionA.compareTo(descripcionB);
	}

}

//class ComparadorArticulos implements Comparator<Articulo> {
//
//	public int compare(Articulo o1, Articulo o2) {
//
//		String desc1 = o1.getDescripcion();
//		String desc2 = o2.getDescripcion();
//		return desc1.compareTo(desc2);
//	}
//
//}