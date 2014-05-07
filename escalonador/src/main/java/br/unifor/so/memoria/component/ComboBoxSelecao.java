package br.unifor.so.memoria.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.unifor.so.memoria.Principal;
import br.unifor.so.memoria.algoritmo.constant.Algoritmo;

public class ComboBoxSelecao implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// Zera o código do ID quando troca.
		Principal.codigo = 0;
		switch (Principal.cbAlgoritmo.getSelectedItem().toString()) {
		case "Selecione":
			break;
		case "Merge Fits":
			Principal.algoritmoENUM = Algoritmo.MERGE_FIT;
			break;
		case "First Fit":
			Principal.algoritmoENUM = Algoritmo.FIRST_FIT;
			break;
		case "Quick Fit":
			Principal.algoritmoENUM = Algoritmo.QUICK_FIT;
			break;
		case "Best Fit":
			Principal.algoritmoENUM = Algoritmo.BEST_FIT;
			break;
		case "Worst Fit":
			Principal.algoritmoENUM = Algoritmo.WORST_FIT;
			break;
		case "Next Fit":
			Principal.algoritmoENUM = Algoritmo.NEXT_FIT;
			break;
		}
	}
}