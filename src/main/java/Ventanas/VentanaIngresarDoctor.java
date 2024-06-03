package Ventanas;
import javax.swing.*;

public class VentanaIngresarDoctor extends JFrame {
    private JTextField textFieldNombre;
    private JTextField textFieldEspecialidad;

    public VentanaIngresarDoctor() {
        setTitle("Ingresar como Doctor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 50, 80, 25);
        panel.add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(120, 50, 200, 25);
        panel.add(textFieldNombre);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(30, 100, 80, 25);
        panel.add(lblEspecialidad);

        textFieldEspecialidad = new JTextField();
        textFieldEspecialidad.setBounds(120, 100, 200, 25);
        panel.add(textFieldEspecialidad);
    }
}
