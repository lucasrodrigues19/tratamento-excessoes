package entites;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import excessao.DominioExcessao;

public class Reserva {

	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	public Reserva() {
		
	}
	
	public Reserva(Integer numeroQuarto, Date entrada, Date saida)throws DominioExcessao {
		if(!saida.after(entrada))
			throw new DominioExcessao( "Erro na reserva, a data de saida tem que ser depois da data de entrada!");
		
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
	public void atualizar(Date entrada, Date saida)throws DominioExcessao{
		
		//caso a data de saida for antes da entrada, não pode, ou caso a data de entrada ou saida for antes da data atual nao pode
		Date dataAgora = new Date();
		if((entrada.before(dataAgora) || saida.before(dataAgora)))
			//quer dizer que um argumento(parametro do metodo) veio errado
			throw new DominioExcessao("Erro na reserva, a data de entrada, ou saida tem que ser depois da data atual!");
		else if(!saida.after(entrada))
			throw new DominioExcessao( "Erro na reserva, a data de saida tem que ser depois da data de entrada!");
		
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
