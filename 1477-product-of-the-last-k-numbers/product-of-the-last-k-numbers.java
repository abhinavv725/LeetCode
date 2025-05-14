class ProductOfNumbers {
    List<Integer> arr;
    int prod;


    public ProductOfNumbers() {
        arr = new ArrayList<>();
        prod =1;
    }
    
    public void add(int num) {
        if(num==0){
            arr = new ArrayList<>();
            prod =1;
        }else{
            prod*=num;
            arr.add(prod);
        }
        
    }
    
    public int getProduct(int k) {
        if(k>arr.size())
            return 0;
        else if(k==arr.size())
            return prod;
        else{
            return (int) (arr.get(arr.size()-1)/arr.get(arr.size()-1-k));
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */