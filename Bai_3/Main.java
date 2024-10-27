package Bai_3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaiKhoan tk = new TaiKhoan("1234567890", "NGUYEN VAN A", 50000, "123456");
        TaiKhoanTietKiem tietKiem = new TaiKhoanTietKiem("1234567890", "NGUYEN VAN A",0, "123456",0,0);
        TaiKhoanThanhToan thanhToan = new TaiKhoanThanhToan("1234567890", "NGUYEN VAN A", tk.soDu, "123456", 0);

        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");

        System.out.println("Tai Khoan Ngan Hang Tạo Cho Ban La:");
        System.out.println(tk);
        System.out.println("------");
        System.out.println("Ban Duoc Doi Ten Tai Khoan Va Doi Mat Khau ");
        System.out.println("Doi Ten");
        System.out.print("Nhap Ten Tai Khoan Cua Ban: ");
        String n = scanner.nextLine();
        tk.setChuTaiKhoa(n);
        System.out.println("Doi Mat Khau");
        System.out.print("Nhap mat khau moi cua ban: ");
        String m = scanner.nextLine();
        tk.doiMatKhau(m);
        System.out.println("-----");
        System.out.println(tk.toStringFULL());

        int luaChon;
        do {
            System.out.println("-----");
            System.out.println("Ban Muon Lua Chon Nao:");
            System.out.println("1. Rut Tien");
            System.out.println("2. Gui Tien");
            System.out.println("3. Doi Mat Khau");
            System.out.println("4. Tai khoan thanh toan");
            System.out.println("5. Tai khoan tiet kiem");
            System.out.println("6. Kiem tra so du");
            System.out.println("7. Thoat");
            System.out.print("Lua chon thu: ");
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhap so tien can rut: ");
                    double rut = scanner.nextDouble();
                    tk.rutTien(rut);
                    thanhToan.soDu = tk.soDu; // Cập nhật số dư của tài khoản thanh toán

                    break;
                case 2:
                    System.out.print("Nhap so tien can gui: ");
                    double gui = scanner.nextDouble();
                    tk.guiTien(gui);
                    thanhToan.soDu = tk.soDu; // Cập nhật số dư của tài khoản thanh toán
                    break;
                case 3:
                    scanner.nextLine(); // Đọc bỏ dòng mới sau khi nhập số
                    System.out.print("Nhap Mat Khau Moi Cua Ban: ");
                    String dmkm = scanner.nextLine();
                    tk.doiMatKhau(dmkm);
                    System.out.println("Mat Khau Moi Cua Ban La: " + tk.getMatKhau());
                    break;
                case 4:
                    thanhToan.nhapPhiDichVuHangThang();
                    thanhToan.truPhiDichVu();
                    tk.soDu = thanhToan.soDu;
                    break;
                case 5:
                    System.out.print("Nhap so tien can gui vao tai khoan tiet kiem: ");
                    double soTienGui = scanner.nextDouble();
                    thanhToan.soDu = tk.soDu; // Cập nhật số dư của tài khoản thanh toán
                    if (soTienGui <= tk.soDu) {
                        tietKiem.guiTienTietKiem(soTienGui);
                        tk.soDu -= soTienGui;
                        System.out.println("Số tiền còn lại trong tài khoản chính là: " + decimalFormat.format(tk.soDu) + " VNĐ");
                        tietKiem.nhaplaiSuat();
                        tietKiem.tinhlaiSuat();
                        tietKiem.inlaiSuat();
                    } else {
                        System.out.println("Số dư không đủ để gửi vào tài khoản tiết kiệm.");
                    }
                    break;

                case 6:
                    System.out.println("Số dư hiện tại của bạn là: " + decimalFormat.format(tk.soDu) + " VNĐ");
                    break;
                case 7:
                    System.out.println("Cam On Da Su Dung Dich Vu");
                    break;
                default:
                    System.out.println("Lua Chon Khong Hop Le. Vui Long Chon Lai!");
                    break;
            }
        } while (luaChon != 7);
        scanner.close();
    }
}
