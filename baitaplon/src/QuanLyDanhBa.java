import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLyDanhBa {
    private List<DanhBa> danhSachDB;
    private Scanner scanner;

    public QuanLyDanhBa() {
        danhSachDB = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void themDanhBa() {
        System.out.print("Nhập tên: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        DanhBa danhBa = new DanhBa(ten, soDienThoai, email);
        danhSachDB.add(danhBa);
        System.out.println("Đã thêm danh bạ thành công!");
    }

    public void hienThiDanhSachDanhBa() {
        if (danhSachDB.isEmpty()) {
            System.out.println("Danh sách danh bạ rỗng.");
            return;
        }
        danhSachDB.forEach(System.out::println);
    }

    public void ghiFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("danhba.dat"))) {
            outputStream.writeObject(danhSachDB);
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Không thể mở file để ghi: " + e.getMessage());
        }
    }

    public void docFile() {
        danhSachDB.clear(); // Xóa danh sách hiện tại trước khi đọc từ file
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("danhba.dat"))) {
            danhSachDB = (List<DanhBa>) inputStream.readObject();
            System.out.println("Đọc file thành công!");
        } catch (EOFException e) {
            // Kết thúc tệp
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Không thể mở file để đọc: " + e.getMessage());
        }
    }

    public void themGhiChu() {
        System.out.print("Nhập tên danh bạ cần thêm ghi chú: ");
        String ten = scanner.nextLine();
        for (DanhBa db : danhSachDB) {
            if (db.getTen().equalsIgnoreCase(ten)) {
                System.out.print("Nhập ghi chú: ");
                String ghiChu = scanner.nextLine();
                db.setGhiChu(ghiChu);
                System.out.println("Đã thêm ghi chú cho danh bạ.");
                return;
            }
        }
        System.out.println("Không tìm thấy danh bạ.");
    }

    public void timKiemNangCao() {
        System.out.print("Nhập tên (hoặc để trống): ");
        String ten = scanner.nextLine();
        System.out.print("Nhập số điện thoại (hoặc để trống): ");
        String soDienThoai = scanner.nextLine();

        boolean found = false;
        for (DanhBa db : danhSachDB) {
            boolean match = true;
            if (!ten.isEmpty() && !db.getTen().equalsIgnoreCase(ten)) {
                match = false;
            }
            if (!soDienThoai.isEmpty() && !db.getSoDienThoai().equals(soDienThoai)) {
                match = false;
            }
            if (match) {
                System.out.println(db);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy danh bạ nào.");
        }
    }

    public void sapXepDanhBa() {
        System.out.println("Sắp xếp theo:");
        System.out.println("1. Tên");
        System.out.println("2. Số điện thoại");
        System.out.print("Chọn: ");
        int luaChon = scanner.nextInt();
        scanner.nextLine();

        switch (luaChon) {
            case 1:
                danhSachDB.sort(Comparator.comparing(DanhBa::getTen));
                System.out.println("Đã sắp xếp theo tên.");
                break;
            case 2:
                danhSachDB.sort(Comparator.comparing(DanhBa::getSoDienThoai));
                System.out.println("Đã sắp xếp theo số điện thoại.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }

    public void xoaDanhBa() {
        System.out.print("Nhập tên hoặc số điện thoại của danh bạ cần xóa: ");
        String tuKhoa = scanner.nextLine();
        danhSachDB.removeIf(db -> db.getTen().equalsIgnoreCase(tuKhoa) || db.getSoDienThoai().equals(tuKhoa));
        System.out.println("Đã xóa danh bạ nếu có.");
    }
}
