/*
 * @ (#) TestKhoaHoc.java 		1.0	8/29/2024
 *
 * Copyright (c) 2024 IUH.  All rights reserved.
 */


package iuh.fit.ds;

import java.util.List;
import java.util.Scanner;

/*
 * @description:
 * @outhor: Huu Trong
 * @date:	8/29/2024
 * @version:	1.0
 */
public class TestKhoaHoc {

    private static void khoiTaoDuLieu(DanhSachKhoaHoc dsKhoaHoc) {
            dsKhoaHoc.themKhoaHoc(new KhoaHoc("CS101", "Nhập môn Khoa học Máy tính", 3, "Khoa học Máy tính"));
            dsKhoaHoc.themKhoaHoc(new KhoaHoc("CS102", "Cấu trúc Dữ liệu", 4, "Khoa học Máy tính"));
            dsKhoaHoc.themKhoaHoc(new KhoaHoc("CS103", "Giải thuật", 4, "Khoa học Máy tính"));
            dsKhoaHoc.themKhoaHoc(new KhoaHoc("MATH101", "Giải tích I", 3, "Toán học"));
            dsKhoaHoc.themKhoaHoc(new KhoaHoc("MATH102", "Đại số tuyến tính", 3, "Toán học"));
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            DanhSachKhoaHoc dsKhoaHoc = new DanhSachKhoaHoc();
            khoiTaoDuLieu(dsKhoaHoc);

            System.out.println("\n===== Menu =====");
            System.out.println("1. Thêm khóa học");
            System.out.println("2. Xem danh sách khóa học");
            System.out.println("3. Xóa khóa học");
            System.out.print("Chọn một chức năng (nhập số tương ứng): ");

            int luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập mã khóa học: ");
                    String maKhoaHoc = scanner.nextLine();
                    System.out.print("Nhập tên khóa học: ");
                    String tenKhoaHoc = scanner.nextLine();
                    System.out.print("Nhập số tín chỉ: ");
                    int soTinChi = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập khoa phụ trách: ");
                    String khoaPhuTrach = scanner.nextLine();

                    KhoaHoc khoaHocMoi = new KhoaHoc(maKhoaHoc, tenKhoaHoc, soTinChi, khoaPhuTrach);
                    dsKhoaHoc.themKhoaHoc(khoaHocMoi);
                    System.out.println("Thêm khóa học thành công.");
                    break;

                case 2:
                    List<KhoaHoc> danhSach = dsKhoaHoc.getDanhSachKhoaHoc();
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách khóa học trống.");
                    } else {
                        System.out.println("\nDanh sách khóa học:");
                        System.out.printf("%-10s %-20s %-10s %-20s\n", "Mã KH", "Tên KH", "Số TC", "Khoa phụ trách");
                        for (KhoaHoc kh : danhSach) {
                            System.out.println(kh);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã khóa học cần xóa: ");
                    String maXoa = scanner.nextLine();
                    if (dsKhoaHoc.xoaKhoaHoc(maXoa)) {
                        System.out.println("Xóa khóa học thành công.");
                    } else {
                        System.out.println("Xóa khóa học thất bại.");
                    }
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
