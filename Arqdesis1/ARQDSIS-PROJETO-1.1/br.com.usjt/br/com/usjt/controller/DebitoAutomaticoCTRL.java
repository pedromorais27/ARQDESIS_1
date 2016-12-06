package br.com.usjt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.usjt.model.DebitoAutomatico;
import br.com.usjt.view.TelaDebitoAutomatico;
import br.com.usjt.view.TelaSelecionarOpcoes;

public class DebitoAutomaticoCTRL extends TelaDebitoAutomatico{


	public DebitoAutomaticoCTRL(DebitoAutomatico debitoAutomatico) throws ParseException{
		super(debitoAutomatico);
		addBtnConfirmarListener(new btnConfirmarListener());
		addBtnVoltarListener(new btnVoltarListener());
		addConsultarListener(new btnConsultarListener());
	}

	public void update(Observable arg0, Object arg1) {

	}

	class btnConfirmarListener implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			getDebitoAutomatico().setTipoDebito("debito em conta corrente");

			if(getEscolherConta().getSelectedItem().toString() == null || getEscolherConta().getSelectedItem().toString() == ""){
				JOptionPane.showMessageDialog(null, "Por favor selecione o tipo de conta");
			}else{

				getDebitoAutomatico().setOperadora(getEscolherConta().getSelectedItem().toString());

				try { 
					getDebitoAutomatico().setCodigoConsumidor(getTxtCodigoConsumidor()); 
				}catch(NumberFormatException erro){ 
					JOptionPane.showMessageDialog(null, "entre com uma codigo valido"); 
					return; 
				}

				try {
					getDebitoAutomatico().setDataDebito(new SimpleDateFormat("dd/MM/yyyy").parse(getTxtData()));
				} catch (ParseException e) {
					e.printStackTrace();
				}

				try { 
					getDebitoAutomatico().setValorDebito(getTxtValor()); 
				}catch(NumberFormatException erro){ 
					JOptionPane.showMessageDialog(null, "Entre com um valor valido"); 
					return; 
				}

				getDebitoAutomatico().setNumConta(getNumConta());
				getDebitoAutomatico().setNumAgencia(getNumAgencia());

			}
			try {
				getDebitoAutomatico().gerarDebito();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class btnVoltarListener implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			TelaSelecionarOpcoes selecionar = new TelaSelecionarOpcoes();
			selecionar.internacionalizar(getIdioma());
			selecionar.setNumConta(getNumConta());
			selecionar.setAgencia(getNumAgencia());
			selecionar.setTitle(getNomeCliente());
			selecionar.setNomeCliente(getNomeCliente());
			selecionar.setSize(500,300);
			selecionar.setVisible(true);
			visual(false);
		}
	}

	class btnConsultarListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			DebitoAutomatico deb = new DebitoAutomatico();
			deb.setNumConta(getNumConta());

			try {
				ArrayList<DebitoAutomatico> recuper = deb.consultar();

				DefaultTableModel dtm = (DefaultTableModel) table.getModel();

				int k = dtm.getRowCount();  

				try{
					if (k > 0){  
						for (int i=0;i<=k;i++){    
							dtm.removeRow(0);    
						}                
					}  

				}catch(Exception e){
					
				}

				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
								
				for(Iterator<DebitoAutomatico> it = recuper.iterator(); it.hasNext();){
					DebitoAutomatico listaLog = it.next();
				
					dtm.addRow(new Object[] {listaLog.getCodDebito(), listaLog.getTipoDebito() , listaLog.getOperadora(),
							listaLog.getCodigoConsumidor(), f.format(listaLog.getDataDebito()), listaLog.getValorDebito(), listaLog.getNumConta()});

				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}