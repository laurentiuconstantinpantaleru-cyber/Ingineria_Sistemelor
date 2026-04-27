package lab7;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;

    // a)
    private static final PasswordMaker instance;

    // c)
    private static int accessCounter = 0;

    private String name;

    // b)
    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);

        // Inițializăm instanța unică aici (putem da un nume default)
        instance = new PasswordMaker("DefaultUser");
    }

    // a)
    private PasswordMaker(String name) {
        this.name = name;
    }

    // a)
    public static PasswordMaker getInstance() {
        // c) Incrementăm contorul
        accessCounter++;
        return instance;
    }

    // Getter pentru contor
    public static int getAccessCounter() {
        return accessCounter;
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = "" + name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }
}