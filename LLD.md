# SOLID principles
    https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design

    Single responsibility pattern
        What it really means
            A class should do one thing
            Changes in business logic, persistence, logging, formatting, etc. should not affect the same class
        SRP is NOT “one method per class”, it’s about one responsibility

        Bad Example (Violates SRP)
            class UserService {
                public void createUser(User user) {
                    // business logic
                    validateUser(user);

                    // persistence
                    saveToDatabase(user);

                    // logging
                    System.out.println("User created");

                    // email notification
                    sendEmail(user);
                }
                private void validateUser(User user) {}
                private void saveToDatabase(User user) {}
                private void sendEmail(User user) {}
            }
            Problems
                Business logic + DB + logging + email = multiple responsibilities
                If email logic changes → class changes
                Hard to test and hard to reuse

        Good Example (SRP Applied)
            class UserService {
                private final UserRepository repository;
                private final EmailService emailService;

                public UserService(UserRepository repository, EmailService emailService) {
                    this.repository = repository;
                    this.emailService = emailService;
                }
                public void createUser(User user) {
                    validateUser(user);
                    repository.save(user);
                    emailService.sendWelcomeEmail(user);
                }
                private void validateUser(User user) {}
            }

            class UserRepository {
                public void save(User user) {
                    // DB logic
                }
            }

            class EmailService {
                public void sendWelcomeEmail(User user) {}
            }

            Benefits
                Easier to change, Easier to test, Cleaner architecture
    
    O — Open/Closed Principle (OCP)
        Software entities should be open for extension, but closed for modification.
        What it means
            You should add new behavior without changing existing code
            We should use interfaces, abstract classes, polymorphism

        Bad Example (Violates OCP)
            class PaymentService {

                public void pay(String type, double amount) {
                    if (type.equals("CARD")) {
                        // card payment logic
                    } else if (type.equals("UPI")) {
                        // upi payment logic
                    } else if (type.equals("WALLET")) {
                        // wallet payment logic
                    }
                }
            }
            Problem
            Adding CRYPTO payment → modify this class
            Risk of breaking existing code
        
        Good Example (OCP Applied)
            interface PaymentMethod {
                void pay(double amount);
            }

            class CardPayment implements PaymentMethod {
                public void pay(double amount) {
                    System.out.println("Paid using card");
                }
            }

            class UpiPayment implements PaymentMethod {
                public void pay(double amount) {
                    System.out.println("Paid using UPI");
                }
            }

            class PaymentService {
                public void processPayment(PaymentMethod method, double amount) {
                    method.pay(amount);
                }
            }
            Now we can easily create a class CryptoPayment and use it for payment.

    L — Liskov Substitution Principle (LSP)
        Subtypes must be substitutable for their base types without breaking behavior.
        Simple meaning
            If class B extends A, then B should work anywhere A is expected
            Subclasses should not break expectations
        
        Classic Bad Example (Rectangle–Square problem)
            class Rectangle {
                protected int width, height;

                public void setWidth(int w) { width = w; }
                public void setHeight(int h) { height = h; }
                public int getArea() {
                    return width * height;
                }
            }
            class Square extends Rectangle {
                public void setWidth(int w) {
                    width = height = w;
                }
                public void setHeight(int h) {
                    width = height = h;
                }
            }

            Why this breaks LSP
                Rectangle r = new Square();
                r.setWidth(5);
                r.setHeight(10);
            System.out.println(r.getArea()); // Expected 50, but gets 100 
            Behavior is broken → LSP violation

        Correct Approach
            interface Shape {
                int getArea();
            }
            class Rectangle implements Shape {
                private int width, height;

                public Rectangle(int w, int h) {
                    width = w;
                    height = h;
                }
                public int getArea() {
                    return width * height;
                }
            }
            class Square implements Shape {
                private int side;

                public Square(int side) {
                    this.side = side;
                }
                public int getArea() {
                    return side * side;
                }
            }
            Benefits
                Predictable behavior, Safe polymorphism, Fewer bugs

    I — Interface Segregation Principle (ISP)
        Clients should not be forced to depend on methods they do not use.
        Meaning
            Prefer many small interfaces over one large interface

        Bad Example (Fat Interface)
            interface Worker {
                void work();
                void eat();
            }

            class RobotWorker implements Worker {
                public void work() {}
                public void eat() { 
                    // meaningless
                }
            }

            Problem
                Robot doesn’t eat
                Forced to implement unused methods

        Good Example (ISP Applied)
            interface Workable {
                void work();
            }
            interface Eatable {
                void eat();
            }
            class HumanWorker implements Workable, Eatable {
                public void work() {}
                public void eat() {}
            }
            class RobotWorker implements Workable {
                public void work() {}
            }
            Benefits
                No unnecessary methods, Cleaner APIs, Better separation of concerns
        
    D — Dependency Inversion Principle (DIP)
        High-level modules should not depend on low-level modules.
        Both should depend on abstractions.
        Meaning
            Do not create new concrete classes inside business logic
            Depend on interfaces, not implementations
        
        Bad Example (Tight Coupling)
            class OrderService {
                private MySQLDatabase database = new MySQLDatabase();

                public void saveOrder(Order order) {
                    database.save(order);
                }
            }
            Problem
                If in future i want to use PostgresDB then i would have to change my OrderService class which will break the Open-closed principle.

        Good Example (DIP Applied)
            interface OrderRepository {
                void save(Order order);
            }

            class MySQLOrderRepository implements OrderRepository {
                public void save(Order order) {}
            }

            class OrderService {
                private final OrderRepository repository;

                public OrderService(OrderRepository repository) {
                    this.repository = repository;
                }

                public void saveOrder(Order order) {
                    repository.save(order);
                }
            }

            Spring Boot makes this easy
            @Service
            class OrderService {
                private final OrderRepository repository;

                public OrderService(OrderRepository repository) {
                    this.repository = repository;
                }
            }

