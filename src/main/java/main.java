import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of groups you would like: ");
        int number = input.nextInt();

        ArrayList<Client> clients = new ArrayList<Client>();

        for (int i = 0; i < number; i++)
        {
            System.out.println("Please enter the name of group " + (i+1));
            String name = input.next();
            System.out.println("Please enter the capacity of lot, number of available slots, and charging rate: ");
            int c = input.nextInt();
            int a = input.nextInt();
            int r = input.nextInt();

            if (c < 0 || a < 0 || r < 0)
            {
                c = Math.abs(c);
                a = Math.abs(a);
                r = Math.abs(r);
                System.out.println("Negative number given, changing values to postive.");
            }

            Client group = new Client();
            group.setName(name);
            group.setCapacity(c);
            group.setAvail(a);
            group.setRate(r);
            clients.add(group);
        }

        System.out.println("How many cars are expected to come in then out: ");
        int carEntering = input.nextInt();
        int carExiting = input.nextInt();

        Collections.sort(clients, new Sortbyrate());

        for(int i = 0; i < clients.size(); i++){
            if (clients.size() == 1){
                for(int j = 0; j < carEntering;j++){
                clients.get(0).carEnter();
                }
                for (int k = 0; k < carExiting; k++)
                {
                    clients.get(0).carExit();
                }
            }

        }


    }
}

class Sortbyrate implements Comparator<Client>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Client a, Client b)
    {
        return a.getRate() - b.getRate();
    }
}