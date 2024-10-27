package Bai_3;

import java.util.Scanner;

public class TaiKhoanThanhToan extends TaiKhoan {
    public double phiDichVuHangThang;

    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double phiDichVuHangThang) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.phiDichVuHangThang = phiDichVuHangThang;
    }

    public TaiKhoanThanhToan() {
        super();
    }

    public void nhapPhiDichVuHangThang() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập phí dịch vụ hàng tháng: ");
        this.phiDichVuHangThang = scanner.nextDouble();
    }

    public void truPhiDichVu() {
        System.out.println("Số dư hiện tại: " + soDu);
        System.out.println("Phí dịch vụ hàng tháng: " + phiDichVuHangThang);
        if (soDu >= phiDichVuHangThang) {
            soDu -= phiDichVuHangThang;
            System.out.println("Đã trừ phí dịch vụ hàng tháng: " + phiDichVuHangThang + " VNĐ");
            System.out.println("Bạn còn " + soDu + " VNĐ");
        } else {
            System.out.println("Số tiền trong tài khoản không đủ để trừ phí dịch vụ.");
        }
    }
}
