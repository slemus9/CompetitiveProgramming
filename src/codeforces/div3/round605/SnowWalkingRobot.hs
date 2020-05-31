import Control.Monad (replicateM_)
import qualified Data.Map.Strict as M

solve :: String -> (Int, String)
solve xs = (d + r + u + l, ans) where
    counts = M.fromListWith (+) [(x, 1) | x <- xs]
    numDs = M.findWithDefault 0 'D' counts
    numRs = M.findWithDefault 0 'R' counts
    numUs = M.findWithDefault 0 'U' counts
    numLs = M.findWithDefault 0 'L' counts
    d' = min numDs numUs
    r' = min numRs numLs
    d = if d' > 0 && r' == 0 then 1 else d'
    r = if r' > 0 && d' == 0 then 1 else r'
    u = d
    l = r
    ans = replicate d 'D' ++ replicate r 'R' ++ replicate u 'U' ++ replicate l 'L'

main =
    read <$> getLine >>= \q ->
    replicateM_ q (
        solve <$> getLine >>= \(num, ans) -> 
        putStrLn $ show num ++ "\n" ++ ans
    )
