package com.mnp.dynamic;

import java.util.HashMap;
import java.util.Map;

public class StolenDroneEx
{
    public static int findUniqueDeliveryId(int[] deliveryIds) {

        Map<Integer, Integer> idsToOccurrences = new HashMap<>();

        for (int deliveryId : deliveryIds) {
            if (idsToOccurrences.containsKey(deliveryId)) {
                idsToOccurrences.put(deliveryId, idsToOccurrences.get(deliveryId) + 1);
            } else {
                idsToOccurrences.put(deliveryId, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : idsToOccurrences.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0;
    }
    
    public static int findUniqueDeliveryId1(int[] deliveryIds) {

        int uniqueDeliveryId = 0;

        for (int deliveryId: deliveryIds) {
            uniqueDeliveryId ^= deliveryId;
        }

        return uniqueDeliveryId;
    }
}
