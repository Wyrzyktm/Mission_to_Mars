public interface SpaceShip {

    //opisy metod znajdują się w klasach implementujących interfejs SpaceShip.

    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    void carry(Item item);



}
