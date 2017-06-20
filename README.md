### XML Parser for Salesforce Role and relationship between them. ###

The technologies used here are :-

	-Java version "1.8.0_121"
	-NetBeans IDE 8.2
	-Operating System : Windows
	-Apache Maven 3


### This program does the following : ###


1. Unzip file using java.util.zip and Access folder created by zip file.
2. Iterate over all the files present in a specific directory.
3. Reads all the <label> tag which are inside the <field> tags and display them on console.
4. Translate the english text in the Desired languages with the help of language codes availabe here.

The JAVA files are located in :
```
src/main/java/com/geminidsystems/XMLtoCSV/
```


### Steps to Run ###


1. Clone all the files to your system
2. Install NetBeans IDE 8.2 from [here](https://netbeans.org/) on your system.
3. Create a folder in C drive and named it as XMLtoCSV
4. Put all your files in this XMLtoCSV folder.
5. You can get `ObjectDefinition.zip` [here](https://drive.google.com/file/d/0Bw9MUzqrEugKVVl6anpVSmNHT0k/view) ,download it.
6. Put the `ObjectDefinition.zip` folder in `C:` Drive and the folder should follow the proper structure i.e. on extracting it should have a directory structure `ObjectDefintion\unpackaged\objects` 
7. Open NetBeans IDE 8.2, Click on file inside toolbar. file => Open Project
						- New window will open here
						- Go to C drive and Select XMLtoCSV folder
						- Now in the right side you will see your project
						- Right Click with your mouse and Select "Clean and Build"
						- Now Select Run the Project by Right Clicking with your mouse.



### Project Structure: ### 


The major important files in the project are showing here with their purpose:
 
a) /.git    :   .git folder contain all the information that is necessary for project in version control and all the information about commits remote repo address etc.All are present in this folder. It also contain a log which store your commit history so that you can roll back to history. If we delete .git then project will no longer be a git project. It is created by git init command. 

b) /src	: package which contains the whole source code. It is mainly classified in:
		/main : The main package will contain some sub-packages with the .java files.
	
   For example:
   /main/java/com/geminidsystems/xmlparser/abc.java 		(Java File)


c) .gitignore: contains files which we don’t want git to track.
	For example: /target 

d) pom.xml: an XML file that contains information about the project and configuration details used by   Maven to build the project. Examples for this is the build directory, which is target; the source directory, which is src/main/java; the test source directory, which is src/test/java.

e) README.md : A README file can have license, contribution guidelines and code to install and run project so it will contain all such details.

f) Diagrams : Diagram related to project like flow chart.

g) XML.java : - Iterate over all the files present in a specific directory.
              - Reads all the <label> tag which are inside the <field> tags and display them on console.
              
h) Translator.java : Translate the english text in the Desired languages with the help of language codes availabe.

i) Project_Plan_XML_Parser : word file Contains project plan for xML Parser for Salesforce Role and relationship between them.