
public class NBody{

	/**get the radius of the univeerse
	 *
 	 */
	public static double readRadius(String filename) {
		In in = new In(filename);
		int number = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	/**read the plants in the file
	 *
	 */
	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		int number = in.readInt();
		double radius = in.readDouble();
		Planet[] Ps = new Planet[number];
		for (int i = 0; i < number; i++) {
			Ps[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
				in.readDouble(), in.readDouble(), in.readString()); 
		}
		return Ps;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]) ;
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] Ps = readPlanets(filename);

		StdDraw.enableDoubleBuffering();

		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");

		for (Planet p : Ps) {
			p.draw();
		}

		StdDraw.show();

		/**Creating an Animation*/
		In in = new In(filename);
		int num = in.readInt();
		for (double t = 0; t <= T; t += dt) {
			double[] xForce = new double[num];
			double[] yForce = new double[num];
			int i = 0;
			for (Planet p : Ps) {
				xForce[i] = p.calcNetForceExertedByX(Ps);
				yForce[i] = p.calcNetForceExertedByY(Ps);
				i ++;
			}
			i = 0;
			for (Planet p : Ps) {
				p.update(dt, xForce[i], yForce[i]);
				i ++;
			}

			StdDraw.picture(0, 0, "images/starfield.jpg");

			for (Planet p : Ps) {
				p.draw();
			}

			StdDraw.show();
			StdDraw.pause(5);
		}

		StdOut.printf("%d\n", Ps.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < Ps.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  Ps[i].xxPos, Ps[i].yyPos, Ps[i].xxVel,
                  Ps[i].yyVel, Ps[i].mass, Ps[i].imgFileName);   
}
	}
}