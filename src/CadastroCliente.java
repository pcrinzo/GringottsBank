import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;


public class CadastroCliente extends JFrame implements ActionListener {
    //1.Criando Labels
    JLabel ltitulo, lcodfunc, lnomefunc, ldtnascfun, lsexofunc, ldocfunc, luffuncdoc, lmaefunc,
            lpaifunc, lcivilfunc, lcidadefunc, luf, lendfunc, lbairrofunc, locupfunc, luffunclnumfunc,
            lcepfunc, lcompletfunc, ltelfunc, lobsfunc, ldtcadfunc, lagencia, lconta;

    //2.Criando TextFields
    static JTextField tcodfunc, tnomefunc, tdocfunc, tmaefunc, tpaifunc, tcidadefunc,
            tendfunc, tbairrofunc, tocupfunc, tnumfunc, tcompletfunc, tagencia, tconta;

    static JFormattedTextField tcepfunc, ttelfunc, tnascfun, tdcadfunc;

    static MaskFormatter mascaratcepfunc, mascarattelfunc, mascaratnascfunc,
            mascaratdtcadfunc;

    static String sexo[] = {"", "Feminino", "Masculino"};

    //Criando ComboBox
    static JComboBox uffuncdoc, civilfunc, uffunc, sexofunc;

    static JButton btnovo, btcadastrar, btexcluir, btalterar, btprocurar, btcancelar, btsair;

