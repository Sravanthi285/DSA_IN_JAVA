class Solution {
    private static final int MOD = 1_000_000_007;
    public int numberOfSets(int n, int k) {
        int N = n + k - 1;
        int R = 2 * k;

        if (R > N) return 0;

        // Compute C(N, R) % MOD using modular arithmetic
        long num = 1;
        long den = 1;

        for (int i = 1; i <= R; i++) {
            num = (num * (N - i + 1)) % MOD;
            den = (den * i) % MOD;
        }

        return (int) ((num * modInverse(den, MOD)) % MOD);
    }

    private long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    private long power(long base, int exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
        
        
    }
}