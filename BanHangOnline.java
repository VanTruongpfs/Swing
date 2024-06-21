package FinalSwing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import tryhard3.MyFrame.XuLiRadio;

public class BanHangOnline extends JFrame{
	JPanel pnChua, pnTop, pnTT, pnSP, pnThaoTac;
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
	public BanHangOnline() {
		setTitle("Mua Hang Online");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pnChua = new JPanel();
		pnChua.setLayout(new BorderLayout());
//Top
		pnTop = new JPanel();
		pnTop.setLayout(new BorderLayout());
		//thong tin
		pnTT = new JPanel();
		pnTT.setLayout(new GridLayout(3,2));
		pnTT.setBorder(BorderFactory.createTitledBorder("Thong Tin Khach Hang"));
		lbTen = new JLabel("Ho va ten");
		lbDiaChi = new JLabel("Dia chi");
		lbSDT = new JLabel("So dien thoai");
		tfTen = new JTextField();
		tfDiaChi = new JTextField();
		tfSDT = new JTextField();
		pnTT.add(lbTen);pnTT.add(tfTen);
		pnTT.add(lbDiaChi);pnTT.add(tfDiaChi);
		pnTT.add(lbSDT);pnTT.add(tfSDT);
		pnTop.add(pnTT, BorderLayout.NORTH);
		pnChua.add(pnTop, BorderLayout.NORTH);
		//san pham
		pnSP = new JPanel();
		pnSP.setLayout(new GridLayout(2, 2));
		pnSP.setBorder(BorderFactory.createTitledBorder("Chon San Pham"));

		rbBanhTrang = new JRadioButton("Banh Trang Tron-15000");
		rbKhoaiTay = new JRadioButton("Khoai Tay Chien-5000");
		rbMacho = new JRadioButton("Tra Sua Tran Chau-20000");
		rbTraSua = new JRadioButton("Tra Sua Thach Macho-20000");
		
		group = new ButtonGroup();
		group.add(rbBanhTrang);
		group.add(rbKhoaiTay);
		group.add(rbMacho);
		group.add(rbTraSua);
		
		rbBanhTrang.addActionListener(new XuLiRadio());
		rbKhoaiTay.addActionListener(new XuLiRadio());
		rbTraSua.addActionListener(new XuLiRadio());
		rbMacho.addActionListener(new XuLiRadio());
		
		pnSP.add(rbBanhTrang);
		pnSP.add(rbKhoaiTay);
		pnSP.add(rbMacho);
		pnSP.add(rbTraSua);
		pnTop.add(pnSP, BorderLayout.CENTER);
		//Thao Tac
		pnThaoTac = new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnThaoTac.setBorder(BorderFactory.createTitledBorder("Thao Tac Dat Hang"));
		btnThanhToan = new JButton("Thanh Toan");
		btnThoat = new JButton("Thoat");
		btnXoa = new JButton("XoaSP");
		
		btnThanhToan.addActionListener(new XuLiButton());
		btnThoat.addActionListener(new XuLiButton());
		btnXoa.addActionListener(new XuLiButton());
		
		pnThaoTac.add(btnThoat);
		pnThaoTac.add(btnXoa);
		pnThaoTac.add(btnThanhToan);
		pnTop.add(pnThaoTac, BorderLayout.SOUTH);
//table
		String[] col = {"STT", "Ten san pham", "Don gia"};
		model = new DefaultTableModel(col,0);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		pnChua.add(scrollPane, BorderLayout.CENTER);
// thanh toan
		lbBill = new JLabel("0.0");
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
			if(table.getRowCount()==0) {
				stt=1;
			}
			if(rbBanhTrang.isSelected()) {
				String sp = rbBanhTrang.getText();
				String tenSP = sp.substring(0, sp.indexOf("-"));
				double gia = Double.parseDouble(sp.substring(sp.indexOf("-")+1, sp.length()));
				tongGia+=gia;
				String[] row = {stt++ +"", tenSP, gia+""};
				model.addRow(row);
			}
			else if(rbKhoaiTay.isSelected()) {
				String sp = rbKhoaiTay.getText();
				String tenSP = sp.substring(0, sp.indexOf("-"));
				double gia = Double.parseDouble(sp.substring(sp.indexOf("-")+1, sp.length()));
				tongGia+=gia;
				String[] row = {stt++ +"", tenSP, gia+""};
				model.addRow(row);
			}
			else if(rbMacho.isSelected()) {
				String sp = rbMacho.getText();
				String tenSP = sp.substring(0, sp.indexOf("-"));
				double gia = Double.parseDouble(sp.substring(sp.indexOf("-")+1, sp.length()));
				tongGia+=gia;
				String[] row = {stt++ +"", tenSP, gia+""};
				model.addRow(row);
			}
			else if(rbTraSua.isSelected()) {
				String sp = rbTraSua.getText();
				String tenSP = sp.substring(0, sp.indexOf("-"));
				double gia = Double.parseDouble(sp.substring(sp.indexOf("-")+1, sp.length()));
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
			if(user==btnThanhToan) {
				tfTen.setEditable(false);
				tfDiaChi.setEditable(false);
				tfSDT.setEditable(false);
				
				rbBanhTrang.setEnabled(false);
				rbKhoaiTay.setEnabled(false);
				rbMacho.setEnabled(false);
				rbTraSua.setEnabled(false);
				
				
				lbBill.setText(tfTen.getText()+" "+tfDiaChi.getText()+" "+tfSDT.getText()+" tong thanh tien: "+tongGia+"");
			}
			else if(user==btnThoat) {
				int option = JOptionPane.showConfirmDialog(null, "Ban muon thoat?", "Xac Nhan", JOptionPane.YES_NO_OPTION);
				if(option==0) {
					System.exit(0);
				}else {
					tongGia=0;
					model.setRowCount(0);
					lbBill.setText(tongGia+"");
					tfTen.setEditable(true);
					tfDiaChi.setEditable(true);
					tfSDT.setEditable(true);
					tfTen.setText("");
					tfDiaChi.setText("");
					tfSDT.setText("");
					
					rbBanhTrang.setEnabled(true);
					rbKhoaiTay.setEnabled(true);
					rbMacho.setEnabled(true);
					rbTraSua.setEnabled(true);
					
					group.clearSelection();
				}
			}
			else if(user==btnXoa) {
				double giaDaXoa = Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 2));
				tongGia-=giaDaXoa;
				model.removeRow(table.getSelectedRow());
			}
		}
		
	}
	public static void main(String[] args) {
		new BanHangOnline();
	}
}
