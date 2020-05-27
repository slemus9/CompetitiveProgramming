import Control.Monad (replicateM_)
import Data.Char (intToDigit)
import qualified Data.Set as Set

readLine :: IO [Int]
readLine = (map read) . words <$> getLine

isPossible :: [Int] -> Bool
isPossible [n, m, a, b] = n * a == m * b

buildRow :: Int -> (Int, Int) -> [Int] 
buildRow m (lo, hi) = [if inRange idx then 0 else 1 | idx <- [0..m-1]] where
    zeroIndices = Set.fromList [idx `mod` m | idx <- [lo..hi]]
    inRange idx = Set.member idx zeroIndices

buildMatrix :: [Int] -> [[Int]]
buildMatrix [n, m, a, b] = 
    snd $ foldr (\ idx (range, matrix) -> (newRange range, newMatrix idx range matrix)) ((0, m - a - 1), [[]]) [0..n-1] where
        newMatrix idx range matrix = buildRow m range : matrix
        newRange (lo, hi) = (hi + 1, hi + m - a)

printMatrix :: [[Int]] -> IO ()
printMatrix (xs: [[]]) = putStrLn (map intToDigit xs)
printMatrix (xs: xss) = putStrLn (map intToDigit xs) >> printMatrix xss

printAns :: [Int] -> IO ()
printAns sizes = 
    if not $ isPossible sizes then putStrLn "NO"
    else putStrLn "YES" >> printMatrix (buildMatrix sizes)

main =
    read <$> getLine >>= \t -> 
    replicateM_ t (readLine >>= printAns)