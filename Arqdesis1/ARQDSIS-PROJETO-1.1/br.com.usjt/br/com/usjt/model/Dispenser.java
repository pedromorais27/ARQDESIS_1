package br.com.usjt.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JOptionPane;
import br.com.usjt.DAO.DispenserDAO;

public class Dispenser extends Observable{

	private int nota, quantidade;

	public Dispenser(int nota, int quantidade) {
		this.nota = nota;
		this.quantidade = quantidade;
	}

	public Dispenser() {
	}

	public int getNota() {
		return nota;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setNota(int nota) {
		this.nota = nota;
		setChanged();
		notifyObservers();

	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		setChanged();
		notifyObservers();
	}

	public void contarNotas(double valorRetirar){

		try{
			//cria um arrayList para serem armazenado todas as informações do banco de dados
			ArrayList<Dispenser> notas = new ArrayList<Dispenser>();

			//cria um arrayList para serem armazenado todas as informações do banco de dados

			DispenserDAO dispenserDAO = new DispenserDAO();

			ResultSet rs = null;

			rs = dispenserDAO.recuperarNotas().executeQuery();

			while (rs.next()){
				notas.add(new Dispenser(rs.getInt(1), rs.getInt(2)));
			}

			int notas50 = notas.get(2).getQuantidade();
			int notas20 = notas.get(1).getQuantidade();
			int notas10 = notas.get(0).getQuantidade();
			
			if(notas10  == 0 || notas20 == 0 || notas50 == 0){
				JOptionPane.showMessageDialog(null, "As notas disponiveis estao acabando. Favor consulte o administrador "
						+ " do sistema para que ele resete o dispenser");
			}

			notas50 -= valorRetirar / 50;

			if (notas50 < 0) {
				notas50 =  notas.get(2).getQuantidade();
				valorRetirar -= (notas50 * 50);
				notas50 = 0;
			} else {
				valorRetirar %= 50;
			}

			notas20 -= valorRetirar / 20;

			if (notas20 < 0) {
				notas20 = notas.get(1).getQuantidade();
				valorRetirar -= (notas20 * 20);
				notas20 = 0;
			} else {
				valorRetirar %= 20;
			}

			notas10 -= valorRetirar / 10;

			if (notas10 < 0) {
				throw new Exception();
			} else {
				valorRetirar %= 10;
			}

			notas.get(2).setQuantidade(notas50);
			notas.get(1).setQuantidade(notas20);
			notas.get(0).setQuantidade(notas10);

			dispenserDAO.retirarNota(notas);

			JOptionPane.showMessageDialog(null, "Nao emitimos comprovante para essa operacao");
		}catch(Exception e){
		}
	}

	public ArrayList<Dispenser> consultarExtratoDeNotas(){

		//cria um arrayList para serem armazenado todas as informações do banco de dados
		ArrayList<Dispenser> notas = new ArrayList<Dispenser>();

		//cria um arrayList para serem armazenado todas as informações do banco de dados
	
		try {
			DispenserDAO dispenserDAO = new DispenserDAO();
			
			ResultSet rs = null;

			rs = dispenserDAO.recuperarNotas().executeQuery();

			while (rs.next()){
				notas.add(new Dispenser(rs.getInt(1), rs.getInt(2)));
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notas;
	}
}