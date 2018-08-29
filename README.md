# Warehouse app

<div align="center">
  <img src="https://user-images.githubusercontent.com/42721137/44773144-7a3c5680-ab78-11e8-99e2-971de9ae9ea2.png"><br><br>
</div>

Warehouse is application for control and accounting goods in the warehouses. It allows:
- :articulated_lorry: add and store data about suppliers;
- :clipboard: save records about receipts and disposals of goods;
- :bar_chart: make analysis of the work;
- :busts_in_silhouette: multi-user use and administration.

Graphic design of application is made by [JavaFX](https://wiki.openjdk.java.net/display/OpenJFX/Main) platform. For storing data is used [MySQL](https://www.mysql.com) server.

## Intention
I wanted to make an application that could be used usefully for work of some business. The idea was to start develop an application for  logistics companies that could keep records of current stocks of goods in the warehouses, allow accounting receipts and disposals of goods and generate some reports for progress control.

## How to run 

Build jar:

```bash
mvn clean package assembly:single
```
To start application run:

```bash
java -jar ./target/Warehouse-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

## Deployment
By default app looks for `data` MySQL database at `localhost:3306` with credentials `root/admin`. By the way, this can be configured in `dbconnection.properties`.

```bash
CREATE TABLE `data`.`receipts` (
  `idreceipts` INT(11) NOT NULL,
  `idsupplier` INT(11) NOT NULL,
  `add_data` VARCHAR(45) NOT NULL,
  `name` VARCHAR(145) NOT NULL,
  `quantity` INT NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `amount` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idreceipts`),
  UNIQUE INDEX `idreceipts_UNIQUE` (`idreceipts` ASC) VISIBLE);
```

```bash
CREATE TABLE `data`.`suppliers` (
  `idsuppliers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(145) NOT NULL,
  `country` VARCHAR(145) NOT NULL,
  `address` VARCHAR(145) NOT NULL,
  `phone` VARCHAR(145) NOT NULL,
  `contract` VARCHAR(145) NOT NULL,
  UNIQUE INDEX `idsuppliers_UNIQUE` (`idsuppliers` ASC));
```

```bash
CREATE TABLE `data`.`users` (
  `idusers` INT(12) NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(145) NOT NULL,
  `LastName` VARCHAR(145) NOT NULL,
  `Login` VARCHAR(145) NOT NULL,
  `Password` VARCHAR(145) NULL,
  `Email` VARCHAR(145) NOT NULL,
  `Role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusers`),
  UNIQUE INDEX `idusers_UNIQUE` (`idusers` ASC) VISIBLE,
  UNIQUE INDEX `Login_UNIQUE` (`Login` ASC) VISIBLE,
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE);
```

## Description

- [x] Login window

Login into system provides by entering own account's login and password in a special window when application starts.

![enter](https://user-images.githubusercontent.com/42721137/44755149-9bc42080-ab2d-11e8-9125-00da6da028d6.png)



- [x] Password sender window

If user password was forgotten, the application provides automatic sending of passwords by email to the employees email addresses which were inserted into database in time of the registration. A special dialog window was added.

![email](https://user-images.githubusercontent.com/42721137/44755556-5bfe3880-ab2f-11e8-80ec-ffa500da1af4.png)



- [x] Main window 

On the left are the button-tabs for working with the application.

![home](https://user-images.githubusercontent.com/42721137/44778047-b83f7780-ab84-11e8-8ad4-a67c5d12365e.png)



- [x] Goods receipt

- Suppleirs tab. 

Here you can manage your suppliers (add new supplier, delete from DB, change supplier's records). 
Suppliers's contracts in PDF format are stored in the local storage. In database only links for them.

![supplier](https://user-images.githubusercontent.com/42721137/44779140-5b918c00-ab87-11e8-96a1-d0ea522991be.png)

- Receipt tab. 

A special tab to create record of receipt at the warehouse. Here you choose from DB the existing list of suppliers and add goods to the table. After adding all goods in table you need to insert records to DB.

![receipt](https://user-images.githubusercontent.com/42721137/44779577-87614180-ab88-11e8-9e26-19bcbb82f43e.png)

- [x] Goods movement window

Window where you can see all current stocks at the warehouse by dates of addition and suppliers. And here you can select of existing in DB goods, change quantity and after make their disposal (shipment from the warehouse).    

![export](https://user-images.githubusercontent.com/42721137/44780966-dfe60e00-ab8b-11e8-86e6-b764fab759e6.png)

- [x] Analysys window

From one date to another date you can see progress of work your warehause: current stocks, quantity shipped goods and recipts during this period in percents and dollars.
The aggregate functions MySQL are used to calculate this stats.

![analysys](https://user-images.githubusercontent.com/42721137/44783332-b086cf80-ab92-11e8-88f0-4254395faee4.png)

- [x] Add employee window

Administrator window where you can register a new user of application or edit user's current record.

![employee](https://user-images.githubusercontent.com/42721137/44782282-5fc1a780-ab8f-11e8-9a08-6f9b0ecd45bd.png)

Everywhere I tried to do an input checkers:

![third](https://user-images.githubusercontent.com/42721137/44783244-67368000-ab92-11e8-9fa6-80d89dc870a2.png)
![first](https://user-images.githubusercontent.com/42721137/44783246-67368000-ab92-11e8-80ce-60f7e6a3100a.png)
![second](https://user-images.githubusercontent.com/42721137/44783247-67cf1680-ab92-11e8-850f-39ec97e6ac85.png)



