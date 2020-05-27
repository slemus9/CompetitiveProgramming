import Control.Monad (replicateM_)
import Data.List (sort)

maxInt = maxBound :: Int

minAbsDiff z (x, y) = min z $ abs (x - y)

readLine = read <$> getLine

getMinDiff xs = 
    foldl minAbsDiff maxInt pairs
    where 
        ys = sort xs
        pairs = zip ys (tail ys)

getAthletes =
    readLine >> (map read) . words <$> getLine

main =
    readLine >>= \t ->
    replicateM_ t (getMinDiff <$> getAthletes >>= print)