# WebCrawler Clean Code
 Assignment 1 from Clean Code --> Simple web crawler

v1 -->  We created simple web crawler that crawls to a specific depth and gives us links of crawled web pages!
        First method crawl is successfully tested, and I got Maven working.
        
v2 --> Added another method that gives us a String array with all specific headings (h1,h2,h3..) that you pick and outputs it to the console and saves it to the array!

v3 --> We added translator class to the project! It takes input array String and outputs to us translated Strings in the array on specific language! We got only German and English but in the future we can add others too!

We created a method to convert given input for an example "english" to "EN" because our DeepL API requires this specific input to translate the sentences!

We tested all of our methods and got 100% from class and methods, but from lines only 90%!

v4 -->

v5 --> Connected all classes successfully and got the program to save output.md file with all of our headings and links!

Created arrow builder method that creates an arrow specific for each depth of crawl!

Created headingBulder method that creates a given form of heading!

v6 --> Created Input Class that creates input object! Now user can write the website, depth, source language and target language.

v7 -->

[![Java CI with Maven](https://github.com/aoksy1/WebCrawler-Clean-Code/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/aoksy1/WebCrawler-Clean-Code/actions/workflows/maven.yml)
