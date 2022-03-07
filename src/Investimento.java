import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Calendar;

public class Investimento extends JFrame {

    JLabel IDLabel, passwordLabel;
    private JLabel statusBar, background;
    int ds, dia, mes, ano;
    Calendar data;
    String diasemana[] = {"Domingo", "Sengunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
    String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

    JPanel painel1 = new JPanel();


    public static void main(String[] args) {
        JFrame janela = new Investimento();
        janela.setUndecorated(true);
        janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);


    }

    public Investimento() {
        setTitle("It´s Money not magic...");
        setBounds(270, 50, 260, 130);
        setSize(907, 688);
        setLocationRelativeTo(null);
        ImageIcon icone = new ImageIcon("src/images/GGtosLogo.png");
        setIconImage(icone.getImage());
        setResizable(false);
        ImageIcon img = new ImageIcon("src/images/StockExchange.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 890, 640);
        add(background);
        painel1.setLayout(new FlowLayout(FlowLayout.LEFT));


        painel1.setLayout(null);
        getContentPane().add(painel1);

        data = Calendar.getInstance();
        ds = data.get(Calendar.DAY_OF_WEEK);
        dia = data.get(Calendar.DAY_OF_MONTH);
        mes = data.get(Calendar.MONTH);
        ano = data.get(Calendar.YEAR);

        statusBar = new JLabel("Gringotts, Beco Diagonal, hoje é dia " + diasemana[ds - 1] + "," + dia + " de " + meses[mes] + " de " + ano + ".");
        add(statusBar, BorderLayout.SOUTH);
        statusBar.setForeground(Color.BLACK);


    }
}