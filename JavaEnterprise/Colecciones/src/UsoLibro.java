
public class UsoLibro {

	public static void main(String[] args) {

		Libro libro1 = new Libro("p en Java", "Juan", 25);
		Libro libro2 = new Libro("p en Java", "Juan", 25);
//		libro1= libro2;
		if (libro1.equals(libro2)) {
			System.out.println(true);
		}else {
			
			System.out.println(false);
		}
		if (libro1.hashCode() == libro2.hashCode()) {
			
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
			System.out.println(true);
		} else {
			
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
			System.out.println(false);
		}
	}

}
