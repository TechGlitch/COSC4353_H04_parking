public class Client extends Parking {

    private String clientName;

    Client(){
        clientName = "Group A";
    }

    Client(String name)
    {
        this.clientName = name;
    }

    public void setName(String name)
    {
        this.clientName = name;
    }

}
