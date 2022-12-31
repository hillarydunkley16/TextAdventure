import java.util.Scanner;
import java.util.*;
import com.google.common.graph.*;

/** init build a graph using Places (taking code from GuavaPractice)
*create all places (one would be the start)
*connect places into graph 
*calls start
* current (node)=start.place (run game loop)
*/

public class Adventure{

  // Mutable graphs can be changed after we build them
    private MutableNetwork<Place,Exit> world;
    Place currentLoc;
    double timeLeft = 360.0; //6 hours in minutes
    //int timeLeftHrs = timeLeft/ 60;
    Place parlor = new Place("The parlor", "Julie enters the parlor.", false);
    Place library = new Place("The library", "Julie enters the library.", false);
    Place kitchen = new Place("The kitchen", "Julie enters the kitchen.", false);
    Place masterBedroom = new Place("Master bedroom", "Julie enters the master bedroom.", false);
    Place attic = new Place("Attic", "Julie enters the attic", false);
    Exit North = new Exit("North",Direction.NORTH,"Julie goes north");
    Exit South = new Exit("South", Direction.SOUTH, "Julie goes south");
    Exit East = new Exit("East",Direction.EAST,"Julie goes east");
    Exit West = new Exit("West",Direction.WEST,"Julie goes west");
    Exit Up = new Exit("Up",Direction.UP,"Julie goes up");
    Exit Down = new Exit("Down",Direction.DOWN,"Julie goes down");
    Exit Southeast = new Exit("SouthEast", Direction.SOUTHEAST, "Julie goes Southeast bc I'm struggling");
    Boolean begin; 
    Boolean game = true;
  
    public Adventure (){
      world = NetworkBuilder.directed().allowsParallelEdges(true).allowsSelfLoops(true).build();
      world.addNode(parlor);
      world.addNode(library);
      world.addNode(kitchen);
      world.addNode(masterBedroom);
      world.addNode(attic);
      world.addEdge(parlor, library, South);
      world.addEdge(library,parlor, North);
      world.addEdge(parlor,kitchen, East);
      world.addEdge(kitchen,parlor, West);
      world.addEdge(attic, library, Southeast);
      world.addEdge(library,masterBedroom,Up);
      world.addEdge(masterBedroom,library,Down);
      // world.addEdge(attic, library, Up);
      // world.addEdge(library,attic, Down);
      // Boolean game = true;
    }
  HashSet<Item> inventory = new HashSet<Item>();
  Item heartKey = new Item("Heart shaped key", masterBedroom, "A key in the shape of a heart");
  Item rustyKey = new Item("rusty key", parlor, "a rusty key");
  Item goldKey = new Item("golden piano key", parlor, "A golden piano key");
  Item screwdriver = new Item("screwdriver",library, "screwdriver to unscrew wood board");
  Item knife = new Item("knife", kitchen, "a rusty knife");
  Item marigold = new Item("marigold",library,"marigold to place in the decaying ofrenda");
   
