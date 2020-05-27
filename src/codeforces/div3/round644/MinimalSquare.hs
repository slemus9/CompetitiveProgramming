import Control.Monad (replicateM_)

getMinSquare [a, b] = side * side where
    side = max (2 * min a b) (max a b)

parseLine = fmap ((map read) . words) getLine

main =
    fmap read getLine >>= \t ->
    replicateM_ t (fmap getMinSquare parseLine >>= print)