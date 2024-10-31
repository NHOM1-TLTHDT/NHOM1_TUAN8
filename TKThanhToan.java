package NganHang;

import java.security.SecureRandom;
import java.util.HashMap;

public class TKThanhToan extends TaiKhoan {

    public TKThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau); // Gọi constructor của lớp cha
    }

    public static double kiemTra(HashMap<String, Double> ck, String soTaiKhoan, double tienCK) {
        if (ck.containsKey(soTaiKhoan)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void ChuyenKhoan(HashMap<String, Double> ck, String soTaiKhoan, double tienCK) {
        if ((kiemTra(ck, soTaiKhoan, tienCK)) == 1) {
            ck.replace(soTaiKhoan, ck.get(soTaiKhoan) + tienCK); // Thêm tiền vào tài khoản
        }
    }

    public static void in(HashMap<String, Double> ck, String soTaiKhoan, double tienCK) {
        if ((TKThanhToan.kiemTra(ck, soTaiKhoan, tienCK)) == 1) {
            System.out.print("Chuyển khoản thành công, số dư của bạn là: ");
        } else System.out.println("Số tài khoản không tồn tại.");
    }

}
