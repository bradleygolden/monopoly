public class RailroadTest
{
    public static void main(String[] args)
    {
        // create railroad space
        BoardLocation railroad = new Railroad("Reading Railroad", 5);

        // print railroad details
        System.out.println(railroad.toString());

        // create mock player
        Player player = new Player(20, "Boot");

        // create mock owner
        Player owner = new Player(20, "Thimble");

        if(railroad.buy(owner))
        {
            // do nothing
        } 
        else 
        {
            System.out.println("Error adding owner");
        }
        
        // create mock owner
        
    }
}
