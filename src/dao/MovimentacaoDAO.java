package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Conta;
import model.Movimentacao;
import model.TipoMovimentacao;
import util.DataBase;

public class MovimentacaoDAO {

    private final DataBase db;
    
    public MovimentacaoDAO() {
        db = new DataBase();
    }
    
    public Movimentacao selectById(int id) {
        Movimentacao movimentacao = new Movimentacao();
        try {
            db.open();
            String sql = "SELECT * FROM movimentacoes WHERE id = ?";
            PreparedStatement ps = db.getConnetion().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                movimentacao.setId(rs.getInt("id"));
                movimentacao.setConta(new ContaDAO().selectById(rs.getInt("conta_id")));
                movimentacao.setCategoria(new CategoriaDAO().selectById(rs.getInt("categoria_id")));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));
                movimentacao.setData(data);
                movimentacao.setDescricao(rs.getString("descricao"));
                movimentacao.setTipoMovimentacao(TipoMovimentacao.valueOf(rs.getString("tipoMovimentacao")));
                movimentacao.setValor(rs.getFloat("valor"));
            }     
        } catch (SQLException error) {
            System.out.println("ERRO: " + error);
        } finally {
            db.close();
            return movimentacao;
        }
    }
    
    public List<Movimentacao> selectAll() {
        List<Movimentacao> movimentacaos = new ArrayList();
        try {
            db.open();
            String sql = "SELECT * FROM movimentacoes";
            PreparedStatement ps = db.getConnetion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movimentacao movimentacao = new Movimentacao();
                movimentacao.setId(rs.getInt("id"));
                movimentacao.setConta(new ContaDAO().selectById(rs.getInt("conta_id")));
                movimentacao.setCategoria(new CategoriaDAO().selectById(rs.getInt("categoria_id")));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));
                movimentacao.setData(data);
                movimentacao.setDescricao(rs.getString("descricao"));
                movimentacao.setTipoMovimentacao(TipoMovimentacao.valueOf(rs.getString("tipoMovimentacao")));
                movimentacao.setValor(rs.getFloat("valor"));
                movimentacaos.add(movimentacao);
            }
        } catch(SQLException error) {
            System.out.println("ERRO: " + error);
        } finally {
            db.close();
            return movimentacaos;
        }
    }
    
}
