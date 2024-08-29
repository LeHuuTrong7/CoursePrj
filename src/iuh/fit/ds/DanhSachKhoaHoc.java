/*
 * @ (#) DanhSachKhoaHoc.java 		1.0	8/29/2024
 *
 * Copyright (c) 2024 IUH.  All rights reserved.
 */


package iuh.fit.ds;
import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @outhor: Huu Trong
 * @date:	8/29/2024
 * @version:	1.0
 */
public class DanhSachKhoaHoc {


     private List<KhoaHoc> danhSachKhoaHoc;

        public DanhSachKhoaHoc() {
            danhSachKhoaHoc = new ArrayList<>();
        }

        public boolean themKhoaHoc(KhoaHoc khoaHoc) {
            if (tonTaiKhoaHoc(khoaHoc)) {
                System.out.println("Mã khóa học đã tồn tại.");
                return false;
            }
            danhSachKhoaHoc.add(khoaHoc);
            return true;
        }

        public boolean tonTaiKhoaHoc(KhoaHoc khoaHoc) {
            for (KhoaHoc kh : danhSachKhoaHoc) {
                if (kh.getMaKhoaHoc().equalsIgnoreCase(khoaHoc.getMaKhoaHoc())) {
                    return true;
                }
            }
            return false;
        }

        public List<KhoaHoc> getDanhSachKhoaHoc() {
            return new ArrayList<>(danhSachKhoaHoc);
        }

        public boolean xoaKhoaHoc(String maKhoaHoc) {
            for (KhoaHoc kh : danhSachKhoaHoc) {
                if (kh.getMaKhoaHoc().equalsIgnoreCase(maKhoaHoc)) {
                    danhSachKhoaHoc.remove(kh);
                    return true;
                }
            }
            System.out.println("Mã khóa học không tồn tại.");
            return false;
        }

        public KhoaHoc timKhoaHocTheoMa(String maKhoaHoc) {
            for (KhoaHoc kh : danhSachKhoaHoc) {
                if (kh.getMaKhoaHoc().equalsIgnoreCase(maKhoaHoc)) {
                    return kh;
                }
            }
            return null;
        }

        public List<KhoaHoc> timKhoaHocTheoTen(String tenKhoaHoc) {
            List<KhoaHoc> ketQua = new ArrayList<>();
            for (KhoaHoc kh : danhSachKhoaHoc) {
                if (kh.getTenKhoaHoc().toLowerCase().contains(tenKhoaHoc.toLowerCase())) {
                    ketQua.add(kh);
                }
            }
            return ketQua.isEmpty() ? null : ketQua;
        }

        public List<KhoaHoc> timKhoaHocTheoKhoa(String khoaPhuTrach) {
            List<KhoaHoc> ketQua = new ArrayList<>();
            for (KhoaHoc kh : danhSachKhoaHoc) {
                if (kh.getKhoaPhuTrach().equalsIgnoreCase(khoaPhuTrach)) {
                    ketQua.add(kh);
                }
            }
            return ketQua.isEmpty() ? null : ketQua;
        }

        public List<KhoaHoc> sapXepKhoaHocTheoTen() {
            List<KhoaHoc> dsKhoaHoc = new ArrayList<>(danhSachKhoaHoc);
            dsKhoaHoc.sort((kh1, kh2) -> kh1.getTenKhoaHoc().compareToIgnoreCase(kh2.getTenKhoaHoc()));
            return dsKhoaHoc;
        }

        public List<KhoaHoc> timKhoaHocCoSoTinChiLonNhat() {
            List<KhoaHoc> dsKhoaHocLonNhat = new ArrayList<>();
            int soTinChiLonNhat = 0;
            for (KhoaHoc kh : danhSachKhoaHoc) {
                if (kh.getSoTinChi() > soTinChiLonNhat) {
                    soTinChiLonNhat = kh.getSoTinChi();
                    dsKhoaHocLonNhat.clear();
                    dsKhoaHocLonNhat.add(kh);
                } else if (kh.getSoTinChi() == soTinChiLonNhat) {
                    dsKhoaHocLonNhat.add(kh);
                }
            }
            return dsKhoaHocLonNhat;
        }

        public String timKhoaCoNhieuKhoaHocNhat() {
            if (danhSachKhoaHoc.isEmpty()) return null;

            int soLuongMax = 0;
            String khoaMax = null;
            for (KhoaHoc kh : danhSachKhoaHoc) {
                int soLuong = (int) danhSachKhoaHoc.stream()
                        .filter(k -> k.getKhoaPhuTrach().equalsIgnoreCase(kh.getKhoaPhuTrach()))
                        .count();
                if (soLuong > soLuongMax) {
                    soLuongMax = soLuong;
                    khoaMax = kh.getKhoaPhuTrach();
                }
            }
            return khoaMax;
        }
    }


