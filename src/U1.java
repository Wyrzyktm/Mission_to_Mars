public class U1 extends Rocket {
    private int rocketCost = 100;


    //konstruktor Rakiety typu U1
    public U1(String name, int weight, int maxWeight) {
        super(name, weight, maxWeight);
    }

    public int getRocketCost() {
        return rocketCost;
    }

    //Metoda obliczająca prawdopodobieństwo wybuchu przy starcie.
    @Override
    public boolean launch() {
        //tworzę losową liczbę od 0 do 100.
        int random = (int) (Math.random() * 100);

        //szansa na wybuch przy określonej wadze załadunku.
        int chance = (int) ((0.05 * (this.getCurrentWeight() / this.getMaxWeight())) * 100);


        //warunek obliczający czy rakieta wybuchnie czy nie.
        if (chance <= random) {
            return true;
        } else {
            return false;
        }
    }

    //Metoda obliczająca prawdopodobieństwo wybuchu przy lądowaniu.
    @Override
    public boolean land() {

        //tworzę losową liczbę od 0 do 100.
        int random = (int)(Math.random() * 100);

        //szansa na wybuch przy określonej wadze załadunku.
        int chance = (int)((0.01 * (this.getCurrentWeight() / this.getMaxWeight())) * 100);

        //warunek obliczający czy rakieta wybuchnie czy nie.
        if (chance <= random) {
            return true;
        } else {
            return false;
        }


    }
}
