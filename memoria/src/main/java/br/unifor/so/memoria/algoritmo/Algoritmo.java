package br.unifor.so.memoria.algoritmo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.unifor.so.memoria.Principal;
import br.unifor.so.memoria.model.Bloco;
import br.unifor.so.memoria.model.Processo;

public abstract class Algoritmo {

	public void criarProcessos() {
		for (int i = 0; i < Integer.parseInt(Principal.tfProcessos.getText()); i++) {
			Processo processo = new Processo();
			Principal.processosAptos.add(processo);
		}
	}
	
	public void montarMemoria() {
		JPanel panel = new JPanel();
		Principal.paProcessando.removeAll();
		int sobrou = Integer.parseInt(Principal.tfTamanhoMemoria.getText());
		Principal.sobrou = sobrou;
		
		List<Processo> processos = new ArrayList<Processo>();
		for (Processo processo : Principal.processosAptos) {
			Bloco bloco = new Bloco();
			bloco.setProcesso(processo);
			bloco.setTamanhoTotal(bloco.getProcesso().getTamanho());
			bloco.setTamanhoTotalUsando(bloco.getProcesso().getTamanho());
			
			sobrou = Principal.sobrou;
			
			if ((sobrou -= bloco.getTamanhoTotal()) >= 0) {
				Principal.sobrou -= bloco.getTamanhoTotal();
				Principal.processosEmExecucao.add(bloco);
				panel.add(Principal.processosEmExecucao.get(0).montarDesenhoDoBloco());
				processos.add(processo);

			} else {
				for (Bloco b : Principal.processosEmExecucao) {
					if (b.getProcesso().isJaSomou() && processo.getTamanho() <= b.getTamanhoTotal()) {
						panel.add(b.montarDesenhoDoBloco());

						b.setProcesso(processo);
						b.setTamanhoTotalUsando(processo.getTamanho());
					}
				}
			}
		}
		
		Principal.processosAptos.removeAll(processos);
		Principal.reorganizarProcessandoClasse(panel);
	}

	public void montarProcessos() {
		JPanel panel = new JPanel();
		Principal.paAProcessar.removeAll();
		for (int i = 0; i < Principal.processosAptos.size(); i++) {
			panel.add(Principal.processosAptos.get(i).montarDesenhoDoProcesso());
		}
		Principal.reorganizarAProcessar(panel);
	}
}