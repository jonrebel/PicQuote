package com.example.picquote2;

public class QuoteGenerator {
    static String[] quotes =
            {"The journey of a thousand miles begins with one step...Lao Tzu",
                    "That which does not kill us makes us stronger...Friedrich Nietzsche",
                    "Life is what happens when youre busy making other plans...John Lennon",
                    "When the going gets tough, the tough get going...Joe Kennedy",
                    "You must be the change you wish to see in the world...Mahatma Gandhi",
                    "You only live once, but if you do it right, once is enough....Mae West",
                    "Tough times never last but tough people do...Robert H. Schuller"};




    public static String getRandomQuote(){
        String quote = "";
        for(int i = 0; i < quotes.length;i++){
            int pointer = (int) Math.floor(Math.random()*7);
            quote = quotes[pointer];
        }
        return quote;
    }
}
