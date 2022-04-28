package templeRun.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

import templeRun.TempleRunApp;
import templeRun.entity.Score;
import templeRun.main.Settings;

public class SaveAndLoad implements ISaveAndLoad {

    public void saveStats(HashMap<String, Score> scoreboard) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("scoreData.txt"))) {
            Iterator<String> set = scoreboard.keySet().iterator();
            while (set.hasNext()) {
                String name = set.next();
                bw.write(name + ":" + String.valueOf(scoreboard.get(name).getPoints()) + "\n");
            }

        } catch (NullPointerException e) {
            System.out.println("The hash map is null");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public HashMap<String, Score> readSavedScoreboard() {
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

    public int[][] loadMap() {
        int[][] mapTileNum = new int[Settings.maxWorldCol][Settings.maxWorldRow];
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(TempleRunApp.class.getResourceAsStream("map/worldMap17x100.txt")))) {
            int col = 0;
            int row = 0;

            while (col < Settings.maxWorldCol && row < Settings.maxWorldRow) {
                String line = br.readLine();
                while (col < Settings.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == Settings.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapTileNum;
    }
}
