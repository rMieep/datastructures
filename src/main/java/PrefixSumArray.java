public interface PrefixSumArray {
    int rangeQuery(int from, int to);
    void updatePoint(int index, int oldValue, int newValue);
}
