# SimpleMerge

Project Description:
The goal of this project is to create SimpleMerge of which main functionality is to compare and merge the files. You may want to refer to the similar extant products such as WinMerge(http://www.winmerge.org, WinDiff, and BeyondCompare to understand the general concepts and usage of this kind of software. 

The MUST features of the software are shown in the following:

(1) Functionality of viewing/editing/saving files
At start-up, a main window with two edit panels (side-by-side) is displayed. On top of each edit panel, there are buttons labeled with "Load", "Edit", "Save". 
If the user presses a "Load" button, then the program should allow the user to choose a file in the file system, load the contents of the file, and displays the contents in the corresponding edit panel.
If the user presses a "Edit" button, then the program should allow the user to edit the strings shown in the edit panel.
If the user presses a "Save" button, then the program should save the edited content into the file

(2) Functionality of comparing two files
The main window has a "Compare" button. If the button is pressed, then the program should display the different lines with a colored font/background. The comparison is done line by line. Your comparison result should be same as the one generated from "diff" program. The "diff" program is a utility comparing two files using "Longest common subsequence(LCS)" algorithm. 

(3) Functionality of merging two files
The user should be able to traverse the blocks indicating the differences after the comparison and merge the differences. There are two basic merge buttons. “Copy to Right” button copies the selected block in the left panel to the file shown in the right panel. Similarly, “Copy to Left” button does to the file shown in the left panel. Note that series of executions of the merge operations will make the corresponding blocks be identical.
