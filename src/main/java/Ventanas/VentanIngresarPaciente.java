package Ventanas;

import javax.swing.*;

class VentanaIngresarPaciente extends JFrame {
    private JTextField textFieldNombre;
    private JTextField textFieldRut;
    private JTextField textFieldTipoSangre;
    private JTextField textFieldEstadoCivil;
    private JTextField textFieldDireccion;
    private JTextField textFieldEnfermedad;
    private JTextField textFieldPassword;

    public VentanaIngresarPaciente() {
        setTitle("Ingresar como Paciente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 80, 25);
        panel.add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(120, 30, 200, 25);
        panel.add(textFieldNombre);

        JLabel lblRut = new JLabel("RUT:");
        lblRut.setBounds(30, 70, 80, 25);
        panel.add(lblRut);

        textFieldRut = new JTextField();
        textFieldRut.setBounds(120, 70, 200, 25);
        panel.add(textFieldRut);

        JLabel lblTipoSangre = new JLabel("Tipo de Sangre:");
        lblTipoSangre.setBounds(30, 110, 100, 25);
        panel.add(lblTipoSangre);

        textFieldTipoSangre = new JTextField();
        textFieldTipoSangre.setBounds(120, 110, 200, 25);
        panel.add(textFieldTipoSangre);

        JLabel lblEstadoCivil = new JLabel("Estado Civil:");
        lblEstadoCivil.setBounds(30, 150, 80, 25);
        panel.add(lblEstadoCivil);

        textFieldEstadoCivil = new JTextField();
        textFieldEstadoCivil.setBounds(120, 150, 200, 25);
        panel.add(textFieldEstadoCivil);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(30, 190, 80, 25);
        panel.add(lblDireccion);

        textFieldDireccion = new JTextField();
        textFieldDireccion.setBounds(120, 190, 200, 25);
        panel.add(textFieldDireccion);

        JLabel lblEnfermedad = new JLabel("Enfermedad:");
        lblEnfermedad.setBounds(30, 230, 80, 25);
        panel.add(lblEnfermedad);

        textFieldEnfermedad = new JTextField();
        textFieldEnfermedad.setBounds(120, 230, 200, 25);
        panel.add(textFieldEnfermedad);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(30, 270, 80, 25);
        panel.add(lblPassword);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(120, 270, 200, 25);
        panel.add(textFieldPassword);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(150, 320, 100, 30);
        panel.add(btnRegistrar);

        btnRegistrar.addActionListener(e -> registrarPaciente());
    }

    private void registrarPaciente() {
        // Obtener los datos de los campos y realizar el registro
        String nombre = textFieldNombre.getText();
        String rut = textFieldRut.getText();
        String tipoSangre = textFieldTipoSangre.getText();
        String estadoCivil = textFieldEstadoCivil.getText();
        String direccion = textFieldDireccion.getText();
        String enfermedad = textFieldEnfermedad.getText();
        String password = textFieldPassword.getText();

        // Aquí iría la lógica para registrar al paciente con los datos obtenidos

        // Por ejemplo, simplemente mostraremos los datos en la consola
        System.out.println("Nombre: " + nombre);
        System.out.println("RUT: " + rut);
        System.out.println("Tipo de Sangre: " + tipoSangre);
        System.out.println("Estado Civil: " + estadoCivil);
        System.out.println("Dirección: " + direccion);
        System.out.println("Enfermedad: " + enfermedad);
        System.out.println("Contraseña: " + password);
    }
}
