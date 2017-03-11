#Reference Material

##git Command Line Interface Commands
Command | Description
--- | ---
`git clone <git_url> [target_directory]` | Clones the specified repository into the target directory. If the target directory is not specified, git will name it based on the git repository name.  
`git add [file]` | Stages the file in its current state to be committed. Keep in mind that any changes made to the file afterwards are not staged.  
`git add -A` | Stages all modified and untracked files to be committed.  
`git commit -m [commit_message]` | Commits the staged files with a specifed commit message. Since the message will most likely contain spaces, don't forget to wrap it in quotation marks.  
`git push` | Pushes your local commits to the remote.  
`git pull` | Pulls the commits from the remote.  
`git reset [file]` | Unstages a file previously staged to be committed. This would be used if you accidentally added a wrong file.  
`git status` | Displays the status of your local repository compared to the remote repository, along with and files that are untracked, modified, or staged.  
`git diff` | Displays a difference report of the differences between your unstaged changes and the HEAD.  
`git diff staged` | Displays a difference report of the differences between your staged changes and the HEAD.  
`git log` | Displays a log of all commits.  
`git show [commit]` | Displays a difference report of the differences between the specified commit and the previous commit. Specify the commit by using 5 or more characters of the commit hash.  

##General
[Text Recognition](https://developers.google.com/vision/text-overview)  
[Material Design Guidelines](https://material.io/guidelines/)

##Android
[Geofence Reference](https://developer.android.com/training/location/geofencing.html)

##iOS