    String estados[] = {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MT", "MS", "PA", "PB", "PE", "PI", "RO", "RR", "RR", "RJ", "RS", "SC", "SE", "TO"};

    String estadocivil[] = {"", "Solteiro", "Casado", "Divorciado", "Viuvo"};

    String estadofunc[] = {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MT", "MS", "PA", "PB", "PE", "PI", "RO", "RR", "RR", "RJ", "RS", "SC", "SE", "TO"};

    //definindo um scrollbar para o campo "Observação"
    static JTextArea obsfunc = new JTextArea(20, 20);
    JScrollPane scroll = new JScrollPane(obsfunc);


    JPanel painel1 = new JPanel();

    public static void main(String[] args) throws ParseException {
        JFrame janela = new CadastroCliente();
        janela.setUndecorated(true);
        janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

        //criando um ícone para o programa
        ImageIcon iconeprograma = new ImageIcon("src/images/logopart1azul.png");
        janela.setIconImage(iconeprograma.getImage());


    }

    CadastroCliente() throws ParseException {

        //Título e formatação do tamanho da janela:
        setTitle("Cadastro de Clientes");
        setBounds(400, 100, 920, 750);
        painel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImageIcon icone = new ImageIcon("src/images/logopart1azul.png");
        setIconImage(icone.getImage());

        //Label título :
        ltitulo = new JLabel("Cadastro de Clientes");
        ltitulo.setForeground(Color.blue);
        Font f = new Font("TimesRoman", Font.BOLD, 25);
        ltitulo.setFont(f);
        setResizable(false);


        //ComboBox de Estados Doc, Estados para Funcionários, Sexo Doc
        uffuncdoc = new JComboBox(estados);
        uffuncdoc.setMaximumRowCount(5);
        uffunc = new JComboBox(estadofunc);
        uffunc.setMaximumRowCount(5);
        sexofunc = new JComboBox(sexo);
        sexofunc.setMaximumRowCount(3);
        civilfunc = new JComboBox(estadocivil);
        civilfunc.setMaximumRowCount(4);


        //Formatando JLabel e JTextFields
        lcodfunc = new JLabel("Código:");
        tcodfunc = new JTextField(6);
        lnomefunc = new JLabel("Nome:");
        tnomefunc = new JTextField(30);
        lsexofunc = new JLabel("Sexo:");
        ldtnascfun = new JLabel("Dt. Nasc:");
        ldocfunc = new JLabel("Documento:");
        tdocfunc = new JTextField(11);
        luffuncdoc = new JLabel("UF Doc: ");
        lcivilfunc = new JLabel("Estado Civil: ");
        lmaefunc = new JLabel("Nome da Mãe: ");
        tmaefunc = new JTextField(30);
        lpaifunc = new JLabel("Nome do Pai: ");
        tpaifunc = new JTextField(30);
        lcidadefunc = new JLabel("Cidade:");
        tcidadefunc = new JTextField(20);
        luf = new JLabel("UF:");
        lendfunc = new JLabel("Endereço:");
        tendfunc = new JTextField(30);
        luffunclnumfunc = new JLabel("Número:");
        tnumfunc = new JTextField(5);
        lcompletfunc = new JLabel("Complemento:");
        tcompletfunc = new JTextField(20);
        lbairrofunc = new JLabel("Bairro:");
        tbairrofunc = new JTextField(10);
        lcepfunc = new JLabel("CEP:");
        locupfunc = new JLabel("Ocupação:");
        tocupfunc = new JTextField(20);
        ltelfunc = new JLabel("Tel:");
        lobsfunc = new JLabel("Observações: ");
        ldtcadfunc = new JLabel("Dt. Cadastro: ");
        lagencia = new JLabel("Agencia: ");
        tagencia = new JTextField(10);
        lconta = new JLabel("Conta:");
        tconta = new JTextField(10);


        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.getViewport().add(obsfunc);


        //Criando "Máscaras:

        try {

            mascaratdtcadfunc = new MaskFormatter("####-##-##");
            mascaratdtcadfunc.setPlaceholderCharacter('_');
            mascaratcepfunc = new MaskFormatter("#####-###");
            mascaratcepfunc.setPlaceholderCharacter('_');
            mascarattelfunc = new MaskFormatter("(##)#####-####");
            mascarattelfunc.setPlaceholderCharacter('_');
            mascaratnascfunc = new MaskFormatter("####-##-##");
            mascaratnascfunc.setPlaceholderCharacter('_');
        } catch (ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }

        //Criando TextFields com "Máscaras":

        tnascfun = new JFormattedTextField(mascaratnascfunc);
        tcepfunc = new JFormattedTextField(mascaratcepfunc);
        tdcadfunc = new JFormattedTextField(mascaratdtcadfunc);
        ttelfunc = new JFormattedTextField(mascarattelfunc);


        //Criando botões
        btnovo = new JButton("Novo", new ImageIcon("src/novo.PNG"));
        btcadastrar = new JButton("Cadastrar", new ImageIcon("src/cadstrorz.PNG"));
        btexcluir = new JButton("Excluir", new ImageIcon("src/Excluir.PNG"));
        btalterar = new JButton("Alterar", new ImageIcon("src/zAlterar.PNG"));
        btprocurar = new JButton("Procurar", new ImageIcon("src/procurar.PNG"));
        btcancelar = new JButton("Cancelar", new ImageIcon("src/cancelar.PNG"));
        btsair = new JButton("Sair", new ImageIcon("src/sair.PNG"));

        //Adicionando eventos "ações" para os botões
        btnovo.addActionListener(this);
        btcadastrar.addActionListener(this);
        btexcluir.addActionListener(this);
        btalterar.addActionListener(this);
        btprocurar.addActionListener(this);
        btcancelar.addActionListener(this);
        btsair.addActionListener(this);


        //Adicionando os elementos no painel "Frame"
        painel1.add(ltitulo);
        painel1.add(lcodfunc);
        painel1.add(tcodfunc);
        painel1.add(lnomefunc);
        painel1.add(tnomefunc);
        painel1.add(uffunc);
        painel1.add(lsexofunc);
        painel1.add(sexofunc);
        painel1.add(ldtnascfun);
        painel1.add(tnascfun);
        painel1.add(ldocfunc);
        painel1.add(tdocfunc);
        painel1.add(luffuncdoc);
        painel1.add(uffuncdoc);
        painel1.add(lcivilfunc);
        painel1.add(civilfunc);
        painel1.add(lmaefunc);
        painel1.add(tmaefunc);
        painel1.add(lpaifunc);
        painel1.add(tpaifunc);
        painel1.add(lcidadefunc);
        painel1.add(tcidadefunc);
        painel1.add(luf);
        painel1.add(uffunc);
        painel1.add(lendfunc);
        painel1.add(tendfunc);
        painel1.add(luffunclnumfunc);
        painel1.add(tnumfunc);
        painel1.add(lcompletfunc);
        painel1.add(tcompletfunc);
        painel1.add(lbairrofunc);
        painel1.add(tbairrofunc);
        painel1.add(lcepfunc);
        painel1.add(tcepfunc);
        painel1.add(locupfunc);
        painel1.add(tocupfunc);
        painel1.add(ltelfunc);
        painel1.add(ttelfunc);
        painel1.add(lobsfunc);
        painel1.add(obsfunc);
        painel1.add(scroll);
        painel1.add(ldtcadfunc);
        painel1.add(tdcadfunc);
        painel1.add(lagencia);
        painel1.add(tagencia);
        painel1.add(lconta);
        painel1.add(tconta);


        //Adicionando botões:
        painel1.add(btnovo);
        painel1.add(btcadastrar);
        painel1.add(btexcluir);
        painel1.add(btalterar);
        painel1.add(btprocurar);
        painel1.add(btsair);
        painel1.add(btcancelar);

        //Criando uma classe para posicionar os elementos no painel "Frame"
        setBounds();
        painel1.setLayout(null);
        getContentPane().add(painel1);


    }

    //Classe de posições do elemento
    public void setBounds() {
        ltitulo.setBounds(300, 50, 500, 30);
        lcodfunc.setBounds(20, 100, 100, 30);
        tcodfunc.setBounds(95, 100, 100, 30);
        lagencia.setBounds(200, 100, 100, 30);
        tagencia.setBounds(250, 100, 100, 30);
        lconta.setBounds(360, 100, 100, 30);
        tconta.setBounds(400, 100, 100, 30);
        lnomefunc.setBounds(20, 150, 100, 30);
        tnomefunc.setBounds(95, 150, 400, 30);
        lsexofunc.setBounds(500, 150, 100, 30);
        sexofunc.setBounds(550, 150, 100, 30);
        ldtnascfun.setBounds(670, 150, 100, 30);
        tnascfun.setBounds(730, 150, 100, 30);
        ldocfunc.setBounds(10, 200, 100, 30);
        tdocfunc.setBounds(95, 200, 100, 30);
        luffuncdoc.setBounds(200, 200, 100, 30);
        uffuncdoc.setBounds(250, 200, 100, 30);
        lcivilfunc.setBounds(370, 200, 100, 30);
        civilfunc.setBounds(450, 200, 100, 30);
        lmaefunc.setBounds(10, 250, 100, 30);
        tmaefunc.setBounds(95, 250, 350, 30);
        lpaifunc.setBounds(450, 250, 100, 30);
        tpaifunc.setBounds(540, 250, 350, 30);
        lcidadefunc.setBounds(10, 300, 100, 30);
        tcidadefunc.setBounds(95, 300, 300, 30);
        luf.setBounds(420, 300, 100, 30);
        uffunc.setBounds(450, 300, 100, 30);
        lendfunc.setBounds(10, 350, 100, 30);
        tendfunc.setBounds(95, 350, 300, 30);
        luffunclnumfunc.setBounds(420, 350, 300, 30);
        tnumfunc.setBounds(480, 350, 100, 30);
        lcompletfunc.setBounds(600, 350, 150, 30);
        tcompletfunc.setBounds(690, 350, 200, 30);
        lbairrofunc.setBounds(10, 400, 100, 30);
        tbairrofunc.setBounds(95, 400, 300, 30);
        lcepfunc.setBounds(420, 400, 250, 30);
        tcepfunc.setBounds(450, 400, 100, 30);
        locupfunc.setBounds(10, 450, 100, 30);
        tocupfunc.setBounds(95, 450, 300, 30);
        ltelfunc.setBounds(420, 450, 300, 30);
        ttelfunc.setBounds(450, 450, 130, 30);
        lobsfunc.setBounds(10, 500, 100, 30);
//        obsfunc.setBounds(95,500,300,90);
        scroll.setBounds(95, 500, 315, 90);
        ldtcadfunc.setBounds(420, 500, 100, 30);
        tdcadfunc.setBounds(500, 500, 100, 30);
        btnovo.setBounds(150, 600, 150, 30);
        btcadastrar.setBounds(300, 600, 150, 30);
        btexcluir.setBounds(450, 600, 150, 30);
        btalterar.setBounds(600, 600, 150, 30);
        btprocurar.setBounds(230, 630, 150, 30);
        btcancelar.setBounds(380, 630, 150, 30);
        btsair.setBounds(530, 630, 150, 30);


    }

    //Classe de Eventos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btcadastrar) {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/yourdatabase",
                                "yourusername", "yourpassword");
                c.setAutoCommit(false);
                System.out.println("Banco de Dados acessado com sucesso!");
                stmt = c.createStatement();
                String sql = "INSERT INTO banco_clientes (codigo, agencia, conta, nome, sexo, data_nasc, documento," +
                        "uf_doc, estado_civil, nome_mae, nome_pai, cidade, uf_endereco, endereco, numero, complemento," +
                        "bairro, cep, ocupacao, tel, obs, dt_cad) "
                        + "VALUES ("+
                        tcodfunc.getText() + ",'" + tagencia.getText()+ "','" + tconta.getText() + "','" + tnomefunc.getText() + "','" +
                        sexofunc.getSelectedItem().toString()+ "','" + tnascfun.getText() + "','" + tdocfunc.getText() + "','" + uffuncdoc.getSelectedItem().toString()+ "','" +
                        civilfunc.getSelectedItem().toString()+ "','" + tmaefunc.getText() + "','" + tpaifunc.getText() + "','" + tcidadefunc.getText() + "','" +
                        uffunc.getSelectedItem().toString() + "','" + tendfunc.getText() + "','" + tnumfunc.getText() + "','" + tcompletfunc.getText() + "','" +
                        tbairrofunc.getText() + "','" + tcepfunc.getText() + "','" + tocupfunc.getText()+"','" + ttelfunc.getText() + "' ,'" + obsfunc.getText() + "','" + tdcadfunc.getText() +"');";
                stmt.executeUpdate(sql);
                stmt.close();
                c.commit();
                c.close();
            } catch (Exception erro) {
                System.err.println(erro.getClass().getName() + ": " + erro.getMessage());
                System.exit(0);
            }
            System.out.println("Dados inseridos corretamente!");
        }
    }
}