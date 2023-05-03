import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Desktop;

public class MenuPrincipal extends JFrame {
	private JTextField txtCentroDeProcessamento;
	private JTextField txtSistemaDePublicaes;
	private JTextField txtPrefeituraMunicipalDe;
	private JTextField txtLicitao;
	private JTextField txtEditais;
	private JTextField txtLegislao;
	private JTextField txtLeis;
	private JTextField txtTransparncia;

    public MenuPrincipal() {
    	getContentPane().setBackground(SystemColor.window);
        setSize(700, 600);
        setTitle("Janela Principal");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(700, 600));

        JButton btnTelaAtas = new JButton("Atas");
        btnTelaAtas.setFont(new Font("Calibri", Font.PLAIN, 12));
        btnTelaAtas.setMinimumSize(new Dimension(55, 30));
        btnTelaAtas.setMaximumSize(new Dimension(55, 30));
        btnTelaAtas.setBounds(100, 166, 174, 30);
        JButton btnTelaContrato = new JButton("Contrato");
        btnTelaContrato.setFont(new Font("Calibri", Font.PLAIN, 12));
        btnTelaContrato.setBounds(100, 207, 174, 30);
        JButton btnTelaCredenciamento = new JButton("Credenciamento");
        btnTelaCredenciamento.setFont(new Font("Calibri", Font.PLAIN, 12));
        btnTelaCredenciamento.setBounds(100, 373, 174, 30);
        JButton btnTelaDecretos = new JButton("Decretos");
        btnTelaDecretos.setFont(new Font("Calibri", Font.PLAIN, 12));
        btnTelaDecretos.setBounds(400, 166, 174, 30);
        JButton btnTelaLeiComplementar= new JButton("Leis Complementares");
        btnTelaLeiComplementar.setFont(new Font("Calibri", Font.PLAIN, 12));
        btnTelaLeiComplementar.setBounds(400, 332, 174, 30);
        JButton btnTelaLeiOrdinaria= new JButton("Leis Ordinárias");
        btnTelaLeiOrdinaria.setFont(new Font("Calibri", Font.PLAIN, 12));
        btnTelaLeiOrdinaria.setBounds(400, 291, 174, 30);
        JButton btnTelaPortaria= new JButton("Portarias");
        btnTelaPortaria.setFont(new Font("Calibri", Font.PLAIN, 12));
        btnTelaPortaria.setBounds(400, 207, 174, 30);
        JButton btnTelaPregaoPresencial= new JButton("Pregão Presencial");
        btnTelaPregaoPresencial.setFont(new Font("Calibri", Font.PLAIN, 12));
        btnTelaPregaoPresencial.setBounds(100, 332, 174, 30);
        JButton btnTelaTermoAditivo= new JButton("Termos Aditivos");
        btnTelaTermoAditivo.setFont(new Font("Calibri", Font.PLAIN, 12));
        btnTelaTermoAditivo.setBounds(100, 248, 174, 30);
        JButton btnTelaTomadadePreço= new JButton("Tomada de Preço");
        btnTelaTomadadePreço.setFont(new Font("Calibri", Font.PLAIN, 12));
        btnTelaTomadadePreço.setBounds(100, 414, 174, 30);
        JButton btnTelaTermodeConvocação= new JButton(" Termos de Convocação");
        btnTelaTermodeConvocação.setFont(new Font("Calibri", Font.PLAIN, 12));
        btnTelaTermodeConvocação.setBounds(400, 414, 174, 30);
        JButton btnCPanel = new JButton("CPanel");
        btnCPanel.setLocation(100, 505);
        btnCPanel.setSize(174, 20);
        getContentPane().add(btnCPanel);
        JButton btnSite = new JButton("Site");
        btnSite.setLocation(400, 505);
        btnSite.setSize(174, 20);
        getContentPane().add(btnSite);
        
        
        btnTelaAtas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setExtendedState(JFrame.ICONIFIED);
            	TelaAtas telaAtas = new TelaAtas();
                telaAtas.setVisible(true);
                dispose();
            }
        });

        btnTelaContrato.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setExtendedState(JFrame.ICONIFIED);
            	TelaContrato telaContrato = new TelaContrato();
                telaContrato.setVisible(true);
                dispose();
            }
        });

        btnTelaCredenciamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setExtendedState(JFrame.ICONIFIED);
            	TelaCredenciamento telaCredenciamento = new TelaCredenciamento();
                telaCredenciamento.setVisible(true);
                dispose();
            }
        });
        
        btnTelaDecretos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setExtendedState(JFrame.ICONIFIED);
            	TelaDecretos telaDecretos = new TelaDecretos();
                telaDecretos.setVisible(true);
                dispose();
            }
        });
        btnTelaLeiComplementar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	setExtendedState(JFrame.ICONIFIED);
        	TelaLeiComplementar telaLeiComplementar = new TelaLeiComplementar();
        	telaLeiComplementar.setVisible(true);
        	dispose();
        	}
        	});
        
        btnTelaLeiOrdinaria.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setExtendedState(JFrame.ICONIFIED);
        		TelaLeiOrdinaria telaLeiOrdinaria = new TelaLeiOrdinaria();
        		telaLeiOrdinaria.setVisible(true);
        		dispose();
        	}
        });
        btnTelaPortaria.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setExtendedState(JFrame.ICONIFIED);
        		TelaPortaria telaPortaria = new TelaPortaria();
        		telaPortaria.setVisible(true);
        		dispose();
        	}
        });
        btnTelaPregaoPresencial.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setExtendedState(JFrame.ICONIFIED);
        		TelaPregaoPresencial telaPregaoPresencial = new TelaPregaoPresencial();
        		telaPregaoPresencial.setVisible(true);
        		dispose();
        	}
        });
        btnTelaTermoAditivo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setExtendedState(JFrame.ICONIFIED);
        		TelaTermoAditivo telaTermoAditivo = new TelaTermoAditivo();
        		telaTermoAditivo.setVisible(true);
        		dispose();
        	}
        });
        btnTelaTomadadePreço.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setExtendedState(JFrame.ICONIFIED);
        		TelaTomadadePreço telaTomadadePreço = new TelaTomadadePreço();
        		telaTomadadePreço.setVisible(true);
        		dispose();
        	}
        });
        btnTelaTermodeConvocação.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	setExtendedState(JFrame.ICONIFIED);
        	TelaTermodeConvocação telaTermodeConvocação = new TelaTermodeConvocação();
        	telaTermodeConvocação.setVisible(true);
        	dispose();
        	}
        	});

        
        btnCPanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://cpanel.prefguaranesia.mg.gov.br/cpsess2929707199/frontend/paper_lantern/filemanager/index.html"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        btnSite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.prefguaranesia.mg.gov.br/adm2017"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        getContentPane().setLayout(null);
        getContentPane().add(btnTelaContrato);
        getContentPane().add(btnTelaAtas);
        getContentPane().add(btnTelaTermoAditivo);
        getContentPane().add(btnTelaPregaoPresencial);
        getContentPane().add(btnTelaCredenciamento);
        getContentPane().add(btnTelaTomadadePreço);
        getContentPane().add(btnTelaLeiOrdinaria);
        getContentPane().add(btnTelaPortaria);
        getContentPane().add(btnTelaDecretos);
        getContentPane().add(btnTelaLeiComplementar);
        getContentPane().add(btnTelaTermodeConvocação);
        getContentPane().add(btnCPanel);
        getContentPane().add(btnSite);
        
        txtCentroDeProcessamento = new JTextField();
        txtCentroDeProcessamento.setForeground(SystemColor.window);
        txtCentroDeProcessamento.setBackground(SystemColor.windowText);
        txtCentroDeProcessamento.setBorder(null);
        txtCentroDeProcessamento.setEditable(false);
        txtCentroDeProcessamento.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtCentroDeProcessamento.setHorizontalAlignment(SwingConstants.CENTER);
        txtCentroDeProcessamento.setText("Centro de Processamento de Dados - 2023");
        txtCentroDeProcessamento.setBounds(0, 541, 684, 20);
        getContentPane().add(txtCentroDeProcessamento);
        txtCentroDeProcessamento.setColumns(10);
        
        txtSistemaDePublicaes = new JTextField();
        txtSistemaDePublicaes.setBorder(null);
        txtSistemaDePublicaes.setAutoscrolls(false);
        txtSistemaDePublicaes.setBackground(SystemColor.window);
        txtSistemaDePublicaes.setEditable(false);
        txtSistemaDePublicaes.setText("SISTEMA DE PUBLICAÇÕES");
        txtSistemaDePublicaes.setHorizontalAlignment(SwingConstants.CENTER);
        txtSistemaDePublicaes.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtSistemaDePublicaes.setColumns(10);
        txtSistemaDePublicaes.setBounds(0, 29, 684, 20);
        getContentPane().add(txtSistemaDePublicaes);
        
        txtPrefeituraMunicipalDe = new JTextField();
        txtPrefeituraMunicipalDe.setBackground(SystemColor.window);
        txtPrefeituraMunicipalDe.setBorder(null);
        txtPrefeituraMunicipalDe.setEditable(false);
        txtPrefeituraMunicipalDe.setText("PREFEITURA MUNICIPAL DE GUARANÉSIA");
        txtPrefeituraMunicipalDe.setHorizontalAlignment(SwingConstants.CENTER);
        txtPrefeituraMunicipalDe.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtPrefeituraMunicipalDe.setColumns(10);
        txtPrefeituraMunicipalDe.setBounds(0, 52, 684, 38);
        getContentPane().add(txtPrefeituraMunicipalDe);
        
        txtLicitao = new JTextField();
        txtLicitao.setText("LICITAÇÃO:");
        txtLicitao.setHorizontalAlignment(SwingConstants.CENTER);
        txtLicitao.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtLicitao.setEditable(false);
        txtLicitao.setColumns(10);
        txtLicitao.setBorder(null);
        txtLicitao.setBackground(Color.WHITE);
        txtLicitao.setAutoscrolls(false);
        txtLicitao.setBounds(100, 142, 174, 20);
        getContentPane().add(txtLicitao);
        
        txtEditais = new JTextField();
        txtEditais.setText("EDITAIS:");
        txtEditais.setHorizontalAlignment(SwingConstants.CENTER);
        txtEditais.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtEditais.setEditable(false);
        txtEditais.setColumns(10);
        txtEditais.setBorder(null);
        txtEditais.setBackground(Color.WHITE);
        txtEditais.setAutoscrolls(false);
        txtEditais.setBounds(100, 301, 174, 20);
        getContentPane().add(txtEditais);
        
        txtLegislao = new JTextField();
        txtLegislao.setText("LEGISLAÇÃO:");
        txtLegislao.setHorizontalAlignment(SwingConstants.CENTER);
        txtLegislao.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtLegislao.setEditable(false);
        txtLegislao.setColumns(10);
        txtLegislao.setBorder(null);
        txtLegislao.setBackground(Color.WHITE);
        txtLegislao.setAutoscrolls(false);
        txtLegislao.setBounds(400, 142, 174, 20);
        getContentPane().add(txtLegislao);
        
        txtLeis = new JTextField();
        txtLeis.setText("LEIS:");
        txtLeis.setHorizontalAlignment(SwingConstants.CENTER);
        txtLeis.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtLeis.setEditable(false);
        txtLeis.setColumns(10);
        txtLeis.setBorder(null);
        txtLeis.setBackground(Color.WHITE);
        txtLeis.setAutoscrolls(false);
        txtLeis.setBounds(400, 258, 174, 20);
        getContentPane().add(txtLeis);
        
        txtTransparncia = new JTextField();
        txtTransparncia.setText("TRANSPARÊNCIA:");
        txtTransparncia.setHorizontalAlignment(SwingConstants.CENTER);
        txtTransparncia.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtTransparncia.setEditable(false);
        txtTransparncia.setColumns(10);
        txtTransparncia.setBorder(null);
        txtTransparncia.setBackground(Color.WHITE);
        txtTransparncia.setAutoscrolls(false);
        txtTransparncia.setBounds(400, 383, 174, 20);
        getContentPane().add(txtTransparncia);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(241, 243, 243));
        panel.setBounds(0, 490, 684, 50);
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MenuPrincipal janelaPrincipal = new MenuPrincipal();
        janelaPrincipal.setVisible(true);
    }
}