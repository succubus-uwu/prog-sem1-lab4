package axl.itmo;

public class IllegalGameInitialization extends RuntimeException {

    public IllegalGameInitialization(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Невозможно воссоздать игру: " + super.getMessage();
    }
}
