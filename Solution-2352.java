// 2352. Equal Row and Column Pairs

class Solution-2352 {
    public int equalPairs(int[][] grid) {

        int n = grid.length;
        Map<String,Integer> mapRow = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ; i < n ; ++i ){
            for( int j = 0 ; j < n ; ++j ){
                int num = grid[i][j];
                sb.append(num);
                sb.append(",");
            }
            String key = sb.toString();
            mapRow.put(key, mapRow.getOrDefault(key,0)+1);
            sb.setLength(0);
        }

        sb.setLength(0);

        Map<String,Integer> mapCol = new HashMap<>();
        for( int i = 0 ; i < n ; ++i ){
            for( int j = 0 ; j < n ; ++j ){
                int num = grid[j][i];
                sb.append(num);
                sb.append(",");
            }
            
            String key = sb.toString();
            mapCol.put(key, mapCol.getOrDefault(key,0)+1);
            sb.setLength(0);
        }

       int ans = 0;
        for (Map.Entry<String, Integer> entry : mapRow.entrySet()){
            String key = entry.getKey();
            if(mapCol.containsKey(key)){
                ans = ans + (entry.getValue()*mapCol.get(key));
            }
        }

        return ans;       
    }
}
