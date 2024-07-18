import java.util.*;

public class MinimumGeneticMutation {

    public static int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startGene);
        visited.add(startGene);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endGene)) return level;

                char[] currentArray = current.toCharArray();
                for (int j = 0; j < currentArray.length; j++) {
                    char originalChar = currentArray[j];
                    for (char gene : genes) {
                        if (currentArray[j] == gene) continue;
                        currentArray[j] = gene;
                        String newGene = new String(currentArray);
                        if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                            queue.add(newGene);
                            visited.add(newGene);
                        }
                    }
                    currentArray[j] = originalChar;
                }
            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        String[] bank = {"AACCGGTA"};

        System.out.println(minMutation(startGene, endGene, bank)); // Output: 1
    }
}


//A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

//Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined 
//as one single character changed in the gene string.

//For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
//There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

//Given the two gene strings startGene and endGene and the gene bank bank, 
//return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.