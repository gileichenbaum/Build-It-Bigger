package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeApi {

    private final static List<String> JOKES = new ArrayList<String>();
    private final static Random RANDOM = new Random(System.currentTimeMillis());

    static {
        JOKES.add("A husband and wife are trying to set up a new password for their computer. The husband puts, \"Mypenis,\" and the wife falls on the ground laughing because on the screen it says, \"Error. Not long enough.\"");
        JOKES.add("Teacher: \"Kids, what does the chicken give you?\"\n" +
                "Student: \"Meat!\"\n" +
                "Teacher: \"Very good! Now what does the pig give you?\"\n" +
                "Student: \"Bacon!\"\n" +
                "Teacher: \"Great! And what does the fat cow give you?\"\n" +
                "Student: \"Homework!\"");
        JOKES.add("Yo momma is so fat, I took a picture of her last Christmas and it's still printing.");
        JOKES.add("Yo momma is so fat when she got on the scale it said, \"I need your weight not your phone number.\"");
        JOKES.add("A boy is selling fish on a corner. To get his customers' attention, he is yelling, \"Dam fish for sale! Get your dam fish here!\" A pastor hears this and asks, \"Why are you calling them 'dam fish.'\" The boy responds, \"Because I caught these fish at the local dam.\" The pastor buys a couple fish, takes them home to his wife, and asks her to cook the dam fish. The wife responds surprised, \"I didn't know it was acceptable for a preacher to speak that way.\" He explains to her why they are dam fish. Later at the dinner table, he asks his son to pass the dam fish. He responds, \"That's the spirit, Dad! Now pass the f*cking potatoes!\"");
        JOKES.add("The teacher asked Jimmy, \"Why is your cat at school today Jimmy?\" Jimmy replied crying, \"Because I heard my daddy tell my mommy, 'I am going to eat that p*ssy once Jimmy leaves for school today!'\"");
        JOKES.add("Yo momma is so fat that when she went to the beach a whale swam up and sang, \"We are family, even though you're fatter than me.\"");
        JOKES.add("Do not be racist; be like Mario. He's an Italian plumber, who was made by the Japanese, speaks English, looks like a Mexican, jumps like a black man, and grabs coins like a Jew!");
        JOKES.add("What did God say when he made the first black man? \"Damn, I burnt one.\"");
        JOKES.add("Yo mamma is so ugly when she tried to join an ugly contest they said, \"Sorry, no professionals.\"");
        JOKES.add("Two old friends crossed paths after not seeing one another for almost a decade. \n" +
                "Utkarsh: \"What are you doing these days?\" \n" +
                "Sparsh: \"PHD.\" \n" +
                "Utkarsh: \"Wow! You're a doctor!\" \n" +
                "Sparsh: \"No, Pizza Home Delivery.\"");
        JOKES.add("Yo momma's so fat and old when God said, \"Let there be light,\" he asked your mother to move out of the way.");
        JOKES.add("I asked a Chinese girl for her number. She said, \"Sex! Sex! Sex! Free sex tonight!\" I said, \"Wow!\" Then her friend said, \"She means 666-3629.\"");
        JOKES.add("How do you blindfold a Chinese person? Put floss over their eyes.");
        JOKES.add("My friend thinks he is smart. He told me an onion is the only food that makes you cry, so I threw a coconut at his face.");
        JOKES.add("Q: What's the difference between a Jew and a boy scout?\n" +
                "A: A boy scout comes home from camp.");
    }

    public static String getJoke() {
        return JOKES.get(RANDOM.nextInt(JOKES.size()));
    }
}
