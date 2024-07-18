class Solution {
    public int maxPoints(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        int n = points.length;
        if(n <= 2) {
            return n;
        }
        int maxPoints = 0;

        for(int i = 0; i < n; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int samePoints = 0;
            int localMax = 0;

            for(int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if(dx == 0 && dy == 0) {
                    samePoints++;
                    continue;               
                }
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                String slope = dy + "/" + dx;
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeCount.get(slope));
            }
            maxPoints = Math.max(maxPoints, localMax + samePoints + 1);
        }
        return maxPoints;
    }
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}


//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, 
//return the maximum number of points that lie on the same straight line.