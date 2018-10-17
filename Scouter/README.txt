Scouter made and maintained by Hans Hoelzer. (Atleast for now) 

- - - Config Layout - - -
weight1,weight2,weight3,weightN
label1,label2,label3,labelN
MasterListName.txt
- - - - - - - - - - - - -
Weights are used when using the team sorting function, enter how much you want each point scored in each section to be worth, matches up with the labels below it. 

Labels are what the match points are displayed as, for example (Switch,Scale,Auto). If there aren’t enough labels for the data in the match, the data will NOT be displayed. If there isn’t enough data for all the labels to be shown, the data less labels will not be displayed either.

The MasterListName.txt is the name you want the list that the program is running from and saving to to have. If the list isn’t found, no data will be displayed in the program. However if data is added to the list, a list will be created under that name. 

- - - File Layout - - -
Scouter |
	|JavaStuff
	|	|Driver.class
	|	|Driver.java
	|	|Filestuff.class
	|	|Filestuff.java
	|	|main.class
	|	|main.java
	|	|Match.class
	|	|Match.java
	|	|Mergesort.class
	|	|Mergesort.java
	|	|Team.class
	|	|Team.java
	|Uploads
	|	|[Any files to be uploaded]
	|Lists
	|	|[Any created lists, or lists to be read]
	|config.txt
	|README.txt
- - - - - - - - - - - - 
This is the hierarchy of the app, nothing you need to change will be located in the JavaShtuff folder, unless you are trying to change the app itself. 

- - - Function Outlines - - -
d.addTeamManual -> Manually add a match for a team to the list
d.addTeamPhone -> Upload a formatted list made by the scouter phone app, file should be in 	the Uploads folder. 
d.sortTeams -> Sort the list of teams be either number or rating. Rating is decided by the 	weighting in the config file and the rating for each match is averaged. 
d.printTeams -> Print out all the teams in the list, along with the matches and scores for 	each match. 
d.writeTeams -> Save the team list to the list specified to the config file in the Lists  	folder.
d.searchTeams -> Display one team and all its matches. 
- - - - - - - - - - - - - - -
 




 


