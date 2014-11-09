import java.io.File;
import java.util.Scanner;

public class NeedleFinder {

  private final int SIZE = 256;
  private final char[] WILDCARDS = {'_'};

  private int[] buildBadCharShift(char[] needle) {

    int nWildCards = 0, biggestStreak = 0;

    for (char c : needle) {

      if (c == '_') nWildCards++;
      else if (c != '_' && nWildCards > biggestStreak) {

        biggestStreak = nWildCards;
        nWildCards = 0;

      }

    }

    int[] badCharShift = new int[SIZE];

    for (int i = 0; i < badCharShift.length; i++) badCharShift[i] = needle.length-biggestStreak;

    int last = needle.length-1;
    for (int i = 0; i < last; i++) badCharShift[(int) needle[i]] = last-i;

    return badCharShift;

  }

  //Returns the index of where the needle can be found in the haystack
  public int findNeedle(char[] hayStack, char[] needle) {

    int[] badCharShift = this.buildBadCharShift(needle);

    int offset = 0, scan = 0, maxOffset = hayStack.length-needle.length, last = needle.length-1;

    while (offset <= maxOffset) {

      for (scan = last; (needle[scan] == '_' || needle[scan] == hayStack[scan+offset]); scan--) {

        if (scan == 0) return offset;

      }

      offset += badCharShift[hayStack[offset+last]];

    }

    return -1;

  }

}
