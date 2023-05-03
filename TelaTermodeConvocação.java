import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;




public class TelaTermodeConvocação extends JFrame {
private ArrayList<ArmazenamentoTermoDeCovocacao> informacoes = new ArrayList<ArmazenamentoTermoDeCovocacao>();
private JLabel labelLink;
private JTextField campoLink;
private JLabel labelNome;
private JTextField campoNome;
private JLabel labelcargo;
private JTextField campocargo;
private JLabel labelData;
private JTextField campodata;
private JButton botaoAdicionar;
private JButton botaoExcluir;
private JButton botaoEditar;
private JTable tabelaInformacoes;
private JScrollPane scrollTabela;
private JButton btnMenuPrincipal;
private JTextField txtSistemaDePublicaes;
private class MeuModeloTabela extends AbstractTableModel {
private String[] colunas = {"Cargo", "Nome", "Link", "Data"};
private ArrayList<ArmazenamentoTermoDeCovocacao> dados;
public MeuModeloTabela(ArrayList<ArmazenamentoTermoDeCovocacao> dados) {
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
	ArmazenamentoTermoDeCovocacao info = dados.get(rowIndex);
switch (columnIndex) {
case 0:
return info.getCargo();
case 1:
return info.getNome();
case 2:
return info.getLink();
case 3:
return info.getData();
default:
return null;
}
}
}
public TelaTermodeConvocação() {
	
// Configurações da janela
setTitle("PUBLICANDO TERMOS DE CONVOCAÇÃO");
setSize(700,600);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setLocationRelativeTo(null);
setMinimumSize(new Dimension(700, 600));
// Inicializando componentes
labelLink = new JLabel("Link:");
labelLink.setBounds(24, 23, 137, 14);
campoLink = new JTextField(20);
campoLink.setBounds(160, 20, 511, 20);
labelNome = new JLabel("Nome:");
labelNome.setBounds(24, 48, 137, 14);
campoNome = new JTextField(20);
campoNome.setBounds(160, 45, 511, 20);
labelcargo = new JLabel("Cargo:");
labelcargo.setBounds(24, 98, 137, 14);
campocargo = new JTextField(20);
campocargo.setBounds(160, 95, 511, 20);
labelData = new JLabel("Data:");
labelData.setBounds(24, 73, 137, 14);
campodata = new JTextField(20);
campodata.setBounds(160, 70, 511, 20);
botaoAdicionar = new JButton("Adicionar");
botaoAdicionar.setBounds(505, 133, 149, 23);
botaoExcluir = new JButton("Excluir");
botaoExcluir.setBounds(505,163,149,23);
botaoEditar = new JButton("Editar");
botaoEditar.setBounds(505,193,149,23);
tabelaInformacoes = new JTable();
scrollTabela = new JScrollPane(tabelaInformacoes);
scrollTabela.setBounds(24, 136, 452, 370);
JButton botaoMostrarDados = new JButton("Mostrar dados");
botaoMostrarDados.setBounds(505, 415, 149, 23);
JButton botaoSalvarDados = new JButton("Salvar dados");
botaoSalvarDados.setBounds(505, 449, 149, 23);
getContentPane().setLayout(null);
// Adicionando componentes à janela
getContentPane().add(labelLink);
getContentPane().add(campoLink);
getContentPane().add(labelNome);
getContentPane().add(campoNome);
getContentPane().add(labelcargo);
getContentPane().add(campocargo);
getContentPane().add(labelData);
getContentPane().add(campodata);
getContentPane().add(botaoAdicionar);
getContentPane().add(scrollTabela);
getContentPane().add(botaoExcluir);
getContentPane().add(botaoEditar);
getContentPane().add(botaoMostrarDados);
getContentPane().add(botaoSalvarDados);
// Adicionando evento ao botão
botaoAdicionar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String Link = campoLink.getText();
String Nome = campoNome.getText();
String cargo = campocargo.getText();
String data = campodata.getText();
ArmazenamentoTermoDeCovocacao info = new ArmazenamentoTermoDeCovocacao(Link, Nome, cargo, data);
informacoes.add(info);
MeuModeloTabela modelo = (MeuModeloTabela) tabelaInformacoes.getModel();
modelo.fireTableDataChanged();
campoLink.setText("");
campoNome.setText("");
campocargo.setText("");
campodata.setText("");
}
});

