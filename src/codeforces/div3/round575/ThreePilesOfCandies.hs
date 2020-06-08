import Control.Monad (replicateM_)

findAliceCandies :: [Integer] -> Integer
findAliceCandies xs = sum xs `div` 2

readCandies :: IO [Integer]
readCandies = (map read) . words <$> getLine

main =
    read <$> getLine >>= \q -> 
    replicateM_ q (readCandies >>= print . findAliceCandies)