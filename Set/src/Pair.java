public class Pair {
    public int first;
    public int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        String s="("+first+","+second+")";
        return s;
    }
}
