package br.unifor.so.memoria.algoritmo.constant;

public enum Algoritmo {

	SELECIONE (0, "Selecione"),
	MERGE_FIT (1, "Merge Fits"),
	FIRST_FIT (2, "First Fit"),
	QUICK_FIT (3, "Quick Fit"),
	BEST_FIT  (4, "Best Fit"),
	WORST_FIT (5, "Worst Fit"),
	NEXT_FIT  (6, "Next Fit");
	
	private int id;
	private String descricao;
	
	private Algoritmo(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}