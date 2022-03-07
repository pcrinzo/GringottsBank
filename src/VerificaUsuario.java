import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VerificaUsuario {

    public java.sql.Connection conectarBD()
    {
        java.sql.Connection conn=null;

        try
        {
            Class.forName("org.postgresql.Driver");
            conn= DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/seudatabase",
                            "yourusername", "yourpassword");
        }

        catch(Exception erro)
        {

        }
        return conn;
    }

    public String usuario="";
    public boolean resultado=false;
    public boolean VerificaUsuario(String usuario, String senha)
    {
        String consultaSQL= "";
        Connection conn=conectarBD();


        consultaSQL="select * from usuario_senha where cpf ="+"'"+LoginCli.cpfT+"' "+"and senha="+"'"+LoginCli.password+"' ;";

        try
        {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(consultaSQL);

            if(rs.next())
            {
                resultado=true;
                EntradaLogin janela = null;
                janela = new EntradaLogin();
                janela.setVisible(true);;

            }}

        catch (Exception erro)
        {

        }
        return resultado;
    }

}


