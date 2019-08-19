public class ReverseInteger {


    public int reverseAllInt(int n,int l) {
        int result = 0;
        for (int i = 0; i < l ; i++) {
            int bit = n & 1;
            n >>= 1;
            result <<= 1;
            result |= bit;
        }
        return result;
    }
}
