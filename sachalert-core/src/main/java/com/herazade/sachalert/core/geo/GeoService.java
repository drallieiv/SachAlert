package com.herazade.sachalert.core.geo;

import java.util.ArrayList;
import java.util.List;

import org.geotools.geometry.jts.JTS;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.GeodeticCalculator;
import org.geotools.referencing.crs.DefaultGeocentricCRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.geotools.referencing.crs.DefaultProjectedCRS;
import org.opengis.geometry.primitive.Bearing;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.springframework.beans.factory.annotation.Autowired;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.operation.distance.DistanceOp;

public class GeoService {

	private static int LAT = 0;
	private static int LON = 1;

	private GeometryFactory geometryFactory;

	@Autowired
	private List<POI> allPOI;

	public GeoService() {
		geometryFactory = JTSFactoryFinder.getGeometryFactory();
	}

	public Zone createZone(double[] points) {
		if (points.length % 2 != 0) {
			throw new IllegalArgumentException("Number of points must be even");
		}

		int nbPointsXY = (points.length + 1) / 2;

		double[][] dPoints = new double[nbPointsXY][2];
		for (int i = 0; i < points.length; i++) {
			dPoints[i / 2][i % 2] = points[i];
		}

		// Close the loop
		dPoints[nbPointsXY - 1][0] = points[0];
		dPoints[nbPointsXY - 1][1] = points[1];

		return createZone(dPoints);
	}

	public Zone createZone(double[][] points) {
		Zone zone = new Zone();
		zone.setArea(getPolygon(points));
		zone.setPoi(findPoiInZone(zone));
		return zone;
	}

	private Polygon getPolygon(double[][] points) {
		ArrayList<Coordinate> coords = new ArrayList<Coordinate>();

		for (double[] point : points) {
			coords.add(new Coordinate(point[LAT], point[LON]));
		}

		LinearRing ring = geometryFactory.createLinearRing(coords.toArray(new Coordinate[coords.size()]));
		LinearRing holes[] = null; // use LinearRing[] to represent holes
		Polygon polygon = geometryFactory.createPolygon(ring, holes);
		return polygon;
	}

	public POI createPOI(Double latitude, Double longitude) {
		POI poi = new POI();
		poi.setPoint(createPoint(latitude, longitude));
		return poi;
	}

	public Point createPoint(Double latitude, Double longitude) {
		Coordinate coordinate = new Coordinate(latitude, longitude);
		return geometryFactory.createPoint(coordinate);
	}

	/**
	 * Select the POI inside given zone
	 * 
	 * @param zone
	 * @return
	 */
	public List<POI> findPoiInZone(Zone zone) {

		Polygon area = zone.getArea();
		List<POI> includedPoi = new ArrayList<>();

		for (POI poi : allPOI) {
			if (area.contains(poi.getPoint())) {
				includedPoi.add(poi);
			}
		}

		return includedPoi;
	}

	public POI closetPoi(Point source, List<POI> pois) {

		POI closetPoi = null;
		List<Point> match = new ArrayList<>();

		for (POI poi : pois) {
			match.add(poi.getPoint());
		}

		Coordinate coord = closetPoint(source, match);

		for (POI poi : pois) {
			if (poi.getPoint().getCoordinate().equals(coord)) {
				closetPoi = poi;
				break;
			}
		}

		return closetPoi;

	}

	public Coordinate closetPoint(Point source, List<Point> match) {
		Point[] matchArray = match.toArray(new Point[0]);
		MultiPoint mp = new MultiPoint(matchArray, geometryFactory);

		Coordinate[] nearest = DistanceOp.nearestPoints(source, mp);
		return nearest[1];
	}

	public Direction getDirection(Point source, Point dest) {
		Direction dir = new Direction();

		GeodeticCalculator calculator = new GeodeticCalculator(DefaultGeographicCRS.WGS84);
		calculator.setStartingGeographicPoint(source.getX(), source.getY());
		calculator.setDestinationGeographicPoint(dest.getX(), dest.getY());

		double distance = calculator.getOrthodromicDistance();
		double azimuth = calculator.getAzimuth();

		dir.setDistance((long) distance);
			
		dir.setDirection(Direction.getCardinalByAzimuth(azimuth));
		
		return dir;
	}

	public List<POI> getAllPOI() {
		return allPOI;
	}

	public void setAllPOI(List<POI> allPOI) {
		this.allPOI = allPOI;
	}

}
