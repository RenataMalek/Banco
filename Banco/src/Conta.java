import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Conta {

	double saldo = 1000.00;
	String numero = "1234";
	String senha = "123456";
	Transacao historico = new Transacao();

	public void chamarMenu() {
		double valor;
		String codigoBarras;
		int opc = 0, aux;

		while (opc != 9) {
			opc = Integer.parseInt(
					JOptionPane.showInputDialog("*ESCOLHA A OPÇÃO DESEJADA*\n1 - Ver saldo \n2 - Efetuar Saque "
							+ "\n3 - Efetuar Depósito \n4 - Efetuar Pagamentos \n5 - Ver extrato \n9 - Encerrar"));

			switch (opc) {
			case 1:
				JOptionPane.showMessageDialog(null, "Seu saldo é de R$ " + saldo);
				break;
			case 2:
				valor = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor de saque "));
				if (valor <= saldo) {
					saque(valor);
				} else {
					JOptionPane.showMessageDialog(null, "Saldo insuficiente");
				}
				break;
			case 3:
				valor = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor de deposito "));
				if (valor > 0) {
					deposito(valor);
				} else {
					JOptionPane.showMessageDialog(null, "Valor invalido!!!");
				}
				break;

			case 4:
				codigoBarras = JOptionPane.showInputDialog("Digite o codigo de barras");
				valor = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor do boleto "));
				if (valor <= saldo) {
					pagamento(codigoBarras, valor);
				} else {
					JOptionPane.showMessageDialog(null, "Saldo insuficiente");
				}
				break;
			case 5:
				aux = Integer.parseInt(JOptionPane.showInputDialog(
						"Escolha o período de histórico para emissão do extrato \n1 - Ultimas 24 horas \n2 - Ultimos 5 dias \n3 - "
								+ "Ultimos 30 dias \n9 - Voltar menu anterior"));

				if (aux == 1) {
					historico.exibirHistorico(1);
				} else if (aux == 2) {
					historico.exibirHistorico(5);
				} else if (aux == 3) {
					historico.exibirHistorico(30);
				} else {
					JOptionPane.showMessageDialog(null, "INVALIDO, TENTE NOVAMENTE");
				}
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "OPERAÇÃO FINALIZADA");
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "INVALIDO, ESCOLHA NOVAMENTE");
				break;

			}
		}

	}

	public void saque(double valor) {

		Transacao enviarSaque = new Transacao();

		saldo -= valor;
		JOptionPane.showMessageDialog(null, "Retire o valor");

		Date data = new Date();
		enviarSaque.historicoSaque(valor, data);
	}

	public void deposito(double valor) {

		Transacao enviarDeposito = new Transacao();

		saldo += valor;
		JOptionPane.showMessageDialog(null, "Depósito realizado");

		Date data = new Date();
		enviarDeposito.historicoDeposito(valor, data);

	}

	public void pagamento(String codigo, double valor) {

		Transacao enviarPgto = new Transacao();

		saldo -= valor;
		JOptionPane.showMessageDialog(null, "Pagamento realizado");

		Date data = new Date();
		enviarPgto.historicoPagamento(valor, data);

	}

	public Calendar recebeData(double valor) {

		Date data = new Date();
		Calendar captar = new GregorianCalendar();

		captar.setTime(data);

		return (captar);

	}

}
