public class XboxGame {

    //////////////
    // We will follow the class definition checklist that was given in the lectures (week 1 and 2 from Semester 2).
    //
    // Specifically:
    // 1. attributes/fields
    // 2. constructor(s)
    // 3. accessors and mutators (note that we only include these if the class requires them)
    // 4. class-specific methods (any  behaviour that is specific to this class)
    // 5. test harness/main method - remember, every class we make can have its own local main method for testing
    // (not in the check-list, but it is also good practice to have an implementation of toString for each class)

    //////////////
    // 1. attributes/fields
    // Our fields will be private so that we can control access to them - if we want users/other classes to be able to
    // observe the values of these attributes then we can provide public accessor methods, and if we want users/other
    // classes to be able to modify them then we can provide public mutator methods. However, we do not HAVE to include
    // accessor or mutators, and if we don't, objects of this class will still have these fields/attributes internally
    // but they cannot be viewed or modified externally (for example, if you had a login system with a User class then
    // a password attribute of the class should be private and not have a public accessor (as you do not want others to
    // be able to see it easily) BUT it is important that the password is still stored privately - for example, if you
    // wanted to have a method such as checkEnteredPassword(String enteredPassword) to compare an entered password to
    // the stored one, the check can be done privately inside that method without ever exposing the value of the
    // password
    private String gameName;
    private String devName;
    private int numPlayers;
    private String ageRating;   // String for now so "Everyone" or similar is acceptable, but enums are better later

    ////////////////
    // 2. Constructors
    // Remember that all classes in Java will have an automatic default constructor IF AND ONLY IF you do not provide
    // your own. However, as soon as you specify your own then this automatic default constructor will no longer exist.
    // Generally, it is better to be specific when learning to program, so even if your class only needs a default
    // constructor (e.g. new XboxGame()) then you can still specify the default constructor explicitly. In this case,
    // however, we only need one constructor that takes 4 args for each of the fields:
    public XboxGame(String gameName, String devName, int numPlayers, String ageRating){
        this.gameName = gameName;
        this.devName = devName;
        this.numPlayers = numPlayers;
        this.ageRating = ageRating;
    }
    // We are using the "this" operator above so that it disambiguates the arguments (the things passed into the method)
    // from the fields/attributes of the object that we're creating. Specifically "this." means we are referring to
    // THIS specific object that we are creating, and in other instance methods, this. means the fiels of the
    // specific object that we are calling the method on (more on that below)

    //////////////
    // 3. Accessors and mutators (or "getters" and "setters")
    // As above, these are required to give outside access (to users or other classes) to our private fields. If our
    // fields were public then we would not need accessors and mutators - but it also means we would have no control
    // over how the fields are used, viewed, or modified. By having private fields, and public accessor/mutator methods,
    // it means ONLY fields with a public accessor can be viewed, and ONLY fields with a public mutator can be modified,
    // meaning we have control over how fields are used and changed. So, while it may seem like extra effort and verbose
    // code to have private fields and public accessor/mutators, there is a very important reason for them - because
    // if we do not want anyone to access/modify a field in our class, we just make sure the field itself is private and
    // then do not provide a public accessor/mutator.

    // In this example, however, we do not need to worry about access or modification of our fields externally.
    // Therefore, for the sake of this example, we will have an accessor and a mutator for each of the 4 fields:
    public String getGameName() {
        return gameName;    // same as "return this.gameName" but we did not need "this." since there is no ambiguity
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;   // we DID need this. here though, as gameName is
                                    // the arg and this.gameName is the field
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public int getNumPlayers() {    // note that the return type must match the type of what we are actually returning
        return numPlayers;          // since numPlayers is an int, the return type of this method is int, not String
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    ////////////////
    // 4. Class-specific methods
    // This is a catch-all for methods that do not fit the standard pattern - i.e. they do something specific to this
    // class, rather than just be a constructor/accessor/mutator. The example we have in this use case is a simple
    // method to return true/false depending on whether the game in question is a multiplayer game (if numPlayers is
    // greater than 1 return true, else return false. Obviously it would be a good idea to check to make sure numPlayers
    // is an int greater than 0, but that should be done when the object is constructed (and more on that when we
    // see exceptions later in the module

    // return type is boolean (true/false) and no arg needed as it is an instance method - i.e. we need an actual
    // XboxGame object to call this method on (i.e. "this" XboxGame that the method is called on)
    public boolean isMultiplayer() {
        return this.numPlayers > 1;
        // could also be written as an if statement, e.g.
        // if(this.numPlayers < 1){
        //      return false;
        // }else{
        //      return true;
        // }
    }

    ///////////
    // toString - not in the checklist, but good practice to include too. We will talk more about toString in week 3
    // as it relates to inheritance, but informally, think of this method as a way to return a String representation
    // of "this" object. Every class has a toString by default but it is your job as the programmer to redefine it to
    // be specific to your class. In this case, we would like it to return a String that includes information about
    // the state of "this" object (i.e. it will return a String with the values of the fields for whichever XboxGame
    // it is called on)
    public String toString(){   // note that if you are using IntelliJ there will be an override icon on the left - more
                                // on that in week 3 with inheritance (other editors will likely show similar too)
        return "Name: " + this.gameName + ", Developer: " + this.devName + ", Players: " +
                this.numPlayers + ", Rating: " + this.ageRating;
    }

    ////////
    // 5. Test harness - remember, all classes can have their own local main method/test harness. This is useful for
    // testing complex functionality in classes but also for showing example usage to other programmers that may wish
    // to use your code. In the example below we'll make an object of type XboxGame using our constructor and then test
    // some of the methods.
    public static void main(String[] args) {
        // note - 1 for num players (as we're assuming local on the same machine/console) and "12" for the age, but
        // remember, "12" must be a String because we declared that the ageRating field is a String (so we could also
        // store "Everyone" or similar"). To make it more obvious in this example we can use the full rating, which
        // officially would be "PEGI 12" (and more obviously a String)
        XboxGame firstGame = new XboxGame("Palworld", "Pocket Pair", 1, "PEGI 12");

        // we can make as many different games as we like - remember, a class is like a blueprint, and then an object
        // of that class is a specific case of it. In this example, let's make a second XboxGame for Rocket League
        XboxGame secondGame = new XboxGame("Rocket League", "Psyonix", 2, "PEGI 3");

        System.out.println("Testing the toStrings:");
        System.out.println("======================================");
        // a quick test to make sure that the toString and isMultiplayer methods are working correctly
        String firstToString = firstGame.toString(); // remember, toString returns a String so we can store it
        System.out.println(firstToString);           // and then print it out

        System.out.println(secondGame);             // or if we just try to print the object itself, Java knows to
                                                    // call the toString automatically so that we can print it
        System.out.println();                       // can print empty line for formatting by passing no args

        // now let's test the isMultiplayer method with an accessor:
        System.out.println("Testing accessor and isMultiplayer:");
        System.out.println("======================================");
        System.out.println("Is " + firstGame.gameName + " a multiplayer game?\t\t\t" + firstGame.isMultiplayer());
        System.out.println("Is " + secondGame.gameName + " a multiplayer game?\t" + secondGame.isMultiplayer());
    }
}
