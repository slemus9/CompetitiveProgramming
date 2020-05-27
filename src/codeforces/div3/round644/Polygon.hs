import Control.Monad (replicateM, replicateM_)
import Data.Array
import Data.Char

readInt :: IO Int
readInt = read <$> getLine

readLine :: IO [Int]
readLine = map digitToInt <$> getLine

getDimensions :: Array (Int, Int) Int -> (Int, Int)
getDimensions = (snd . bounds)

readTable :: IO [[Int]]
readTable = 
    read <$> getLine >>= \n ->
    replicateM n readLine

addIndices :: [[Int]] -> [((Int, Int), Int)]
addIndices xss = [((i, j), x) | (i, xs) <- zip [0..] xss, 
                                (j, x)  <- zip [0..] xs]

matrixFromList :: [[Int]] -> Array (Int, Int) Int
matrixFromList xss = 
    array ((0, 0), (n, m)) (addIndices xss)
    where
        (n, m) = (length xss - 1, (length . head) xss - 1)

isCellValid :: (Int, Int) -> Array (Int, Int) Int -> Bool
isCellValid (i, j) matrix =
    matrix ! (i, j) == 0 ||
    i == n  || j == m || 
    matrix ! (i, j + 1) == 1 ||
    matrix ! (i + 1, j) == 1
    where
        (n, m) = getDimensions matrix

checkMatrix :: Array (Int, Int) Int -> String
checkMatrix matrix = if valid then "YES" else "NO" where 
    valid = all (\ idx -> isCellValid idx matrix) (indices matrix)

main = 
    readInt >>= \t ->
    replicateM_ t (
        readTable >>= \table ->
        putStrLn $ (checkMatrix . matrixFromList) table
    )