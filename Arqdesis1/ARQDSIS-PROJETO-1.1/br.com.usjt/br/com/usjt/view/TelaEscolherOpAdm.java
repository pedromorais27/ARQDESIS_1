package br.com.usjt.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.usjt.controller.DispenserCTRL;
import br.com.usjt.controller.LogDoSistemaCTRL;
import br.com.usjt.model.Dispenser;
import br.com.usjt.model.Log;

public class TelaEscolherOpAdm extends JFrame {

	private JPanel contentPane;

	public TelaEscolherOpAdm() {
		setBounds(100, 100, 196, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnLogSistema = new JButton("Logs do Sistema");
		btnLogSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdmLogSistemas log = new LogDoSistemaCTRL(new Log());
				dispose();
			}
		});
		panel.add(btnLogSistema);
		
		JButton btnOpDispenser = new JButton("Opcoes do Dispenser");
		btnOpDispenser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdmDispenser dis = new DispenserCTRL(new Dispenser());
				dispose();
			}
		});
		panel.add(btnOpDispenser);
	}
}