public class Oblig3 {

  public static void main(String[] args) {

    NeedleFinder nf = new NeedleFinder();
    String haystack = "oiwenndagporgpdogasdfoihasdwegwerfasdfadfdog";
    String needle =   "_nd_g";
    System.out.println(nf.findNeedle(haystack.toCharArray(), needle.toCharArray()));

  }

}
