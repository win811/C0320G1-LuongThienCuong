package TEST.codegymdn;

import TEST.codegymhn.NhanVien;

public class TruongPhong extends NhanVien {
    public double trachNhiem;

    public TruongPhong(String hoTen, double luong, double trachNhiem) {
        super(hoTen,luong);
    }

    public void xuat() {
        super.hoTen = "Tuấn";
        super.luong = 500;
//        super.xuat();
//        double thuNhap = super.getThuNhap();
    }
}
