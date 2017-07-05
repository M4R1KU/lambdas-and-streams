---
permalink: /lambdas
---

# Java Lambdas

Mit der achten Version hat Java eines der besten, wenn nicht das Beste Update seit dem Beginn der Sprache erhalten.
Features wie die Stream API, NIO oder auch die neue DateTime API sind die Highlights. Zu den grossen neuen Features gehören auch die Lambdas bzw. Lambda Ausdrücke.

## Was heisst Lambda?

Lambda ist der elfte Buchstabe des griechischen Alphabets und sieht so aus (klein/gross)"**λΛ**".
Ein Lambda bzw. der Buchstabe Lambda hat nach dem Englischsprachigen Wikipedia insgesamt ungefähr 49 Bedeutungen in Themengebieten wie Mathematik, Physik und angewandten Wissenschaften.
Zu den 49 Bedeutungen gehören auch das Auto von Lancia oder das Logo vom Videospiel Half-Life.
Was uns im Java Kontext interessiert ist die Bedeutung von Lambda Kalkül.
Lambda-Kalkül ist ein Konzept für anonyme Funktionen und tauchte allererstens in den 1930er Jahren bei den Mathematikern Alonzo Church und Stephen Cole Kleene auf.

## Was ist ein Lambda Ausdruck?
Ein Lambda Ausdruck ist nichts anderes als eine anonyme Funktion.
In Java ist ein Lambda Ausdruck eigentlich die syntaktisch verkürzte Version einer Implementation eines Interfaces mit **nur einer** abstrakten Methode.

Ein Lambda Ausdruck kann wie ein Normales Objekt behandelt werden. Somit ist es möglich ein Lambda in einer Variable zu speichern, einer anderen Methode zu übergeben oder von einer Methode als Rückgabewert zu erhalten.

Lambda Ausdrücke ermöglichen es endlich in Java Funktional zu programmieren ohne hässliche anonyme Klassen.edited

## Syntax
Da Lambdas zum Teil auch das Ziel haben, den Code übersichtlicher, lesbarer und schöner zu machen haben sie auch eine eine relativ kurze Syntax und es gibt mehrere Optionale Teile, welche bei bestimmten Konditionen weggelassen werden können.

Lambda mit allen Optionalen Teilen

`Function<String, File> fileF = (String path) -> { return new File(path); };`

Vereinfacht

`Function<String, File> fileF = path -> new File(path);`

Als Method Reference

`Function<String, File> fileF = File::new;`

## Typen
Wie bei einer normalen Funktion müssen die Parametertypen und der Rückgabetype spezifiziert werden. Doch wie man sieht hat die vereinfachte Form des Lambdas keine Typinformationen. Wie bekommt der Compiler nun die Informationen über die Typen, um das Typechecking durchzuführen?

Die Antwort auf diese Frage lautet: Kontext.
Ein Lambda ist wie schon erwähnt die anonyme Implementation eines Interfaces mit nur einer abstrakten Methode. Und die Deklaration der abstrakten Methode gibt alles vor was es braucht, um die Typen des Lambdas zu definieren.

Das Function Interface, welches oben verwendet wird kommt aus dem JDK und gehört zu einer Menge Standard Functional Interfaces welche im `java.util.function` package sind.
Das Interface sieht etwa so aus:

```java
@FunctionalInterface
public interface Function<T, R> {
  R apply(T t);
}
```

Wie man im Beispiel sieht werden die Typen durch die Generics definiert.

## Functional Interface

Um ein Lambdatyp zu definieren wird ein FunctionalInterface benötigt. Jedes Interface ist ein FunctionalInterface, wenn es nur eine abstrakte Methode hat. Somit sind auch Javas `Runnable` oder auch Springs `TransactionCallback` obwohl das letztere keine `@FunctionalInterface` Annotation hat, wie `Function<T, R>` im Beispiel.
Daraus folgt, dass die Annonation Optional ist. Das einzige was die Annoation macht ist beim Compilen zu überprüfen, dass wirklich nur eine abstrakte Methode vorhanden ist. Sonst hat sie keine weitere Funktion.

Die Annotation ist Optional, weil mn gewollt hatte, dass man noch alte Libraries verwenden kann aber trotzdem auch Lambdas im Zusammenhang mit diesen Libraries.

## Variable Scoping

Von Lambdas aus können alle Variablen im umgebenden Kontext angesprochen werden mit der Bedingung, dass sie Effectively Final sind. Dies bedeutet, dass sie nicht bedingt als Final deklariert werden müssen sondern einfach nie geändert werden dürfen.

```java
int x = 100;
IntUnaryOperator op = y -> y * x;
int result = op.applyAsInt(10); // 1000
```

```java
int x = 100;
IntUnaryOperator op = y -> y * x;
x = 10;
int result = op.applyAsInt(10); // Error: local variable used in lambda must be final or effectively final
```

Dies hat der Grund, dass so komische Sideeffects durch wechselnden Kontext verhindert werden sollen.

Aus einem Lambda hat man auch Zugriff auf den `this` Kontext und kann so innerhalb einer Klasse agieren.

## Method References

Method References bieten die Möglichkeit bestehende Methoden zu nutzen anstatt Lambda Ausdrücke zu verwenden. Die bestehenden Methoden müssen natürlich mit dem entsprechenden FunctionalInterface kompatibel sein.
Method References bestehen aus zwei Teilen, welche mit Doppelpunkt getrennt werden. Der erste Teil ist die Klasse oder die Instanz wo die Referenz hinzeigt. Der zweite Teil ist der Name der Methode **ohne** Klammern und Parameter.
Bsp: `File::new` 

## Arten von Method References

1. **Static Method Reference**
   Referenz zu einer satischen Methode einer Klasse.

   ```java
   List<String> names = asList("Frank", "John", "Harold");
   names.forEach(System.out::println);
   ```

2. **Method Reference to Object**
   Referenz auf eine Methode eines spezifischen Objekts

   ```java
   Person person = new Person("John", "Reese");
   Supplier<String> fullNameSupplier = person::getFullName;
   String fName = fullNameSupplier.get();
   ```

3. **Reference to an instance method of an arbitrary object of a particular type**
   Referenz auf eine Methode eines Objektes eines bestimmten Typs. Die Instanz wird, dann als erster Parameter übergeben.

   ```java
   Person person = new Person("John", "Reese");
   Function<Person, String> getFullName = Person::getFullName;
   System.out.println(getFullName.apply(person));
   ```

4. **Constructor Reference**
   Referenz zu einem Konstruktor einer Klasse.

   ```java
   class Person {
       public Person(String firstName, String secondName) {
           ...
       }
   }

   BiFunction<String, String, Person> personConst = Person::new;
   Person p = personFunction.apply("Doris", "Leuthard");
   ```