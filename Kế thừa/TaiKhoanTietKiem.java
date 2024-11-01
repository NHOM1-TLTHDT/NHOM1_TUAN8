package Bai_3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TaiKhoanTietKiem extends TaiKhoan {
    private double laiSuat;
    private int kyHan;
    private double tienLai;

    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double laiSuat, int kyHan) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public TaiKhoanTietKiem() {
        super();
    }

    public void nhaplaiSuat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap lai suat (%): ");
        this.laiSuat = scanner.nextDouble();
        System.out.print("Nhap ky han (thang): ");
        this.kyHan = scanner.nextInt();
    }

    public void tinhlaiSuat() {
        this.tienLai = this.soDu * (this.laiSuat / 100) * (this.kyHan / 12.0);
    }

    public void inlaiSuat() {
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("Tien lai suat cua ban la: " + df.format(this.tienLai) + " VNĐ");
    }

    public void guiTienTietKiem(double soTienGui) {
        if (soTienGui > 0) {
            this.soDu += soTienGui;
            System.out.println("Giao Dich Gui Tien Thanh Cong. So Du Moi La: " + new DecimalFormat("#,###.##").format(this.soDu) + " VNĐ");
        } else {
            System.out.println("So Tien Gui Khong Hop Le. Vui Long Nhap Lai.");
        }
    }

}