# UML diagram
    https://algomaster.io/learn/lld/class-diagram

# Strategy design pattern
    Strategy pattern lets you define multiple ways (strategies) to perform an action and choose which one to use at runtime without changing the code that uses them.

    Real-Life Analogy
        Imagine a navigation app:
            You can choose "By Car", "By Bike", or "By Walking".
            The app doesn’t change; it just uses a different route strategy based on your choice.

    When to Use Strategy Pattern
        When you have multiple ways to perform an operation (e.g., sorting, payment, compression).
        When you want to avoid if-else or switch chains.
        When the algorithm might change or be added to without touching the context.

    Benefits
        Advantage	                Description
        Open/Closed Principle	    Add new strategy without modifying context
        Removes Conditional Logic	Replaces complex if-else
        Code Reusability	        Each strategy can be reused independently

    LLD Problems That Use Strategy Pattern
        1. Payment Gateway Integration
            Problem: Users can pay via UPI, Credit Card, Wallet, Net Banking, etc.
            Strategy: Each payment method implements a PaymentStrategy interface.
            paymentService.setStrategy(new UpiPaymentStrategy());
            paymentService.processPayment(order);
        2. Routing/Navigation System (like Google Maps)
            Problem: You need different routing strategies:
            Fastest, Shortest, Scenic, Traffic-aware
            Strategy: Each strategy implements RouteStrategy.
            router.setStrategy(new TrafficAwareStrategy());
            router.findPath(from, to);
        3. Discount Calculation System (E-commerce)
            Problem: Discounts can be:
                Flat ₹100 off, 20% off, Buy 1 Get 1, Coupon-based
                Strategy: Implement DiscountStrategy for each case.
                cart.applyDiscount(new PercentageDiscountStrategy(20));
        4. Sorting Algorithm Selector (Analytics / Reports)
            Problem: Choose sorting method (QuickSort, MergeSort, BubbleSort) based on dataset size or input type.
            Strategy: Use SortStrategy interface with multiple algorithm implementations.
        6. Authentication Strategies (Web/SaaS)
            Problem: Users can log in with:
            Username/password, OAuth (Google, Facebook), OTP, SSO
            Strategy: AuthStrategy interface with different providers.
            authContext.setStrategy(new OtpAuthStrategy());
            authContext.authenticate(request);

