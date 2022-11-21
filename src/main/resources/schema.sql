CREATE TABLE client (
  client_id     VARCHAR(30) PRIMARY KEY,
  first_name    VARCHAR(30) NOT NULL,
  last_name     VARCHAR(30) NOT NULL,
  age          INTEGER NOT NULL,
  address      VARCHAR(100) NOT NULL);

CREATE TABLE account (
  iban VARCHAR(30) primary key,
  client_id VARCHAR(30) NOT NULL,
  account_type INTEGER NOT NULL,
  creation_date DATE NOT NULL,
  balance DOUBLE NOT NULL,
  account_minimum_balance DOUBLE NOT NULL
);

CREATE TABLE transaction (
  transaction_id BIGINT AUTO_INCREMENT primary key,
  account_iban VARCHAR(30) NOT NULL,
  transaction_value DOUBLE NOT NULL,
  label VARCHAR(30),
  transaction_date DATE NOT NULL,
  balance_after DOUBLE NOT NULL
);

CREATE SEQUENCE transaction_id_seq;

