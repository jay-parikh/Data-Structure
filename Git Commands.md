#### Keep Github Fork Repo upto date with Master
1. Add Master Repo url to your forked one which will be added using<br /> `git remote add_endpoint_name repo_url`
2. Get new updates from Master Repo<br /> `git pull add_endpoint_name branch_name `<br /> `e.g. git pull upstream master`
3. Send changes to forked repo<br /> `git push endpoint_name branch_name `<br /> `e.g. git push origin master`

#### Checkout in forked repo to different branch
`git checkout -b <branch> --track <remote>/<branch>`<br /> `e.g. git checkout -b master --track upstream/master`

##### Discard modified changes in git
`git checkout <path-to-file>`<br />
`git checkout -- .`
- Remove untracked files<br />
`git clean -f -d`
- List all branch with latest commit message<br />
`git branch -v -a`

#### Tagging in Git
##### Lets first start by explaining what is tag in git
A tag is used to label and mark a specific commit in the history. It is usually used to mark release points (eg. v1.0, etc.).  
Although a tag may appear similar to branch, a tag however does not change. It points directly to a specific commit in the history.  

You will not be able to checkout the tags if its not locally in your repository so first you have to `fetch` the tags to your local repository.

First make sure that the tag exists locally by doing  
`--all will fetch all the remotes.`  
`--tags will fetch all tags as well`  
`git fetch --all --tags --prune`  
Then check out the tag by running  
`git checkout tags/<tag_name> -b <branch_name>`


##### Git fetch remote branch   
`git fetch upstream master:refs/remotes/upstream/master`   
`git checkout -b master --track upstream/master`
