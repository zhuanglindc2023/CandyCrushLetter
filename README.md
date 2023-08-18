# CandyCrushLetter
# The Project is constructed by maven. It will need use Maven to build the solution.
# 1. To Build the Project: Please Run "mvn install". It will build into jar artifact into "target" folder named "CandyCrushLetter-1.0.jar"
# 2. To Run the project after build
      a. Navigate to the "target" folder.
      b. run "java -jar CandyCrushLetter-1.0.jar FILE_PATH"
          * FILE_PATH is the path of input txt file with the characters list.
          e.g. "java -jar CandyCrushLetter-1.0.jar c:\input.txt"
# 3. There a guided navigator asking for additional inputs.
     - Please choose your options:
        1. Remove duplicated character directly.
        2. remove duplicated character with the one comes before it alphabetically.
        Please type '1' or '2', then press 'ENTER'
        (This is asking for type of Option mapping to 2 reqirements of the testing)
     - Please choose the threshold that AT LEAST how many duplicate characters to remove.The default value is 3.
        (This is asking for the level of duplication, meaning at least how many duplicated character will trigger the remove).
