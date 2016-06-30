package contactDesktop;

/**
 * Created by Nigel on 6/29/16.
 */
public class Contact {
    String nameText, phoneText, emailText;

    public Contact(){

    }

    public Contact(String nameText, String phoneText, String emailText) {
        this.nameText = nameText;
        this.phoneText = phoneText;
        this.emailText = emailText;
    }

    public String getNameText() {
        return nameText;
    }

    public String getPhoneText() {
        return phoneText;
    }

    public String getEmailText() {
        return emailText;
    }

    @Override
    public String toString(){
        return nameText + ", " + phoneText + ", " + emailText;
    }
}
