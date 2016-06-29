package contactDesktop;

/**
 * Created by Nigel on 6/29/16.
 */
public class Contact {
    String nameText, phoneText, emailText;

    public Contact(String nameText, String phoneText, String emailText) {
        this.nameText = nameText;
        this.phoneText = phoneText;
        this.emailText = emailText;
    }

    @Override
    public String toString(){
        return nameText + ", " + phoneText + ", " + emailText;
    }
}
