import Control.Monad
import Data.Array
import Data.Bits
import Data.List
import Data.List.Split
import Data.Set
import Debug.Trace
import System.Environment
import System.IO
import System.IO.Unsafe

diagonalDiff :: [[Int]] -> Int -> Int -> Int
diagonalDiff [] _ _ = 0
diagonalDiff (xs: ts) i j = (xs !! i) - (xs !! j) + (diagonalDiff ts (i + 1) (j - 1))

readMultipleLinesAsStringArray :: Int -> IO [String]
readMultipleLinesAsStringArray 0 = return []
readMultipleLinesAsStringArray n = do
    line <- getLine
    rest <- readMultipleLinesAsStringArray(n - 1)
    return (line : rest)

main :: IO()
main = do
    stdout <- getEnv "OUTPUT_PATH"
    fptr <- openFile stdout WriteMode

    n <- readLn :: IO Int

    arrTemp <- readMultipleLinesAsStringArray n
    let arr = Data.List.map (\x -> Data.List.map (read :: String -> Int) . words $ x) arrTemp

    let result = abs $ diagonalDiff arr 0 (n-1)

    hPutStrLn fptr $ show result

    hFlush fptr
    hClose fptr
