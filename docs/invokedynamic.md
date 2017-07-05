---
permalink: /dynamic
---
# Invoke Dynamic

Zum ersten Mal  seit Java 1.0 ist mit invokedynamic in Java 7 ein neuer Bytecode zur JVM hinzugefügt worden. Der Bytecode  ergänzt die bereits existierenden vier, namentlich invokevirtual (Instanz Methoden), invokestatic (Statische Methoden), invokeinterface (Aufruf über ein Interface) und invokespecial (z.B. Konstruktoren).

Mithilfe von  invokedynamic können dynamische Programmiersprachen, welche auf der JVM  basieren schneller laufen. Ein Zitat aus der Groovy Dokumentation:

Depending  on the JVM (even different minor versions of the JVM), you can target close to  Java performance for dynamic Groovy with invokedynamic support activated

Zudem sind  auch die Lambdas, welche in Java 8 eingeführt wurden, mit invokedynamic  implementiert (dazu später mehr).

Mit  invokedynamic wird bei der Ausführung eine Bootstrap-Methode aufgerufen. Diese  Bootstrap-Methode hat die folgende Syntax:

public static CallSite bootstrap(Lookup lookup, String name, MethodType  type)

Die CallSite, welche zurückgegeben wird, enthält einen  MethodHandle, welcher schlussendlich aufgerufen wird. Zwischen dem Aufruf der  Bootstrap-Methode und der Rückgabe der CallSite können beliebige Sachen  passieren. Die Bootstrap-Methode kann einfach eine passende Methode suchen,  oder sogar eine neue Methode implementieren (per Code Generation), für welche  dann ein Handle zurückgegeben wird.

Wie man sehen kann, wird der Bootstrap-Methode ein Lookup  Objekt übergeben. Dies ist auch neu und gehört zur Klasse MethodHandles. Mit  Lookup kann man Methoden auf einer Klasse suchen.

`findConstructor(Class<?> refc, MethodType type)`

Produces  a method handle which creates an object and initializes it, using the  constructor of the specified type.


`findGetter(Class<?> refc, String name, Class<?> type)`

Produces  a method handle giving read access to a non-static field.


`findSetter(Class<?> refc, String name, Class<?> type)`

Produces  a method handle giving write access to a non-static field.


`findSpecial(Class<?> refc, String name, MethodType type,  Class<?> specialCaller)`

Produces  an early-bound method handle for a virtual method.


`findStatic(Class<?> refc, String name, MethodType type)`

Produces  a method handle for a static method.


`findStaticGetter(Class<?> refc, String name, Class<?> type)`

Produces  a method handle giving read access to a static field.


`findStaticSetter(Class<?> refc, String name, Class<?> type)`

Produces  a method handle giving write access to a static field.


`findVirtual(Class<?> refc, String name, MethodType type)`

Produces  a method handle for a virtual method.


`unreflect(Method m)`

Makes a  direct method handle to m, if the lookup class has permission.


`unreflectConstructor(Constructor<?> c)`

Produces  a method handle for a reflected constructor.


`unreflectGetter(Field f)`

Produces  a method handle giving read access to a reflected field.


`unreflectSetter(Field f)`

Produces  a method handle giving write access to a reflected field.


`unreflectSpecial(Method m, Class<?> specialCaller)`

Produces  a method handle for a reflected method.


Der Vorteil von Lookup ist, dass die Zugriffsprüfung nur  beim Aufruf einer dieser Lookup-Methoden durchgeführt wird, was ein wichtiger  Unterschied zur Reflection/Method.invoke API ist, welche bei jedem Aufruf den  Zugriff überprüft. Die verschiedenen unreflect*  Methoden nehmen ein Objekt von Reflection und geben ein passendes MethodHandle  zurück, welches dann ebenfalls nicht mehr Zugriffsprüfungen durchführt.

## Lambdas

Wie bereits erwähnt wurden Lambdas ebenfalls mit  invokedynamic implementiert. Die Details dazu findet man in der Klasse java.lang.invoke.LambdaMetafactory.  Diese Klasse enthält die folgende Methode:


```java
public static CallSite  metafactory(
    MethodHandles.Lookup caller,
    String invokedName,
    MethodType invokedType,
    MethodType samMethodType,
    MethodHandle implMethod,
    MethodType instantiatedMethodType
)
```

Wenn man genau hinschaut, erkennt man in den ersten drei  Argumenten die Signatur einer Bootstrap-Methode, was sie auch ist. Wenn man im  Code ein Lambda verwendet, wird ein invokedynamic zu dieser Bootstrap-Methode  kompiliert.

In dieser Methode erfolgt erst die Implementation des  Lambdas, zur Laufzeit! In Java 8 erfolgt dies mithilfe der Klasse InnerClassLambdaMetafactory, welche  mithilfe von ASM (eine Bytecode-Manipulation Library) zur Laufzeit eine  Implementation generiert und eine CallSite für diese neue Implementation  zurückgibt.

Der Vorteil davon ist, dass die Implementationsstrategie  von Lambdas später einfach ausgetauscht werden kann. Wenn eine neue JVM Version  eine neue LambdaMetafactory mitbringt, werden plötzlich alle  Lambda-Implementationen durch diese neue Version abgehandelt. Dies ist sehr  clever und ermöglicht eine gute Rückwärtskompatibilität, wobei trotzdem von  neuen Sprachfeatures profitiert werden kann.