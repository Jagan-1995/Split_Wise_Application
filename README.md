## Overview
- The Expense Sharing Application is designed to help users manage and share expenses with other users.
- It supports individual expenses, group-based expenses, and provides the ability to settle up amounts owed.
- The application allows users to register, create and manage groups, add expenses, and track their transaction history.
- It operates on a command-based interface with an emphasis on flexibility and ease of use.

## Architecture
- Controllers: Handle user commands and route them to appropriate services.
- Models: Represent the data and business logic, including Users, Expenses, Groups, and Transactions.
- Services: Contain the core business logic and interact with the repositories.
- Repositories: Manage data persistence, though in this implementation, data does not persist between runs.
- Common Strategies: Handle different types of expense splitting (Equal, Percentage, Ratio, Exact).

## Assumptions
- Transactions will be settled only for the user requesting the settle-up or for a specific group.
- Groups are identified by their group IDs (e.g., g1).
- The application does not persist data between runs.
- All tests will be conducted in a single session.

## How to Run
- Execute the commands as specified in the Input Format section.
- Ensure to follow the exact syntax to avoid errors.


