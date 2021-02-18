package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Veiculo;
import model.dao.VeiculoDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JFCadastroVeiculos extends JFrame {

	private JPanel contentPane;
	private JTextField txtModelo;
	private JTextField txtChassi;
	private JTextField txtMarca;
	private JTextField txtPlaca;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastroVeiculos frame = new JFCadastroVeiculos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFCadastroVeiculos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(96, 44, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setBounds(252, 44, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Chassi");
		lblNewLabel_2.setBounds(96, 97, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Placa");
		lblNewLabel_3.setBounds(252, 97, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ano");
		lblNewLabel_4.setBounds(96, 150, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CambioA");
		lblNewLabel_5.setBounds(252, 150, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(96, 69, 96, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtChassi = new JTextField();
		txtChassi.setBounds(96, 122, 96, 20);
		contentPane.add(txtChassi);
		txtChassi.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(252, 69, 96, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(252, 122, 96, 20);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JSpinner spnAno = new JSpinner();
		spnAno.setBounds(96, 175, 96, 20);
		contentPane.add(spnAno);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(252, 171, 46, 23);
		contentPane.add(rdbtnSim);
		
		JRadioButton rdbtnNao = new JRadioButton("N\u00E3o");
		rdbtnNao.setBounds(300, 171, 48, 23);
		contentPane.add(rdbtnNao);
		
		ButtonGroup CambioA = new ButtonGroup();
		CambioA.add(rdbtnSim);
		CambioA.add(rdbtnNao);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(96, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo v = new Veiculo();
				VeiculoDAO dao = new VeiculoDAO();
				v.setModelo(txtModelo.getText());
				v.setMarca(txtMarca.getText());
				v.setChassi(txtChassi.getText());
				v.setPlaca(txtPlaca.getText());
				v.setAno(Integer.parseInt(spnAno.getValue().toString()));

                if(rdbtnNao.isSelected()) {
                    v.setCambioA(false);
                }
                else if (rdbtnSim.isSelected()) {
                    v.setCambioA(true);
                }
                dao.create(v);
				
			}
		});
		btnCadastrar.setBounds(269, 227, 89, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_6 = new JLabel("Cadastro de Ve\u00EDculo");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_6.setBounds(139, 11, 163, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtModelo.setText(null);
				txtMarca.setText(null);
				txtChassi.setText(null);
				txtPlaca.setText(null);
				spnAno.setValue(0);
				CambioA.clearSelection();
				
			}
		});
		btnLimpar.setBounds(181, 227, 89, 23);
		contentPane.add(btnLimpar);
	}

}
