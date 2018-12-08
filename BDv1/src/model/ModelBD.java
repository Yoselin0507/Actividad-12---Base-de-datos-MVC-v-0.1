package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelBD {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String nombre;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda_mvc", "user_mvc", "pass_mvc.2018");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM contactos;");
            rs.next();
            nombre = rs.getString("nombre");
            email = rs.getString("email");
            this.setEmail(email);
            this.setNombre(nombre);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 001: " + err.getMessage());
        }

    }

    public void primerRegistro() throws SQLException {
        System.out.print("Programa accion cambiarPrimerRegistro");
        rs.first();
        this.setNombre(rs.getString("nombre"));
        this.setEmail(rs.getString("email"));
    }

    public void siguienteRegistro() throws SQLException {
        System.out.print("Programa accion cambiarSiguienteRegistro");
        if (!rs.isLast()) {
            rs.next();
        }
        this.setNombre(rs.getString("nombre"));
        this.setEmail(rs.getString("email"));
    }

    public void anteriorRegistro() throws SQLException {
        System.out.print("Programa accion cambiarAnteriorRegistro");
        if (!rs.isFirst()) {
            rs.previous();
        }
        this.setNombre(rs.getString("nombre"));
        this.setEmail(rs.getString("email"));
    }

    public void ultimoRegistro() throws SQLException {
        System.out.print("Programa accion cambiarUltimoRegistro");
        rs.last();
        this.setNombre(rs.getString("nombre"));
        this.setEmail(rs.getString("email"));
    }

    public void guardarRegistro(String nombre, String email) throws SQLException {
        System.out.println("Programa accion guaradrRegistro");
        st.executeUpdate("INSERT INTO contactos(nombre,email) VALUES" + "('" + nombre + "','" + email + "');");
        this.conectarDB();
    }
}

