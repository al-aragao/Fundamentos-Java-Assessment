package br.infnet.edu.assessment.presentation.console;

import br.infnet.edu.assessment.domain.Client;
import br.infnet.edu.assessment.domain.Costume;
import br.infnet.edu.assessment.domain.FigureAction;
import br.infnet.edu.assessment.domain.Manga;
import br.infnet.edu.assessment.domain.Order;
import br.infnet.edu.assessment.domain.Product;
import br.infnet.edu.assessment.infrastructure.crossCutting.exceptions.NegativeNumberException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        try {
            String directory = "C:/";
            String fileToRead = "Orders.txt";
            String fileToWrite = "Orders_Resume.txt";
            
            FileReader fileReader = new FileReader(directory + fileToRead);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            FileWriter fileWriter = new FileWriter(directory + fileToWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            String line = null;
            
            int proccessedOrder = 0;
            Order order = null;
            List<Order> orders = new ArrayList<Order>();
            
            line = bufferedReader.readLine();
            
            while(line != null){
                String[] fields = line.split(";");
                
                if(!"PM".equals(fields[0]) && !"PFA".equals(fields[0]) && !"PC".equals(fields[0]))
                {
                    if(order == null || order.getId().toString() != fields[0])
                    {
                        if(order != null){
                            orders.add(order);
                        }

                        proccessedOrder++;
                        order = generateOrder(fields);
                    }
                }
                else{
                    switch(fields[0]){
                        case "PM": //Manga
                            try {
                                order.addProduct(generateMangaProduct(fields));
                            } catch (Exception e) {
                                System.out.println("Erro ao adicionar o produto Manga na Order (" + order.getId()  + "): " + e.getMessage());
                            } 
                            break;
                        case "PC": //Costume
                            try {
                                order.addProduct(generateCostumeProduct(fields));
                            } catch (Exception e) {
                                System.out.println("Erro ao adicionar o produto Costume na Order (" + order.getId()  + "): " + e.getMessage());
                            }
                            break;
                        case "PFA": //Figure Action
                            try {
                                order.addProduct(generateFigureActionProduct(fields));
                            } catch (Exception e) {
                                System.out.println("Erro ao adicionar o produto Figure Action na Order (" + order.getId()  + "): " + e.getMessage());
                            }
                            break;
                        default:
                            System.out.println("Produto não categorizado");              
                            break;
                    }
                }
                
                line = bufferedReader.readLine();
            }
            
                        
            if(order != null){
                //;
                orders.add(order);
            }
            
            for (int i = 0; i< orders.size(); i++){
                for (int j = 0; j < orders.get(i).getProducts().size(); j++) {
                    StringBuilder builder = new StringBuilder();

                    builder.append(orders.get(i).toString()).append(";");

                    builder.append(orders.get(i).getProducts().get(j).toString()).append("\r\n");

                    bufferedWriter.write(builder.toString());
                }                
            }
            
            bufferedWriter.close();
            fileWriter.close();
            bufferedReader.close();
            fileReader.close();
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            System.out.println("Leitura concluida com sucesso");    
        }  
    }

    private static Order generateOrder(String[] fields) {
        Client client = new Client(
                UUID.fromString(fields[4]), fields[5], fields[6], fields[7]
        );
        
        return new Order(
                UUID.fromString(fields[0]), fields[1], fields[2], Boolean.parseBoolean(fields[3]),client
        );
    }

    private static Product generateMangaProduct(String[] fields) throws NegativeNumberException {
        return new Manga(
                UUID.fromString(fields[1]), 
                fields[2], 
                Float.parseFloat(fields[3]), 
                Integer.parseInt(fields[4]), 
                Integer.parseInt(fields[5]), 
                fields[6], 
                Integer.parseInt(fields[7])
        );
    }

    private static Product generateCostumeProduct(String[] fields) throws NegativeNumberException {
        return new Costume(
                UUID.fromString(fields[1]), 
                fields[2], 
                Float.parseFloat(fields[3]), 
                Integer.parseInt(fields[4]), 
                fields[5], 
                fields[6], 
                fields[7]);
    }

    private static Product generateFigureActionProduct(String[] fields) throws NegativeNumberException {
        return new FigureAction(
                UUID.fromString(fields[1]), 
                fields[2], 
                Float.parseFloat(fields[3]), 
                Integer.parseInt(fields[4]), 
                Integer.parseInt(fields[5]), 
                fields[6], 
                Integer.parseInt(fields[7]));
    }

}
