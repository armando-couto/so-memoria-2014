package br.unifor.so.memoria.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.unifor.so.memoria.Principal;
import br.unifor.so.memoria.algoritmo.FirstFit;

public class BotaoIniciar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Principal.algoritmoENUM.getId()) {
		case 0:
			JOptionPane.showMessageDialog(null, "Selecione um Algoritmo.");
			break;
		case 1:
			break;
		case 2:
			Principal.btnIniciar.addActionListener(new FirstFit());
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		}
	}
}