

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexQuestion {
   public static void main(String[] args) {
      String phoneNumber = "����Ŭ : 010-3751-1361\n�ص��:010-3213-2154\n ������ȣ:017-393-6428";
      String content = contentGetter();
      //System.out.println(phoneNumber);
      String theNor = "The northern Area";
      regex("(?<=<span class='uccResultAmount'>)\\d.\\d{3}.\\d{2}", content);
      
      
      regex("01[016-9]-\\d{3,4}-\\d{4}",phoneNumber);
      regex("\\B(The|the)\\B", theNor);
      
      String IU = IURelicMaker();
      //System.out.println(IU);
      regex("(?<=������, )�ϳ�",IU);
   }
   private static void regex(String regex, String input){
      Pattern p = Pattern.compile(regex);
      System.out.println(p);
      Matcher m = p.matcher(input);
      //System.out.println(m.find());
      List<String> list = new ArrayList<>();
      while(m.find()){
         list.add(m.group());
      }
      for(String a:list){
         System.out.println(a);
      }
      
   }
   private static String IURelicMaker(){
      StringBuilder sb = new StringBuilder();
      sb.append("���� �̷��� �ϴ��� �� �Ķ�����\n");
      sb.append("���õ��� �� �ٶ��� �� �Ϻ�����\n");
      sb.append("�׳� �𸣴�ô �ϳ� ������ô\n");
      sb.append("��������ô �� ��� �����ұ�\n");
      sb.append("�ƹ� �� ���ϰ� �Ը����\n");
      sb.append("������ ���ö� �� ���\n");
      sb.append("�帣�� ���ϰ� �� ��¦ ����\n");
      sb.append("���� �� �̷����� ���� ���� �ϴ���\n");
      sb.append("���� �ߴ� ��� �� �� �ϴ� ����\n");
      sb.append("�ѹ��� ���ߴ� ��\n");
      sb.append("��鼭 �� ���� �� ������ ��\n");
      sb.append("���¿� ������ ������ ���\n");
      sb.append("\n");
      sb.append("���� �ٲ� �� �Ӹ��� ���ο�����\n");
      sb.append("�԰� ���Դ� ���� �Ǽ���������\n");
      sb.append("���� �𸣴�ô ��� �� ����ô\n");
      sb.append("�ƹ� �Ͼ�����ó�� �����\n");
      sb.append("�׳� �����ڰ� ����ұ�\n");
      sb.append("������ ���ö� �� ���\n");
      sb.append("�帣�� ���ϰ� �� ��¦ ����\n");
      sb.append("���� �� �̷����� ���� ���� �ϴ���\n");
      sb.append("���� �ߴ� ��� �� �� �ϴ� ����\n");
      sb.append("�ѹ��� ���ߴ� ��\n");
      sb.append("��鼭 �� ���� �� ������ ��\n");
      sb.append("���¿� ������ ������ ���\n");
      sb.append("(��~ ���)\n");
      sb.append("\n");
      sb.append("�̷� ���� ���� �׷� ���� ���� ���� ���ƿ�\n");
      sb.append("ö ���� ���� ���� ���Ѱ��� ���� ���� ���°ɿ�\n");
      sb.append("\n");
      sb.append("������ �����µ� Ȱ¦ ����\n");
      sb.append("�� ���� ���� �� ũ�� ����\n");
      sb.append("���� �� �̷����� �β����� ������\n");
      sb.append("�������� ���� ���� �ϴ� ����\n");
      sb.append("�� ���� ���ߴ� �� ��¼�� �ٽ� ���� �ٷ� �� ��\n");
      sb.append("���¿� ������ ������(������, �ϳ� ��)\n");
      sb.append("I'm in my dream\n");
      sb.append("\n");
      sb.append("(It's too beautiful beautiful day)\n");
      sb.append("(Make it a good day)\n");
      sb.append("(Just don't make me cry)\n");
      sb.append("�̷��� ���� ��\n");
      return sb.toString();
   }
   
   
   private static String contentGetter(){
      StringBuilder contents = new StringBuilder();
      Pattern p = Pattern.compile("(?<=<span class=\'uccResultAmount\'>)\\d?,?[0-9]{3}.\\d{2}");
      System.out.println(p);
      String urlPath = "http://www.xe.com/currencyconverter/convert/?Amount=1&From=USD&To=KRW";
      String pageContents = "";
      String content = "";
      try {

         URL url = new URL(urlPath);
         URLConnection con = (URLConnection) url.openConnection();
         InputStreamReader reader = new InputStreamReader(con.getInputStream(), "utf-8");

         BufferedReader buff = new BufferedReader(reader);

         while ((pageContents = buff.readLine()) != null) {
            // System.out.println(pageContents);
            contents.append(pageContents);
            contents.append("\r\n");
         }

         buff.close();

         System.out.println(contents.toString());
         content = contents.toString();
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return content;
   }
}