# Observer design pattern
    The Observer Pattern defines a one‑to‑many relationship between objects so that when one object changes state, all its dependents are notified and updated automatically.

    Real-World Analogy
        Imagine a YouTube channel:
        The channel is the Subject.
        Subscribers are the Observers.
        When the channel uploads a new video, all subscribers get notified.

    When to Use the Observer Pattern
        Use Case	                    Examples
        Event-driven systems	        UI buttons, game events
        Notification systems	        Email/SMS alerts, system monitoring
        Data binding (e.g., MVC, MVVM)	UI auto-updates when model changes
        Real-time systems	            Stock tickers, weather dashboards
        Chat app                        New message → Notifies all users in the group
        Weather data updates            Pushes data to all connected clients

# Decorator pattern
    The Decorator Design Pattern is a structural design pattern that allows you to dynamically add behavior or responsibilities to an object without modifying its original class.

    Real-World Analogy
        Coffee Shop Example:
            You order a coffee, and then add-ons like:
                Milk, Sugar, Whipped Cream
        Each add-on decorates the base coffee, adding behavior (cost, description) without changing the Coffee class.

    What Decorator Solves:
        Dynamically add features (new behavior or data) at runtime
        Avoid subclassing every feature combo
        Keep classes open for extension, but closed for modification (Open/Closed Principle)
    
    Suppose you open zomato and take a dish, on that dish you have several options like add beverage, add fries etc. This is the place where decorator pattern comes into play.

    Real-Life Scenarios Where Decorator Pattern Is Used:
        1. Java I/O Streams (Real Java Example)
            Java's file streams are full of decorators!
            InputStream in = new BufferedInputStream(new GZIPInputStream(new FileInputStream("file.gz")));
            Each of those wraps the previous:
            FileInputStream → base stream, GZIPInputStream → adds decompression, BufferedInputStream → adds buffering

        2. Spring Security Filters (or Servlet Filters)
            In a web app, you can stack filters to decorate a request with behaviors like:
            Authentication, Authorization, Logging, CORS
            Each filter wraps the request/response and adds features.

    LLD problems:
        Text Editor with Formatting
            Problem: A text editor should support bold, italic, underline, color etc., without creating dozens of FormattedText subclasses.
        Design a Notification System
            Problem: A system sends notifications via multiple channels: Email, SMS, WhatsApp, Slack. You may want to combine or stack these.
        Logger Design
            Problem: A logger should optionally add timestamp, log level, thread name, etc. You don’t want 10 subclasses for each log format.
        Billing Invoice Generator
            Problem: Base invoice + discount + tax + voucher + delivery fee = total.

