package br.com.usjt.view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class TelaAdmDoSistemaLogin {
	public  String senha = "123321";
	public JPasswordField jpf;
	
	public TelaAdmDoSistemaLogin() {
		//Criar a mensagem sera exibida
		JLabel label = new JLabel("Digite a senha do administrador do sistema:");
		//criar o componente grafico que recebera o que for digitado
		jpf = new JPasswordField();
		//Exibir a janela para o usuario
		JOptionPane.showConfirmDialog(null,
				new Object[]{label, jpf}, "Senha:",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		//Pegamos o que foi digitado e comparamos com a senha correta
		String senhaDigitada = new String(jpf.getPassword());
	}
	
	
	public boolean validar(){
		boolean validar = false;
		//Pegamos o que foi digitado e comparamos com a senha correta
		String senhaDigitada = new String(jpf.getPassword());
		if (senha.equals(senhaDigitada)){
			TelaEscolherOpAdm frame = new TelaEscolherOpAdm();
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setSize(200,200);
			validar = true;
		}else {
			JOptionPane.showMessageDialog(null, "Senha de administrador incorreta !!");
			TelaAdmDoSistemaLogin adm = new TelaAdmDoSistemaLogin();
		}
		return validar;
	}
}

