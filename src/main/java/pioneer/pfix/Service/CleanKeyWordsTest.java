package pioneer.pfix.Service;

public class CleanKeyWordsTest
{
    public static void main(String[] args) {
        CleanKeyWords cleanKeyWords = new CleanKeyWords();
        String bbb = cleanKeyWords.cleanSql("insert asdasd");
        System.out.println(bbb);
        String aaa = cleanKeyWords.cleanXSS("<a></html>");
        System.out.println(aaa);
    }
}