# Factory design pattern
    https://algomaster.io/learn/lld/factory-method
    Factory Pattern is used when the creation logic of an object is complex, involves decision-making, or needs to be hidden from the client.
    It delegates the instantiation logic to a separate method or class, called a factory.
    Encapsulates object creation logic and returns objects through a common interface(factory.getShape()).

    It’s particularly useful in situations where:
        The exact type of object to be created isn't known until runtime.
        Object creation logic is complex, repetitive, or needs encapsulation.
        You want to follow the Open/Closed Principle, open for extension, closed for modification.

    Real-World Analogy
        Example: Vehicle Factory
        You tell the factory, “I want a Car” or “I want a Bike” — it gives you the appropriate object.
        You don’t worry about how the object is created.

    LLD problems:
        Notification System (SMS, Email, Push, WhatsApp)
            Problem: Send a notification, but the delivery mechanism depends on user preference or configuration.
        Payment Gateway System (UPI, Card, Wallet, Net Banking)
            Problem: Choose and process payments through different methods dynamically.
        Document Parser System (PDF, DOCX, TXT, CSV)
            problem: Read documents of different formats and parse them accordingly.
        Shape Drawing Tool (Circle, Rectangle, Triangle)
            Problem: Create different shapes based on user selection for drawing or modeling.
        Vehicle Rental System (Car, Bike, Truck)
            Problem: Create vehicle objects based on user rental request or booking.
        Authentication System (Password, OTP, OAuth, SSO)
            Problem: Users can authenticate via multiple strategies based on environment or preference.
        Cloud Storage Connectors (AWS S3, Google Cloud Storage, Azure Blob)
            Problem: Based on deployment or config, connect to the appropriate cloud provider.
        Game Character Weapons (Sword, Bow, Magic Wand)
            Problem: Equip characters with different weapons during gameplay.
        UI Component Generator (Mobile, Web, Desktop Themes)
            Problem: Generate platform-specific UI components based on device type.
        Export System (CSV, PDF, Excel)
            Problem: Export reports in different formats depending on user request.

# Abstract factory pattern
    The Abstract Factory Pattern is a creational design pattern used when you need to create families of related objects without specifying their concrete classes.

    Real-World Analogy
        UI Toolkit for Different Platforms:
            You want your app to work on Windows, macOS, and Linux.
            Each platform has:
                Its own Button
                Its own Checkbox
        Instead of creating them manually like:
            new WindowsButton();
            new MacCheckbox();
        You use an Abstract Factory:
            GUIFactory factory = new WindowsFactory();
            Button button = factory.createButton();
            Checkbox checkbox = factory.createCheckbox();
        The factory gives you the right family of components for the platform.

    Real-World LLD Problems Using Abstract Factory
        UI framework for cross-platform apps	GUIFactory (Windows/Mac/Linux)
        Theme system (Light, Dark, Custom)	ThemeFactory creates buttons, sliders, etc.
        Game asset factory (Desert, Forest, Snow worlds)	WorldAssetFactory for environment, characters
        Cloud SDKs (AWS, GCP, Azure)	CloudServiceFactory for storage, queue, compute
        DB Drivers (MySQL, Postgres, Oracle)	DbDriverFactory for queries, connections
        Notification channels (Transactional, Marketing)	NotificationFactory returns correct formatters & senders

# Factory method pattern
    What is the Factory Method Pattern?
        The Factory Method Pattern is a creational design pattern that:
            Defines an interface for creating an object, but lets subclasses decide which class to instantiate.
        Unlike Simple Factory:
            Object creation is delegated to subclasses instead of switch case on basis of type.
            Follows Open/Closed Principle more clearly.

# Chain of Responsibility design pattern
    The Chain of Responsibility (CoR) is a behavioral design pattern used to pass a request along a chain of handlers. Each handler decides either to process the request or to pass it to the next handler in the chain.

    Problem It Solves
        Avoids tight coupling between sender and receiver of a request.
        Allows dynamic assignment of responsibility at runtime.
        Makes it easy to add new handlers without changing existing code.

    Real-world cases
        It is used in spring filter chain
        It is used in implementing logger
    
    LLD problems:
        1. Logging Framework
            Problem: Design a logger that can handle multiple levels (INFO, DEBUG, ERROR).
            Use CoR: Each logger checks the log level and either logs the message or forwards it to the next logger.
        2. ATM Withdrawal System
            Problem: Break down a cash withdrawal amount into available denominations (e.g., ₹2000, ₹500, ₹100).
            Use CoR: Each handler processes its denomination and passes the remaining to the next.
        4. Customer Support Ticketing System
            Problem: Handle user complaints that need to be escalated based on severity.
            Use CoR: Levels like Support Agent → Manager → Legal handle or escalate.
        5. Middleware Pipeline (Web Frameworks)
            Problem: Process incoming HTTP requests through a set of middlewares (logging, auth, rate limiting).
            Use CoR: Each middleware handles its concern and passes the request further.
        6. Purchase Approval System
            Problem: Approve purchase orders based on amount (e.g., Team Lead approves up to ₹10,000, Manager up to ₹50,000).
            Use CoR: Handlers process requests based on limit, escalate otherwise.
        7. Form Input Validation
            Problem: Apply multiple validations (e.g., not empty, valid format, custom logic).
            Use CoR: Each validation rule is a handler that passes input down the chain if valid.
        8. Spam Filter in Email System
            Problem: Detect and filter spam based on different rules (blacklist, keywords, reputation).
            Use CoR: Each rule is a handler in the chain.
        9. Discount Engine
            Problem: Apply eligible discounts in sequence (seasonal, coupon, referral).
            Use CoR: Each discount checker adds/modifies discount and passes it on.
        10. Workflow/Approval System
            Problem: Document or task needs to be approved by multiple stakeholders in order.
            Use CoR: Each role checks and forwards if approval is not in its scope.

