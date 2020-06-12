package algorithms.graph.connectivity

class QuickUnion (val n: Int) {
    private val parent = (0 until n).toMutableList()
    private val size = MutableList(n){1}
    var components = n

    tailrec fun find (p: Int): Int = when(p){
        parent[p] -> p
        else -> find(parent[p])
    }

    fun connected (p: Int, q: Int): Boolean =
        find(p) == find(q)

    fun union (p: Int, q: Int) {
        val rootP = find(p)
        val rootQ = find(q)
        if (rootP != rootQ) {
            components--
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ
                size[rootQ] += size[rootP]
            } else {
                parent[rootQ] = rootP
                size[rootP] += size[rootQ]
            }
        }
    }
}