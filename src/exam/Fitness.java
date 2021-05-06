package exam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Fitness {

    static final int MAX_CLIENTS_FROM_ZONE = 20;
    static ArrayList<Client> clientsGym = new ArrayList<>();
    static ArrayList<Client> clientsGroup = new ArrayList<>();
    static ArrayList<Client> clientsPool = new ArrayList<>();


    static void close() {
        clientsGym.removeAll(clientsGym);
        clientsGroup.removeAll(clientsGroup);
        clientsPool.removeAll(clientsPool);
    }

    static void regClient(TypeZone typeZone, Ticket ticket) {
        if (!Utils.dateReg(ticket.getCloseTicket())) {
            System.out.println("Абонемент просрочен");
            return;
        }
        if (!checkTypeZone(typeZone, ticket)) {
            System.out.println("Клиент не имеет доступа в эту зону");
            return;
        }
        if (!checkFreeZone(typeZone)) {
            System.out.println("Выбранная зона занята");
            return;
        }
        if (checkClientInZones(ticket.getClient())) {
            System.out.println("Клиент уже зарегестрирован");
            return;
        }
        switch (typeZone){
            case GYM:
                clientsGym.add(ticket.getClient());
                break;
            case SWIMMING_POOL:
                clientsPool.add(ticket.getClient());
                break;
            case GROUP_CLASSES:
                clientsGroup.add(ticket.getClient());
                break;
        }
    }

    private static boolean checkTypeZone(TypeZone typeZone, Ticket ticket) {
        switch (typeZone) {
            case GYM:
                return ticket.getTypeTickets().isAccessGym();
            case SWIMMING_POOL:
                return ticket.getTypeTickets().isAccessPool();
            case GROUP_CLASSES:
                return ticket.getTypeTickets().isAccessGroup();
            default:
                return false;
        }
    }

    private static boolean checkFreeZone(TypeZone typeZone) {
        switch (typeZone) {
            case GYM:
                return clientsGym.size() < MAX_CLIENTS_FROM_ZONE;
            case SWIMMING_POOL:
                return clientsPool.size() < MAX_CLIENTS_FROM_ZONE;
            case GROUP_CLASSES:
                return clientsGroup.size() < MAX_CLIENTS_FROM_ZONE;
            default:
                return false;

        }
    }
    public static boolean checkClientInZones(Client client){
        for (Client clientInArray : clientsGym){
            if(clientInArray == client)
                return true;
        }
        for (Client clientInArray : clientsPool){
            if(clientInArray == client)
                return true;
        }
        for (Client clientInArray : clientsGroup){
            if(clientInArray == client)
                return true;
        }
        return false;
    }
    public static void printInfo() {
        System.out.println("Клиенты тренажерного зала: ");
        for (Client client : clientsGym) {
            client.printInfo();
        }
        System.out.println("Клиенты бассейна: ");
        for (Client client : clientsPool) {
            client.printInfo();
        }
        System.out.println("Клиенты групповых занятий: ");
        for (Client client : clientsGroup) {
            client.printInfo();
        }
    }

}