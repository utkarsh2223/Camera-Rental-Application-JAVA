package cameraRentalApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalApplication {
	private List<Camera> cameraList;
    private double walletAmount;

    public RentalApplication() {
        cameraList = new ArrayList<>();
        walletAmount = 0.0;
    }

    public void start() {
        displayWelcomeScreen();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!exit) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    listCameras();
                    break;
                case 2:
                    rentCamera(scanner);
                    break;
                case 3:
                    manageWallet(scanner);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Application closed.");
    }
    
    private void displayWelcomeScreen() {
        System.out.println("Welcome to the Rent My Cam application!");
        System.out.println("Developer: [Your Name]");
        System.out.println();
    }

    private void displayMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. List Cameras");
        System.out.println("2. Rent a Camera");
        System.out.println("3. Manage Wallet");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private void listCameras() {
        if (cameraList.isEmpty()) {
            System.out.println("No Data Present at This Moment.");
        } else {
            System.out.println("Available Cameras:");
            for (int i = 0; i < cameraList.size(); i++) {
                Camera camera = cameraList.get(i);
                System.out.println((i + 1) + ". " + camera.getBrand() + " " + camera.getModel()
                        + " (Rent: $" + camera.getRentalAmountPerDay() + " per day)");
            }
        }
        System.out.println();
    }

    private void rentCamera(Scanner scanner) {
        listCameras();
        if (cameraList.isEmpty()) {
            return;
        }
        
        System.out.print("Enter the camera number you want to rent: ");
        int cameraNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (cameraNumber < 1 || cameraNumber > cameraList.size()) {
            System.out.println("Invalid camera number. Please try again.");
            return;
        }

        Camera selectedCamera = cameraList.get(cameraNumber - 1);
        if (walletAmount < selectedCamera.getRentalAmountPerDay()) {
            System.out.println("Insufficient wallet amount.");
        } else {
            walletAmount -= selectedCamera.getRentalAmountPerDay();
            System.out.println("Camera rented successfully!");
        }
        System.out.println();
    }
    private void manageWallet(Scanner scanner) {
        System.out.println("Wallet Menu:");
        System.out.println("1. View Wallet Balance");
        System.out.println("2. Deposit Amount");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                viewWalletBalance();
                break;
            case 2:
                depositAmount(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        System.out.println();
    }
    private void viewWalletBalance() {
        System.out.println("Wallet Balance: $" + walletAmount);
    }

    private void depositAmount(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        if (amount < 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            walletAmount += amount;
            System.out.println("Amount deposited successfully!");
        }
    }
    
    public void addCamera(Camera camera) {
        cameraList.add(camera);
    }

    public static void main(String[] args) {
        RentalApplication application = new RentalApplication();

        // Add sample cameras (for testing)
        application.addCamera(new Camera("Brand 1", "Model 1", 10.0));
        application.addCamera(new Camera("Brand 2", "Model 2", 15.0));
        application.addCamera(new Camera("Brand 3", "Model 3", 12.5));

        application.start();
    }

}
