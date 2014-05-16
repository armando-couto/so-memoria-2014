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
	private int[] possiveisTamanhosDoProcesso = { 32, 64, 128, 256, 512, 1024 };
	private boolean jaSomou = false;

	private Integer tempoAindaQueFalta;

	public Processo() {
		Principal.codigoProcesso++;
		this.codigo = Principal.codigoProcesso;
		this.tempoInicial = 0;
		gerarTamanho();
		gerarTempoDeExecucao();
	}

	public JLabel montarDesenhoDoProcesso() {
		StringBuilder sb = new StringBuilder();
		JLabel label = new JLabel();
		sb.append("<html>Id: " + this.codigo + "<br>");
		sb.append("Tempo Inicial: " + this.tempoInicial + "<br>");
		sb.append("Tempo Final: " + this.tempoFinal + "<br>");
		sb.append("Tamanho: " + this.tamanho + "<br></html>");
		label.setText(sb.toString());
		label.setForeground(Color.BLUE);
		label.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		return label;
	}

	private void gerarTempoDeExecucao() {
		Random r = new Random();
		int tempoGerado = r.nextInt(30);
		if (tempoGerado <= 10)
			gerarTempoDeExecucao();

		this.tempoFinal = tempoGerado;
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
		int valorAleatorio = r.nextInt(6);
		this.tamanho = possiveisTamanhosDoProcesso[valorAleatorio];
	}

	public void limparDados() {
		codigo = null;
		tempoInicial = 0;
		tempoFinal = 0;
		tamanho = 0;
	}

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

	public boolean isJaSomou() {
		return jaSomou;
	}

	public void setJaSomou(boolean jaSomou) {
		this.jaSomou = jaSomou;
	}
}