package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Veiculo;
import model.dao.VeiculoDAO;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class JFListarVeiculo extends JFrame {

	private JPanel contentPane;
	private JTable JTVeiculo;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarVeiculo frame = new JFListarVeiculo();
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
	public JFListarVeiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 414, 110);
		contentPane.add(scrollPane);
		
		JTVeiculo = new JTable();
		scrollPane.setViewportView(JTVeiculo);
		
		JTVeiculo.setModel(new DefaultTableModel(
	            new Object[][] {
	            },	
	            new String[] {
	                "Model", "Marca", "Chassi", "Placa", "Ano","CambioA"
	            }
	        ));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(177, 17, 46, 14);
		contentPane.add(lblNewLabel);
		
		readJtable();
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	dispose();
            }
        });
		btnCancelar.setAction(action);
		btnCancelar.setBounds(10, 197, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if(JTVeiculo.getSelectedRow() != -1) {
                    int opcao = JOptionPane.showConfirmDialog(null, "Deseja deletar o Veiculo selecionado", "Deletar", JOptionPane.YES_NO_OPTION);
                    if(opcao == 0) {
                        VeiculoDAO dao = new VeiculoDAO();
                        Veiculo v = new Veiculo();
                        v.setId((int) JTVeiculo.getValueAt(JTVeiculo.getSelectedRow(), 0));
                        dao.delete(v);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Selecione uma linha");
                }
                readJtable();

            }
            }
        );
		btnDeletar.setAction(action_1);
		btnDeletar.setBounds(116, 197, 89, 23);
		contentPane.add(btnDeletar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent arg0) {
            	if(JTVeiculo.getSelectedRow() != -1) {
                    JFAtualizarVeiculo ac = new JFAtualizarVeiculo((int)JTVeiculo.getValueAt(JTVeiculo.getSelectedRow(), 0 ));
                    ac.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Selecione uma linha");
                }
                readJtable();
            }
        });
		btnAlterar.setAction(action_2);
		btnAlterar.setBounds(226, 197, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnCadastrar = new JButton("Cadastro");
		btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	JFCadastroVeiculos ac;
                ac = new JFCadastroVeiculos();
                ac.setVisible(true);
            }
        });
		btnCadastrar.setAction(action_3);
		btnCadastrar.setBounds(335, 197, 89, 23);
		contentPane.add(btnCadastrar);}
		
		public void readJtable() {
	        DefaultTableModel modelo = (DefaultTableModel) JTVeiculo.getModel();
	        modelo.setNumRows(0);
	        VeiculoDAO vDAO = new VeiculoDAO();
	        for(Veiculo v: vDAO.read()) {
	            String CambioA = null;
	            if(v.getCambioA() == true) {
	            	CambioA = ("Sim");
	            }
	            else {
	            	CambioA = ("Não");
	            }
	            modelo.addRow(new Object[] {
	            		v.getId(),
						v.getModelo(),
						v.getMarca(),
						v.getChassi(),
						v.getPlaca(),
						v.getAno(),
						CambioA
	            });
	        }

	    }
		
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cancelar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Deletar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Alterar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Cadastro");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
