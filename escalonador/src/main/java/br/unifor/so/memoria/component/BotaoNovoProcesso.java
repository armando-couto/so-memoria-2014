package br.unifor.so.memoria.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import br.unifor.so.memoria.Principal;
import br.unifor.so.memoria.algoritmo.BestFit;
import br.unifor.so.memoria.algoritmo.FirstFit;
import br.unifor.so.memoria.algoritmo.MergeFit;
import br.unifor.so.memoria.algoritmo.NextFit;
import br.unifor.so.memoria.algoritmo.QuickFit;
import br.unifor.so.memoria.algoritmo.WorstFit;
import br.unifor.so.memoria.model.Processo;

public class BotaoNovoProcesso implements ActionListener {

	@Override
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {
		switch (Principal.algoritmoENUM.getId()) {
		case 1:
			MergeFit mergeFit = new MergeFit();
			mergeFit.criarProcessos();
			mergeFit.montarProcessos();
			break;
		case 2:
			BestFit bestFit = new BestFit();
			bestFit.criarProcessos();
			bestFit.montarProcessos();
			break;
		case 3:
			QuickFit quickFit = new QuickFit();
			quickFit.criarProcessos();
			quickFit.montarProcessos();
			break;
		case 4:
			FirstFit firstFit = new FirstFit();
			firstFit.criarProcessos();
			Principal.processosEmExecucao = new ArrayList<Processo>();
			firstFit.montarNucleos();
			firstFit.montarPrecessos();
			break;
		case 5:
			WorstFit worstFit = new WorstFit();
			worstFit.criarProcessos();
			Principal.processosEmExecucao = new ArrayList<Processo>();
			worstFit.montarNucleos();
			worstFit.montarProcessos();
			break;
		case 6:
			NextFit nesxtFit = new NextFit();
			nesxtFit.criarProcessos();
			Principal.processosEmExecucao = new ArrayList<Processo>();
			nesxtFit.montarNucleos();
			nesxtFit.montarProcessos();
			break;
		}
	}
}