package companies.indium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HostsAndTotalNumberOfRequests {
    public static void main(String[] args) throws IOException {

        String path = "mkdata/hosts_access_log_00.txt";
        String text_file_data = new HostsAndTotalNumberOfRequests().readFile(path);
        String[] inputString = text_file_data.split(" ");
        List<String> host = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < inputString.length && idx < inputString.length; i++) {
            host.add(inputString[idx]);
            idx += 9;
        }

        var s = host.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());

        System.out.println(s);

    }

    private String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        try (FileInputStream fis = new FileInputStream(this.getClass().getClassLoader().getResource(path).getFile())) {
            while ((c = fis.read()) != -1) {
                sb.append((char) c);
            }
        }
        return sb.toString();
    }
}
