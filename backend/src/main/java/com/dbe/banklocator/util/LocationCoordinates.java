package com.dbe.banklocator.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class LocationCoordinates {

    private final Map<String, double[]> coordinatesMap = new HashMap<>();

    public LocationCoordinates() {
        coordinatesMap.put("bole", new double[]{9.0240, 38.7616});
        coordinatesMap.put("kality", new double[]{8.9444, 38.7800});
        coordinatesMap.put("piassa", new double[]{9.0370, 38.7500});
        coordinatesMap.put("megenagna", new double[]{9.0169, 38.8003});
        coordinatesMap.put("merkato", new double[]{9.0376, 38.7400});
        coordinatesMap.put("kazanchis", new double[]{9.0153, 38.7596});
        coordinatesMap.put("sarbet", new double[]{9.0105, 38.7403});
        coordinatesMap.put("asko", new double[]{9.0705, 38.6900});
        coordinatesMap.put("lideta", new double[]{9.0200, 38.7400});
        coordinatesMap.put("yeka", new double[]{9.0500, 38.8200});
        coordinatesMap.put("akaki", new double[]{8.9167, 38.7333});
        coordinatesMap.put("gullele", new double[]{9.0800, 38.7200});
        coordinatesMap.put("nifas silk", new double[]{9.0000, 38.7600});

        coordinatesMap.put("bahir dar", new double[]{11.6000, 37.3833});
        coordinatesMap.put("gondar", new double[]{12.6000, 37.4667});
        coordinatesMap.put("mekelle", new double[]{13.4967, 39.4753});
        coordinatesMap.put("hawassa", new double[]{7.0667, 38.4833});
        coordinatesMap.put("dire dawa", new double[]{9.5931, 41.8661});
        coordinatesMap.put("jimma", new double[]{7.6667, 36.8333});
        coordinatesMap.put("adama", new double[]{8.5400, 39.2700});
        coordinatesMap.put("harar", new double[]{9.3111, 42.1225});
        coordinatesMap.put("dessie", new double[]{11.1333, 39.6333});
        coordinatesMap.put("arba minch", new double[]{6.0333, 37.5500});
    }

    public double[] getCoordinates(String districtOrCity) {
        return coordinatesMap.getOrDefault(districtOrCity.toLowerCase(), new double[]{9.03, 38.74});
    }
}
