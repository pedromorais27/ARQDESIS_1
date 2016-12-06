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

import br.com.usjt.model.Dispenser;
import br.com.usjt.model.Log;

public class TelaAdmDispenser extends JFrame implements Observer{
	private JButton btnConsultar, btnVoltar, btnResetar;
	public JTable tblResultado;
	private Dispenser dispenser;

	public TelaAdmDispenser(Dispenser dispenser){
		setResizable(false);
		setTitle("Estatiscas do Dispenser");
		
		Container tela = getContentPane();
		
		//divide o BorderLayout
		tela.setLayout(new BorderLayout(2,10));

		btnConsultar = new JButton("Consultar");
		btnVoltar = new JButton("Voltar");
		btnResetar = new JButton("Resetar Notas");
		JPanel buton = new JPanel();
		buton.add(btnConsultar);
		buton.add(btnVoltar);
		buton.add(btnResetar);
	
		tblResultado = new JTable();
	
		//define o nome das colunas do JTable
		DefaultTableModel model = new DefaultTableModel(
				new String [] {"Notas", "Quantidade de notas"},0);
	
		tblResultado.setModel(model);
		JScrollPane resultado = new JScrollPane();
		
		resultado.setViewportView(tblResultado);
		
		tela.add(resultado, BorderLayout.CENTER);
		tela.add(buton, BorderLayout.SOUTH);
	
		setVisible(true);
		setSize(400, 300);
		
		this.dispenser = dispenser;///define que a variabel do tipo Acesso recebera o que estiver no parametro acesso
		dispenser.addObserver(this);//esta classe é a que vai ser observada
	}
	
	public void addBtnConsultarListener(ActionListener a) {
		btnConsultar.addActionListener(a);
	}
	
	public void addBtnVoltarListener(ActionListener a) {
		btnVoltar.addActionListener(a);
	}
	
	public void addBtnResetarListener(ActionListener a) {
		btnResetar.addActionListener(a);
	}
	
	protected Dispenser getDispenserView() {
		return dispenser;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
