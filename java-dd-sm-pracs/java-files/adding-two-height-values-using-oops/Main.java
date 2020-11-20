class Main {
    
    public static void main(String[] args) {
        
        Height firstHeight = new Height(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Height secondHeight = new Height(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        Height resultHeight = firstHeight.addHeight(secondHeight);
        resultHeight.display();

    }

}

class Height{

    private int heightM, heightCm;

    Height(){}

    Height(int heightM, int heightCm){

        this.heightM = heightM;
        this.heightCm = heightCm;

    }
    Height addHeight(Height secondHeight){

        int tempHeightCm = heightCm + secondHeight.heightCm;
        Height tempHeight = new Height();
        tempHeight.heightCm = tempHeightCm % 100;
        tempHeight.heightM = (heightM + secondHeight.heightM) + tempHeightCm / 100;
        return tempHeight;

    }
    void display(){

        System.out.println(heightM + " m" + " " + heightCm + " cm.");

    }

}