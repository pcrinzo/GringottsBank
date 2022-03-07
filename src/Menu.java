import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Calendar;

public class Menu extends JFrame implements ActionListener {


    JMenu menuCadastro, menuAcessoBanco;
    JMenuItem miCliente, miFuncionarios, miSair, miAcCliente;
    JMenuBar MenuBar1;
    private JLabel statusBar,background;
    int ds, dia, mes, ano;
    Calendar data;
    String diasemana[] = {"Domingo", "Sengunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
    String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};



    public static void main(String[] args) {
        JFrame janela = new Menu();
        janela.setUndecorated(true);
        janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);


    }

    public Menu() {
        setTitle("Menu Principal");
        setBounds(370, 280, 270, 1000);
        setSize(887, 668);
        setLocationRelativeTo(null);
        ImageIcon icone = new ImageIcon("src/images/GGTosLogo.png");
        setIconImage(icone.getImage());
        setResizable(false);
        ImageIcon img = new ImageIcon("src/images/Gringotts12.png");
        background= new JLabel("", img,JLabel.CENTER);
        background.setBounds(300,300,700,1000);
        add(background);


        data = Calendar.getInstance();
        ds = data.get(Calendar.DAY_OF_WEEK);
        dia = data.get(Calendar.DAY_OF_MONTH);
        mes = data.get(Calendar.MONTH);
        ano = data.get(Calendar.YEAR);

        statusBar = new JLabel("Gringotts, Beco Diagonal, hoje é dia " + diasemana[ds - 1] + "," + dia + " de " + meses[mes] + " de " + ano + ".");
        add(statusBar, BorderLayout.SOUTH);
        statusBar.setForeground(Color.BLACK);

        MenuBar1 = new JMenuBar();
        menuCadastro = new JMenu("Cadastro");
        menuAcessoBanco = new JMenu("Acessar Banco");

        miCliente = new JMenuItem("Clientes");
        miCliente.addActionListener(this);
        miCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
        miCliente.setMnemonic(KeyEvent.VK_L);

        miFuncionarios = new JMenuItem("Empresas");
        miFuncionarios.addActionListener(this);
        miFuncionarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
        miFuncionarios.setMnemonic(KeyEvent.VK_F);


        miSair = new JMenuItem("Sair");
        miSair.addActionListener(this);
        miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        miSair.setMnemonic(KeyEvent.VK_S);

        menuCadastro.add(miCliente);
        menuCadastro.add(miFuncionarios);
        menuCadastro.addSeparator();
        menuCadastro.add(miSair);

        miAcCliente = new JMenuItem("Clientes");
        miAcCliente.addActionListener(this);
        miAcCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
        miAcCliente.setMnemonic(KeyEvent.VK_C);


        menuAcessoBanco.add(miAcCliente);


        MenuBar1.add(menuCadastro);
        MenuBar1.add(menuAcessoBanco);

        setJMenuBar(MenuBar1);


    }



    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==miSair)
        {

            int opcao;
            Object[] botoes = {"Sim","Não"};
            opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo sair ? ","Fechar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
            if (opcao==JOptionPane.YES_OPTION)
                System.exit(0);
        }

        if(e.getSource()==miAcCliente)
        {

            // instanciar
            LoginCli janela = null;
            janela = new LoginCli();
            // apresentar
            janela.setVisible(true);
        }

        if(e.getSource()==miCliente)
        {

            CadastroCliente janela = null;
            try {
                janela = new CadastroCliente();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            janela.setVisible(true);
        }


    }
}

