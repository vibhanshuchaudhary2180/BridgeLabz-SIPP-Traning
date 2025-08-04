public class CircularTour {

    static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int total_tank = 0;
        int curr_tank = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int gain = pumps[i].petrol - pumps[i].distance;
            total_tank += gain;
            curr_tank += gain;

            // If we can't reach the next pump from current start
            if (curr_tank < 0) {
                // Choose next pump as start, reset curr_tank
                start = i + 1;
                curr_tank = 0;
            }
        }

        // If total petrol is less than total distance, no solution
        return total_tank >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };

        int start = findStartingPoint(pumps);
        System.out.println("Starting pump index: " + start);
        // Output: 1
    }
}
