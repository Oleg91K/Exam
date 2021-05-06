package exam;

public class Random {
    public static String randName(){
        String[] randomName ={"Олег","Рома","Дмитрий","Артем","Виктор","Ирина","Ольга",
        "Мария","Светлана","Екатерина",""};
        return randomName[(int) (Math.random()*10)];
    }
    public static String randSurName(){
        String[] randomSurName = {"Волк","Вулич","Моль","Грач","Цой","Черных","Седых",
        "Мышь","Шевченко","Синих"};
        return randomSurName [(int)(Math.random()*10)];
    }

    public static int randYear(){
        int [] randomYear = {1960,1964,1972,1976,1986,1988,1991,1995,1999,2001};
        return randomYear [(int)(Math.random()*10)];
    }

}
