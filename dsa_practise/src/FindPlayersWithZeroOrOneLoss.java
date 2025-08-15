import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPlayersWithZeroOrOneLoss {
    public static void main(String[] args) {
        int[][] matches = {
                {1, 3}, {2, 3}, {3, 6}, {5, 6},
                {5, 7}, {4, 5}, {4, 8}, {4, 9},
                {10, 4}, {10, 9}
        };

        List<List<Integer>> result = findPlayersWithLosses(matches);

        System.out.println("Players with zero losses: " + result.get(0));
        System.out.println("Players with one loss: " + result.get(1));
    }

    private static List<List<Integer>> findPlayersWithLosses(int[][] matches) {
        Map<Integer, Integer> lossesMap = new HashMap<>();

        for (int[] match : matches) {
            lossesMap.put(match[0], lossesMap.getOrDefault(match[0], 0));
            lossesMap.put(match[1], lossesMap.getOrDefault(match[1], 0) + 1);
        }

        System.out.println(lossesMap);
        
        List<Integer> zeroLossPlayers = new ArrayList<>();
        List<Integer> oneLossPlayers = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : lossesMap.entrySet()) {
            int playerId = entry.getKey();
            int losses = entry.getValue();

            if (losses == 0) {
                zeroLossPlayers.add(playerId);
            } else if (losses == 1) {
                oneLossPlayers.add(playerId);
            }
        }

        // Sort the player lists
        zeroLossPlayers.sort(Integer::compareTo);
        oneLossPlayers.sort(Integer::compareTo);

        return Arrays.asList(zeroLossPlayers, oneLossPlayers);
    }
}
