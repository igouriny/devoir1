package modele.communication;

public class Message {

    private String numDestination;
    private String message;

    public Message(String numDestination, String message) {
        this.numDestination = numDestination;
        this.message = message;
    }

    public String getNumDestination() {
        return numDestination;
    }

    public String getMessage() {
        return message;
    }


}
