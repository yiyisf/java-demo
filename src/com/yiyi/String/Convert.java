package com.yiyi.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by zgx on 2017-12-07.
 */
public class Convert {
    public static void main(String[] args) {
        String alpha = "Welcome, to, my, place, yiyi";

        //Comma-separated String to List Using Regex
        List<String> list = Arrays.asList(alpha.split("\\s*,\\s*"));
        System.out.println(list);

        //Convert CSV to Modifiable List
        list = new ArrayList<>(Arrays.asList(alpha.split("\\s*,\\s*")));
        System.out.println(list);
        list.add("new");
        System.out.println(list);

        //Convert List of Strings to CSV, use String,join
        List<String> list1 = Arrays.asList("Convert", "list", "to", "csv", "test", "!");
        String result = String.join("-", list1);
        System.out.println(result);

        result = String.join(", ", list1);
        System.out.println(result);



    }
}
