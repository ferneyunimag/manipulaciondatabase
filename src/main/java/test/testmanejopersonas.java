package test;

import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class testmanejopersonas {

    public static void main(String[] args) {


        PersonaDAO personaDAO=new PersonaDAO();

        Persona personanueva= new Persona("carlos","mantilla","cmantilla@email.com","4331193");
        personaDAO.insertar(personanueva);



        Persona personamodificar =new Persona(3,"arturo","venavidez","enamnue@correo","12349884");
        personaDAO.updatePersona(personamodificar);

        personaDAO.deletePersona(personamodificar);
        List<Persona> personas=personaDAO.seleccionar();
        for (Persona persona:personas) System.out.println(persona);


    }

}
