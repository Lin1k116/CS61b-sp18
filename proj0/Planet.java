
public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	
	/**first constructor
	 * 
	 * @param xP
	 * @param yP
	 * @param xV
	 * @param yV
	 * @param m
	 * @param img
	 */
	public Planet(double xP, double yP, double xV,
            double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	
	/**initialize an identical Body object
	 * 
	 * @param p
	 */
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	/**calculate the distance between two planet
	 *
	 */
	public double calcDistance(Planet p) {
		double x;
		x = (this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) +
			(this.yyPos - p.yyPos) * (this.yyPos - p.yyPos);
		return Math.sqrt(x);
	}

	/**calculate the force exerted on this by planet p
	 *
	 */
	public double calcForceExertedBy(Planet p) {
		double f;
		f = 6.67e-11 * this.mass * p.mass /
			(this.calcDistance(p) * this.calcDistance(p));
		return f;
	}
	/**calculate force in the x dirction exerted on this 
	 *
	 */
	public double calcForceExertedByX(Planet p) {
		double f;
		f = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) /
			this.calcDistance(p);
		return f;
	}

	/**calculate force in the y dirction exerted on this 
	 *
	 */
	public double calcForceExertedByY(Planet p) {
		double f;
		f = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) /
			this.calcDistance(p);
			return f;
	}

	/**calculate the net x force exerted on this by all other planet
	 *
	 */
	public double calcNetForceExertedByX(Planet[] Ps) {
		double netfX = 0;
		for (Planet p : Ps) {
			if(!this.equals(p)) {
				netfX += this.calcForceExertedByX(p);
			}
		}
		return netfX;
	}

	/**calculate the net x force exerted on this by all other planet
	 *
	 */
	public double calcNetForceExertedByY(Planet[] Ps) {
		double netfY = 0;
		for (Planet p : Ps) {
			if(!this.equals(p)) {
				netfY += this.calcForceExertedByY(p);
			}
		}
		return netfY;
	}

	/**update the position and velocity of this planet
	 *
	 */
	public void update(double dt, double fX, double fY) {
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		this.xxVel += dt * aX;
		this.yyVel += dt * aY;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;
	}

	/**draw the planet
	 *
	 */
	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
	}
}
