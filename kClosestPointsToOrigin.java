// You are given an 2-D array points where points[i] = [xi, yi] represents the coordinates of a point on an X-Y axis plane. You are also given an integer k.
// Return the k closest points to the origin (0, 0).
// The distance between two points is defined as the Euclidean distance (sqrt((x1 - x2)^2 + (y1 - y2)^2)).
// You may return the answer in any order.

class Solution {

    PriorityQueue<Point> minPoints;

    public int[][] kClosest(int[][] points, int k) {

        int[][] kClosestPoints = new int[k][2];

        minPoints = new PriorityQueue<>( (p1, p2) -> Integer.compare( p1.x * p1.x + p1.y * p1.y, 
                                                                      p2.x * p2.x + p2.y * p2.y  ) );

        for( int i = 0 ; i < points.length ; i++ ){
            
            Point p = new Point( points[i][0], points[i][1] );

            minPoints.offer(p);

        }

        int i = 0;

        while( i < k ){

            Point p = minPoints.poll();

            System.out.println(p);

            kClosestPoints[i][0] = p.x;
            kClosestPoints[i][1] = p.y;

            i++;

        }

        return kClosestPoints;
        
    }

}

class Point{

    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

}
