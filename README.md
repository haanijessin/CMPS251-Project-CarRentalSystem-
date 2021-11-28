
**Qatar University  Object-Oriented Programming (CMPS251) - Dept. of Computer Science & Engineering** 

**Spring 2020 Term Project - FCar Company Rental System**  

**Phase I is due on 26/10/2020** 

![FCARRental Banner](https://i.imgur.com/fgZTcw2.jpg)

**Introduction** 

As part of the Qatar’s vision 2030 the government is encouraging companies to modernize their working environment. Due to this, a lot of companies are trying to move from the traditional paper-based system to more advanced computerized systems. As a result, **FCars**, a car rental company**,** asked you to change their paper passed system into a computerized system.    

**Renting Process**  

When new customer arrives to rent a car, their data are entered and saved into the system. Those customers could be of two kinds; residents in Qatar who have the Qatari ID or Visitors who have temporary visa. 

If the customer is resident then they can use their Qatari ID to rent the car, however for visitors they will be required to use their passports and also show their valid visa. Furthermore, both customer types should deposit 2000 QR for insurance purpose. Once the user returns the car an invoice is generated that has all the payments such as rental money and damages. Finally, the deposit money is paid back to the customer after deducting the remaining rent and damages. 

**Requirement Specification** 

Your task is to develop a car rental system for **FCars** rental company. The system should meet the following requirements. The system should allow, 

1. adding, updating, deleting customers in the system 
1. adding, updating and deleting newly purchased car’s information    
1. adding, updating, deleting of rental payments  
1. generating report of 
1. available cars: show all the cars of the company that are not rented 
1. registered customers: list all the customers in the system 
1. rented cars: list all the cars that are currently rented 
1. income: show total income of the company 

The following is a class diagram that describes the classes in this system and their relationships. 
![class diagram](https://i.imgur.com/TJtfmqA.jpg)
*Figure 1 FCars Car Rental Class Diagram*  


**Project Phase I requirements** 

**Phase I is due on 26/10/2020** 

1. Implement the entity classes for FCars Rental System as shown in Figure 1. 



|**Inovice**|**Explanation** |
| - | - |
|+modifyIPayment(payment: Payment): String|Update payment information. First search for the payment, from the list of payments inside the invoice object.  Then modify old payment values with the new payment values. Finally, return “updated payment successfully” |
|+deletePayement(paymentId: int): String |Delete a payment. First search for the payment, then delete it, Finally, return “delete payment successfully” |
|+addPayment(payment: Payment): String |Add a new payment to the system, then, return “add payment successfully”|
|+getPayment(paymentId: int): Payment |Search for a specific payment by their id |
|+calculateTotalPayment() : double|Calculate total payment for the invoice. |
2. Implement the FCars Rental System class as described below. 



|**FCars Rental State System** |**Explanation** |
| - | - |
|+addCustomer(customer: Customer): String |Add a new customer to the system (resident or visitor), then, return “added customer successfully” |
|+findCustomer(customerId: int): Customer  |Search for a specific customer by their id. |
|+deleteCustomer(customerId: int): String |Delete for a specific customer by their id, then, return “delete customer successfully” |
|+addCar(car: Car): String |Add a new Car to the system  then, return “added car successfully” |
|+findCar(plateNumber : String) :Car |Search for a specific car by its number. |
|+deleteCar( plateNumber : String) :String |Delete for a specific car by its plate number ,You should also delete the car’s rentals as the car no longer exists, then, return “deleted car successfully”  |
|+getCarByAvailability(available: boolean) : List<Car> |Returns a list containing the available cars. |
|+returnCar(plateNo: String): invoice |<p>When a customer returns back the car, the car status is updated to available.  </p><p>Then invoice of the car is returned.  </p>|
|+bookCarRental(rental: Rental): void |When booking a rental, set the car that is currently being rented to “not available”. That means you should find the car inside the list of cars and make it unavailable. |
|+findCarRentalByCustomerId(customerId: int): List<CarRental> |Returns all the cars rented by a specific customer (past and present rentals) |
|+deleteCarRental(customerId : int): void |Deletes specific car rental by specific customerId. Also, you should update the rental of that car and make it available.  |
|+getAvailableCarsByDate(date: Date): List<Car> |Return all cars that are available after a specific date. This means, you need to return the currently available cars and the cars currently rented but that will become available after thatgiven date. |
3. Add an App class having the main method to test all the methods of the application. In phase I, any data needed should be hardcoded. The app should display the results to the console. There is no need to ask the user to enter any data during phase I. 

**Instructions:** 

1. This is a group-work project (**3 students per group**, exceptionally a group of 4 may be allowed).  
1. Please immediately form your group and share them on Blackboard. I have already created a link that allows you to register your group.  
1. Please start immediately and plan your time so that you finish within the project period. Submissions after the due date will incur a 25% penalty for every day or part of a day.  
1. Name of the member who created a class must be written as the author using Javadoc comments. Also, add the date of creation of the class. The version number must also be included.   
1. Each group should submit a zip file of the project code and the word file of the project documentation. 
1. an archive of their project folder. You can export using eclipse IDE. 
1. an MS-Word document containing  
	- a **cover page** that lists your names and QU ID's.  
	- the source code of all the developed Java classes (font size should be 12 points, please)  
	- screenshots of all input/output.  
1.  Each member MUST submit a **one-page confidential report** (called the self-report) describing his/her exact contribution to the project and explaining the advantages and disadvantages of working in teams, based on your current experience with this project. This is individual and you will be required to submit it on a different link. [**DO NOT SHARE** this with your teammates] 

**Project Phase II requirements** 

**Due on 14/11/2020** 

In Phase II your task is to develop the user interface for the **FCars** rental system using JavaFX. The system should meet the following requirements.   

1. Display the Main UI Window that allows the users to choose customer, car, or rental window 
1. Customer UI window should allow the user to add, update, delete customers in the system 
1. Car UI window should allow the user to add, update, delete cars in the system 
1. Rental UI window should allow the user to rent a new car, for a specific customer   

Your system should have a GUI interface to interact with system users and should **use files to save data** permanently. Not using files will result in losing 30% of the project grade. 

Below are some of the screenshots for the GUI you suppose to create in phase II of the project. The following screenshot are guidelines of how the system should look like. They are the minimal requirements. **However, if some of you would like to improve the design or implement more functionalities, then you are free to do so.**   

**Main UI Window** 

This window is loaded when you first start the application [Fig.1].  
![](https://i.imgur.com/lCAqxz3.png)

*Figure 1 Main app window*

**Main Car Window** 

This window is shown when the user clicks on the Car Button in the MainView [Fig.2]. 
![](https://i.imgur.com/Og0yNta.png)

*Figure 2 Car Main UI window*

**Add Car Window** 

This window is shown when the user clicks on the Add Button inside the Car View shown [Fig.3] 
![](https://i.imgur.com/GIcFZA9.png)

*Figure 3 Add car window*

**Update Car Window**

This window is shown when the user clicks on the Update Button inside the Car View shown [Fig.4].  The user should select a car before clicking update. You will be required to populate the selected car info into a form to allow the user to edit. 

![](https://i.imgur.com/Re34sTB.png)

*Figure 4 – Update car window*

**Delete Car** 

If the user does not select any car you should display a warning message saying , “***please select a car to delete***” 

![](https://i.imgur.com/pfmZt5b.png)

If the user selects a car and presses on the delete button then give a confirmation message saying , “***Are you sure you want to delete car with plate no: X*** ” 

![](https://i.imgur.com/BfPj6lq.png)

*Figure 5 – Delete Car* 

**Main Customer Window** 

This window is shown when the user clicks on the Customer Button inside the Main View shown [Fig.6] 

![](https://i.imgur.com/a2WMTRF.png)

*Figure 6 Customer Main UI window*  

**Add Customer Window** 

This window is shown when the user clicks on the Add Button inside the Customer View shown [Fig.7] 

![](https://i.imgur.com/szRFYuQ.png)

*Figure 7 Add customer window*

**Update Customer Window** 

This window is shown when the user clicks on the Update Button inside the Customer View shown 

[Fig.8].  The user should select a customer before clicking update. You will be required to populate the selected customer info into a form to allow the user to edit.    

![](https://i.imgur.com/2VbgaTZ.png)

*Figure 8 update customer*

**Delete Customer** 

If the user does not select any customer you should display a warning message saying , “***please select a customer to delete***” 

![](https://i.imgur.com/yyZet4Q.png)

*Figure 9 update customer*

If the user does selects a customer and presses on the delete button then give a confirmation message saying , “***Are you sure you want to delete customer with ID X : Name : Y*** ” 

![](https://i.imgur.com/Fpl6ZZS.png)

*Figure 10 update customer*

**Rentals View**   

This window is shown when the user clicks on the Rentals Button inside the Main View shown [Fig.1].  The following are the steps you need to implement. 

1. You should populate the customer id and car plate numbers in the two drop down elements [Customer, Car].  
1. When the user selects a customer id, car no, rent start date and rent end dates, and presses on **Rent** button.  Then you need to use this information to create a rental object and save this object into the file called ***rentals*** and also display in the table. 

Hint: before creating the rental object, use the **findCar** and **findCustomer** methods you created in Phase 1, to get all the car and customer objects. 

The below figure shows adding a rental   

![](https://i.imgur.com/0wd7qhs.png)

*Figure 11 : Rent a car*

**Instructions for Phase 2** 

1. All the instruction in phase I apply here too, as these instructions are just a continuation of the previous phase. 
1. Please start immediately and plan your time so that you finish within the project period. Submissions after the due date will incur a 25% penalty for every day or part of a day. 
1. The name of the member who created a class must be written as the author using Javadoc comments. Also, add the date of the creation of the class. 
1. Each group should submit one softcopy of their work by uploading an archive of their project folder to the course website on Blackboard under your group and also update their Phase I report by adding phase II GUI. 
1. Each member MUST submit a one-page confidential report (called the self-report) describing his/her exact contribution to the project and explaining the advantages and disadvantages of working in teams, based on your current experience with this project. 
