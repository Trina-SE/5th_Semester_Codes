package Adapter;
import Shape.*;


public class SquarePegAdapter extends RoundPeg {

	private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    public double getRadius() {
        double result;
        result = (Math.sqrt(2))*peg.getWidth();
        result = result/2;
      //  System.out.println(result);
        return result;
    }
}
