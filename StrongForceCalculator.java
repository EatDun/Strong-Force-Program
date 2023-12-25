import java.lang.Math;
import java.util.Scanner;

class Quark {
    String color;
    
    void setColor(String newColor) {
        String color = newColor;
    }
    
    public static String color1Method() {
        double num = Math.random();
        if (num < 0.33) {
            return "Red";
        }
        else if (num < 0.67) {
            return "Green";
        }
        else {
            return "Blue";
        }
    }
    
    public static String color2Method(String color1) {
        if (color1.equals("Blue")) {
            double num = Math.random();
            if (num < 0.5) {
                return "Red";
            }
            else {
                return "Green";
            } 
        }
        else if (color1.equals("Red")) {
            double num = Math.random();
            if (num < 0.5) {
                return "Blue";
            }
            else {
                return "Green";
            } 
        }
        else {
            double num = Math.random();
            if (num < 0.5) {
                return "Red";
            }
            else {
                return "Blue";
            } 
        }
    }
    
    public static String color3Method (String color1, String color2) {
        if (color1.equals("Red") && color2.equals("Blue")) {
            return "Green";
        }
        else if (color1.equals("Red") && color2.equals("Green")) {
            return "Blue";
        }
        else if (color1.equals("Blue") && color2.equals("Green")) {
            return "Red";
        }
        else if (color1.equals("Blue") && color2.equals("Red")) {
            return "Green";
        }
        else if (color1.equals("Green") && color2.equals("Red")) {
            return "Blue";
        }
        else {
            return "Red";
        }
    }
    
    public static String nextColor1Method (String color1, String color2) {
        if (color1.equals("Red")) {
            double num = Math.random();
            if (num > .5) {
                return "Blue";
            }
            else {
                return "Green";
            }
        }
        else if (color1.equals("Green")) {
            double num = Math.random();
            if (num > .5) {
                return "Blue";
            }
            else {
                return "Red";
            }
        }
        else {
            double num = Math.random();
            if (num > .5) {
                return "Red";
            }
            else {
                return "Green";
            }
        }
    }
}


class Gluon {
    String color;
    String antiColor;
    
    void setColor(String newColor) {
        color = newColor; 
    }
    void setAntiColor(String newAntiColor) {
        antiColor = newAntiColor;
    }
    
    public static String antiColorMethod(String q1C, String q2C) {
        if (q1C.equals("Red") && q2C.equals("Green")) {
            return "Blue";
        }
        else if (q1C.equals("Red") && q2C.equals("Blue")) {
            return "Green";
        }
        else if (q1C.equals("Green") && q2C.equals("Red")) {
            return "Blue";
        }
        else if (q1C.equals("Green") && q2C.equals("Blue")) {
            return "Red";
        }
        else if (q1C.equals("Blue") && q2C.equals("Red")) {
            return "Green";
        }
        else {
            return "Red";
        }
    }
    public static String colorMethod (String color) {
    return color;
    }
}

class StrongForce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String prevQOneColor = null;
        String prevQTwoColor = null;
        String prevQThreeColor = null;

        while (true) {
            Quark quarkOne = new Quark();
            Quark quarkTwo = new Quark();
            Quark quarkThree = new Quark();
            Gluon gluonOneTwo = new Gluon();
            Gluon gluonTwoThree = new Gluon();
            Gluon gluonThreeOne = new Gluon();

            String qOneColor, qTwoColor, qThreeColor;
            do {
                qOneColor = Quark.color1Method();
                qTwoColor = Quark.color2Method(qOneColor);
                qThreeColor = Quark.color3Method(qOneColor, qTwoColor);
            } while (qOneColor.equals(prevQOneColor) || qTwoColor.equals(prevQTwoColor) || qThreeColor.equals(prevQThreeColor));

            String gOneTwoColor = Gluon.colorMethod(qTwoColor);
            String gTwoThreeColor = Gluon.colorMethod(qThreeColor);
            String gThreeOneColor = Gluon.colorMethod(qOneColor);
            String gOneTwoAntiColor = Gluon.antiColorMethod(qOneColor, qTwoColor);
            String gTwoThreeAntiColor = Gluon.antiColorMethod(qTwoColor, qThreeColor);
            String gThreeOneAntiColor = Gluon.antiColorMethod(qThreeColor, qOneColor);

            quarkOne.color = qOneColor;
            quarkTwo.color = qTwoColor;
            quarkThree.color = qThreeColor;
            gluonOneTwo.setColor(gOneTwoColor);
            gluonOneTwo.setAntiColor(gOneTwoAntiColor);
            gluonTwoThree.setColor(gTwoThreeColor);
            gluonTwoThree.setAntiColor(gTwoThreeAntiColor);
            gluonThreeOne.setColor(gThreeOneColor);
            gluonThreeOne.setAntiColor(gThreeOneAntiColor);

            System.out.println("Quark1 color: " + quarkOne.color + "\nGluon1/2 color: " + gluonOneTwo.color + " / anti " + gluonOneTwo.antiColor + "\nQuark2 color: " + quarkTwo.color + "\nGluon2/3 color: " + gluonTwoThree.color + " / anti " + gluonTwoThree.antiColor + "\nQuark3 color: " + quarkThree.color + "\nGluon3/1 color: " + gluonThreeOne.color + " / anti " + gluonThreeOne.antiColor);

            System.out.println("Press Enter to generate the next sequence or type 'exit' to quit:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }
            
            prevQOneColor = qOneColor;
            prevQTwoColor = qTwoColor;
            prevQThreeColor = qThreeColor;
        }
    }
}
