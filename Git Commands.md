#### Keep Github Fork Repo upto date with Master
1. Add Master Repo url to your forked one which will be added using<br /> `git remote add_endpoint_name repo_url`
2. Get new updates from Master Repo<br /> `git pull add_endpoint_name branch_name`
3. Send changes to forked repo<br /> `git push endpoint_name branch_name `<br /> `e.g. git push origin master`

#### Checkout in forked repo to different branch
**`git checkout -b <branch> --track <remote>/<branch>`**<br /> `e.g. git checkout -b master --track upstream/master`

##### Discard modified changes in git
`git checkout <path-to-file>`<br />
`git checkout -- .`
- Remove untracked files<br />
`git clean -f -d`
- List all branch with latest commit message<br />
`git branch -v -a`
