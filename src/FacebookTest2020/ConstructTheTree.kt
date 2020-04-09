package FacebookTest2020

object ConstructTheTree{

}

sealed class Tree<out T>{
    class Node<T>(val left: Tree<T>, val right: Tree<T>, val value: T): Tree<T>()
    class Leaf<T>(val value: T): Tree<T>()
    object Empty: Tree<Nothing>()
}