package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2021/10/1
 * 旅行终点站
 */
public class DestinationCity {
    /**
     * @param paths paths[i]=[cityAi,cityBi]表示该线路将会从cityAi直接前往cityBi
     * @return 旅行终点站，即没有任何可以通往其他城市的线路的城市
     */
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
        }
        String start = paths.get(0).get(0);
        while (map.get(start) != null) {
            start = map.get(start);
        }
        return start;
    }
}
