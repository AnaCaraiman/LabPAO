package task6;

import java.lang.Math;

class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;

    public Patrulater() {
        this(0, 0, 0, 0);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }

    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }

    public int perimetru() {
        return latura1 + latura2 + latura3 + latura4;
    }

    public double aria() {
        return -1;
    }
}

class Paralelogram extends Patrulater {
    public Paralelogram(int latura1, int latura2, double unghi1) {
        super(latura1, latura2, latura1, latura2, unghi1, 180 - unghi1, unghi1, 180 - unghi1);
    }

    @Override
    public double aria() {
        return latura1 * latura2 *Math.sin(Math.toRadians(unghi1));
    }
}

class Romb extends Paralelogram {
    public double diag1, diag2;

    public Romb(int latura1, int latura2, double unghi1, double diag1, double diag2) {
        super(latura1, latura2, unghi1);
        this.diag1 = diag1;
        this.diag2 = diag2;
    }

    @Override
    public double aria() {
        return (diag1 * diag2) / 2;
    }
}

class Dreptunghi extends Paralelogram {
    public Dreptunghi(int lungime, int latime) {
        super(lungime, latime, 90);
    }

    @Override
    public double aria() {
        return latura1 * latura2;
    }
}

class Patrat extends Dreptunghi {
    public Patrat(int latura) {
        super(latura, latura);
    }

    @Override
    public double aria() {
        return latura1 * latura1;
    }
}

class Executare {
    public static void main(String[] args) {
        Paralelogram paralelogram = new Paralelogram(2, 3, 60);
        System.out.println("Aria paralelogramului: " + paralelogram.aria());

        Romb romb = new Romb(5, 8, 30, 6, 9);
        System.out.println("Aria rombului: " + romb.aria());

        Dreptunghi dreptunghi = new Dreptunghi(5, 8);
        System.out.println("Aria dreptunghiului: " + dreptunghi.aria());

        Patrat patrat = new Patrat(5);
        System.out.println("Aria patratului: " + patrat.aria());
    }
}