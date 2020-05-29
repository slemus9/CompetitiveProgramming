import Control.Monad (replicateM_, replicateM)
import Data.Bits
import qualified Data.Sequence as S
import Data.Sequence ((<|), (|>))
import Data.Foldable (toList)

type Str = S.Seq Char

readInt :: IO Int
readInt = read <$> getLine

readStrings :: Int -> IO [Str]
readStrings n = replicateM n (S.fromList <$> getLine)

pow2Of :: Int -> Integer
pow2Of = shiftL 1

getMatchingPrefixes :: Int -> Str -> [Str] -> Int
getMatchingPrefixes prefSize pref = length . filter (==pref) . map (S.take prefSize)

getAllowed :: Int -> Int -> Str -> [Str] -> Integer
getAllowed m prefSize pref xss = 
    pow2Of (m - prefSize) - toInteger (getMatchingPrefixes prefSize pref xss)

getMedian :: Int -> Int -> [Str] -> Str
getMedian n m xss = go medianPos S.empty [1..m] where
    medianPos = (pow2Of m - (toInteger n) + 1) `div` 2
    go _ _ [] = S.empty
    go searchSize pref (prefSize : xs) = bit <| go newSearchSize (pref |> bit) xs where
        allowedNumStrings = getAllowed m prefSize (pref |> '0') xss
        bit = 
            if searchSize <= allowedNumStrings then '0'
            else '1'
        newSearchSize = 
            if searchSize <= allowedNumStrings then searchSize
            else searchSize - allowedNumStrings

main = 
    readInt >>= \t ->
    replicateM_ t (
        (map read) . words <$> getLine >>= \[n, m] ->
        readStrings n >>= \xss ->
        putStrLn $ toList $ getMedian n m xss
    )