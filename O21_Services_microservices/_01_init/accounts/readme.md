
# Customer Account Microservices

### UP
```
curl --location 'http://localhost:9090/api'
```

### Create Customer Account

```
curl --location 'http://localhost:9090/api/create' \
--header 'Content-Type: application/json' \
--data-raw '{
      "name": "John Doe",
      "email": "john@example.com",
      "mobileNumber": "1234567890"
    }'
```

### Get Customer Account

```
curl --location 'http://localhost:9090/api/fetch?phoneNumber=12345678888'
```


### Update Customer Account

```
curl --location --request PUT 'http://localhost:9090/api/update' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "John Doe updated",
    "email": "john@example.com",
    "mobileNumber": "12345678888",
    "accounts": {
        "accountNumber": 11185867631,
        "accountType": "Savings",
        "branchAddress": "123 Main Street, New York"
    }
}'
```

### Delete Customer Account

```
curl --location --request DELETE 'http://localhost:9090/api/delete?phoneNumber=1234567890'
```
