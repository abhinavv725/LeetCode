class ProductOfNumbers {
    int[] mul;
    int index;

    public ProductOfNumbers() {
        mul=new int[40001];
        index=0;
    }
    
    public void add(int num) {
        mul[index++]=num;
    }
    
    public int getProduct(int k) {
        int prod=1;
        for(int i=index-k;i<index;i++){
            prod*=mul[i];
        }
        return prod;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */