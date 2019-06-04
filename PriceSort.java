public class PriceSort{
    public static void main(String[] args){
        Computer[] computers = {
            new Workstation("wsl", 800, 256, 300000),
            new PersonalComputer("Pc1", 450,128,180000),
            new Workstation("ws2", 800, 512, 500000),
            new PersonalComputer("pc2", 450, 256, 200000),
        };

        for(int i = 0; i < computers.length; i++){
            System.out.println(computers[i]);
        }
        System.out.println("\n<sorted by price>");
        PriceUtility.computeDiscountPrice(computers);
        PriceUtility.sort(computers);

        for(int i = 0; i < computers.length; i++){
            System.out.println(computers[i]);
        }
    }
}

interface IComp{
    int compareWith(IComp a);
}

class Computer implements IComp{
    String name;
    int frequency;
    int memory;
    int price;

    public Computer(String name, int frequency, int memory, int price){
        this.name = name;
        this.frequency = frequency;
        this.memory = memory;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String toString(){
        return name + ", frequency:" + frequency + ", mamory" + memory + ", price" + price;
    }
    public double getDiscountRate(){
        return 0.0;
    }
    public int compareWith(IComp a){
        Computer computer = (Computer)a;
        return computer.price - this.price;
    }
}

class Workstation extends Computer{
    public Workstation(String name, int frequency, int memory, int price){
        super(name,frequency,memory,price);
    }

    public double getDiscountRate(){
        return 0.1;
    }
}

class PersonalComputer extends Computer{
    public PersonalComputer(String name, int frequency, int memory, int price){
        super(name,frequency,memory,price);
    }

    public double getDiscountRate(){
        return 0.2;
    }
}

class PriceUtility{
    public static void computeDiscountPrice(Computer[] a){
        int newPrice;
        for(int i = 0; i < a.length; i++){
            newPrice = (int)(a[i].getPrice() * (1 - a[i].getDiscountRate()));
            a[i].setPrice(newPrice);
        }
    }

    public static void sort(IComp[] a){
        int j;

        for(int i = 1; i < a.length; i++){
            IComp temp = a[i];
            for(j = i - 1; j >= 0 && temp.compareWith(a[j]) < 0; j--){
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
    }
}