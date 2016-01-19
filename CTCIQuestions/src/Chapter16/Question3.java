package Chapter16;

import Chapter8.Point;

public class Question3{
	
	Question3(){
	}

	
	public Point findIntersection(Point start1, Point end1, Point start2, Point end2){
		if(start1.getX() > end2.getX() || start2.getX() > end1.getX() ||
		   start1.getY() > end2.getY() || start2.getY() > end1.getY() ||
		   start1.getX() == end1.getX() || start2.getX() == end2.getX()){
			return null;
		}
		
		/**
		 * Compute slopes of each line
		 * m = (endY - startY) / (endX - startX)
		 */
		double m1 = ((double) (end1.getY() - start1.getY()) / (double) (end1.getX() - start1.getX()));
		double m2 = ((double) (end2.getY() - start2.getY()) / (double) (end2.getX() - start2.getX()));

		
		/**
		 * If slopes are equal return
		 */
		
		
		/**
		 * y - startY = m(x - startX)
		 * y - startY = mx + -(m * startX)
		 * y = mx + -(m * startX) + startY
		 * y = mx + b
		 * b = -(m * startX) + startY
		 */
		double b1 = m1 * start1.getX() * -1 + start1.getY();
		double b2 = m2 * start2.getX() * -1 + start2.getY();
		
		if(m1 == m2){
			if(b1 != b2){
				return null;
			}
			double maxStartX = Math.max(start1.getX(), start2.getX());
			double maxStartY = Math.max(start1.getY(), start2.getY());
			double minEndX = Math.min(end1.getX(), end2.getX());
			double minEndY = Math.min(end1.getY(), end2.getY());

			return new Point((maxStartX + minEndX) / 2, (maxStartY + minEndY) / 2);
		}
		
		/**
		 * m1x + b1 = m2x + b2
		 * m1x - m2x = b2 - b1
		 * x(m1 - m2) = b2 - b1
		 * x = (b2 - b1)/(m1 - m2)
		 */
		double x = (b2 - b1)/(m1 - m2);
		double y = m1 * x + b1;
		
		double minX = Math.min(start1.getX(), Math.min(start2.getX(), Math.min(end1.getX(), end2.getX())));
		double minY = Math.min(start1.getY(), Math.min(start2.getY(), Math.min(end1.getY(), end2.getY())));
		double maxX = Math.max(start1.getX(), Math.max(start2.getX(), Math.max(end1.getX(), end2.getX())));
		double maxY = Math.max(start1.getY(), Math.max(start2.getY(), Math.max(end1.getY(), end2.getY())));
		
		if(x > minX && x < maxX && 
		   y > minY && y < maxY){
			return new Point(x,y);
		}
		
		return null;
	}
}
