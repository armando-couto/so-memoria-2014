package br.unifor.so.memoria.model.thread;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.unifor.so.memoria.Principal;
import br.unifor.so.memoria.model.Bloco;
import br.unifor.so.memoria.model.Processo;

public class ProcessoThreadFirstFit extends Thread {

	@SuppressWarnings("static-access")
	public void run() {
		boolean checar = true;
		while (checar) {
			JPanel panel = new JPanel();
			for (int i = 0; i < Principal.processosEmExecucao.size(); i++) {
				Bloco bloco = Principal.processosEmExecucao.get(i);
				bloco.getProcesso().processamento();

				if (bloco.getProcesso().checarSeOTempoZerou() && !bloco.getProcesso().isJaSomou()) {

					bloco.getProcesso().setJaSomou(true);

					int tamanhoOriginal = Integer.parseInt(Principal.tfTamanhoMemoria.getText());

					if (tamanhoOriginal < Principal.sobrou)
						Principal.sobrou = tamanhoOriginal;

					List<Processo> processos = new ArrayList<Processo>();
					for (Processo processo : Principal.processosAptos) {

						int sobrou = Principal.sobrou;

						if ((sobrou -= processo.getTamanho()) >= 0) {
							Principal.sobrou -= processo.getTamanho();

							panel.add(Principal.processosEmExecucao.get(0).montarDesenhoDoBloco());
							Bloco bloco3 = Principal.processosEmExecucao.get(i);

							bloco3.setProcesso(processo);
							bloco3.setTamanhoTotalUsando(processo.getTamanho());

							processos.add(processo);
							Principal.paAProcessar.removeAll();

						} else {
							for (Bloco b : Principal.processosEmExecucao) {
								if (b.getProcesso().isJaSomou() && processo.getTamanho() <= b.getTamanhoTotal()) {
									panel.add(b.montarDesenhoDoBloco());

									b.setProcesso(processo);
									b.setTamanhoTotalUsando(processo.getTamanho());

									Principal.paAProcessar.removeAll();
								}
							}
						}
					}

					if (processos.isEmpty()) {
						bloco.getProcesso().limparDados();
					}

					Principal.processosAptos.removeAll(processos);

				} else {
					panel.add(Principal.processosEmExecucao.get(i).montarDesenhoDoBloco());
					Principal.processosEmExecucao.set(i, bloco);
				}
			}

			JPanel panelAptos = new JPanel();
			for (Processo processoAptos : Principal.processosAptos) {
				panelAptos.add(processoAptos.montarDesenhoDoProcesso());
			}
			Principal.reorganizarAProcessar(panelAptos);

			Principal.reorganizarProcessando(panel);

			try {
				checar = !Principal.processosEmExecucao.isEmpty();
				Principal.processamento.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}