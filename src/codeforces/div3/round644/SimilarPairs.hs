import Control.Monad (replicateM_)
import qualified Data.Set as Set

readLine :: IO [Integer]
readLine = getLine >> (map read) . words <$> getLine

isPartitionPossible xs = 
    if numEven == 0 || numOdd == 0 || even numEven then "YES"
    else if any (\x -> Set.member (x + 1) evenSet || Set.member (x - 1) evenSet) odds then "YES"
    else "NO"
    where
        evens = filter even xs
        odds = filter odd xs
        numEven = length evens
        numOdd = length odds
        evenSet = Set.fromList evens

main =
    read <$> getLine >>= \t ->
    replicateM_ t (isPartitionPossible <$> readLine >>= putStrLn)