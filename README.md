# 🍰 Assignment 2 — Factory Method & Abstract Factory

##  Assignment Information

| **Item**       | **Information**                   |
|----------------| --------------------------------- |
| **Topic**      | Bakery Factory                    |
| **Group**      | SE-2514                           |
| **Student**    | Aruzhan Imanmadiyeva              |
| **Course**     | Software Design Patterns          |
| **Assignment** | #2                                |
| **Patterns**   | Factory Method & Abstract Factory |

---

#  1. Project Overview

This project demonstrates two **Creational Design Patterns**:

* **Factory Method**
* **Abstract Factory**

The project uses a **bakery system** as the main domain.

The **Factory Method** creates individual dessert products, while the **Abstract Factory** creates families of related bakery products for different occasions.

### Main Goal

The main goal is to demonstrate how objects can be created through factories instead of creating concrete products directly in the client code.

---

#  2. Part A — Factory Method

##  Product

The common product interface is:

**`Dessert`**

It defines the common `prepare()` method.

### Concrete Products

| Product   | Description          |
| --------- | -------------------- |
| `Cake`    | Represents a cake    |
| `Cupcake` | Represents a cupcake |

Both products implement the **`Dessert`** interface.

---

##  Creator

The abstract creator is:

**`DessertCreator`**

It declares the Factory Method:

**`createDessert()`**

### Concrete Creators

| Creator          | Creates   |
| ---------------- | --------- |
| `CakeCreator`    | `Cake`    |
| `CupcakeCreator` | `Cupcake` |

---

## Factory Method Structure

```text
                    DessertCreator
                         │
              ┌──────────┴──────────┐
              │                     │
        CakeCreator          CupcakeCreator
              │                     │
              ▼                     ▼
            Cake                 Cupcake
```

### How it works

The client works with the abstract `DessertCreator`.

The concrete creator decides which specific dessert will be created.

For example:

```java
DessertCreator creator = new CakeCreator();
Dessert dessert = creator.createDessert();
```

The client does not need to directly create the `Cake` object.

---

#  3. Part B — Abstract Factory

The **Abstract Factory** is used to create families of related bakery products.

The project contains two product types:

* **Cake**
* **Decoration**

And two product families:

*  **Birthday**
*  **Wedding**

---

##  Abstract Products

### `BakeryCake`

Common interface for all bakery cakes.

### `BakeryDecoration`

Common interface for all bakery decorations.

---

## 🎂 Birthday Product Family

The Birthday family contains:

* `BirthdayCake`
* `BirthdayDecoration`

```text
        BirthdayBakeryFactory
                 │
          ┌──────┴──────┐
          │             │
          ▼             ▼
    BirthdayCake   BirthdayDecoration
```

---

## 💍 Wedding Product Family

The Wedding family contains:

* `WeddingCake`
* `WeddingDecoration`

```text
         WeddingBakeryFactory
                 │
          ┌──────┴──────┐
          │             │
          ▼             ▼
      WeddingCake   WeddingDecoration
```

---

#  4. Abstract Factory Structure

The abstract factory is:

**`BakeryFactory`**

It provides two creation methods:

* `createCake()`
* `createDecoration()`

### Concrete Factories

| Factory                 | Product Family |
| ----------------------- | -------------- |
| `BirthdayBakeryFactory` | Birthday       |
| `WeddingBakeryFactory`  | Wedding        |

### Full Structure

```text
                         BakeryFactory
                              │
                 ┌────────────┴────────────┐
                 │                         │
     BirthdayBakeryFactory       WeddingBakeryFactory
                 │                         │
          ┌──────┴──────┐           ┌──────┴──────┐
          │             │           │             │
          ▼             ▼           ▼             ▼
   BirthdayCake   BirthdayDecoration   WeddingCake   WeddingDecoration
```

### How it works

One concrete factory creates a **complete and consistent family** of related products.

For example:

```java
BakeryFactory factory = new BirthdayBakeryFactory();

BakeryCake cake = factory.createCake();
BakeryDecoration decoration = factory.createDecoration();
```

The client works with the abstract interfaces and does not directly create `BirthdayCake` or `BirthdayDecoration`.

---

#  5. Client

The client is the **`Main`** class.

The client works with:

* `Dessert`
* `DessertCreator`
* `BakeryFactory`
* `BakeryCake`
* `BakeryDecoration`

The client does **not** directly create concrete bakery products.

### Example

```java
BakeryFactory factory = new BirthdayBakeryFactory();

BakeryCake cake = factory.createCake();
BakeryDecoration decoration = factory.createDecoration();
```

This makes the client code independent from concrete product classes.

---

#  6. Clean Code Principles

The project follows **five Clean Code principles** required by the assignment.

## 6.1 Meaningful Names

Class and method names clearly describe their purpose.

Examples:

* `BirthdayBakeryFactory`
* `WeddingBakeryFactory`
* `createCake()`
* `createDecoration()`

These names make the code easy to understand.

---

## 6.2 Small Methods

Methods perform one simple task.

For example:

```java
public BakeryCake createCake() {
    return new BirthdayCake();
}
```

The method has only one responsibility: creating a cake.

---

## 6.3 Focused Classes

Each class has a clear responsibility.

For example:

* `Cake` represents a cake product.
* `CakeCreator` creates a cake.
* `BirthdayBakeryFactory` creates Birthday products.

This keeps the classes simple and focused.

---

## 6.4 Consistent Formatting

The project uses consistent:

* indentation
* brackets
* naming
* method structure

All classes follow the same coding style.

---

## 6.5 No Magic Numbers or Strings

The project avoids unnecessary numbers and unclear values in the program logic.

Meaningful class and method names are used instead of unexplained values.

---

#  7. Project Structure

```text
BakeryFactory
│
├── README.md
│
└── src
    │
    ├── Dessert.java
    ├── Cake.java
    ├── Cupcake.java
    │
    ├── DessertCreator.java
    ├── CakeCreator.java
    ├── CupcakeCreator.java
    │
    ├── BakeryCake.java
    ├── BakeryDecoration.java
    │
    ├── BirthdayCake.java
    ├── BirthdayDecoration.java
    │
    ├── WeddingCake.java
    ├── WeddingDecoration.java
    │
    ├── BakeryFactory.java
    ├── BirthdayBakeryFactory.java
    ├── WeddingBakeryFactory.java
    │
    └── Main.java
```

---

#  8. Program Output

When the `Main` class is executed, the program demonstrates both design patterns.

```text
Preparing a cake
Preparing a cupcake

Making a birthday cake
Adding birthday decoration

Making a wedding cake
Adding wedding decoration
```

---


#  9. Conclusion

The project demonstrates how **Factory Method** and **Abstract Factory** can be used in a bakery system.

The **Factory Method** creates individual dessert products such as `Cake` and `Cupcake`.

The **Abstract Factory** creates related product families such as Birthday and Wedding bakery products.

The project also follows basic **Clean Code principles**, making the code simple, readable, and organized.
