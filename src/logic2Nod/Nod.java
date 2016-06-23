package logic2Nod;

public class Nod {
	
	private enum CalcType {
		RECURSION, LOOP
	}
	
	private CalcType calcType;
	
	public Nod(CalcType calcType) {
		this.calcType = calcType;
	}
	
	public int nod2Loop (int x, int y) {
		if (x == 0 || y == 0) {
			throw new IllegalArgumentException("nod does not exist if one of argument = 0");
		}
		while (x != y) {		
			int temp = x;
			x = Math.min(x, y);
			y = Math.abs(temp-y);
		}
		return x;
	}
	
	public int nod2Recur (int x, int y) {
		if (x == 0 || y == 0) {
			throw new IllegalArgumentException("nod does not exist if one of argument = 0");
		}
		
		if (x == y) {
			return x;
		} else {
			return nod2Recur (Math.min(x, y), Math.abs(x-y));
		}
	}
	
	
	public int nod4 (int a, int b, int c, int d) {
		if (calcType == CalcType.RECURSION) {
			return nod2Recur (nod2Recur(a,b), nod2Recur(c, d));
		} else {
			return nod2Loop (nod2Loop(a,b), nod2Loop(c, d));
		}

	}
	
	

	public static void main(String[] args) {
		
		Nod nod = new Nod(CalcType.RECURSION);
		String calcType = nod.calcType.name();
		
		System.out.println(calcType + " (7, 7) = " + nod.nod2Recur(7, 7));
		System.out.println(calcType + " (7, 14) = " + nod.nod2Recur(7, 14));
		System.out.println(calcType + " (24, 20) = " + nod.nod2Recur(24, 20));
		System.out.println(calcType + " (17, 5) = " + nod.nod2Recur(17, 5));
		long start = System.currentTimeMillis();
		System.out.println(calcType + " (210, 140, 420, 280) = " + nod.nod4(210, 140, 420, 280));
		System.out.println("time = " + (System.currentTimeMillis()-start));
		System.out.println(calcType + " (21, 7, 17, 5) = " + nod.nod4(21, 7, 17, 5));
		
		
		
		nod = new Nod(CalcType.LOOP);
		calcType = nod.calcType.name();
		
		System.out.println(calcType + " (7, 7) = " + nod.nod2Loop(7, 7));
		System.out.println(calcType + " (7, 14) = " + nod.nod2Loop(7, 14));
		System.out.println(calcType + " (24, 20) = " + nod.nod2Loop(24, 20));
		System.out.println(calcType + " (17, 5) = " + nod.nod2Loop(17, 5));
		start = System.currentTimeMillis();
		System.out.println(calcType + " (210, 140, 420, 280) = " + nod.nod4(210, 140, 420, 280));
		System.out.println("time = " + (System.currentTimeMillis()-start));
		System.out.println(calcType + " (21, 7, 17, 5) = " + nod.nod4(21, 7, 17, 5));
		
		
		//System.out.println(calcType + " " + nodRec.nod2Recur(0, 7));
		

	}

}
