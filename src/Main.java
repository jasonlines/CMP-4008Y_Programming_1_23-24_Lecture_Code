public class Main {

    public static void main(String[] args){
        // a quick example to show that we cannot access private fields but CAN access public methods of XboxGame

        // First, another example game object:
        XboxGame xg = new XboxGame("Balder's Gate 3", "Larian Studios", 1, "PEGI 18");

        // in the above, say we made an error - Balder's Gate 3 did not have local multiplayer on Xbox Series S when it
        // was released but it does have 2-player local co-op on Xbox Series X. Therefore, we want to change the
        // numPlayers field of our object, called xg, to be 2.

        // First, let's print the toString of xg to verify that numPlayers has been set to 1 initially (also you could
        // check this by using a breakpoint and the debugger - which I encourage you to investigate and get used to
        // because it is VERY useful (to set a breakpoint in IntelliJ, click in the margin next to the line number so
        // that a red circle appears, then right click anywhere in the file and select "Debug Main.main" instead of Run)

        System.out.println(xg);         // try setting a breakpoint here and run the code in debugging mode

        // we CANNOT do the following - if you uncomment it, it will be a compilation error and your IDE should say
        // something along the lines of "'numPlayers' has private access". This is because we intentionally made the
        // field have private access in the XboxGame class to manage how fields can be modified in other classes

        // xg.numPlayers = 2; // TRY UNCOMMENTING THIS LINE TO SEE WHAT HAPPENS - RE-COMMENT BEFORE RUNNING, THOUGH

        // However, we did want to allow functionality to change the number of players later (because sometimes
        // games are updated to add new modes, ratings change, developer studios get renamed, etc.). Therefore, we can
        // change the number of players using the public accessor that we provided
        xg.setNumPlayers(2);        // this is perfectly fine as setNumPlayers has public access

        // The logic above is powerful because we may wish to make sure certain fields cannot be changed externally.
        // For example, image there was a genre field - it would make less sense for a genre of a game to change, so
        // there could be a private field for genre so it is stored for a game, a public accessor so we can view the
        // genre, but if we do not provide a public mutator, the genre cannot be changed. This is powerful because it
        // is up to us as the designers of the code to decide what functionality it has

        // Now let's verify that the field updated by printin the toString again (or, again, set a new breakpoint and
        // inspect the state of the xg object to make sure it has updated)
        System.out.println(xg);
    }
}
