package exam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class Ticket {
    private LocalDate openTicket;
    private LocalDate closeTicket;
    private TypeTickets typeTickets;
    private Client client;

    public Ticket(LocalDate closeTicket, TypeTickets typeTickets, Client client) {
        if(closeTicket.isAfter(LocalDate.now())) {
            this.openTicket = LocalDate.now();
            this.closeTicket = closeTicket;
            this.typeTickets = typeTickets;
            this.client = client;
        }else{
            System.out.println("Дата окончания меньше текущей");
        }
    }

    public LocalDate getOpenTicket() {
        return openTicket;
    }

    public void setOpenTicket(LocalDate openTicket) {
        this.openTicket = openTicket;
    }

    public LocalDate getCloseTicket() {
        return closeTicket;
    }

    public void setCloseTicket(LocalDate closeTicket) {
        this.closeTicket = closeTicket;
    }

    public TypeTickets getTypeTickets() {
        return typeTickets;
    }

    public void setTypeTickets(TypeTickets typeTickets) {
        this.typeTickets = typeTickets;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public static Ticket addTicket(Client client){
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите тип абонемента: ");
        System.out.println("1 - Полный абонемент");
        System.out.println("2 - Дневной абонемент");
        System.out.println("3 - Разовый абонемент");
        int typeTicket = in.nextInt();
        System.out.println("Выберите срок действия абонемента абонемента: ");
        System.out.println("1 - 12 месяцев");
        System.out.println("2 - 6 месяцев");
        System.out.println("3 - 3 месяца");
        int periodTicket = in.nextInt();

        TypeTickets typeTickets;
        LocalDate endDate;
        switch (typeTicket) {
            case 1:
                typeTickets = TypeTickets.FULL_TICKET;
                break;
            case 2:
                typeTickets = TypeTickets.DAILY_TICKET;
                break;
            case 3:
                typeTickets = TypeTickets.SINGLE_TICKET;
                break;
            default:typeTickets = null;
        }
        switch (periodTicket) {
            case 1:
                endDate = LocalDate.now().plusMonths(12);
                break;
            case 2:
                endDate = LocalDate.now().plusMonths(6);
                break;
            case 3:
                endDate = LocalDate.now().plusMonths(3);
                break;
            default:endDate = null;
        }
        return new Ticket(endDate,typeTickets,client);
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "openTicket=" + openTicket +
                ", closeTicket=" + closeTicket +
                ", typeTickets=" + typeTickets +
                ", client=" + client +
                '}';
    }
}






