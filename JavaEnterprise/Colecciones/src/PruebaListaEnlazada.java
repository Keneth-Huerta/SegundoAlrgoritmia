import java.util.LinkedList;
import java.util.ListIterator;

public class PruebaListaEnlazada {

	public static void main(String[] args) {

		LinkedList<String> paises = new LinkedList<String>();

		paises.add("España");
		paises.add("Colombia");
		paises.add("México");
		paises.add("Perú");

		LinkedList<String> capitales = new LinkedList<String>();

		capitales.add("Madrid");
		capitales.add("Bogotá");
		capitales.add("Ciudad de México");
		capitales.add("Lima");

//		System.out.println(paises + "\n");
//		System.out.println(capitales);

		ListIterator<String> it1 = paises.listIterator();
		ListIterator<String> it2 = capitales.listIterator();

		while (it2.hasNext()) {

			if (it1.hasNext()) {

				it1.next();
			}
			it1.add(it2.next());
		}
		System.out.println(paises);
		it2 = capitales.listIterator();
		while (it2.hasNext()) {
			
			it2.next();
			if (it2.hasNext()) {
				
				it2.next();
				it2.remove();
			}
		}
		System.out.println(capitales);
		paises.removeAll(capitales);
		System.out.println(paises);
	}

}
