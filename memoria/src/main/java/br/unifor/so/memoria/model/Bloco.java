package br.unifor.so.memoria.model;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import br.unifor.so.memoria.Principal;

public class Bloco implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private Integer tamanhoTotal;
	private Integer tamanhoTotalUsando;
	private Processo processo;
	
	public Bloco() {
		Principal.codigoBloco++;
		this.codigo = Principal.codigoBloco;
	}

	public JLabel montarDesenhoDoBloco() {
		StringBuilder sb = new StringBuilder();
		JLabel label = new JLabel();
		sb.append("<html>Id: " + this.codigo + "<br>");
		sb.append("Tamanho Total: " + this.tamanhoTotal + "<br>");
//		sb.append("Tamanho Total Usado: " + this.tamanhoTotalUsando + "<br>");
		sb.append("Processo Tamanho: " + this.processo.getTamanho() + "<br>");
		sb.append("Processo Tempo Inicial: " + this.processo.getTempoInicial() + "<br>");
		sb.append("Processo Tempo Final: " + this.processo.getTempoFinal() + "<br></html>");
		label.setText(sb.toString());
		label.setForeground(Color.BLUE);
		label.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		return label;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getTamanhoTotal() {
		return tamanhoTotal;
	}

	public void setTamanhoTotal(Integer integer) {
		this.tamanhoTotal = integer;
	}

	public Integer getTamanhoTotalUsando() {
		return tamanhoTotalUsando;
	}

	public void setTamanhoTotalUsando(Integer tamanhoTotalUsando) {
		this.tamanhoTotalUsando = tamanhoTotalUsando;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
}