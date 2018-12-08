
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelBD;
import view.ViewBD;

public final class ControllerBD {

    ModelBD modelBD;
    ViewBD viewBD;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
            if (e.getSource() == viewBD.Jb_primero) {
                try {
                    jb_primero_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewBD.Jb_anterior) {
                try {
                    jb_anterior_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewBD.Jb_siguiente) {
                try {
                    jb_siguiente_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewBD.Jb_ultimo) {
                try {
                    jb_ultimo_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(e.getSource() == viewBD.Jb_guardar){
                try {
                    jb_guardar();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }else if(e.getSource() == viewBD.Jb_nuevo){
                jb_nuevo();
            }

        }

    };

    public ControllerBD(ModelBD modelE, ViewBD viewE) {
        this.modelBD = modelE;
        this.viewBD = viewE;
        initComponents();
        setActionListener();
        initDB();
    }    

    public void initDB(){
        modelBD.conectarDB();
        viewBD.Jtf_nombre.setText(modelBD.getNombre());
        viewBD.Jtf_email.setText(modelBD.getEmail());
    }

    public void initComponents() {
        viewBD.setLocationRelativeTo(null);
        viewBD.setTitle("Agenda MVC");
        viewBD.setVisible(true);
    }


    public void setActionListener() {
        viewBD.Jb_primero.addActionListener(actionListener);
        viewBD.Jb_anterior.addActionListener(actionListener);
        viewBD.Jb_siguiente.addActionListener(actionListener);
        viewBD.Jb_ultimo.addActionListener(actionListener);
        viewBD.Jb_guardar.addActionListener(actionListener);
        viewBD.Jb_nuevo.addActionListener(actionListener);
    }

 
    private void jb_primero_actionPerformed() throws SQLException {
        System.out.println("Action del boton jb_primero");
        modelBD.primerRegistro();
        viewBD.Jtf_nombre.setText(modelBD.getNombre());
        viewBD.Jtf_email.setText(modelBD.getEmail());

    }


    private void jb_anterior_actionPerformed() throws SQLException {
        System.out.println("Action del boton jb_anterior");
        modelBD.anteriorRegistro();
        viewBD.Jtf_nombre.setText(modelBD.getNombre());
        viewBD.Jtf_email.setText(modelBD.getEmail());
    }


    private void jb_ultimo_actionPerformed() throws SQLException {
        System.out.println("Action del boton jb_ultimo");
        modelBD.ultimoRegistro();
        viewBD.Jtf_nombre.setText(modelBD.getNombre());
        viewBD.Jtf_email.setText(modelBD.getEmail());
 
    }
    private void jb_siguiente_actionPerformed() throws SQLException {
        System.out.println("Action del boton jb_siguiente");
        modelBD.siguienteRegistro();
        viewBD.Jtf_nombre.setText(modelBD.getNombre());
        viewBD.Jtf_email.setText(modelBD.getEmail());
       
  
    }
    private void jb_guardar() throws SQLException {
        System.out.println("Action del boton jb_guardar");
        modelBD.setNombre(viewBD.Jtf_nombre.getText());
        modelBD.setEmail(viewBD.Jtf_email.getText());
        modelBD.guardarRegistro(modelBD.getNombre(),modelBD.getEmail());
        JOptionPane.showMessageDialog(viewBD, "Registro guardado correctamente");
        }

        private void jb_nuevo() {
            System.out.println("Action del boton jb_nuevo");
            modelBD.setEmail(null);
            modelBD.setNombre(null);
            viewBD.Jtf_email.setText(modelBD.getEmail());
            viewBD.Jtf_nombre.setText(modelBD.getNombre());
            
        }
}
