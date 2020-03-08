import java.util.ArrayList;
import java.util.Date;

public class Transacao {
	double valor;
	Date data;

	
	public void exibirHistorico(int aux) {
		
		
		
		
		
	}
	
	public ArrayList<Transacao> historicoSaque(double valor, Date data) {

		Transacao recebeSaque = new Transacao();

		recebeSaque.valor = valor;
		recebeSaque.data = data;

		ArrayList<Transacao> saque = new ArrayList<Transacao>();
    
		saque.add(recebeSaque);
		
		return (saque);
	}

	public ArrayList<Transacao> historicoDeposito(double valor, Date data) {

		Transacao recebeDeposito = new Transacao();

		recebeDeposito.valor = valor;
		recebeDeposito.data = data;

		ArrayList<Transacao> deposito = new ArrayList<Transacao>();

		deposito.add(recebeDeposito);
		
		return (deposito);
	}

	public ArrayList<Transacao> historicoPagamento(double valor, Date data) {
		Transacao recebePgto = new Transacao();

		recebePgto.valor = valor;
		recebePgto.data = data;

		ArrayList<Transacao> pgto = new ArrayList<Transacao>();

		pgto.add(recebePgto);
		
		return (pgto);
	}

}
