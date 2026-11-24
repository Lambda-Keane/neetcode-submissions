class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 1;
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        float time;
        float prevTime = (float) (target - cars[0][0]) / cars[0][1];
        for (int i = 1; i < position.length; i++) {
            time = (float) (target - cars[i][0]) / cars[i][1];
            if (time > prevTime) {
                res++;
                prevTime = time;
            }
        }
        return res;
    }
}
