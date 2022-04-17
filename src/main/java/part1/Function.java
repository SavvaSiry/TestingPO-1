package part1;

import org.apache.commons.math3.fraction.BigFraction;

import java.math.BigInteger;

import static java.lang.Math.*;

public class Function {

    public static double tan(double x) {
        double result = 0;
        x %= PI;
        if (abs(x) != PI / 2) {
            int bernoulli;
            for (int n = 1; n < 7; n++) {
                bernoulli = 2 * n;
                result += abs(bernoulli(bernoulli))
                        * ((pow(2, 2 * n) * (pow(2, 2 * n) - 1)) / fact(2 * n))
                        * pow(x, 2 * n - 1);
            }
        } else return Double.NaN;
        return result;
    }

    private static int fact(int x) {
        if (x <= 1) return 1;
        return x * (fact(x - 1));
    }

    private static double bernoulli(int n) {
        BigFraction result = BigFraction.ZERO;
        for (int k = 0; k <= n; k++) {
            BigFraction jSum = BigFraction.ZERO;
            BigInteger bInt = BigInteger.ONE;
            for (int j = 0; j <= k; j++) {
                BigInteger jPownN = (new BigInteger("" + j)).pow(n);
                if (j % 2 == 0) {
                    jSum = jSum.add(bInt.multiply(jPownN));
                } else {
                    jSum = jSum.subtract(bInt.multiply(jPownN));
                }
                bInt = bInt.multiply(new BigInteger("" + (k - j))).
                        divide(new BigInteger("" + (j + 1)));
            }
            result = result.add(jSum.divide(new BigInteger("" + (k + 1))));
        }
        return result.doubleValue();
    }
}
