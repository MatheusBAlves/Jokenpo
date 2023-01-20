import javax.swing.JOptionPane;

public class Partida {

	JogadaComputador jogadaComputador = new JogadaComputador();
	VerificaResultado verificaResultado = new VerificaResultado();

	public int jogar() {
		boolean escolha = false;
		int escolhaUsuario=0;
		Object[] jogadas = { 1, 2, 3 };
		int escolhaComputador = jogadaComputador.setJogadaComputador();
		do {
			try {
				escolhaUsuario = (int) JOptionPane.showInputDialog(null, "Pedra - 1\nPapel - 2\nTesoura - 3",
						"Jogada do usuario", 3, null, jogadas, jogadas[0]);
				escolha = true;
			} catch (NullPointerException err) {
				int opcao = JOptionPane.showConfirmDialog(null, "deseja sair?");
				if (opcao == JOptionPane.OK_OPTION || opcao == JOptionPane.CLOSED_OPTION) {
					JOptionPane.showMessageDialog(null, "Muito obrigado por jogar nosso jogo Jokenpo!", "Criado por Matheus Alves",
							1);
					System.exit(0);
				}
			}
		} while (escolha == false);
		return verificaResultado.verificaResultado(escolhaUsuario, escolhaComputador);
	}
}
