package entites;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	public Reserva() {
		
	}
	
	public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	
	public Long duracao() {
		long diff = saida.getTime() - entrada.getTime();
		//converte os dias em milessegundos 
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	public void atualizar(Date entrada, Date saida) {
		this.entrada = entrada;
		this.saida = saida;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Reserva: ");
		sb.append("Quarto ");
		sb.append(this.getNumeroQuarto());
		sb.append(", entrada: ");
		sb.append(sdf.format(this.entrada));
		sb.append(", saida: ");
		sb.append(sdf.format(this.saida)+", ");
		sb.append(duracao());
		sb.append(" noites");
		return sb.toString();
	}
	
}
