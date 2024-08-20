import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Caesar Verschlüsselung");

        String text = "";

        while (text.isEmpty()) {
            System.out.println("Bitte geben Sie den zu verschlüsselnden Text ein:");
            text = scanner.nextLine();

            if (text.isEmpty()) {
                System.out.println("Es wurde kein Text eingegeben. Bitte geben Sie einen gültigen Text ein.");
            }
        }

        int schluessel;

        // Validierung des Schlüssels
        while (true) {
            System.out.println("Bitte geben Sie den Verschlüsselungsschlüssel ein (1-25):");
            schluessel = scanner.nextInt();

            if (schluessel >= 1 && schluessel <= 25) {
                break; // Gültiger Schlüsselwert, Schleife wird beendet
            } else {
                System.out.println("Ungültiger Schlüssel! Der Schlüssel muss zwischen 1 und 25 liegen.");
            }
        }

        // Initialisierung des Arrays
        char[] verschluesselterText = new char[text.length()];

        // Schleife durch jedes Zeichen im Text
        for (int i = 0; i < text.length(); i++) {
            char zeichen = text.charAt(i);

            // Beispiel: Großbuchstabe C, Schlüssel 3
            if (zeichen >= 'A' && zeichen <= 'Z') {
                // C --> 67 - ("A" = 65) = 2 + schluessel 3 = 5 --> %26 = 5 + ("A" = 65) = 70 --> F
                verschluesselterText[i] = (char)((zeichen - 'A' + schluessel) % 26 + 'A');
            }
            else if (zeichen >= 'a' && zeichen <= 'z') {
                verschluesselterText[i] = (char)((zeichen - 'a' + schluessel) % 26 + 'a');
            }
            else {
                verschluesselterText[i] = zeichen;
            }
        }

        // Ausgabe des verschlüsselten Textes
        System.out.println("Verschlüsselter Text:");
        System.out.println(new String(verschluesselterText));
    }
}
