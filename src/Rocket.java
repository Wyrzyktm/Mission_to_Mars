public class Rocket extends Item implements SpaceShip {
    //maksymalna waga jaką może udźwignąc rakieta.
    private int maxWeight;
    //aktualna waga rakiety po załadunku.
    private int currentWeight = this.getWeight();

//konstruktor rakiety.
    public Rocket(String name, int weight, int maxWeight) {
        super(name, weight);
        this.maxWeight = maxWeight;
    }

    //getter pobierający wartość aktualnej wagi rakiety.
    public int getCurrentWeight() {
        return currentWeight;
    }

    //getter pobierający maksymalną wagę rakiety.
    public int getMaxWeight() {
        return maxWeight;
    }

    //nadpisana metoda z interefejsu SpaceShip - dokładna implementacja znajduje się w klasach konkretnych modeli rakiet.
    @Override
    public boolean launch() {
        return true;
    }
    //nadpisana metoda z interefejsu SpaceShip - dokładna implementacja znajduje się w klasach konkretnych modeli rakiet.
    @Override
    public boolean land() {
        return true;
    }

    //implementacja metody z interfejsu SpaceShip sprawdzająca czy przedmiot jaki chcemy umieścić na statku
    // nie przelroczy możliwości udźwigu rakiety.
    @Override
    public boolean canCarry(Item item) {
        if(this.currentWeight + item.getWeight() <= this.maxWeight){
            return true;
        } else{
            return false;
        }

    }

    //implementacja metody z interfejsu SpaceShip ustawiająca aktualną wagę załadunku po dodaniu przedmiotu.
    @Override
    public void carry(Item item) {
        this.currentWeight += item.getWeight();

    }
}