  public void Start(){
      //Boolean begin = true;
      currentLoc = parlor;
      System.out.println("\t \t \t \t \t Welcome to...");
      System.out.println("\t \t \t \t \t \t \t \t \t \t \t Namor's Revenge");
      System.out.println("\t \t \t \t  A text-based horror-adventure game by Ashley Luna and Hillary Dunkley.");
      System.out.println("");
      System.out.println("");
      System.out.println("There is only one goal you have tonight: to stay alive. \n \nBut tonight, you are not you: you are Julie, a sixteen year old girl who has been invited to her first high school party. And you aren't in the year of our lord 2022...or 2023...or whatever far off year you're living in with Jetson style cars. No, tonight it is 1996. And it is Halloween night. \n\nEarlier in the day Julie applied mascara and dark black eyeliner while listening to Mariah Carey, Alanis Morisette and Whitney Houston on her cd player. She was so excited for her first party that she had been beaming the whole day. It was going to be perfect. She was going to dance with her friends, talk to that cute boy she'd been eyeing in her geometry class, and maybe even sneak a kiss before the night was done. It was going to be perfect. Absolutely, positively perfect. Well, it would've been if her friends gave her the right address.");

     //System.out.println("\n \nJulie's witch costume was starting to get really scratchy as she walked down the quiet suburban street. Her mom told her to have fun and be safe, and to make sure she finds her friends. She wrote the address on a slip of paper that she grasped in her hand: 123 Elm Street. \n \nSoon enough the house came into view. It was quiet and the light was quickly fading. A gust of wind blew through Julie and she felt a shiver go down her spine. She walked up the cracked path to the rotting front door and knocked gently, only to find the door creaking open. Huh, a weird place to have a party, but my friend's have got to be in there somewhere.");
      System.out.println("\nDoes Julie enter?");
      Scanner q1 = new Scanner(System.in);
      String i1 = q1.nextLine();
        if (i1.toUpperCase().charAt(0) == 'Y'){
        System.out.println("The adventure begins! Remaining Time: 6 hours... Explore Parlor or move north to the Library?");
        begin = false;
    }else{
          
        System.out.println("\nHuh, that's weird, because Julie definitely remembers her friends telling her where the house was. It was in between third and fourth period. Jessica, Rachel and Monica had lockers in between Julie and were talking so excitedly about it. The entire basketball and football team was going to be there, and there was even going to be beer pong. When Julie heard them talking she asked them about it and Rachel slyly said, oh yeah, you can come, it's 123 Elm Street. Julie remembers asking Jessica for a slip of paper and asking Monica for a pen so she could write it down. She even asked Rachel to repeat the address three times.");
        System.out.println("\nThey can't have been lying right?");
        System.out.println("\nDoes Julie enter after all? I'll only ask nicely once.");
          begin = false;
        Scanner nicely = new Scanner(System.in);
        String nice = nicely.nextLine();
        if (nice.toUpperCase().charAt(0) == 'Y'){
          System.out.println("The adventure begins! Remaining Time: 6 hours... Explore Parlor or move north to the Library?");
          begin = false;
        }else{
          System.out.println("\nCome one, player. Julie's been waiting for this moment her whole life!! You can't mess this up for her now. There are hot boys inside.");
          Scanner meanly = new Scanner(System.in);
          String mean = meanly.nextLine();
          if (mean.toUpperCase().charAt(0) == 'Y'){
            System.out.println("The adventure begins! Remaining Time: 6 hours... Explore Parlor or move north to the Library?");
          begin = false;
          }else{
            System.out.println("\n\nJulie tripped and fell face first into the door, breaking her nose and her spirit. She layed there and bled out until she eventually died.");
            System.out.println("GAME OVER. DON'T BE A CONTRARIAN.");
            begin = false;
          }
        }
    }
      
    }

    public void World() {
    
    // Place parlor = new Place("The parlor", "Julie enters the parlor.", false);
      //is the game running?
    //Boolean game = true;
    Boolean begin = true;
    
    //game loop 
      Start();
      while (true) {
        Scanner q2 = new Scanner(System.in);
        String i2 = q2.nextLine();
        if(i2.toUpperCase().contains("LIBRARY") || i2.toUpperCase().charAt(0) == 'N'){
          currentLoc = library;
          describePlace(library);
          actionSequence(library);
        }
        describePlace(parlor);
        actionSequence(parlor);
      }
    }
   /**
  function to allow user to choose a direction, update location upon choice. 
  */
    public void Choice(Place currentLoc){
      Set<Exit> roomEdges = world.outEdges(currentLoc);
      System.out.println("Choose a direction to go in.");
      for (Exit i: roomEdges){
        System.out.println(i);
      }
      Scanner scanner = new Scanner(System.in);
      String input;
      boolean choice_ok = false;
      // while choice is not good, keep asking
      while (!choice_ok){
        choice_ok = true;
        input = scanner.nextLine();
        if (input.toUpperCase().charAt(0) == 'N'){
          //System.out.println("North");
          //System.out.println(currentloc.North);
          
          EndpointPair<Place> endpointPair = world.incidentNodes(North);
         currentLoc = endpointPair.nodeV();
         describePlace(currentLoc);
        }else if (input.toUpperCase().charAt(0) == 'S'){
          
          EndpointPair<Place> endpointPair = world.incidentNodes(South);
          currentLoc = endpointPair.nodeV();
          describePlace(currentLoc);
        }else if (input.toUpperCase().charAt(0) == 'E'){
          
          EndpointPair<Place> endpointPair = world.incidentNodes(East);
          currentLoc = endpointPair.nodeV();
          describePlace(currentLoc);
        }else if (input.toUpperCase().charAt(0) == 'W'){
          EndpointPair<Place> endpointPair = world.incidentNodes(West);
          currentLoc = endpointPair.nodeV();
          describePlace(currentLoc);
        }else if(input.toUpperCase().charAt(0) == 'U'){
          EndpointPair<Place> endpointPair = world.incidentNodes(Up);
          currentLoc = endpointPair.nodeV();
          describePlace(currentLoc);
        }else if (input.toUpperCase().charAt(0) == 'D'){
          EndpointPair<Place> endpointPair = world.incidentNodes(Down);
          currentLoc = endpointPair.nodeV();
          describePlace(currentLoc);
        }else{
          choice_ok = false;
          System.out.println("Please pick a valid direction");
          // Choice();
        }
      }
    }
  
