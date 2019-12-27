package exemplotrycatchReserva.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entites.Reserva;

public class Program {
public static void main(String[] args) throws ParseException  {
	
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	System.out.print("Numero do quarto: ");
	Integer numeroQuarto = sc.nextInt();
	
	System.out.print("Entrada (DD/MM/YYYY)");
	Date entrada = sdf.parse(sc.next());
	
	System.out.print("Saida (DD/MM/YYYY)");
	Date saida = sdf.parse(sc.next());
	if(!saida.after(entrada))
		System.out.println("Erro na reserva, a data de saida tem que ser depois da data de entrada!");
	else {
	Reserva r = new Reserva(numeroQuarto, entrada, saida);
	
	System.out.println(r);
	
	System.out.println();
	System.out.println("Entre com os dados para atualizar: ");
	System.out.print("Entrada (DD/MM/YYYY)");
	 entrada = sdf.parse(sc.next());
	
	System.out.print("Saida (DD/MM/YYYY)");
	saida = sdf.parse(sc.next());
	
	
	
	
	if(r.atualizar(entrada, saida) == null)
		System.out.println(r);
	
	
	
	}
	sc.close();
}

}
