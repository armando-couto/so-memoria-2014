package br.unifor.so.memoria.model.thread;

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
				if (bloco.getProcesso().checarSeOTempoZerou()) {
					Principal.sobrou += Principal.processosEmExecucao.get(i).getTamanhoTotal();
					// Principal.processosEmExecucao.remove(bloco);
					if (!Principal.processosAptos.isEmpty()) {
						panel.add(Principal.processosEmExecucao.get(0).montarDesenhoDoBloco());
						Bloco bloco3 = Principal.processosEmExecucao.get(i);

						if (Principal.sobrou >= bloco3.getTamanhoTotal()) {
							bloco3.setProcesso(Principal.processosAptos.get(0));

							Principal.processosAptos.remove(0);
							Principal.paAProcessar.removeAll();

							JPanel panelAptos = new JPanel();
							for (Processo processoAptos : Principal.processosAptos) {
								panelAptos.add(processoAptos.montarDesenhoDoProcesso());
							}
							Principal.reorganizarAProcessar(panelAptos);
						} else {
							for (Processo processo : Principal.processosAptos) {
								if (Principal.sobrou >= processo.getTamanho()) {
									bloco3.setProcesso(processo);

									Principal.processosAptos.remove(0);
									Principal.paAProcessar.removeAll();

									JPanel panelAptos = new JPanel();
									for (Processo processoAptos : Principal.processosAptos) {
										panelAptos.add(processoAptos.montarDesenhoDoProcesso());
									}
									Principal.reorganizarAProcessar(panelAptos);
								}
							}
						}
					}
				} else {
					panel.add(Principal.processosEmExecucao.get(i).montarDesenhoDoBloco());
					Principal.processosEmExecucao.set(i, bloco);
				}
			}
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