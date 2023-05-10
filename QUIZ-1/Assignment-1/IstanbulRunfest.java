import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> minutes = new ArrayList<>();
        Map<String, Integer> participants = new Hashtable<>();
        participants.put("Ibrahim",272);
        participants.put("Berke",479);
        participants.put("Metin",278);
        participants.put("Irem",329);
        participants.put("Yigit",445);
        participants.put("Melis",402);
        participants.put("Mehmet",388);
        participants.put("Akif",275);
        participants.put("Furkan",243);
        participants.put("Fırat",334);
        participants.put("Tolga",412);
        participants.put("Ozkan",393);
        participants.put("Umut",299);
        participants.put("Seda",343);
        participants.put("Selcan",317);
        participants.put("Hatice",265);
        for (Map.Entry<String, Integer> set : participants.entrySet()) {
            minutes.add(set.getValue());
        }
        String name = null;
        String name1 = null;
        int num = findFastest(minutes);
        int num1 = secondFastest(minutes);
        for (Map.Entry<String, Integer> entry : participants.entrySet()) {
            if (entry.getValue().equals(num)) {
                name = entry.getKey();
            }
            if (entry.getValue().equals(num1)){
                name1 = entry.getKey();
            }
        }
        System.out.println("1st runner is: " + name+"\t Run time: " +(num));
        System.out.println("2nd runner is: " + name1+"\t Run time: " +(num1));
}
    public static int findFastest (ArrayList<Integer> minutes){
        Collections.sort(minutes);
        return minutes.get(0);
    }
    public static int secondFastest(ArrayList<Integer> minutes){
        //System.out.println(minutes);
        return minutes.get(1);
    }
}
