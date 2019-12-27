package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entites.Reserva;
import excessao.DominioExcessao;

public class Program {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	try {
	System.out.print("Numero do quarto: ");
	Integer numeroQuarto = sc.nextInt();
	
	System.out.print("Entrada (DD/MM/YYYY)");
	Date entrada = sdf.parse(sc.next());
	System.out.print("Saida (DD/MM/YYYY)");
	Date saida = sdf.parse(sc.next());
	
	Reserva r = new Reserva(numeroQuarto, entrada, saida);
	System.out.println(r);
	
	
	System.out.println();
	System.out.println("Entre com os dados para atualizar: ");
	
	System.out.print("Entrada (DD/MM/YYYY)");
	entrada = sdf.parse(sc.next());
	System.out.print("Saida (DD/MM/YYYY)");
	saida = sdf.parse(sc.next());
	
	
	
	
	r.atualizar(entrada, saida);
		System.out.println(r);
	}catch(ParseException e) {
		System.out.println("Formato de data invalido");
	}catch(DominioExcessao e) {
		System.out.println(e.getMessage());
	}catch(RuntimeException e) {
		System.out.println("Erro inesperado!");
	}
	finally {
		sc.close();
	}
	
	

	sc.close();
}

}
