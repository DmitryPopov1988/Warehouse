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

## Description

- [x] Login

Login into system provides by entering own account's login and password in a special window when application starts.

![enter](https://user-images.githubusercontent.com/42721137/44755149-9bc42080-ab2d-11e8-9125-00da6da028d6.png)

- [x] Password sender

If user password was forgotten, the application provides automatic sending of passwords by email to the employees email addresses which were inserted into database in time of the registration. A special dialog window was added.

![email](https://user-images.githubusercontent.com/42721137/44755556-5bfe3880-ab2f-11e8-80ec-ffa500da1af4.png)

Main screen after login. On the left are the button-tabs for working with the application.

![home](https://user-images.githubusercontent.com/42721137/44778047-b83f7780-ab84-11e8-8ad4-a67c5d12365e.png)

- [x] Goods receipt

- Suppleirs tab. 

There you can manage your suppliers (add new supplier, delete from DB, change supplier's records). 
Suppliers's contracts in PDF format are stored in the local storage. In database only links for them.

![supplier](https://user-images.githubusercontent.com/42721137/44779140-5b918c00-ab87-11e8-96a1-d0ea522991be.png)

- Receipt tab. 

A special tab to create record of receipt at the warehouse. Here you choose from DB the existing list of suppliers and add goods to the table. After adding all goods in table you need to insert records to DB.

![receipt](https://user-images.githubusercontent.com/42721137/44779577-87614180-ab88-11e8-9e26-19bcbb82f43e.png)






