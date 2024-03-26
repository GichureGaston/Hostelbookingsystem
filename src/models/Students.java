package models;

public class  Students {
    private String name;
    private int id;
    private String registrationNumber;

    public Students(String name,int id, String registrationNumber){
        this.name=name;
        this.id=id;
       this. registrationNumber=registrationNumber;
    }


    public Students(String studentRegistrationD) {
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public String getRegistrationNumber(){
        return registrationNumber;
    }
}
