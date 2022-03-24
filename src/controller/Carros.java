package controller;

import java.util.concurrent.Semaphore;

public class Carros extends Thread {
	private int car;
	private Semaphore semaforo;
	public String sentido;
	
	public Carros (Semaphore semaforo, String sentido) {
		this.car = (int)this.getId();
		this.semaforo = semaforo;
		this.sentido = sentido;
}
	
	public void run () {
		esperaCarro();
		
		try {
			
			passandoCarro ();
			semaforo.acquire();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
	} cruzaCarro();
}
	
	public void passandoCarro() {
		int t = 0;
		
		t = (int) ((Math.random()*3000)+1000);
		
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace ();
		}
		
		System.out.println("O carro " + car + " esta passando pelo cruzamento.");
	}
	public void esperaCarro() {
	  System.out.println("O carro " + car + " parou no cruzamento.");
	}
	
	public void cruzaCarro () {
		System.out.println("O carro " + car + " cruzou para " + sentido + ".");
		
	}
	}
