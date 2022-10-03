package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;

import bean.Camiseta;
import bean.Cliente;
import bean.Roupa;
import dao.CamisetaDAO;
import dao.ClienteDAO;
import dao.RoupaDAO;

import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Loja extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCNome;
	private JTextField textFieldCor;
	private JTextField textFieldCodigo;
	private JTextField textFieldPreco;
	private JTextField textFieldEstampa;
	private JLayeredPane layeredPane;
	private JPanel panelMenu;
	private JPanel panelProduto;
	private JLayeredPane layeredPaneProdutos;
	private JPanel panelPCamiseta;
	private JPanel panelPCalca;
	private JPanel panelPVestido;
	private JPanel panelPProdutos;
	private JPanel panelCompra;
	private JPanel panelLista;
	private JPanel panelCliente;
	private JTextField textFieldCCodigo;
	public Object codigoComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loja frame = new Loja();
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
	public Loja() {
		setTitle("Loja de Roupas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 387);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 577, 326);
		contentPane.add(layeredPane);
		
		panelMenu = new JPanel();
		layeredPane.setLayer(panelMenu, 0);
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setBounds(0, 0, 577, 326);
		layeredPane.add(panelMenu);
		panelMenu.setLayout(new GridLayout(4, 1, 5, 5));
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		panelMenu.add(label);
		
		JLabel label_1 = new JLabel("");
		panelMenu.add(label_1);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(layeredPane, panelCliente);
			}
		});
		btnCadastrarCliente.setForeground(Color.DARK_GRAY);
		btnCadastrarCliente.setBackground(Color.LIGHT_GRAY);
		btnCadastrarCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelMenu.add(btnCadastrarCliente);
		
		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(layeredPane, panelProduto);
			}
		});
		btnCadastrarProduto.setForeground(Color.DARK_GRAY);
		btnCadastrarProduto.setBackground(Color.LIGHT_GRAY);
		btnCadastrarProduto.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelMenu.add(btnCadastrarProduto);
		
		JButton btnCompra = new JButton("Comprar Produtos");
		btnCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(layeredPane, panelCompra);
			}
		});
		btnCompra.setForeground(Color.DARK_GRAY);
		btnCompra.setBackground(Color.LIGHT_GRAY);
		btnCompra.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelMenu.add(btnCompra);
		
		JButton btnLista = new JButton("Lista de Compras");
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(layeredPane, panelLista);
			}
		});
		btnLista.setForeground(Color.DARK_GRAY);
		btnLista.setBackground(Color.LIGHT_GRAY);
		btnLista.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelMenu.add(btnLista);
		
		panelCliente = new JPanel();
		panelCliente.setBackground(Color.WHITE);
		layeredPane.setLayer(panelCliente, 0);
		panelCliente.setBounds(0, 0, 577, 326);
		layeredPane.add(panelCliente);
		panelCliente.setLayout(null);
		
		JButton btnCCadastrar = new JButton("Cadastrar");
		btnCCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteDAO cDAO = new ClienteDAO();
				Cliente c = new Cliente();
				
				String nomeCliente = textFieldCNome.getText();
				if (!nomeCliente.equals("")) {
					c.setNome(nomeCliente);
					cDAO.inserir(c);
					JOptionPane.showMessageDialog(null, "Cliente cadastrado!");
				} else {
					JOptionPane.showMessageDialog(null, "Nome não registrado!");
				}
				textFieldCNome.setText("");
			}
		});
		btnCCadastrar.setBounds(187, 163, 200, 32);
		panelCliente.add(btnCCadastrar);
		
		textFieldCNome = new JTextField();
		textFieldCNome.setBounds(187, 120, 200, 32);
		panelCliente.add(textFieldCNome);
		textFieldCNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(187, 95, 200, 14);
		panelCliente.add(lblNewLabel);
		
		JButton btnCVoltar = new JButton("Voltar");
		btnCVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(layeredPane, panelMenu);
			}
		});
		btnCVoltar.setBounds(426, 283, 141, 32);
		panelCliente.add(btnCVoltar);
		
		panelProduto = new JPanel();
		layeredPane.setLayer(panelProduto, 2);
		panelProduto.setBackground(Color.WHITE);
		panelProduto.setBounds(0, 0, 577, 326);
		layeredPane.add(panelProduto);
		panelProduto.setLayout(null);
		
		JButton btnCVoltar_1 = new JButton("Voltar");
		btnCVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(layeredPane, panelMenu);
			}
		});
		btnCVoltar_1.setBounds(426, 283, 141, 32);
		panelProduto.add(btnCVoltar_1);
		
		JComboBox comboBoxProdutos = new JComboBox();
		comboBoxProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBoxProdutos) {
					if (comboBoxProdutos.getSelectedItem().equals("Camiseta")) {
						SwitchScreen(layeredPaneProdutos, panelPCamiseta);
					} else if (comboBoxProdutos.getSelectedItem().equals("Calça")) {
						SwitchScreen(layeredPaneProdutos, panelPCalca);
					} else if (comboBoxProdutos.getSelectedItem().equals("Vestido")) {
						SwitchScreen(layeredPaneProdutos, panelPVestido);
					} else {
						SwitchScreen(layeredPaneProdutos, panelPProdutos);
					}
				}
			}
		});
		comboBoxProdutos.setModel(new DefaultComboBoxModel(new String[] {"Produto", "Camiseta", "Cal\u00E7a", "Vestido"}));
		comboBoxProdutos.setBounds(10, 283, 200, 32);
		panelProduto.add(comboBoxProdutos);
		
		layeredPaneProdutos = new JLayeredPane();
		layeredPaneProdutos.setBounds(10, 11, 557, 261);
		panelProduto.add(layeredPaneProdutos);
		
		panelPCamiseta = new JPanel();
		layeredPaneProdutos.setLayer(panelPCamiseta, 0);
		panelPCamiseta.setBounds(0, 0, 557, 261);
		layeredPaneProdutos.add(panelPCamiseta);
		panelPCamiseta.setLayout(null);
		
		JComboBox comboBoxTamanho = new JComboBox();
		comboBoxTamanho.setModel(new DefaultComboBoxModel(new String[] {"P", "M", "G"}));
		comboBoxTamanho.setBounds(230, 83, 100, 32);
		panelPCamiseta.add(comboBoxTamanho);
		
		JLabel lblNewLabel_1 = new JLabel("Tamanho:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(230, 58, 100, 14);
		panelPCamiseta.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cor:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(230, 141, 100, 14);
		panelPCamiseta.add(lblNewLabel_1_1);
		
		textFieldCor = new JTextField();
		textFieldCor.setBounds(230, 158, 100, 32);
		panelPCamiseta.add(textFieldCor);
		textFieldCor.setColumns(10);
		
		JButton btnPCamiseta = new JButton("Cadastrar");
		btnPCamiseta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoupaDAO rDAO = new RoupaDAO();
				CamisetaDAO cDAO = new CamisetaDAO();
				Camiseta c = new Camiseta();
				
				int codigo = Integer.parseInt(textFieldCCodigo.getText());
				Object tamanho = comboBoxTamanho.getSelectedItem();
				String cor = textFieldCor.getText();
				String tamanhoString = tamanho.toString();
				System.out.println(tamanhoString);
				if (textFieldCCodigo.equals("") || tamanhoString.equals("") || cor.equals("")) {
					JOptionPane.showMessageDialog(null, "Dados inválidos!");
				} else {
					c.setCodigo(codigo);
					c.setCor(cor);
					c.setTamanho(tamanhoString);
					cDAO.inserir(c);
					JOptionPane.showMessageDialog(null, "Camiseta inserida!");
				}
			}
		});
		btnPCamiseta.setBounds(230, 201, 100, 32);
		panelPCamiseta.add(btnPCamiseta);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("CAMISETAS");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(10, 11, 537, 24);
		panelPCamiseta.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("C\u00F3digo:");
		lblNewLabel_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_3.setBounds(43, 101, 100, 14);
		panelPCamiseta.add(lblNewLabel_1_2_3);
		
		textFieldCCodigo = new JTextField();
		textFieldCCodigo.setColumns(10);
		textFieldCCodigo.setBounds(43, 126, 100, 32);
		panelPCamiseta.add(textFieldCCodigo);
		
		panelPCalca = new JPanel();
		layeredPaneProdutos.setLayer(panelPCalca, 0);
		panelPCalca.setBounds(0, 0, 557, 261);
		layeredPaneProdutos.add(panelPCalca);
		panelPCalca.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("N\u00FAmero:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(229, 87, 100, 14);
		panelPCalca.add(lblNewLabel_1_2);
		
		JComboBox comboBoxNúmero = new JComboBox();
		comboBoxNúmero.setModel(new DefaultComboBoxModel(new String[] {"36", "38", "40", "42", "44", "46"}));
		comboBoxNúmero.setBounds(229, 112, 100, 32);
		panelPCalca.add(comboBoxNúmero);
		
		JButton btnPCalca = new JButton("Cadastrar");
		btnPCalca.setBounds(229, 205, 100, 32);
		panelPCalca.add(btnPCalca);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("CAL\u00C7AS");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setBounds(10, 11, 537, 24);
		panelPCalca.add(lblNewLabel_1_2_1);
		
		JComboBox comboBoxCodigoCalca = new JComboBox();
		comboBoxCodigoCalca.setBounds(40, 117, 100, 32);
		panelPCalca.add(comboBoxCodigoCalca);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("C\u00F3digo:");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setBounds(40, 92, 100, 14);
		panelPCalca.add(lblNewLabel_1_2_2);
		
		panelPVestido = new JPanel();
		layeredPaneProdutos.setLayer(panelPVestido, 0);
		panelPVestido.setBounds(0, 0, 557, 261);
		layeredPaneProdutos.add(panelPVestido);
		panelPVestido.setLayout(null);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Estampa:");
		lblNewLabel_1_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_4.setBounds(229, 87, 100, 14);
		panelPVestido.add(lblNewLabel_1_2_4);
		
		JButton btnPVestido = new JButton("Cadastrar");
		btnPVestido.setBounds(229, 205, 100, 32);
		panelPVestido.add(btnPVestido);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("VESTIDOS");
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_2.setBounds(10, 11, 537, 24);
		panelPVestido.add(lblNewLabel_1_2_1_2);
		
		JComboBox comboBoxCodigoVestido = new JComboBox();
		comboBoxCodigoVestido.setBounds(40, 117, 100, 32);
		panelPVestido.add(comboBoxCodigoVestido);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_1.setBounds(40, 92, 100, 14);
		panelPVestido.add(lblNewLabel_1_2_2_1);
		
		textFieldEstampa = new JTextField();
		textFieldEstampa.setColumns(10);
		textFieldEstampa.setBounds(229, 112, 100, 32);
		panelPVestido.add(textFieldEstampa);
		
		panelPProdutos = new JPanel();
		layeredPaneProdutos.setLayer(panelPProdutos, 0);
		panelPProdutos.setBounds(0, 0, 557, 261);
		layeredPaneProdutos.add(panelPProdutos);
		panelPProdutos.setLayout(null);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("PRODUTOS");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1.setBounds(10, 11, 537, 24);
		panelPProdutos.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("C\u00F3digo:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(230, 46, 100, 14);
		panelPProdutos.add(lblNewLabel_1_3);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(230, 71, 100, 32);
		panelPProdutos.add(textFieldCodigo);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Pre\u00E7o:");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setBounds(230, 125, 100, 14);
		panelPProdutos.add(lblNewLabel_1_3_1);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setColumns(10);
		textFieldPreco.setBounds(230, 150, 100, 32);
		panelPProdutos.add(textFieldPreco);
		
		JButton btnPCadastrarProduto = new JButton("Cadastrar");
		btnPCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoupaDAO rDAO = new RoupaDAO();
				Roupa r = new Roupa();
				
				int codigo = Integer.parseInt(textFieldCodigo.getText());
				double preco = Double.parseDouble(textFieldPreco.getText());
				if (!textFieldCodigo.getText().equals("")) {
					r.setCodigo(codigo);
					r.setPreco(preco);
					rDAO.inserir(r);
					JOptionPane.showMessageDialog(null, "Roupa cadastrada!");
				} else {
					JOptionPane.showMessageDialog(null, "Dados inválidos!");
				}
			}
		});
		btnPCadastrarProduto.setBounds(230, 193, 100, 32);
		panelPProdutos.add(btnPCadastrarProduto);
		
		panelCompra = new JPanel();
		panelCompra.setBackground(Color.WHITE);
		panelCompra.setBounds(0, 0, 577, 326);
		layeredPane.add(panelCompra);
		
		panelLista = new JPanel();
		panelLista.setBackground(Color.WHITE);
		panelLista.setBounds(0, 0, 577, 326);
		layeredPane.add(panelLista);
	}
	
	public void SwitchScreen(JLayeredPane l, JPanel p) {
		l.removeAll();
		l.add(p);
		l.repaint();
		l.revalidate();
	}	
}
