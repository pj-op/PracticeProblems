package jsonpractice;

import com.concepts.EmpData;
import com.google.gson.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class LoadJsonData {
    List<EmpData> empList;
    static String jsonData;
    String path = "mkdata/MOCK_DATA.json";

    public LoadJsonData() {
        empList = new ArrayList<>();
        jsonData = readingFile(path);
    }

    public static void main(String[] args) throws IOException {
        //Data Setup
        var empList = new LoadJsonData().prepareEmpList(jsonData);
        new LoadJsonData().createCSV(
//        System.out.println(
                manipulateData(empList)
//        );
        );

        new LoadJsonData().createXLS(
                manipulateData(empList)
        );
//        mapOperation();

    }

    public File loadingJsonData() throws IOException {
        var empList = new LoadJsonData().prepareEmpList(jsonData);
        return new LoadJsonData()
                .createXLS(manipulateData(empList));
//                .createCSV(manipulateData(empList));
    }

    public File createCSV(List<EmpData> empList) throws IOException {

        File file = new File("OP.csv");
        if (file.createNewFile()) System.out.println("Created File : " + file.getName());
        FileWriter fileWriter = new FileWriter("OP.csv");

        fileWriter.write("id,firstName,lastName,email,gender,salary,joiningDate");
        fileWriter.write("\n");

        for (EmpData emp : empList) {
            fileWriter.write(String.valueOf(emp));
            fileWriter.write("\n");
        }
        fileWriter.close();

        return file;
    }

    private File createXLS(List<EmpData> empList) throws IOException {
        try (XSSFWorkbook wb = new XSSFWorkbook(); FileOutputStream fos = new FileOutputStream("XLS-File.xlsx")) {
            XSSFSheet sheet = wb.createSheet("csv_data");
            XSSFRow row = sheet.createRow(0);
            String[] rowHeaderLegend = {"id", "firstName", "lastName", "email", "gender", "salary", "joiningDate"};
            for (int i = 0; i < rowHeaderLegend.length; i++) {
                row.createCell(i).setCellValue(rowHeaderLegend[i]);
            }
            int rowIndex = 1;
            for (EmpData emp : empList) {
                XSSFRow row1 = sheet.createRow(rowIndex++);
                row1.createCell(0).setCellValue(emp.getId());
                row1.createCell(1).setCellValue(emp.getFirstName());
                row1.createCell(2).setCellValue(emp.getLastName());
                row1.createCell(3).setCellValue(emp.getEmail());
                row1.createCell(4).setCellValue(emp.getGender());
                row1.createCell(5).setCellValue(emp.getSalary());
                row1.createCell(6).setCellValue(emp.getJoiningDate());
            }
            wb.write(fos);
            return new File("XLS-File.xlsx");
        }
    }

    private static void mapOperation() {
        int[] arr = {5, 7, 5, 7, 5, 2, 7, 7};
        Map.Entry<Integer, Long> maxEntry = null;
        maxEntry = Collections.max(
                Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                        .entrySet(), Map.Entry.comparingByValue());
        System.out.println(maxEntry.getKey());

    }

    private static List<EmpData> manipulateData(List<EmpData> empList) {

        //Employee Name starting with A
//        var s =
        return
                empList.stream()
//                .filter(emp->emp.getFirstName().startsWith("A"))
                        .filter(emp -> emp.getSalary() > 80000 && "Male".equalsIgnoreCase(emp.getGender()))
                        .filter(empData -> empData.getJoiningDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isAfter(LocalDate.now().minusYears(10)))
                        .sorted(Comparator.comparing(EmpData::getFirstName))
                        .limit(10)
//                .map(String::valueOf)
//                .collect(Collectors.joining(","));
//                .forEach(System.out::println);
                        .collect(Collectors.toList());


//        LocalDate.now().datesUntil(LocalDate.now().plusDays(10)).forEach(System.out::println);

    }

    private List<EmpData> prepareEmpList(String jsonData) {

        JsonArray jsonArray = JsonParser.parseString(jsonData).getAsJsonArray();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        for (JsonElement jsonElement : jsonArray) {
            EmpData empData = gson.fromJson(jsonElement, EmpData.class);
            empList.add(empData);
        }
        return empList;
    }

    public List<EmpData> prepareEmpList() {
        return prepareEmpList(jsonData);
    }

    public String readingFile(String path) {
        /*try (FileInputStream fis = new FileInputStream("src/main/resources/mkdata/MOCK_DATA.json")) {
            while (fis.read() != -1) {
                System.out.println((char) fis.read());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(Objects.requireNonNull(this.getClass().getClassLoader().getResource(path)).getFile())) {
            int c = 0;
            while ((c = fis.read()) != -1) {
                sb.append((char) c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }
}
