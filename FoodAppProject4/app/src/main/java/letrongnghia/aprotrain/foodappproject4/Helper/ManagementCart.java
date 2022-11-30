package letrongnghia.aprotrain.foodappproject4.Helper;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

import letrongnghia.aprotrain.foodappproject4.Interface.ChangeNumberItemsListener;
import letrongnghia.aprotrain.foodappproject4.database.FoodData;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertFood(FoodData item){
        ArrayList<FoodData> listFood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for(int i =0; i < listFood.size(); i++){
            if(listFood.get(i).getTitle().equals(item.getTitle())){
                existAlready = true;
                n = i;
                break;
            }
        }
        if(existAlready){
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        }else {
            listFood.add(item);
        }
        tinyDB.putListObject("CartList", listFood);
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<FoodData> getListCart(){
        return tinyDB.getListObject("CartList");
    }
    public void plusNumberFood(ArrayList<FoodData> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CartList", listFood);
        changeNumberItemsListener.changed();
    }
    public void minisNumberFood(ArrayList<FoodData> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
       if(listFood.get(position).getNumberInCart()==1){
           listFood.remove(position);
       }else{
           listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()-1);
       }
        tinyDB.putListObject("CartList", listFood);
        changeNumberItemsListener.changed();
    }
    public Double getTotalFee(){
        ArrayList<FoodData> listFood = getListCart();
        double fee = 0;
        for (int i = 0; i < listFood.size(); i++) {
            fee = fee + (listFood.get(i).getFee() * listFood.get(i).getNumberInCart());
        }
        return fee;
    }
}
