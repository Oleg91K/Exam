package exam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ticket> tickets = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Добавить клиента");
            System.out.println("2 - Зарегестрировать клиента в фитнесс клуба");
            System.out.println("3 - Вывести информацию о зарегистрированных посетителях");
            System.out.println("4 - Завершить работу фитнеса");
            System.out.println("0 - выход");
            int userChoice = in.nextInt();
            if (userChoice == 0) break;
            switch (userChoice) {
                case 1:
                    tickets.add(Ticket.addTicket(Client.addClient()));
                    break;
                case 2:
                    System.out.println("Выберите клиента которого необходимого зарегестрировать");
                    printClientNotRegistr(tickets);
                    int idClient = in.nextInt();
                    System.out.println("В какую зону клиент хочет попасть");
                    System.out.println("1 - Тренажерный зал");
                    System.out.println("2 - Групповые занятия");
                    System.out.println("3 - Бассейн");
                    int typeZoneInt = in.nextInt();
                    TypeZone typeZone = null;
                    switch (typeZoneInt) {
                        case 1:
                            typeZone = TypeZone.GYM;
                            break;
                        case 2:
                            typeZone = TypeZone.GROUP_CLASSES;
                            break;
                        case 3:
                            typeZone = TypeZone.SWIMMING_POOL;
                            break;
                        default:typeZone = null;
                    }
                    Fitness.regClient(typeZone,getTicketByClientID(tickets,idClient));
                    break;
                case 3:
                    Fitness.printInfo();
                    break;
                case 4:
                    Fitness.close();
                    break;
            }
        }
    }
    public static void printClientNotRegistr(ArrayList<Ticket> tickets){
        for (Ticket ticket : tickets) {
            if(!Fitness.checkClientInZones(ticket.getClient()))
                ticket.getClient().printInfo();
        }
    }
    public static Ticket getTicketByClientID (ArrayList<Ticket> tickets,int id){
        for (Ticket ticket : tickets) {
            if(ticket.getClient().getId() == id)
            return ticket;
        }
        return null;
    }
}

