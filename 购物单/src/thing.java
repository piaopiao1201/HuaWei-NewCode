public class thing{
    int price;
    int importance;
    double rate;
    int xuhao;
    int fujian;
    public thing(int price,int importance,int xuhao,int fujian){
        this.price=price;
        this.importance=importance;
        this.rate=(double)price/importance;
        this.xuhao=xuhao;
        this.fujian=fujian;
    }
}