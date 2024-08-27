package practico3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {

    private JTextField userField;
    private JPasswordField passwordField;
    private JButton togglePasswordButton;

    public LoginScreen() {
        // Configurar el marco (JFrame)
        setTitle("Credenciales");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Crear los componentes
        JLabel titleLabel = new JLabel("Inicio de sesión");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel userLabel = new JLabel("Usuario:");
        JLabel passwordLabel = new JLabel("Contraseña:");
        userField = new JTextField(15);
        passwordField = new JPasswordField(15);

        JButton loginButton = new JButton("Verificar");
        togglePasswordButton = new JButton("Ver");

        // Acción para el botón de "Ver" o "Ocultar" contraseña
        togglePasswordButton.addActionListener(new ActionListener() {
            private boolean isPasswordVisible = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPasswordVisible) {
                    passwordField.setEchoChar('*');
                    togglePasswordButton.setText("Ver");
                } else {
                    passwordField.setEchoChar((char) 0);
                    togglePasswordButton.setText("Ocultar");
                }
                isPasswordVisible = !isPasswordVisible;
            }
        });

        // Configurar el diseño
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        add(userLabel, gbc);

        gbc.gridx = 1;
        add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(togglePasswordButton, gbc);

        gbc.gridy = 4;
        add(loginButton, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
}
