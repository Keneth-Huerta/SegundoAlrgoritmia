package usothreads;

//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;

public class BancoSincronizar {

	public static void main(String[] args) {

		Banco banco = new Banco();
		for (int i = 0; i < 100; i++) {

			EjecucionTransferencias r = new EjecucionTransferencias(banco, i, 2000);
			Thread t = new Thread(r);
			t.start();
		}
	}

}

class Banco {
	private final double[] cuentas;
//	private Lock cierraBanco = new ReentrantLock();
//	private Condition saldoSuficiente;

	public Banco() {

		cuentas = new double[100];
		for (int i = 0; i < cuentas.length; i++) {

			cuentas[i] = 2000;
		}
//		saldoSuficiente = cierraBanco.newCondition();
	}

	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad)
			throws InterruptedException {

//		cierraBanco.lock();
//		try {
//			if (cuentas[cuentaOrigen] < cantidad) {// evalua que el saldo no es inferior

//				System.out.println("-----------CANTIDAD INSUFICIENTE: " + cuentaOrigen + ".......SALDO: "
//						+ cuentas[cuentaOrigen] + "....." + cantidad);
//				return;
//			}
//			else {
//				System.out.println("----------------CANTIDAD OK----------" + cuentaOrigen);
//			}
		while (cuentas[cuentaOrigen] < cantidad) {

//				saldoSuficiente.await();
			wait();
		}
		System.out.println(Thread.currentThread());
		cuentas[cuentaOrigen] -= cantidad; // dinero que sale de la cuenta origen
		System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
		cuentas[cuentaDestino] += cantidad;
		System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());
//		saldoSuficiente.signalAll();
//		} finally {
//			cierraBanco.unlock();
//		}
		notifyAll();
	}

	public double getSaldoTotal() {
		double sumaCuentas = 0;
		for (double a : cuentas) {

			sumaCuentas += a;
		}
		return sumaCuentas;
	}
}

class EjecucionTransferencias implements Runnable {
	private Banco banco;
	private int deLaCuenta;
	private double cantidadMax;

	public EjecucionTransferencias(Banco b, int de, double max) {

		banco = b;
		deLaCuenta = de;
		cantidadMax = max;
	}

	public void run() {

		while (true) {

			int paraLaCuenta = (int) (100 * Math.random());
			double cantidad = cantidadMax * Math.random();
			try {

				banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
				Thread.sleep((int) (Math.random() * 10));
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}