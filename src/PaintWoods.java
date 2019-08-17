public class PaintWoods {
    public int minTime (int[] woods, int k) {
        int lowerBound = 0;
        int upperBound = 0;
        for (int wood : woods) {
            lowerBound = Math.max(wood,lowerBound);
            upperBound += wood;
        }

        // classical binary search and find answer
        while (lowerBound < upperBound - 1) {
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            if (!validate(woods, k, mid)) {
                lowerBound = mid+1;
            } else {
                upperBound = mid;
            }
        }
        if (validate(woods,k,lowerBound)) {
            return lowerBound;
        }
        return upperBound;
    }

    public int minTime2(int[] woods, int numOfPainters) {
        int[] minTimeForKMinusOnePainters= new int[woods.length];
        int[] prevSum = new int[woods.length];
        for (int i = 0; i < woods.length; i++) {
            if (i > 0) {
                prevSum[i] += prevSum[i-1];
            }
            prevSum[i]  += woods[i];
        }
        for (int i = 0; i < woods.length; i++) {
            minTimeForKMinusOnePainters[i] = prevSum[i];
        }


        for (int k = 2; k <= numOfPainters; k++) {
            int[] minTimeForKPainters= new int[woods.length];
            for (int index = 1; index < woods.length; index++) {
                minTimeForKPainters[index] = prevSum[index];
                for (int i = 0; i <= index; i++) {
                    minTimeForKPainters[index] = Math.min(minTimeForKPainters[index],
                            Math.max( minTimeForKMinusOnePainters[i],prevSum[index]-prevSum[i]));
                }
            }
            minTimeForKMinusOnePainters =  minTimeForKPainters;
        }
        return minTimeForKMinusOnePainters[woods.length-1];
    }

    // validate if we can paint WITHIN targetTime and WITHIN k workers
    private boolean validate(int[] woods, int k, int targetTime) {
        int accumulatedWoods = 0;
        for (int i = 0; i < woods.length; i++) {
            accumulatedWoods += woods[i];
            if (accumulatedWoods > targetTime) {
                k--;
                accumulatedWoods = woods[i];
            }
        }
        // a worker needs to do the rest
        k--;
        return k >= 0;
    }
}
