package br.unifor.so.memoria.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.unifor.so.memoria.Principal;
import br.unifor.so.memoria.algoritmo.FirstFit;

public class BotaoNovoProcesso implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Principal.algoritmoENUM.getId()) {
		case 1:
//			MergeFit mergeFit = new MergeFit();
//			mergeFit.criarProcessos();
//			mergeFit.montarProcessos();
			break;
		case 2:
			FirstFit firstFit = new FirstFit();
			firstFit.criarProcessos();
			break;
		case 3:
//			QuickFit quickFit = new QuickFit();
//			quickFit.criarProcessos();
//			quickFit.montarProcessos();
			break;
		case 4:
			
			break;
		case 5:
//			WorstFit worstFit = new WorstFit();
//			worstFit.criarProcessos();
//			Principal.processosEmExecucao = new ArrayList<Processo>();
//			worstFit.montarMemoria();
//			worstFit.montarProcessos();
			break;
		case 6:
//			NextFit nesxtFit = new NextFit();
//			nesxtFit.criarProcessos();
//			Principal.processosEmExecucao = new ArrayList<Processo>();
//			nesxtFit.montarMemoria();
//			nesxtFit.montarProcessos();
			break;
		}
	}
}