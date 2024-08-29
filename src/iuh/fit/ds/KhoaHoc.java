/*
 * @ (#) KhoaHoc.java 		1.0	8/29/2024
 *
 * Copyright (c) 2024 IUH.  All rights reserved.
 */


package iuh.fit.ds;


/*
 * @description:
 * @outhor: Huu Trong
 * @date:	8/29/2024
 * @version:	1.0
 */
public class KhoaHoc {
        private String maKhoaHoc;
        private String tenKhoaHoc;
        private int soTinChi;
        private String khoaPhuTrach;

        public KhoaHoc(String maKhoaHoc, String tenKhoaHoc, int soTinChi, String khoaPhuTrach) {
            if (maKhoaHoc == null || maKhoaHoc.length() < 3 || !maKhoaHoc.matches("[a-zA-Z0-9]+")) {
                throw new RuntimeException("Mã khóa học phải chứa ký tự chữ cái hoặc số và có chiều dài ít nhất là 3");
            }
            if (tenKhoaHoc == null || tenKhoaHoc.isEmpty()) {
                throw new RuntimeException("Tên khóa học không được để trống");
            }
            if (soTinChi <= 0) {
                throw new RuntimeException("Số tín chỉ phải lớn hơn 0");
            }
            this.maKhoaHoc = maKhoaHoc;
            this.tenKhoaHoc = tenKhoaHoc;
            this.soTinChi = soTinChi;
            this.khoaPhuTrach = khoaPhuTrach;
        }

        public String getMaKhoaHoc() {
            return maKhoaHoc;
        }

        public String getTenKhoaHoc() {
            return tenKhoaHoc;
        }

        public int getSoTinChi() {
            return soTinChi;
        }

        public String getKhoaPhuTrach() {
            return khoaPhuTrach;
        }

        // Phương thức setter
        public void setMaKhoaHoc(String maKhoaHoc) {
            this.maKhoaHoc = maKhoaHoc;
        }

        public void setTenKhoaHoc(String tenKhoaHoc) {
            this.tenKhoaHoc = tenKhoaHoc;
        }

        public void setSoTinChi(int soTinChi) {
            this.soTinChi = soTinChi;
        }

        public void setKhoaPhuTrach(String khoaPhuTrach) {
            this.khoaPhuTrach = khoaPhuTrach;
        }

        @Override
        public String toString() {
            return String.format("%-10s %-20s %-10d %-20s", maKhoaHoc, tenKhoaHoc, soTinChi, khoaPhuTrach);
        }
    }


