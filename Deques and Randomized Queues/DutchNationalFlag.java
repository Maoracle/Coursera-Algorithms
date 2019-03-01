
public class DutchNationalFlag {
    private Color[] buckets;
    private int swapCalls = 0, colorCalls = 0;

    private enum Color{
        RED, WHITE, BLUE
    }

    public DutchNationalFlag(Color[] buckets){
        this.buckets = buckets;
    }

    public Color color(int i){
        colorCalls++;
        return buckets[i];
    }

    public void swap(int i, int j){
        swapCalls++;
        Color temp = buckets[i];
        buckets[i] = buckets[j];
        buckets[j] = temp;
    }

    public void sort(){
        int r, b;
        r = 0;
        b = buckets.length - 1;
        int i = 0;
        while(i <= b){
            switch(color(i)){
                case RED: {
                    if(i != r){
                        swap(i, r);
                    }
                    r++;
                    i++;
                    break;
                }
                case BLUE: {
                    if(i != b){
                        swap(i, b);
                    }
                    b--;
                    break;
                }
                case WHITE: {
                    i++;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        int N = 7;
        Color[] buckets = new Color[N];
        buckets[0] = Color.BLUE;
        buckets[1] = Color.RED;
        buckets[2] = Color.WHITE;
        buckets[3] = Color.RED;
        buckets[4] = Color.BLUE;
        buckets[5] = Color.RED;
        buckets[6] = Color.WHITE;
        DutchNationalFlag f = new DutchNationalFlag(buckets);
        f.sort();
        for(int i = 0; i < N; i++){
            System.out.print(buckets[i]+" ");
        }
        System.out.println();
        System.out.println("Number of colorcalls: " + f.colorCalls);
        System.out.println("Number of swapcalls: " + f.swapCalls);
    }

}
