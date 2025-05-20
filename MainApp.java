package MainApp;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainApp {
    public static void main(String[] args) {
        // Tạo JFrame chính
        JFrame frame = new JFrame("Ứng dụng quản lý");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        // Tạo tab để chứa các chức năng
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Giả sử bạn đã có các panel AddPanel, ViewPanel, DeletePanel
        tabbedPane.addTab("Thêm", new AddPanel());
        tabbedPane.addTab("Xem", new ViewPanel());
        tabbedPane.addTab("Xóa", new DeletePanel());
        
        // Thêm tabbedPane vào JFrame
        frame.add(tabbedPane);
        
        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}




