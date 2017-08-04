package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conta;
import util.DataBase;

public class ContaDAO {

    private final DataBase db;
    
    public ContaDAO() {
        db = new DataBase();
    }
    
    public Conta selectById(int id) {
        Conta conta = new Conta();
        try {
            db.open();
            String sql = "SELECT * FROM contas WHERE id = ?";
            PreparedStatement ps = db.getConnetion().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                conta.setId(rs.getInt("id"));
                conta.setBanco(rs.getString("banco"));
                conta.setAgencia(rs.getString("agencia"));
                conta.setNumero(rs.getString("numero"));
                conta.setTitular(rs.getString("titular"));
            }     
        } catch (SQLException error) {
            System.out.println("ERRO: " + error);
        } finally {
            db.close();
            return conta;
        }
    }
    
    public List<Conta> selectAll() {
        List<Conta> contas = new ArrayList();
        try {
            db.open();
            String sql = "SELECT * FROM contas";
            PreparedStatement ps = db.getConnetion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Conta conta = new Conta();
                conta.setId(rs.getInt("id"));
                conta.setBanco(rs.getString("banco"));
                conta.setAgencia(rs.getString("agencia"));
                conta.setNumero(rs.getString("numero"));
                conta.setTitular(rs.getString("titular"));
                contas.add(conta);
            }
        } catch(SQLException error) {
            System.out.println("ERRO: " + error);
        } finally {
            db.close();
            return contas;
        }
    }
    
}
