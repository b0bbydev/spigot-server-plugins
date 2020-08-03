<img src="https://avatars1.githubusercontent.com/u/4350249?s=280&v=4" height="100" align="right">

# Project Summary
This project is an example of some entry level Java programming using Minecraft. It contains examples of object oriented programming fundamentals such as Instantiation, Inheritance, Abstraction etc.

This was a project done for some self practice along with my interest in video games. Minecraft is a great choice as it allows you to "visualize" your code quite quickly, as you make changes and modify your program. The <a href="https://hub.spigotmc.org/javadocs/spigot/">Spigot API Documentation</a> also makes it very user-friendly for developers to interact with.


## What It Includes
A server ran on your localhost - which can be configured to allow players to connect. <a href="#">see how here</a>

Some examples of how to use the <a href="https://www.spigotmc.org/wiki/spigot/">Spigot API</a> to modify/create features in Minecraft!

Lots of commented code to allow other beginners with similar interests, to try and understand what each line of code is doing. (This is also to help me really understand the Java programming language - and makes the code easier to come back to).

## Server Setup
To setup the server you will need to run the BuildTools.jar, which will generate a new freshly compiled jar to use for your server.


##### Prerequisites
* Java 8 or above - <a href="#">get it here</a>

* Git - <a href="#">get it here</a>

* BuildTools.jar - <a href="https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar.">get it here</a>


##### Running BuildTools
1. Place the BuildTools.jar in a dedicated folder. (e.x: C:\Users\\{name}\\Desktop\\{folder})
2. Open git bash on Windows and navigate the folder created from step 1
3. Once inside the folder on git bash enter the command: ``` java -jar BuildTools.jar ```

After entering the command, this should build the server.jar for you to use.


##### Installation
1. Place the freshly compiled jar after running BuildTools (``` spigot-*.jar ```), in a new folder. One where you wish to run the server from. (e.x: C:\Users\\{name}\\Desktop\\MinecraftServer\\{here})
2. In the same directory, paste the following code into a new text document and save it as ```'serverstart.bat'```

``` @echo off
    java -Xms1G -Xmx1G -XX:+UseConcMarkSweepGC -jar spigot-*.jar nogui
    pause
```
> spigot-*.jar will have to be named the exact same as newly compiled jar.

> -Xmx** can be used to specify how much RAM you wish to dedicate to the server. In this case it's 1GB.


After saving this ```'serverstart.bat'``` file, it can now be double-clicked and will start the server for you. You may have to agree to EULA on the first start-up. After agreeing, double-click your .bat file again, and the server should start again with no issues.


Congratulations! You have set up a Minecraft server to operate on your localhost. In order for others to connect to it - <a href="#">see here</a>.