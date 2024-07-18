public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startingStation = 0;

        // Calculate total gas and total cost
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // If total gas is less than total cost, it's impossible to complete the circuit
        if (totalGas < totalCost) {
            return -1;
        }

        // Determine the starting station
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];

            // If current gas is negative, reset the starting station and current gas
            if (currentGas < 0) {
                startingStation = i + 1;
                currentGas = 0;
            }
        }

        return startingStation;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println(result);  // Output should be 3
    }
}


//There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

//You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. 
//You begin the journey with an empty tank at one of the gas stations.

//Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in 
//the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique