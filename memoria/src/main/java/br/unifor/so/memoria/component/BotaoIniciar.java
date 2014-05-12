package br.unifor.so.memoria.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.unifor.so.memoria.Principal;
import br.unifor.so.memoria.algoritmo.BestFit;
import br.unifor.so.memoria.algoritmo.FirstFit;
import br.unifor.so.memoria.algoritmo.MergeFit;
import br.unifor.so.memoria.algoritmo.NextFit;
import br.unifor.so.memoria.algoritmo.QuickFit;
import br.unifor.so.memoria.algoritmo.WorstFit;

public class BotaoIniciar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Principal.algoritmoENUM.getId()) {
		case 0:
			JOptionPane.showMessageDialog(null, "Selecione um Algoritmo.");
			break;
		case 1:
			Principal.btnIniciar.addActionListener(new MergeFit());
			break;
		case 2:
			Principal.btnIniciar.addActionListener(new FirstFit());
			break;
		case 3:
			Principal.btnIniciar.addActionListener(new QuickFit());
			break;
		case 4:
			Principal.btnIniciar.addActionListener(new BestFit());
			break;
		case 5:
			Principal.btnIniciar.addActionListener(new WorstFit());
			break;
		case 6:
			Principal.btnIniciar.addActionListener(new NextFit());
			break;
		}
	}
}