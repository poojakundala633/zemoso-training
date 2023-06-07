package Assignment6;
import java.util.*;

public class Assignment6_1 {
        public static void main(String[] args)
        {
            int count = 0;
            int num = 1000;
            while (count < 100)
            {
                if (isVampireNumber(num))
                {
                    System.out.println(num);
                    count++;
                }
                num++;
            }
        }

        public static boolean isVampireNumber(int num)
        {
            if (num % 2 != 0)
            {
                return false;
            }

            int[] numDigits = getDigits(num);
            int[] xyDigits ;
            int x, y;
            for (x = 10; x <= Math.sqrt(num); x++)
            {
                if (num % x == 0)
                {
                    y = num / x;
                    if (x % 10 == 0 && y % 10 == 0)
                    {
                        continue;
                    }
                    xyDigits = getDigits(x, y);
                    Arrays.sort(numDigits);
                    Arrays.sort(xyDigits);
                    if (Arrays.equals(numDigits, xyDigits))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        public static int[] getDigits(int num)
        {
            String str = Integer.toString(num);
            int[] digits = new int[str.length()];
            for (int i = 0; i < str.length(); i++)
            {
                digits[i] = str.charAt(i) - '0';
            }
            return digits;
        }

        public static int[] getDigits(int x, int y)
        {
            int[] digits = new int[Integer.toString(x).length() + Integer.toString(y).length()];
            int index = 0;
            while (x > 0)
            {
                digits[index++] = x % 10;
                x /= 10;
            }
            while (y > 0)
            {
                digits[index++] = y % 10;
                y /= 10;
            }
            return digits;
        }
    }

