package Analisis;

 public class HelperFunctions {
    public static Integer  parseNumber(String num, Integer maxNum){
        if(maxNum == null){
            maxNum=999;
        }
        String first2chars = num.substring(0,2);
        Integer res = null;
        switch (first2chars) {
            case "0x" -> {
                res = Integer.decode(num);
            }
            case "0b" -> {
                //Strip 0b
                String new_num = num.substring(2);
                //Strip .
                new_num = new_num.replace(".","");
                //process
                res = Integer.parseInt(new_num,2);
                }

            default -> {
                res = Integer.parseInt(num);
            }
        }

        if(res>maxNum){
            throw new RuntimeException("El número supera el límite establecido: " +maxNum);
        }
        return res;
    }
}