# Proxy design pattern
    https://algomaster.io/learn/lld/proxy
    The Proxy Design Pattern provides a placeholder or surrogate for another object to control access to it. It is part of the Structural Design Patterns in the Gang of Four (GoF) catalog.
    The proxy:
        Has the same interface as the real object
        Intercepts calls
        Adds behavior before or after delegating to the real object

    Existing Real-World Use Case: Database Access with Lazy Loading (Hibernate / JPA)
        This is not hypothetical — Hibernate uses proxies extensively.
        Real Scenario
            You load an entity (e.g. User)
            The related entity (Orders) is not loaded immediately
            Hibernate returns a proxy
            Actual DB query happens only when you access the data

    Why Use It?
        To control access (e.g., for security).
        To implement caching of the object.
        To delay object creation (e.g., lazy loading or caching).
        To add logging, remote access, or smart referencing.

    Depending on the use case, the Proxy may take different forms:
        Virtual Proxy: Defers creation of the real object until it’s actually needed (lazy loading).
        Protection Proxy: Performs permission checks before allowing access to certain operations.
        Remote Proxy: Handles communication between local and remote objects over a network.
        Caching Proxy: Caches expensive results and avoids repeated calls to the real subject.
        Smart Proxy: Adds logging, reference counting, or monitoring before/after method calls.

    LLD problems:
        1. Access Control System (Protection Proxy)
            Use Case:
                Design a system that controls access to sensitive operations based on roles.
                Example: Admin vs. User access in a document editor or banking portal, or a bash terminal which lets you run the command based on your access.
        2. Image Viewer / Media Loader (Virtual Proxy)
            Use Case:
                Designing a photo gallery or video platform where media files are heavy.
                Only load the image/video when the user actually views it.
        3. API Rate Limiting Gateway (Protection Proxy)
            Use Case:
                Limit the number of API calls per user/IP to prevent abuse.
        4. Caching data
            Use case:
                Get request for object or data can be optimized using caching 
        5. File System Management Tool
            Use Case:
                Manage file access based on user permissions, or show file previews.
        6. Authentication Service
            Use Case:
                An app that checks whether a user is authenticated before accessing core services.

# State Design pattern
    The State Design Pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes. It appears as if the object has changed its class.

    Real-World Analogy
        ATM Machine:
            An ATM behaves differently depending on whether:
                It's Out of Service
                It has No Card
                A card is Inserted
                It's Authorized
        Each of these is a state, and behavior like insertCard(), ejectCard(), withdraw() changes based on that state.

    LLD problems
        Order Processing System (e-Commerce)
            States:
                New, Packed, Shipped, Delivered, Cancelled

        ATM Machine
            States:
                NoCard, CardInserted, Authorized, OutOfService

        Authentication/Session State
            States:
                LoggedOut, LoggedIn, SessionExpired, Locked
        TV 
            states:
                on, off, channel changed
    Each state:
    Defines different access control behaviors.
    Defines valid transitions (e.g., session expiry moves from LoggedIn to SessionExpired).

