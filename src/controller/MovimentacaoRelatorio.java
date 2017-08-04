package controller;

import java.util.Date;
import model.Movimentacao;

public class MovimentacaoRelatorio {

    private final Movimentacao movimentacao;

    public MovimentacaoRelatorio(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public Integer getId() {
        return movimentacao.getId();
    }

    public Date getData() {
        return movimentacao.getData().getTime();
    }

    public String getDescricao() {
        return movimentacao.getDescricao();
    }

    public String getTipoMovimentacao() {
        return movimentacao.getTipoMovimentacao().name();
    }

    public float getValor() {
        return movimentacao.getValor();
    }

    @Override
    public String toString() {
        return "MovimentacaoRelatorio{" + "id=" + this.getId() + ", data=" + this.getData() + ", descricao=" + this.getDescricao() + ", tipo=" + this.getTipoMovimentacao() + ", valor=" + this.getValor() + "}";
    }
    
}
