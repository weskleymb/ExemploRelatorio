package view;

import controller.MovimentacaoRelatorio;
import dao.MovimentacaoDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import model.Movimentacao;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import util.DataBase;

public class Principal extends JFrame {
    
    private JButton btMostrar;
    
    public Principal() {
        inicializarComponentes();
        definirEventos();
    }
    
    private void inicializarComponentes() {
        setTitle("Teste de Relatório");
        setResizable(false);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        
        btMostrar = new JButton("Mostrar Relatório");
        btMostrar.setBounds(100, 150, 200, 50);
        add(btMostrar);
    }
    
    private void definirEventos() {
        btMostrar.addActionListener((ActionEvent e) -> {
            exibirRelatorio();
        });
    }
    
    private static void abrir() {
        Principal janela = new Principal();
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dimensao.width - janela.getSize().width) / 2;
        int y = (dimensao.height - janela.getSize().height) / 2;
        janela.setLocation(x, y);
        janela.setVisible(true);
    }
    
    private void exibirRelatorio() {
        DataBase db = new DataBase();
        db.open();
        String endereco = "./src/report/relatorio1.jasper";
        Connection conexao = db.getConnetion();
        try {
            Map<String, Object> parametros = new HashMap();
            List<Movimentacao> movimentacoes = new MovimentacaoDAO().selectAll();
            List<MovimentacaoRelatorio> listaRelatorio = new ArrayList();
            for (Movimentacao movimentacao : movimentacoes) {
                listaRelatorio.add(new MovimentacaoRelatorio(movimentacao));
            }
            JRDataSource dataSource = new JRBeanCollectionDataSource(listaRelatorio);
            JasperPrint impressao = JasperFillManager.fillReport(endereco, parametros, dataSource);
            JasperViewer visualizador = new JasperViewer(impressao, false);
            visualizador.setTitle("Relatório de Movimentações");
            visualizador.setVisible(true);
        } catch (JRException error) {
            System.out.println("Erro:" + error);
        } finally {
            db.close();
        }
//        for (Movimentacao movimentacao : new MovimentacaoDAO().selectAll()) {
//            System.out.println(new MovimentacaoRelatorio(movimentacao));
//        }
    }

    public static void main(String[] args) {
        abrir();
    }

}
