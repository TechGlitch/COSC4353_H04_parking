public class Parking {
    /*
    1. A parking lot has a capacity.
    2. A parking lot has entrance and exit gates.
    3. Cars receive a time-stamped ticket at entry.
    4. Cars present the ticket at exit gates, pay and then leave the parking lot.
    5. Cars cannot be admitted if there is no space in the parking lot.
    6. NEW: Each parking lots belongs to a group that sets the price, discounts, and policies in the group.
    7. Cars can inquire the latest price and availability of parking space.
    8. NEW: groups can send the latest prices to interested cars.
    9. NEW: Cars can be only at one place at a time, i.e., they cannot park in two different parking lots.
    10. NEW: Cars choose the lowest available parking lot for parking.
    Requirement: NEW: Use the Maven build system to automated the build process.
    Goal: The owners of parking lots want you to maximize their profits.
     */
    private int capacity;
    private int avail;
    private boolean isFull;
    private int rate;
    private int total;

    Parking()
    {
        this.capacity = 100;
        this.avail = 100;
        this.isFull = false;
        this.rate = 10;
    }

    Parking(int capacity, int avail, int rate)
    {
        setCapacity(capacity);
        setAvail(avail);
        setRate(rate);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAvail(int available)
    {
        this.avail = available;
    }

    public void setRate(int rate)
    {
        this.rate = rate;
    }

    private void Total()
    {
        total += rate;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getAvail()
    {
        return this.avail;
    }

    public int getRate()
    {
        return this.rate;
    }

    private int getTotal()
    {
        return this.total;
    }

    protected void carEnter()
    {
        if (isFull == false){
            System.out.println("A car has entered");
            avail -= 1;
            checkAvail();
        }
        else if(isFull == true)
            System.out.println("Lot has reached capcity, no spots available. " + avail);
    }

    protected void carExit()
    {
        if(isFull == true){
            System.out.println("A car has left, a space is available");
            avail += 1;
            Total();
            isFull = false;
        }
        else if(avail == capacity)
        {
            System.out.println("No car left in lot");
        }
        else{
            Total();
            System.out.println("Car is paying: $" + rate + ", now exiting. Total for today is: $" + total);
            avail += 1;
        }
    }

    private void checkAvail()
    {
        if (avail == 0) {
            isFull = true;
            System.out.println("Parking lot is full, no more cars can enter");
        }
    }
}