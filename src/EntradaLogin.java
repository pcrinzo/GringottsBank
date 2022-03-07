import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Calendar;

import static javax.swing.text.StyleConstants.Bold;
import static javax.swing.text.StyleConstants.FontFamily;

public class EntradaLogin extends JFrame implements ActionListener {

    JLabel IDLabel, passwordLabel;
    static JButton CCButton, PButton, TButton, CreditButton, IButton, SButton;
    private JLabel statusBar,background;
    static JTextField Tvalores;
    int ds, dia, mes, ano;
    Calendar data;
    String diasemana[] = {"Domingo", "Sengunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
    String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

    JPanel painel1= new JPanel();
    ResultSet resultSet;


    public static void main(String[] args) {
        JFrame janela = new LoginCli();
        janela.setUndecorated(true);
        janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);


    }

    public EntradaLogin() {
        setTitle("Your bank in the palm of your wands!");
        setBounds(270, 0, 390, 150);
        setSize(960, 740);
        setLocationRelativeTo(null);
        ImageIcon icone = new ImageIcon("src/images/GGtosLogo.png");
        setIconImage(icone.getImage());
        setResizable(false);
        ImageIcon img = new ImageIcon("src/images/BancoMain.png");
        background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(-50,0,1050,680);
        add(background);
        painel1.setLayout(new FlowLayout(FlowLayout.LEFT));


        data = Calendar.getInstance();
        ds = data.get(Calendar.DAY_OF_WEEK);
        dia = data.get(Calendar.DAY_OF_MONTH);
        mes = data.get(Calendar.MONTH);
        ano = data.get(Calendar.YEAR);

        statusBar = new JLabel("Gringotts, Beco Diagonal, hoje é dia " + diasemana[ds - 1] + "," + dia + " de " + meses[mes] + " de " + ano + ".");
        add(statusBar, BorderLayout.SOUTH);
        statusBar.setForeground(Color.BLACK);

        Font myFont = new Font("Abadi", Font.BOLD, 30);
        CCButton = new JButton("Saldo");
        CCButton.setBackground(Color.WHITE);
        CCButton.setFont(myFont);
        CCButton.setBorderPainted(false);

        TButton = new JButton("Transfêrencia");
        TButton.setBackground(Color.WHITE);
        TButton.setFont(myFont);
        TButton.setBorderPainted(false);

        PButton = new JButton("Poupança");
        PButton.setBackground(Color.WHITE);
        PButton.setFont(myFont);
        PButton.setBorderPainted(false);

        IButton= new JButton("Investimentos");
        IButton.setBackground(Color.WHITE);
        IButton.setFont(myFont);
        IButton.setBorderPainted(false);

        CreditButton= new JButton("Fatura");
        CreditButton.setBackground(Color.WHITE);
        CreditButton.setFont(myFont);
        CreditButton.setBorderPainted(false);

        SButton = new JButton("Sair");
        SButton.setBackground(Color.WHITE);
        SButton.setFont(myFont);
        SButton.setBorderPainted(false);

        Tvalores = new JTextField();
        Tvalores.setFont(myFont);



        painel1.add(CCButton);CCButton.addActionListener(this);
        painel1.add(TButton);TButton.addActionListener(this);
        painel1.add(PButton); PButton.addActionListener(this);
        painel1.add(CreditButton); CreditButton.addActionListener(this);
        painel1.add(IButton); IButton.addActionListener(this);
        painel1.add(SButton); SButton.addActionListener(this);
        painel1.add(Tvalores);
        Tvalores.setEditable(false);
        Tvalores.setBackground(Color.WHITE);


        setBounds();
        painel1.setLayout(null);
        getContentPane().add(painel1);




    }

    private void setBounds() {
        Tvalores.setBounds(120,55,200,60);
        CCButton.setBounds(90,330,200,60);
        TButton.setBounds(90,450,250,60);
        PButton.setBounds(90,570,250,60);
        CreditButton.setBounds(610,330,200,60);
        IButton.setBounds(610,450,250,60);
        SButton.setBounds(610,570,200,60);

    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==SButton)
        {
                System.exit(0);
        }
        if (e.getSource()==CCButton){
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/gringotts",
                                "postgres", "dsacademy");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                String sql = "SELECT s.saldo_ccorrente FROM usuario_senha u INNER JOIN saldos s ON u.cpf='123456789-10'";
//                        cpfT.getText()+"';";  //para uso futuro
                resultSet =stmt.executeQuery(sql);
                resultSet.next();
                try{

                 Tvalores.setText(String.valueOf(resultSet.getDouble("saldo_ccorrente")));}catch (SQLException erro){};


           } catch (Exception erro) {
                System.err.println( erro.getClass().getName()+": "+ erro.getMessage() );
                System.exit(0);
         }
          System.out.println("Cliente Encontrado");
        }
        if (e.getSource()==PButton){

            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/gringotts",
                                "postgres", "dsacademy");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                String sql = "SELECT s.saldo_poupanca FROM usuario_senha u INNER JOIN saldos s ON u.cpf='123456789-10'";
//                        cpfT.getText()+"';";  //para uso futuro
                resultSet =stmt.executeQuery(sql);
                resultSet.next();
                try{

                    Tvalores.setText(String.valueOf(resultSet.getDouble("saldo_poupanca")));}catch (SQLException erro){};


            } catch (Exception erro) {
                System.err.println( erro.getClass().getName()+": "+ erro.getMessage() );
                System.exit(0);
            }
            System.out.println("Cliente Encontrado");
        }

        if (e.getSource()==CreditButton){


            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/gringotts",
                                "postgres", "dsacademy");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                String sql = "SELECT s.fatura_cartao FROM usuario_senha u INNER JOIN saldos s ON u.cpf='123456789-10'";
//                        cpfT.getText()+"';";  //para uso futuro
                resultSet =stmt.executeQuery(sql);
                resultSet.next();
                try{
                    Tvalores.setForeground(Color.ORANGE);
                    Tvalores.setText(String.valueOf(resultSet.getDouble("fatura_cartao")));}catch (SQLException erro){};


            } catch (Exception erro) {
                System.err.println( erro.getClass().getName()+": "+ erro.getMessage() );
                System.exit(0);
            }
            System.out.println("Cliente Encontrado");
        }

        if (e.getSource()==TButton){
            Connection c = null;
            Statement stmt = null;
            String valor, contaDestino;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/gringotts",
                                "postgres", "dsacademy");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                contaDestino=JOptionPane.showInputDialog("Qual a conta destino?");
                valor=JOptionPane.showInputDialog("Qual valor deseja transferir?");
                String sql = "SELECT s.saldo_ccorrente -"+valor+" AS saldo_novo FROM usuario_senha u INNER JOIN saldos s ON u.cpf='123456789-10'";
//                        cpfT.getText()+"';";  //para uso futuro
                resultSet =stmt.executeQuery(sql);
                resultSet.next();
                try{

                    Tvalores.setText(String.valueOf(resultSet.getDouble("saldo_novo")));}catch (SQLException erro){};


            } catch (Exception erro) {
                System.err.println( erro.getClass().getName()+": "+ erro.getMessage() );
                System.exit(0);
            }
            System.out.println("Cliente Encontrado");
        }

        if (e.getSource()==IButton)
        {
            Investimento janela = null;
            janela = new Investimento();
            janela.setVisible(true);
        }


    }
}



