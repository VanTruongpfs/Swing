package FinalSwing;

import java.util.ArrayList;

public class QuanLiBanHang {
	private ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();

	public QuanLiBanHang(ArrayList<KhachHang> listKH) {
		this.listKH = listKH;
	}
	//b
	public void themKhachHang(KhachHang kh) {
		if(!tonTai(kh.getMaKH())) {
			listKH.add(kh);
			System.out.println("Da them");
		}else {
			System.out.println("Khach hang da ton tai");
		}
	}
	public boolean tonTai(String maKH) {
		for (KhachHang khachHang : listKH) {
			if(khachHang.getMaKH().equals(maKH)) {
				return true;
			}
		}
		return false;
	}
	//c
	public void themSanPham(String maKH, SanPham sp) {
		if(tonTai(maKH)) {
			for (KhachHang khachHang : listKH) {
				if(khachHang.getMaKH().equals(maKH)) {
					khachHang.getListSP().add(sp);
				}
			}
		}else {
			System.out.println("khach hang khong ton tai");
		}
	}
	//d
	public SanPham timSanPham(String maSP) {
		SanPham sp = null;
		for (KhachHang khachHang : listKH) {
			for (SanPham sanPham : khachHang.getListSP()) {
				if(sanPham.getMaSP().equals(maSP)) {
					return sanPham;
				}
			}
		}
		return sp;
	}
	//e 
	public void capNhatDonGiaSP(String maSP, double giaGiaMoi){
		for (KhachHang khachHang : listKH) {
			for (SanPham sanPham : khachHang.getListSP()) {
				if(sanPham.getMaSP().equals(maSP)) {
					sanPham.dongiaSP = giaGiaMoi;
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		Date d1 = new Date(1, 2, 2023);
		Date d2 = new Date(1, 5, 2023);
		ArrayList<SanPham> listSP1 = new ArrayList<SanPham>();
		ArrayList<SanPham> listSP2 = new ArrayList<SanPham>();
		
		ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
		QuanLiBanHang quanLi = new QuanLiBanHang(listKH);
		//b
		KhachHang kh1 = new KhachHang("111", "Le Van A", listSP1);
		KhachHang kh2 = new KhachHang("222", "Le Van B", listSP1);
		quanLi.themKhachHang(kh2);
		quanLi.themKhachHang(kh1);
		quanLi.themKhachHang(kh1);
		//c
		SanPham sp1 = new ThucPham("1", "Ga", 50000, d1, d2);
		SanPham sp2 = new ThoiTrang("2", "Ao", 40000, d1);
		quanLi.themSanPham("111", sp1);
		quanLi.themSanPham("222", sp2);
		quanLi.themSanPham("333", sp1);
		//d
		System.out.println("tim thay " + quanLi.timSanPham("1"));
		System.out.println(quanLi.timSanPham("3"));
		//e
		quanLi.capNhatDonGiaSP("1", 100000);
		System.out.println(sp1);
	}
}
