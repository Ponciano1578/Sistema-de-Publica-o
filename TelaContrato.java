import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class TelaContrato extends JFrame {
private ArrayList<ArmazenamentoContrato> informacoes = new ArrayList<ArmazenamentoContrato>();
private JLabel labellinkContrato;
private JTextField campolinkContrato;
private JLabel labelnumeroContrato;
private JTextField camponumeroContrato;
private JLabel labelobjetoContrato;
private JTextField campoobjetoContrato;
private JLabel labelfornecedorContrato;
private JTextField campofornecedorContrato;
private JLabel labelvalorContrato;
private JTextField campovalorContrato;
private JButton botaoAdicionar;
private JButton botaoExcluir;
private JButton botaoEditar;
private JTable tabelaInformacoes;
private JScrollPane scrollTabela;
private JButton btnMenuPrincipal;
private JTextField txtSistemaDePublicaes;
private class MeuModeloTabela extends AbstractTableModel {
private String[] colunas = {"Objeto", "Numero", "Link", "Fornecedor", "Valor"};
private ArrayList<ArmazenamentoContrato> dados;
public MeuModeloTabela(ArrayList<ArmazenamentoContrato> dados) {
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
	ArmazenamentoContrato info = dados.get(rowIndex);
switch (columnIndex) {
case 0:
return info.getobjetoContrato();
case 1:
return info.getnumeroContrato();
case 2:
return info.getlinkContrato();
case 3:
return info.getfornecedorContrato();
case 4:
return info.getvalorContrato();
default:
return null;
}
}
}
public TelaContrato() {
// Configurações da janela
setTitle("PUBLICANDO CONTRATOS");
setSize(700,600);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setLocationRelativeTo(null);
setMinimumSize(new Dimension(700, 600));


// Inicializando componentes
labellinkContrato = new JLabel("Link do Contrato:");
labellinkContrato.setBounds(24, 23, 137, 14);
campolinkContrato = new JTextField(20);
campolinkContrato.setBounds(160, 20, 511, 20);

labelnumeroContrato = new JLabel("Numero do Contrato:");
labelnumeroContrato.setBounds(24, 48, 137, 14);
camponumeroContrato = new JTextField(20);
camponumeroContrato.setBounds(160, 45, 191, 20);

labelobjetoContrato = new JLabel("Objeto:");
labelobjetoContrato.setBounds(24, 76, 132, 14);
campoobjetoContrato = new JTextField(20);
campoobjetoContrato.setBounds(160, 73, 511, 20);

labelfornecedorContrato = new JLabel("Fornecedor em letras MAIUSCULAS:");
labelfornecedorContrato.setBounds(24, 104, 224, 14);
campofornecedorContrato = new JTextField(20);
campofornecedorContrato.setBounds(258, 101, 413, 20);

labelvalorContrato = new JLabel("Valor:");
labelvalorContrato.setBounds(363, 48, 66, 14);
campovalorContrato = new JTextField(20);
campovalorContrato.setBounds(407, 45, 264, 20);

botaoAdicionar = new JButton("Adicionar");
botaoAdicionar.setBounds(505, 144, 149, 23);
tabelaInformacoes = new JTable();

botaoExcluir = new JButton("Excluir");
botaoExcluir.setBounds(505,174,149,23);
botaoEditar = new JButton("Editar");
botaoEditar.setBounds(505,204,149,23);

scrollTabela = new JScrollPane(tabelaInformacoes);
scrollTabela.setBounds(24, 147, 452, 359);
JButton botaoMostrarDados = new JButton("Mostrar dados");
botaoMostrarDados.setBounds(505, 415, 149, 23);
JButton botaoSalvarDados = new JButton("Salvar dados");
botaoSalvarDados.setBounds(505, 449, 149, 23);
getContentPane().setLayout(null);





// Adicionando componentes à janela
getContentPane().add(labellinkContrato);
getContentPane().add(campolinkContrato);

getContentPane().add(labelnumeroContrato);
getContentPane().add(camponumeroContrato);

getContentPane().add(labelobjetoContrato);
getContentPane().add(campoobjetoContrato);

getContentPane().add(labelfornecedorContrato);
getContentPane().add(campofornecedorContrato);

getContentPane().add(labelvalorContrato);
getContentPane().add(campovalorContrato);

getContentPane().add(botaoAdicionar);
getContentPane().add(scrollTabela);

getContentPane().add(botaoExcluir);
getContentPane().add(botaoEditar);

getContentPane().add(botaoMostrarDados);
getContentPane().add(botaoSalvarDados);




// Adicionando evento ao botão
botaoAdicionar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

	String linkContrato = campolinkContrato.getText();
	String numeroContrato = camponumeroContrato.getText();
	String objetoContrato = campoobjetoContrato.getText();
	String fornecedorContrato = campofornecedorContrato.getText();
	String valorContrato = campovalorContrato.getText();



ArmazenamentoContrato info = new ArmazenamentoContrato(linkContrato, numeroContrato, objetoContrato, fornecedorContrato, valorContrato);
informacoes.add(info);
MeuModeloTabela modelo = (MeuModeloTabela) tabelaInformacoes.getModel();
modelo.fireTableDataChanged();
campolinkContrato.setText("");
camponumeroContrato.setText("");
campoobjetoContrato.setText("");
campofornecedorContrato.setText("");
campovalorContrato.setText("");
}
});

