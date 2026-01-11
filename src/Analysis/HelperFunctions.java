package Analysis;

 public class HelperFunctions {
    public static Integer  parseNumber(String num, Integer maxNum){
        if(maxNum == null){
            maxNum=999999999;
        }
        String first2chars = null;
        if(num.length()>1){
            first2chars = num.substring(0,2);
        }else{
           first2chars = num.substring(0,1);
        }

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

    public static void main(String[] arg){
        Integer res =parseNumber("1",null);
        System.out.println(res);
    }
}
