import java.util.Random;

/**
 * @author reinan
 *
 */

public class Perceptron {
	public static void main(String[] args) throws InterruptedException {
		boolean VerificarPesoAdequado[] = { false, false, false, false, false };
		int padrao1[] = { /* bias */1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }; // 1
		int padrao2[] = { /* bias */1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1 }; // 1
		int padrao3[] = { /* bias */1, 1, 1, 0, 1, 0, 0, 0, 0, 1, -1 }; // -1
		int padrao4[] = { /* bias */1, 1, 1, 1, 0, 1, 0, 0, 0, 0, -1 }; // -1
		int padrao5[] = { /* bias */1, 0, 0, 1, 1, 1, 1, 1, 0, 1, -1 }; // -1
		int contadorInteracao = 0;
		int contadorAtualizacaoPeso = 0;
		double pesos[] = new double[10];
		for (int n = 0; n < 10; n++) {
			Random rand = new Random();
			Double randomPeso = -1 + rand.nextDouble(1 - (-1));
			randomPeso = Math.round(randomPeso * 10.0) / 10.0;
			pesos[n] = randomPeso;
		}
		int teste1[] = { /* bias */1, 
								   1, 1, 1, 
								   0, 1, 0, 
							       0, 1, 0, 
								   1 }; // 1
		double yTeste1 = 0;
		int teste2[] = { /* bias */1, 
								   1, 0, 1,
								   1, 1, 1,
								   1, 0, 1,
								   1 }; // 1
		double yTeste2 = 0;
		int teste3[] = { /* bias */1,
								   0, 0, 1,
								   1, 1, 1,
								   1, 0, 1,
								   -1 }; // -1
		double yTeste3 = 0;
		int teste4[] = { /* bias */1,
				   1, 1, 1,
				   0, 1, 0,
				   0, 0, 0,
				   -1 }; // -1
		double yTeste4 = 0;
		int teste5[] = { /* bias */1,
		   1, 1, 1,
		   1, 0, 1,
		   1, 1, 1,
		   -1 }; // -1
		double yTeste5 = 0;
		
		double yPadrao1 = 0;
		double yPadrao2 = 0;
		double yPadrao3 = 0;
		double yPadrao4 = 0;
		double yPadrao5 = 0;

		Perceptron p = new Perceptron();
		while (p.VerificarConvergencia(VerificarPesoAdequado)) {
			yPadrao1 = padrao1[0] * pesos[0] + padrao1[1] * pesos[1] + padrao1[2] * pesos[2] + padrao1[3] * pesos[3]
					 + padrao1[4] * pesos[4] + padrao1[5] * pesos[5] + padrao1[6] * pesos[6] + padrao1[7] * pesos[7]
					 + padrao1[8] * pesos[8] + padrao1[9] * pesos[9];

			yPadrao1 = Math.round(yPadrao1 * 10.0) / 10.0;
			yPadrao1 = (yPadrao1 <= 0 ? -1 : 1);
			System.out.println("\nCalculo do Y padrao 1");
			System.out.println( "("+padrao1[0]+"*"+pesos[0]+")+("+padrao1[1]+"*"+pesos[1]+")+("+padrao1[2]+"*"+pesos[2]+")+("+padrao1[3]+"*"+pesos[3]
				    +")+("+padrao1[4]+"*"+pesos[4]+")+("+padrao1[5]+"*"+pesos[5]+")+("+padrao1[6]+"*"+pesos[6]+")+("+padrao1[7]+"*"+pesos[7]
				    +")+("+padrao1[8]+"*"+pesos[8]+")+("+padrao1[9]+"*"+pesos[9]+")"+"="+yPadrao1);
			VerificarPesoAdequado[0] = true;
			if (yPadrao1 != padrao1[10]) {
				contadorAtualizacaoPeso++;
				pesos[0] = pesos[0] + 0.4 * padrao1[0] * (padrao1[10] - yPadrao1);
				pesos[1] = pesos[1] + 0.4 * padrao1[1] * (padrao1[10] - yPadrao1);
				pesos[2] = pesos[2] + 0.4 * padrao1[2] * (padrao1[10] - yPadrao1);
				pesos[3] = pesos[3] + 0.4 * padrao1[3] * (padrao1[10] - yPadrao1);
				pesos[4] = pesos[4] + 0.4 * padrao1[4] * (padrao1[10] - yPadrao1);
				pesos[5] = pesos[5] + 0.4 * padrao1[5] * (padrao1[10] - yPadrao1);
				pesos[6] = pesos[6] + 0.4 * padrao1[6] * (padrao1[10] - yPadrao1);
				pesos[7] = pesos[7] + 0.4 * padrao1[7] * (padrao1[10] - yPadrao1);
				pesos[8] = pesos[8] + 0.4 * padrao1[8] * (padrao1[10] - yPadrao1);
				pesos[9] = pesos[9] + 0.4 * padrao1[9] * (padrao1[10] - yPadrao1);
				VerificarPesoAdequado[0] = false;
				System.out.println("Atualizar pesos padrao 1");
				System.out.printf("%.1f * "+0.4+padrao1[0]+" * "+"("+padrao1[10]+" - ("+yPadrao1+"))",pesos[0]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao1[1]+" * "+"("+padrao1[10]+" - ("+yPadrao1+"))",pesos[1]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao1[2]+" * "+"("+padrao1[10]+" - ("+yPadrao1+"))",pesos[2]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao1[3]+" * "+"("+padrao1[10]+" - ("+yPadrao1+"))",pesos[3]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao1[4]+" * "+"("+padrao1[10]+" - ("+yPadrao1+"))",pesos[4]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao1[5]+" * "+"("+padrao1[10]+" - ("+yPadrao1+"))",pesos[5]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao1[6]+" * "+"("+padrao1[10]+" - ("+yPadrao1+"))",pesos[6]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao1[7]+" * "+"("+padrao1[10]+" - ("+yPadrao1+"))",pesos[7]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao1[8]+" * "+"("+padrao1[10]+" - ("+yPadrao1+"))",pesos[8]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao1[9]+" * "+"("+padrao1[10]+" - ("+yPadrao1+"))",pesos[9]);
				System.out.println("\n");
			}
			for (int n = 0; n < 10; n++) {
				pesos[n] = Math.round(pesos[n] * 10.0) / 10.0;;
			}

			// padrao2
			yPadrao2 = padrao2[0] * pesos[0] + padrao2[1] * pesos[1] + padrao2[2] * pesos[2] + padrao2[3] * pesos[3]
					 + padrao2[4] * pesos[4] + padrao2[5] * pesos[5] + padrao2[6] * pesos[6] + padrao2[7] * pesos[7]
					 + padrao2[8] * pesos[8] + padrao2[9] * pesos[9];

			yPadrao2 = Math.round(yPadrao2 * 10.0) / 10.0;
			yPadrao2 = (yPadrao2 <= 0 ? -1 : 1);
			System.out.println("\nCalculo do Y padrao 2");
			System.out.println( "("+padrao2[0]+"*"+pesos[0]+")+("+padrao2[1]+"*"+pesos[1]+")+("+padrao2[2]+"*"+pesos[2]+")+("+padrao2[3]+"*"+pesos[3]
		 		    +")+("+padrao2[4]+"*"+pesos[4]+")+("+padrao2[5]+"*"+pesos[5]+")+("+padrao2[6]+"*"+pesos[6]+")+("+padrao2[7]+"*"+pesos[7]
		 		    +")+("+padrao2[8]+"*"+pesos[8]+")+("+padrao2[9]+"*"+pesos[9]+")"+"="+yPadrao2);
			VerificarPesoAdequado[1] = true;
			if (yPadrao2 != padrao2[10]) {
				contadorAtualizacaoPeso++;
				pesos[0] = pesos[0] + 0.4 * padrao2[0] * (padrao2[10] - yPadrao2);
				pesos[1] = pesos[1] + 0.4 * padrao2[1] * (padrao2[10] - yPadrao2);
				pesos[2] = pesos[2] + 0.4 * padrao2[2] * (padrao2[10] - yPadrao2);
				pesos[3] = pesos[3] + 0.4 * padrao2[3] * (padrao2[10] - yPadrao2);
				pesos[4] = pesos[4] + 0.4 * padrao2[4] * (padrao2[10] - yPadrao2);
				pesos[5] = pesos[5] + 0.4 * padrao2[5] * (padrao2[10] - yPadrao2);
				pesos[6] = pesos[6] + 0.4 * padrao2[6] * (padrao2[10] - yPadrao2);
				pesos[7] = pesos[7] + 0.4 * padrao2[7] * (padrao2[10] - yPadrao2);
				pesos[8] = pesos[8] + 0.4 * padrao2[8] * (padrao2[10] - yPadrao2);
				pesos[9] = pesos[9] + 0.4 * padrao2[9] * (padrao2[10] - yPadrao2);
				VerificarPesoAdequado[1] = false;
				System.out.println("Atualizar pesos padrao 2");
				System.out.printf("%.1f * "+0.4+padrao2[0]+" * "+"("+padrao2[10]+" - ("+yPadrao2+"))",pesos[0]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao2[1]+" * "+"("+padrao2[10]+" - ("+yPadrao2+"))",pesos[1]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao2[2]+" * "+"("+padrao2[10]+" - ("+yPadrao2+"))",pesos[2]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao2[3]+" * "+"("+padrao2[10]+" - ("+yPadrao2+"))",pesos[3]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao2[4]+" * "+"("+padrao2[10]+" - ("+yPadrao2+"))",pesos[4]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao2[5]+" * "+"("+padrao2[10]+" - ("+yPadrao2+"))",pesos[5]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao2[6]+" * "+"("+padrao2[10]+" - ("+yPadrao2+"))",pesos[6]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao2[7]+" * "+"("+padrao2[10]+" - ("+yPadrao2+"))",pesos[7]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao2[8]+" * "+"("+padrao2[10]+" - ("+yPadrao2+"))",pesos[8]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao2[9]+" * "+"("+padrao2[10]+" - ("+yPadrao2+"))",pesos[9]);
				System.out.println("\n");
			}

			for (int n = 0; n < 10; n++) {
				pesos[n] = Math.round(pesos[n] * 10.0) / 10.0;;
			}

			// padrao3
			yPadrao3 = padrao3[0] * pesos[0] + padrao3[1] * pesos[1] + padrao3[2] * pesos[2] + padrao3[3] * pesos[3]
					 + padrao3[4] * pesos[4] + padrao3[5] * pesos[5] + padrao3[6] * pesos[6] + padrao3[7] * pesos[7]
					 + padrao3[8] * pesos[8] + padrao3[9] * pesos[9];

			yPadrao3 = Math.round(yPadrao3 * 10.0) / 10.0;
			yPadrao3 = (yPadrao3 <= 0 ? -1 : 1);
			System.out.println("\nCalculo do Y padrao 3");
			System.out.println( "("+padrao3[0]+"*"+pesos[0]+")+("+padrao3[1]+"*"+pesos[1]+")+("+padrao3[2]+"*"+pesos[2]+")+("+padrao3[3]+"*"+pesos[3]
		    		    +")+("+padrao3[4]+"*"+pesos[4]+")+("+padrao3[5]+"*"+pesos[5]+")+("+padrao3[6]+"*"+pesos[6]+")+("+padrao3[7]+"*"+pesos[7]
		    		    +")+("+padrao3[8]+"*"+pesos[8]+")+("+padrao3[9]+"*"+pesos[9]+")"+"="+yPadrao3);
			VerificarPesoAdequado[2] = true;
			if (yPadrao3 != padrao3[10]) {
				contadorAtualizacaoPeso++;
				pesos[0] = pesos[0] + 0.4 * padrao3[0] * (padrao3[10] - yPadrao3);
				pesos[1] = pesos[1] + 0.4 * padrao3[1] * (padrao3[10] - yPadrao3);
				pesos[2] = pesos[2] + 0.4 * padrao3[2] * (padrao3[10] - yPadrao3);
				pesos[3] = pesos[3] + 0.4 * padrao3[3] * (padrao3[10] - yPadrao3);
				pesos[4] = pesos[4] + 0.4 * padrao3[4] * (padrao3[10] - yPadrao3);
				pesos[5] = pesos[5] + 0.4 * padrao3[5] * (padrao3[10] - yPadrao3);
				pesos[6] = pesos[6] + 0.4 * padrao3[6] * (padrao3[10] - yPadrao3);
				pesos[7] = pesos[7] + 0.4 * padrao3[7] * (padrao3[10] - yPadrao3);
				pesos[8] = pesos[8] + 0.4 * padrao3[8] * (padrao3[10] - yPadrao3);
				pesos[9] = pesos[9] + 0.4 * padrao3[9] * (padrao3[10] - yPadrao3);
				VerificarPesoAdequado[2] = false;
				System.out.println("Atualizar pesos padrao 3");
				System.out.printf("%.1f * "+0.4+padrao3[0]+" * "+"("+padrao3[10]+" - ("+yPadrao3+"))",pesos[0]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao3[1]+" * "+"("+padrao3[10]+" - ("+yPadrao3+"))",pesos[1]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao3[2]+" * "+"("+padrao3[10]+" - ("+yPadrao3+"))",pesos[2]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao3[3]+" * "+"("+padrao3[10]+" - ("+yPadrao3+"))",pesos[3]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao3[4]+" * "+"("+padrao3[10]+" - ("+yPadrao3+"))",pesos[4]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao3[5]+" * "+"("+padrao3[10]+" - ("+yPadrao3+"))",pesos[5]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao3[6]+" * "+"("+padrao3[10]+" - ("+yPadrao3+"))",pesos[6]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao3[7]+" * "+"("+padrao3[10]+" - ("+yPadrao3+"))",pesos[7]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao3[8]+" * "+"("+padrao3[10]+" - ("+yPadrao3+"))",pesos[8]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao3[9]+" * "+"("+padrao3[10]+" - ("+yPadrao3+"))",pesos[9]);
				System.out.println("\n");
			}

			for (int n = 0; n < 10; n++) {
				pesos[n] = Math.round(pesos[n] * 10.0) / 10.0;;
			}
			// padrao4
			yPadrao4 = padrao4[0] * pesos[0] + padrao4[1] * pesos[1] + padrao4[2] * pesos[2] + padrao4[3] * pesos[3]
					 + padrao4[4] * pesos[4] + padrao4[5] * pesos[5] + padrao4[6] * pesos[6] + padrao4[7] * pesos[7]
					 + padrao4[8] * pesos[8] + padrao4[9] * pesos[9];

			yPadrao4 = Math.round(yPadrao4 * 10.0) / 10.0;
			yPadrao4 = (yPadrao4 <= 0 ? -1 : 1);
			System.out.println("\nCalculo do Y padrao 4");
			System.out.println( "("+padrao4[0]+"*"+pesos[0]+")+("+padrao4[1]+"*"+pesos[1]+")+("+padrao4[2]+"*"+pesos[2]+")+("+padrao4[3]+"*"+pesos[3]
				    +")+("+padrao4[4]+"*"+pesos[4]+")+("+padrao4[5]+"*"+pesos[5]+")+("+padrao4[6]+"*"+pesos[6]+")+("+padrao4[7]+"*"+pesos[7]
				    +")+("+padrao4[8]+"*"+pesos[8]+")+("+padrao4[9]+"*"+pesos[9]+")"+"="+yPadrao4);
			VerificarPesoAdequado[3] = true;
			if (yPadrao4 != padrao4[10]) {
				contadorAtualizacaoPeso++;
				pesos[0] = pesos[0] + 0.4 * padrao4[0] * (padrao4[10] - yPadrao4);
				pesos[1] = pesos[1] + 0.4 * padrao4[1] * (padrao4[10] - yPadrao4);
				pesos[2] = pesos[2] + 0.4 * padrao4[2] * (padrao4[10] - yPadrao4);
				pesos[3] = pesos[3] + 0.4 * padrao4[3] * (padrao4[10] - yPadrao4);
				pesos[4] = pesos[4] + 0.4 * padrao4[4] * (padrao4[10] - yPadrao4);
				pesos[5] = pesos[5] + 0.4 * padrao4[5] * (padrao4[10] - yPadrao4);
				pesos[6] = pesos[6] + 0.4 * padrao4[6] * (padrao4[10] - yPadrao4);
				pesos[7] = pesos[7] + 0.4 * padrao4[7] * (padrao4[10] - yPadrao4);
				pesos[8] = pesos[8] + 0.4 * padrao4[8] * (padrao4[10] - yPadrao4);
				pesos[9] = pesos[9] + 0.4 * padrao4[9] * (padrao4[10] - yPadrao4);
				VerificarPesoAdequado[3] = false;
				System.out.println("Atualizar pesos padrao 4");
				System.out.printf("%.1f * "+0.4+padrao4[0]+" * "+"("+padrao4[10]+" - ("+yPadrao4+"))",pesos[0]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao4[1]+" * "+"("+padrao4[10]+" - ("+yPadrao4+"))",pesos[1]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao4[2]+" * "+"("+padrao4[10]+" - ("+yPadrao4+"))",pesos[2]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao4[3]+" * "+"("+padrao4[10]+" - ("+yPadrao4+"))",pesos[3]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao4[4]+" * "+"("+padrao4[10]+" - ("+yPadrao4+"))",pesos[4]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao4[5]+" * "+"("+padrao4[10]+" - ("+yPadrao4+"))",pesos[5]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao4[6]+" * "+"("+padrao4[10]+" - ("+yPadrao4+"))",pesos[6]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao4[7]+" * "+"("+padrao4[10]+" - ("+yPadrao4+"))",pesos[7]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao4[8]+" * "+"("+padrao4[10]+" - ("+yPadrao4+"))",pesos[8]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao4[9]+" * "+"("+padrao4[10]+" - ("+yPadrao4+"))",pesos[9]);
				System.out.println("\n");
			}

			for (int n = 0; n < 10; n++) {
				pesos[n] = Math.round(pesos[n] * 10.0) / 10.0;;
			}
			// padrao5
			yPadrao5 = padrao5[0] * pesos[0] + padrao5[1] * pesos[1] + padrao5[2] * pesos[2] + padrao5[3] * pesos[3]
					+ padrao5[4] * pesos[4] + padrao5[5] * pesos[5] + padrao5[6] * pesos[6] + padrao5[7] * pesos[7]
					+ padrao5[8] * pesos[8] + padrao5[9] * pesos[9];

			yPadrao5 = Math.round(yPadrao5 * 10.0) / 10.0;
			yPadrao5 = (yPadrao5 <= 0 ? -1 : 1);
			System.out.println("\nCalculo do Y padrao 5");
			System.out.println( "("+padrao5[0]+"*"+pesos[0]+")+("+padrao5[1]+"*"+pesos[1]+")+("+padrao5[2]+"*"+pesos[2]+")+("+padrao5[3]+"*"+pesos[3]
		    			+")+("+padrao5[4]+"*"+pesos[4]+")+("+padrao5[5]+"*"+pesos[5]+")+("+padrao5[6]+"*"+pesos[6]+")+("+padrao5[7]+"*"+pesos[7]
		    			+")+("+padrao5[8]+"*"+pesos[8]+")+("+padrao5[9]+"*"+pesos[9]+")"+"="+yPadrao5);
			VerificarPesoAdequado[4] = true;
			if (yPadrao5 != padrao5[10]) {
				contadorAtualizacaoPeso++;
				pesos[0] = pesos[0] + 0.4 * padrao5[0] * (padrao5[10] - yPadrao5);
				pesos[1] = pesos[1] + 0.4 * padrao5[1] * (padrao5[10] - yPadrao5);
				pesos[2] = pesos[2] + 0.4 * padrao5[2] * (padrao5[10] - yPadrao5);
				pesos[3] = pesos[3] + 0.4 * padrao5[3] * (padrao5[10] - yPadrao5);
				pesos[4] = pesos[4] + 0.4 * padrao5[4] * (padrao5[10] - yPadrao5);
				pesos[5] = pesos[5] + 0.4 * padrao5[5] * (padrao5[10] - yPadrao5);
				pesos[6] = pesos[6] + 0.4 * padrao5[6] * (padrao5[10] - yPadrao5);
				pesos[7] = pesos[7] + 0.4 * padrao5[7] * (padrao5[10] - yPadrao5);
				pesos[8] = pesos[8] + 0.4 * padrao5[8] * (padrao5[10] - yPadrao5);
				pesos[9] = pesos[9] + 0.4 * padrao5[9] * (padrao5[10] - yPadrao5);
				VerificarPesoAdequado[4] = false;
				System.out.println("Atualizar pesos padrao 1");
				System.out.printf("%.1f * "+0.4+padrao5[0]+" * "+"("+padrao5[10]+" - ("+yPadrao5+"))",pesos[0]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao5[1]+" * "+"("+padrao5[10]+" - ("+yPadrao5+"))",pesos[1]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao5[2]+" * "+"("+padrao5[10]+" - ("+yPadrao5+"))",pesos[2]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao5[3]+" * "+"("+padrao5[10]+" - ("+yPadrao5+"))",pesos[3]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao5[4]+" * "+"("+padrao5[10]+" - ("+yPadrao5+"))",pesos[4]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao5[5]+" * "+"("+padrao5[10]+" - ("+yPadrao5+"))",pesos[5]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao5[6]+" * "+"("+padrao5[10]+" - ("+yPadrao5+"))",pesos[6]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao5[7]+" * "+"("+padrao5[10]+" - ("+yPadrao5+"))",pesos[7]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao5[8]+" * "+"("+padrao5[10]+" - ("+yPadrao5+"))",pesos[8]);
				System.out.println();
				System.out.printf("%.1f * "+0.4+padrao5[9]+" * "+"("+padrao5[10]+" - ("+yPadrao5+"))",pesos[9]);
				System.out.println("\n");
			}

			for (int n = 0; n < 10; n++) {
				pesos[n] = Math.round(pesos[n] * 10.0) / 10.0;;
			}
			contadorInteracao++;
		}
		yTeste1 = teste1[0] * pesos[0] + teste1[1] * pesos[1] + teste1[2] * pesos[2] + teste1[3] * pesos[3]
				+ teste1[4] * pesos[4] + teste1[5] * pesos[5] + teste1[6] * pesos[6] + teste1[7] * pesos[7]
				+ teste1[8] * pesos[8] + teste1[9] * pesos[9];
		yTeste1 = (yTeste1 <= 0 ? -1 : 1);
		System.out.println("\n\nTeste da rede com caractere T : " + yTeste1);
		yTeste2 = teste2[0] * pesos[0] + teste2[1] * pesos[1] + teste2[2] * pesos[2] + teste2[3] * pesos[3]
				+ teste2[4] * pesos[4] + teste2[5] * pesos[5] + teste2[6] * pesos[6] + teste2[7] * pesos[7]
				+ teste2[8] * pesos[8] + teste2[9] * pesos[9];
		yTeste2 = (yTeste2 <= 0 ? -1 : 1);
		System.out.println("Teste da rede com caractere H : " + yTeste2);
		yTeste3 = teste3[0] * pesos[0] + teste3[1] * pesos[1] + teste3[2] * pesos[2] + teste3[3] * pesos[3]
				+ teste3[4] * pesos[4] + teste3[5] * pesos[5] + teste3[6] * pesos[6] + teste3[7] * pesos[7]
				+ teste3[8] * pesos[8] + teste3[9] * pesos[9];
		yTeste3 = (yTeste3 <= 0 ? -1 : 1);
		System.out.println("Teste da rede com caractere INVALIDO : " + yTeste3);
		yTeste4 = teste4[0] * pesos[0] + teste4[1] * pesos[1] + teste4[2] * pesos[2] + teste4[3] * pesos[3]
				+ teste4[4] * pesos[4] + teste4[5] * pesos[5] + teste4[6] * pesos[6] + teste4[7] * pesos[7]
				+ teste4[8] * pesos[8] + teste4[9] * pesos[9];
		yTeste4 = (yTeste4 <= 0 ? -1 : 1);
		System.out.println("Teste da rede com caractere INVALIDO : " + yTeste3);
		yTeste5 = teste5[0] * pesos[0] + teste5[1] * pesos[1] + teste5[2] * pesos[2] + teste5[3] * pesos[3]
				+ teste5[4] * pesos[4] + teste5[5] * pesos[5] + teste5[6] * pesos[6] + teste5[7] * pesos[7]
				+ teste5[8] * pesos[8] + teste5[9] * pesos[9];
		yTeste5 = (yTeste5 <= 0 ? -1 : 1);
		System.out.println("Teste da rede com caractere INVALIDO : " + yTeste3 + "\n\n");
		
		System.out.println("Numero de interacoes para aprendizado : " + contadorInteracao);
		System.out.println("Atualizacoes de pesos : " + contadorAtualizacaoPeso);
	}

	boolean VerificarConvergencia(boolean VerificarPesoAdequado[]) {
		for (int i = 0; i < 5; i++)
			if (VerificarPesoAdequado[i] == false)
				return true;
		return false;
	}
}
