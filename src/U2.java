public class U2 extends Rocket {
    private int rocketCost = 120;

    public U2(String name, int weight, int maxWeight) {
        super(name, weight, maxWeight);
    }

    public int getRocketCost() {
        return rocketCost;
    }

    @Override
    public boolean launch() {
        //tworzę losową liczbę od 0 do 100.
        int random = (int) (Math.random() * 100);

        //szansa na wybuch przy określonej wadze załadunku.
        int chance = (int) ((0.04 * (this.getCurrentWeight() / this.getMaxWeight())) * 100);

        //warunek obliczający czy rakieta wybuchnie czy nie.
        if (chance <= random) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean land() {
        //tworzę losową liczbę od 0 do 100.
        int random = (int) (Math.random() * 100);

        //szansa na wybuch przy określonej wadze załadunku.
        int chance = (int) ((0.08 * (this.getCurrentWeight() / this.getMaxWeight())) * 100);

        //warunek obliczający czy rakieta wybuchnie czy nie.
        if (chance <= random) {
            return true;
        } else {
            return false;
        }
    }
}
