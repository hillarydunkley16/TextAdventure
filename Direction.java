public enum Direction{
  NORTH ("North"),
  SOUTH ("South"),
  EAST ("East"),
  WEST ("West"),
  UP ("Up"),
  DOWN ("Down"),
  SOUTHEAST("Southeast");
  // NORTH , SOUTH, EAST, WEST, UP, DOWN;

  public final String text;

  private Direction(String text){
     this.text = text; 
  }

  
  public String toString(){
    return text; 
  }
// //match string to direction
  public static Direction matchDirection(String s){
    for (Direction d: Direction.values()){
      if (d.text.equals(Direction.values())){
        return d;
      }
    }
    return null;
  }
 }
//hashmap<String> place 