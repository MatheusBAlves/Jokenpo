import javax.swing.JOptionPane;

public class Jogo {

	public static void main(String[] args) {
		boolean jogar = true;
		int partidas = 0;
		int partidasInicial = 0;
		int pontosJogador = 0;
		int pontosComputador = 0;
		Partida partida = new Partida();
		JOptionPane.showMessageDialog(null, "BEM VINDO AO JOGO JOKENPO", "JOKENPO", 1);
		do {
			do {
				try {
					partidas = Integer.parseInt(JOptionPane.showInputDialog("Quantos rounds?"));
				} catch (NumberFormatException err) {
					int opcao = JOptionPane.showConfirmDialog(null, "deseja sair?");
					if (opcao == JOptionPane.OK_OPTION || opcao == JOptionPane.CLOSED_OPTION) {
						jogar = false;
						break;
					}
				}
				if (partidas == 0) {
					JOptionPane.showMessageDialog(null, "Insira um valor válido");
				}
			} while (partidas == 0);
			if (jogar == false) {
				break;
			}
			partidasInicial = partidas;
			for (int i = 1; i <= partidas; i++) {
				int resultado = partida.jogar();
				JOptionPane.showMessageDialog(null, "Round número: " + i);
				switch (resultado) {
				case -1:
					pontosComputador++;
					JOptionPane.showMessageDialog(null,
							"Seu inimigo venceu o round, totalizando: " + pontosComputador + " pontos",
							"Computador venceu", 1);
					break;
				case 0:
					JOptionPane.showMessageDialog(null,
							"Empate, Pontos Computador: " + pontosComputador + " Pontos Jogador: " + pontosJogador,
							"Empate", 1);
					break;
				case 1:
					pontosJogador++;
					JOptionPane.showMessageDialog(null,
							"Você venceu o round, totalizando: " + pontosJogador + " pontos", "Jogador venceu", 1);
					break;

				}
				if (pontosJogador >= (partidasInicial / 2) + 0.5) {
					int opcao = JOptionPane.showConfirmDialog(null,
							"Jogador venceu com " + pontosJogador + " pontos, deseja começar outro jogo?",
							"Fim de jogo", 2);
					if (opcao == JOptionPane.CANCEL_OPTION || opcao == JOptionPane.CLOSED_OPTION) {
						jogar = false;
					}
					pontosComputador = 0;
					pontosJogador = 0;
					break;
				} else if (pontosComputador >= (partidasInicial / 2) + 0.5) {
					int opcao = JOptionPane.showConfirmDialog(null,
							"Computador venceu com " + pontosComputador + " pontos, deseja começar outro jogo?",
							"Fim de jogo", 2);
					if (opcao == JOptionPane.CANCEL_OPTION || opcao == JOptionPane.CLOSED_OPTION) {
						jogar = false;
					}
					pontosComputador = 0;
					pontosJogador = 0;
					break;
				}
				if (pontosComputador <= (partidasInicial / 2) + 0.5 && pontosJogador <= (partidasInicial / 2) + 0.5
						&& i == partidas) {
					partidas++;
				}
			}
		} while (jogar == true);
		JOptionPane.showMessageDialog(null, "Muito obrigado por jogar nosso jogo Jokenpo!", "Criado por Matheus Alves",
				1);
	}

}