//Adicionando ação para o botão de exclusão
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
	ArmazenamentoContrato info = informacoes.get(selectedRow);
	campoobjetoContrato.setText(info.getobjetoContrato());
	camponumeroContrato.setText(info.getnumeroContrato());
	campolinkContrato.setText(info.getlinkContrato());
	campofornecedorContrato.setText(info.getfornecedorContrato());
	campovalorContrato.setText(info.getvalorContrato());
	

// Adicionando ação para o botão salvar alterações
	JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");
	botaoSalvarAlteracoes.setBounds(505,234,149,23);
	add(botaoSalvarAlteracoes);
	botaoSalvarAlteracoes.addActionListener(new ActionListener() {
	     public void actionPerformed(ActionEvent e) {
	        // Coletando as linhas selecionadas na tabela
	        int[] selectedRows = tabelaInformacoes.getSelectedRows();
	        for (int i = 0; i < selectedRows.length; i++) {
	           // Recuperando o objeto ArmazenamentoContrato correspondente à linha selecionada
	           ArmazenamentoContrato info = informacoes.get(selectedRows[i]);
	           // Salvando as alterações feitas nos campos de texto para o objeto ArmazenamentoContrato
	           info.setobjetoContrato(campoobjetoContrato.getText());
	           info.setnumeroContrato(camponumeroContrato.getText());
	           info.setlinkContrato(campolinkContrato.getText());
				info.setfornecedorContrato(campofornecedorContrato.getText());
				info.setvalorContrato(campovalorContrato.getText());
				
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
	      for (ArmazenamentoContrato info : informacoes ) {
	    	  areaTexto.append("<tr style=\"cursor: default;\" tr=\"\" onmouseover=\"javascript:this.style.backgroundColor='#cfd8dc'\" onmouseout=\"javascript:this.style.backgroundColor=''\">\n");
	    	  areaTexto.append("<td style=\"text-align: justify;\">"+ info.getnumeroContrato() +"/2023</td>\n");
	    	  areaTexto.append("<td style=\"text-align: justify;\">"+ info.getobjetoContrato()+".</td>\n");
	    	  areaTexto.append("<td style=\"text-align: justify;\">"+ info.getfornecedorContrato()+"</td>\n");
	    	  areaTexto.append("<td style=\"text-align: justify;\">"+ info.getvalorContrato()+"</td>\n");
	    	  areaTexto.append("<td><div align=\"center\"><a href=\"../../Contratos/2023/"+ info.getlinkContrato()+".pdf\" target=\"blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\"></a></div></td>\n"); 
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
public void mostrarDados() {
	for (ArmazenamentoContrato info : informacoes ) {
		  System.out.println("<tr style=\"cursor: default;\" tr=\"\" onmouseover=\"javascript:this.style.backgroundColor='#cfd8dc'\" onmouseout=\"javascript:this.style.backgroundColor=''\">");
		  System.out.println("<td style=\"text-align: justify;\">"+ info.getnumeroContrato() +"/2023</td>");
		  System.out.println("<td style=\"text-align: justify;\">"+ info.getobjetoContrato()+".</td>");
		  System.out.println("<td style=\"text-align: justify;\">"+ info.getfornecedorContrato()+"</td>");
		  System.out.println("<td style=\"text-align: justify;\">"+ info.getvalorContrato()+"</td>");
		  System.out.println("<td><div align=\"center\"><a href=\"../../Contratos/2023/"+ info.getlinkContrato()+".pdf\" target=\"blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\"></a></div></td>"); 
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
for (ArmazenamentoContrato info : informacoes ) {
escritor.write("<tr style=\"cursor: default;\" tr=\"\" onmouseover=\"javascript:this.style.backgroundColor='#cfd8dc'\" onmouseout=\"javascript:this.style.backgroundColor=''\">\n");
escritor.write("<td style=\"text-align: justify;\">"+ info.getnumeroContrato() +"/2023</td>\n");
escritor.write("<td style=\"text-align: justify;\">"+ info.getobjetoContrato()+".</td>\n");
escritor.write("<td style=\"text-align: justify;\">"+ info.getfornecedorContrato()+"</td>\n");
escritor.write("<td style=\"text-align: justify;\">"+ info.getvalorContrato()+"</td>\n");
escritor.write("<td><div align=\"center\"><a href=\"../../Contratos/2023/"+ info.getlinkContrato()+".pdf\" target=\"blank\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\"></a></div></td>\n"); 
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
new TelaContrato();
}
}

