import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;



public class TelaLeiOrdinaria extends JFrame {

    private ArrayList<ArmazenamentoLeiOrdinaria> informacoes = new ArrayList<ArmazenamentoLeiOrdinaria>();

    private JLabel labellink;
    private JTextField campolink;
    private JLabel labelNomeLei;
    private JTextField campoNomeLei;
    private JLabel labelTextoLei;
    private JTextField campoTextoLei;
    private JButton botaoAdicionar;
    private JButton botaoExcluir;
    private JButton botaoEditar;
    private JTable tabelaInformacoes;
    private JScrollPane scrollTabela;
    private JButton btnMenuPrincipal;
    private JTextField txtSistemaDePublicaes;

    private class MeuModeloTabela extends AbstractTableModel {

        private String[] colunas = {"Numero", "Descrição", "Link"};
        private ArrayList<ArmazenamentoLeiOrdinaria> dados;

        public MeuModeloTabela(ArrayList<ArmazenamentoLeiOrdinaria> dados) {
            this.dados = dados;
        }

        public int getRowCount() {
            return dados.size();
        }

        public int getColumnCount() {
            return colunas.length;
        }

        public String getColumnName(int column) {
            return colunas[column];
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            ArmazenamentoLeiOrdinaria info = dados.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return info.getNomeLei();
                case 1:
                    return info.getTextoLei();
                case 2:
                    return info.getLink();
                default:
                    return null;
            }
        }
    }

    public TelaLeiOrdinaria() {
        // Configurações da janela
        setTitle("PUBLICANDO LEI ORDINÁRIA");
        setSize(700,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(700, 600));

        // Inicializando componentes
        labellink = new JLabel("Link:");
        labellink.setBounds(24, 20, 137, 14);
        campolink = new JTextField(20);
        campolink.setBounds(160, 20, 511, 20);
        labelNomeLei = new JLabel("Número da Lei:");
        labelNomeLei.setBounds(24, 45, 137, 14);
        campoNomeLei = new JTextField(20);
        campoNomeLei.setBounds(160, 45, 511, 20);
        labelTextoLei = new JLabel("Descrição da Lei:");
        labelTextoLei.setBounds(24, 70, 137, 14);
        campoTextoLei = new JTextField(20);
        campoTextoLei.setBounds(160, 70, 511, 20);
        botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.setBounds(505, 101, 149, 23);
        botaoExcluir = new JButton("Excluir");
        botaoExcluir.setBounds(505,135,149,23);
        botaoEditar = new JButton("Editar");
        botaoEditar.setBounds(505,169,149,23);
        tabelaInformacoes = new JTable();
        scrollTabela = new JScrollPane(tabelaInformacoes);
        scrollTabela.setBounds(24, 104, 452, 402);
        JButton botaoMostrarDados = new JButton("Mostrar dados");
        botaoMostrarDados.setBounds(505, 415, 149, 23);
        JButton botaoSalvarDados = new JButton("Salvar dados");
        botaoSalvarDados.setBounds(505, 449, 149, 23);
        getContentPane().setLayout(null);
        
        
        // Adicionando componentes à janela
        getContentPane().add(labellink);
        getContentPane().add(campolink);
        getContentPane().add(labelNomeLei);
        getContentPane().add(campoNomeLei);
        getContentPane().add(labelTextoLei);
        getContentPane().add(campoTextoLei);
        getContentPane().add(botaoAdicionar);
        getContentPane().add(scrollTabela);
        getContentPane().add(botaoExcluir);
		getContentPane().add(botaoEditar);
        getContentPane().add(botaoMostrarDados);
        getContentPane().add(botaoSalvarDados);

        // Adicionando evento ao botão
        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String link = campolink.getText();
                String NomeLei = campoNomeLei.getText();
                String TextoLei = campoTextoLei.getText();
                ArmazenamentoLeiOrdinaria info = new ArmazenamentoLeiOrdinaria(link, NomeLei, TextoLei);
                informacoes.add(info);
                MeuModeloTabela modelo = (MeuModeloTabela) tabelaInformacoes.getModel();
                modelo.fireTableDataChanged();
                campolink.setText("");
                campoNomeLei.setText("");
                campoTextoLei.setText("");
            }
        });
      
     
     // Adicionando ação para o botão de exclusão
        botaoExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabelaInformacoes.getSelectedRow();
                if (selectedRow != -1) {
                    informacoes.remove(selectedRow);
                    tabelaInformacoes.updateUI();
                    ((MeuModeloTabela) tabelaInformacoes.getModel()).fireTableDataChanged();
                }
            }
        });
        // Adicionando ação para o botão de edição
     		botaoEditar.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     			int selectedRow = tabelaInformacoes.getSelectedRow();
     			if (selectedRow != -1) {
     			ArmazenamentoLeiOrdinaria info = informacoes.get(selectedRow);
     			campoNomeLei.setText(info.getNomeLei());
     			campoTextoLei.setText(info.getTextoLei());
     			campolink.setText(info.getLink());
     			
     		
     		// Adicionando ação para o botão salvar alterações
     			JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");
     			botaoSalvarAlteracoes.setBounds(505,203,149,23);
     			add(botaoSalvarAlteracoes);
     			botaoSalvarAlteracoes.addActionListener(new ActionListener() {
     			     public void actionPerformed(ActionEvent e) {
     			        // Coletando as linhas selecionadas na tabela
     			        int[] selectedRows = tabelaInformacoes.getSelectedRows();
     			        for (int i = 0; i < selectedRows.length; i++) {
     			           // Recuperando o objeto ArmazenamentoLeiOrdinaria correspondente à linha selecionada
     			           ArmazenamentoLeiOrdinaria info = informacoes.get(selectedRows[i]);
     			           // Salvando as alterações feitas nos campos de texto para o objeto ArmazenamentoLeiOrdinaria
     			           info.setNomeLei(campoNomeLei.getText());
     			           info.setTextoLei(campoTextoLei.getText());
     			           info.setLink(campolink.getText());
     					
     					}
     			        // Atualizando a tabela
     			        tabelaInformacoes.updateUI();
     			        ((MeuModeloTabela) tabelaInformacoes.getModel()).fireTableDataChanged();

     			     }
     			  });
         }
     }
     });
        
        botaoMostrarDados.addActionListener(new ActionListener() {
      	  public void actionPerformed(ActionEvent e) {
      	    // Create a new JFrame for displaying the information
      	    JFrame mostrarDadosFrame = new JFrame("Mostrar Dados");
      	    mostrarDadosFrame.setSize(700, 600);
      	    mostrarDadosFrame.setLocationRelativeTo(null);
      	    mostrarDadosFrame.setExtendedState(MAXIMIZED_BOTH);
      	    mostrarDadosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      	    // Create a JTextArea for displaying the information
      	    JTextArea areaTexto = new JTextArea();
      	    areaTexto.setEditable(true);
      	    areaTexto.setBounds(24, 136, 452, 370);

      	    // Append the information from the "ArmazenamentoAta" objects to the JTextArea
      	  for (ArmazenamentoLeiOrdinaria info : informacoes ) {
      		  areaTexto.append("<tr style=\"cursor: default;\">");
              areaTexto.append("<td><div>"+ info.getNomeLei()+"</div></td>\n");
              areaTexto.append("<td><div align=\"justify\">"+info.getTextoLei()+"</div></td>\n");
              areaTexto.append("<td><div align=\"center\"><a href=\"../../leis/leisordinarias/2023/"+ info.getLink()+".pdf\" target=\"blank\"><img src=\"../wp-content/uploads/2017/03/baixar-150x150.png\" alt=\"\" width=\"40\" height=\"40\" border=\"0\"></a></div></td>\n");
              areaTexto.append("</tr>\n");
              areaTexto.append("\n");
      	    }

      	JScrollPane scrollPane = new JScrollPane(areaTexto);
	    scrollPane.setBounds(24, 136, 452, 370);

	    // Add the JScrollPane to the JFrame and set it visible
	    mostrarDadosFrame.add(scrollPane);
	    mostrarDadosFrame.setVisible(true);
      	  }
      	});
        botaoSalvarDados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarDados();
            }
        });
        // Configurando a tabela
        MeuModeloTabela modelo = new MeuModeloTabela(informacoes);
        tabelaInformacoes.setModel(modelo);
        
        btnMenuPrincipal = new JButton("Menu Principal");
        btnMenuPrincipal.setBounds(505, 483, 149, 23);
        getContentPane().add(btnMenuPrincipal);
        
        btnMenuPrincipal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	setExtendedState(JFrame.ICONIFIED);
        	MenuPrincipal menuPrincipal = new MenuPrincipal();
        	menuPrincipal.setVisible(true);
        	dispose();
        	}
        	});
        
        txtSistemaDePublicaes = new JTextField();
        txtSistemaDePublicaes.setEditable(false);
        txtSistemaDePublicaes.setHorizontalAlignment(SwingConstants.CENTER);
        txtSistemaDePublicaes.setText("Sistema de Publicações - Prefeitura Municipal De Guaranésia - CPD 2023");
        txtSistemaDePublicaes.setBounds(0, 541, 684, 20);
        getContentPane().add(txtSistemaDePublicaes);
        txtSistemaDePublicaes.setColumns(10);

        // Exibindo a janela
        setVisible(true);
    }

    public void mostrarDados() {
    	for (ArmazenamentoLeiOrdinaria info : informacoes ) {
			System.out.println("<tr style=\"cursor: default;\">");
			System.out.println("<td><div>"+ info.getNomeLei()+"</div></td>\n");
			System.out.println("<td><div align=\"justify\">"+info.getTextoLei()+"</div></td>\n");
			System.out.println("<td><div align=\"center\"><a href=\"../../leis/leisordinarias/2023/"+ info.getLink()+".pdf\" target=\"blank\"><img src=\"../wp-content/uploads/2017/03/baixar-150x150.png\" alt=\"\" width=\"40\" height=\"40\" border=\"0\"></a></div></td>\n");
			System.out.println("</tr>\n");
			
        }
    }
    public void salvarDados() {
        JFileChooser seletorArquivo = new JFileChooser();
        seletorArquivo.setDialogTitle("Salvar arquivo");
        seletorArquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int escolha = seletorArquivo.showSaveDialog(this);
        if (escolha == JFileChooser.APPROVE_OPTION) {
            File arquivo = seletorArquivo.getSelectedFile();
            try {
                FileWriter escritor = new FileWriter(arquivo + ".txt");
                for (ArmazenamentoLeiOrdinaria info : informacoes ) {
                    escritor.write("<tr style=\"cursor: default;\">");
                    escritor.write("<td><div>"+ info.getNomeLei()+"</div></td>\n");
                    escritor.write("<td><div align=\"justify\">"+info.getTextoLei()+"</div></td>\n");
                    escritor.write("<td><div align=\"center\"><a href=\"../../leis/leisordinarias/2023/"+ info.getLink()+".pdf\" target=\"blank\"><img src=\"../wp-content/uploads/2017/03/baixar-150x150.png\" alt=\"\" width=\"40\" height=\"40\" border=\"0\"></a></div></td>\n");
                    escritor.write("</tr>\n");
                    escritor.write("\n");
				
				}
                escritor.close();
                JOptionPane.showMessageDialog(this,"Dados salvos com sucesso!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
	public static void main(String[] args) {
        new TelaLeiOrdinaria();
    }
}
