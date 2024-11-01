package Bai_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaiKhoan tk = new TaiKhoan("1234567890", "NGUYEN VAN A", 50000, "123456");
        TaiKhoanTietKiem tietKiem = new TaiKhoanTietKiem();
        TaiKhoanThanhToan thanhToan = new TaiKhoanThanhToan("1234567890", "NGUYEN VAN A" , tk.soDu ,"123456",0);
        int luaChon;
        do {
            System.out.println("-----");
            System.out.println("Ban Muon Lua Chon Nao:");
            System.out.println("1. Rut Tien");
            System.out.println("2. Gui Tien");
            System.out.println("3. Doi Mat Khau");
            System.out.println("4. Tai khoan tiet kiem");
            System.out.println("5. Tai khoan thanh toan");
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
                    scanner.nextLine();
                    System.out.print("Nhap Mat Khau Moi Cua Ban: ");
                    String dmkm = scanner.nextLine();
                    tk.doiMatKhau(dmkm);
                    System.out.println("Mat Khau Moi Cua Ban La: " + tk.getMatKhau());
                    break;
                case 4:
                    System.out.print("Nhap so tien can gui vao tai khoan tiet kiem: ");
                    double soTienGui = scanner.nextDouble();

                    if (soTienGui <= tk.soDu) { 
                        tk.soDu -= soTienGui;
                        tietKiem.guiTienTietKiem(soTienGui);
                        tietKiem.nhaplaiSuat();
                        tietKiem.tinhlaiSuat();
                        tietKiem.inlaiSuat();
                        System.out.println("So du tai khoan chinh sau khi gui tiet kiem: " + tk.getSoDu() + " VNĐ");
                    } else {
                        System.out.println("So tien gui lon hon so du hien tai!");
                    }
                    break;

                case 5:
                    thanhToan.nhapPhiDichVuHangThang();
                    thanhToan.truPhiDichVu();
                    tk.soDu = thanhToan.soDu; // Cập nhật số dư của tài khoản chính
                    break;
                case 6 :
                    System.out.println(" so du hien tai cua ban la " +tk.soDu +"VNĐ" );
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
