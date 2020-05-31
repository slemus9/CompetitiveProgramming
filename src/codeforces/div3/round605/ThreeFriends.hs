import Control.Monad (replicateM_)
import Data.List (sort)

findMin :: [Int] -> Int
findMin xs = max 0 (2*(mx - mn - 2)) where
    [mn, mid, mx] = sort xs

readLine :: IO [Int]
readLine = (map read) . words <$> getLine

main =
    read <$> getLine >>= \q ->
    replicateM_ q (findMin <$> readLine >>= print)