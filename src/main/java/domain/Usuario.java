package domain;

public class Usuario {
    private int  idUsuario;
    private String usuairo;
    private String Password;

    public Usuario(int idUsuario, String usuairo, String password) {
        this.idUsuario = idUsuario;
        this.usuairo = usuairo;
        Password = password;
    }

    public Usuario(String usuairo, String password) {
        this.usuairo = usuairo;
        Password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public Usuario setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public String getUsuairo() {
        return usuairo;
    }

    public Usuario setUsuairo(String usuairo) {
        this.usuairo = usuairo;
        return this;
    }

    public String getPassword() {
        return Password;
    }

    public Usuario setPassword(String password) {
        Password = password;
        return this;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", usuairo='" + usuairo + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

}
