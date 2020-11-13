class Main {
    
    private static String generateAbbrev(String name){

        String abbrevName = "";
        String partsOfName[] = name.split(" ");
        for(String part : partsOfName){

            abbrevName += part.charAt(0) + "";

        }
        abbrevName = String.join(".", abbrevName.toUpperCase().split("")) + ".";
        return abbrevName;

    }
    public static void main(String[] args) {
        
        System.out.println("Abbreviated form: " + generateAbbrev(args[args.length - 1]));

    }

}
