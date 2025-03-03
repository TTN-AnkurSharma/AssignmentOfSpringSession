package com.ttnAssignment;

interface BaseInterfaceLC
{
    void toShowInfo();
}
class ImplementedClassFirstLC implements BaseInterfaceLC
{
    @Override
    public void toShowInfo() {
        System.out.println("Implemented First class");
    }
}
class ImplementedClassSecondLC implements BaseInterfaceLC
{
    @Override
    public void toShowInfo() {
        System.out.println("Implemented Second Class");
    }
}
class ExampleClassLC
{

    void display(BaseInterfaceLC provided)
    {
        provided.toShowInfo();;
    }
}
public class ImplementationOfQues2 {
    public static void main(String[] args) {
       ImplementedClassFirstLC first = new ImplementedClassFirstLC();
        ImplementedClassSecondLC second = new ImplementedClassSecondLC();

        ExampleClassLC exampleClass=new ExampleClassLC();

        exampleClass.display(first);
        exampleClass.display(second);
    }
}

