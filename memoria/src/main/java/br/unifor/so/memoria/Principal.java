package br.unifor.so.memoria;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.unifor.so.memoria.algoritmo.constant.Algoritmo;
import br.unifor.so.memoria.component.BotaoIniciar;
import br.unifor.so.memoria.component.BotaoNovoProcesso;
import br.unifor.so.memoria.component.ComboBoxSelecao;
import br.unifor.so.memoria.model.Bloco;
import br.unifor.so.memoria.model.Processo;

public class Principal extends JFrame {

	private static final long serialVersionUID = 8936578361797638901L;

	public static Thread processamento;
	
	public static int codigoProcesso = 0;
	public static int codigoBloco = 0;

	public static List<Bloco> processosEmExecucao;
	public static List<Processo> processosAptos;
	
	public static int sobrou;

	public static JPanel paParametros;
	public static JPanel paProcessando;
	public static JScrollPane spaProcessando;
	public static JPanel paAProcessar;
	public static JScrollPane spaAProcessar;
	public static JTextField tfTamanhoMemoria;
	public static JTextField tfProcessos;
	public static Algoritmo algoritmoENUM;
	
	@SuppressWarnings("rawtypes")
	public static JComboBox cbAlgoritmo;
	public static JButton btnIniciar;
	
	private JButton btnNovoProcesso;

	public Principal() {
		setTitle("Memória");
		getContentPane().setLayout(null);
		
		this.setSize(850, 430);
		spaProcessando = new JScrollPane(paProcessando);
		spaAProcessar = new JScrollPane(paAProcessar);
		
		algoritmoENUM = Algoritmo.SELECIONE;

		this.panelParametros();
		this.panelProcessando();
		this.panelAProcessar();

		this.totalMemoria();
		this.processos();
		this.algoritmo();

		this.acoes();
	}
	
	private void panelParametros() {
		paParametros = new JPanel();
		paParametros.setBorder(new TitledBorder(null, "Par\u00E2metros ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paParametros.setBounds(17, 21, 819, 94);
		getContentPane().add(paParametros);
		paParametros.setLayout(null);
	}

	private void panelProcessando() {
		paProcessando = new JPanel();
		paProcessando.setBorder(new TitledBorder(null, "Processando ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paProcessando.setBounds(17, 116, 819, 153);
		getContentPane().add(paProcessando);
		paProcessando.setLayout(new BorderLayout(0, 0));
	}

	private void panelAProcessar() {
		paAProcessar = new JPanel();
		paAProcessar.setBorder(new TitledBorder(null, "A Processar ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paAProcessar.setBounds(17, 267, 819, 118);
		getContentPane().add(paAProcessar);
		paAProcessar.setLayout(new BorderLayout(0, 0));
		
		JLabel lblarmandocouto = new JLabel("©ArmandoCouto");
		lblarmandocouto.setBounds(727, 386, 106, 16);
		getContentPane().add(lblarmandocouto);
	}

	private void totalMemoria() {
		JLabel lbTotalMemoria = new JLabel("Total da Mémoria:");
		lbTotalMemoria.setBounds(6, 24, 117, 16);
		paParametros.add(lbTotalMemoria);

		tfTamanhoMemoria = new JTextField();
		tfTamanhoMemoria.setBounds(120, 18, 132, 28);
		paParametros.add(tfTamanhoMemoria);
		tfTamanhoMemoria.setColumns(100);
	}

	private void processos() {
		JLabel lbProcessos = new JLabel("Processos:");
		lbProcessos.setBounds(51, 52, 72, 16);
		paParametros.add(lbProcessos);

		tfProcessos = new JTextField();
		tfProcessos.setBounds(120, 46, 132, 28);
		paParametros.add(tfProcessos);
		tfProcessos.setColumns(100);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void algoritmo() {
		JLabel lbAlgoritmo = new JLabel("Algoritmo:");
		lbAlgoritmo.setBounds(276, 24, 72, 16);
		paParametros.add(lbAlgoritmo);

		cbAlgoritmo = new JComboBox();
		cbAlgoritmo.setBounds(351, 20, 316, 27);
		cbAlgoritmo.addItem(Algoritmo.SELECIONE.getDescricao());
		cbAlgoritmo.addItem(Algoritmo.MERGE_FIT.getDescricao());
		cbAlgoritmo.addItem(Algoritmo.FIRST_FIT.getDescricao());
		cbAlgoritmo.addItem(Algoritmo.QUICK_FIT.getDescricao());
		cbAlgoritmo.addItem(Algoritmo.BEST_FIT.getDescricao());
		cbAlgoritmo.addItem(Algoritmo.WORST_FIT.getDescricao());
		cbAlgoritmo.addItem(Algoritmo.NEXT_FIT.getDescricao());
		paParametros.add(cbAlgoritmo);
	}

	private void acoes() {
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(531, 59, 117, 29);
		paParametros.add(btnIniciar);

		btnNovoProcesso = new JButton("Novo Processos");
		btnNovoProcesso.setBounds(661, 59, 152, 29);
		paParametros.add(btnNovoProcesso);
		
		cbAlgoritmo.addActionListener(new ComboBoxSelecao());
		btnIniciar.addActionListener(new BotaoIniciar());
		btnNovoProcesso.addActionListener(new BotaoNovoProcesso());
	}
	
	public static void reorganizarAProcessar(JPanel panel) {
		Principal.paAProcessar.add(new JScrollPane(panel));
		Principal.paAProcessar.repaint();
		Principal.paAProcessar.revalidate();
	}
	
	public static void reorganizarProcessando(JPanel panel) {
		Principal.paProcessando.removeAll();
		Principal.paProcessando.add(new JScrollPane(panel));
		Principal.paProcessando.repaint();
		Principal.paProcessando.revalidate();
	}
	
	public static void reorganizarProcessandoClasse(JPanel panel) {
		Principal.processosAptos.removeAll(Principal.processosEmExecucao);
		Principal.paProcessando.add(new JScrollPane(panel));
		Principal.paProcessando.repaint();
		Principal.paProcessando.revalidate();
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Principal().setVisible(true);
			}
		});
	}
}