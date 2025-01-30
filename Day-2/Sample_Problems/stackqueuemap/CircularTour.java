package stackqueuemap;

class CircularTourSolution {
    // method returns the starting position to start the tour if tour cannot be completed then it returns -1
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // we have 4 variable
        // startpoint denotes the starting position
        int startPoint = 0;

        // sum of cost of the tour
        int totalDist = 0;

        // required gas to complete the tour
        int totalFuel = 0;

        // if we cant complete a circle with current starting pos
        int deficit = 0;

        // looping through both arrays
        for (int i = 0; i < gas.length; i++) {

            deficit += gas[i] - cost[i];
            totalDist += cost[i];
            totalFuel += gas[i];

            // if condition to update the starting position
            if (deficit < 0) {
                startPoint = i + 1;
                deficit = 0;
            }
        }

        // if the tour cannot be completed
        if (totalDist > totalFuel) {
            return -1;
        }

        // tour completed with start point
        return startPoint;
    }
}

 class CircularTour {

    public static void main(String[] args) {
        // example petrol and distance
        int[] gas = {1,2,3,4,5};
        int[] distance = {3,4,5,1,2};

        // calculating if it is possible to do circular tour and return the start location
        int startingPos = CircularTourSolution.canCompleteCircuit(gas, distance);

        // printing the answer
        if (startingPos == -1) {
            System.out.println("There is no starting point to complete a circular tour");
        }else {
            System.out.println("The starting poinnt of the tour will be : "+ startingPos);
        }
    }
}