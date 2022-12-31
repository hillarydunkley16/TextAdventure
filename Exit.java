public class Exit{
  //descriptor for exit
  private String name;
  //direction of exit
  private Direction dir; 
  //item required to use for exit
  //private Item required; 
  //description when exit is used
  private String desc;
  
  //to string method
  // public String toString(String name, Direction dir, String desc){
  //   String Exit = System.out.prinltn(name + dir + desc);
  // }
  public Exit(String name, Direction dir, String desc){
    this.name = name;
    this.dir = dir;
    this.desc = desc;
    
  }
  public String toString(){
    return name;
}
  
}