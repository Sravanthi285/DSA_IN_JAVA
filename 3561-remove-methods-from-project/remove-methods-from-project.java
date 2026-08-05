class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] inv : invocations) {
            graph.get(inv[0]).add(inv[1]); // inv[0] calls inv[1]
        }

        
        
        boolean[] isSuspicious = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(k);
        isSuspicious[k] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (!isSuspicious[v]) {
                    isSuspicious[v] = true;
                    queue.offer(v);
                }
            }
        }

        // Step 3: Check if any non-suspicious method calls a suspicious method
        for (int[] inv : invocations) {
            int u = inv[0]; // caller
            int v = inv[1]; // callee
            
            // Non-suspicious caller calling a suspicious method
            if (!isSuspicious[u] && isSuspicious[v]) {
                List<Integer> allMethods = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    allMethods.add(i);
                }
                return allMethods; 
            }
        }

        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isSuspicious[i]) {
                result.add(i);
            }
        }

        return result;
        
    }
}