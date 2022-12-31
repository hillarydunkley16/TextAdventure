public class Item{
  //item name
  private String name;
  //item description
  private String desc;
  //item location
  private Place loc; 

  public Item(String name, Place loc, String desc){
    this.name = name;
    this.loc = loc;
    this.desc = desc;
    
  }
  public String toString(){
    return name;
}
}  