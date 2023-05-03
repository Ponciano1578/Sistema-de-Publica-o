import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;




public class TelaPortaria extends JFrame {
private ArrayList<ArmazenamentoPortaria> informacoes = new ArrayList<ArmazenamentoPortaria>();
private JLabel labellink;
private JTextField campolink;
private JLabel labelNomeFuncionario;
private JTextField campoNomeFuncionario;
private JLabel labelAntesNome;
private JTextField campoAntesNome;
private JLabel labelDepoisNome;
private JTextField campoDepoisNome;
private JLabel labelNumeroPortaria;
private JTextField campoNumeroPortaria;
private JButton botaoAdicionar;
private JButton botaoExcluir;
private JButton botaoEditar;
private JTable tabelaInformacoes;
private JScrollPane scrollTabela;
private JButton btnMenuPrincipal;
private JTextField txtSistemaDePublicaes;
private class MeuModeloTabela extends AbstractTableModel {
private String[] colunas = {"Antes do Nome", "Nome Servidor", "Depois Nome", "Link", "Número"};
private ArrayList<ArmazenamentoPortaria> dados;
public MeuModeloTabela(ArrayList<ArmazenamentoPortaria> dados) {
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
	ArmazenamentoPortaria info = dados.get(rowIndex);
switch (columnIndex) {
case 0:
return info.getAntesNome();
case 1:
return info.getNomeFuncionario();
case 2:
return info.getDepoisNome();
case 3:
return info.getLink();
case 4:
return info.getNumeroPortaria();

default:
return null;
}
}
}
public TelaPortaria() {
// Configurações da janela
setTitle("PUBLICANDO PORTARIAS");
setSize(700,600);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setLocationRelativeTo(null);
setMinimumSize(new Dimension(700, 600));


// Inicializando componentes
labellink = new JLabel("Link:");
labellink.setBounds(24, 26, 137, 14);
campolink = new JTextField(20);
campolink.setBounds(160, 20, 511, 20);

labelNomeFuncionario = new JLabel("Nome do Servidor:");
labelNomeFuncionario.setBounds(367, 51, 137, 14);
campoNomeFuncionario = new JTextField(20);
campoNomeFuncionario.setBounds(496, 48, 175, 20);

labelAntesNome = new JLabel("Antes do Nome:");
labelAntesNome.setBounds(24, 54, 132, 14);
campoAntesNome = new JTextField(20);
campoAntesNome.setBounds(160, 48, 184, 20);

labelDepoisNome = new JLabel("Depois do Nome:");
labelDepoisNome.setBounds(24, 82, 137, 14);
campoDepoisNome = new JTextField(20);
campoDepoisNome.setBounds(160, 76, 184, 20);

labelNumeroPortaria = new JLabel("Número da Portaria:");
labelNumeroPortaria.setBounds(367, 82, 137, 14);
campoNumeroPortaria = new JTextField(20);
campoNumeroPortaria.setBounds(496, 76, 175, 20);


botaoAdicionar = new JButton("Adicionar");
botaoAdicionar.setBounds(505, 116, 149, 23);

botaoExcluir = new JButton("Excluir");
botaoExcluir.setBounds(505,146,149,23);
botaoEditar = new JButton("Editar");
botaoEditar.setBounds(505,176,149,23);

tabelaInformacoes = new JTable();
scrollTabela = new JScrollPane(tabelaInformacoes);
scrollTabela.setBounds(24, 116, 452, 390);
JButton botaoMostrarDados = new JButton("Mostrar dados");
botaoMostrarDados.setBounds(505, 415, 149, 23);
JButton botaoSalvarDados = new JButton("Salvar dados");
botaoSalvarDados.setBounds(505, 449, 149, 23);
getContentPane().setLayout(null);





// Adicionando componentes à janela
getContentPane().add(labellink);
getContentPane().add(campolink);

getContentPane().add(labelNomeFuncionario);
getContentPane().add(campoNomeFuncionario);

getContentPane().add(labelAntesNome);
getContentPane().add(campoAntesNome);

getContentPane().add(labelDepoisNome);
getContentPane().add(campoDepoisNome);

getContentPane().add(labelNumeroPortaria);
getContentPane().add(campoNumeroPortaria);

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
	String NomeFuncionario = campoNomeFuncionario.getText();
	String AntesNome = campoAntesNome.getText();
	String DepoisNome = campoDepoisNome.getText();
	String NumeroPortaria = campoNumeroPortaria.getText();




ArmazenamentoPortaria info = new ArmazenamentoPortaria(link, NomeFuncionario, AntesNome, DepoisNome, NumeroPortaria);
informacoes.add(info);
MeuModeloTabela modelo = (MeuModeloTabela) tabelaInformacoes.getModel();
modelo.fireTableDataChanged();
campolink.setText("");
campoNomeFuncionario.setText("");
campoAntesNome.setText("");
campoDepoisNome.setText("");
campoNumeroPortaria.setText("");

}
});

