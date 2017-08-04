package model;

import java.util.Calendar;

public class Movimentacao {

    private int id;
    private Conta conta;
    private Categoria categoria;
    private Calendar data;
    private String descricao;
    private TipoMovimentacao tipoMovimentacao;
    private float valor;

    public Movimentacao() {}

    public Movimentacao(int id, Conta conta, Categoria categoria, Calendar data, String descricao, TipoMovimentacao tipoMovimentacao, float valor) {
        this.id = id;
        this.conta = conta;
        this.categoria = categoria;
        this.data = data;
        this.descricao = descricao;
        this.tipoMovimentacao = tipoMovimentacao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public Conta getConta() {
        return conta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Calendar getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public float getValor() {
        return valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimentacao other = (Movimentacao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movimentacao{" + "id=" + id + ", conta=" + conta + ", categoria=" + categoria + ", data=" + data + ", descricao=" + descricao + ", tipoMovimentacao=" + tipoMovimentacao + ", valor=" + valor + '}';
    }
    
}
