# Welcome to your CDK TypeScript project!

> https://cdkworkshop.com/20-typescript.html

You should explore the contents of this project. It demonstrates a CDK app with an instance of a stack (`WorkshopStack`)
which contains an Amazon SQS queue that is subscribed to an Amazon SNS topic.

The `cdk.json` file tells the CDK Toolkit how to execute your app.

* `cdk synth` ... CloudFormationテンプレートをつくる
* `cdk bootstrap` ... デプロイ用のリソースつくる（このサンプルだとS3のバケットができていた）
* `cdk deploy` ... デプロイする
* `cdk diff` ... 差分表示
* `cdk destroy` ... リソースを削除する
