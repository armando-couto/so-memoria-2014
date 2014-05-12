package br.unifor.so.memoria.algoritmo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import br.unifor.so.memoria.Principal;
import br.unifor.so.memoria.model.Bloco;
import br.unifor.so.memoria.model.Processo;
import br.unifor.so.memoria.model.thread.ProcessoThreadFirstFit;

/**
 * First Fit.
 * 
 * @author armandocouto
 * @email coutoarmando@gmail.com
 * @date 20/03/2014
 */
public class FirstFit extends Algoritmo implements ActionListener {

	@Override
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if (Principal.processamento != null)
			Principal.processamento.stop();

		Principal.processosAptos = new ArrayList<Processo>();
		Principal.processosEmExecucao = new LinkedList<Bloco>();
		criarProcessos();
		montarMemoria();
		montarProcessos();

		Principal.processamento = new ProcessoThreadFirstFit();
		Principal.processamento.start();
	}
}