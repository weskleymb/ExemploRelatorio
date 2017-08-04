package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import util.DataBase;

public class CategoriaDAO {

    private final DataBase db;
    
    public CategoriaDAO() {
        db = new DataBase();
    }
    
    public Categoria selectById(int id) {
        Categoria categoria = new Categoria();
        try {
            db.open();
            String sql = "SELECT * FROM categorias WHERE id = ?";
            PreparedStatement ps = db.getConnetion().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
            }     
        } catch (SQLException error) {
            System.out.println("ERRO: " + error);
        } finally {
            db.close();
            return categoria;
        }
    }
    
    public List<Categoria> selectAll() {
        List<Categoria> categorias = new ArrayList();
        try {
            db.open();
            String sql = "SELECT * FROM categorias";
            PreparedStatement ps = db.getConnetion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categorias.add(categoria);
            }
        } catch(SQLException error) {
            System.out.println("ERRO: " + error);
        } finally {
            db.close();
            return categorias;
        }
    }
    
}
