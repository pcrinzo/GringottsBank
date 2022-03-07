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

public class LoginCli extends JFrame implements ActionListener {

        JLabel IDLabel, passwordLabel;
        static JTextField cpfT;
        static MaskFormatter maskID;
        static JButton login;
        static JPasswordField password;
        private JLabel statusBar, background;
        int ds, dia, mes, ano;
        Calendar data;
        String diasemana[] = {"Domingo", "Sengunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
        String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        JPanel painel1 = new JPanel();




        public static void main(String[] args) {
                JFrame janela = new LoginCli();
                janela.setUndecorated(true);
                janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setVisible(true);


        }

        public LoginCli() {
                setTitle("It´s Money not magic...");
                setBounds(270, 50, 260, 130);
                setSize(907, 688);
                setLocationRelativeTo(null);
                ImageIcon icone = new ImageIcon("src/images/GGtosLogo.png");
                setIconImage(icone.getImage());
                setResizable(false);
                ImageIcon img = new ImageIcon("src/images/GringottsLogin.png");
                background = new JLabel("", img, JLabel.CENTER);
                background.setBounds(0, 0, 890, 640);
                add(background);
                painel1.setLayout(new FlowLayout(FlowLayout.LEFT));

                IDLabel = new JLabel("Digite o CPF");
                passwordLabel = new JLabel("Digite a senha");
                cpfT = new JTextField(11);
                painel1.add(cpfT);
                password = new JPasswordField(10);
                painel1.add(password);

                login = new JButton("Acessar Conta");
                painel1.add(login);
                login.addActionListener(this);

                try {
                        maskID = new MaskFormatter("###.###.###-##");
                        maskID.setPlaceholderCharacter('_');

                } catch (ParseException err) {
                        System.err.println("Erro na formatação: " + err.getMessage());
                        System.exit(-1);
                }

                cpfT = new JFormattedTextField(maskID);
                painel1.add(cpfT);


                setBounds();
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

        private void setBounds() {
                cpfT.setBounds(504, 342, 330, 65);
                password.setBounds(504, 485, 330, 65);
                login.setBounds(560, 580, 200, 50);

        }


        public void actionPerformed(ActionEvent e) {
                if (e.getSource()==login){
//                        Connection c = null;
//            Statement stmt = null;
//            try {
//                Class.forName("org.postgresql.Driver");
//                c = DriverManager
//                        .getConnection("jdbc:postgresql://localhost:5432/gringotts",
//                                "postgres", "dsacademy");
//                c.setAutoCommit(false);
//                System.out.println("Opened database successfully");
//                stmt = c.createStatement();
//                String sql = "SELECT s.saldo_ccorrente FROM usuario_senha u INNER JOIN saldos s ON u.cpf='123456789-10'";
////                        LoginCli.cpfT.getText()+"';";
//                resultSet =stmt.executeQuery(sql);
//                resultSet.next();

                        EntradaLogin janela = null;
                        janela = new EntradaLogin();
                        janela.setVisible(true);


//                        try {
//                                Class.forName("org.postgresql.Driver");
//                                c = DriverManager
//                                        .getConnection("jdbc:postgresql://localhost:5432/testdb",
//                                                "postgres", "dsacademy");
//                                c.setAutoCommit(false);
//                                System.out.println("Opened database successfully");
//                                stmt = c.createStatement();
//                                String sql = "SELECT * FROM usuario_senha WHERE nome='"+
//                                        cpfT+"','"+
//                                        password.getPassword()+"';";
//                                ResultSet resultSet = stmt.executeQuery(sql);
//                                resultSet.next();
//
//                        } catch (Exception erro) {
//                                System.err.println( erro.getClass().getName()+": "+ erro.getMessage() );
//                                System.exit(0);
//                        }
//                        System.out.println("Cliente Encontrado");
                }
//                try {
//
//                                if (e.getSource()==login||e.getSource()==cpfT){
//                                        Connection c = null;
//                                        Statement stmt = null;
//                                        try {
//                                                Class.forName("org.postgresql.Driver");
//                                                c = DriverManager
//                                                        .getConnection("jdbc:postgresql://localhost:5432/testdb",
//                                                                "postgres", "dsacademy");
//                                                c.setAutoCommit(false);
//                                                System.out.println("Opened database successfully");
//                                                stmt = c.createStatement();
//                                                String sql = "SELECT b.nome, s.senha FROM banco_clientes b INNER JOIN "+
//                                                        tCod.getText()+";";
//                                                resultSet=stmt.executeQuery(sql);
//                                                resultSet.next();
//                                                atualizaCampos();
//                                                EntradaLogin janela = null;
//                                                janela = new EntradaLogin();
//                                                janela.setVisible(true);
//
//                                        } catch (Exception erro) {
//                                                System.err.println( erro.getClass().getName()+": "+ erro.getMessage() );
//                                                System.exit(0);
//                                        }
//                                        System.out.println("Cliente Encontrado");
//                                }
//        }
//}
        }}

