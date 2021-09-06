# DeliveryProject-Backend

This is the repository of Delivery Project Backend

## Team member

## ER diagram

## API designs

## Branches
* _main_ branch has the latest code
* Generally, prefer working in feature branches, then commit and start a pull request to the _main_ branch

## How to contribute
1. Fork this repository
2. Clone your forked repository to local
3. Add upstream
    * Contribute to the repository if you open in Github desktop (then the upstream is already added)
    * `git remote add upstream <this_repo_url>`
    * Check git `git remote -v`
        - Should have 
        ```
        upstream        https://github.com/Stephen-X123/deliveryProject.git (fetch)
        upstream        https://github.com/Stephen-X123/deliveryProject.git (push)
        ```
4. \[Optional\] Merge upstream to your main branch
    1. `git fetch upstream`
    2. `git checkout upstream/main`
    3. `git pull`
    4. `git checkout main`
    5. `git merge`
    6. `git push origin`
5. Checkout a new branch based on the latest code
    1. `git checkout -b OWLY-<your_name>-<function>-<version>`
    2. Made some changes
    3. `git -add <file1>`, `git -add <file2>` ..  (manually add all files you want to commit)
    4. `git commit -m “<your_branch_name>: messages”`
    5. `git push origin`
6. Create pull request
    1. We should have someone write some comments on the code

## Name rules:
We can follow [Google naming rule](https://google.github.io/styleguide/cppguide.html#Naming)
