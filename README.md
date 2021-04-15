
About

This repository contains the implementation of a distributed account system which is implemented with Lia Yang snapshot algorithm. Here, 2 different accounts are considered, treated as processes. They send random amount of money to each other without leading to any negative account balance. This has been implemented in Java

INSTRUCTIONS TO RUN THE PROGRAM

Compiling instructions:
1 Import the source code in Eclipse as a Maven Project
2 Right click on the Click on the project and click run and then perform Maven Clean
 
3 Now again right click and do a Maven install this will create the Build and all complied file will be placed under target directory
4 We can use these compile file and can run our Program as per the instruction provided below






Running instruction:

Step1- Extract the Jar file and save it in the Local directory
Step2- Go to the target directory where we have the complied file (class file)
Step3- Open CMD and navigate to Class directory
Step4 Type the command java Followed by the package name as showing in the below example
Provide the Input related to various process and timestamp


 


Output:

C:\Users\raktim.saikia\eclipse-workspace\LiaYangAssignment\target\classes>java LiaYang.LiaYangAssignment.App

##########################################
        Lai Yang Global Snapshot Algoritham
##########################################
Enter initial value for process P1:
1000
Enter initial value for process P2:
2000
Enter total number of timestamps
10
Enter total number of messages
3
Processes Initialized Successfully.
Initial Value P1 = 1000
Initial Value P2 = 2000
Total System Value = 3000
##########################################
Enter values for message 1
Amount:
100
From Process[1 OR 2]:
1
To Process[1 OR 2]:
2
Start Timestamp[0-10]:
0
End Timestamp[0-10]:
4
Enter values for message 2
Amount:
200
From Process[1 OR 2]:
2
To Process[1 OR 2]:
1
Start Timestamp[0-10]:
3
End Timestamp[0-10]:
6
Enter values for message 3
Amount:
200
From Process[1 OR 2]:
1
To Process[1 OR 2]:
2
Start Timestamp[0-10]:
3
End Timestamp[0-10]:
7
==========================
|  Timestamp   P1      P2 |
==========================
|   T1  |  900  |  2000  |
==========================
|   T2  |  900  |  2000  |
==========================
|   T3  |  900  |  2000  |
==========================
|   T4  |  700  |  1800  |
==========================
|   T5  |  700  |  1900  |
==========================
|   T6  |  700  |  1900  |
==========================
|   T7  |  900  |  1900  |
==========================
|   T8  |  900  |  2100  |
==========================
|   T9  |  900  |  2100  |
==========================
|   T10  |  900  |  2100  |
Enter RED message index[1-3]:
3
Local State P1: 700
Local State P2: 1900
Total of sent messages from P1 to P2:  300
Total of messages received from P1 to P2:  100
Total of sent messages from P2 to P1:  200
Total of messages received from P2 to P1:  0
Total Initial Value 3000 == Total Snapshot Value 3000
Initial system value is EQUAL to snapshot value hence it is a consistent global state.

##########################################
        END OF PROGRAM
##########################################

C:\Users\raktim.saikia\eclipse-workspace\LiaYangAssignment\target\classes>




Supported Environments
The program is built, executed and tested Windows Machine having Java 8 installed on it.
It was compiled by using JDK 1.8 version
