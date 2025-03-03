package com.ttnAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ImplementationOfQues3_4_5_6 {
    public static void main(String[] args) {
        ApplicationContext applicationContext=SpringApplication.run(ImplementationOfQues3_4_5_6.class,args);
        
        ExampleClass exampleClass= applicationContext.getBean(ExampleClass.class);
      
        System.out.println("Bean details "+exampleClass);
        
        exampleClass.display();
    }

}

interface BaseInterface
{
    void toShowInfo();
}

@Component("First Implementation")
class ImplementedClassFirst implements BaseInterface
{
    @Override
    public void toShowInfo() {
        System.out.println("Implemented First class");
    }
}
@Component("Second Implementation")
//@Primary can either make primary bean
class ImplementedClassSecond implements BaseInterface
{
    @Override
    public void toShowInfo() {
        System.out.println("Implemented Second Class");
    }
}
@Component
class ExampleClass
{
    BaseInterface baseInterface;

    @Autowired
    public ExampleClass(@Qualifier("First Implementation") BaseInterface baseInterface) {
        this.baseInterface = baseInterface;
    }

    
    void display()
    {
        baseInterface.toShowInfo();;
    }
}