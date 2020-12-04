class Main {

    public static void main(String[] args) throws Exception {

        if (args.length != 2)
            throw new Exception("Arguments mismatch");
        else {
            Converter converter;
            double data = Double.parseDouble(args[0]);
            if (args[args.length - 1].charAt(0) == 't') {

                converter = new TempConverterToFahrenheit(data);
                System.out.println(converter.convert());

            } else if (args[args.length - 1].charAt(0) == 'h') {

                converter = new HeightConverterToInches(data);
                System.out.println(converter.convert());

            } else
                throw new Exception("Invalid choice for conversion");
        }
    }

}

abstract class Converter {
    private double data;

    Converter(double data) {
        this.data = data;
    }

    double getData() {
        return data;
    }

    abstract double convert();
}

class TempConverterToFahrenheit extends Converter {

    TempConverterToFahrenheit(double data) {
        super(data);
    }

    double convert() {
        return getData() * 9 / 5 + 32;
    }
}

class HeightConverterToInches extends Converter {

    HeightConverterToInches(double data) {
        super(data);
    }

    double convert() {
        return getData() * 12;
    }
}