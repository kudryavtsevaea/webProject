package com.natcracker.domain.enims;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.concurrent.Callable;

public class SeasonService {
    private Season[] seasons = Season.values();
    private Month[] months = Month.values();

    private EnumMap<Month, Callable<Season>> enummap1;

    public SeasonService() {
       enummap1 = new EnumMap<>(Month.class);

        enummap1.put(months[months.length - 1], () -> Season.WINTER);

        int finalK = 0;
        for (int i = 1; i < months.length ; i++){
            if (i%3 == 0) {
                finalK++;
                int finalK1 = finalK;
                enummap1.put(months[i - 1], () -> seasons[finalK1]);
            }
            else{
                int finalK1 = finalK;
                enummap1.put(months[i - 1], () -> seasons[finalK1]);
            }
        }
    }

    void mainMethod(Month month) throws Exception {
        Season season = enummap1.get(month).call();
        System.out.println(months[month.ordinal()] + " - " + season.getDescription());

    }
}
