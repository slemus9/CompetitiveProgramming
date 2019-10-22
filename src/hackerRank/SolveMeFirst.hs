{-# LANGUAGE FlexibleInstances, UndecidableInstances, DuplicateRecordFields #-}

import Control.Monad
import qualified Data.List as List
import Data.List.Split
import Data.Set
import System.Environment
import System.IO

simpleArraySum :: [Int] -> Int
simpleArraySum ar = List.foldl (+) 0 ar

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

    arCount <- readLn :: IO Int

    arTemp <- getLine

    let ar = List.map (read :: String -> Int) . words $ arTemp

    let result = simpleArraySum ar

    hPutStrLn fptr $ show result

    hFlush fptr
    hClose fptr
