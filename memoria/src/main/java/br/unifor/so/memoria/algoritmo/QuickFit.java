package br.unifor.so.memoria.algoritmo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import br.unifor.so.memoria.Principal;
import br.unifor.so.memoria.model.Bloco;
import br.unifor.so.memoria.model.Processo;
import br.unifor.so.memoria.model.thread.ProcessoThreadQuickFit;

/**
 * Quick Fit.
 * 
 * @author armandocouto
 * @email coutoarmando@gmail.com
 * @date 11/05/2014
 */
public class QuickFit extends Algoritmo implements ActionListener {

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

		Principal.processamento = new ProcessoThreadQuickFit();
		Principal.processamento.start();
	}
}