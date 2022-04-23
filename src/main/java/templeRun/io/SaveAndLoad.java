package templeRun.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import templeRun.Score;

public class SaveAndLoad implements ISaveAndLoad {

    public void saveStats(HashMap<String, Score> scoreboard) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("scoreData.txt"))) {
            Iterator<String> set = scoreboard.keySet().iterator();
            while (set.hasNext()) {
                String name = set.next();
                bw.write(name + ":" + String.valueOf(scoreboard.get(name).getPoints()) + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public HashMap<String, Score> readSavedScoreboard() throws IOException {
        HashMap<String, Score> tmpMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader("scoreData.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String username;
                Long points;
                String data[] = line.split(":");
                username = data[0];
                points = Long.valueOf(data[1]);
                Score tempScore = new Score(username, points);
                tmpMap.put(username, tempScore);
            }

        } catch (IOException e) {
            System.out.println("File not created");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tmpMap;
    }

    public static void main(String[] args) {
        SaveAndLoad saveAndLoad = new SaveAndLoad();
        HashMap<String, Score> tmp = new HashMap<>();
        tmp.put("Daniel", new Score("Daniel", 420L));
        tmp.put("Jens", new Score("Jens", 69L));
        tmp.put("Henrik", new Score("Henrik", 42069L));
        try {
            saveAndLoad.saveStats(tmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