//Adicionando ação para o botão de edição
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int selectedRow = tabelaInformacoes.getSelectedRow();
			if (selectedRow != -1) {
			ArmazenamentoTermoDeCovocacao info = informacoes.get(selectedRow);
			campocargo.setText(info.getCargo());
			campoNome.setText(info.getNome());
			campoLink.setText(info.getLink());
			campodata.setText(info.getData());
			
		
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
			
			// Adicionando ação para o botão salvar alterações
			JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");
			botaoSalvarAlteracoes.setBounds(505,223,149,23);
			add(botaoSalvarAlteracoes);
			botaoSalvarAlteracoes.addActionListener(new ActionListener() {
			     public void actionPerformed(ActionEvent e) {
			        // Coletando as linhas selecionadas na tabela
			        int[] selectedRows = tabelaInformacoes.getSelectedRows();
			        for (int i = 0; i < selectedRows.length; i++) {
			           // Recuperando o objeto ArmazenamentoTermodeConvocação correspondente à linha selecionada
			           ArmazenamentoTermoDeCovocacao info = informacoes.get(selectedRows[i]);
			           // Salvando as alterações feitas nos campos de texto para o objeto ArmazenamentoTermodeConvocação
			           info.setCargo(campocargo.getText());
			           info.setNome(campoNome.getText());
			           info.setLink(campoLink.getText());
						info.setData(campodata.getText());
					
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
	    for (ArmazenamentoTermoDeCovocacao info : informacoes ) {
	    	areaTexto.append("<tr style=\"cursor: default;\">");
	    	areaTexto.append( "<td> "+ info.getNome() +"</td>\n");
	    	areaTexto.append( "<td>" +info.getCargo() +"</td>\n");
	    	areaTexto.append( "<td>");
	    	areaTexto.append( "<div align=\"center\">" +info.getData() +"</div></td>\n");
	    	areaTexto.append( "<td>");
	    	areaTexto.append( "<div align=\"center\"><a href=\"../../termosdeconvocacao/2023/" + info.getLink() +".pdf\" target=\"_blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"50\" height=\"50\"></a></div></td>\n");
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
txtSistemaDePublicaes.setHorizontalAlignment(SwingConstants.CENTER);
txtSistemaDePublicaes.setText("Sistema de Publicações - Prefeitura Municipal De Guaranésia - CPD 2023");
txtSistemaDePublicaes.setEditable(false);
txtSistemaDePublicaes.setBounds(0, 541, 684, 20);
getContentPane().add(txtSistemaDePublicaes);
txtSistemaDePublicaes.setColumns(10);
// Exibindo a janela
setVisible(true);
}
private void setSize(Object setExtendedState) {
	// TODO Auto-generated method stub
	
}
private void setMinimumSize(int i, int j) {
	// TODO Auto-generated method stub
	
}
public void mostrarDados() {
for (ArmazenamentoTermoDeCovocacao info : informacoes ) {
	System.out.println("<tr style=\"cursor: default;\">");
	System.out.println( "<td> "+ info.getNome() +"</td>\n");
	System.out.println( "<td>" +info.getCargo() +"</td>\n");
	System.out.println( "<td>");
	System.out.println( "<div align=\"center\">" +info.getData() +"</div></td>\n");
	System.out.println( "<td>");
	System.out.println( "<div align=\"center\"><a href=\"../../termosdeconvocacao/2023/" + info.getLink() +".pdf\" target=\"_blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"50\" height=\"50\"></a></div></td>\n");
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
for (ArmazenamentoTermoDeCovocacao info : informacoes ) {
	escritor.write("<tr style=\"cursor: default;\">");
	escritor.write( "<td> "+ info.getNome() +"</td>\n");
	escritor.write( "<td>" +info.getCargo() +"</td>\n");
	escritor.write( "<td>");
	escritor.write( "<div align=\"center\">" +info.getData() +"</div></td>\n");
	escritor.write( "<td>");
	escritor.write( "<div align=\"center\"><a href=\"../../termosdeconvocacao/2023/" + info.getLink() +".pdf\" target=\"_blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"50\" height=\"50\"></a></div></td>\n");
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
new TelaTermodeConvocação();
}
}

