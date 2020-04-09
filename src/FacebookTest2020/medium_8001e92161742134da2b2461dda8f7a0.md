# Types - Medium

## Summary

You are developing a type system for a simple programming language, called *Lang*.  Here is an
example program:

```
(type even (int -> bool))
(type odd  (int -> bool))

(func (even n) (if (= n 0) true  (odd  (- n 1))))
(func (odd n)  (if (= n 0) false (even (- n 1))))

(type fib (int -> int))
(type helper (int int int -> int))

(func (fib n) (helper 0 1 (+ n 1)))
(func (helper n a b) (if (= n 0) a (helper (- n 1) a (+ a b))))
```

*Lang* has the following types:

* `int`, representing the integers (..., `-1`, `0`, `1`, `2`, etc),
* `bool` for booleans (`true` and `false`).
* `(P1 P2 ... PN -> R)` for any types `P1`, `P2`, ..., `PN` and `R`.  Representing a function
  taking `N` arguments, and returning a value of type `R`.

A *Lang* program consists of a sequence of statements, each on their own line (Empty lines are
ignored).  A statement can be one of the following:

* A `type` declaration, of the form `(type NAME TYPE)` which introduces a new variable, with the
  given name and type.
* A `func`tion definition, of the form `(func (NAME V1 V2 ... VN) BODY)` which supplies the
  implementation of a function previously declared with the given name.  `BODY` is an expression
  (explained below).  In a well-formed program, the function will have been declared with `N`
  parameters, whose names are given by `V1`, `V2`, ..., `VN` and the type of its body will match
  the return type in its declaration too.

Expressions in *Lang* are one of the following:

* An integer literal, like `-1`,  `0`, `1`, `2` etc.
* A variable name, which can refer to a parameter of the function the expression is defined in, or
  any function declared before the expression in the program.
* A conditional of the form `(if c a b)` which evaluates to `a` if `c` evaluates to `true` and
  evaluates to `b`  if `c` evaluates to `false`.
* A function call of the form `(f e1 e2 ... en)` where `f` is a variable name and `ei` is an
  expression for `1 <= i <= n`.

## Problem

We want to help *Lang* programmers make sure their programs are correct.  To this end, we want to
check that the **functions** they write **match the types** they have written. *Lang* programs can
have the following **type errors**:

* **Missing type declaration:** A function implementation whose type has not been declared earlier
  in the program.
* **Undefined identifier:** A variable name which is neither a parameter for the function
  containing it, nor a function whose type has been previously declared.
* **Definition arity mismatch:** The number of parameters in a function implementation's signature
  do not match the number of parameter types in its declaration.
* **Call arity mismatch:** The number of parameters passed in to a function at its call-site do not
  match the number of parameter types in its declaration.
* **Parameter type mismatch:** The type of the N-th parameter to a function at its call-site does
  not match the N-th parameter type in its declaration.
* **Return type mismatch:** The type of a function implementation's body does not match the return
  type in the function's declaration.
* **If condition mismatch:** A condition expression for an `if` statement which does not evaluate
  to a `bool`.

Note that *Lang* has the following built-in identifiers:

```
(type true  bool)
(type false bool)
(type +     (int int -> int))
(type -     (int int -> int))
(type =     (int int -> bool))
(type <     (int int -> bool))
```

Your input will be a *Lang* program.  Your output will be a sequence of responses each separated
from the next by a space.  There should be one response for **each function definition**, in the
order they are encountered in the program.  The response will be `Ok` if the function passes type
checking and `Err` if it contains one of the mentioned type errors.

### Example 1

#### Input

```
(type even (int -> bool))
(type odd  (int -> bool))

(func (even n) (if n true (odd (- n 1))))
(func (odd n) (if (= n 0) 0 (even (- n 1))))

(type fib (int -> int))
(type helper (int int int -> int))

(func (fib n) (helper 0 1 (+ n 1)))
(func (helper n a b) (if (= n 0) a (helper (- n 1) (+ a b))))
```

#### Output

```
Err Err Ok Err
```

#### Notes

* `even` contains an **if condition mismatch** because the condition evaluates to `int`.
* `odd` contains a **return type mismatch**, because its “then” branch returns an `int` but the
  function expects to return a `bool`.
* `fib` type checks fine, despite its `helper` function failing to type check
* `helper` contains a **call arity mismatch** in its recursive call.
