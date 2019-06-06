import p2utils.*;

public class SupermarketOrdering
{
    private int numOrders = 0;
	private Queue<Order> orders = new Queue<>();
	private HashTable<Integer> products = new HashTable<>(10);
    
    public SupermarketOrdering(){}

    public void enterOrder(Order order)
    {
        orders.in(order);
        numOrders++;
        if(!products.contains(order.prodName)) products.set(order.prodName, order.quantity);
        else products.set(order.prodName, products.get(order.prodName) + order.quantity);
    }

    public int numOrders()
    {
        return this.numOrders;
    }

    public Order serveOrder()
    {
        Order order = orders.peek();
        products.set(order.prodName, products.get(order.prodName) - order.quantity);

        orders.out();
        numOrders--;
        return order;
    }

    public int query(String product)
    {
        if(this.products.contains(product)) return this.products.get(product);
        else return 0;
    }

    public void displayOrders()
    {
        String[] productKeys = this.products.keys();
        System.out.println("-> Produtos encomendados");
        int servedProducts = 0;
        for(String key : productKeys)
        {
            int request = this.products.get(key);
            if(request > 0){
                System.out.println(key + ":" + request);
                servedProducts++;
            }
        }
        if(servedProducts == 0) System.out.println("Nada em espera para ser entregue");
        System.out.println("");

    }
}