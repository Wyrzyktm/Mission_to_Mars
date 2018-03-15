import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    //Metoda do tworzenia pliku.
    public File createFile(String fileName) {
        File file = new File(fileName);
        return file;
    }

    //Metoda pobierająca listę rzeczy z pliku i ładująca ją do ArrayList<Item>.
    public ArrayList<Item> loadItems(File file) throws FileNotFoundException {

        //tworzenie Obiektu Scanner czytającego plik podany przez użytkownika.
        Scanner scanner = new Scanner(file);

        //ArrayList przechowująca listę zawierającą Obiekty Item.
        ArrayList<Item> listOfItem = new ArrayList<>();

        //Pętla działająca tak długo jak będą jakieś wiersze tekstu  w pliku,
        //odziela od siebie nazwę i wagę przedmiotu za pomocą separatora '=',
        //Tworzy obiekt typu Item i łąduje go do listOfItem.
        while (scanner.hasNextLine()) {
            String nameOfItem;
            int weight;
            String line = scanner.nextLine();
            String splittedLine[] = line.split("=");
            nameOfItem = splittedLine[0];
            weight = Integer.parseInt(splittedLine[1]);
            Item item = new Item(nameOfItem, weight);
            listOfItem.add(item);
        }

        return listOfItem;

    }

    //Metoda służąca załadowaniu i tworzeniu rakiet typu U1 do momentu aż wszystkie rzeczy z listy nie zostaną załadowanę
    //Rakiekta nie może być przeładowana.
    public ArrayList<U1> loadU1(ArrayList<Item> listOfItem) {
        //Tworzy listę zawierającą listę zapełnionych Rakiet typu U1
        ArrayList<U1> listOfRocketU1 = new ArrayList<>();

        int i = 0;

        //Pętla sprawdzająca czy w liście rzeczy są jeszcze rzeczy do załadowania.
        while (listOfItem.size() > 0) {
            //inkrementuje i aby każda rakieta miała swoją specyficzną nazwę.
            i++;
            U1 rocketU1 = new U1("U1shark" + i, 10000, 18000);

            //Pętla sprawdzająca czy załadowanie rakiety nie spowoduje przeciążenia maksymalnego załadunku.
            while (listOfItem.size() > 0 && rocketU1.canCarry(listOfItem.get(0))) {
                rocketU1.carry(listOfItem.get(0));
                listOfItem.remove(0);
            }
            listOfRocketU1.add(rocketU1);
        }

        return listOfRocketU1;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> listOfItem) {
        //Tworzy listę zawierającą listę zapełnionych Rakiet typu U1
        ArrayList<U2> listOfRocketU2 = new ArrayList<>();

        int i = 0;

        //Pętla sprawdzająca czy w liście rzeczy są jeszcze rzeczy do załadowania.
        while (listOfItem.size() > 0) {
            //inkrementuje i aby każda rakieta miała swoją specyficzną nazwę.
            i++;
            U2 rocketU2 = new U2("U2whale" + i, 18000, 29000);

            //Pętla sprawdzająca czy załadowanie rakiety nie spowoduje przeciążenia maksymalnego załadunku.
            while (listOfItem.size() > 0 && rocketU2.canCarry(listOfItem.get(0))) {
                rocketU2.carry(listOfItem.get(0));
                listOfItem.remove(0);
            }
            listOfRocketU2.add(rocketU2);
        }

        return listOfRocketU2;

    }


    public int runSimulationU1(ArrayList<U1> listOfRockets) {
        int budget = 0;
        for (int i = 0; i < listOfRockets.size(); i++) {
            boolean land = false;
            while (land == false) {
                if (listOfRockets.get(i).launch()) {
                    land = listOfRockets.get(i).land();
                    budget += listOfRockets.get(i).getRocketCost();
                } else {
                    budget += listOfRockets.get(i).getRocketCost();
                }

            }

        }

        return budget;
    }

    public int runSimulationU2(ArrayList<U2> listOfRockets) {
        int budget = 0;
        for (int i = 0; i < listOfRockets.size(); i++) {
            boolean land = false;
            while (land == false) {
                if (listOfRockets.get(i).launch()) {
                    land = listOfRockets.get(i).land();
                    budget += listOfRockets.get(i).getRocketCost();
                } else {
                    budget += listOfRockets.get(i).getRocketCost();
                }

            }

        }

        return budget;
    }

}

