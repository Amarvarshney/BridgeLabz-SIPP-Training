import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class uniqueotp {
      public static String generateOTP() {
        int otp = 100000 + (int)(Math.random() * 900000); // 6-digit
        return String.valueOf(otp);
    }

    public static boolean areOTPsUnique(String[] otps) {
        Set<String> set = new HashSet<>(Arrays.asList(otps));
        return set.size() == otps.length;
    }

    public static void main(String[] args) {
        String[] otpList = new String[10];
        for (int i = 0; i < 10; i++) {
            otpList[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otpList[i]);
        }

        System.out.println("Are all OTPs unique? " + (areOTPsUnique(otpList) ? "Yes" : "No"));
    }
}
