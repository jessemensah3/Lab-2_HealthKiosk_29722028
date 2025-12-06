import java.util.Scanner;
public class HealthKiosk {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);


            System.out.println("Welcome to Ashesi Health Center Intake Kiosk!");

            System.out.print("Enter service code (P/L/T/C): ");
            char serviceCode = input.next().charAt(0);
            String serviceDesk = "";
            String serviceName = "";

            switch (Character.toUpperCase(serviceCode)) {
                case 'P':
                    serviceDesk = "Pharmacy Desk";
                    serviceName = "PHARMACY";
                    break;
                case 'L':
                    serviceDesk = "Lab Desk";
                    serviceName = "LAB";
                    break;
                case 'T':
                    serviceDesk = "Triage Desk";
                    serviceName = "TRIAGE";
                    break;
                case 'C':
                    serviceDesk = "Counseling Desk";
                    serviceName = "COUNSELING";
                    break;
                default:
                    System.out.println("Invalid service code");
                    input.close();
                    return;
            }

            System.out.println("Go to: " + serviceDesk);

            double metricValue = 0;
            String metricDisplay = "";

            if (Character.toUpperCase(serviceCode) == 'T') {
                System.out.print("Enter the health metric (1 for BMI, 2 for Dosage round-up, 3 for simple trig helper): ");
                int metricChoice = input.nextInt();

                if (metricChoice == 1) {

                    System.out.print("Enter weight(kg): ");
                    double weight = input.nextDouble();
                    System.out.print("Enter height(m): ");
                    double height = input.nextDouble();

                    double bmi = weight / Math.pow(height, 2);

                    double bmiRounded = Math.round(bmi * 10) / 10.0;

                    metricValue = Math.round(bmi);

                    String category;
                    if (bmi < 18.5) {
                        category = "Underweight";
                    } else if (bmi < 25.0) {
                        category = "Normal";
                    } else if (bmi < 30.0) {
                        category = "Overweight";
                    } else {
                        category = "Obese";
                    }

                    System.out.println("BMI: " + bmiRounded + " Category: " + category);
                    metricDisplay = "BMI=" + bmiRounded;

                } else if (metricChoice == 2) {

                    System.out.print("Enter required dosage (mg): ");
                    double dosageMg = input.nextDouble();

                    int tablets = (int) Math.ceil(dosageMg / 250.0);

                    metricValue = tablets;
                    System.out.println("Tablets needed: " + tablets);
                    metricDisplay = "Tablets=" + tablets;

                } else if (metricChoice == 3) {

                    System.out.print("Enter angle in degrees: ");
                    double angleDegrees = input.nextDouble();

                    double angleRadians = Math.toRadians(angleDegrees);

                    double sinVal = Math.round(Math.sin(angleRadians) * 1000) / 1000.0;
                    double cosVal = Math.round(Math.cos(angleRadians) * 1000) / 1000.0;

                    System.out.println("sin(" + angleDegrees + "°) = " + sinVal);
                    System.out.println("cos(" + angleDegrees + "°) = " + cosVal);

                    metricValue = Math.round(sinVal * 100);
                    metricDisplay = "Sin=" + sinVal;
                }
            }


            char randomLetter = (char) ('A' + (int)(Math.random() * 26));


            int digit1 = 3 + (int)(Math.random() * 7);
            int digit2 = 3 + (int)(Math.random() * 7);
            int digit3 = 3 + (int)(Math.random() * 7);
            int digit4 = 3 + (int)(Math.random() * 7);


            String shortID = "" + randomLetter + digit1 + digit2 + digit3 + digit4;

            boolean validLength = (shortID.length() == 5);
            boolean firstIsLetter = Character.isLetter(shortID.charAt(0));
            boolean allDigits = Character.isDigit(shortID.charAt(1)) &&
                    Character.isDigit(shortID.charAt(2)) &&
                    Character.isDigit(shortID.charAt(3)) &&
                    Character.isDigit(shortID.charAt(4));


            if (!validLength) {
                System.out.println("Invalid length");
            } else if (!firstIsLetter) {
                System.out.println("Invalid: first char must be a letter");
            } else if (!allDigits) {
                System.out.println("Invalid: last 4 must be digits");
            } else {
                System.out.println("ID OK");
            }


            System.out.print("Enter your first name: ");
            String firstName = input.next();


            char baseCode = Character.toUpperCase(firstName.charAt(0));
            System.out.println("Base code = " + baseCode);


            char shiftedLetter = (char)('A' + (baseCode - 'A' + 2) % 26);
            System.out.println("Shifted letter of base code = " + shiftedLetter);


            String lastTwoChars = shortID.substring(3, 5);
            System.out.println("Last two characters for ID (task 3): " + lastTwoChars);


            int metricInt = (int) metricValue;

            String displayCode = "" + shiftedLetter + lastTwoChars + "-" + metricInt;
            System.out.println("Display Code: " + displayCode);


            String summary = "Summary: " + serviceName + " | ID=" + shortID + " | ";


            if (Character.toUpperCase(serviceCode) == 'T' && !metricDisplay.isEmpty()) {
                summary = summary + metricDisplay + " | ";
            }

            summary = summary + "Code=" + displayCode;

            System.out.println(summary);

            input.close();
        }
}
