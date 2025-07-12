# Low-level-design

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

💡 Key Idea:
        Separate intrinsic (shared) state from extrinsic (unique) state. Store intrinsic data in a shared object (flyweight), and pass extrinsic data when needed.

    🧵 Real-world Analogy:
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

