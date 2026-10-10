package class_problems;

import java.util.Scanner;

public class question1 {

    // Base abstract class representing a community garden plot
    public static abstract class Plot {
        protected String owner;

        public Plot(String owner) {
            this.owner = owner;
        }

        public abstract double calculateArea();
    }

    public static class CirclePlot extends Plot {
        private double radius;

        public CirclePlot(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    public static class RectanglePlot extends Plot {
        private double length;
        private double width;

        public RectanglePlot(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        @Override
        public double calculateArea() {
            return length * width;
        }
    }

    public static class TrianglePlot extends Plot {
        private double base;
        private double height;

        public TrianglePlot(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        double totalArea = 0.0;

        for (int i = 0; i < n; i++) {
            String shape = scanner.next().toUpperCase();
            String owner = scanner.next();

            Plot plot = null;

            switch (shape) {
                case "CIRCLE":
                    double radius = scanner.nextDouble();
                    plot = new CirclePlot(owner, radius);
                    break;
                case "RECTANGLE":
                    double length = scanner.nextDouble();
                    double width = scanner.nextDouble();
                    plot = new RectanglePlot(owner, length, width);
                    break;
                case "TRIANGLE":
                    double base = scanner.nextDouble();
                    double height = scanner.nextDouble();
                    plot = new TrianglePlot(owner, base, height);
                    break;
            }

            if (plot != null) {
                double area = plot.calculateArea();
                totalArea += area;
                System.out.printf("%s (%s): %.2f%n", owner, shape, area);
            }
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        scanner.close();
    }
}
