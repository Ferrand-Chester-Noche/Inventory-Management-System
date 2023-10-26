package com.inventory.restaurant.Services;

import com.inventory.restaurant.AddIngredient;
import com.inventory.restaurant.entities.Category_ingredient;
import com.inventory.restaurant.entities.Ingredient;
import com.inventory.restaurant.entities.Unit;

import java.io.*;
import java.util.*;

public class IngredientService {
    public final static String path="Ingredient.csv";
    public static void writeDataLineByLine(List<Ingredient> ingredientList)
    {
        try {
            FileWriter csvWriter = new FileWriter(path);
            csvWriter.append("sku").append(",");
            csvWriter.append("Name").append(",");
            csvWriter.append("category").append(",");
            csvWriter.append("brand").append(",");
            csvWriter.append("quantity").append(",");
            csvWriter.append("unit").append(",");
            csvWriter.append("Description").append("\n");

            for (Ingredient rowData : ingredientList) {
                csvWriter.append(sku(rowData)).append(",")
                .append(rowData.getName()).append(",")
                .append(rowData.getCategory().toString()).append(",")
                .append(rowData.getBrand()).append(",")
                .append(String.valueOf(rowData.getQuantity())).append(",")
                .append(rowData.getUnit().toString()).append(",")
                .append(rowData.getDescription()).append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.out.println("exception on writeDataLineByLine");
        }
    }

    public static void addLine(Ingredient rowData)
    {
        try {
            FileWriter csvWriter = new FileWriter(path,true);
                csvWriter.append(sku(rowData)).append(",")
                        .append(rowData.getName()).append(",")
                        .append(rowData.getCategory().toString()).append(",")
                        .append(rowData.getBrand()).append(",")
                        .append(String.valueOf(rowData.getQuantity())).append(",")
                        .append(rowData.getUnit().toString()).append(",")
                        .append(rowData.getDescription()).append("\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.out.println("exception on addLine");
        }
    }
    public static List<Ingredient> getIngredientFromCsv() throws IOException {
        List<Ingredient> ingredientList = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        csvReader.readLine();
        while ((row = csvReader.readLine()) != null) {

            Ingredient ingredient=new Ingredient();
            String[] data = row.split(",");

            ingredient.setSku(data[0]);
            ingredient.setName(data[1]);
            ingredient.setCategory(Category_ingredient.getByCatName(data[2]));
            ingredient.setBrand(data[3]);
            ingredient.setQuantity(Integer.parseInt(data[4]));
            ingredient.setUnit(Unit.valueOf(data[5]));
            ingredient.setDescription(data[6]);
            ingredientList.add(ingredient);
        }
        csvReader.close();
        return ingredientList;
    }
    public static Ingredient getIngredientBySku(String sku) throws IOException {
       List<Ingredient> ingredientList= getIngredientFromCsv();
       for(Ingredient ingredient : ingredientList)
       {
           if(ingredient.getSku().equals(sku))
           {
               return ingredient;
           }
       }
       return null;
    }
    public static void importFromCsv(String pathcsv) throws IOException {
        List<Ingredient> ingredientList = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(pathcsv));
        String row;
        csvReader.readLine();
        while ((row = csvReader.readLine()) != null) {

            Ingredient ingredient=new Ingredient();
            String[] data = row.split(",");

            ingredient.setSku(data[0]);
            ingredient.setName(data[1]);
            ingredient.setCategory(Category_ingredient.getByCatName(data[2]));
            ingredient.setBrand(data[3]);
            ingredient.setQuantity(Integer.parseInt(data[4]));
            ingredient.setUnit(Unit.valueOf(data[5]));
            ingredient.setDescription(data[6]);
            ingredientList.add(ingredient);
        }
        csvReader.close();
        List<Ingredient> mydata = getIngredientFromCsv();
        for(int i=0;i<mydata.size();i++)
        {
            for (int j=0;j<ingredientList.size();j++)
            {
                if (mydata.get(i).equals(ingredientList.get(j)))
                {
                    mydata.get(i).AddQuantity(ingredientList.get(j).getQuantity());
                    break;
                }
                if(!mydata.get(i).equals(ingredientList.get(j)) && j==ingredientList.size()-1)
                {
                    addLine(ingredientList.get(j));
                }
            }
        }
    }

    public static List<Ingredient> getIngredientsByCategory(Category_ingredient category_ingredient) throws IOException {
        List<Ingredient> ingredientList = new ArrayList<>();
        for(Ingredient ingredient : getIngredientFromCsv())
        {
            if(ingredient.getCategory().equals(category_ingredient))
            {
                ingredientList.add(ingredient);
            }
        }
        return ingredientList;
    }
    public static Ingredient CheckSufficientIngredientsByName(Ingredient ingredientToCheck) throws IOException {
        for(Ingredient ingredient : getIngredientFromCsv())
        {
            if(ingredient.getName().equals(ingredientToCheck.getName()))
            {
                if(ingredient.getQuantity()>=ingredientToCheck.getQuantity())
                {
                    return ingredient;
                }
            }
        }
        return null;
    }

    public static void Prepare(Ingredient stock,Ingredient ingredientToCheck) throws IOException {
        List<Ingredient> ingredientList = getIngredientFromCsv();
        ingredientList.remove(stock);
        stock.AddQuantity((ingredientToCheck.getQuantity()*-1));
        ingredientList.add(stock);
        writeDataLineByLine(ingredientList);

    }


    public static boolean uniqueSKU(String sku) throws IOException {
        if (getIngredientFromCsv().isEmpty())
        {
            return true;
        }
        for (Ingredient ingredient : getIngredientFromCsv())
        {
            if(sku.equals(ingredient.getSku().substring(6)))
            {
                return false;
            }
        }
        return true;
    }
    public static List<Ingredient> initializeIngredients()
    {
        return  Arrays.asList(
                new Ingredient("Salt",Category_ingredient.CONDIMENT,"",10000,Unit.g,"Salt"),
                new Ingredient("Meat",Category_ingredient.MEAT,"No Brand",5000,Unit.g,"Meat"),
                new Ingredient("Cola",Category_ingredient.BEVERAGE,"CocaCola",20,Unit.bottle,"Cola"),
                new Ingredient("Water",Category_ingredient.BEVERAGE,"No Brand",20000,Unit.ml,"Basic water"),
                new Ingredient("Olive Oil", Category_ingredient.CONDIMENT,"",30000,Unit.ml,"Olive oil"),
                new Ingredient("Pasta",Category_ingredient.PASTA,"",20000,Unit.g,"Pasta"),
                new Ingredient("Mayo",Category_ingredient.SAUCE,"",5000,Unit.g,"Mayo"),
                new Ingredient("Ketchup",Category_ingredient.SAUCE,"",5000,Unit.g,"Ketchup"),
                new Ingredient("Tomato",Category_ingredient.VEGETABLES,"",5000,Unit.g,"Tomato for sauce"),
                new Ingredient("Banana",Category_ingredient.FRUIT,"",5000,Unit.g,"Banana"),
                new Ingredient("Orange",Category_ingredient.FRUIT,"",5000,Unit.g,"Orange"),
                new Ingredient("Lettuce",Category_ingredient.VEGETABLES,"",5000,Unit.g,"Lettuce"),
                new Ingredient("Rice",Category_ingredient.RICE,"",20000,Unit.g,"Rice"),
                new Ingredient("Pepsi",Category_ingredient.BEVERAGE,"Pepsi",10,Unit.bottle,"Pepsi"),
                new Ingredient("Fish",Category_ingredient.FISH,"",10000,Unit.g,"Fish"),
                new Ingredient("Garlic",Category_ingredient.VEGETABLES,"",1000,Unit.g,"Garlic"),
                new Ingredient("Apple",Category_ingredient.FRUIT,"",10000,Unit.g,"Apple"),
                new Ingredient("Tuna fillet",Category_ingredient.FISH,"",125,Unit.g,"tuna"),
                new Ingredient("Rice",Category_ingredient.RICE,"",150,Unit.g,"Rice"),
                new Ingredient("water",Category_ingredient.BEVERAGE,"",180,Unit.ml,"Garlic"),
                new Ingredient("Sesame Oil", Category_ingredient.CONDIMENT,"",7,Unit.g,"Olive oil")
        );
    }
    public static void main(String[] args) throws IOException {
        addLine( new Ingredient("T-shirt", Category_ingredient.TSHIRT,"",10000, Unit.piece,"T-shirt"));
        /*
        List<Ingredient> rows = initializeIngredients();
        writeDataLineByLine(rows);
        System.out.println(getIngredientFromCsv());
        for(Ingredient ingredient : rows ){
            System.out.println(sku(ingredient));
        }
         */
    }
    public static String sku(Ingredient ingredient) throws IOException {
        Random rand = new Random();
        String numbers = "0123456789";
        StringBuilder sb = new StringBuilder(4);
        do {
            for (int i = 0; i < 4; i++) {
                sb.append(numbers.charAt(rand.nextInt(9)));
            }
        }while (!uniqueSKU(sb.toString()));

        return  String.valueOf(Character.toUpperCase(ingredient.getCategory().toString().charAt(0))) +
                Character.toUpperCase(ingredient.getCategory().toString().charAt(ingredient.getCategory().toString().length() - 1)) +
                Character.toUpperCase(ingredient.getName().charAt(0)) +
                Character.toUpperCase(ingredient.getName().charAt(ingredient.getName().length() - 1)) +
                '-' +
                sb;
    }
}
