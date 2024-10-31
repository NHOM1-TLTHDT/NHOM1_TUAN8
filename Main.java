package NganHang;

import java.util.HashMap;
import java.time.LocalDate;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("#,###.##");

    public static void main(String[] args) {

        TKThanhToan tkThanhToan1 = new TKThanhToan("0987654321", "NGUYEN VAN A", 50000, "123456");
        TKThanhToan tkThanhToan2 = new TKThanhToan("0982634742", "Pham Van Ly", 70000, "030705");
        TKTietKiem tkTietKiem1 = new TKTietKiem(tkThanhToan1, 0, tkThanhToan1.matKhau);
        TKTietKiem tkTietKiem2 = new TKTietKiem(tkThanhToan2, 0, tkThanhToan2.matKhau);
        HashMap<String, Double> ck = new HashMap<>();
        ck.put(tkThanhToan1.soTaiKhoan, tkThanhToan1.soDu);
        ck.put(tkThanhToan2.soTaiKhoan, tkThanhToan2.soDu);
        ck.put(tkTietKiem1.soTaiKhoan, tkTietKiem1.soDu);
        ck.put(tkTietKiem2.soTaiKhoan, tkTietKiem2.soDu);
        int count = 0;
        System.out.println("----------");
        System.out.println("Chào mừng bạn đến với ngân hàng Một Thành Viên");
        int luaChon = 0;
        do {
            System.out.println("Mời lựa chọn chương trình:");
            if (count == 0) {
                System.out.println("0. Thoát");
                System.out.println("1. Mở Tài Khoản Ngân Hàng");
                System.out.println("2. Kiểm Tra Tài Khoản: " + tkThanhToan2.getChuTaiKhoan());
            }
            if (count >= 1) {
                System.out.println("0. Thoát");
                System.out.println("1. Đăng Nhập Tài Khoản " + tkThanhToan1.getChuTaiKhoan());
                System.out.println("2. Đăng Nhập Tài Khoản " + tkThanhToan2.getChuTaiKhoan());
            }
            System.out.print("Lựa chọn của bạn: ");
            luaChon = sc.nextInt();
            switch (luaChon) {
                case 0:
                    System.out.println("Cảm ơn bạn đã đến với ngân hàng");
                    System.exit(0);
                    break;
                case 1:
                    String ten = "";
                    if (count == 0) {
                        sc.nextLine();
                        System.out.println("----------");
                        System.out.println("Tài Khoản Ngân Hàng Cấp");
                        System.out.println(tkThanhToan1.toString());
                        System.out.println("----------");
                        System.out.println("Bạn được đổi Mật Khẩu và Tên Tài Khoản:");
                        String n;
                        do {
                            System.out.print("Nhập Tên Tài Khoản của bạn: ");
                            ten = sc.nextLine();
                            if (ten.length() >= 8 && ten.length() <= 16) {
                                tkThanhToan1.setChuTaiKhoa(ten);
                            } else System.out.println("Tên Phải Đảm Bảo Có 8-> 16 Kí Tự!!!\n");
                        } while (ten.length() < 8 || ten.length() > 16);
                        String m;
                        do {
                            System.out.print("Nhập Mật Khẩu Mới Của Bạn: ");
                            m = sc.nextLine();
                            if (m.length() >= 6 && m.length() <= 30) {
                                tkThanhToan1.doiMatKhau(m);
                            } else
                                System.out.println("Lỗi! Mật Khẩu Từ 6-> 30 Kí Tự!!!\n");
                        } while (m.length() < 6 || m.length() > 30);
                        System.out.println("-----------");
                        System.out.println("Moi Lựa chọn chương trình: ");
                        System.out.printf("1. Đăng Nhập Tài Khoản: %s", ten);
                        System.out.println("\n2. Đăng Nhập Tài Khoản: " + tkThanhToan2.getChuTaiKhoan());
                        System.out.print("Lựa chọn của bạn: ");
                        luaChon = sc.nextInt();
                    }
                    if (count >= 1) {
                        sc.nextLine();

                    }
                    switch (luaChon) {
                        case 1:
                            System.out.println("----------");
                            System.out.println("Tai Khoan: " + tkThanhToan1.getChuTaiKhoan());
                            System.out.println(tkThanhToan1.toStringFULL());
                            System.out.println("-----------");
                            System.out.println("Mời Lựa Chọn Chức Năng:");
                            System.out.println("1. Gửi Tiền");
                            System.out.println("2. Rút Tiền");
                            System.out.println("3. Chuyển Khoản");
                            System.out.println("4. Trở Lại");
                            System.out.println("5. Mở sổ tiết kiệm");
                            System.out.print("Lựa chọn: ");
                            luaChon = sc.nextInt();
                            switch (luaChon) {
                                case 1:
                                    System.out.print("Nhập Số Tiền Muốn Gửi: ");
                                    double gui = sc.nextDouble();
                                    tkThanhToan1.guiTien(gui);
                                    count++;
                                    break;
                                case 2:
                                    System.out.print("Nhập Số Tiền Muốn Rút: ");
                                    double rut = sc.nextDouble();
                                    tkThanhToan1.rutTien(rut);
                                    count++;
                                    break;
                                case 3:
                                    sc.nextLine();
                                    String stK;
                                    double chuyenTien;
                                    do {
                                        System.out.print("Nhập số Tài Khoản Muốn chuyển: ");
                                        stK = sc.nextLine();
                                        if (!(ck.containsKey(stK))) {
                                            System.out.println("Số Tài Khoản Không Tồn Tại Tề");
                                        } else if (stK.equals(tkThanhToan1.soTaiKhoan)) {
                                            System.out.println("Trùng số tài khoản với chính mình!");
                                        }
                                    } while (!(ck.containsKey(stK)) || (stK.equals(tkThanhToan1.soTaiKhoan)));
                                    do {
                                        System.out.print("\nNhập số tiền muốn chuyển: ");
                                        chuyenTien = sc.nextDouble();
                                        if (tkThanhToan1.soDu < chuyenTien) {
                                            System.out.println("Không đủ tiền ấy ơi");
                                        } else if (chuyenTien < 2000) {
                                            System.out.println("Tiền ít quá không cho chuyển ấy ơi( phải >2000VNĐ)");
                                        }
                                    } while (tkThanhToan1.soDu < chuyenTien || chuyenTien < 2000);
                                    System.out.println("Xác Nhận");
                                    System.out.println("Số tài khoản: " + stK + ": " + tkThanhToan2.getChuTaiKhoan() + "\nMuốn chuyển: " + df.format(chuyenTien) + "VNĐ");
                                    int oTP = tkThanhToan1.otp();
                                    System.out.println("Mã OTP: " + oTP);
                                    System.out.print("Nhập mã OTP: ");
                                    int OTP = sc.nextInt();
                                    if (OTP == oTP) {
                                        TKThanhToan.ChuyenKhoan(ck, stK, chuyenTien);
                                        TKThanhToan.in(ck, stK, chuyenTien);
                                        tkThanhToan1.soDu = tkThanhToan1.soDu - chuyenTien;
                                        System.out.println(df.format(tkThanhToan1.soDu) + "VNĐ");
                                        tkThanhToan2.soDu = ck.get(tkThanhToan2.soTaiKhoan);
                                    } else
                                        System.out.println("Mã OTP không chính xác. Giao dịch thất bại!");

                                    count++;
                                    break;
                                case 4:
                                    count++;
                                    break;
                                case 5:
                                    System.out.println("----------");
                                    System.out.println("Mở sổ Tiết Kiệm");
                                    System.out.println("1. Có Kỳ Hạn");
                                    System.out.println("2. Không Kỳ Hạn");
                                    int kyHan;
                                    double laiXuatKyHan, laiXuatKhongKyHan, tienGui;
                                    laiXuatKyHan = 5;
                                    laiXuatKhongKyHan = 0.8;
                                    System.out.print("Lựa Chọn: ");
                                    kyHan = sc.nextInt();
                                    LocalDate date = LocalDate.now();

                                    switch (kyHan) {
                                        case 1:
                                            System.out.println("Bạn chọn mở sổ có thời hạn với lãi xuất " + laiXuatKyHan + "%/năm");
                                            System.out.println("Ngày Hiện Tại: " + date);
                                            System.out.println("Nhập Thời Hạn Gửi");
                                            int tg = tkTietKiem1.thoiHanGui();
                                            System.out.println("Nhập số tiền muốn gửi tiết kiệm");
                                            tienGui = sc.nextDouble();
                                            System.out.println("Xác Nhận");
                                            System.out.println("Số tài khoản: " + tkTietKiem1.soTaiKhoan + ": " + tkThanhToan1.getChuTaiKhoan() + "\nMuốn Gửi Tiết Kiệm: " + df.format(tienGui) + "VNĐ");
                                            int ma = tkThanhToan1.otp();
                                            System.out.println("Mã OTP: " + ma);
                                            System.out.print("Nhập mã OTP: ");
                                            int maOTP = sc.nextInt();
                                            if (ma == maOTP) {
//                                                if(date.equals(tkTietKiem1.ngayy())){
//                                                    tkTietKiem1.soDu+=tienGui;
//                                                }
                                                if (tkThanhToan1.soDu >= tienGui) {
                                                    System.out.println("Bạn sẽ nhận được Tổng " + df.format(tkTietKiem1.kyHan(tienGui, laiXuatKyHan / 100, tg)) + "VNĐ nếu đủ hạn");
                                                    tkThanhToan1.soDu=tkThanhToan1.soDu-tienGui;
                                                    tkTietKiem1.soDu+=tienGui;
                                                } else {
                                                    System.out.println("Tài Khoản Không Đủ Tiền");
                                                }

                                            } else
                                                System.out.println("Mã OTP không chính xác. Giao dịch thất bại!");
                                            count++;
                                            break;

                                        case 2:
                                            System.out.println("Bạn chọn mở sổ không kỳ hạn với lãi xuất " + laiXuatKhongKyHan + "%/năm");
                                            break;
                                    }
                                    break;
                                default:
                                    System.out.println("Lựa chọn không hợp lệ. Chọn Lại");
                                    System.out.println("----------");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("----------");
                            System.out.println("Tài khoản: " + tkThanhToan2.getChuTaiKhoan());
                            System.out.println(tkThanhToan2.toStringFULL());
                            do {
                                System.out.println("-----------");
                                System.out.println("Mời Lựa Chọn Chức Năng:");
                                System.out.println("1. Gửi Tiền");
                                System.out.println("2. Rút Tiền");
                                System.out.println("3. Chuyển Khoản");
                                System.out.println("4. Mở Tài Khoản Tiết Kiệm");
                                System.out.println("5. Kiểm tra tài khoản");
                                System.out.println("6. Trở Lại");
                                System.out.print("Lựa chọn: ");
                                luaChon = sc.nextInt();
                                switch (luaChon) {
                                    case 6:
                                        break;
                                    case 1:
                                        System.out.print("Nhập Số Tiền Muốn Gửi: ");
                                        double gui = sc.nextDouble();
                                        tkThanhToan2.guiTien(gui);
                                        count++;
                                        break;
                                    case 2:
                                        System.out.print("Nhập Số Tiền Muốn Rút: ");
                                        double rut = sc.nextDouble();
                                        tkThanhToan2.rutTien(rut);
                                        count++;
                                        break;
                                    case 3:
                                        sc.nextLine();
                                        double chuyenTien;
                                        String stk;
                                        do {
                                            System.out.print("Nhập số tài khoản: ");
                                            stk = sc.nextLine();
                                            if (!(ck.containsKey(stk))) {
                                                System.out.println("Số Tài Khoản Không Tồn Tại Tề");
                                            } else if (stk.equals(tkThanhToan1.soTaiKhoan)) {
                                                System.out.println("Trùng số tài khoản với chính mình!");
                                            }
                                        } while (!(ck.containsKey(stk)) || (stk.equals(tkThanhToan1.soTaiKhoan)));
                                        do {
                                            System.out.print("Nhập số tiền muốn chuyển: ");
                                            chuyenTien = sc.nextDouble();
                                            sc.nextLine();
                                            if (tkThanhToan2.soDu < chuyenTien) {
                                                System.out.println("Không đủ tiền ấy ơi");
                                            } else if (chuyenTien < 2000) {
                                                System.out.println("Tiền ít quá không cho chuyển ấy ơi( phải >2000VNĐ)");
                                            }
                                        } while (tkThanhToan2.soDu < chuyenTien || chuyenTien < 2000);
                                        System.out.println("Xác Nhận");
                                        System.out.println("Số tài khoản: " + stk + ": " + tkThanhToan1.getChuTaiKhoan() + "\nMuốn chuyển: " + df.format(chuyenTien) + "VNĐ");
                                        int oTP = tkThanhToan2.otp();
                                        System.out.println("Mã OTP: " + oTP);
                                        System.out.print("Nhập mã OTP: ");
                                        int OTP = sc.nextInt();
                                        if (OTP == oTP) {
                                            TKThanhToan.ChuyenKhoan(ck, stk, chuyenTien);
                                            TKThanhToan.in(ck, stk, chuyenTien);
                                            tkThanhToan2.soDu = tkThanhToan2.soDu - chuyenTien;
                                            System.out.println(df.format(tkThanhToan2.soDu) + "VNĐ");
                                            tkThanhToan1.soDu = ck.get(tkThanhToan1.soTaiKhoan);
                                        } else
                                            System.out.println("Mã OTP không chính xác. Giao dịch thất bại!");
                                        count++;
                                        break;
                                    case 4:
                                        System.out.println("----------");
                                        System.out.println("Mở sổ Tiết Kiệm");
                                        System.out.println("1. Có Kỳ Hạn");
                                        System.out.println("2. Không Kỳ Hạn");
                                        int kyHan;
                                        double laiXuatKyHan, laiXuatKhongKyHan, tienGui;
                                        laiXuatKyHan = 5;
                                        laiXuatKhongKyHan = 0.8;
                                        System.out.print("Lựa Chọn: ");
                                        kyHan = sc.nextInt();
                                        LocalDate date = LocalDate.now();
                                        switch (kyHan) {
                                            case 1:
                                                System.out.println("Bạn chọn mở sổ có thời hạn với lãi xuất " + laiXuatKyHan + "%/năm");
                                                System.out.println("Ngày Hiện Tại: " + date);
                                                System.out.println("Nhập Thời Hạn Gửi");
                                                int tg = tkTietKiem1.thoiHanGui();
                                                System.out.println("Nhập số tiền muốn gửi tiết kiệm");
                                                tienGui = sc.nextDouble();
                                                System.out.println("Xác Nhận");
                                                System.out.println("Số tài khoản: " + tkTietKiem1.soTaiKhoan + ": " + tkThanhToan1.getChuTaiKhoan() + "\nMuốn Gửi Tiết Kiệm: " + df.format(tienGui) + "VNĐ");
                                                int ma = tkThanhToan1.otp();
                                                System.out.println("Mã OTP: " + ma);
                                                System.out.print("Nhập mã OTP: ");
                                                int maOTP = sc.nextInt();
                                                if (ma == maOTP) {
                                                    if (tkThanhToan2.soDu >= tienGui) {
                                                        System.out.println("Bạn sẽ nhận được Tổng " + df.format(tkTietKiem2.kyHan(tienGui, laiXuatKyHan / 100, tg)) + "VNĐ nếu đủ hạn");
                                                        tkThanhToan2.soDu = tkThanhToan2.soDu - tienGui;
                                                        tkTietKiem2.soDu+=tienGui;
                                                    } else {
                                                        System.out.println("Tài Khoản Không Đủ Tiền");
                                                    }

                                                } else
                                                    System.out.println("Mã OTP không chính xác. Giao dịch thất bại!");
                                                break;
                                            case 2:
                                        }
                                        count++;
                                        break;
                                    case 5:
                                        System.out.println("----------");
                                        System.out.println(tkThanhToan2.toStringFULL());
                                        break;
                                    default:
                                        System.out.println("Lựa chọn không hợp lệ. Chọn Lại");
                                }
                                count++;
                            } while (luaChon != 6);
                    }
                    break;
                case 2:
                    if (count == 0) {
                        System.out.println("----------");
                        System.out.println("Tài Khoản " + tkThanhToan2.getChuTaiKhoan());
                        System.out.println(tkThanhToan2.toStringFULL());
                        System.out.println("----------");
                    } else {
                        System.out.println("----------");
                        System.out.println("Tài khoản: " + tkThanhToan2.getChuTaiKhoan());
                        System.out.println(tkThanhToan2.toStringFULL());
                        do {
                            System.out.println("-----------");
                            System.out.println("Mời Lựa Chọn Chức Năng:");
                            System.out.println("1. Gửi Tiền");
                            System.out.println("2. Rút Tiền");
                            System.out.println("3. Chuyển Khoản");
                            System.out.println("4. Mở Tài Khoản Tiết Kiệm");
                            System.out.println("5. Kiểm tra tài khoản");
                            System.out.println("6. Trở Lại");
                            System.out.print("Lựa chọn: ");
                            luaChon = sc.nextInt();
                            switch (luaChon) {
                                case 6:
                                    break;
                                case 1:
                                    System.out.print("Nhập Số Tiền Muốn Gửi: ");
                                    double gui = sc.nextDouble();
                                    tkThanhToan2.guiTien(gui);
                                    count++;
                                    break;
                                case 2:
                                    System.out.print("Nhập Số Tiền Muốn Rút: ");
                                    double rut = sc.nextDouble();
                                    tkThanhToan2.rutTien(rut);
                                    count++;
                                    break;
                                case 3:
                                    sc.nextLine();
                                    double chuyenTien;
                                    String stk;
                                    do {
                                        System.out.print("Nhập số tài khoản: ");
                                        stk = sc.nextLine();
                                        if (!(ck.containsKey(stk))) {
                                            System.out.println("Số Tài Khoản Không Tồn Tại Tề");
                                        } else if (stk.equals(tkThanhToan1.soTaiKhoan)) {
                                            System.out.println("Trùng số tài khoản với chính mình!");
                                        }
                                    } while (!(ck.containsKey(stk)) || (stk.equals(tkThanhToan1.soTaiKhoan)));
                                    do {
                                        System.out.print("Nhập số tiền muốn chuyển: ");
                                        chuyenTien = sc.nextDouble();
                                        sc.nextLine();
                                        if (tkThanhToan2.soDu < chuyenTien) {
                                            System.out.println("Không đủ tiền ấy ơi");
                                        } else if (chuyenTien < 2000) {
                                            System.out.println("Tiền ít quá không cho chuyển ấy ơi( phải >2000VNĐ)");
                                        }
                                    } while (tkThanhToan2.soDu < chuyenTien || chuyenTien < 2000);
                                    System.out.println("Xác Nhận");
                                    System.out.println("Số tài khoản: " + stk + ": " + tkThanhToan1.getChuTaiKhoan() + "\nMuốn chuyển: " + df.format(chuyenTien) + "VNĐ");
                                    int oTP = tkThanhToan2.otp();
                                    System.out.println("Mã OTP: " + oTP);
                                    System.out.print("Nhập mã OTP: ");
                                    int OTP = sc.nextInt();
                                    if (OTP == oTP) {
                                        TKThanhToan.ChuyenKhoan(ck, stk, chuyenTien);
                                        TKThanhToan.in(ck, stk, chuyenTien);
                                        tkThanhToan2.soDu = tkThanhToan2.soDu - chuyenTien;
                                        System.out.println(df.format(tkThanhToan2.soDu) + "VNĐ");
                                        tkThanhToan1.soDu = ck.get(tkThanhToan1.soTaiKhoan);
                                    } else
                                        System.out.println("Mã OTP không chính xác. Giao dịch thất bại!");
                                    count++;
                                    break;
                                case 4:
                                    System.out.println("----------");
                                    System.out.println("Mở sổ Tiết Kiệm");
                                    System.out.println("1. Có Kỳ Hạn");
                                    System.out.println("2. Không Kỳ Hạn");
                                    int kyHan;
                                    double laiXuatKyHan, laiXuatKhongKyHan, tienGui;
                                    laiXuatKyHan = 5;
                                    laiXuatKhongKyHan = 0.8;
                                    System.out.print("Lựa Chọn: ");
                                    kyHan = sc.nextInt();
                                    LocalDate date = LocalDate.now();
                                    switch (kyHan) {
                                        case 1:
                                            System.out.println("Bạn chọn mở sổ có thời hạn với lãi xuất " + laiXuatKyHan + "%/năm");
                                            System.out.println("Ngày Hiện Tại: " + date);
                                            System.out.println("Nhập Thời Hạn Gửi");
                                            int tg = tkTietKiem1.thoiHanGui();
                                            System.out.println("Nhập số tiền muốn gửi tiết kiệm");
                                            tienGui = sc.nextDouble();
                                            System.out.println("Xác Nhận");
                                            System.out.println("Số tài khoản: " + tkTietKiem1.soTaiKhoan + ": " + tkThanhToan1.getChuTaiKhoan() + "\nMuốn Gửi Tiết Kiệm: " + df.format(tienGui) + "VNĐ");
                                            int ma = tkThanhToan1.otp();
                                            System.out.println("Mã OTP: " + ma);
                                            System.out.print("Nhập mã OTP: ");
                                            int maOTP = sc.nextInt();
                                            if (ma == maOTP) {
                                                if (tkThanhToan2.soDu >= tienGui) {
                                                    System.out.println("Bạn sẽ nhận được Tổng " + df.format(tkTietKiem2.kyHan(tienGui, laiXuatKyHan / 100, tg)) + "VNĐ nếu đủ hạn");
                                                    tkThanhToan2.soDu = tkThanhToan2.soDu - tienGui;
                                                    tkTietKiem2.soDu+=tienGui;

                                                    

                                                } else {
                                                    System.out.println("Tài Khoản Không Đủ Tiền");
                                                }

                                            } else
                                                System.out.println("Mã OTP không chính xác. Giao dịch thất bại!");
                                            break;
                                        case 2:
                                    }
                                    count++;
                                    break;
                                case 5:
                                    System.out.println("----------");
                                    System.out.println(tkThanhToan2.toStringFULL());
                                    break;
                                default:
                                    System.out.println("Lựa chọn không hợp lệ. Chọn Lại");
                            }
                            count++;
                        } while (luaChon != 6);
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Chọn Lại");
                    System.out.println("----------");
            }
        } while (luaChon != 0);
    }

}



