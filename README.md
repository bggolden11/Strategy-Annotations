# Brian Goldenberg Strategy Design Pattern

## Design Choices
The annotation processing is done in the    ```Processor```. I also had a total of two different annotation for my design pattern. The first being the   ``` StrategyTrait   ```.
 This is uesd when implementating a strategy trait that will later be extended in the actual algorithm. I then had a    ```StategyImpl``` annotation which is used when creating the actual algorithm class. In the  ```Processor ``` class 
 I first check to make sure the  ``` StrategyTrait ``` has atleast one method. Since the whole point of this trait is to later implement an algorithm it needs atleast one method or else a error is logged. I then check to make the  ``` StrategyImpl``` 
 extend a  ``` StrategyTrait ``` this ensures that they have an algorithm that they are implementating. I used java reflection api to ensure it is following the correct design patterns. When a trait/class does not follow the DP guidlines logs are created
 using the logger. Further specific information of the Strategy design pattern can be seen in the comments of the respected classes. 

## Requirements to run program 
 - sbt
 - In order to get logging to work properly I needed to add following jar file in my classpath: slf4j-simple-1.6.2.jar
##  How to run
  - Pull the repo
   - Move into the directory 
   - Run the following command:
    
```console
   sbt run
```
The will compile and run the program. However, because there are multiple mains you will be prompted for which you would like to run. Please input 1,2 or 3. Input will not show up on the console. Press enter when completed. 
All three mains implement the strategy design pattern but slightly differently. They all use the costume annotations that I created.
## Sample Outputs
```console
Multiple main classes detected, select one to run:

 [1] Driver.MathMain
 [2] Driver.PayMain
 [3] Driver.WorkMainompile / previousCompile 0s



[info] running Driver.MathMain 
Welcome to Brian's Strategy design pattern implementation of math strategy:) 
------------------------------------------------------------

Would you like to:
1. add 
2. subtract
Input the number that corresponds to your desired operation
1
Input the first integer for the operation
4
Input the second integer for the operation
4
The output is 8
```

I did not to use any config files since I did not hard code any values

I also wanted to play around with bitbuckets pipeline ci tool so I added the  
```.yml``` hope that's okay.

```.gitignore``` file taken from http://goel.io/joe 

![Cat Reading Strategy](giphy.gif)
