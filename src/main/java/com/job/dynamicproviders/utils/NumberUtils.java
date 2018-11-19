package com.job.dynamicproviders.utils;

public class NumberUtils {
    public static boolean isNumeric(String str)
    {
        try
        {
            long a = Long.parseLong(str);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
