# DineSmart-Pro
⚡技术
=================
<div align="left">
    <img src="https://img.shields.io/badge/Java-1.8%2B-%23437291?logo=openjdk&logoColor=%23437291"/>
    <img src="https://img.shields.io/badge/mysql-8%2B-%23437291?logo=openjdk&logoColor=%23437291"/>
    <img src="https://img.shields.io/badge/jdbc-8.2.0-brightgreen"/>
    <img src="https://img.shields.io/badge/javafx-21.0.1-brightgreen"/>
</div>

👋简介：
=================
"DineSmart Pro 餐厅管理系统" 是一款专业的餐饮业务管理工具，为餐馆提供全面的解决方案。该系统集成了多种功能，以提高餐厅运营效率，改善客户服务体验。通过 DineSmart Pro，餐厅管理者能够轻松处理订单、管理菜单、追踪库存、进行财务分析，实现全面的业务掌控。系统界面简洁直观，易于使用，适用于各类餐饮场所，是提升餐厅管理水平的得力助手。

💻功能：
=================

#### 用户权限管理
* 重新整理上述功能，提供完善的用户（店员、管理员）权限管理，确保信息安全和业务顺畅进行。

#### 账单记录
* 记录客户的订单并可进行编辑、修改、删除。

#### 菜单管理
* 添加、编辑和删除菜单项。

#### 自动纳税管理
* 汇总税款，用于提醒管理员缴纳。

#### 打印
* 打印订单收据。

#### 顾客评价
* 记录顾客对菜品与服务的评价和建议。

#### 原料记录
* 用于记录所购入的食材以及餐具建材等物品。

#### 资金管理
* 显示所有流水和生成报表。

🌱项目分析
=================
该项目采用 MVC 模式, 即 Model-View-Controller（模型-视图-控制器） 模式。
### 按项目结构看：
#### Model（模型）：
模型代表一个存取数据的对象或 JAVA POJO。它也可以带有逻辑，在数据变化时更新控制器。  
-  Main.java  
-  Material.java  
-  MaterialDAO.java  
-  Menu.java  
-  MenuDAO.java  
-  Order.java  
-  OrderDAO.java  
-  Review.java  
-  ReviewDAO.java  
-  User.java  
-  UserDAO.java  
#### View（视图） :
视图代表模型包含的数据的可视化。
-  login.fxml  
-  main.fxml  
-  material.fxml  
-  materialAdd.fxml  
-  materialUpdate.fxml  
-  menu.fxml  
-  menuAdd.fxml  
-  menuUpdate.fxml  
-  order.fxml  
-  orderAdd.fxml  
-  orderTaxCalculate.fxml  
-  orderUpdate.fxml  
-  reviewfxml  
-  reviewAdd.fxml  
-  reviewUpdate.fxml  
#### Controller（控制器）: 
控制器作用于模型和视图上。它控制数据流向模型对象，并在数据变化时更新视图。它使视图与模型分离开。
-  LoginController.java  
-  MainController.java  
-  MaterialAddController.java  
-  MaterialController.java  
-  MaterialUpdateController.java  
-  MenuAddControllerjava  
-  MenuController.java  
-  MenuUpdateController.iava  
-  OrderAddController.java  
-  OrderController.java  
-  OrderTaxCalculateController.java  
-  OrderUpdateController.java  
-  ReviewAddController.java  
-  ReviewController.java  
-  ReviewUpdateController.java  

### 按具体功能看：
在这里举例Login和Order页面的实现
#### Login页面:
-  User.java：这是一个简单的 Java 类，代表了餐厅管理系统中的用户对象，并且具有一些属性。类中包含了默认构造函数和一个带有参数的构造函数，以及用于获取和设置每个属性值的 getter 和 setter 方法。这个类的实例用于在程序中表示和操作用户信息。
- UserDAO.java：这是一个用于与数据库进行交互的数据访问对象（DAO）类。DAO 是数据访问对象（Data Access Object）的缩写，它是一种设计模式，用于将应用程序的业务逻辑与数据存储（通常是数据库）的访问细节分离开来。其中的isValidUser方法负责验证用户的登录信息是否有效，通过查询数据库中的用户表（user表）来判断输入的用户名和密码是否匹配。根据匹配结果，该方法会返回一个布尔值，表示验证是否成功。同时，使用了一个简单的chooseFun方法将查询结果中的用户信息映射到User对象中。
- login.fxml：这是一个FXML（JavaFX的XML-based用户界面描述语言）文件，定义了登录界面的布局。包含了两个文本输入框（用户名和密码）、两个标签（用户名和密码的标签）、一个按钮（用于执行登录操作）以及一个AnchorPane容器。FXML文件通过fx:id属性将UI元素与Java代码中的成员变量关联起来，使得在LoginController中可以轻松地访问和操作这些UI元素。
- LoginController.java：这是一个Java类，作为MVC架构中的控制器（Controller）部分。LoginController包含了处理登录操作的方法handleLogin，该方法通过调用UserDAO中的isValidUser方法验证用户登录。如果验证成功，会调用showWelcomeDialog显示登录成功的提示框，并切换到主界面（main.fxml）。如果验证失败，则会调用showAlert方法显示登录失败的提示框。

总体而言，login.fxml定义了登录界面的外观，UserDAO.java处理与数据库的交互，而LoginController.java负责用户界面的逻辑控制。这样的MVC架构有助于代码的组织和维护，使得各部分的功能分明，易于理解和修改。


👋Introduction:
=================
"DineSmart Pro - Restaurant Management System" is a professional tool designed to streamline restaurant operations and enhance overall efficiency. This system offers a comprehensive solution for restaurant management, integrating a variety of features to optimize both front-end and back-end processes. With DineSmart Pro, restaurant owners can easily handle orders, manage menus, track inventory, and perform financial analysis, gaining full control over their business operations. The system boasts an intuitive and user-friendly interface, making it suitable for various types of dining establishments and serving as a valuable asset for elevating restaurant management standards.

💻Features:
=================

### UserPermission Management
Rearrange the above functions, providing comprehensive user permission management (Clerk, Administrator)   to ensure information security and smooth business operations.

### Invoice Records
Record customer orders with options for editing, modification, and deletion.

### Menu Management
Add, edit, and delete menu items.

### Automatic Tax Management
Consolidate tax payments and remind administrators to pay in a timely manner.

### Printing
Print order receipts.

### Customer Reviews
Record feedback and suggestions from customers on dishes and services.

### Ingredient Records
Track the purchase of food ingredients, utensils, and building materials.

### Funds Management
Display all transactions and generate relevant reports.
