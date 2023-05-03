import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class TelaDecretos extends JFrame {

    private ArrayList<ArmazenamentoDecreto> informacoes = new ArrayList<ArmazenamentoDecreto>();

    private JLabel labelLinkDecreto;
    private JTextField campoLinkDecreto;
    private JLabel labelNomeDecreto;
    private JTextField campoNomeDecreto;
    private JLabel labelNumeroDecreto;
    private JTextField campoNumeroDecreto;
    private JButton botaoAdicionar;
    private JTable tabelaInformacoes;
    private JScrollPane scrollTabela;
    private JButton btnMenuPrincipal;
    private JTextField txtSistemaDePublicaes;
    private JButton botaoExcluir;
    private JButton botaoEditar;

    private class MeuModeloTabela extends AbstractTableModel {

        private String[] colunas = {"Numero", "Nome", "Link"};
        private ArrayList<ArmazenamentoDecreto> dados;

        public MeuModeloTabela(ArrayList<ArmazenamentoDecreto> dados) {
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
            ArmazenamentoDecreto info = dados.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return info.getNumeroDecreto();
                case 1:
                    return info.getnomeDecreto();
                case 2:
                    return info.getlinkDecreto();
                default:
                    return null;
            }
        }
    }

    public TelaDecretos() {
        // Configurações da janela
        setTitle("PUBLICANDO DECRETOS");
        setSize(700,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(700, 600));

        // Inicializando componentes
        labelLinkDecreto = new JLabel("Link do Decreto:");
        labelLinkDecreto.setBounds(24, 20, 137, 14);
        campoLinkDecreto = new JTextField(20);
        campoLinkDecreto.setBounds(160, 20, 511, 20);
        labelNomeDecreto = new JLabel("Nome do Decreto:");
        labelNomeDecreto.setBounds(24, 45, 137, 14);
        campoNomeDecreto = new JTextField(20);
        campoNomeDecreto.setBounds(160, 45, 511, 20);
        labelNumeroDecreto = new JLabel("Numero do Decreto:");
        labelNumeroDecreto.setBounds(24, 70, 137, 14);
        campoNumeroDecreto = new JTextField(20);
        campoNumeroDecreto.setBounds(160, 70, 511, 20);
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
        getContentPane().add(labelLinkDecreto);
        getContentPane().add(campoLinkDecreto);
        getContentPane().add(labelNomeDecreto);
        getContentPane().add(campoNomeDecreto);
        getContentPane().add(labelNumeroDecreto);
        getContentPane().add(campoNumeroDecreto);
        getContentPane().add(botaoAdicionar);
        getContentPane().add(scrollTabela);
        getContentPane().add(botaoExcluir);
        getContentPane().add(botaoEditar);
        getContentPane().add(botaoMostrarDados);
        getContentPane().add(botaoSalvarDados);
        

        // Adicionando evento ao botão
        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String linkDecreto = campoLinkDecreto.getText();
                String nomeDecreto = campoNomeDecreto.getText();
                String numeroDecreto = campoNumeroDecreto.getText();
                ArmazenamentoDecreto info = new ArmazenamentoDecreto(linkDecreto, nomeDecreto, numeroDecreto);
                informacoes.add(info);
                MeuModeloTabela modelo = (MeuModeloTabela) tabelaInformacoes.getModel();
                modelo.fireTableDataChanged();
                campoLinkDecreto.setText("");
                campoNomeDecreto.setText("");
                campoNumeroDecreto.setText("");
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
      	  for (ArmazenamentoDecreto info : informacoes ) {
      		areaTexto.append("<tr style=\"cursor: default;\">");
      		areaTexto.append("<td class=\"text-left\" style=\"height: 60px;\">");
      		areaTexto.append("<div align=\"center\">" + info.getNumeroDecreto() +"</div></td\n>");
      		areaTexto.append("<td class=\"text-left\" style=\"height: 60px;\">"+ info.getnomeDecreto() +".</td\n>");
      		areaTexto.append("<td style=\"width: 60px;\">"); 
      		areaTexto.append("<div align=\"center\"><a href=\"../../Decretos/"+info.getlinkDecreto() +".pdf\" target=\"_blank\" rel=\"noopener\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\"></a></div></td\n>");
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
        
        
     // Adicionando ação para o botão de edição
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int selectedRow = tabelaInformacoes.getSelectedRow();
			if (selectedRow != -1) {
			ArmazenamentoDecreto info = informacoes.get(selectedRow);
			campoNumeroDecreto.setText(info.getNumeroDecreto());
			campoNomeDecreto.setText(info.getnomeDecreto());
			campoLinkDecreto.setText(info.getlinkDecreto());
        // Adicionando ação para o botão salvar alterações
			JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");
			botaoSalvarAlteracoes.setBounds(505,203,149,23);
			add(botaoSalvarAlteracoes);
			botaoSalvarAlteracoes.addActionListener(new ActionListener() {
			     public void actionPerformed(ActionEvent e) {
			        // Coletando as linhas selecionadas na tabela
			        int[] selectedRows = tabelaInformacoes.getSelectedRows();
			        for (int i = 0; i < selectedRows.length; i++) {
			           // Recuperando o objeto ArmazenamentoDecreto correspondente à linha selecionada
			           ArmazenamentoDecreto info = informacoes.get(selectedRows[i]);
			           // Salvando as alterações feitas nos campos de texto para o objeto ArmazenamentoDecreto
			           info.setNumeroDecreto(campoNumeroDecreto.getText());
			           info.setnomeDecreto(campoNomeDecreto.getText());
			           info.setlinkDecreto(campoLinkDecreto.getText());
			        }
			        // Atualizando a tabela
			        tabelaInformacoes.updateUI();
			        ((MeuModeloTabela) tabelaInformacoes.getModel()).fireTableDataChanged();
			     }
			  });
    }
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
    	for (ArmazenamentoDecreto info : informacoes ) {
			System.out.println("<tr style=\"cursor: default;\">");
			System.out.println("<td class=\"text-left\" style=\"height: 60px;\">");
			System.out.println("<div align=\"center\">" + info.getNumeroDecreto() +"</div></td\n>");
			System.out.println("<td class=\"text-left\" style=\"height: 60px;\">"+ info.getnomeDecreto() +".</td\n>");
			System.out.println("<td style=\"width: 60px;\">"); 
			System.out.println("<div align=\"center\"><a href=\"../../Decretos/"+info.getlinkDecreto() +".pdf\" target=\"_blank\" rel=\"noopener\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\"></a></div></td\n>");
			System.out.println("</tr>");
			
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
                for (ArmazenamentoDecreto info : informacoes ) {
                    escritor.write("<tr style=\"cursor: default;\">");
                    escritor.write("<td class=\"text-left\" style=\"height: 60px;\">");
                    escritor.write("<div align=\"center\">" + info.getNumeroDecreto() +"</div></td\n>");
                    escritor.write("<td class=\"text-left\" style=\"height: 60px;\">"+ info.getnomeDecreto() +".</td\n>");
					escritor.write("<td style=\"width: 60px;\">"); 
					escritor.write("<div align=\"center\"><a href=\"../../Decretos/"+info.getlinkDecreto() +".pdf\" target=\"_blank\" rel=\"noopener\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\"></a></div></td\n>");
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
        new TelaDecretos();
    }
}
