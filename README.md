# WebCrawler Clean Code
 Assignment 1 from Clean Code --> Simple web crawler

v1 -->  We created simple web crawler that crawls to a specific depth and gives us links of crawled web pages!
        First method crawl is successfully tested, and I got Maven working.
        
v2 --> Added another method that gives us a String array with all specific headings (h1,h2,h3..) that you pick and outputs it to the console and saves it to the array!

v3 --> We added translator class to the project! It takes input array String and outputs to us translated Strings in the array on specific language! We got only German and English but in the future we can add others too!

We created a method to convert given input for an example "english" to "EN" because our DeepL API requires this specific input to translate the sentences!

We tested all of our methods and got 100% from class and methods, but from lines only 90%!

v4 --> Translator class connected and trying to get Output.md file to save our output to!

v5 --> Connected all classes successfully and got the program to save output.md file with all of our headings and links!

Created arrow builder method that creates an arrow specific for each depth of crawl!

Created headingBulder method that creates a given form of heading!

v6 --> Created Input Class that creates input object! Now user can write the website, depth, source language and target language.

v7 --> Tested input class. There is only crawler class left to test.

v8 --> Final version with 100% of methods tested and some bug fixes.

v9 --> Trying to automate JUnit tests.

v10 --> Bug fixes.

v11 --> Fine tuning and all bugs are fixed! Now we can test our program and get all headings from www.forbes.com on button click on Github.

[![Java CI with Maven](https://github.com/aoksy1/WebCrawler-Clean-Code/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/aoksy1/WebCrawler-Clean-Code/actions/workflows/maven.yml)

-Testing the build can be done directly through GitHub, by running the Build with Maven workflow. Running the workflow also assures that there are no failing Unit tests in the project.

-Running the project should be done through an IDE after downloading the zip file from GitHub. User should run the Driver class where the main method is, and follow the instructions in the console to succesfuly use the crawler and the translator.
     -Step 1 should be entering the website URL and it should be in the following format "www.sample-website.com"
     
     -Step 2 is choosing the desired depth to crawl to
    
     -Step 3 and Step 4 are entering the source and target language and they should be written as i.e. "english" ; "german" etc. it should always be in lowercase.
      To view the translations please open the output.md file in src/output path

-You can test the project by running the Test classes that are in the "tests/java" directory, or by checking the workflow run in the GitHub actions, under the "Build    with Maven" job.
