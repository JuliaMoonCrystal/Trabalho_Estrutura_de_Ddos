package Qualidade;

public class dados {
	 String regiao;
	 double dados_Regiao;
	 String qualidade;

	public dados(String regiao, double novo_indice,String qualidade) {
		this.dados_Regiao=novo_indice;
		this.regiao=regiao;
		this.qualidade=qualidade;
	}

	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public double getDados_Regiao() {
		return dados_Regiao;
	}
	public void setDados_Regiao(int dados_Regiao) {
		this.dados_Regiao = dados_Regiao;
	}
	public String getQualidade() {
		return qualidade;
	}
	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	 } 
}
