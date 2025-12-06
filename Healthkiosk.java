import java.util.Scanner;

public class Healthkiosk{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Ashesi Health Kiosk!");

        
        System.out.print("Enter service code (P/L/T/C): ");
        char service = scanner.next().charAt(0);
        service = Character.toUpperCase(service);

        String serviceName;
        switch (service) {
            case 'P': serviceName = "PHARMACY"; System.out.println("Go to: Pharmacy Desk"); break;
            case 'L': serviceName = "LAB"; System.out.println("Go to: Lab Desk"); break;
            case 'T': serviceName = "TRIAGE"; System.out.println("Go to: Triage Desk"); break;
            case 'C': serviceName = "COUNSELING"; System.out.println("Go to: Counseling Desk"); break;
            default: serviceName = "INVALID"; System.out.println("Invalid service code"); return;
        }

       
        double metricValue = 0; 
        int roundedMetric = 0;

        if (serviceName.equals("TRIAGE")) {
            System.out.print("Enter health metric option (1=BMI, 2=Dosage, 3=Trig): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                
                System.out.print("Enter weight(kg): ");
                double weight = scanner.nextDouble();
                System.out.print("Enter height(m): ");
                double height = scanner.nextDouble();

                double bmi = weight / (height * height);
                double bmiRounded = Math.round(bmi * 10) / 10.0;
                metricValue = bmi;
                roundedMetric = (int)Math.round(bmi);

                String category;
                if (bmi < 18.5) category = "Underweight";
                else if (bmi < 25.0) category = "Normal";
                else if (bmi < 30.0) category = "Overweight";
                else category = "Obese";

                System.out.println("BMI: " + bmiRounded + " Category: " + category);
            }
            else if (choice == 2) {
        
                System.out.print("Enter required dosage (mg): ");
                double dosage = scanner.nextDouble();
                int tablets = (int)Math.ceil(dosage / 250.0);
                metricValue = tablets;
                roundedMetric = tablets;
                System.out.println("Number of tablets: " + tablets);
            }
            else if (choice == 3) {
                
                System.out.print("Enter angle in degrees: ");
                double angle = scanner.nextDouble();
                double radians = Math.toRadians(angle);

                double sin = Math.round(Math.sin(radians) * 1000) / 1000.0;
                double cos = Math.round(Math.cos(radians) * 1000) / 1000.0;

                metricValue = Math.sin(radians) * 100;
                roundedMetric = (int)Math.round(metricValue);

                System.out.println("sin = " + sin + ", cos = " + cos);
            }
        }

        
        char randomChar = (char) ('A' + (int)(Math.random() * 26));

        int digit1 = 3 + (int)(Math.random() * 7);
        int digit2 = 3 + (int)(Math.random() * 7);
        int digit3 = 3 + (int)(Math.random() * 7);
        int digit4 = 3 + (int)(Math.random() * 7);

        String shortID = "" + randomChar + digit1 + digit2 + digit3 + digit4;
        System.out.println("Generated ID: " + shortID);

        if (shortID.length() != 5) {
            System.out.println("Invalid length");
        } else if (!Character.isLetter(shortID.charAt(0))) {
            System.out.println("Invalid: first char must be a letter");
        } else if (!(Character.isDigit(shortID.charAt(1)) &&
                     Character.isDigit(shortID.charAt(2)) &&
                     Character.isDigit(shortID.charAt(3)) &&
                     Character.isDigit(shortID.charAt(4)))) {
            System.out.println("Invalid: last 4 must be digits");
        } else {
            System.out.println("ID OK");
        }

        
        System.out.print("Enter your first name: ");
        String firstName = scanner.next();

        char baseCode = Character.toUpperCase(firstName.charAt(0));
        char shifted = (char) ('A' + (baseCode - 'A' + 2) % 26);

        String lastTwo = "" + shortID.charAt(3) + shortID.charAt(4);
        String displayCode = shifted + lastTwo + "-" + roundedMetric;
        System.out.println("Display Code: " + displayCode);

        
        if (serviceName.equals("TRIAGE")) {
            double bmiRounded = Math.round(metricValue * 10) / 10.0;
            System.out.println("Summary: " + serviceName + " | ID=" + shortID +
                               " | BMI=" + bmiRounded + " | Code=" + displayCode);
        } else if (serviceName.equals("PHARMACY") ||
                   serviceName.equals("LAB") ||
                   serviceName.equals("COUNSELING")) {
            System.out.println("Summary: " + serviceName + " | ID=" + shortID +
                               " | Code=" + displayCode);
        }
    }
}


