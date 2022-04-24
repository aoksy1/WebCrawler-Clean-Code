# WebCrawler Clean Code
 Assignment 1 from Clean Code --> Simple web crawler

v1 -->  We created simple web crawler that crawls to a specific depth and gives us links of crawled web pages!
        First method crawl is successfully tested, and I got Maven working.
        
v2 --> Added another method that gives us a String array with all specific headings (h1,h2,h3..) that you pick and outputs it to the console and saves it to the array!

v3 --> We added translator class to the project! It takes input array String and outputs to us translated Strings in the array on specific language! We got only German and English but in the future we can add others too!

We created a method to convert given input for an example "english" to "EN" because our DeepL API requires this specific input to translate the sentences!

We tested all of our methods and got 100% from class and methods, but from lines only 90%!

v4 --> Connected translator class with crawler. Now it can translate all the headings that crawler sends to the class.

v5 --> ArrowBuilder method is now working. It gives us simple arrow (-->) specific for the depth that crawler is getting headings from. Now when we run the code it saves everything to a output.md file and the data is formatted in the way given from the moodle.
