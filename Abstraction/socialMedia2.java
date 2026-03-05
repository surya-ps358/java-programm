package Abstraction;



// 2. Facebook – Friends & Posts
// Instance variables: userId, name, friendsCount
// Static variable: platformName = "Facebook"

// Methods (all void):
// addFriend(String friendName) -> increases friendsCount and prints message
// createPost(String message) -> prints post details with user name
// displayProfile() -> prints profile info

class Facebook {
    private String userId;
    private String name;
    private int friendsCount;
    static String platFormName="Facebook";

    public Facebook(String userId,String name,int friendsCount)
    {
        this.userId=userId;
        this.name=name;;
        this.friendsCount=0;

    }
    
public void setName(String name) {
        this.name =name;
    }

public String getName() {
        return name;
    }

public void addFriend(String friendName){
    friendsCount++;
    System.out.println(getName() +","+friendName+" Now is your friend ");

}
public void createPost(String message){
    System.out.println(getName() +",Hi bro !!"+message);
}
public void displayProfile(){
System.out.println("Available on :"+platFormName);
System.out.println("User id is:"+userId);
System.out.println("user name is :"+name);
System.out.println("Total friends  is :"+friendsCount);

}


    
}

public class socialMedia2 {
    public static void main(String[] args) {
        Facebook user1=new  Facebook("101abc", "Imran",0);
        Facebook user2=new Facebook("102xyz", "Amar", 1);
        user1.addFriend(" Pandurang");
        user1.createPost(" how are you!");
        user1.displayProfile();
        System.out.println("-----------------------------------------");
        //user2.addFriend();
        user2.addFriend("Pandurang");  
        user2.createPost(" how about you !");
        user2.displayProfile();
    }
}
