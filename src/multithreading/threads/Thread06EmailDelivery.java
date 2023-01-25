package multithreading.threads;

import javax.swing.*;
import multithreading.service.EmailDeliveryService;
import multithreading.threads.dominio.Members;

public class Thread06EmailDelivery {

    public static void main(String[] args) {
        Members members = new Members();
        Thread jiraya = new Thread(new EmailDeliveryService(members), "Jiraya");
        Thread kakashi = new Thread(new EmailDeliveryService(members), "Kakashi");
        jiraya.start();
        kakashi.start();
        while (true) {
            String email = JOptionPane.showInputDialog("Enter your email");
            if (email == null || email.isEmpty()) {
                members.close();
                break;
            }
            members.addMemberEmail(email);
        }
    }
}
