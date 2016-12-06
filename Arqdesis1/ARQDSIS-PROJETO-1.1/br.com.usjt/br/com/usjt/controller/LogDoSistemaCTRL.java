package br.com.usjt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.table.DefaultTableModel;

import br.com.usjt.model.Log;
import br.com.usjt.view.TelaAdmLogSistemas;
import br.com.usjt.view.TelaEscolherOpAdm;

public class LogDoSistemaCTRL extends TelaAdmLogSistemas{

	public LogDoSistemaCTRL(Log log){
		super(log);
		addBtnPesquisarListener(new BtnPesquisarListener());
		addBtnVoltarListener(new BtnVoltarListener());
	}

	public void update(Observable arg0, Object arg1) {

	}
	
	class BtnVoltarListener implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			TelaEscolherOpAdm frame = new TelaEscolherOpAdm();
			frame.setVisible(true);
			frame.setSize(200,200);
			dispose();
		}
	}

	class BtnPesquisarListener implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			Log log = new Log();

			try {
				ArrayList<Log> recuper = log.consultarestatisticas();

				DefaultTableModel dtm = (DefaultTableModel) tblResultado.getModel();

				//se não existir nenhuma informação consultada ele remove todas as linhas da tabela
				while (tblResultado.getRowCount() > 0) {
					dtm.removeRow(0);
				}

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
				
				for(Iterator<Log> it = recuper.iterator(); it.hasNext();){
					Log listaLog = it.next();
					dtm.addRow(new Object[] {listaLog.getCodigoItemLog(), listaLog.getCodigoMovimento(), listaLog.getOperacao(),
							listaLog.getValor(), listaLog.getConta(), listaLog.getAgencia(), listaLog.getCodigoCliente(), f.format(listaLog.getDataOperacao())});
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}