//Adicionando ação para o botão de edição
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int selectedRow = tabelaInformacoes.getSelectedRow();
			if (selectedRow != -1) {
			ArmazenamentoPortaria info = informacoes.get(selectedRow);
			campoAntesNome.setText(info.getAntesNome());
			campoNomeFuncionario.setText(info.getNomeFuncionario());
			campoDepoisNome.setText(info.getDepoisNome());
			campolink.setText(info.getLink());
			campoNumeroPortaria.setText(info.getNumeroPortaria());

		
		// Adicionando ação para o botão salvar alterações
			JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");
			botaoSalvarAlteracoes.setBounds(505,206,149,23);
			add(botaoSalvarAlteracoes);
			botaoSalvarAlteracoes.addActionListener(new ActionListener() {
			     public void actionPerformed(ActionEvent e) {
			        // Coletando as linhas selecionadas na tabela
			        int[] selectedRows = tabelaInformacoes.getSelectedRows();
			        for (int i = 0; i < selectedRows.length; i++) {
			           // Recuperando o objeto ArmazenamentoPortaria correspondente à linha selecionada
			           ArmazenamentoPortaria info = informacoes.get(selectedRows[i]);
			           // Salvando as alterações feitas nos campos de texto para o objeto ArmazenamentoPortaria
			           info.setAntesNome(campoAntesNome.getText());
			           info.setNomeFuncionario(campoNomeFuncionario.getText());
			           info.setDepoisNome(campoDepoisNome.getText());
						info.setLink(campolink.getText());
						info.setNumeroPortaria(campoNumeroPortaria.getText());

					}
			        // Atualizando a tabela
			        tabelaInformacoes.updateUI();
			        ((MeuModeloTabela) tabelaInformacoes.getModel()).fireTableDataChanged();

			     }
			  });
 }
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
	    for (ArmazenamentoPortaria info : informacoes ) {
	    	areaTexto.append("<tr style=\"cursor: default;\" tr=\"\" onmouseover=\"javascript:this.style.backgroundColor='#cfd8dc'\" onmouseout=\"javascript:this.style.backgroundColor=''\">");
			areaTexto.append("<td>");
			areaTexto.append("<div align=\"center\">"+info.getNumeroPortaria()+"/2023</div></td>\n");
			areaTexto.append("<td>"+info.getAntesNome()+" <span style=\"color: #1d66d3;\">"+ info.getNomeFuncionario()+" </span>"+info.getDepoisNome()+".</td>\n");
			areaTexto.append("<td>");
			areaTexto.append("<div align=\"center\"><a href=\"../../portaria/2023/"+info.getLink()+".pdf\" target=\"blank\" rel=\"noopener\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\" /></a></div></td>\n");
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
	 for (ArmazenamentoPortaria info : informacoes ) {
		System.out.println("<tr style=\"cursor: default;\" tr=\"\" onmouseover=\"javascript:this.style.backgroundColor='#cfd8dc'\" onmouseout=\"javascript:this.style.backgroundColor=''\">");
 		System.out.println("<td>");
 		System.out.println("<div align=\"center\">"+info.getNumeroPortaria()+"/2023</div></td>\n");
 		System.out.println("<td>"+info.getAntesNome()+" <span style=\"color: #1d66d3;\">"+ info.getNomeFuncionario()+" </span>"+info.getDepoisNome()+".</td>\n");
 		System.out.println("<td>");
 		System.out.println("<div align=\"center\"><a href=\"../../portaria/2023/"+info.getLink()+".pdf\" target=\"blank\" rel=\"noopener\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\" /></a></div></td>\n");
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
	for (ArmazenamentoPortaria info : informacoes ) {
		escritor.write("<tr style=\"cursor: default;\" tr=\"\" onmouseover=\"javascript:this.style.backgroundColor='#cfd8dc'\" onmouseout=\"javascript:this.style.backgroundColor=''\">");
		escritor.write("<td>");
		escritor.write("<div align=\"center\">"+info.getNumeroPortaria()+"/2023</div></td>\n");
		escritor.write("<td>"+info.getAntesNome()+" <span style=\"color: #1d66d3;\">"+ info.getNomeFuncionario()+" </span>"+info.getDepoisNome()+".</td>\n");
		escritor.write("<td>");
		escritor.write("<div align=\"center\"><a href=\"../../portaria/2023/"+info.getLink()+".pdf\" target=\"blank\" rel=\"noopener\"><img class=\"wp-image-257 alignnone size-medium\" src=\"../wp-content/uploads/2017/03/baixar-300x300.png\" alt=\"baixar\" width=\"40\" height=\"40\" /></a></div></td>\n");
		escritor.write("</tr>\n"); 
}
escritor.close();
JOptionPane.showMessageDialog(this,"Dados salvos com sucesso!");
} catch (IOException ex) {
ex.printStackTrace();
}
}
}
public static void main(String[] args) {
new TelaPortaria();
}
}

