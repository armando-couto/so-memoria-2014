package br.unifor.so.memoria.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.unifor.so.memoria.Principal;
import br.unifor.so.memoria.algoritmo.BestFit;
import br.unifor.so.memoria.algoritmo.FirstFit;
import br.unifor.so.memoria.algoritmo.MergeFit;
import br.unifor.so.memoria.algoritmo.NextFit;
import br.unifor.so.memoria.algoritmo.QuickFit;
import br.unifor.so.memoria.algoritmo.WorstFit;

public class BotaoNovoProcesso implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Principal.algoritmoENUM.getId()) {
		case 1:
			MergeFit mergeFit = new MergeFit();
			mergeFit.criarProcessos();
			break;
		case 2:
			FirstFit firstFit = new FirstFit();
			firstFit.criarProcessos();
			firstFit.montarProcessos();
			break;
		case 3:
			QuickFit quickFit = new QuickFit();
			quickFit.criarProcessos();
			break;
		case 4:
			BestFit bestFit = new BestFit();
			bestFit.criarProcessos();
			break;
		case 5:
			WorstFit worstFit = new WorstFit();
			worstFit.criarProcessos();
			break;
		case 6:
			NextFit nesxtFit = new NextFit();
			nesxtFit.criarProcessos();
			break;
		}
	}
}