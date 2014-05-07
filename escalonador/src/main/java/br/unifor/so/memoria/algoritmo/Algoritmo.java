package br.unifor.so.memoria.algoritmo;

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
		int var = Integer.parseInt(Principal.tfTamanhoMemoria.getText());
		Principal.sobrou = var;
		int i = 0;
		boolean boo = true;
		while (boo) {
			Bloco bloco = new Bloco();
			bloco.setProcesso(Principal.processosAptos.get(i));
			bloco.setTamanhoTotal(bloco.getProcesso().getTamanho());
			if ((Principal.sobrou -= bloco.getTamanhoTotal()) < 0) {
				break;
			} else {
				Principal.processosEmExecucao.add(bloco);
				panel.add(Principal.processosEmExecucao.get(i).montarDesenhoDoBloco());
				i++;
			}
		}
//		for (int i = 0; i < var; i++) {
//			Bloco bloco = new Bloco();
//			bloco.setProcesso(Principal.processosAptos.get(i));
//			Principal.processosEmExecucao.add(bloco);
//			panel.add(Principal.processosEmExecucao.get(i).montarDesenhoDoBloco());
//		}
		Principal.reorganizarProcessandoClasse(panel);
	}
	
	private boolean checar() {
		// TODO Auto-generated method stub
		return false;
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