package modele.communication;

public class Message {

    private final String numeroDestination;
    private final String message;

    public Message(String numeroDestination, String message) {
        this.numeroDestination = numeroDestination;
        this.message = message;
    }

    public String getNumeroDestination() {
        return numeroDestination;
    }
    public String getMessage() {
        return message;
    }
}
