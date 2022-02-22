import java.util.*;

public class Main {

    static Deque<Integer> out = new ArrayDeque<>();
    static List<List<Integer>> arrays = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-9);
        list.add(-8);
        list.add(-7);
        list.add(-6);
        list.add(-5);
        list.add(-4);
        list.add(-3);
        list.add(-2);
        list.add(-1);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        /*list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);*/

        System.out.println(getResult(list));
        System.out.println(count);

    }
    static long count = 0L;
    public static void recurs(List<Integer> in, int jj) {
        //count += 1L;
        if (in.size() == 0) {
            return;
        }
        int j = in.size();
        int sum = 0;
        boolean isNot = false;
        for (int i = 0; i < j; i++) {
            int k;
            k = in.remove(i);
            sum += k;
            if (Math.abs(k) >= jj) isNot = true;
            if (!containtsArray(in)) {
                arrays.add(new ArrayList<>(in));
                recurs(new ArrayList<>(in), jj);
            } else {
                in.add(i, k);
                continue;
            }
            in.add(i, k);
        }
        if (!isNot) {
            out.add(sum);
            //System.out.print(sum + " ");
        }
    }

    public static boolean getResult(List<Integer> fences) {
        int k = fences.size();
        List<Integer> fences2 = new ArrayList<>(fences);
        Collections.sort(fences2);
        recurs(fences2, k);
        while (!out.isEmpty()) {
            if (out.pollLast() == k - 1) return true;
        }
        return false;
    }

    public static boolean containtsArray(List<Integer> list) {


        for (List<Integer> array : arrays) {
            if (array.equals(list)) return true;
        }
        return false;
    }

}
