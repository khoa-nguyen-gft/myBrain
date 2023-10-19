## [Main title](/README.md)

# CI/CD
+ [What is CI/CD?](#what-is-cicd)

# Github Action
+ [What is Github Action?](#what-is-github-action)
+ [What is difference between Git, Github and Github Action?](#what-is-difference-between-git-github-and-github-action)
+ [What Events (Workflow Triggers)?](#what-events-workflow-triggers)


# CircleCI
+ [What is difference between CircleCI and GitHub Actions?](#what-is-difference-between-circleci-and-github-actions)
+ [What is CircleCI?](#what-is-circleci)
    + [What is Commands in CircleCI?](#what-is-commands-in-circleci)
    + [What is Executors in CircleCI?](#what-is-executors-in-circleci)
    + [What is Jobs in CircleCI?](#what-is-job-in-circleci)
    + [What is Workflows in CircleCI?](#what-is-workflows-in-circleci)
    + [What is Pipelines in CircleCI?](#what-is-pipelines-in-circleci)
+ [What is difference Environment Variables and Pipeline Variables in CircleCI?](#what-is-difference-environment-variables-and-pipeline-variables-in-circleci)
+ [What is Orbs?](#what-is-orbs)


    
----

## What is CI/CD?

![Alt text](images/cicd.png)

[Table of Contents](#github-action)

### What is Github Action?
- GitHub Actions is a CI/CD tool that provides automation and integration capabilities for software development workflows, helping developers streamline their processes and increase the efficiency of their development pipelines.


![Alt text](images/GitHub%20Action.png)

[Table of Contents](#github-action)

## What is difference between Git, Github and Github Action?
- **Git**: Git is a distributed version control system for tracking changes in source code during software development. 


![Alt text](images/git.png)

- **GitHub**: GitHub is a web-based Git repository hosting service, which offers all of the distributed revision control and source code management (SCM) functionality of Git as well as adding its own features. 

![Alt text](TbfUF.png)

[Table of Contents](#github-action)


## What is difference between Workflow, Job and Step?

![Alt text](images/What%20is%20difference%20between%20Workflow,%20Job%20and%20Step2.png)

![Alt text](images/%20What%20is%20difference%20between%20Workflow,%20Job%20and%20Step.png)

[Table of Contents](#github-action)


## What Events (Workflow Triggers)?
-  workflow triggers, are specific occurrences or actions that can trigger the execution of a workflow. When an event happens, GitHub automatically starts the associated workflow, allowing you to automate various tasks, such as building, testing, and deploying code.

    + **workflow_dispatch** is a special event that allows you to trigger a workflow manually
    ![Alt text](images/workflow_dispatch.png)

    + **Push**: This event is triggered when someone pushes code to a repository's default branch or any other specified branch.
    ![Alt text](images/Push.png)

![Alt text](images/event.png)


[Table of Contents](#github-action)


# CircleCI

### What is difference between CircleCI and GitHub Actions?

- **CircleCI and GitHub Actions** are both popular CI/CD (Continuous Integration/Continuous Delivery) tools, but they have some differences in terms of their setup, features, and integration:

![Alt text](./images/CircleCI%20and%20GitHub%20Actions.png)

[Table of Contents](#github-action)


### What is CircleCI?
- Trong thư mục root của dự án, bạn tạo ra một thư mục có tên là .circleci, trong đó sẽ chứa file config.yml. Bạn sẽ giao tiếp với CircleCI thông qua file config này.

![Alt text](image.png)

[Table of Contents](#github-action)


### What is Commands in CircleCI?

- **commands** cũng sẽ là nơi bạn định nghĩa những steps để thực hiện các công việc mà sau đó bạn có thể sử dụng nó ở bất cứ đâu.

```yaml
commands:
  sayhello:
    description: "A very simple command for demonstration purposes"
    #parameters: Một mảng parameters sẽ được sử dụng trong các steps.
    parameters:
      to:
        type: string
        default: "Hello World"
    # steps: Danh sách các bước sẽ thực hiện trong command.
    steps:
      - run: echo << parameters.to >>
```
[Table of Contents](#github-action)

### What is executors in CircleCI?
- **executors** sẽ là nơi bạn khai báo các cài đặt cho từng môi trường

![Alt text](image-1.png)

```yaml
executors:
  docker-executor:
    - image: circleci/ruby:2.7.1
    - image: mongo:2.6.8-jessie
  machine-executor:
    - image: ubuntu-1604:201903-01

jobs:
  build-with-docker:
    executor: docker-executor
    steps:
      - run: echo "Buiding with docker executor"
  build-with_machine:
    executor: machine-executor
    steps:
      - run: echo "Buiding with machine executor"

```

[Table of Contents](#github-action)


### What is job in CircleCI?

 - **job** trong CircleCI chính là một danh sách các hành động (steps) để hoàn thành một công việc. Những công việc đó có thể là kéo code mới nhất về, run test...Tại đây bạn cũng có thể khai báo môi trường (executors) để thực hiện các hành động 

```yaml
jobs:
  build:
    docker:
      - image: circleci/ruby:2.7.1
        environment:
          RAILS_ENV: test
    steps:
      - checkout
      - run: bundle exec rails rspec
  deploy:
    machine: true
    steps:
      - add_ssh_keys:
          fingerprints:
            - $FINGERPRINT
      - run:
          name: Deploy over SSH
          command: ssh -o StrictHostKeyChecking=no -v $SSH_USER@$SSH_HOST "sh ./deploy.sh $CIRCLE_BRANCH"

```

[Table of Contents](#github-action)


### What is Workflows in CircleCI?
- Trong khi job là một tập hợp các steps để hoàn thành một công việc thì workflow sẽ là tập hợp các jobs để thực hiện một công việc lớn hơn

```yaml

workflows:
  version: 2
  build_deploy:
    jobs:
      - build
      - deploy:
          requires:
            - build
          filters:
            branches:
              only: master
```

[Table of Contents](#github-action)


### What is pipelines in CircleCI?

- Theo định nghĩa của CircleCI thì một pipeline sẽ là tập hợp của tất cả những cấu hình để bạn hoàn thành công việc của mình. Nói cách khác, một pipeline sẽ chứa nhiều workflows, mỗi workflow sẽ lại có nhiều jobs và mỗi job sẽ lại thực thi nhiều steps khác nhau. Như vậy, tất cả những gì chúng ta đã tìm hiểu ở trên đều nằm trong một pipeline.

[Table of Contents](#github-action)


### What is difference Environment Variables and Pipeline Variables in CircleCI?
- **Environment Variables**: Đây là các biến môi trường trong những container hay machine. Chúng có thể được sử trong các steps hoặc trong khi quá trình khởi tạo các executor diễn ra

```yaml
jobs:
  build:
    docker:
      - image: circleci/ruby:2.7.1
        environment:
          ENTRY_VARIABLE: my_environment_variable
    steps:
      - checkout
      - run: echo $ENTRY_VARIABLE           # Wil not print out anything
      - run: echo $PROJECT_SETTING_VARIABLE # Will print out the value you set in project setting

```

- **Pipeline Variables:** không tồn tại trong các container hay virture machine, nó đơn giản chỉ là các biến chứa giá trị mà bạn có thể dùng được ở bất cứ đâu trong file config.

```yaml
parameters:
  image-tag:
    type: string
    default: "latest"
  workingdir:
    type: string
    default: "~/main"

jobs:
  build:
    docker:
      - image: circleci/ruby:<< pipeline.parameters.image-tag >>
    environment:
      IMAGETAG: << pipeline.parameters.image-tag >>
    working_directory: << pipeline.parameters.workingdir >>
    steps:
      - run: echo "Image tag used was ${IMAGETAG}"
      - run: echo "$(pwd) == << pipeline.parameters.workingdir >>"

```

[Table of Contents](#github-action)



### What is Orbs?

![Alt text](image-2.png)

```yaml
orbs:
  slack: circleci/slack@4.2.0
jobs:
  notify:
    docker:
      - image: cimg/base:stable
    steps:
      - slack/notify:
          custom: |
            {
              "blocks": [
                {
                  "type": "section",
                  "fields": [
                    {
                      "type": "plain_text",
                      "text": "*This is a text notification*",
                      "emoji": true
                    }
                  ]
                }
              ]
            }
          event: always
workflows:
  send-notification:
    jobs:
      - notify:
          context: slack-secrets

```

[Table of Contents](#github-action)
