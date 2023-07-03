package env2prop.src.main.java.no.fun.stuff.linux.bash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Env2Prop {
    public void convertAll() throws IOException {
        if (System.in.available() == 0) {
            return;
        }
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(convertLine(line));
            line = reader.readLine();
        }
    }

    public String convertLine(String line) {

        String[] split = line.split("[=]");
        List<String> list = Arrays.asList(split);
        if (split.length < 2) {
            return line;
        }
        if (split.length > 2) {
            List<String> strings = list.subList(1, list.size());
            split = new String[]{split[0], contact(strings, "=")};
        }
        String[] variableName = split[0].split("[_]");
        String lowerCase = contact(Arrays.asList(variableName), ".").toLowerCase();
        return lowerCase.concat("=").concat(split[1]);
    }

    public static String contact(final List<String> list, String delimiter) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < list.size() - 1; i++) {
            sb.append(list.get(i)).append(delimiter);
        }
        sb.append(list.get(list.size() - 1));
        return sb.toString();
    }

}
