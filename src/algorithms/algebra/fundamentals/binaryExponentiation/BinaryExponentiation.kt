package algorithms.algebra.fundamentals

/**
 * a^n = 1 , if n = 0
 *     = (a^2)^(n/2) , if n is even
 *     = (a^2)^((n - 1)/2) if n is odd
 *
 */
fun binExpRec(a: Long, n: Long): Long {
    tailrec fun go(a: Long, n: Long, acc: Long): Long{
        if (a == 0.toLong()) return 0
        if (n == 0.toLong()) return 1
        if (n == 1.toLong()){
            return a * acc
        }
        if (n % 2 == 0.toLong())
            return go(a * a, n/2, acc)
        else
            return go(a * a, (n - 1)/2, a * acc)
    }
    return go(a, n, 1)
}

fun binExpIter(a: Long, n: Long): Long{

    if (a == 0.toLong()) return 1

    var x = a
    var y: Long = 1
    var count = n

    while (count > 1){

        if (count % 2 == 0.toLong()){
            count /= 2
        }else{
            y *= x
            count = (count - 1)/2
        }
        x *= x
    }

    return x * y
}

/**
 * If m is prime, we can compute a^(n mod (m - 1)) instead of
 * a^n
 *
 * Reminder: a * b = ((a mod m) * (b mod m)) mod m
 */
fun binExpMod(a: Long, n: Long, m: Long): Long{
    if (a == 0.toLong()) return 1

    var x = a
    var y: Long = 1
    var count = n

    while (count > 1){
        if (count % 2 == 0.toLong()) count /= 2
        else{
            y = (y * x) % m
            count = (count - 1)/2
        }
        x = (x * x) % m
    }

    return (x * y) % m
}

fun binExpMod1(a: Long, n: Long, m: Long): Long{
    tailrec fun go(a: Long, n: Long, acc: Long): Long{
        if (a == 0.toLong()) return 0
        if (n == 1.toLong()){
            return (a * acc) % m
        }
        if (n % 2 == 0.toLong())
            return go((a * a) % m, n/2, acc)
        else
            return go((a * a) % m, (n - 1)/2, (a * acc) % m)
    }
    return go(a, n, 1)

}

/**
 * a * b = 0 , if a = 0 || b = 0
 *       = 2 * (a/2) * b , if a is even
 *       = 2 * ((a-1)/2) * b + b , if a is odd
 *
 */
fun multRec(a: Long, b: Long): Long{
    tailrec fun go(a: Long, b: Long, acc: Long): Long{
        if (a == 0.toLong() || b == 0.toLong()) return 0
        if (a == 1.toLong()){
            return b + acc
        }
        if (a % 2 == 0.toLong())
            return go(a/2, b * 2, acc)
        else
            return go((a - 1)/2, b * 2, b + acc)
    }
    return go(a, b, 0)
}

/**
 * Reminder: (a + b) mod m = ((a mod m) + (b mod m)) mod m
 */
fun multMod(a: Long, b: Long, m: Long): Long{
    tailrec fun go(a: Long, b: Long, acc: Long): Long{
        if (a == 0.toLong() || b == 0.toLong()) return 0
        if (a == 1.toLong()){
            return (b + acc) % m
        }
        if (a % 2 == 0.toLong())
            return go(a/2, (b * 2) % m, acc)
        else
            return go((a - 1)/2, (b * 2) % m, (b + acc) % m)
    }
    return go(a, b, 0)
}

fun main(args: Array<String>) {
//    println(binExpRec(3, 13))
//    println(binExpRec(3, 10))
//    println(binExpRec(2, 12))
//    println(binExpRec(5, 14))
//    println(binExpRec(6, 8))
//    println(binExpRec(2, 21))
//    println(binExpIter(2, 21))
//    println(binExpMod(2, 5, 13))
//    println(binExpMod(3, 10, 5))
//    println(binExpMod(2, 21, 11))
    println(binExpMod1(2, 5, 13))
    println(binExpMod1(3, 10, 5))
    println(binExpMod1(2, 21, 11))
    println(binExpMod1(3, 31, 16))
    println(multRec(17, 25))
    println(multRec(5, 81))
    println(multRec(765, 88))
    println(multRec(88, 765))
    println(multMod(10123465234878998, 65746311545646431, 10005412336548794))
    println(binExpRec(31, 0))
}