# Composite design pattern
    Composite is a structural design pattern that lets you compose objects into tree structures and then work with these structures as if they were individual objects.

    Real-world Analogy
        Think of a file system:
            A File is a leaf node.
            A Directory is a composite that can contain files or other directories.
        Both implement the same interface like open(), getSize(), etc.
    
    LLD problems:
        File System Design	
            Files and Folders both implement a common interface (e.g. FileSystemComponent). Folders can contain files or other folders.
        UI Framework / GUI Builder	
            Buttons, Labels, TextFields (leaf components) and Panels, Windows (composite components) all inherit from a base UIComponent class.
        Menu & Submenu System	
            Menu and SubMenus all implement the same interface like render() or select(). A Menu can contain individual Items or more Menus.
        Organization Hierarchy	
            Employee and Manager both implement an Employee interface. Managers can have subordinates (other employees or managers).
        Access Control System	
            Permissions can be atomic (e.g., "read") or grouped into roles (e.g., "admin" includes read, write, delete).

# Adapter design pattern
    The Adapter Design Pattern is a structural design pattern that allows incompatible interfaces to work together. It acts like a bridge between two incompatible interfaces.

    Real-World Analogy:
        You're integrating a third-party payment gateway or logger (e.g., PayPal, Stripe, SLF4J), but their APIs don’t match your internal system's interface.
            interface PaymentProcessor {
                void pay(double amount);
            }
            class PayPalAPI {
                void makePayment(double dollars) { ... }
            }
            class PayPalAdapter implements PaymentProcessor {
                PayPalAPI payPal = new PayPalAPI();
                public void pay(double amount) {
                    payPal.makePayment(amount); // Adapts the API
                }
            }
        You're working with AWS, Azure, and GCP. Each has different APIs for storage, compute, etc.
        You write adapters to expose a common interface like CloudConnector.
    LLD problems:
        1. Notification Service (Email, SMS, WhatsApp)
            Problem: You want a unified interface to send notifications, but each provider (e.g., Twilio, SendGrid, WhatsApp API) has its own method signatures.
            Adapter Use:
                Define a NotificationService interface.
                Create adapters for each provider to conform to this interface.

        2. Payment Gateway Integration
            Problem: Support multiple payment services like Razorpay, Stripe, PhonePe, but all have different SDKs and APIs.
            Adapter Use:
                Define PaymentGateway interface.
                Implement StripeAdapter, RazorpayAdapter, etc.

        3. Cloud Connector Framework
            Problem: You want to write to AWS S3, Azure Blob, and GCP Storage through a single interface.
            Adapter Use:
                Define CloudStorage interface.
                Use S3Adapter, AzureBlobAdapter, etc.

        4. File Format Converter System
            Problem: Your file generator supports JSON → PDF, TXT, DOCX, but uses third-party libraries with different interfaces.
            Adapter Use:
                Create a FileConverter interface.
                Write adapters like PDFAdapter, DocxAdapter.

        5. Legacy Logger Adapter
            Problem: Your system uses SLF4J for logging, but an older module uses its own OldLogger.logThis().
            Adapter Use:
                Wrap OldLogger with an adapter that implements SLF4J’s interface.4

        6. Authentication Framework
            Problem: You want to support LDAP, OAuth, and JWT in a common interface.
            Adapter Use:
                Define AuthProvider interface.
                Implement OAuthAdapter, LDAPAdapter, etc.

# builder design pattern
    This is a creational design pattern which can be used to create objects
    Suppose a class has a lot of required objects and some optional objects, these required objects are needed in the costructor everytime and the optional ones are passed as null when not needed, this is not a good practice
    Instead of this we can set a static nested class Builder which can provide us argument creation with chaining, with this we can also use setter method to change the value but it also helps us in a case where argument needs to be created only once which we can achieve by creating argument inside builder and removing the setter method;

