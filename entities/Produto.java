package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Produto {
	private Integer codigo;
	private String nome;
	private Double precoUnidade;
	private Integer quantidade;
	private Double valorTotal;
	private Date validade;

	private Funcionario funcionarioResponsavel;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Produto(Integer codigo, String nome, Double precoUnidade, Integer quantidade, Double valorTotal,
			Date validade, Funcionario funcionarioResponsavel) {
		this.codigo = codigo;
		this.nome = nome;
		this.precoUnidade = precoUnidade;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
		this.validade = validade;
		this.funcionarioResponsavel = funcionarioResponsavel;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrecoUnidade() {
		return precoUnidade;
	}

	public void setPrecoUnidade(Double precoUnidade) {
		this.precoUnidade = precoUnidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Funcionario getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}

	public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
		this.funcionarioResponsavel = funcionarioResponsavel;
	}

	public String toString() {
		return "Funcionario responsavel: " + funcionarioResponsavel.toString() + "\n Codigo: " + codigo + "\n Nome: " + nome
				+ "\n Validade: " + sdf.format(validade) + "\n Preco: R$" + precoUnidade + "\n Quantidade: " + quantidade
				+ "\n Valor total em estoque: R$" + getValorTotal();

	}

}
