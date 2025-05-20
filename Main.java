import java.util.ArrayList;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		boolean exit = false;

		while (!exit) {
			System.out.println("Menu:");
			System.out.println("1. Nhap thong tin va tao cac doi tuong xe");
			System.out.println("2. Xuat bang ke khai tien thue truoc ba cua cac xe");
			System.out.println("3. Xuat thong tin xe co thue truoc ba cao nhat");
			System.out.println("4. Thoat");
			System.out.print("Chon (1-4): ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1: // Nhập thông tin xe
				System.out.print("Nhap so luong xe can nhap: ");
				int n = scanner.nextInt();
				scanner.nextLine();

				for (int i = 0; i < n; i++) {
					System.out.print("Nhap ten xe thu " + (i + 1) + ": ");
					String name = scanner.nextLine();
					System.out.print("Nhap gia tri xe thu " + (i + 1) + ": ");
					double value = scanner.nextDouble();
					System.out.print("Nhap dung tich xi lanh xe thu " + (i + 1) + ": ");
					int xiLanh = scanner.nextInt();
					scanner.nextLine();

					// Tạo đối tượng xe và thêm vào danh sách
					Vehicle vehicle = new Vehicle(name, value, xiLanh);
					vehicles.add(vehicle);
				}
				break;

			case 2: // Xuất bảng kê khai thuế trước bạ
				System.out.println("Bang ke khai tien thue truoc ba cua cac xe:");
				
				for (Vehicle vehicle : vehicles) {
					System.out.println(vehicle.getInfo());
				}
				break;

			case 3: // Xuất thông tin xe có thuế cao nhất
				if (vehicles.isEmpty()) {
					System.out.println("Khong co xe nao trong danh sach.");
				} else {
					Vehicle highestTaxVehicle = vehicles.get(0);
					for (Vehicle vehicle : vehicles) {
						if (vehicle.getTax() > highestTaxVehicle.getTax()) {
							highestTaxVehicle = vehicle;
						}
					}
					System.out.println("Thong tin xe co thue truoc ba cao nhat:");
					System.out.println(highestTaxVehicle.getInfo());
				}
				break;

			case 4:
				exit = true;
				System.out.println("Thoat chuong trinh.");
				break;

			default:
				System.out.println("Lua chon khong hop le! Vui long chon lai");
			}
		}

		scanner.close();
	}
}

class Vehicle {
	private String vehicleName;
	private double value; // giá trị xe
	int xiLanh; // dung tích xi-lanh

	public Vehicle(String vehicleName, double value, int xiLanh) {
		this.vehicleName = vehicleName;
		this.value = value;
		this.xiLanh = xiLanh;
	}

	// tính thuế trước bạ
	public double thueTruocBa() {
		double taxRate;
		if (xiLanh < 100) {
			taxRate = 0.01;
		} else if (xiLanh >= 100 && xiLanh <= 200) {
			taxRate = 0.03; 
		} else {
			taxRate = 0.05; 
		}
		return value * taxRate;
	}

	// trả về thông tin của xe
	public String getInfo() {
		return String.format("Tên xe: %s | Giá trị: %.2f | Dung tích xi-lanh: %dcc | Thuế trước bạ: %.2f", vehicleName,
				value, xiLanh, thueTruocBa());
	}

	// Getter để lấy giá trị thuế cho việc so sánh
	public double getTax() {
		return thueTruocBa();
	}
}
