package Abstraction;

import java.util.Scanner;

// 1. Twitter – User & Tweet System

// Instance variables: userId, username, followersCount
// Static variable: platformName = "Twitter"
// Methods (all void):
// postTweet(String content) -> prints tweet with username
// followUser(String anotherUser) -> prints follow action & increases followersCount
// displayUserInfo() -> prints user details

class Twitter {
    private String userId;
    private String username;
    private int followersCount;
    static String platformName = "Twitter";

    public Twitter(String userId, String username) {
        this.userId = userId;
        this.username = username;
        this.followersCount = 0;
    }

    public void postTweet(String content) {
        System.out.println(username + "" + content);

    }

    public void followUser(Twitter anotherUser) {
        System.out.println(username + " followed " + anotherUser.username);
        anotherUser.followersCount++;
    }

    public void displayUserInfo() {
        System.out.println("Platform Name :" + platformName);
        System.out.println("user id is :" + userId);
        System.out.println("username is :" + username);
        System.out.println("the total followers is :" + followersCount);
    }

    public Twitter createUser() {
        return new Twitter(userId, username);
    }
}

public class socialMedia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        {
            // String
        }
        // Twitter user1=new Twitter("101df", "surya");
        // Twitter user2=new Twitter("102abc","imran");

        // user1.followUser(user1);
        // user1.postTweet(" Hi i am very exited to in twitter !!");
        // user1.displayUserInfo();

        // System.out.println("--------------------------------------");
        // user2.followUser(user1);
        // user2.postTweet(" hi i am very exited to in twitter");
        // user2.displayUserInfo();
        sc.close();
    }
}
