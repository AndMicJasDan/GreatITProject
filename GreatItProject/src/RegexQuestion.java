

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
      String phoneNumber = "마이클 : 010-3751-1361\n앤드류:010-3213-2154\n 옛날번호:017-393-6428";
      String content = contentGetter();
      //System.out.println(phoneNumber);
      String theNor = "The northern Area";
      regex("(?<=<span class='uccResultAmount'>)\\d.\\d{3}.\\d{2}", content);
      
      
      regex("01[016-9]-\\d{3,4}-\\d{4}",phoneNumber);
      regex("\\B(The|the)\\B", theNor);
      
      String IU = IURelicMaker();
      //System.out.println(IU);
      regex("(?<=아이쿠, )하나",IU);
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
      sb.append("어쩜 이렇게 하늘은 더 파란건지\n");
      sb.append("오늘따라 왜 바람은 또 완벽한지\n");
      sb.append("그냥 모르는척 하나 못들은척\n");
      sb.append("지워버린척 딴 얘길 시작할까\n");
      sb.append("아무 말 못하게 입맞출까\n");
      sb.append("눈물이 차올라서 고갤 들어\n");
      sb.append("흐르지 못하게 또 살짝 웃어\n");
      sb.append("내게 왜 이러는지 무슨 말을 하는지\n");
      sb.append("오늘 했던 모든 말 저 하늘 위로\n");
      sb.append("한번도 못했던 말\n");
      sb.append("울면서 할 줄은 나 몰랐던 말\n");
      sb.append("나는요 오빠가 좋은걸 어떡해\n");
      sb.append("\n");
      sb.append("새로 바뀐 내 머리가 별로였는지\n");
      sb.append("입고 나왔던 옷이 실수였던건지\n");
      sb.append("아직 모르는척 기억 안 나는척\n");
      sb.append("아무 일없던것처럼 굴어볼까\n");
      sb.append("그냥 나가자고 얘기할까\n");
      sb.append("눈물이 차올라서 고갤 들어\n");
      sb.append("흐르지 못하게 또 살짝 웃어\n");
      sb.append("내게 왜 이러는지 무슨 말을 하는지\n");
      sb.append("오늘 했던 모든 말 저 하늘 위로\n");
      sb.append("한번도 못했던 말\n");
      sb.append("울면서 할 줄은 나 몰랐던 말\n");
      sb.append("나는요 오빠가 좋은걸 어떡해\n");
      sb.append("(휴~ 어떡해)\n");
      sb.append("\n");
      sb.append("이런 나를 보고 그런 슬픈 말은 하지 말아요\n");
      sb.append("철 없는 건지 조금 둔한건지 믿을 수가 없는걸요\n");
      sb.append("\n");
      sb.append("눈물은 나오는데 활짝 웃어\n");
      sb.append("네 앞을 막고서 막 크게 웃어\n");
      sb.append("내가 왜 이러는지 부끄럼도 없는지\n");
      sb.append("자존심은 곱게 접어 하늘 위로\n");
      sb.append("한 번도 못했던 말 어쩌면 다신 못할 바로 그 말\n");
      sb.append("나는요 오빠가 좋은걸(아이쿠, 하나 둘)\n");
      sb.append("I'm in my dream\n");
      sb.append("\n");
      sb.append("(It's too beautiful beautiful day)\n");
      sb.append("(Make it a good day)\n");
      sb.append("(Just don't make me cry)\n");
      sb.append("이렇게 좋은 날\n");
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