package br.unifor.so.memoria.algoritmo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import br.unifor.so.memoria.Principal;
import br.unifor.so.memoria.model.Processo;
import br.unifor.so.memoria.model.thread.ProcessoThreadWorstFit;

public class WorstFit extends Algoritmo implements ActionListener {

	@Override
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if (Principal.processamento != null)
			Principal.processamento.stop();

		Principal.processosAptos = new ArrayList<Processo>();
		Principal.processosEmExecucao = new ArrayList<Processo>();
		criarProcessos();
		montarNucleos();
		montarProcessos();
		
		Principal.processamento = new ProcessoThreadWorstFit();
		Principal.processamento.start();
	}
	
	@Override
	public void criarProcessos() {
		super.criarProcessos();
		Principal.processosAptos.addAll(Principal.processosEmExecucao);
		for (Processo processo : Principal.processosAptos) {
			processo.calculaTempoAindaDeExecucao();
		}
//		Collections.sort(Principal.processosAptos, new Processo());
	}
}