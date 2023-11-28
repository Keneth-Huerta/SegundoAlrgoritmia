public class Uso_Arrays_II {

	public static void main(String[] args) {


		int[] matriz_aleatorios=new int[10000];
		
		for (int i = 0; i < matriz_aleatorios.length; i++) {
			matriz_aleatorios[i]=(int)Math.round(Math.random()*100);
		}
		for (int i : matriz_aleatorios) {
			System.out.print(i+", ");
		}
	}

}
