import java.util.Random;

public class OTPService {
    public static String generateOTP() {
        Random rand = new Random();
        int otp = 1000 + rand.nextInt(9000);
        return String.valueOf(otp);
    }
}

