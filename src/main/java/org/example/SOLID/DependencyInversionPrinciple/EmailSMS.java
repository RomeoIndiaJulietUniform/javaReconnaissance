package org.example.SOLID.DependencyInversionPrinciple;

class EmailService{
    public void sendingNotification(String Message){
        System.out.println("Email Service is sending " + Message);
    }
}

class SMSService{
    public void sendingNotification(String Message){
        System.out.println("SMS Service is sending "+ Message);
    }
}



class UserService{

    SMSService smsService = new SMSService();
    EmailService emailService = new EmailService();

    void sendMessage(String type, String message){
        if(type == "SMS"){
            smsService.sendingNotification(message);
        }
        else if(type == "Email"){
            emailService.sendingNotification(message);
        }
    }

}



public class EmailSMS {

    public static void main(String[] args){
        UserService userService = new UserService();

        userService.sendMessage("SMS", "hii bro");
    }
}
