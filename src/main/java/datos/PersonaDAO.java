package datos;

import domain.Persona;
import static datos.conexion.close;
import static datos.conexion.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    private static final String SQLSELECT = "SELECT id_perrsona,nombre,apellido,email,telefono FROM persona";
    private static final String SQLINSERT="INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?,?,?,?)";
    private static final String SQLUPDATE="UPDATE persona SET nombre=?,apellido=?,email=?,telefono=? WHERE id_persona=?";
    private static final String SQLDELETE="DELETE FROM persona WHERE id_persona=?";




    public List<Persona> seleccionar() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<Persona>();
        try {
            conn = conexion.getConnection();
           // System.out.println(conn);
            stmt = conn.prepareStatement(SQLSELECT);
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            //System.out.println(rs);
            while (rs.next()) {

                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }finally {
            try {
                close(rs);
                close(stmt);
                close(conn);

            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }

        return personas;
    }

    public int insertar(Persona persona){
         Connection conn=null;
         PreparedStatement stmt =null;
         int registro=0;

        try {
            conn=getConnection();
            stmt=conn.prepareStatement(SQLINSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            registro=stmt.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        } finally {

            try {
                close(stmt);
                close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }

       }

    return registro;
    }

    public  int  updatePersona (Persona persona){

        int registro=0;
        Connection conn = null;
        PreparedStatement stmt=null;

        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQLUPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            stmt.setInt(5,persona.getIdPersona());
            registro=stmt.executeUpdate();



        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }


        return registro;
    }




    public  int  deletePersona(Persona persona){

        int registro=0;
        Connection conn = null;
        PreparedStatement stmt=null;

        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQLDELETE);
            stmt.setInt(5,persona.getIdPersona());
            registro=stmt.executeUpdate();



        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }


        return registro;
    }





}




