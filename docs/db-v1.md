# BotTelegram — Database Schema

This document describes the database schema for my application. The main goal is to manage products and users.

## Table: users

Storage of user information

| Column       | Type        | Description                                     | Notes           |
|:-------------|:------------|:-----------------------------------------------|:----------------|
| `user_id`    | `uuid`      | Unique identifier for the user                 | **Primary Key** |
| `full_name`  | `string`    | Full name of the user                           |                 |
| `email`      | `string`    | User's email address, used for login and contact | **Unique**      |
| `hash`       | `string`    | Password hash for user authentication          |                 |
| `roles`      | `string`    | Roles assigned to the user                      |                 |
| `created_at` | `timestamp` | Timestamp when the user was created            |                 |
| `updated_at` | `timestamp` | Timestamp when the user was last updated       |                 |

## Table: products

Storage of information about the store products

| Column                | Type        | Description                                    | Notes           |
|:----------------------|:------------|:-----------------------------------------------|:----------------|
| `product_id`          | `uuid`      | Unique identifier for the product              | **Primary Key** |
| `name`                | `string`    | Name of the product                             |                 |
| `price`               | `double`    | Price of the product                            |                 |
| `status_availability` | `string`    | Indicates if the product is available for sale |                 |
| `basic_unit`          | `string`    | Unit type              |                 |
| `image`               | `string`    | URL or path of the product image               | **Nullable**    |
| `created_at`          | `timestamp` | Timestamp when the product was created         |                 |
| `updated_at`          | `timestamp` | Timestamp when the product was last updated    |                 |
