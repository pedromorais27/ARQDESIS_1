package br.com.usjt.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.usjt.model.Log;

public class TelaAdmLogSistemas extends JFrame implements Observer{
	private JButton btnPesquisar, btnVoltar;
	public JTable tblResultado;
	private Log log;

	public TelaAdmLogSistemas(Log log){

		setTitle("Estatiscas das operacoes");
		setResizable(false);		
		Container tela = getContentPane();
		
		//divide o BorderLayout
		tela.setLayout(new BorderLayout(2,10));

		btnPesquisar = new JButton("Consultar");
		btnVoltar = new JButton("Voltar");
		JPanel buton = new JPanel();
		buton.add(btnPesquisar);
		buton.add(btnVoltar);
	
		tblResultado = new JTable();
	
		//define o nome das colunas do JTable
		DefaultTableModel model = new DefaultTableModel(
				new String [] {"codigoItemLog", "codigoDoMovimento", "tipoOperacao", "valor", 
						"Conta","agencia", "codigoDoCliente", "dataOperacao"},0);
	
		tblResultado.setModel(model);
		JScrollPane resultado = new JScrollPane();
		
		resultado.setViewportView(tblResultado);
		
		tela.add(resultado, BorderLayout.CENTER);
		tela.add(buton, BorderLayout.SOUTH);
	
		setVisible(true);
		setSize(400, 300);
		
		this.log = log;///define que a variabel do tipo Acesso recebera o que estiver no parametro acesso
		log.addObserver(this);//esta classe é a que vai ser observada
	}
	
	public void addBtnPesquisarListener(ActionListener a) {
		btnPesquisar.addActionListener(a);
	}
	
	public void addBtnVoltarListener(ActionListener a) {
		btnVoltar.addActionListener(a);
	}
	
	protected Log getLog() {
		return log;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
