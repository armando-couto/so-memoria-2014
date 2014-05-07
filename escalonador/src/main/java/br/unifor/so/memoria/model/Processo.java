package br.unifor.so.memoria.model;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import br.unifor.so.memoria.Principal;

public class Processo implements Serializable {

	private static final long serialVersionUID = 1038124241569745320L;

	private Integer codigo;
	private Integer tempoInicial;
	private Integer tempoFinal;
	private Integer tamanho;
	private int[] possiveisTamanhosDeMemoria = {32, 64, 128, 256, 512, 1024};

	private Integer tempoAindaQueFalta;

	public Processo() {
		Principal.codigo++;
		this.codigo = Principal.codigo;
		this.tempoInicial = 0;
		gerarTempoDeExecucao();
	}

	private void gerarTempoDeExecucao() {
		Random r = new Random();
		int tempoGerado = r.nextInt(30);
		if (tempoGerado <= 10)
			gerarTempoDeExecucao();

		this.tempoFinal = tempoGerado;
	}

	public JLabel montarDesenhoDoProcesso() {
		StringBuilder sb = new StringBuilder();
		JLabel label = new JLabel();
		sb.append("<html>Id: " + this.codigo + "<br>");
		sb.append("TI: " + this.tempoInicial + "<br>");
		sb.append("TF: " + this.tempoFinal + "<br></html>");
		label.setText(sb.toString());
		label.setForeground(Color.BLUE);
		label.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		return label;
	}

	public JLabel montarDesenhoDoProcessoComPrioridade() {
		StringBuilder sb = new StringBuilder();
		JLabel label = new JLabel();
		sb.append("<html>Id: " + this.codigo + "<br>");
		sb.append("TI: " + this.tempoInicial + "<br>");
		sb.append("TF: " + this.tempoFinal + "<br>");
		sb.append("TM: " + this.tamanho + "<br></html>");
		label.setText(sb.toString());
		label.setForeground(Color.BLUE);
		label.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		return label;
	}

	public void processamento() {
		if (tempoInicial < tempoFinal)
			tempoInicial++;
	}

	public boolean checarSeOTempoZerou() {
		if (tempoInicial >= tempoFinal)
			return true;
		else
			return false;
	}

	public void calculaTempoAindaDeExecucao() {
		this.tempoAindaQueFalta = tempoFinal - tempoInicial;
	}

	public void gerarTamanho() {
		Random r = new Random();
		int valorAleatorio = r.nextInt(5);
		this.tamanho = possiveisTamanhosDeMemoria[valorAleatorio];
	}

//	@Override
//	public int compare(Processo o1, Processo o2) {
//		if (Principal.algoritmoENUM == Algoritmo.SRT) {
//			return o1.getTempoAindaQueFalta().compareTo(o2.getTempoAindaQueFalta());
//		} else if (Principal.algoritmoENUM == Algoritmo.N_FIFO) {
//			return o1.getPrioridade().compareTo(o2.getPrioridade());
//		} else {
//			return o1.getTempoFinal().compareTo(o2.getTempoFinal());
//		}
//	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoInicial(Integer tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	public Integer getTempoFinal() {
		return tempoFinal;
	}

	public void setTempoFinal(Integer tempoFinal) {
		this.tempoFinal = tempoFinal;
	}

	public Integer getTempoAindaQueFalta() {
		return tempoAindaQueFalta;
	}

	public void setTempoAindaQueFalta(Integer tempoAindaQueFalta) {
		this.tempoAindaQueFalta = tempoAindaQueFalta;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}
}