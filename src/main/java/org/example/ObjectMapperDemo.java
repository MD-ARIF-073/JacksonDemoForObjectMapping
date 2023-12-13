package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.ToString;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

//@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Data
class Laptop{
    private String brand;
    private String model;

//    @Override
//    public String toString() {
//        return "Laptop{" +
//                "brand='" + brand + '\'' +
//                ", model='" + model + '\'' +
//                '}';
//    }

//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }

}
public class ObjectMapperDemo {
    public static void main(String[] args) {
        String json = "{\"brand\":\"ACER\", \"model\":\"XYZ\", \"serial\":\"\" }";
//      String json = "[{\"brand\":\"ACER\", \"model\":\"XYZ\", \"serial\":\"\" }," +   // Json string array
//                "{\"brand\":\"DELL\", \"model\":\"ABC\", \"serial\":\"\"}]";
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
           // Laptop l = mapper.readValue(json, Laptop.class);   // Json string to java object conversion
           // Laptop[] l = mapper.readValue(json, Laptop[].class);  // Json string to an array of java object conversion
           // List<Laptop> l = mapper.readValue(json, new TypeReference<List<Laptop>>() {}); // Json string array to list of java object conversion
            Map<String, String> l = mapper.readValue(json, new TypeReference<Map<String, String>>() {});
//            for(Laptop lt: l){
//                System.out.println(lt);
//            }
            l.keySet().forEach(key -> {
                System.out.println("Key: " +key);
                System.out.println("Value: " +l.get(key));
                    });
           // System.out.println(l);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
//        // Converting Java obj to a Json String
//        Laptop l = new Laptop();
//        l.setBrand("ACER");
//        l.setModel("XYZ");
//
//        ObjectMapper om = new ObjectMapper();
//        StringWriter writer = new StringWriter();  // can write it's contents to a string
//        try {
//            om.writeValue(writer, l);   // 2nd argument is the obj that neet to convert to json string
//            String json = writer.toString(); //Converting String Writer to a string with its toString method
//            System.out.println(json);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}