package datos;

import domain.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private static final String SQLSELECCIONAR=" SELECT id_usuario,usuario,password FROM usuarios ";


    public static List<Usuario> seleccionar(){

        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Usuario usuario=null;
        List<Usuario> usuarios=new ArrayList<Usuario>();


        try {
            conn=conexion.getConnection();
            stmt=conn.prepareStatement(SQLSELECCIONAR);
            rs=stmt.executeQuery();

            while (rs.next()){
                int idUsuario=rs.getInt("id_usuario");
                String usuario1=rs.getString("usuario");
                String password1=rs.getString("password");
                usuario=new Usuario(idUsuario,usuario1,password1);
                usuarios.add(usuario);






            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return usuarios;
    }


}
