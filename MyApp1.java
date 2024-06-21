package TryHard8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.ldap.spi.LdapDnsProvider;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MyApp1 extends JFrame{
	JPanel pnChua, pnTop, pnTable, pnTT, pnSP, pnThaoTac;
	JLabel lbTen, lbDiaChi, lbSDT, lbBill;
	JTextField tfTen, tfDiaChi, tfSDT;
	JRadioButton rbBanhTrang, rbTraSua, rbKhoaiTay, rbMacho;
	ButtonGroup group;
	JButton btnThoat, btnXoa, btnThanhToan;
	DefaultTableModel model;
	JTable table;
	JScrollPane scrollPane;
	private double tongGia =0;
	private int stt =1;
	
	public MyApp1() {
		setTitle("Mua Hang Online");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pnChua = new JPanel();
		pnChua.setLayout(new BorderLayout());
		//Top
		pnTop = new JPanel();
		pnTop.setLayout(new BorderLayout());
		//Thong tin
		pnTT = new JPanel();
		pnTT.setLayout(new GridLayout(3, 2));
		lbTen = new JLabel("Ho va ten");
		lbDiaChi = new JLabel("Dia chi");
		lbSDT = new JLabel("So dien thoai");
		tfTen = new JTextField();
		tfDiaChi = new JTextField();
		tfSDT = new JTextField();
		
		pnTT.add(lbTen);pnTT.add(tfTen);
		pnTT.add(lbDiaChi);pnTT.add(tfDiaChi);
		pnTT.add(lbSDT);pnTT.add(tfSDT);
		pnTT.setBorder(BorderFactory.createTitledBorder("Thong Tin Khach Hang"));
		pnTop.add(pnTT, BorderLayout.NORTH);
		pnChua.add(pnTop, BorderLayout.NORTH);
		//San Pham
		pnSP = new JPanel();
		pnSP.setLayout(new GridLayout(2,2));
		group = new ButtonGroup();
		rbBanhTrang = new JRadioButton("Banh Trang Tron-15000");
		rbKhoaiTay = new JRadioButton("Khoai Tay Chien-5000");
		rbTraSua = new JRadioButton("Tra Sua Tran Chau-20000");
		rbMacho = new JRadioButton("Tra Sua Thach Macho-20000");
		group.add(rbBanhTrang);
		group.add(rbKhoaiTay);
		group.add(rbMacho);
		group.add(rbTraSua);
		rbBanhTrang.addActionListener(new XuLiRadio());
		rbKhoaiTay.addActionListener(new XuLiRadio());
		rbMacho.addActionListener(new XuLiRadio());
		rbTraSua.addActionListener(new XuLiRadio());
		pnSP.add(rbBanhTrang);
		pnSP.add(rbTraSua);
		pnSP.add(rbKhoaiTay);
		pnSP.add(rbMacho);
		pnSP.setBorder(BorderFactory.createTitledBorder("Chon San Pham"));
		pnTop.add(pnSP, BorderLayout.CENTER);
		//Thao tac
		pnThaoTac = new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		btnThoat = new JButton("Thoat");
		btnXoa = new JButton("XoaSP");
		btnThanhToan = new JButton("ThanhToan");
		
		btnThanhToan.addActionListener(new XuLiButton());
		btnThoat.addActionListener(new XuLiButton());
		btnXoa.addActionListener(new XuLiButton());
		
		pnThaoTac.add(btnThoat);
		pnThaoTac.add(btnXoa);
		pnThaoTac.add(btnThanhToan);
		pnThaoTac.setBorder(BorderFactory.createTitledBorder("Thao Tac Dat Hang"));
		pnTop.add(pnThaoTac, BorderLayout.SOUTH);
		//table
		pnTable = new JPanel();
		String[] headerTable = {"STT", "Ten San Pham", "Don Gia"};
		model = new DefaultTableModel(headerTable, 0);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		pnTable.add(scrollPane);
		pnChua.add(pnTable, BorderLayout.CENTER);
		//thanh toan
		lbBill = new JLabel(tongGia+"");
		lbBill.setHorizontalAlignment(SwingConstants.LEFT);
		lbBill.setBorder(BorderFactory.createTitledBorder("Tong so tien can thanh toan"));
		pnChua.add(lbBill, BorderLayout.SOUTH);
		
		getContentPane().add(pnChua);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public class XuLiRadio implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(rbBanhTrang.isSelected()) {
				int index = rbBanhTrang.getText().indexOf("-");
				String tenSP = rbBanhTrang.getText().substring(0, index);
				double gia = Double.parseDouble(rbBanhTrang.getText().substring(index+1, rbBanhTrang.getText().length()));
				tongGia+=gia;
				String[] row = {stt++ +"", tenSP, gia+""};
				model.addRow(row);
			}
			else if(rbKhoaiTay.isSelected()) {
				int index = rbKhoaiTay.getText().indexOf("-");
				String tenSP = rbKhoaiTay.getText().substring(0, index);
				double gia = Double.parseDouble(rbKhoaiTay.getText().substring(index+1, rbKhoaiTay.getText().length()));
				tongGia+=gia;
				String[] row = {stt++ +"", tenSP, gia+""};
				model.addRow(row);
			}
			else if(rbMacho.isSelected()) {
				int index = rbMacho.getText().indexOf("-");
				String tenSP = rbMacho.getText().substring(0, index);
				double gia = Double.parseDouble(rbMacho.getText().substring(index+1, rbMacho.getText().length()));
				tongGia+=gia;
				String[] row = {stt++ +"", tenSP, gia+""};
				model.addRow(row);
			}
			else if(rbTraSua.isSelected()) {
				int index = rbTraSua.getText().indexOf("-");
				String tenSP = rbTraSua.getText().substring(0, index);
				double gia = Double.parseDouble(rbTraSua.getText().substring(index+1, rbTraSua.getText().length()));
				tongGia+=gia;
				String[] row = {stt++ +"", tenSP, gia+""};
				model.addRow(row);
			}
			
		}
		
	}
	public class XuLiButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton user = (JButton) e.getSource();
			if(user==btnThoat) {
				int option = JOptionPane.showConfirmDialog(null, "Ban muon thoat?", "Xac Nhan", JOptionPane.YES_NO_OPTION);
				if(option==0) {
					System.exit(0);
				}else {
					stt=0;
					tongGia=0;
					rbBanhTrang.setSelected(false);
					rbKhoaiTay.setSelected(false);
					rbMacho.setSelected(false);
					rbTraSua.setSelected(false);
					model.setRowCount(0);
					lbBill.setText(tongGia+"");
				}
			}else if(user==btnThanhToan) {
					lbBill.setText(tfTen.getText()+" "+tfDiaChi.getText()+" "+tfSDT.getText()+" "+ "Tong thanh tien: "+tongGia+"");
			}else if(user==btnXoa) {
				double giaXoa = Double.parseDouble(((String) table.getValueAt(table.getSelectedRow(), 2)));
				tongGia-=giaXoa;
				model.removeRow(table.getSelectedRow());
			}
			
		}
		
	}
	public static void main(String[] args) {
		new MyApp1();
	}

}
