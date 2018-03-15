import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        int budgetOfU1Rocket = 0;
        int budgetOfU2Rocket = 0;

        Simulation simulation = new Simulation();

        File phase1 = simulation.createFile("phase-one.txt");
        File phase2 = simulation.createFile("phase-two.txt");

        ArrayList<Item> listPhase1 = simulation.loadItems(phase1);
        ArrayList<Item> listPhase2 = simulation.loadItems(phase2);

        ArrayList<U1> listRocketPhase1 = simulation.loadU1(listPhase1);
        ArrayList<U1> listRocketPhase2 = simulation.loadU1(listPhase2);

        ArrayList<Item> listPhase11 = simulation.loadItems(phase1);
        ArrayList<Item> listPhase22 = simulation.loadItems(phase2);

        ArrayList<U2> listRocketU2Phase1 = simulation.loadU2(listPhase11);
        ArrayList<U2> listRocketU2Phase2 = simulation.loadU2(listPhase22);



        budgetOfU1Rocket = simulation.runSimulationU1(listRocketPhase1) + simulation.runSimulationU1(listRocketPhase2);
        budgetOfU2Rocket = simulation.runSimulationU2(listRocketU2Phase1) + simulation.runSimulationU2(listRocketU2Phase2);




        System.out.println("Koszt wyprawy za pomocą rakiety U1: " + "$" + budgetOfU1Rocket + " Milionów");
        System.out.println("Koszt wyprawy za pomocą rakiety U2: " + "$" + budgetOfU2Rocket + " Milionów");


    }
}
