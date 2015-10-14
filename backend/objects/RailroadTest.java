public class RailroadTest
{
    public static void main(String[] args)
    {
        // create railroad space
        BoardLocation[] board = new BoardLocation[1];
        board[0] = new Railroad("Reading Railroad", 5);

        // print railroad details
        System.out.println(board[0].toString());

        // create mock player
        Player player = new Player(20, "Boot");

        // create mock owner
        Player owner = new Player(500, "Thimble");

        if(board[0].buy(owner))
        {
            // do nothing
        } 
        //else 
        //{
            //System.out.println("Error adding owner");
        //}
        
        // create mock owner
        
    }
}
