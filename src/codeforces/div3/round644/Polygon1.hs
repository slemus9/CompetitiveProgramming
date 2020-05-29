import Control.Monad (replicateM, replicateM_)
import Data.Char

readInt :: IO Int
readInt = read <$> getLine

readLine :: IO [Int]
readLine = map digitToInt <$> getLine

readTable :: IO [[Int]]
readTable = 
    read <$> getLine >>= \n ->
    replicateM n readLine

checkMatrix :: [[Int]] -> Bool
checkMatrix m = not $ any (any invalid) (zipWith3 zip3 m ts t) where
    ts = map tail m
    t = tail m
    invalid (x, right, down) = x == 1 && right == 0 && down == 0

main =
    readInt >>= \t -> 
    replicateM_ t (
        readTable >>= \m ->
        putStrLn (
            if checkMatrix m then "YES"
            else "NO"
        )
    )