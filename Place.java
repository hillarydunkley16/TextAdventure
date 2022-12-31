import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Place{
  public String name; 
  public String desc; 
  public Boolean isTerminal;

  public Place(String name, String desc, Boolean isTerminal){
    this.name = name;
    this.desc = desc;
    this.isTerminal = isTerminal;
  }
  public String toString(){
    return "Place["+name+"]";
  }
  

  
   //Place parlor = new Place("The parlor", "Julie enters the parlor. A couch and two armchairs surround a coffee table, an inch thick layer of dust covering the surface. The pale green wallpaper is peeling from the walls and a piano sits in the corner with several keys missing. A skeleton sits on the piano stool, both of its hands on the keyboard as if it's about to play a sonata. That skeleton's got to be fake, right? thinks Julie.");
}
//public string name;
//public string desc;
//public bool isTerminal
//getters and setters for room
//items
//toString method



// // How will different places be identified?
  
// // How will the game know how to describe a place to the player?
// // How will the game know whether a place is a terminal location?
// // How will the game know what directions are valid moves (i.e., will lead them to a new location)?
// // How will the player know what directions are valid moves?
// // How can you quickly and accurately verify that your game environment includes all the locations you intended?
