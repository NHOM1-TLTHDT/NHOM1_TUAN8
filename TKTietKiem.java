package NganHang;

import java.time.LocalDate;
import java.time.Period;
import java.text.DecimalFormat;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TKTietKiem extends TaiKhoan {
    private int ngay, day, month, year;
    private TKThanhToan taiKhoan;
    static DecimalFormat df = new DecimalFormat("#,###.##");

    public TKTietKiem(TKThanhToan taiKhoan, double tienTK, String matKhau) {
        super(taiKhoan.getSoTaiKhoan(), taiKhoan.getChuTaiKhoan(), tienTK, matKhau);
    }

    public void update(String newChuTaiKhoan) {
        taiKhoan.chuTaiKhoan = newChuTaiKhoan;
    }

    public void updateMK(String mkm) {
        taiKhoan.matKhau = mkm;
    }

    public int thoiHanGui() {
        LocalDate currentDate = LocalDate.now();
        Scanner sc = new Scanner(System.in);
        int y, m;
        do {
            System.out.print("Nhap nam: ");
            this.year = sc.nextInt();
            y = this.year - currentDate.getYear();
            if (this.year < currentDate.getYear() || y > 10) {
                System.out.println("Loi nhap nam. Nhap lai(Khoảng cách giữa năm hiện tại và năm gửi cách 10 năm");
            }
        } while (this.year < currentDate.getYear() || y > 10);
        do {
            m = currentDate.getMonth().getValue();
            System.out.print("Nhap thang: ");
            this.month = sc.nextInt();
            if (this.month < 1 || this.month > 12) {
                System.out.println("Loi nhap thang. Nhap lai");
            }
            if (this.month < m && this.year == currentDate.getYear()) {
                System.out.println("Loi nhap thang.Nhap Lai. Thang phai lon hon thang hien tai");
                this.month = -1;
            }
        } while (this.month < 1 || this.month > 12);
        do {
            System.out.print("Nhap ngay: ");
            this.day = sc.nextInt();
            if (this.day < 1 || this.day > 31) {
                System.out.println("Loi nhap ngay. Nhap lai");
            } else {
                if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12)
                    this.day = this.day;
                if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
                    if (this.day <= 30)
                        this.day = this.day;
                    else {
                        System.out.printf("Loi. Thang %d chi co 30 ngay\n", this.month);
                        this.day = -1;
                    }
                }
                if (this.month == 2) {
                    if (this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0) {
                        if (this.day <= 29)
                            this.day = this.day;
                        else {
                            System.out.printf("Loi.Thang 2 cua nam %d chi co 29 ngay\n", this.year);
                            this.day = -1;
                        }
                    } else {
                        if (this.day <= 28) {
                            this.day = this.day;
                        } else {
                            System.out.println("Loi nhap ngay. Nam khong nhuan chi co 28 ngay");
                            this.day = -1;
                        }
                    }
                }
            }
        } while (this.day < 1 || this.day > 31);
        String date = String.format("%02d-%02d-%d", this.day, this.month, this.year);
        System.out.println("Ngay ban nhap la: " + date);
        String date1 = String.format("%d-%02d-%02d", this.year, this.month, this.day);
        LocalDate dateLocal = LocalDate.parse(date1);
        Period khoangCach = Period.between(currentDate, dateLocal);// Tính khoảng cách giữa ngày hiện tại và tuơng lai
        System.out.println("Khoang cach: " + khoangCach.getDays() + " ngày, " + khoangCach.getMonths() + " tháng, " + khoangCach.getYears() + " năm. ");
        int tongNgay = (int) ChronoUnit.DAYS.between(currentDate, dateLocal);
        this.ngay = tongNgay;
        System.out.println("Tổng ngày: " + this.ngay + " ngày.");
        return this.ngay;
    }
    public LocalDate ngayy (){
        String ngayyy=String.format("%d-%2d-%2d", this.year, this.month, this.day);
        LocalDate ngayyyy = LocalDate.parse(ngayyy);
        return ngayyyy;
    }

    public void in() {
        System.out.println(this.day + " " + this.month + " " + this.year);
    }

    public double khongKyHan(double tienGui, double laiXuat) {
        return tienGui * laiXuat * this.ngay;
    }

    public double kyHan(double tienGui, double laiXuat, int tongNgay) {
        System.out.println("Tổng cả gốc lẫn lãi");
        return tienGui + lai(tienGui, laiXuat, tongNgay);
    }
    public double lai(double tienGui, double laiXuat, int tongNgay){
        return tienGui*laiXuat/365*tongNgay;
    }

    public int  kiemTraKyHan(LocalDate date){
        String thoiHan = String.format("%d-%02d-%02d", this.year, this.month, this.day);
        LocalDate thoiHan1= LocalDate.parse(thoiHan);
        if(date.equals(thoiHan1)){
            return 1;
        }
        else return 0;
    }
}
