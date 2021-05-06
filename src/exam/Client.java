package exam;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Client {
    private static int count = 0;
    private int id ;
    private String name;
    private String surName;
    private int year;


    public Client(String name, String surName, int year) {
        count++;
        this.name = name;
        this.surName = surName;
        this.year = year;
        this.id =count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null && name.length()!= 0) {
            System.out.println("Имя не может быть ноль");
        }
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        if("".equals(surName)) {
            System.out.println("Фамилия не может быть ноль");
        }
        this.surName = surName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        Date today = new Date();
        if (year < 0 || year > today.getYear()-18)
            System.out.println("Год рождения не может быть отрицательным или меньше 18 лет");
        this.year = year;
    }
    public void info() {
        System.out.println("Имя: " + this.name + "Фамилия: " + this.surName + "Год Рождения: "
                + this.year);
    }
    public void printInfo(){
        System.out.println("Клиент(" + id + "): " + " Имя: " + name + " Фамилия: " + surName + " Год Рождения: "+ year);
    }
    public static Client addClient(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите Фамилию");
        String name = in.nextLine();
        System.out.println("Введите Имя");
        String surName = in.nextLine();
        System.out.println("Введите Год Рождения");
        int year = in.nextInt();
        return new Client(name,surName,year);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", year=" + year +
                '}';
    }
}
