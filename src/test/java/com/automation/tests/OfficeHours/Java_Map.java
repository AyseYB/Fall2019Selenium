package com.automation.tests.OfficeHours;

import java.util.*;

public class Java_Map {

/*
Map interface ;does not accept any duplicate keys
-HashMap : key/value , can accept null
-hashTable : synchrinized // no null values
-linkedHashMap extends the hashMap
-TreeMap : sorted
 */
        public static void main(String[] args) {
            HashMap<String , String > user1 = new HashMap<>();
            user1.put("first name " , null);
            user1.put("last name " , "Smith");
            user1.put("Account Number ", "A6348764");
            user1.put("DOB", "02.20.1980");
            System.out.println("user1 = " + user1);

            LinkedHashMap<String , String >  user2 = new LinkedHashMap<>();
            user2.put("First Name " , "John");
            user2.put("Last Name " , null);
            user2.put("Last Name " , "White");
            user2.put("Last Name ", "Green");
            user2.put("Account Number" , "A47389937H");
            user2.put("DOB" , "12.02.1987");
            System.out.println("user2 = " + user2);
//user list
      //      List<Map<String, String >> listOfUsers = Arrays.asList(user1, user2);
            //or we can use hashMap
            List<HashMap<String , String >> users = Arrays.asList(user1, user2);

            HashMap<String , String > user3 =new HashMap<>();
            user3.put("Account Number" , "A654973");
            user3.put("DOB","12.08.1984");
            users.add(user3);
            //print account number for all users along with last name
            for ( HashMap<String , String > user: users ){
                System.out.println("Account Number: " + user.get("Account Number") + " | Last Name: " + user.get("Last Name"));
            }

        }
}
