package primitives;
import geometries.Intersectable.GeoPoint;

import static primitives.Util.isZero;

import java.util.List;

/**
 * Ray class will serve as the ray of a general shape to build the shape later
 * on.
 * 
 * @author Mendy Welner 209272228. mendiwell@gmail.com Mendy Segal.
 *         211769955.Mendysegal490@gmail.com
 * 
 */
public class Ray {

	private final Point p0;
	private final Vector dir;

	/**
	 * Constructor to create a new Ray object with the specified starting point and
	 * direction. The direction vector is normalized to have a length of 1.
	 * 
	 * @param p   the starting point of the Ray
	 * @param vec the direction vector of the Ray
	 */
	public Ray(Point p, Vector vec) {
		p0 = p;
		dir = vec.normalize();
	}

	/**
	 * This function returns the starting point of the the ray which is p0
	 * 
	 * @return point
	 */
	public Point getP0() {
		return p0;
	}

	/**
	 * This function returns a point p0 on the central base and we're adding to it
	 * the direction vector scaled by t. if t equals to 0 then we just return p0.
	 * 
	 * @param t is a scalar
	 * @return point
	 */
	public Point getPoint(double t) {
		return isZero(t) ? p0 : p0.add(dir.scale(t));
	}

	/**
	 * This function returns the direction vector normalized
	 * 
	 * @return direction vector of the axis ray
	 */
	public Vector getDir() {
		return dir;
	}
	
	/**
	 * This function returns the closest point from list of points, to the point of the ray
	 * 
	 * @param points is a list of points
	 * @return the closest point
	 */
	public Point findClosestPoint(List<Point> points) {
		return points == null? null
				: findClosestGeoPoint(points.stream()
						.map(p -> new GeoPoint(null, p)).toList()
						).point;
	}
	
	public GeoPoint findClosestGeoPoint(List<GeoPoint> points) {
		if (points.size() == 0)
			return null;
		GeoPoint closestGeoPoint = points.get(0);
		double minDistance = points.get(0).point.distance(p0);
		for (int i = 1; i < points.size(); i++) {
			if (points.get(i).point.distance(p0) < minDistance) {
				closestGeoPoint = points.get(i);
				minDistance = points.get(i).point.distance(p0);
			}
		}
		return closestGeoPoint;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Ray r)
			return this.p0.equals(r.p0) && this.dir.equals(r.dir);
		return false;
	}

	@Override
	public String toString() {
		return p0 + "->" + dir;
	}

}
