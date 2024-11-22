import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyDanhBa qlDanhBa = new QuanLyDanhBa();
        qlDanhBa.docFile(); // Đọc danh bạ từ file khi khởi động

        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("\n=============MENU===============");
            System.out.println("1. Thêm danh bạ");
            System.out.println("2. Hiển thị danh sách danh bạ");
            System.out.println("3. Ghi file");
            System.out.println("4. Đọc file");
            System.out.println("5. Thêm ghi chú");
            System.out.println("6. Tìm kiếm nâng cao");
            System.out.println("7. Sắp xếp danh bạ");
            System.out.println("8. Xóa danh bạ");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    qlDanhBa.themDanhBa();
                    break;
                case 2:
                    qlDanhBa.hienThiDanhSachDanhBa();
                    break;
                case 3:
                    qlDanhBa.ghiFile();
                    break;
                case 4:
                    qlDanhBa.docFile();
                    break;
                case 5:
                    qlDanhBa.themGhiChu();
                    break;
                case 6:
                    qlDanhBa.timKiemNangCao();
                    break;
                case 7:
                    qlDanhBa.sapXepDanhBa();
                    break;
                case 8:
                    qlDanhBa.xoaDanhBa();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 0);
    }
}
