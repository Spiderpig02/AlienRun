package templeRun.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

import templeRun.Score;
import templeRun.TempleRunApp;

public class SaveAndLoad implements ISaveAndLoad {

    public void saveStats(HashMap<String, Score> scoreboard) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("scoreData.txt"))) {
            Iterator<String> set = scoreboard.keySet().iterator();
            while (set.hasNext()) {
                String name = set.next();
                bw.write(name + ":" + String.valueOf(scoreboard.get(name)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public HashMap<String, Score> readSavedScoreboard() throws IOException {
        HashMap<String, Score> tmpMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(TempleRunApp.class.getResourceAsStream("scoreData.txt")))) {
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

}
