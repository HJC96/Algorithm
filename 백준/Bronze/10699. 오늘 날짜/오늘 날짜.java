import java.text.SimpleDateFormat;
import java.util.Date;

class Main {
    public static void main(String[] args) {

        Date now = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(now));

    }
}