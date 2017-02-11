package gyc.java.main;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guoyc on 2016/7/16.
 */
public class HelpToMarkDownTest {

    private static final String NEW_LINE = "\r\n";
    private static final String MARKDOWN_TABLE_SECEND_LINE = "| ------- | ------- | ------- | ------- |";


    public static void main(String[] args) {

        // System.out.println(getContentFromUrl("http://www.zhihu.com/"));
        List<String> test_content = new ArrayList<>();
        test_content.add("| 1 | 1 | 1 | 1 |");
        test_content.add("| 2 | 2 | 2 | 2 |");
        outputMarkDown(test_content, "e:/test.md");
    }

    private static String getContentFromUrl(String content_url) {
        try {
            URL url = new URL(content_url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setInstanceFollowRedirects(false);
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();
            StringBuilder sb = new StringBuilder();
            String line = "";
            BufferedReader URLinput = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line = URLinput.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }
            con.disconnect();
            return sb.toString().toLowerCase();
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    private static List<String> tranStringToMarkDown() {
        return new ArrayList<>();
    }

    private static void outputMarkDown(List<String> content, String markdown_url) {
        String file_content = "";
        StringBuilder file_content_temp = new StringBuilder();
        for (int i = 0;  i < content.size(); i++) {
            if (i == 1) {
                file_content_temp.append(MARKDOWN_TABLE_SECEND_LINE);
            }
            file_content_temp.append(content.get(i));
            file_content_temp.append(NEW_LINE);
        }
        file_content = file_content_temp.toString();
        try {
            Writer writer = new FileWriter(markdown_url);
            BufferedWriter buffWriter=new BufferedWriter(writer);
            buffWriter.write(file_content);
            buffWriter.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("请检查路径是否正确");
        }
    }
}
