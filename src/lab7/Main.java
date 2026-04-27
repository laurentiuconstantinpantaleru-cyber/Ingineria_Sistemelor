package lab7;

public class Main {
    public static void main(String[] args) {
        Form f1 = new Form("red");
        Form f2 = new Form("blue");
        Form f3 = new Form();

        System.out.println("Valoare contor instanțe: " + Form.getCounter());
        PasswordMaker pm1 = PasswordMaker.getInstance();
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("Parola generata: " + pm1.getPassword());
        System.out.println("Metoda getInstance a fost apelată de: " + PasswordMaker.getAccessCounter() + " ori.");

        System.out.println("Sunt aceleași obiecte? " + (pm1 == pm2)); // Va afișa true
    }
}
