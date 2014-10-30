/*
 *  30.10.2014 (C) KV RLP
 */
package de.kesper.workshop.tools;

/**
 *
 * @author kesper
 */
public class StringUtils {
    public static boolean isEmpty(String s) {
        if (s==null) return true;
        return "".equals(s.trim());
    }
}
