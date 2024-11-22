import java.io.Serializable;

public class DanhBa implements Serializable {
    private String ten;
    private String soDienThoai;
    private String email;
    private String ghiChu; // Thêm thuộc tính ghi chú

    public DanhBa(String ten, String soDienThoai, String email) {
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.ghiChu = ""; // Khởi tạo ghi chú rỗng
    }

    public String getTen() {
        return ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public String getGhiChu() {
        return ghiChu; // Getter cho ghi chú
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu; // Setter cho ghi chú
    }

    @Override
    public String toString() {
        return "Tên: " + ten + ", SĐT: " + soDienThoai + ", Email: " + email + ", Ghi chú: " + ghiChu;
    }
}
