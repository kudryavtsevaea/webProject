package com.natcracker.domain.enims;

import java.util.EnumMap;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {
        SeasonService seasonService = new SeasonService();
        seasonService.mainMethod(Month.JANUARY);
        seasonService.mainMethod(Month.FEBRUARY);
        seasonService.mainMethod(Month.MARCH);
        seasonService.mainMethod(Month.APRIL);
        seasonService.mainMethod(Month.MAY);
        seasonService.mainMethod(Month.JUNE);
        seasonService.mainMethod(Month.JULY);
        seasonService.mainMethod(Month.AUGUST);
        seasonService.mainMethod(Month.SEPTEMBER);
        seasonService.mainMethod(Month.OCTOBER);
        seasonService.mainMethod(Month.NOVEMBER);
        seasonService.mainMethod(Month.DECEMBER);
    }
}
