import javax.swing.JOptionPane;

public class Conta {

	double saldo = 1000.00;
	String numero = "1234";
	String senha = "123456";

	public void chamarMenu() {
		double valor;
		String codigoBarras;
		int opc = 0;

		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane
					.showInputDialog("*ESCOLHA A OPÇÃO DESEJADA*\n1 - Ver saldo \n2 - Efetuar Saque "
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
			case 5: // extrato();
				break;
			case 9: JOptionPane.showMessageDialog(null, "OPERAÇÃO FINALIZADA");
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "INVALIDO, ESCOLHA NOVAMENTE");
				break;

			}
		}

	}

	public void saque(double valor) {

		saldo -= valor;
		JOptionPane.showMessageDialog(null, "Retire o valor");

	}

	public void deposito(double valor) {

		saldo += valor;
		JOptionPane.showMessageDialog(null, "Depósito realizado");

	}

	public void pagamento(String codigo, double valor) {

		saldo -= valor;
		JOptionPane.showMessageDialog(null, "Pagamento realizado");

	}
}