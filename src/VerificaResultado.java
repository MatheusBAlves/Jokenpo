
public class VerificaResultado {

	private int resultado = 0;

	public int verificaResultado(int jogador, int jogadaComputador) {
		switch (jogador) {

		case 1:
			switch (jogadaComputador) {

			case 1:
				resultado = 0;
				break;
			case 2:
				resultado = -1;
				break;
			case 3:
				resultado = 1;
				break;

			}

			break;

		case 2:
			switch (jogadaComputador) {

			case 1:
				resultado = 1;
				break;
			case 2:
				resultado = 0;
				break;
			case 3:
				resultado = -1;
				break;

			}

			break;

		case 3:
			switch (jogadaComputador) {

			case 1:
				resultado = -1;
				break;
			case 2:
				resultado = 1;
				break;
			case 3:
				resultado = 0;
				break;

			}
			break;
		}
		return resultado;
	}

}
