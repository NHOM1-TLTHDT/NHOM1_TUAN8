package NganHang;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Scanner;

public class TaiKhoan {
    DecimalFormat df = new DecimalFormat("#,###.##");
    Scanner scanner = new Scanner(System.in);
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected double soDu;
    protected String matKhau;

    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }


    public String getSoTaiKhoan() {
        return this.soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return this.chuTaiKhoan;
    }

    public void setChuTaiKhoa(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }

    public String getSoDu() {
        return df.format(this.soDu);
    }

    public String getMatKhau() {
        return this.matKhau;
    }

    public String setMatKhau(String maKhau) {
        return this.matKhau = matKhau;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        TaiKhoan other = (TaiKhoan) obj;
        if (other.matKhau == null) return false;
        return this.matKhau.equals(other.matKhau);
    }

    public void doiMatKhau(String mkm) {
        String mkc;
        do {
            System.out.print("Nhap mat khau cu: ");
            mkc = scanner.nextLine();
            try {
                if (this.matKhau.equals(mkc)) {
                    System.out.println("Doi Mat Khau Thanh Cong");
                    this.matKhau = mkm;
                    break;
                } else
                    System.out.println("Doi Mat Khau Khong Thanh Cong!\nVui Long Nhap Lai");

            } catch (Exception e) {
                System.out.println("Loi Tao Mat Khau");
            }
        } while (!this.matKhau.equals(mkc));

    }

    public void guiTien(double gui) {
        if (gui > 10000) {
            System.out.print("Giao Dich Thanh Cong\nSo Du Cua Ban La: " + df.format(this.soDu += gui) + "VNĐ\n");
        } else {
            System.out.print("Giao Dich Khong Thanh Cong\nSo Tien Gui Khong Hop Le!(So Tien Gui Phai Lon Hon 10.000VNĐ)\nSo Du Cua Ban La: " + df.format(this.soDu) + "VNĐ\n");
        }
    }

    public void rutTien(double rut) {
        if (rut <= soDu && rut >= 10000) {
            System.out.println("Rut Tien Thanh Cong");
            System.out.println("So Du Con Lai La: " + df.format(this.soDu -= rut) + "VNĐ\n");
        } else {
            System.out.print("Rut Tien Khong Thang Cong\nTien Rut Khong Hop Le(So Tien Rut Phai Lon Hon Hoac Bang 10.000VNĐ)\nSo Du Cua Ban La: " + df.format(this.soDu) + "VNĐ\n");
        }
    }

    public int otp() {
        SecureRandom random = new SecureRandom();
        int value = random.nextInt(900000) + 100000;
        return value;
    }

    @Override
    public String toString() {
        return "Tên Tài Khoản Ngân Hàng Cấp: " + this.chuTaiKhoan + "\nSố Tài Khoản: " + this.soTaiKhoan + "\nSố Dư Tài Khoản: " + df.format(this.soDu) + "VNĐ" + "\nMật Khẩu Ngân Hàng Cấp: " + this.matKhau;
    }

    public String toStringFULL() {
        return "Tên Tài Khoản Của Bạn: " + this.chuTaiKhoan + "\nSố Tài Khoản: " + this.soTaiKhoan + "\nSố Dư Tài Khoản: " + df.format(this.soDu) + "VNĐ" + "\nMật Khẩu Của Bạn Là: " + this.matKhau;
    }


}

