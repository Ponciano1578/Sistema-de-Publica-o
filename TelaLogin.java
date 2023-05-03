import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton btnLogin;
    private JTextField txtVerso;

    public TelaLogin() {
        setSize(450, 250);
        setTitle("LOGIN - SISTEMA DE PUBLICAÇÕES");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsuario.setBounds(83, 22, 105, 37);
        campoUsuario = new JTextField();
        campoUsuario.setBounds(188, 28, 167, 25);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSenha.setBounds(83, 64, 105, 37);
        campoSenha = new JPasswordField();
        campoSenha.setBounds(188, 70, 167, 25);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnLogin.setBounds(137, 121, 142, 37);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());
                if (usuario.equals("Marcelo") && senha.equals("Pipoca103")) {
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.setVisible(true);
                    dispose();
                }
                else if (usuario.equals("Mateus") && senha.equals("2648")) {
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.setVisible(true);
                    dispose();
                }
                else if (usuario.equals("Otavio") && senha.equals("123")) {
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.setVisible(true);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
                }
            }
        });

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.add(lblUsuario);
        painel.add(campoUsuario);
        painel.add(lblSenha);
        painel.add(campoSenha);
        JLabel label = new JLabel();
        label.setBounds(0, 74, 142, 37);
        painel.add(label);
        painel.add(btnLogin);
        getContentPane().add(painel);
        
        txtVerso = new JTextField();
        txtVerso.setDisabledTextColor(SystemColor.textHighlight);
        txtVerso.setEnabled(false);
        txtVerso.setEditable(false);
        txtVerso.setBorder(null);
        txtVerso.setBackground(SystemColor.control);
        txtVerso.setHorizontalAlignment(SwingConstants.CENTER);
        txtVerso.setText("Versão 1.4");
        txtVerso.setBounds(0, 186, 434, 25);
        painel.add(txtVerso);
        txtVerso.setColumns(10);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }
}