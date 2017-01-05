import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScoreReader {
    public static String fileName = "Scores.txt";
    public static int highScoreContainer;
    public static String highScoreNameContainer;

    public void ScoreReader() { // http://www.avajava.com/tutorials/lessons/how-do-i-read-a-string-from-a-file-line-by-line.html
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) { // goes through all the lines
            String[] score = line.split(":");
            lineNumber++;
            highScoreNameContainer = score[0];
            highScoreContainer = Integer.parseInt(score[1]);

    //                int comparisonPurposes = Integer.parseInt(score[1]);
    //                if (newScore > comparisonPurposes && comparisonPurposes > oldScore[lineNumber +  1]) {
    //                    scoreSwitcher();
    //
    //                }
    //                oldScore[newLine] = newScore;
    //                Arrays.sort(oldScore);
    //                System.out.println(score[0 ] + " killed " + score[1] + " Smiths " + lineNumber);

            }

            } catch (IOException e) {
            e.printStackTrace();
            }
    }

    public int returnOldHighScore() {
        ScoreReader();
        return highScoreContainer;
    }
}