    public void describePlace(Place currentLoc){
      if (currentLoc == parlor){
        System.out.println("The parlor");
        System.out.println("Julie enters the parlor. A couch and two armchairs surround a coffee table, an inch thick layer of dust covering the surface. The pale green wallpaper is peeling from the walls and a piano sits in the corner with several keys missing. A skeleton sits on the piano stool, both of its hands on the keyboard as if it's about to play a sonata. That skeleton's got to be fake, right? thinks Julie.");
      }else if(currentLoc == library){
        System.out.println("The library");
        System.out.println("The room has two tall bookcases full of old decaying books expect for one that is in perfect condition. There's a book stand with a locked cabinet. A lamp that is not connected to the outlet flickers occasionally.");
      }else if (currentLoc == kitchen){
        System.out.println("Julie enters the kitchen. A large, mahogany dining table sits with a wrinkled, moth devoured tablecloth that appears to have been white at some point in time. A single plate is set out, shining brightly as if it had just recently been finely polished. There is a brass pot on the stove overflowing with mold with a spatula carefully balancing on its lid. The fridge has magnets with family photos attached all over it.");
        
      }
        else if(currentLoc == masterBedroom){
        //will be locked, only accessed with key in kitchen
          System.out.println("Julie enters the master bedroom. The overwhelming smell of decaying flesh enters her nose. A four poster bed sits in the middle of the room, with sheets crusted with blood and other bodily fluids Julie shudders to think about. Julie takes a step forward and finds a puddle of some sort on the floor. Rain? Wine? Or was it something far worse? Julie notices a vanity with a broken mirror and a dark closet. The lights begins to flicker rapidly. ");
      } 
        //the attic is the end of the story. there julie will have a little showdown with namor
        else if(currentLoc == attic){
          System.out.println("Julie enters the attic.");
      }
    }
  //for every exit have a requirement (ex. password, key etc)
  //explore room to find item
  public void actionSequence(Place currentLoc){
    //System.out.println("1. game is " + game);
    while (game == true){
      //System.out.println("1. game is " + game);
      if (timeLeft == 0){
        System.out.println("Namor has killed you, because Julie is his long lost lover from another life who betrayed him in his time of need.");
        System.out.println("GAME OVER");
      }
      System.out.println("What does Julie do?");
      Scanner q3 = new Scanner(System.in);
       String i3 = q3.nextLine();
      if(i3.toUpperCase().contains("LEAVE")){
        Choice(currentLoc);
      }
      else if (currentLoc == parlor){
       //things to interact with
       //couch
       //wallpaper
       //piano
       //coffee table
         if (i3.toUpperCase().contains("COUCH")){
         System.out.println("The couch is upholstered with a deep fuschia fabric of the couch that shines like a fine silk. It looks like no one has ever sat on it: no stains, no depressions in the cushions. It's perfectly pristine, except for a small rip near the bottom at the left side.");
         System.out.println("sit on the couch?");
         Scanner q4 = new Scanner(System.in);
         String i4 = q4.nextLine();
           if (i4.toUpperCase().charAt(0) == 'Y'){
             System.out.println("Julie sits on the couch and takes a deep breath. It isn't as bad here as she thought. And that skeleton looks pretty funny from her angle. She ponders where her friends might be as her eyelids become heavier and heavier, and soon enough she falls asleep.");
             System.out.println("...");
             Scanner timepass1 = new Scanner(System.in);
             String time1 = timepass1.nextLine();
             System.out.println("...");
             Scanner timepass2 = new Scanner(System.in);
             String time2 = timepass2.nextLine();
             System.out.println("...");
             Scanner timepass3 = new Scanner(System.in);
             String time3 = timepass3.nextLine();
             System.out.println("Oh no! Did Julie fall asleep? It's pitch black outside. Julie checks her casio watch: it's 9pm!");
             timeLeft -= 120;
             System.out.println("Time left " + (timeLeft/60.0) + " hours");
         }else if (i4.toUpperCase().charAt(0) == 'N'){
             System.out.println("No, of course Julie can't rest, she needs to find her friends! But that couch looks so interesting and ornate.");
             System.out.println("Should Julie inspect the rip?");
             Scanner q5 = new Scanner(System.in);
             String i5 = q5.nextLine();
             if (i5.toUpperCase().charAt(0) == 'Y'){
               System.out.println("");
             }
             actionSequence(currentLoc);
         }
         }else if (i3.toUpperCase().contains("WALLPAPER")){
            System.out.println("The wallpaper is a pale green color, with wild flowers scattered throughout. Are those hyacinths? Or maybe baby's breath? Julie inspects further, tracing the outline of the flowers. Suddenly, the tip of Julie's finger feels a small ridge. What could that possibly be?");
            System.out.println("Should Julie inspect further?");
            Scanner q6 = new Scanner(System.in);
            String i6 = q6.nextLine();
            if (i6.toUpperCase().charAt(0) == 'Y'){
              System.out.println("Whoa, it's a rusty key!");
              System.out.println("Julie puts it in her purse.");
              inventory.add(rustyKey);
              System.out.println("Current inventory: " + inventory.toString());
            }else{
              System.out.println("Whatever, it's not that interesting.");
              actionSequence(currentLoc);
            }
       }else if (i3.toUpperCase().contains("PIANO")){
           System.out.println("It's one of those grand pianos Julie's seen on TV, where skilled musicians play Chopin or Mozart. The appearance of this piano is far from the shiny, glossy ones she's seen. The keys of the piano are caked in mud and dirt. Ew, that's totally gross. Julie notices that there's a single golden key, where a black key would normally be. The skeleton skull looks so detailed, but there's no way it could be real. Julie glances at the insides of the piano, and sees that the strings are rusted.");
           System.out.println("What should Julie do?");
           /**
            three choices:
            choice 1: golden key
            choice 2: skeleton
            choice 3: inside of piano
            */
           Scanner q7 = new Scanner(System.in);
           String i7 = q7.nextLine();
           if (i7.toUpperCase().contains("KEY") || i7.toUpperCase().contains("GOLDEN")){
             System.out.println("Julie gently touches the golden key. Hm, it has a bit of give to it. Should Julie try to loosen it more?");
             Scanner q8 = new Scanner(System.in);
             String i8 = q8.nextLine();
             if (i8.toUpperCase().charAt(0) == 'Y'){
               System.out.println("Julie starts to move the key back and forth to try to get it loose. It just won't budge! Julie puts a little more force into it, using both hands now.");
               System.out.println("Julie puts it in her purse");
               inventory.add(goldKey);
               System.out.println("Julie's inventory: " + inventory);
               System.out.println("Suddenly, the ground begins to shake. It's an earthquake! Julie ducks to the floor. After an hour the world finally calms down. ");
               timeLeft -= 60;
               System.out.println("Time left " + (timeLeft/60.0) + " hours");
             }
           }else if(i7.toUpperCase().contains("SKELETON")){
             System.out.println("The surface of the skleton is ruddy and muddy. Julie notices a piece of paper sticking out of its mouth.");
             System.out.println("Should Julie try to get the piece of paper?");
             Scanner q8 = new Scanner(System.in);
             String i8 = q8.nextLine();
             if (i8.toUpperCase().charAt(0) == 'Y'){
               System.out.println("Julie slowly reaches her hand into the skeleton's mouth...");
               Scanner q9 = new Scanner(System.in);
               String i9 = q9.nextLine();
               System.out.println("And suddenly, the skeleton's jaw closes on Julie's hand! It has a vice grip, and Julie feels her hand start to be crushed from the force.");
               boolean stuck = true;
               while (stuck == true){
                 //System.out.println("1. stuck is " + stuck);
                 /** possible choices:
                  choice 1: hit the skeleton
                  choice 2: if inventory contains screwdriver or knife stab skeleton
                */
                 System.out.println("What should Julie do?!");
                 Scanner q10 = new Scanner(System.in);
                 String i10 = q10.nextLine();
                 if (i10.toUpperCase().contains("HIT")){
                   System.out.println("Julie begins to hit the skeleton repeatedly, to no avail. Julie's bones begin to crack. The pain is immeasurable.");
                   System.out.println("After some time Julie begins to black out and she loses consciousness, dying with her hand crushed");
                   System.out.println("GAME OVER");
                   game = false;
                   stuck = false;
                   //System.out.println("2. stuck is " + stuck);
                  }
                 else if ((i10.toUpperCase().contains("STAB") && (inventory.contains(knife) && !inventory.contains(screwdriver)))) {
                  System.out.println("Stab skeleton");
                  stuck = false;
                   //System.out.println("3. stuck is " + stuck);
                 }else if (i10.toUpperCase().contains("STAB") && (!inventory.contains(knife) && inventory.contains(screwdriver))){
                  //screwdriver found in library, knife found in kitchen
                  System.out.println("Stab with screwdriver");
                  stuck = false;
                 }else if (i10.toUpperCase().contains("STAB") && !inventory.contains(knife) && !inventory.contains(screwdriver)){
                  System.out.println("Julie would, but she doesn't have anything to stab with.");
                 }else{
                   System.out.println("After some time Julie begins to black out and she loses consciousness, dying with her hand crushed");
                   System.out.println("GAME OVER");
                   game = false;
                   stuck = false;
                 }
               }
             }else if (i8.toUpperCase().charAt(0) == 'N'){
               System.out.println("No, there's nothing interesting there.");
             }
           }else if (i7.toUpperCase().contains("INSIDE") || i7.toUpperCase().contains("PIANO") || i7.toUpperCase().contains("STRINGS")){
             System.out.println("The strings are red with rust.");
           }else{
             System.out.println("That's not there.");
           }
       }
      }
       else if (currentLoc == library){
        /**
        things to interact with:
        bookcases
        locked cabinet
        lamp
        */
        if (i3.toUpperCase().contains("BOOK")){
          System.out.println("Julie approaches the bookcase and reaches for the pristine book. When Julie starts to pull down the book all of a sudden the bookshelf starts to open like a door! \n The bookcase/door opens to reveal a set of rickety wooden stairs.");
          System.out.println("Should Julie go up the stairs?");
          Scanner q13 = new Scanner(System.in);
          String i13 = q13.nextLine();
          if (i13.toUpperCase().charAt(0) == 'Y'){
            currentLoc = attic;
          }
        }else if (i3.toUpperCase().contains("CABINET")){
          System.out.println("Julie looks through the cabinet to find a dingy screwdriver.");
          inventory.add(screwdriver);
          System.out.println("Julie's inventory " + inventory);
        }else if (i3.toUpperCase().contains("LAMP")){
          System.out.println("The lamp is covered in pearls and ");
        }
    } 
    else if (currentLoc == kitchen){
        /**
        things to interact with:
        table
        stovetop
        fridge
        */
        if(i3.toUpperCase().equals("TABLE") || i3.toUpperCase().equals("DINING") || i3.toUpperCase().equals("PLATE")){
          System.out.println("table stuff");
        }else if (i3.toUpperCase().equals("STOVE") || i3.toUpperCase().equals("POT")){
          System.out.println("Julie can't bear to look at the pot with overflowing mold. She starts to gag from the smell. Next to the pot she notices a rusty knife that is sticking out of the countertop, as if someone tried to stab the counter. Huh that's weird.");
          System.out.println("Should Julie take the knife?");
          Scanner q12 = new Scanner(System.in);
          String i12 = q12.nextLine();
          if (i12.toUpperCase().charAt(0) == 'Y'){
            System.out.println("Julie puts both of her hands on the handle and pulls the knife from the surface of the countertop. She admires it for a second before realizing...the tip of the blade is covered in dark blood!");
            inventory.add(knife);
            System.out.println("Julie's inventory: " + inventory);
          }
        }else if (i3.toUpperCase().contains("FRIDGE")){
          System.out.println("fridge stuff");
        }  
    } else if (currentLoc == masterBedroom) {
        /**
        things to interact with:
        bed
        vanity
        closet  
        */
        if (i3.toUpperCase().contains("BED")){
          System.out.println("bed stuff");
        } else if (i3.toUpperCase().contains("VANITY")){
          System.out.println("vanity stuff");
        } else if (i3.toUpperCase().contains("CLOSET")){
          System.out.println("closet stuff");
        }
      } else if (currentLoc == attic){
          System.out.println("Julie is in the attic");
      }  
    }   
  }
}
      
   

 