# Facade design pattern
    https://medium.com/@akshatsharma0610/facade-design-pattern-in-java-777005efc75f

    What is the Facade Design Pattern?
        The Facade pattern provides a simplified interface to a larger and more complex system of classes, libraries, or APIs.
        It's like putting a clean "front door" on a messy building full of rooms and switches. The user sees just one neat interface, even though lots of things are happening behind the scenes.

    Purpose
        Hide internal complexity
        Make code easier to use
        Promote loose coupling between subsystems
    
    When to Use
        When you want to provide a clean API for a complex subsystem
        When you're working with legacy code or third-party APIs
        When you want to decouple parts of your system
    
    example
        In a typical Spring application, the @RestController (or @Controller) layer acts like a facade to your service layer.
        I have implemented it a lot of times in creating RESTful web services so i don't need to program it.
        Client (frontend) → Controller (Facade) → Service Layer → Repository/DB

# Bridge design pattern
    https://medium.com/@andreaspoyias/design-patterns-a-quick-guide-to-bridge-pattern-9ebf6a77baed

    The Bridge design pattern is one of the classic Gang of Four (GoF) structural design patterns. It's especially useful when you want to separate abstraction from implementation, so they can evolve independently.
    The Bridge pattern is a structural design pattern that lets you split a large class or a closely related set of classes into two separate hierarchies — abstraction and implementation — which can be developed independently.
    The main goal: decouple abstraction from implementation.

    Without the Bridge pattern:
        You'll likely fall into the inheritance trap, adding new subclasses for every feature combo.
        Extensibility suffers. Want to add a new dimension? You need to change all shape classes.
        You lose modularity and SRP (Single Responsibility Principle).
        The abstraction (Shape) and implementation (Rendering) are tightly bound.

# Flyweight design pattern
    https://www.scaler.com/topics/design-patterns/flyweight-design-pattern/

    The Flyweight Design Pattern is a structural design pattern used to minimize memory usage by sharing as much data as possible with similar objects. It's particularly useful when you're dealing with a large number of objects that have some shared or common state.

    Key Idea:
        Separate intrinsic (shared) state from extrinsic (unique) state. Store intrinsic data in a shared object (flyweight), and pass extrinsic data when needed.

    Real-world Analogy:
        Think of a text editor. Each character in the document could be an object. But storing thousands of characters individually would be inefficient. Instead:
        The character 'a', 'b', 'c'… are flyweights (shared).
        Their position, font size, and color are extrinsic (passed in).

# Command design pattern
    https://refactoring.guru/design-patterns/command
    https://www.scaler.com/topics/design-patterns/command-design-pattern/

    The Command design pattern is a behavioral pattern that turns a request into a standalone object containing all the information about the request — such as what action to perform, on which object, and when.

    Intent:
    Encapsulate a request as an object, allowing you to parameterize clients with different requests, queue them, log them, and support undoable operations.

    Command design pattern should be used when the caller of an operation doesn't necessarily need to know how to perform the operation. Example: A button UI component doesn't need to know how to perform the operation when it is clicked.

    When to Use:
        You want to parameterize objects with operations.
        You need queueing, scheduling, or undo support.
        You want to decouple the sender from the receiver.

    Real-World Uses:
        GUI buttons triggering actions (e.g., copy, paste).
        Undo/redo systems in editors.
        Task queues (like command processors in game engines or job schedulers).

# Visitor design pattern
    Visitor pattern is used when we have to perform an operation on a group of similar kind of Objects. With the help of visitor pattern, we can move the operational logic from the objects to another class.
    For example, think of a Shopping cart where we can add different type of items (Elements). When we click on checkout button, it calculates the total amount to be paid. Now we can have the calculation logic in item classes or we can move out this logic to another class using visitor pattern. Let’s implement this in our example of visitor pattern.

