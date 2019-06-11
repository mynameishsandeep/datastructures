import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Test{

    public static void main(String[] args) throws FileNotFoundException{
        File f = new File("clustering_big.txt");
        Scanner s = new Scanner(f);

        int number = s.nextInt();
        s.nextLine();
        UnionFind uf = new UnionFind(number);

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        int index = 0;
        while(s.hasNext()){
            String input = s.nextLine();
            int tempNum = convert(input);

            int[] test = reconvert(tempNum);

            if (map.containsKey(tempNum)){
                ArrayList<Integer> indexes = map.get(tempNum);
                indexes.add(index);
                map.put(tempNum, indexes);
            }

            else{
                ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
                tempArrayList.add(index);
                map.put(tempNum, tempArrayList);
            }

            index ++;
        }

        // Union
        Set<Integer> keys = map.keySet();
        for (int key:keys){

            ArrayList<Integer> ids = map.get(key);

            // Union distance = 0
            for(int i = 0; i < ids.size() - 1; i ++){
                for(int j = i + 1; j < ids.size(); j ++){

                    int idOne = ids.get(i);
                    int idTwo = ids.get(j);

                    if (!uf.checkConnected(idOne, idTwo))
                        uf.connect(ids.get(i), ids.get(j));
                }
            }

            // Union distance = 1
            for (int i = 0; i < ids.size(); i ++){
                ArrayList<Integer> potentials = generateNearNumber(key, 1);
                for (int potential : potentials){
                    if(map.containsKey(potential)){
                        ArrayList<Integer> potentialIds = map.get(potential);
                        for (int id: potentialIds){
                            int idOne = ids.get(i);

                            if(!uf.checkConnected(idOne, id))
                                uf.connect(ids.get(i), id);
                        }

                    }
                }

            }

            // Union distance = 2
            for (int i = 0; i < ids.size(); i ++){
                ArrayList<Integer> potentials = generateNearNumber(key, 2);
                for (int potential : potentials){
                    if(map.containsKey(potential)){
                        ArrayList<Integer> potentialIds = map.get(potential);
                        for (int id: potentialIds){
                            int idOne = ids.get(i);

                            if (!uf.checkConnected(idOne, id ))
                                uf.connect(ids.get(i), id);
                        }

                    }
                }

            }
        }

        System.out.println(uf.components);
    }

    public static int convert(String input){

        String[] testing = input.split(" ");

        int tempNum = 0;
        int twos = 1;

        for(int i = 0; i <= 23; i ++) {
            tempNum += Integer.valueOf(testing[i]) * twos;
            twos *= 2;
        }

        return tempNum;
    }

    public static int convert(int[] arr){
        int tempNum = 0;
        int twos = 1;

        for(int i = 0;i <=23; i ++){
            tempNum += arr[i] * twos;
            twos *= 2;
        }

        return tempNum;

    }

    public static int[] reconvert(int input){
        int[] result = new int[24];

        for(int i = 0; i <= 23; i ++){
            result[i] = input % 2;
            input /= 2;
        }

        return result;
    }

    public static ArrayList<Integer> generateNearNumber(int input, int distance){
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(distance < 0)
           return null;

        else if (distance == 0){
            result.add(input);
        }

        else if (distance == 1){

            int[] originalBinaryForm = reconvert(input);
            for (int i = 0;i < originalBinaryForm.length; i ++){
                int[] temp = Arrays.copyOf(originalBinaryForm, originalBinaryForm.length);
                if (temp[i] == 1)
                    temp[i] = 0;
               else
                    temp[i] = 1;

                result.add(convert(temp));
            }
        }

        else if (distance == 2){

            int[] originalBinaryForm = reconvert(input);
            for (int i = 0; i < originalBinaryForm.length - 1; i ++){
                for (int j = i + 1; j < originalBinaryForm.length; j ++){
                    int[] temp = Arrays.copyOf(originalBinaryForm, originalBinaryForm.length);

                    if (temp[i] == 1)
                        temp[i] = 0;
                    else
                        temp[i] = 1;

                    if (temp[j] == 1)
                        temp[j] = 0;
                    else
                        temp[j] = 1;

                    result.add(convert(temp));

                }

            }
        }
        return result;
    }
}
