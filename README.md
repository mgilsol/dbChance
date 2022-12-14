# dbChance
Code:

    [GITHUB] https://github.com/mgilsol/dbChance.git
    [GITHUB] git@github.com:mgilsol/dbChance.git

## Dev Challenge (Short)

The Asset Management Digital Challenge

Please provide with a simple REST service application using Spring Boot.

Your task is to add functionality for adding, reading and a transfer of money between bank accounts. Following is the simple interface for these 3 methods:

### Create an account:
*	accountId and balance

### Reading an account:
*	accountId

### Transfers should be specified by providing:
*	accountFrom id
*	accountTo id
*	amount to transfer between accounts

The amount to transfer should always be a positive number.
It should not be possible for an account to end up with negative balance (we do not support overdrafts!)

You can use memory for storing account data temporally. No persistence database is required.

## Additional guidance

Please provide us with the code, preferably via github (you can commit + push as many times as you want).
We think this task should take you between 1 and 2 hours - take the simplest possible approach that works. It's not meant to be a trick question, and our expectations are set accordingly to the time we expect you to spend on this.

Please treat this as an opportunity to showcase how you work, quality of what you provide will matter much more than pure quantity of code, or adding features we do not ask for.
Clean, elegant and simple code wins over feature rich every time.

Due to limited time we expect you to spend on this, we are happy for you to focus only on the code and tests to deliver the feature.
However, please provide a short document (a few bullet points will suffice) describing any extra work you would consider important to do before this project was turned into a production application - i.e. what would you improve/add, given more time.

Please focus on the application being "production-and-support-ready" for requirements already provided - not on extra features/functionality that could be added. 
