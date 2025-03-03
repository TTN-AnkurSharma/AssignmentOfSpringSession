package com.ttnAssignment;

//This is class that is required by other classes

class RequiredClass
{
    private String name;

    public RequiredClass(){
        name="";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
class RequiringClass
{
     RequiredClass obj=new RequiredClass();
    //This shows tight coupling
    // and if any change is made in Required class it would require changes here too

    public void show()
    {
        obj.setName("Ankur Sharma");
        System.out.println(obj.getName());
    }
}

public class ImplementationOfQues1 {
    public static void main(String[] args) {

        RequiringClass obj=new RequiringClass();
        obj.show();

    }
}