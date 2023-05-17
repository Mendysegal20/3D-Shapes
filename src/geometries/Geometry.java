package geometries;

import primitives.Vector;
import primitives.Point;

/**
 * The interface Geometry will serve as the representation of a general shape
 * 
 * @author Mendy Welner 209272228. mendiwell@gmail.com Mendy Segal.
 *         211769955.Mendysegal490@gmail.com
 */

public interface Geometry extends Intersectable {

	/**
	 * This function returns the normal vector at the given point on the shell of
	 * general geometry
	 * 
	 * @param p the point on the surface of the geometry
	 * @return the normal of the shape at that point
	 */
	public Vector getNormal(Point p);

}
