import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    //1.Take input and processing(precomputation + query
    static int GCD(int n, int m) {
        if (m == 0)
            return n;
        return GCD(m, n % m);
    }

    static int LCM(int n, int m) {
        return (n * m) / GCD(n, m);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int lcm = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        while (lcm!=0){

            int Counter = 0;
            for (int gcd = 1;gcd*gcd <=lcm; gcd++) {
                    if(lcm%gcd!=0)
                        continue;
                    int j;
                    int gcd2=lcm/gcd;
                    for (j = 1; j * j <= lcm / gcd; j++) {
                        if ((lcm / gcd) % j == 0) {
                            if (GCD(lcm / (gcd * j), j) == 1) {

                                Counter++;

                            }
                        }
                        if (j * j <= lcm / gcd2&&(lcm / gcd2) % j == 0) {
                            if (GCD(lcm / (gcd2 * j), j) == 1&&gcd!=gcd2) {

                                Counter++;

                            }
                        }

                    }



            }

            out.println(lcm+" "+Counter);
            st = new StringTokenizer(br.readLine());
            lcm = Integer.parseInt(st.nextToken());
        }
        out.flush();
    }
}
