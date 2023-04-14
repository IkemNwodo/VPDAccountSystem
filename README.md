
# Bank API

This is a simple REST API for managing bank accounts. The API allows users to create accounts, deposit funds, withdraw funds, and transfer funds between accounts.
### Currently using this custom Account Number generator util [Generator.java](/VPDAccountSystem/src/main/java/com/ikem/vpda_ccount_system/util/Generator.java) to generate account numbers for new accounts. Will add ability to use last 10 digits of a user phone number, soon.

## Technologies Used
- Spring Boot 3.0.5
- Java 17
- MySQL database
- Spring Data JPA
- Spring Boot Validation
- Apache Maven 3.8.6
- Lombok

## API Endpoints
### Create Account
Creates a new bank account.
- Endpoint: POST /api/v1/account/create
- Request Body:





```json
{
    "firstName": "Ikemefuna",
    "lastName": "Nwodo",
    "bvn": "12345678902",
    "password": "1234567890",
    "emailAddress": "nwodofrank@gmail.com"
}
```

- Response Body:

```json
{
    "accountNumber": "0000000001",
    "accountName": "IkemefunaNwodo",
    "balance": 0.0,
    "transactions": []
}
```
### Deposit
Deposits funds into bank account.
- Endpoint: POST  /api/v1/account/deposit
- Request Body:
```json
{
    "amount": 100,
    "accountNumber": "0000000001"
}
```
- Response Body:

```json
{
    "amount": 100,
    "accountNumber": "0000000001",
    "currentBalance": 100.00,
    "message": "Deposit successful"
}
```
### Withdraw
Withdraws funds from a bank account.
- Endpoint: POST  /api/v1/account/withdraw
- Request Body:
```json
{
    "amount": 100,
    "accountNumber": "0000000001"
}
```
- Response Body:

```json
{
    "amount": 100,
    "accountNumber": "0000000001",
    "currentBalance": 0.00,
    "message": "Withdrawal successful"
}
```
### Transfer
Transfers funds between two bank accounts.
- Endpoint: POST  /api/v1/account/transfer
- Request Body:
```json
{
    "amount": 100,
    "sourceAccountNumber": "0000000001",
    "destinationAccountNumber": "0000000002"
}
```
- Response Body:

```json
{
    "amount": 100,
    "sourceAccountNumber": "0000000001",
    "destinationAccountNumber": "0000000002"
    "currentBalance": 0.00,
    "message": "Transfer successful"
}
```

