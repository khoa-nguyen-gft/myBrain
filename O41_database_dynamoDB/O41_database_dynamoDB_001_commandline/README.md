# How to manipulate tables?

- 

```bash
aws sso login --profile gft

aws sts get-caller-identity

aws iam list-roles --query "Roles[?AttachedPolicies[?PolicyName=='AmazonDynamoDBFullAccess']]" --output json


aws iam list-roles --query "Roles[?AttachedPolicies[?PolicyName=='AmazonDynamoDB']]" --profile gft

```
- **List Tables**:

```bash

aws dynamodb list-tables --profile gft
```

```json
// Json Result
{
    "TableNames": [
        "Accounts",
        "AppSyncCommentTable-TeC7mMxc",
        "AppSyncEventTable-TeC7mMxc",
        "Balances",
        "BankFast-master-Accounts"
        ]
}
```

- **Example**: 
```bash 
sh-3.2$ aws dynamodb list-tables --query "TableNames[]" --profile bf  --output json > table_list.json
```

- **Query all content of Tables**:

```bash
aws dynamodb scan --table-name --table-name MyTable --profile your-sso-profile-name
```

- **Example**: 
```bash 
sh-3.2$ aws dynamodb  scan --table-name "BankFast-vndev-Cards" --profile bf  --output json > scan_table_content.json
```


- **Delete Tables**:

```bash
# Delete the table
aws dynamodb delete-table --table-name MyTable --profile your-sso-profile-name
```

- **Create Tables**:

```bash
# Create a table
aws dynamodb create-table \
    --table-name MyTable \
    --attribute-definitions AttributeName=Id,AttributeType=N \
    --key-schema AttributeName=Id,KeyType=HASH \
    --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5
```