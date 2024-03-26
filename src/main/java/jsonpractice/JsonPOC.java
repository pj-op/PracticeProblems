package jsonpractice;

import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class JsonPOC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        prepareJsonObject();
//        getDBConnection();
        checkMapAddition();
    }

    private static void checkMapAddition() {
        List<Map<String, String>> cardsList = new ArrayList<>();

        Map<String, String> dataMap1 = new HashMap<>();
        dataMap1.put("card_num", "89898");
        dataMap1.put("card_title", "Live the Life");

        Map<String, String> dataMap2 = new HashMap<>();
        dataMap2.put("card_num", "1234");
        dataMap2.put("card_title", "Wait for Life");

        cardsList = Arrays.asList(dataMap1, dataMap2);

        cardsList.stream()
                .peek(c -> c.put("c", "c"))
                .toList()
                .forEach(System.out::println);

        cardsList.forEach(i -> i.put("cardList.available", "999"));

        System.out.println(cardsList);

    }

    private static void prepareJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "Pranjal");
        jsonObject.addProperty("id", "12345678");

        JsonArray jsonArray = new JsonArray();
        jsonArray.add("1234");
        jsonArray.add("45678");
        jsonArray.add("This is an json Array");
        jsonObject.add("mobileNumber", jsonArray);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(jsonObject));


    }

    private static void getDBConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "Epam1234$");
        PreparedStatement ps = con.prepareStatement("SELECT Name from tritable WHERE id=?");
        ps.setInt(1, 3);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String s = rs.getString("Name");

        JsonArray jsonArray = JsonParser.parseString(s).getAsJsonArray();

        System.out.printf(jsonArray.toString());
    }
}
