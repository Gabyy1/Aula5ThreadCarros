package view;

import java.util.concurrent.Semaphore;

import controller.Carros;

public class Principal {
	


	public static void main(String[] args) {
		String[] sentido = { "Frente", "Esquerda", "Direita", "Frente"};
		Semaphore semaforo = new Semaphore(1);
		
		
		for (int car = 1; car <= 4; car++) {
			Thread Carros = new Carros (semaforo, sentido[car - 1]);
			Carros.start();
		}

	}

}
